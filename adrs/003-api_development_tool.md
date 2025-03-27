# ADR 003 - API Development Tool

**Datum:** 21-03-2025

## Status

**Voorstel**

## Context

Voor het testen van de API calls worden er tussen de teamleden
verschillende software gebruikt. Er is besloten om één tool te
gaan gebruiken onderling, zodat er meer consistentie en efficiëntie is in de samenwerking.

## Alternatieven

| Criteria     | Postman                                                               | Insomnia                                                               | Unirest            | HttpClient         |
|--------------|-----------------------------------------------------------------------|------------------------------------------------------------------------|--------------------|--------------------|
| UI/UX        | + (Gebruiksvriendelijk)                                               | + (Minimalistisch)                                                     | + (Code-gebaseerd) | + (Code-gebaseerd) |
| Samenwerking | + (Teamworkspaces, cloud sync)                                        | - (Alleen lokaal)                                                      | - (Alleen lokaal)  | - (Alleen lokaal)  |
| Platform     | + (Windows, Mac, Linux)                                               | + (Windows, Mac, Linux)                                                | + (Java, Python)   | - (Java)           |
| Kosten       | - (Postman heeft betaalde features wat niet toegankelijk zijn gratis) | - (Insomnia heeft betaalde features wat niet toegankelijk zijn gratis) | + (Open-Source)    | + (Open-Source) |

## Beslissing

Er is besloten om **Postman** als standaard API development tool te gebruiken,  
vanwege de brede ondersteuning, gebruiksvriendelijkheid en samenwerkingstools.

## Consequencies
✅ **Voordelen:**
- één tool binnen het team.
- Mogelijkheid om API-requests te delen en testen te automatiseren.
- Ondersteuning voor REST, GraphQL en andere API-types.

❌ **Nadelen:**
- De gekozen software is niet bij elk teamlid bekend,  
  waardoor er een leercurve is.
