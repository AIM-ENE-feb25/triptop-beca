package org.example;

public class RekenmachineZonderOCP {

    public int bereken(String operatie, int a, int b) {
        switch (operatie) {
            case "optellen":
                return a + b;
            case "delen":
                return a / b;
            case "vermenigvuldigen":
                return a * b;
            default:
                System.out.println("Onbekend: " + operatie);
                return 0;
        }
    }

    public static void run() {
        RekenmachineZonderOCP rekenmachine = new RekenmachineZonderOCP();
        System.out.println("Zonder OCP: ");
        System.out.println("Optellen: " + rekenmachine.bereken("optellen", 5, 3));   // 8
        System.out.println("Delen: " + rekenmachine.bereken("delen", 10, 2)); // 5
        System.out.println("Vermenigvuldigen: " + rekenmachine.bereken("vermenigvuldigen", 5, 3));
    }
}




