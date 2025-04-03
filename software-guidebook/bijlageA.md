# Bijlage A - Voorbeeld toevoegen van een externe service en stappenplan

Om te verduidelijken hoe andere externe services kunnen worden toegevoegd, hebben we een diagram gemaakt waar, als voorbeeld, een tweede externe restaurantservice (Tripadvisor) is toegevoegd en een externe hotelservice (Booking COM).

![Afbeelding van component diagram](./ontwerpvraag-eva/component-diagram-eva-2-metvoorbeelden.svg)

## Overzicht
Om een tweede restaurantservice toe te voegen (feature bestaat al), hoeft er alleen een adapter voor de externe service aangemaakt te worden die de bestaande `RestaurantPort` implementeert en de `APICaller` extend. In `RestaurantService` hoeft geen code aangepast te worden en deze blijft gebruik maken van dezelfde `RestaurantPort`.

Om een hotelservice toe te voegen (nieuwe feature), moet er een `HotelController` en `HotelService` aangemaakt worden, met een eigen interface (HotelPort). Ook moet er een nieuwe adapterklasse (BookingCOMAdapter) gemaakt worden die deze interface implementeert en `APICaller` extend. 

In het prototype is een voorbeelduitwerking te vinden van het toevoegen van de nieuwe hotelfeature. Het uitbreiden van de bestaande restaurantfeature met een nieuwe externe service is niet uitgewerkt i.v.m. de beperkte duur van het project. 

Hieronder volgt een gedetailleerde uitleg van het stappenplan om een nieuwe feature toe te voegen.Kijk voor een voorbeeld naar de klassen `Hotel`, `HotelController`, `HotelService`, `HotelPort`, `APICaller` en `BookingCOMAdapter` in het prototype:

## Stappenplan toevoegen nieuwe feature
### 1. Maak een nieuwe controller aan
Voeg de annotaties `@RestController` en `@RequestMapping("/endpointnaam")` toe (vervang 'endpointnaam' voor de featurenaam, zoals 'hotels', 'attracties' etc.). Maak een constructor aan en voeg methoden toe voor de endpoints.
### 2. Maak een nieuwe domain class aan
Voeg attributen toe en voeg een constructor, getters, setters en een toString methode toe.
### 3. Maak een nieuwe service aan
Voeg de annotatie `@Service` toe aan de klasse en `@AutoWired` aan de contructor. Voeg ook methoden toe die corresponderen met de methoden in de controller van stap 1.
### 4. Maak een nieuwe Port aan (interface)
Voeg hier de methoden uit de service van stap 3 toe. 
### 5. Maak een nieuwe adapter aan
Voeg de annotatie `@Component` toe aan de klasse. Samen met de `@AutoWired` annotatie in de service (stap 3) zorgt deze dat de port bean gevonden kan worden. Implementeer de port uit stap 4 en extend de APICaller. Neem deze methoden over. Voeg de API key en URL toe aan `application.properties` volgens het volgende format:
```properties
# api naam
APINaam.API.key=key-voor-api
APINaam.API.url=url-voor-api
```
Vervang de waarden voor de daadwerkelijke naam van de API, key en URL. 

Maak een constructor en gebruik `@Value` om de key en URL uit te lezen volgens het volgende format:

```java
public APINaamAdapter(@Value("${APINaam.API.key}") String APIKey, @Value("${APINaam.API.URL}") String APIURL) {
    this.APIURL = APIURL;
    this.APIKey = APIKey;
}
```
Vervang "APINaam" voor de naam van de daadwerkelijke API.

Vul de APICaller methoden in:
- login: een println als placeholder voor de latere login logica;
- checkToken: token op 'null' zetten;
- callAPI: de code voor de daadwerkelijke API aanroep.

Vul als laatste de port methoden in. Als de methode parameters gebruikt, voeg deze dan toe aan een Map genaamd 'parameters' zodat het in de callAPI methode kan. Dit kan als volgt:
```java
Map<String, String> parameters = Map.of("parameternaam1", parameternaam1, "parameternaam2", parameternaam2);
```

### 6. Test of het werkt
