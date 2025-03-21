# Prototypes met klasses

| Class::attribuut                               | Is input voor API+Endpoint     | Wordt gevuld door API+Endpoint | Wordt geleverd door eindgebruiker | Moet worden opgeslagen in de applicatie |
|------------------------------------------------|--------------------------------| ------------------------------ |-----------------------------------|-----------------------------------------|
| Locatie::lat, Locatie::lon                     | MapsData /whatishere (GET)     |                                | x                                 |                                         |
| Verblijf::startDatum, Verblijf::eindDatum      | Booking.com /searchHotels (GET) || x                                 |                                         |
| Verblijfplaats::locatie, Verblijfplaats::prijs | |Booking.com /searchHotels (GET)|| x                                       |