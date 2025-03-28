# ADR 004 - API Gateway

**Datum:** 21-03-2025

## Status

Voorstel

## Context

Onze applicatie maakt gebruik van meerdere externe API’s, die verschillende services aanbieden. Om deze API’s efficiënt te beheren en beveiligen, willen we een centrale oplossing inzetten. Een API Gateway biedt één ingang voor alle inkomende API-aanvragen en vereenvoudigt het toevoegen van authenticatie en andere beveiligingsmaatregelen. Hierdoor verminderen we de complexiteit, omdat we beveiliging, monitoring en onderhoud op één plek kunnen regelen.

## Alternatieven

We hebben de volgende opties onderzocht:

| Criteria         | API Gateway                                                                 | Geen API Gateway                                                                                                         |
|-----------------|-----------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------|
| **Beheer**      | (+) Centraal beheer van alle API-aanvragen.                                | (-) Beheer moet individueel per API worden geregeld.                                                                    |
| **Beveiliging** | (+) Centrale implementatie van authenticatie en autorisatie.              | (-) Beveiliging moet per API worden geïmplementeerd, wat kan leiden tot inconsistenties.                                |
| **Foutgevoeligheid** | (-) Een enkele fout in de API Gateway kan impact hebben op alle API’s. | (+) Een fout in een specifieke API heeft alleen gevolgen voor die API en niet voor de rest van het systeem.             |
| **Implementatietijd** | (-) Vereist tijd voor configuratie en integratie van alle API’s.     | (+) Geen centrale implementatie nodig, alleen losse configuratie per API.                                              |

## Beslissing

We kiezen voor de implementatie van een API Gateway als centraal punt voor het beheren, beveiligen en monitoren van externe API’s.

Deze keuze helpt ons om de complexiteit van API-beheer te verminderen en zorgt voor een consistente beveiligingsaanpak. Daarnaast biedt de API Gateway betere monitoringmogelijkheden en vereenvoudigt het onderhoud, wat leidt tot een robuustere infrastructuur.

## Consequenties

### Voordelen:

- **Centraal beheer:** Alle API-aanvragen verlopen via één plek, wat het beheer eenvoudiger maakt.
- **Verbeterde beveiliging:** We implementeren authenticatie en autorisatie op één centrale locatie.
- **Monitoring en logging:** De API Gateway verzamelt statistieken en logs van alle API-aanroepen, wat helpt bij foutopsporing en prestatieanalyse.
- **Afgeschermde interne systemen:** Wijzigingen in externe API’s kunnen worden opgevangen zonder impact op de interne architectuur.

### Nadelen:

- **Single Point of Failure:** Als de API Gateway faalt, heeft dit impact op alle externe API’s.
- **Implementatie-inspanning:** Het opzetten en configureren van de API Gateway kost tijd en vereist onderhoud.  
