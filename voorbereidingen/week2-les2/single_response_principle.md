# Single Responsibility Principle

## Wat is Single Responsibility Principle?

Single Responsibilty Principle houdt in dat een klasse zich zou moeten richten op slechts één aspect van de applicatie en niet meerdere verantwoordelijkheden combineren. Als een klasse meerdere verantwoordelijkheden heeft, wordt onderhoud moeilijker, omdat wijzigingen in de ene verantwoordelijkheid onbedoeld de andere kunnen beïnvloeden.

## Voordelen

- **Betere leesbaarheid en onderhoudbaarheid**: Code blijft overzichtelijk en begrijpelijk.

- **Makkelijker testen**: Klassen met een enkele verantwoordelijkheid zijn eenvoudiger te testen.

- **Minder kans op bugs**: Wijzigingen in de ene functionaliteit hebben geen invloed op andere, niet-gerelateerde functionaliteiten.

- **Betere herbruikbaarheid**: Omdat klassen onafhankelijk van elkaar werken, kunnen ze gemakkelijker in andere projecten worden gebruikt.

## Gevolgen van het NIET gebruiken van SRP

- Een klasse groeit te groot en krijgt te veel verantwoordelijkheden (ook wel een God Object genoemd).

- Wijzigingen in één functie kunnen onbedoelde neveneffecten veroorzaken in andere functies.

- Moeilijker te debuggen en te begrijpen wat de klasse precies doet.

## Design Property

- Cohesie

Zorgt voor dat klasses samenwerken i.p.v. dat 1 klasse veel dingen doet (verantwoordelijkheden).
