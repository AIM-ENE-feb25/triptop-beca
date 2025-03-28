# Motivatie design pattern & component diagram

## Design pattern
Voor het uitwerken van mijn prototype heb ik gekozen om de state pattern toe te passen.
Dit komt doordat de ontwerpvraag verschillende stappen wilt laten uitvoeren in volgorde.
Daarbij vond ik dat states het best gebruikt kon worden om dit te realiseren. 
Bekijk adr state pattern voor meer uitleg.\

## Component diagram
 > BookingService als centrale aansturing van de boeking, waardoor de controller ontlast wordt.

 > State Pattern in BookingVolgorde om de juiste volgorde van boekingen te garanderen.

 > BookingAdapter als tussenlaag, zodat het systeem flexibel blijft bij API-wijzigingen.
 
 > Duidelijke scheiding tussen verwerking (BookingVolgorde) en opslag (TripRepository).

Dit ontwerp zorgt ervoor dat meerdere externe API-aanroepen correct worden afgehandeld
in de juiste volgorde en biedt tegelijkertijd flexibiliteit, uitbreidbaarheid en onderhoudbaarheid.