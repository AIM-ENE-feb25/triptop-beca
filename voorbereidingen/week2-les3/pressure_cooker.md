# Pressure Cooker

## Componenten en verantwoordelijkheden

- **EatsController**: API-verzoeken maken en informatie ophalen van de EatsService om te voldoen aan de API-verzoeken.
- **EatsService**: Bevat de logica voor het manipuleren van de Uber Eats API.
- **EatsFacade**: Bevat de logica voor het generen van een bruikbare response, als de Uber Eats API geen zinnige output geeft.
- **EatsRepository**: Bevat het beheren van de informatie die de API geeft en maakt connectie met de database.
- **Database**: Bevat alle locatieinfo als het fout gaat met de API.

## Beschrijven van Interfaces

- **EatsService Interface**: EatsController <-> EatsService Interface <-> EatsServiceImpl
- **EatsFacade Interface**: EatsService Interface <-> EatsFacade Interface <-> EatsFacadeImpl

## Dynamic en Code Diagram gemaakt