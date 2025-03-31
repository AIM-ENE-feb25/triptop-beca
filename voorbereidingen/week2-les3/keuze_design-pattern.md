# Keuze van Design Pattern en Ontwerpprincipes

Voor het waarborgen van data-integriteit bij het verzenden en ontvangen van data via externe API’s heb ik gekozen voor het State Pattern. De reden hiervoor is dat mijn ontwerpvraag een dynamische overgang tussen verschillende API-versies vereist, waardoor ik polymorfisme zal moeten toepassen.

Het Strategy Pattern zou hier niet geschikt zijn omdat je bij dit patroon de service gebruikt om te wisselen van strategiën (namelijk de versies van API's). Dit leidt tot high coupling en low cohesion.
Het leidt tot high coupling omdat de service moet weten welke API-versie actief is en de juiste strategie moet instellen.
Het leidt tot low cohesion omdat de logica van de transitie tussen API-versies niet binnen de API’s zelf wordt geregeld, maar binnen de service.

Het State Pattern daarentegen zorgt ervoor dat de API’s zelf verantwoordelijk zijn voor de transitie naar een andere staat. Waardoor je low coupling, high cohesion en flexibiliteit voor de toekomst hebt.
Het leidt tot low coupling omdat de service niet hoeft te weten welke API-versie actief is aangezien de API’s zelf verantwoordelijk zijn voor de transitie.
Het leidt tot high cohesion omdat de API-transities en bijbehorende logica binnen API-implementaties blijven.
Tot slot leidt het ook nog tot flexibiliteit voor in de toekomst omdat wanneer je een API V3 krijgt, dat API V2 de overgang hiernaartoe regelen. Met een strategy pattern zou dit weer zorgen voor nog meer low coupling omdat dit extra werk is voor de service.

Als ontwerpprincipes heb ik gekozen voor het Open/Closed Principle en Program to an Interface.

Ik heb voor Open/Closed gekozen omdat ik gebruik maak van polymorfie via interfaces, zodat elke nieuwe API-versie als een nieuwe state kan worden toegevoegd zonder bestaande code te wijzigen.
Elke API-versie implementeert dezelfde interface en kan een volgende versie instellen wanneer dat nodig is.