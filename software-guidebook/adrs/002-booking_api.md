# ADR 002 - Booking COM API als primaire externe dataprovider

**Datum:** 21-03-2025

## Status

Geaccepteerd

## Context

In het contextdiagram hebben wij gekozen om verschillende externe providers weer te geven voor de verschillende bouwstenen van een reis. We hebben weergegeven welke bouwstenen er nodig zijn en welke functionaliteit deze moeten leveren, met voorbeelden van welke providers we hiervoor zouden kunnen gebruiken. Dit geeft een volledig beeld van welke externe informatie nodig is voor het plannen van een reis.

Bij het maken van het containerdiagram werd duidelijk dat we het grootste deel van de externe data uit de Booking COM API konden halen. Booking COM biedt namelijk niet alleen overnachtingen aan, maar ook aanvullende services zoals autoverhuur, vluchten en excursies.

Hierdoor ontstond de keuze tussen de Booking COM API als primaire API te gebruiken of verschillende API’s inzetten voor verschillende bouwstenen.

## Alternatieven

| Forces                                               | Verschillende API's gebruiken                       | Booking COM als primaire API                       |
| ---------------------------------------------------- | --------------------------------------------------- | -------------------------------------------------- |
| Afhankelijkheid van één partij                       | + (afhankelijkheden verdeeld)                       | - (afhankelijk van Booking COM)                    |
| Hoeveelheid integraties                              | - (meerdere providers)                              | + (alleen Booking COM)                             |
| Onderhoudslast                                       | - (verschillende API's controleren bij wijzigingen) | + (alleen Booking COM controleren bij wijzigingen) |
| Flexibiliteit in aanbod                              | + (aanbod van verschillende providers )             | - (aanbod wat op Booking COM staat)                |
| Eenvoudiger afspraken maken over affiliate marketing | - (afspraken met meerdere bedrijven)                | + (alleen afspraken met Booking COM)               |

## Beslissing

We hebben gekozen om de Booking COM API als primaire externe databron te gebruiken voor het ophalen van informatie over overnachtingen, autoverhuur, vluchten en excursies.
We hebben deze keuze gemaakt omdat Booking COM een groot aantal diensten aanbiedt via één API. Hierdoor wordt het aantal externe afhankelijkheden verminderd, de technische implementatie eenvoudiger en kan er sneller ontwikkelt worden.

Later kunnen we deze applicatie nog uitbreiden met andere externe providers, zoals een API die trein- of busreizen aanbiedt. Naast de Booking COM API is er een aparte API voor eten en drinken (Uber Eats Scraper API) en voor routeplanning.

## Consequenties

### Voordelen

- Lagere technische complexiteit door minder externe providers.
- Minder onderhoudslast, omdat alleen de wijzigingen van Booking COM gecontroleerd moeten worden.
- Snellere ontwikkeling, omdat er minder verschillende providers geïmplementeerd hoeven worden.
- Met één partij afspraken maken over affiliate marketing in plaats van met meerdere partijen.

### Nadelen

- Grote afhankelijkheid van de Booking COM API. Bij problemen met deze API kunnen meerdere bouwstenen uitvallen.
- Minder flexibiliteit om specifieke aanbieders weer te geven die niet via Booking COM beschikbaar zijn.

Deze problemen zouden we later kunnen oplossen door de applicatie uit te breiden met andere externe providers.
