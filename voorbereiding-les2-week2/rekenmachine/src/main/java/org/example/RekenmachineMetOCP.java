package org.example;

public class RekenmachineMetOCP {
    public int bereken(Operatie operatie, int a, int b) {
        return operatie.voerUit(a, b);
    }

    public static void run() {
        RekenmachineMetOCP calculator = new RekenmachineMetOCP();
        System.out.println("Met OCP: ");
        System.out.println("Optellen: " + calculator.bereken(new Optellen(), 5, 3));   // 8
        System.out.println("Delen: " + calculator.bereken(new Delen(), 10, 2)); // 5
    }
}
