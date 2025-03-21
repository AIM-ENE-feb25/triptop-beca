# ADR 001 - Betaling API

**Datum:** 2025-03-21

## Status

Geaccepteerd

## Context

Tijdens het maken van de context diagram kwamen mijn groepsleden en ik erachter of we echt een Betaling API nodig hebben (Bijvoorbeeld Stripe) om de betalingen bij te houden, omdat we andere API's hebben zoals de Booking COM API en Uber Eats API, die waarschijnlijk betalingen kunnen afhandelen, waardoor we geen Betaling API nodig hebben.

## Alternatieven

| Criteria                                | Betaling API (Bijv. Stripe) | Externe API's (Booking COM en Uber Eats) |
| --------------------------------------- | --------------------------- | ---------------------------------------- |
| Implementatiecomplexiteit               | - (Hoog)                    | + (Laag)                                 |
| Afhankelijkheid van andere partijen     | + (Beperkt)                 | - (Hoog)                                 |
| Kosten                                  | - (Kan hoog zijn)           | + (Inbegrepen)                           |
| Ondersteuning voor affiliate betalingen | - (Niet standaard)          | + (Ja)                                   |

## Beslissing

We hebben besloten om geen aparte Betaling API te integreren, omdat we de voordelen van een aparte Betaling API niet nodig hebben. In plaats daarvan werken we met de affiliate programma's van de bestaande API's zoals Uber Eats en Booking COM, om de betaling door te voeren, maar ook onze deel krijgen.

## Consequencies

### Voordelen:

- **Minder ontwikkelcomplexiteit:** Er is geen extra API die moet worden geïntegreerd en beheerd.
- **Snellere implementatie:** We kunnen direct gebruikmaken van de betalingsfunctionaliteiten van externe API's.

### Nadelen:

- **Verspreide betalingsinformatie:** Betalingsgegevens zijn niet gecentraliseerd, wat het lastiger maakt om de betaling services te beheren.
- **Afhankelijkheid van externe API's:** We moeten vertrouwen op de betrouwbaarheid en consistentie van verschillende externe systemen.
- **Mogelijke beperkingen:** Niet alle externe API's bieden dezelfde betalingsopties of flexibiliteit als een dedicated Betaling API.
