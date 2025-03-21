# ADR 004 - API Gateway

**Datum:** 2025-03-21

## Status

Geaccepteerd

## Context
Onze applicatie maakt gebruik van meerdere externe API’s. Om het beheer en het gebruik van deze API’s te ordenen, hebben we een API Gateway nodig.

## Beslissing
Er is besloten om RapidAPI te gebruiken als onze API Gateway, omdat het een oplossing biedt voor het beheren en monitoren van API’s zonder extra werk te hoeven verrichten.
Verder is RapidAPI een bekende API Gateway waarin API's envoudig beheerd worden via de Marketplace, wat handig is als we later nieuwe API’s willen toevoegen. Verder is er een subscription nodig waardoor we verzekerd zijn van een aantal requests.
Tot slot worden de API’s beschermd tegen ongeautoriseerde toegang met API-sleutels, wat ons een vorm van beveiliging biedt.

## Consequencies
✅ **Voordelen:**
- **Eenvoudig beheer:** API’s zijn overzichtelijk te beheren via de RapidAPI Marketplace.
- **Snelle integratie:** Minimaliseert configuratie en onderhoud.
- **Goede analytics:** Goed inzicht in API-gebruik en prestaties.
- **Beveiliging:** API’s worden beschermd tegen ongeautoriseerde toegang.

⚠️ **Nadelen & risico’s:**
- **Beperkte mogelijkheden:** Er zijn kosten voor als we een hoog verbruikslimiet hebben of premium features willen gebruiken.
