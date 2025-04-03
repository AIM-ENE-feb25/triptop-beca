# ADR 006 - Hoe zorgen we ervoor dat we makkelijk een nieuwe externe service kunnen toevoegen?

**Datum:** 27-03-2025

## Status

Geaccepteerd

## Context

In dit project halen we data op via externe API’s van verschillende aanbieders, zoals Uber Eats en Booking.com. Deze externe services verschillen onderling in structuur, vereisten en aanroepwijze.

We willen flexibel blijven in het gebruik van deze services, zodat we eenvoudig kunnen wisselen van aanbieder als een externe service onvoldoende aanbod heeft of als we een nieuwe feature willen toevoegen.

Daarom zoeken we een structuur waarmee we eenvoudig een nieuwe externe service kunnen toevoegen of vervangen, zonder bestaande code te wijzigen. We willen een oplossing die onderhoudbaar en uitbreidbaar is, en waarbij de koppeling met specifieke aanbieders laag is.

## Alternatieven

| Forces                           | Directe koppeling met API-implementatieklasse (zonder interface) | Centrale API-gatewayklasse                           | Ports en Adapters                              |
| -------------------------------- | ---------------------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------- |
| Uitbreidbaarheid (OCP)           | - (Nieuwe aanbieder vereist wijziging service)                   | - (Nieuwe aanbieder vereist wijziging gatewayklasse. Kan bij veel externe API's erg onoverzichtelijk worden) | + (Nieuwe adapter toevoegen zonder wijzigingen in controller of service)                   |
| Herbruikbare structuur           | - (Geen gedeelde interface of abstractie)                        | - (Alles in één klasse, dus beperkt per aanbieder.)   | + (Via adapters en ports)                      |
| Afhankelijkheid                  | - (Service hangt direct af van concrete implementatieklasse)     | - (Service hangt af van gatewayklasse)               | + (Service hangt alleen af van port-interface) |
| Complexiteit                     | + (Gemakkelijk en snel te implementeren)                         | + (Gemakkelijk te begrijpen en beheren)              | - (Meer structuur nodig. Nieuwe teamleden zijn mogelijk niet bekend met hexagonale architectuur.)                       |
| Mogelijk om vaste aanroepstructuur af te dwingen voor bijv. inloggen (m.b.v. Template Method Pattern) | - (Service spreekt direct implementatieklassen aan) | - (Alle API aanroepen zitten in één klasse.) | + (Structuur van aanroep is te centraliseren in abstracte klasse naast de interface) |

## Beslissing

We hebben gekozen voor de Ports & Adapters architectuur (hexagonale architectuur). Services communiceren hierdoor niet rechtstreeks met specifieke klassen, maar maken gebruik van een port-interface die door externe adapters wordt geïmplementeerd. Iedere externe service (zoals Uber Eats of Booking.com) heeft zijn eigen adapter, die de interface van de bijbehorende bouwsteen implementeert.

Dit maakt het mogelijk om een nieuwe externe service toe te voegen zonder de bestaande code te wijzigen. De service hoeft alleen de interface te gebruiken. Dit sluit aan op het [Open/Closed Principle](../README.md#61-openclosed-principe) (OCP) en het [Dependency Inversion Principle](../README.md#62-dependency-inversion-principe) (DIP), waarbij je afhankelijk bent van abstracties in plaats van specifieke implementaties. 

Daarnaast is deze architectuur goed te combineren met het [Template Method Pattern](../README.md#732-class-diagram-toevoegen-van-een-nieuwe-externe-service). Hierdoor kan de structuur van het aanroepen van externe API's gegarandeerd worden. 

Voor meer informatie over de hexagonale architectuur, zie de volgende bronnen:

- Het artikel [Hexagonal architecture](https://alistair.cockburn.us/hexagonal-architecture/) van Alistair Cockburn beschrijft het orginele concept van de hexagonale architectuur.

- Het artikel [Organizing Layers Using Hexagonal Architecture, DDD, and Spring](https://www.baeldung.com/hexagonal-architecture-ddd-spring) van Baeldung geeft een praktische uitleg met voorbeelden in Java en Spring Boot.

## Consequenties

### Voordelen

- Voldoet aan OCP -> Externe services kunnen worden toegevoegd door een nieuwe adapter te implementeren, zonder dat bestaande code aangepast hoeft te worden.
- Voldoet aan DIP -> Service is losgekoppeld van specifieke implementaties, wat zorgt voor betere testbaarheid.
- Consistentie -> Consistentie in hoe externe API’s worden aangeroepen, omdat iedere adapter dezelfde interface gebruikt (per bouwsteen). Daarnaast kan het Template Method Pattern toegepast worden.
- Overzichtelijk -> Door voor iedere bouwsteen (zoals restaurants of hotels) een eigen interface te gebruiken, blijft de architectuur overzichtelijk.

### Nadelen

- Complexer -> Vereist meer werk en abstractie dan de andere alternatieven.
- Meer componenten nodig -> Er zijn extra componenten nodig door gebruik van ports en adapters.
