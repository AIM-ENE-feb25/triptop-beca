# Keuze van Design Pattern en Ontwerpprincipes

Als design pattern voor mijn ontwerpvraag heb ik gekozen voor het **Strategy Pattern**, omdat dit het beste aansluit bij mijn vraag. Mijn ontwerpvraag draait om het garanderen van de integriteit van data die via externe API's wordt ontvangen. Met dit patroon kan ik flexibel schakelen tussen verschillende strategieën, zoals validatie, logging en beveiligde verbindingen, om de data-integriteit te waarborgen.

Het Strategy Pattern biedt de mogelijkheid om algoritmen of strategieën te variëren zonder dat de omringende code hoeft te worden aangepast. Dit is nuttig in mijn situatie, omdat ik eenvoudig nieuwe mechanismen kan implementeren.

---

Bij de keuze voor ontwerpprincipes heb ik gekeken naar het **Open/Closed Principe**/

Het **Open/Closed Principe** (OCP) stelt dat softwarecomponenten uitbreidbaar moeten zijn zonder dat bestaande code aangepast hoeft te worden. Dit sluit goed aan bij het Strategy Pattern, omdat ik nieuwe strategieën kan toevoegen zonder de bestaande implementatie te wijzigen. Hierdoor blijft de code flexibel en goed onderhoudbaar.
