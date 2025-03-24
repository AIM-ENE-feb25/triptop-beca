package org.example;

public class Delen implements Operatie {
    @Override
    public int voerUit(int a, int b) {
        return a / b;
    }
}
