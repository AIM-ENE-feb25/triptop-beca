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

Voor het waarborgen van data-integriteit bij het verzenden en ontvangen van data via externe API’s hebben we gekozen voor het State Pattern. De reden hiervoor is dat de ontwerpvraag een dynamische overgang tussen verschillende API-versies vereist, wat het gebruik van polymorfisme noodzakelijk maakt.

Het Strategy Pattern zou hier niet geschikt zijn, omdat het de service gebruikt om te wisselen van strategieën (namelijk de versies van API’s). Dit zou leiden tot high coupling en low cohesion. Het leidt tot high coupling omdat de service moet weten welke API-versie actief is en de juiste strategie moet instellen. Het leidt ook tot low cohesion, omdat de logica van de transitie tussen API-versies niet binnen de API’s zelf wordt geregeld, maar binnen de service.

Het State Pattern daarentegen zorgt ervoor dat de API’s zelf verantwoordelijk zijn voor de transitie naar een andere staat, wat resulteert in low coupling, high cohesion en flexibiliteit voor de toekomst. De service hoeft niet te weten welke API-versie actief is, aangezien de API’s zelf verantwoordelijk zijn voor de transitie. Bovendien blijven de transities en bijbehorende logica binnen de API-implementaties, wat de cohesion verhoogt. Dit biedt flexibiliteit, omdat bijvoorbeeld als API V3 wordt geïntroduceerd, API V2 de overgang naar V3 kan regelen.

Als ontwerpprincipes hebben we gekozen voor het Open/Closed Principle en Program to an Interface. We maken gebruik van polymorfisme via interfaces, zodat elke nieuwe API-versie als een nieuwe state kan worden toegevoegd zonder bestaande code te wijzigen. Elke API-versie implementeert dezelfde interface en kan een volgende versie instellen wanneer dat nodig is.

## **Consequenties**

### **Voordelen:**
+ **Automatische API-overgangen** zonder externe service-logica.
+ **Low coupling & high cohesion**: API’s regelen zelf hun versies, zonder afhankelijkheid van de service.
+ **Flexibel uitbreidbaar**: Nieuwe API-versies kunnen eenvoudig worden toegevoegd.
+ **Beveiliging en betrouwbaarheid** door validatie, logging en HTTPS.

### **Nadelen:**
- **Complexiteit**: API’s moeten hun eigen transitiebeheer implementeren.  