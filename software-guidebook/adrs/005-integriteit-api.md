# ADR 005 - Waarborging van Data-integriteit bij Externe APIs

**Datum:** 27-03-2025

## Status

Geaccepteerd

## **Context**

Onze applicatie maakt gebruik van meerdere externe API’s voor het ontvangen van data. Het is cruciaal om de integriteit van deze data te waarborgen om ervoor te zorgen dat de gegevens correct en betrouwbaar zijn.
Een uitdaging is het omgaan met veranderingen in de structuur van ontvangen data wanneer een API een nieuwe versie uitbrengt.

## **Alternatieven**

| Criteria                          | Dynamische API-toewijzing                             | Handmatige versiekeuze via service               |
|-----------------------------------|-------------------------------------------------------|--------------------------------------------------|
| **Automatische API-transities**   | + (Elke API regelt eigen transitie)                   | - (Service moet versies beheren)                 |
| **Low coupling**                  | + (Service hoeft API-versies niet te kennen)          | - (Service moet weten welke API actief is)       |
| **High cohesion**                 | + (Transities en logica blijven binnen API’s)         | - (Logica verspreid over service en API’s)       |
| **Schaalbaarheid**                | + (Nieuwe versies kunnen eenvoudig worden toegevoegd) | - (Elke nieuwe versie verhoogt de complexiteit)  |
| **Complexiteit implementatie**    | - (API’s moeten transitiebeheer implementeren)        | - (Service wordt complexer bij meerdere versies) |

## **Beslissing**

We hebben gekozen voor een toewijzing waarbij FlightService altijd met een ApiState werkt. De API-implementaties zijn zelf verantwoordelijk voor het doorsturen van de transitie naar een volgende versie, wat zorgt voor een flexibele en uitbreidbare architectuur.

## **Consequenties**

### **Voordelen:**
+ **Automatische API-overgangen** zonder externe service-logica.
+ **Low coupling & high cohesion**: API’s regelen zelf hun versies, zonder afhankelijkheid van de service.
+ **Flexibel uitbreidbaar**: Nieuwe API-versies kunnen eenvoudig worden toegevoegd.
+ **Beveiliging en betrouwbaarheid** door validatie, logging en HTTPS.

### **Nadelen:**
- **Complexiteit**: API’s moeten hun eigen transitiebeheer implementeren.  