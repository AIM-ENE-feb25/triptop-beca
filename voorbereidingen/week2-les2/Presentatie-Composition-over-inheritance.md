# Composition over Inheritance

## Definitie
Composition over Inheritance betekent dat je objecten opbouwt door ze te combineren met kleinere, losse onderdelen (compositie) in plaats van nieuwe klassen te maken die een bestaande klasse overnemen (overerving).

Overerving kan code herbruikbaar maken, maar het zorgt er ook voor dat klassen sterk met elkaar verbonden zijn. Als je de ouderklasse aanpast, heeft dat invloed op alle afgeleide klassen, wat je code moeilijk te onderhouden maakt.

Compositie lost dit op door kleine, losse stukjes functionaliteit te maken die je flexibel kunt combineren zonder dat alles aan elkaar vastzit.


## Consequenties van het toepassen van het principe

- Meer flexibiliteit:
  Met compositie kun je eenvoudig onderdelen vervangen of toevoegen zonder de hele code te veranderen. Dit maakt het makkelijker om nieuwe functionaliteit toe te voegen.


- Minder afhankelijkheden: 
  Bij overerving zijn klassen sterk met elkaar verbonden. Als je iets wijzigt in een ouderklasse, kan dat problemen veroorzaken in alle afgeleide klassen. Compositie voorkomt dit door losse onderdelen te gebruiken die je apart kunt aanpassen.


- Beter herbruikbare code:
  Met compositie kun je kleine stukjes code in verschillende objecten hergebruiken zonder ze telkens opnieuw te schrijven. Dit bespaart tijd en maakt je code efficiënter.

## Codevoorbeeld

### Overerving
```java
class Dier {
    void eet() {
        System.out.println("Het dier eet.");
    }
}

class Zoogdier extends Dier {
    void drinktMelk() {
        System.out.println("Dit zoogdier drinkt melk.");
    }
}

class Hond extends Zoogdier {
    void blaf() {
        System.out.println("Woef!");
    }
}

public class Main {
    public static void main(String[] args) {
        Hond hond = new Hond();
        hond.eet();
        hond.drinktMelk();
        hond.blaf();
    }
}
```

### Compositie
```java
class EetGedrag {
    void eet() {
        System.out.println("Het dier eet.");
    }
}

class BlafGedrag {
    void blaf() {
        System.out.println("Woef!");
    }
}

class Hond {
    private EetGedrag eetGedrag;
    private BlafGedrag blafGedrag;

    public Hond() {
        this.eetGedrag = new EetGedrag();
        this.blafGedrag = new BlafGedrag();
    }

    void eet() {
        eetGedrag.eet();
    }

    void blaf() {
        blafGedrag.blaf();
    }
}

public class Main {
    public static void main(String[] args) {
        Hond hond = new Hond();
        hond.eet();
        hond.blaf();
    }
}
```


## Op welke design property is het principe gebaseerd?

Composition over Inheritance is gebaseerd op coupling, wat verwijst naar de mate waarin onderdelen van een systeem afhankelijk zijn van elkaar.

- Tight coupling: Overerving zorgt voor sterke afhankelijkheid tussen klassen, waardoor wijzigingen in een ouderklasse invloed hebben op alle subklassen.
- Loose coupling: Compositie vermindert afhankelijkheden door objecten samen te stellen uit kleinere, zelfstandige componenten.


