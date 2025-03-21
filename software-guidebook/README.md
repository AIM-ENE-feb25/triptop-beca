# Software Guidebook Triptop

## 1. Introduction

Dit software guidebook geeft een overzicht van de Triptop-applicatie. Het bevat een samenvatting van het volgende:

1. De vereisten, beperkingen en principes.
1. De software-architectuur, met inbegrip van de technologiekeuzes op hoog niveau en de structuur van de software.
1. De ontwerp- en codebeslissingen die zijn genomen om de software te realiseren.
1. De architectuur van de infrastructuur en hoe de software kan worden geinstalleerd.

## 2. Context

Context diagram van de Triptop applicatie:
![Afbeelding van Context diagram](./context-diagram-team.svg)

Dit diagram toont de omgeving waarin Triptop zich bevindt. Triptop is een online systeem, wat communiceert met verschillende externe systemen.

- Functionaliteit

De Triptop applicatie biedt reizigers de volgende mogelijkheden:

1. Reizigers kunnen zelf hun reis samenstellen door verschillende bouwstenen te combineren.

2. Reizigers kunnen zelf hun reis aanpassen, boeken, betalen en annuleren.

3. Reizigers kunnen hun reisstatus bewaren.

- Gebruikers

Het systeem heeft twee soorten gebruikers, namelijk:

> Reiziger

De reiziger is de primaire gebruiker van het systeem en heeft toegang tot bovenstaande functionaliteiten. De reiziger kan contact opnemen met de reisagent voor hulp bij vragen of problemen.

> Reisagent

De reisagent is een medewerker van Triptop die de reiziger ondersteunt bij het plannen en aanpassen van de reis. De reisagent biedt tweedelijns ondersteuning, door bijvoorbeeld vragen te beantwoorden of risico-inschattingen te maken.

- Externe systemen

De Triptop applicatie maakt gebruik van verschillende externe systemen. Er is gekozen om nog geen betalingsprovider toe te voegen, omdat er gebruik gemaakt zal worden van affiliate marketing. Dit wordt toegelicht in ADR-001.

## 3. Functional Overview

Om de belangrijkste features toe te lichten zijn er user stories en twee domain stories gemaakt en een overzicht van het domein in de vorm van een domeinmodel. Op deze plek staat typisch een user story map maar die ontbreekt in dit voorbeeld.

### 3.1 User Stories

#### 3.1.1 User Story 1: Reis plannen

Als gebruiker wil ik een zelfstandig op basis van diverse variabelen (bouwstenen) een reis kunnen plannen op basis van mijn reisvoorkeuren (wel/niet duurzaam reizen, budget/prijsklasse, 's nachts reizen of overdag etc.) zodat ik op vakantie kan gaan zonder dat hiervoor een reisbureau benodigd is.

#### 3.1.2 User Story 2: Reis boeken

Als gebruiker wil ik een geplande reis als geheel of per variabele (bouwsteen) boeken en betalen zodat ik op vakantie kan gaan zonder dat hiervoor een reisbureau benodigd is.

#### 3.1.3 User Story 3: Reis cancelen

Als gebruiker wil ik een geboekte reis, of delen daarvan, kunnen annuleren zodat ik mijn geld terug kan krijgen zonder inmenging van een intermediair zoals een reisbureau.

#### 3.1.4 User Story 4: Reisstatus bewaren

Als gebruiker wil ik mijn reisstatus kunnen bewaren zonder dat ik een extra account hoef aan te maken zodat ik mijn reis kan volgen zonder dat ik daarvoor extra handelingen moet verrichten.

#### 3.1.5 User Story 5: Bouwstenen flexibel uitbreiden

Als gebruiker wil ik de bouwstenen van mijn reis flexibel kunnen uitbreiden met een zelf te managen stap (bijv. met providers die niet standaard worden aangeboden zoals een andere reisorganisatie, hotelketen etc.) zodat ik mijn reis helemaal kan aanpassen aan mijn wensen.

### 3.2 Domain Story Reis Boeken (AS IS)

![Domain Story Reis Boeken AS IS](../opdracht-diagrammen/reis-boeken-asis-coursegrained_2024-06-11.egn.svg)

### 3.3 Domain Story Reis Boeken (TO BE)

![Domain Story Reis Boeken TO BE](../opdracht-diagrammen/reis-boeken-tobe-coursegrained_2024-06-11.egn.svg)

### 3.4 Domain Model

![Domain Model](../opdracht-diagrammen/Domain%20Model.png)

## 4. Quality Attributes

Voordat deze casusomschrijving tot stand kwam, heeft de opdrachtgever de volgende ISO 25010 kwaliteitsattributen benoemd als belangrijk:

- Compatibility -> Interoperability (Degree to which a system, product or component can exchange information with other products and mutually use the information that has been exchanged)
- Reliability -> Fault Tolerance (Degree to which a system or component operates as intended despite the presence of hardware or software faults)
- Maintainability -> Modularity (Degree to which a system or computer program is composed of discrete components such that a change to one component has minimal impact on other components)
- Maintainability -> Modifiability (Degree to which a product or system can be effectively and efficiently modified without introducing defects or degrading existing product quality)
- Security -> Integrity (Degree to which a system, product or component ensures that the state of its system and data are protected from unauthorized modification or deletion either by malicious action or computer error)
- Security -> Confidentiality (Degree to which a system, product or component ensures that data are accessible only to those authorized to have access)

## 5. Constraints

> [!IMPORTANT]
> Beschrijf zelf de beperkingen die op voorhand bekend zijn die invloed hebben op keuzes die wel of niet gemaakt kunnen of mogen worden.

## 6. Principles

> [!IMPORTANT]
> Beschrijf zelf de belangrijkste architecturele en design principes die zijn toegepast in de software.

## 7. Software Architecture

### 7.1. Containers

#### 7.1.1 Statische container diagram van de Triptop applicatie

![Afbeelding van statisch container diagram](./final-container-diagram.svg)

Dit diagram beschrijft de architectuur van de Triptop applicatie en de interacties tussen de verschillende bouwstenen. De gebruikers van de applicatie zijn de reiziger en de reisagent.

De applicatie is opgebouwd uit verschillende containers. De frontend applicatie, gebouwd met React.js en Vite, is de interface waar de reiziger zijn reis kan samenstellen, boeken, aanpassen, annuleren en betalen. De backend is ontwikkeld met Java en Spring Boot en beheert de logica van de applicatie. De backend ontvangt verzoeken van de frontend en communiceert met de database, waarin alle gegevens over gebruikers en reizen worden opgeslagen. Verder is er een API Gateway, die als poort fungeert tussen de backend en de externe systemen. Deze keuze wordt toegelicht in ADR-004.

Daarnaast maakt de applicatie gebruik van verschillende externe systemen via de API Gateway. De Booking COM API biedt informatie over accommodaties, vluchten, autohuur en attracties. De Uber Eats API toont restaurants. Via de WireMock API wordt de identiteit van de reiziger geverifieerd door middel van Single Sign-On (SSO). Tot slot biedt de Maps Data API informatie over locaties. Voor het prototype wordt gebruik gemaakt van de Maps Data API. De Google Maps API, die daadwerkelijk routes en kaarten levert, werkt met een betaald model en is niet geschikt voor ontwikkeling zonder kosten.

In het containerdiagram is het aantal externe providers lager ten opzichte van het contextdiagram. Dit komt doordat de Booking COM API als primaire provider wordt gebruikt voor meerdere bouwstenen. Deze keuze is gemaakt om het aantal integraties te verlagen en wordt toegelicht in ADR-002.

De frontend applicatie communiceert met de backend, die de benodigde gegevens uit de database haalt en de externe systemen via de API Gateway aanroept om aanvullende informatie op te halen of handelingen uit te voeren, zoals het boeken van tickets of het verifiëren van de identiteit van de reiziger.

#### 7.1.2 Dynamisch container diagram voor Inloggen scenario

![Afbeelding van dynamisch login container diagram](./login-diagram.svg)

Dit diagram beschrijft de dynamische architectuur van de Triptop applicatie tijdens het inloggen van een reiziger. De reiziger start de authenticatie door zijn inloggegevens in te voeren op de frontend applicatie, die ontwikkeld is met React.js en Vite. De frontend stuurt vervolgens een authenticatieverzoek naar de WireMock API. Als de verificatie succesvol is, ontvangt de frontend een token van de WireMock API.

Met deze token stuurt de frontend een validatieverzoek naar de backend, die ontwikkeld is met Java en Spring Boot. De backend controleert de token en haalt de bijbehorende gegevens op uit de database. Na het ophalen van de gegevens stuurt de backend het resultaat van de inlogpoging terug naar de frontend. Als alles correct is verlopen, wordt de reiziger ingelogd en krijgt hij/zij toegang tot de applicatie.

Dit diagram toont alleen de happy path. Edge cases zijn momenteel nog niet in de scope en worden later behandeld. 

#### 7.1.3 Dynamisch container diagram voor Reis boeken scenario

![Afbeelding van dynamisch reis boeken container diagram](./boeken-diagram.svg)

Dit diagram beschrijft de dynamische architectuur van de Triptop applicatie wanneer een reiziger een reis plant en boekt. De reiziger begint door een reis samen te stellen via de frontend applicatie, die ontwikkeld is met React.js en Vite. De frontend stuurt de ingevoerde reisgegevens door naar de backend, die ontwikkeld is met Java en Spring Boot.

De backend verwerkt deze gegevens en slaat de boeking op in de database. Zodra het opslaan van de data voltooid is, stuurt de backend een bevestiging terug naar de frontend. De frontend toont vervolgens de bevestiging aan de reiziger, die hiermee geïnformeerd wordt dat zijn/haar reis succesvol is geboekt.

Dit diagram toont alleen de happy path. Edge cases zijn momenteel nog niet in de scope en worden later behandeld. 

### 7.2. Components

> [!IMPORTANT]
> Voeg toe: Component Diagram plus een Dynamic Diagram van een aantal scenario's inclusief begeleidende tekst.

### 7.3. Design & Code

> [!IMPORTANT]
> Voeg toe: Per ontwerpvraag een Class Diagram plus een Sequence Diagram van een aantal scenario's inclusief begeleidende tekst.

## 8. Architectural Decision Records

> [!IMPORTANT]
> Voeg toe: 3 tot 5 ADR's die beslissingen beschrijven die zijn genomen tijdens het ontwerpen en bouwen van de software.

## 8.1 ADR 001 - Betaling API

**Datum:** 21-03-2025

### Status

Geaccepteerd

### Context

Tijdens het maken van de context diagram werd er gedacht door het team of er een aparte Betaling API (Bijvoorbeeld Stripe) nodig is om de betalingen bij te houden, omdat er andere API's zijn zoals de Booking COM API en Uber Eats API, waarmee samengewerkt kan worden om betalingen te maken.

### Alternatieven

| Criteria                                | Betaling API (Bijv. Stripe) | Externe API's (Booking COM en Uber Eats) |
| --------------------------------------- | --------------------------- | ---------------------------------------- |
| Implementatiecomplexiteit               | - (Hoog)                    | + (Laag)                                 |
| Afhankelijkheid van andere partijen     | + (Beperkt)                 | - (Hoog)                                 |
| Kosten                                  | - (Kan hoog zijn)           | + (Inbegrepen)                           |
| Ondersteuning voor affiliate betalingen | - (Niet standaard)          | + (Ja)                                   |

### Beslissing

Er is besloten om geen aparte Betaling API te integreren, omdat de voordelen van een aparte Betaling API voor dit domein niet nodig zijn. In plaats daarvan wordt er gewerkt met affiliate programma's van de bestaande API's zoals Uber Eats en Booking COM, om de betaling door te voeren en er een deel naar de makers gaat.

### Consequencies

#### Voordelen:

- **Minder ontwikkelcomplexiteit:** Er is geen extra API die moet worden geïntegreerd en beheerd.
- **Snellere implementatie:** Er kan direct gebruikt gemaakt worden van de betalingsfunctionaliteiten van externe API's.

#### Nadelen:

- **Verspreide betalingsinformatie:** Betalingsgegevens zijn niet gecentraliseerd, wat het lastiger maakt om de betaling services te beheren.
- **Afhankelijkheid van externe API's:** Er is vertrouwen op de betrouwbaarheid en consistentie van verschillende externe systemen.
- **Mogelijke beperkingen:** Niet alle externe API's bieden dezelfde betalingsopties of flexibiliteit als een dedicated Betaling API.

## 8.2 002. Booking COM API als primaire externe dataprovider

Datum: 21-03-2025

### Status

Geaccepteerd

### Context

In het contextdiagram is gekozen om verschillende externe providers weer te geven voor de verschillende bouwstenen van een reis. Er is weergegeven welke bouwstenen er nodig zijn en welke functionaliteit deze moeten leveren, met voorbeelden van welke providers er gebruikt zouden kunnen worden hiervoor. Dit geeft een volledig beeld van welke externe informatie nodig is voor het plannen van een reis.

Bij het maken van het containerdiagram werd duidelijk dat het grootste deel van de externe data uit de Booking COM API gehaald kon worden. Booking COM biedt namelijk niet alleen overnachtingen aan, maar ook aanvullende services zoals autoverhuur, vluchten en excursies.

Hierdoor ontstond de keuze tussen de Booking COM API als primaire API te gebruiken of verschillende API’s inzetten voor verschillende bouwstenen.

### Alternatieven

| Forces                                               | Verschillende API's gebruiken                       | Booking COM als primaire API                       |
| ---------------------------------------------------- | --------------------------------------------------- | -------------------------------------------------- |
| Afhankelijkheid van één partij                       | + (afhankelijkheden verdeeld)                       | - (afhankelijk van Booking COM)                    |
| Hoeveelheid integraties                              | - (meerdere providers)                              | + (alleen Booking COM)                             |
| Onderhoudslast                                       | - (verschillende API's controleren bij wijzigingen) | + (Alleen Booking COM controleren bij wijzigingen) |
| Flexibiliteit in aanbod                              | + (aanbod van verschillende providers )             | - (aanbod wat op Booking COM staat)                |
| Eenvoudiger afspraken maken over affiliate marketing | - (afspraken met meerdere bedrijven)                | + (alleen afspraken met Booking COM)               |

### Keuze

Er is gekozen om de Booking COM API als primaire externe databron te gebruiken voor het ophalen van informatie over overnachtingen, autoverhuur, vluchten en excursies.
Deze keuze is gemaakt omdat Booking COM een groot aantal diensten aanbiedt via één API, waardoor het aantal externe afhankelijkheden verminderd wordt, de technische implementatie eenvoudiger is, en er sneller ontwikkelt kan worden.

Later kan de applicatie nog uitgebreidt worden met andere externe providers, zoals een API die trein- of busreizen biedt. Naast de Booking API is er een aparte API voor eten en drinken (Uber Eats API) en voor routeplanning.

### Consequenties

Positieve consequenties:

- Lagere technische complexiteit door minder externe providers.
- Minder onderhoudslast omdat alleen de wijzigingen van Booking COM gecontroleerd moeten worden.
- Snellere ontwikkeltijd omdat er minder verschillende providers geimplementeerd moeten worden.
- Met één partij afspraken maken over affiliate marketing in plaats van met meerdere.

Negatieve consequenties/risico's:

- Grote afhankelijkheid van de Booking COM API. Bij problemen met deze API kunnen meerdere bouwstenen uitvallen.
- Minder flexibiliteit om specifieke aanbieders weer te geven die niet via Booking COM beschikbaar zijn.

Deze problemen zouden later opgelost kunnen worden door de applicatie uit te breiden met andere externe providers.

## 8.3 ADR 003 - API Development Tool

**Datum:** 21-03-2025

### Status

**Voorstel**

### Context

Voor het testen van de API calls worden er tussen de teamleden
verschillende software gebruikt. Er is besloten om één tool te
gaan gebruiken onderling, zodat er meer consistentie en efficiëntie is in de samenwerking.

### Alternatieven

| Criteria     | Postman                        | Insomnia                | Unirest            | HttpClient         |
| ------------ | ------------------------------ | ----------------------- | ------------------ | ------------------ |
| UI/UX        | + (Gebruiksvriendelijk)        | + (Minimalistisch)      | + (Code-gebaseerd) | + (Code-gebaseerd) |
| Samenwerking | + (Teamworkspaces, cloud sync) | - (Alleen lokaal)       | - (Alleen lokaal)  | - (Alleen lokaal)  |
| Platform     | + (Windows, Mac, Linux)        | + (Windows, Mac, Linux) | + (Java, Python)   | - (Java)           |

### Beslissing

Er is besloten om **Postman** als standaard API development tool te gebruiken,  
vanwege de brede ondersteuning, gebruiksvriendelijkheid en samenwerkingstools.

### Consequencies

✅ **Voordelen:**

- één tool binnen het team.
- Mogelijkheid om API-requests te delen en testen te automatiseren.
- Ondersteuning voor REST, GraphQL en andere API-types.

❌ **Nadelen:**

- De gekozen software is niet bij elk teamlid bekend,  
  waardoor er een leercurve is.
- Sommige geavanceerde features vereisen een betaald account.

## 8.4 ADR 004 - API Gateway

**Datum:** 21-03-2025

### Status

Geaccepteerd

### Context

Onze applicatie maakt gebruik van meerdere externe API’s. Deze API’s kunnen verschillende services. Het is belangrijk om deze API’s te beheren en beveiligen op een centrale plek, omdat dit het makkelijker maakt om authenticatie toe te voegen. Een API Gateway biedt een oplossing hiervoor door één punt te bieden voor alle inkomende API-aanvragen. Dit vermindert de complexiteit omdat er maar één plek is waar authenticatie en onderhoud uitgevoerd hoeft te worden.

### Alternatieven

| Forces           | API Gateway                                                                                           | Geen gebruik van API Gateway                                                                                                       |
| ---------------- | ----------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------- |
| Beheer           | (+) Biedt een centrale plek voor het beheren van alle API-aanvragen.                                  | (-) Beheer moet per API                                                                                                            |
| Beveiliging      | (+) Biedt een centrale plek om authenticatie en authorisatie te implementeren                         | (-) Beveiliging moet per API geïmplementeerd worden, wat voor inconsistentie kan zorgen                                            |
| Foutgevoeligheid | (-) Er is één plek voor fouten wat een risico kan veroorzaken voor de toegang tot alle externe API’s. | (+) Fouten kunnen voorkomen bij elke externe API, maar dit heeft alleen impact voor de desbetreffende API en niet voor de anderen. |
| Tijd             | (-) Implementatie kan tijdrovend zijn door de setup van de Gateway en configuraties voor alle API’s.  | (+) Geen grote implementatie, maar per API.                                                                                        |

### Beslissing

We hebben besloten om een API Gateway in onze infrastructuur te implementeren. Dit zal dienen als centraal punt voor het beheren, beveiligen en monitoren van de externe API’s die we gebruiken. De API Gateway biedt ons controle voor authenticatie en autorisatie.

Deze keuze is gemaakt omdat wij het een goede manier vonden om de complexiteit van het beheren van meerdere externe API’s te verminderen en de beveiliging en monitoring te verbeteren, omdat het kan leiden tot verspreide configuraties en inconsistenties.

### Consequencies

#### Voordelen:

- Centraal punt: Alle aanvragen voor de externe API’s gaan via één plek, waardoor het gemakkelijker wordt om deze API’s te beheren.
- Beveiliging: Het biedt een centraal punt voor het implementeren van beveiliging zoals authenticatie en autorisatie.
- Monitoring: Het maakt het makkelijk om statistieken en logs voor alle API-aanroepen te verzamelen, wat kan helpen bij foutopsporing.
- Beheer van externe API’s: Maakt het mogelijk om wijzigingen in de externe API’s door te voeren zonder dat dit invloed heeft op de interne systemen.

#### Nadelen:

- Eén punt voor fouten: De API Gateway wordt een belangrijk onderdeel van de infrastructuur en als deze problemen/bugs heeft, kan de toegang tot alle externe API’s onbruikbaar worden.
- Tijd: Het maken van de API Gateway kost tijd om te implementeren.

### 8.5. ADR-005 TITLE

> [!TIP]
> These documents have names that are short noun phrases. For example, "ADR 1: Deployment on Ruby on Rails 3.0.10" or "ADR 9: LDAP for Multitenant Integration". The whole ADR should be one or two pages long. We will write each ADR as if it is a conversation with a future developer. This requires good writing style, with full sentences organized into paragraphs. Bullets are acceptable only for visual style, not as an excuse for writing sentence fragments. (Bullets kill people, even PowerPoint bullets.)

#### Context

> [!TIP]
> This section describes the forces at play, including technological, political, social, and project local. These forces are probably in tension, and should be called out as such. The language in this section is value-neutral. It is simply describing facts about the problem we're facing and points out factors to take into account or to weigh when making the final decision.

#### Considered Options

> [!TIP]
> This section describes the options that were considered, and gives some indication as to why the chosen option was selected.

#### Decision

> [!TIP]
> This section describes our response to the forces/problem. It is stated in full sentences, with active voice. "We will …"

#### Status

> [!TIP]
> A decision may be "proposed" if the project stakeholders haven't agreed with it yet, or "accepted" once it is agreed. If a later ADR changes or reverses a decision, it may be marked as "deprecated" or "superseded" with a reference to its replacement.

#### Consequences

> [!TIP]
> This section describes the resulting context, after applying the decision. All consequences should be listed here, not just the "positive" ones. A particular decision may have positive, negative, and neutral consequences, but all of them affect the team and project in the future.

## 9. Deployment, Operation and Support

> [!TIP]
> Zelf beschrijven van wat je moet doen om de software te installeren en te kunnen runnen.
