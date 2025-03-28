# Toelichting Component Diagram

Dit component diagram toont de architectuur van het **Triptop** systeem, met name over de backend. De **Triptop Applicatie** stuurt verzoeken naar de backend, die bestaat uit meerdere componenten zoals de **EatsController**, **EatsService**, **EatsAdapter** en **EatsRepository**. Deze backend verwerkt API-aanvragen, beheert data en communiceert met externe systemen zoals de **UberEats API** en een **Redis Cache** voor tijdelijke opslag van restaurantgegevens.

# Design Pattern en Principe Keuze

Voor mijn ontwerp heb ik gekozen voor het **Strategy Pattern**. Dit patroon maakt het mogelijk om flexibel te schakelen tussen verschillende strategieën als de UberEats API tijdelijk niet beschikbaar is. Bijvoorbeeld, in plaats van een foutmelding te geven, kan de applicatie overschakelen op een caching-strategie met Redis.

Voor de meest passende principe koos ik voor de **Open/Closed Principle (OCP)**. Dit principe stelt dat softwarecomponenten open moeten zijn voor uitbreiding, maar gesloten voor modificatie. Dit sluit goed aan bij het Strategy Pattern, omdat nieuwe strategieën kunnen worden toegevoegd zonder bestaande code te wijzigen. Hierdoor blijft de architectuur flexibel en onderhoudbaar.

# Uitleg Code Diagram

Dit diagram laat zien hoe de verschillende onderdelen van het **Triptop backend-systeem** met elkaar samenwerken. Het belangrijkste doel van dit systeem is om restaurantgegevens op te halen, zelfs als de externe UberEats API niet beschikbaar is.

## Wat gebeurt er in het systeem?

- **EatsController**: Ontvangt aanvragen en stuurt ze door naar **EatsService**.
- **EatsService**: Kiest de beste manier om restaurantgegevens op te halen. Als de API niet werkt, gebruikt het een andere methode.
- **RetrieveDataStrategy**: Dit is een soort "plan" dat bepaalt hoe gegevens worden opgehaald. Er zijn twee strategieën:
  - **RetrieveFromAPIStrategy**: Probeert gegevens op te halen via de UberEats API.
  - **RetrieveFromCacheStrategy**: Haalt gegevens op uit de **cache** (tijdelijke opslag), zodat het systeem blijft werken als de API offline is.
- **EatsFallbackException**: Wordt gebruikt als er helemaal geen gegevens beschikbaar zijn.
