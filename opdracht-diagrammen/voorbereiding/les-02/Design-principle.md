# Design principe: Law of demeter

## Design property: Information Hiding

1.  Definitie van het Principe
    <br></br>
Dit principe zegt dat een object alleen mag communiceren met objecten die direct aan het object verbonden zijn. 
Het betekent dat een object niet mag praten met objecten die verderop in de keten liggen. 
Bijvoorbeeld: als object A een methode aanroept van object B, mag B geen methode van object C aanroepen.
   <br></br>
2. Gevolgen van het Toepassen van het Principe

 >  Minder afhankelijkheden: Objecten communiceren alleen met hun directe relaties, wat betekent dat ze minder afhankelijk zijn van andere objecten.

 >  Betere encapsulatie: De interne werking van objecten blijft verborgen, waardoor je de implementatie kunt wijzigen zonder dat andere objecten beïnvloed worden.

 >  Minder kans op fouten: Het systeem wordt minder kwetsbaar voor bugs, omdat er minder interactie is tussen objecten die indirect met elkaar verbonden zijn.
   
4. Design Eigenschappen waarop het Principe Gebaseerd is
   <br></br>
Encapsulatie: Dit principe zorgt ervoor dat de interne details van een object verborgen blijven. 
Alleen de directe eigenschappen of methoden van een object mogen worden aangesproken.
Losse Koppeling: Door objecten niet direct te laten communiceren met andere objecten verderop in de keten, worden ze minder afhankelijk van elkaar. 
Dit maakt het systeem flexibeler en makkelijker te wijzigen zonder dat andere objecten worden beïnvloed.
