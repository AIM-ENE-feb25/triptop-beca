# ADR 008 - Gebruik van het State Pattern voor Booking Volgorde

**Datum:** 27-03-2025

## Status

Geaccepteerd

## Context

In de applicatie TripTop moeten meerdere externe services worden aangeroepen in een vaste volgorde. Dit betekent dat de volgende stappen van een boeking één voor één moeten plaats vinden:

1. **Hotel boeken**
2. **Vlucht boeken**
3. **Auto huren**
4. **Boeking bevestigen**

Wij zoeken naar een pattern die deze stappen flexibel en goed onderhoudbaar maakt, waarbij de afhandeling van elke stap duidelijk gescheiden blijft.

## Alternatieven

We hebben verschillende ontwerppatronen overwogen:

| Oplossing        | Flexibiliteit                                                    | Modulariteit                                                      | Complexiteit                                                       | Uitbreidbaarheid                                                             |
| ---------------- |------------------------------------------------------------------|-------------------------------------------------------------------|--------------------------------------------------------------------|------------------------------------------------------------------------------|
| State Pattern    | ++(Makkelijk nieuwe staten toevoegen)                            | ++(Elke state in een aparte klasse)                               | – –(Verhoogt het aantal klassen en samenhang)                      | ++(Nieuwe gedragingen implementeren zonder de context te wijzigen)           |
| Strategy Pattern | ++(Vervanging van algoritmes is eenvoudig)                       | ++(Losse strategieklassen bevorderen hergebruik)                  | +(Beperkte complexiteit, vooral bij weinig strategieën)            | ++(Nieuwe strategieën kunnen onafhankelijk worden toegevoegd)                |
| Facade Pattern   | +(Beperkt in flexibiliteit doordat de focus ligt op eenvoud)     | +(Verbergt complexiteit maar kan leiden tot monolithische façade) | ++(Vereenvoudigt de interface voor de cliënt)                      | +(Minder geschikt voor het dynamisch toevoegen van nieuwe functionaliteiten) |
| Adapter Pattern  | ++(Maakt het mogelijk om incompatibele interfaces te integreren) | +(Helpt bij het isoleren van de aanpassingslogica)                | +(Voegt een extra laag toe, maar beperkt de impact)                | +(Nieuwe adapters kunnen relatief eenvoudig geïmplementeerd worden)          |
| Factory Pattern  | ++(Eenvoudig aanpasbaar voor objectcreatie)                      | +(Centraliseert instantiatie en bevordert consistentie)           | +(Voegt extra abstractie toe, maar is meestal beperkt tot creatie) | +(Gemakkelijk uit te breiden met nieuwe subklassen of producten)             |

## Keuze

Wij hebben gekozen voor het State Pattern, waarbij elke stap van boeken een eigen State klasse heeft. De BookingVolgorde klasse beheert deze states en bepaalt de juiste volgorde van verwerking. Dit zorgt ervoor dat:

- Elke stap duidelijk gescheiden blijft.
- er eenvoudig nieuwe stappen kunnen toevoegen zonder de originele klasse te herschrijven.

## Consequenties

### Voordelen

**Modulair** – Elke stap zit in een aparte klasse en kan los worden beheerd.  
**Flexibel** – Makkelijk uitbreidbaar als er een nieuwe boekingsstap nodig is.

### Nadelen

**Complexiteit** – Meer klassen nodig voor elke stap.
