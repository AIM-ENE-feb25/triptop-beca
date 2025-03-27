# Pressure Cooker

## Componenten en verantwoordelijkheid
| Component | Voorbeeldnamen | Verantwoordelijkheid | 
|----|----|---|
| Controller(s) | RestaurantController, HotelController | Ontvangen de HTTP-verzoeken van de front-end en roepen de bijbehorende service aan. |
| Service(s) | RestaurantService, HotelService | Beheren de businesslogica en regelen het opvragen van data via de ports. |
| APICaller (abstracte klasse) | APICaller | Legt de vaste volgorde van stappen binnen de externe API-aanroepen vast volgens Template Method Pattern. Hierdoor wordt consistent gedrag afgedwongen tussen de API-adapters. |
| APIPort(s) (interfaces) | RestaurantPort, HotelPort | Definieert de methoden die de service kan aanroepen voor het opvragen van data. |
| APIAdapter(s) | UberEatsAdapter, BookingComAdapter | Geven invulling aan de methoden uit de APICaller, implementeren de bijbehorende port en regelen de communicatie met de externe API. |

> Voorbeeldnamen toegevoegd, want de specifieke klassen zijn afhankelijk van de feature die je wilt toevoegen en de bouwsteen die daarbij hoort.

## Interfaces van betrokken componenten
> Dit zijn voorbeelden van mogelijke ports
- RestaurantPort  

public interface RestaurantPort {
    List<Restaurant> getRestaurantsForLocation(String location);
}

- HotelPort  

public interface HotelPort {
    List<Hotel> getHotelsForLocation(String location);
}

## Dynamic diagram
> Gemaakt op basis van restaurant bouwsteen/feature als voorbeeld.

## Class diagram
> Gemaakt op basis van restaurant bouwsteen/feature als voorbeeld.

### Onduidelijkheden in diagram
- Wat voor een returntype zijn de APICaller methoden?
- Welke methoden komen er specifiek in de controller/service/port?

## Pattern en Principle
- Template Method Pattern
- Open/Closed Principle


