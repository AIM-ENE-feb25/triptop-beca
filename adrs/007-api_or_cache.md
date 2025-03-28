# ADR 007 - Externe API vs. Redis Cache

**Datum:** 27-03-2025  
**Status:** Geaccepteerd

## **Context**

Tijdens het werken aan mijn ontwerpvraag over hoe je om moet gaan met externe services die niet beschikbaar zijn, terwijl je toch een waardevolle output wilt ben ik tegen een dilemma aangelopen. Ik had de keuze om een andere API te gebruiken en de output daarvan te tonen, of de outputs die al geweest waren op te slaan en te tonen aan de gebruiker.

Een mogelijke oplossing is het gebruik van een **cache-oplossing**, zoals Redis, waarin eerder opgehaalde data wordt opgeslagen en opnieuw gebruikt als de externe service tijdelijk niet bereikbaar is. Dit kan ervoor zorgen dat er nog steeds een relevante output is, ook als de live data niet direct beschikbaar is.

Een andere mogelijke aanpak is het **overschakelen naar een alternatieve externe API** wanneer de primaire API niet beschikbaar is. Dit vereist dat er een of meerdere fallback-API’s bestaan die dezelfde of vergelijkbare gegevens kunnen leveren.

## **Alternatieven**

| Criteria                       | Redis Cache                                           | Alternatieve API                                                                                    |
| ------------------------------ | ----------------------------------------------------- | --------------------------------------------------------------------------------------------------- |
| **Beschikbaarheid**            | ++ (Direct beschikbaar als de data al in cache staat) | -- (Afhankelijk van de beschikbaarheid van alternatieve API’s)                                      |
| **Consistentie van gegevens**  | - (Kan verouderde gegevens bevatten)                  | ++ (Live data indien beschikbaar)                                                                   |
| **Complexiteit implementatie** | + (Relatief eenvoudig toe te voegen)                  | -- (Hoge complexiteit, vereist meerdere API-integraties en failover-logica)                         |
| **Latency / prestaties**       | ++ (Snelle responstijd vanuit cache)                  | - (Mogelijk hogere latentie bij overschakelen)                                                      |
| **Onderhoud en beheer**        | + (Beperkt onderhoud nodig)                           | -- (Meerdere API’s moeten beheerd worden, inclusief veranderingen in hun endpoints en dataformaten) |
| **Kosten**                     | + (Kleine extra infrastructuurkosten)                 | - (Extra kosten per API-aanroep bij alternatieve diensten)                                          |

## **Beslissing**

Ik heb er voor gekozen om de **redis-cache oplossing** te gebruiken. Ik heb dit gekozen omdat de criteria **Beschikbaarheid** en **Complexiteit implementatie** het belangrijkst voor mij zijn tijdens dit project. We hebben geen alternatieve API die lijkt op de Uber Eats API (in data opzicht) en het implementeren van een cache oplossing is niet zo lastig, na het onderzoeken hoe je met redis en redis cache in Spring Boot moet werken (Bealdung, 2024). Naast de belangrijkste criteria, heeft redis cache meer pluspunten dan alternatieve API's, wat mijn beslissing sterker maakt.

## **Consequenties**

### **Voordelen:**

- **Hogere beschikbaarheid**: Als de externe API niet beschikbaar is, kan ik nog steeds een relevante response geven op basis van eerder opgehaalde gegevens.
- **Snelheid**: De responstijden verbeteren, omdat er geen nieuwe API-aanroep nodig is als de data in de cache staat.

### **Nadelen:**

- **Mogelijk verouderde gegevens**: Als de API langer niet beschikbaar is, kan de cache niet worden ververst, wat leidt tot minder accurate data.
- **Niet geschikt voor alle use-cases**: Als real-time data essentieel is, is een cache-oplossing niet voldoende en moet alsnog een alternatieve API worden overwogen.

## Bronnen

- Bealdung (2024), Introduction to Spring Data Redis, Geraadpleegd op 27 maart 2025, [Link naar de website](https://www.baeldung.com/spring-data-redis-tutorial)
