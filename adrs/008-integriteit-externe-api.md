# ADR 008 - Waarborging van Data-integriteit bij Externe APIs

**Datum:** 27-03-2025  
**Status:** Geaccepteerd

## **Context**

Onze applicatie maakt gebruik van meerdere externe API’s voor het ontvangen van data. Het is cruciaal om de integriteit van deze data te waarborgen om ervoor te zorgen dat de gegevens correct en betrouwbaar zijn. Een probleem dat we moeten oplossen is het omgaan met veranderingen in de structuur van ontvangen data wanneer een API een nieuwe versie uitbrengt. Dit kan worden bereikt door verschillende methoden zoals validatie, logging, en het gebruik van beveiligde verbindingen.

## **Alternatieven**

| Criteria                       | Validatie Service                                    | Logging Service                                                                                 | Beveiligde Verbindingen (HTTPS)                                                                 |
| ------------------------------ | --------------------------------------------------- | ----------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------ |
| **Data-integriteit**           | ++ (Controleert de juistheid van de data)           | + (Biedt traceerbaarheid en helpt bij het opsporen van fouten)                                  | ++ (Versleutelt data tijdens transmissie, voorkomt onderschepping en manipulatie)                 |
| **Complexiteit implementatie** | + (Eenvoudig te integreren met bestaande services)  | + (Eenvoudig te implementeren, vereist alleen logging configuratie)                             | + (Standaard in moderne API-ontwikkeling, vereist certificaatbeheer)                              |
| **Prestaties**                 | - (Kan de responstijd beïnvloeden door extra checks)| - (Kan de prestaties beïnvloeden door extra logging overhead)                                   | + (Minimale impact op prestaties, afhankelijk van de implementatie)                               |
| **Onderhoud en beheer**        | + (Beperkt onderhoud nodig)                         | + (Beperkt onderhoud nodig, afhankelijk van de logging configuratie)                            | + (Certificaatbeheer vereist periodieke updates en monitoring)                                    |
| **Kosten**                     | + (Weinig extra kosten)                             | + (Weinig extra kosten, afhankelijk van de hoeveelheid gelogde data)                            | + (Kosten voor certificaten en mogelijk hogere kosten voor beveiligde verbindingen)               |

## **Beslissing**

We hebben besloten om een combinatie van **Validatie Service**, **Logging Service**, en **Beveiligde Verbindingen (HTTPS)** te gebruiken om de integriteit van data die via externe API’s wordt verzonden of ontvangen te waarborgen. Logging zal ook worden gebruikt om versie-informatie van de API's vast te leggen, zodat veranderingen in de structuur van ontvangen data kunnen worden gedetecteerd en beheerd. Deze combinatie biedt een robuuste oplossing die zowel de juistheid van de data controleert, traceerbaarheid biedt, en de data beschermt tijdens transmissie.

## **Consequenties**

### **Voordelen:**

- **Hoge data-integriteit**: Door validatie en beveiligde verbindingen wordt de juistheid en veiligheid van de data gewaarborgd.
- **Traceerbaarheid**: Logging biedt inzicht, helpt bij het opsporen van fouten en legt versie-informatie vast.
- **Beveiliging**: HTTPS zorgt ervoor dat de data tijdens transmissie versleuteld is, wat onderschepping en manipulatie voorkomt.

### **Nadelen:**

- **Prestaties**: Extra validatie en logging kunnen de responstijd beïnvloeden.
- **Onderhoud**: Certificaatbeheer voor HTTPS vereist periodieke updates en monitoring.
- **Complexiteit**: Het combineren van meerdere methoden kan de implementatiecomplexiteit verhogen.