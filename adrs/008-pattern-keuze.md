# 008. Gebruik van het State Pattern voor Booking Volgorde
Date: 27-03-2025

## Status
Geaccepteerd

## Context
In de applicatie TripTop moeten meerdere externe services worden aangeroepen in een vaste volgorde. Dit betekent dat de volgende stappen van een boeking één voor één moeten plaats vinden:

1. **Beschikbaarheid controleren**
2. **Hotel boeken**
3. **Vlucht boeken**
4. **Auto huren**
5. **Boeking bevestigen**

Het team zoekt naar een pattern die deze stappen flexibel en goed onderhoudbaar maakt, waarbij de afhandeling van elke stap duidelijk gescheiden blijft.

## Alternatieven
We hebben verschillende ontwerppatronen overwogen:

| Oplossing     | Flexibiliteit               | Modulariteit                | Complexiteit                  | Uitbreidbaarheid            |
|---------------|-----------------------------|-----------------------------|-------------------------------|-----------------------------|
| State Pattern | +++<br/>Makkelijk nieuwe staten toevoegen* | +++<br/>Elke state in een aparte klasse| ––<br/>Verhoogt het aantal klassen en samenhang  | +++<br/>Nieuwe gedragingen implementeren zonder de context te wijzigen |
| Strategy Pattern | +++<br/>Vervanging van algoritmes is eenvoudig | +++<br/>Losse strategieklassen bevorderen hergebruik | +<br/>Beperkte complexiteit, vooral bij weinig strategieën | +++<br/>Nieuwe strategieën kunnen onafhankelijk worden toegevoegd  |
| Facade Pattern | +<br/>Beperkt in flexibiliteit doordat de focus ligt op eenvoud | ++<br/>Verbergt complexiteit maar kan leiden tot monolithische façade | +++<br/>Vereenvoudigt de interface voor de cliënt | +<br/>Minder geschikt voor het dynamisch toevoegen van nieuwe functionaliteiten |
| Adapter Pattern | ++<br/>Maakt het mogelijk om incompatibele interfaces te integreren | ++<br/>Helpt bij het isoleren van de aanpassingslogica | +<br/>Voegt een extra laag toe, maar beperkt de impact | ++<br/>Nieuwe adapters kunnen relatief eenvoudig geïmplementeerd worden |
| Factory Pattern | ++<br/>Eenvoudig aanpasbaar voor objectcreatie| ++<br/>Centraliseert instantiatie en bevordert consistentie | +<br/>Voegt extra abstractie toe, maar is meestal beperkt tot creatie | ++<br/>Gemakkelijk uit te breiden met nieuwe subklassen of producten |


## Keuze
Het team heeft gekozen voor het State Pattern, waarbij elke stap van boeken een eigen State klasse heeft. De BookingVolgorde klasse beheert deze states en bepaalt de juiste volgorde van verwerking. Dit zorgt ervoor dat:

- Elke stap duidelijk gescheiden blijft.
- er eenvoudig nieuwe stappen kunnen toevoegen zonder de originele klasse te herschrijven.

## Consequenties
### Voordelen
✅ **Modulair** – Elke stap zit in een aparte klasse en kan los worden beheerd.  
✅ **Flexibel** – Makkelijk uitbreidbaar als er een nieuwe boekingsstap nodig is.

### Nadelen
⚠ **Complexiteit** – Meer klassen nodig voor elke stap.
 


