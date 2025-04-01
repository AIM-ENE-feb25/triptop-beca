# ADR 001 - Betaling API

**Datum:** 21-03-2025

## Status

Geaccepteerd

## Context

Tijdens het maken van het contextdiagram hebben wij als team overwogen of het nodig is om een aparte Betaling API (bijvoorbeeld Stripe) te integreren om betalingen bij te houden. Er zijn echter al bestaande API's, zoals de Booking.com API en de Uber Eats API, waarmee samengewerkt kan worden om betalingen af te handelen. Dit bracht ons tot de vraag of een aparte Betaling API toegevoegde waarde heeft binnen ons domein.

## Alternatieven

| Criteria                                    | Betaling API (Bijv. Stripe, PayPal, Mollie, Adyen)         | Externe API's (Booking.com en Uber Eats)                       |
| ------------------------------------------- | ---------------------------------------------------------- | -------------------------------------------------------------- |
| **Implementatiecomplexiteit**               | -- (Hoge complexiteit, extra ontwikkeling nodig)           | ++ (Lage complexiteit, direct gebruiksklaar)                   |
| **Afhankelijkheid van andere partijen**     | + (Beperkte afhankelijkheid, controle over betalingen)     | -- (Hoge afhankelijkheid van externe API's en hun voorwaarden) |
| **Kosten**                                  | -- (Kan hoog zijn, afhankelijk van transactievolume)       | ++ (Inbegrepen in de bestaande platforms)                      |
| **Ondersteuning voor affiliate betalingen** | - (Niet standaard, vereist maatwerk)                       | ++ (Volledige ondersteuning via affiliate-programma's)         |
| **Schaalbaarheid**                          | ++ (Schaalbaar en flexibel voor toekomstige uitbreidingen) | - (Beperkt door de mogelijkheden van externe API's)            |
| **Beheer van betalingsgegevens**            | ++ (Centrale opslag en controle)                           | - (Verspreide betalingsinformatie, lastiger beheer)            |

## Beslissing

Wij hebben besloten om geen aparte Betaling API te integreren, omdat de voordelen van een eigen betaaloplossing binnen ons domein niet opwegen tegen de nadelen. In plaats daarvan maken wij gebruik van de affiliate-programma’s van bestaande API’s zoals Uber Eats en Booking.com. Hierdoor kunnen wij betalingen afhandelen via deze externe systemen en profiteren van hun bestaande infrastructuur.

## Consequenties

### Voordelen:

- **Minder ontwikkelcomplexiteit:** Er is geen extra API die moet worden geïntegreerd en beheerd, wat tijd en middelen bespaart.
- **Snellere implementatie:** Wij kunnen direct gebruikmaken van de betalingsfunctionaliteiten van externe API's zonder extra ontwikkeling.
- **Lagere kosten:** Omdat wij de betaalinfrastructuur van partners gebruiken, vermijden wij extra kosten voor transactieverwerking en onderhoud.

### Nadelen:

- **Verspreide betalingsinformatie:** Omdat betalingen via verschillende platforms verlopen, is er geen centrale plek voor betalingsgegevens, wat beheer en rapportage kan bemoeilijken.
- **Afhankelijkheid van externe API’s:** Wij zijn afhankelijk van de betrouwbaarheid, beschikbaarheid en beleidswijzigingen van derden, wat risico's met zich meebrengt.
- **Mogelijke beperkingen in functionaliteit:** Niet alle externe API’s bieden dezelfde flexibiliteit en betalingsopties als een dedicated Betaling API, wat onze mogelijkheden kan beperken.

Door deze keuze kunnen wij onze focus leggen op onze kernfunctionaliteiten en een snellere time-to-market realiseren, terwijl wij tegelijkertijd profiteren van de bestaande infrastructuren van onze partners.
