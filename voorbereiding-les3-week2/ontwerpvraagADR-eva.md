# 005. Hoe zorgen we ervoor dat we makkelijk een nieuwe externe service kunnen toevoegen?
Datum: 27-03-2025

## Status
Voorgesteld

## Context
In dit project halen we data op via externe API’s van verschillende aanbieders, zoals Uber Eats en Booking.com. Deze externe services verschillen onderling in structuur, vereisten en aanroepwijze.

We willen flexibel blijven in het gebruik van deze services, zodat we eenvoudig kunnen wisselen van aanbieder als een externe service onvoldoende aanbod heeft of als we een nieuwe feature willen toevoegen.

Daarom zoeken we een structuur waarmee we eenvoudig een nieuwe externe service kunnen toevoegen of vervangen, zonder bestaande code te wijzigen. We willen een oplossing die onderhoudbaar en uitbreidbaar is, en waarbij de koppeling met specifieke aanbieders laag is.

## Alternatieven
| Forces | Directe koppeling met API-implementatieklasse (zonder interface) | Centrale API-gatewayklasse | Ports en Adapters |
|------------------------------|----------------|-----|--|
| Uitbreidbaarheid (OCP) | - (Nieuwe aanbieder vereist wijziging service) | - (Nieuwe aanbieder vereist wijziging gatewayklasse) | + (Nieuwe adapter toevoegen) |
| Herbruikbare structuur | - (Geen gedeelde interface of abstractie) | - (Alles in één klasse, dus beperkt per aanbieder) | + (Via adapters en ports) |
| Afhankelijkheid | - (Service hangt direct af van concrete implementatieklasse)| - (Service hangt af van gatewayklasse) | + (Service hangt alleen af van port-interface) |
| Complexiteit | + (Gemakkelijk en snel te implementeren) | + (Gemakkelijk te begrijpen en beheren) | - (Meer structuur nodig) |
| Consistente manier van aanroepen | - (Geen vaste structuur) | + (Centrale plek om consistentie af te dwingen) | + (Afgedwongen via adapter-structuur) |

## Keuze
We kiezen voor de Ports & Adapters-architectuur (hexagonale architectuur). Hierdoor spreken services niet direct met concrete klassen, maar gebruiken ze een port-interface die door externe adapters wordt geïmplementeerd. Elke externe service (zoals Uber Eats of Booking.com) heeft zijn eigen adapter, die de interface van de bijbehorende bouwsteen implementeert.

Deze structuur maakt het mogelijk om een nieuwe externe service toe te voegen zonder de bestaande code te wijzigen. De service hoeft alleen de interface te gebruiken. Dit sluit aan op het Open/Closed Principle (OCP) en het Dependency Inversion Principle (DIP), waarbij je afhankelijk bent van abstracties in plaats van concrete implementaties.

## Consequenties
### Positieve consequenties:
+ Voldoet aan OCP -> Externe services kunnen worden toegevoegd door een nieuwe adapter te implementeren, zonder dat bestaande code aangepast hoeft te worden.
+ Voldoet aan DIP -> Service is losgekoppeld van specifieke implementaties, wat zorgt voor betere testbaarheid.
+ Consistentie -> Consistentie in hoe externe API’s worden aangeroepen, omdat iedere adapter dezelfde interface gebruikt (per bouwsteen).
+ Overzichtelijk -> Door voor iedere bouwsteen (zoals restaurants of hotels) een eigen interface te gebruiken, blijft de architectuur overzichtelijk.
### Negatieve consequenties:
- Complexer -> Vereist meer werk en abstractie dan de andere alternatieven.
- Meer componenten nodig -> Er zijn extra componenten nodig door gebruik van ports en adapters.




# Voorbeelden diagram opnemen!
