package Strukturalne;

import java.io.IOException;

/**
 * Structural Design Pattern Bridge
 **/

public class Most {
    public static void main(String[] args) throws IOException {

        Abstrakcja ab = new AbstrakcjaPochodna();

        ab.implementacja = new SpecficznaImplementacja();
        ab.MetodaImplementacji();

        ab.implementacja = new InnaImplementacja();
        ab.MetodaImplementacji();

        System.in.read();
    }
}

abstract class Implementacja {
    public abstract void MetodaImplementacji();
}

abstract class Abstrakcja {
    protected Implementacja implementacja;
    public void setImplementacja(Implementacja value) {
        implementacja = value;
    }

    public void MetodaImplementacji() {
        implementacja.MetodaImplementacji();
    }
}

class AbstrakcjaPochodna extends Abstrakcja {
    @Override
    public void MetodaImplementacji() {
        implementacja.MetodaImplementacji();
    }
}

class SpecficznaImplementacja extends Implementacja {

    @Override
    public void MetodaImplementacji() {
        System.out.println("SpecyficznaImplementacja MetodaImplementacji");
    }
}

class InnaImplementacja extends Implementacja {

    @Override
    public void MetodaImplementacji() {
        System.out.println("InnaImplemetacja MetodaImplementacji");
    }
}