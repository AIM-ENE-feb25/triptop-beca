# Open/Closed principe

## Naam en definitie
Open/Closed principe (OCP) is 1 van de 5 SOLID-principes.
> Definitie: Software entities (zoals classes, modules, functies etc.) moeten open zijn voor extensie, maar gesloten voor modificatie. 

Dit houdt in dat je een bestaande codebase niet aangepast om nieuwe functionaliteit toe te voegen. In plaats daarvan voeg je nieuwe code toe (bijv. via abstractie, overerving of interfaces), zodat de bestaande (werkende) codebase niet aangepast hoeft te worden.
Het gebruik van abstractie, polymorfisme en overerving stelt je in staat nieuwe functionaliteit toe te voegen zonder de bestaande code te wijzigen.

## Consequenties van het toepassen van het Open/Closed principe
Voordelen:
- Makkelijk uit te breiden -> Bij het toevoegen van nieuwe functionaliteit kan je bestaande code uitbreiden in plaats van herschrijven.
- Lager risico op bug -> Door de bestaande code niet te wijzigen, verlaag je de kans dat je per ongeluk de werkende functionaliteit breekt.
- Flexibeler -> Door het gebruik van polymorfisme kan je makkelijk nieuwe implementaties toevoegen.

Nadelen:
- Meer werk in het begin -> Je moet je bij het ontwerpen van code al voorbereiden op hoe je later toevoegingen of aanpassingen wil gaan maken.

## Codevoorbeeld
Zie voorbeeld rekenmachine

## Op welk design property of properties is het principe gebaseerd
- Abstract Factory
- Template Method
- Stategy