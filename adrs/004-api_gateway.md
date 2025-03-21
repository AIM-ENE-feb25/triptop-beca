# ADR 004 - API Gateway

**Datum:** 2025-03-21

## Status

Geaccepteerd

## Context
Onze applicatie maakt gebruik van meerdere externe API’s. Deze API’s kunnen verschillende services. Het is belangrijk om deze API’s te beheren en beveiligen op een centrale plek. Een API Gateway biedt een oplossing hiervoor door één punt te bieden voor alle inkomende API-aanvragen. Dit vermindert de complexiteit en maakt het makkelijker om API’s te beheren.

## Alternatieven
| Forces           | API Gateway                                                                                       | Geen gebruik van API Gateway                                                                                                   |
|------------------|---------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------|
| Beheer           | Biedt een centrale plek voor het beheren van alle API-aanvragen.                                  | Beheer moet per API                                                                                                            |
| Beveiliging      | Biedt een centrale plek om authenticatie en authorisatie te implementeren                         | Beveiliging moet per API geïmplementeerd worden, wat voor inconsistentie kan zorgen                                            |
| Foutgevoeligheid | Er is één plek voor fouten wat een risico kan veroorzaken voor de toegang tot alle externe API’s. | Fouten kunnen voorkomen bij elke externe API, maar dit heeft alleen impact voor de desbetreffende API en niet voor de anderen. |
| Tijd             | Implementatie kan tijdrovend zijn door de setup van de Gateway en configuraties voor alle API’s.  | Geen grote implementatie, maar per API.                                                                                        |

## Beslissing
We hebben besloten  om een API Gateway in onze infrastructuur te implementeren. Dit zal dienen als centraal punt voor het beheren, beveiligen en monitoren van de externe API’s die we gebruiken. De API Gateway biedt ons controle voor authenticatie, en autorisatie.

Deze keuze is gemaakt omdat het een goede manier is om de complexiteit van het beheren van meerdere externe API’s te verminderen en de beveiliging en monitoring te verbeteren.

## Consequencies
### Voordelen:

- Centraal punt: Alle aanvragen voor de externe API’s gaan via één plek, waardoor het gemakkelijker wordt om deze API’s te beheren.
- Beveiliging: Het biedt een centraal punt voor het implementeren van beveiliging zoals authenticatie en autorisatie.
- Monitoring: Het maakt het makkelijk om statistieken en logs voor alle API-aanroepen te verzamelen, wat kan helpen bij foutopsporing.
- Beheer van externe API’s: Maakt het mogelijk om wijzigingen in de externe API’s door te voeren zonder dat dit invloed heeft op de interne systemen.

### Nadelen:

- Eén punt voor fouten: De API Gateway wordt een belangrijk onderdeel van de infrastructuur en als deze problemen/bugs heeft, kan de toegang tot alle externe API’s onbruikbaar worden.
- Tijd: Het maken van de API Gateway kost tijd om te implementeren.
