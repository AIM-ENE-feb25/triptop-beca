# ADR 001 - Betaling API

**Datum:** 21-03-2025

## Status

Geaccepteerd

## Context

Tijdens het maken van de context diagram werd er gedacht door het team of er een aparte Betaling API (Bijvoorbeeld Stripe) nodig is om de betalingen bij te houden, omdat er andere API's zijn zoals de Booking COM API en Uber Eats API, waarmee samengewerkt kan worden om betalingen te maken.

## Alternatieven

| Criteria                                | Betaling API (Bijv. Stripe) | Externe API's (Booking COM en Uber Eats) |
| --------------------------------------- | --------------------------- | ---------------------------------------- |
| Implementatiecomplexiteit               | - (Hoog)                    | + (Laag)                                 |
| Afhankelijkheid van andere partijen     | + (Beperkt)                 | - (Hoog)                                 |
| Kosten                                  | - (Kan hoog zijn)           | + (Inbegrepen)                           |
| Ondersteuning voor affiliate betalingen | - (Niet standaard)          | + (Ja)                                   |

## Beslissing

Er is besloten om geen aparte Betaling API te integreren, omdat de voordelen van een aparte Betaling API voor dit domein niet nodig zijn. In plaats daarvan wordt er gewerkt met affiliate programma's van de bestaande API's zoals Uber Eats en Booking COM, om de betaling door te voeren en er een deel naar de makers gaat.

## Consequencies

### Voordelen:

- **Minder ontwikkelcomplexiteit:** Er is geen extra API die moet worden geïntegreerd en beheerd.
- **Snellere implementatie:** Er kan direct gebruikt gemaakt worden van de betalingsfunctionaliteiten van externe API's.

### Nadelen:

- **Verspreide betalingsinformatie:** Betalingsgegevens zijn niet gecentraliseerd, wat het lastiger maakt om de betaling services te beheren.
- **Afhankelijkheid van externe API's:** Er is vertrouwen op de betrouwbaarheid en consistentie van verschillende externe systemen.
- **Mogelijke beperkingen:** Niet alle externe API's bieden dezelfde betalingsopties of flexibiliteit als een dedicated Betaling API.
