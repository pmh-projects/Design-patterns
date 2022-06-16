package Behawioralne;

import java.io.IOException;

/**
 * Behavioral Design Pattern Template Method
 **/

public class MetodaSzablonowa {
    public static void main(String[] args) throws IOException {

        KlasaAbstrakcyjna aA = new SpecyficznaKlasaA();
        aA.MetodaSzablonowa();

        KlasaAbstrakcyjna aB = new SpecyficznaKlasaB();
        aB.JakasInnaMetoda();

        System.in.read();
    }
}

abstract class KlasaAbstrakcyjna {
    public abstract void ZrobCos();
    public abstract void JakasInnaMetoda();

    public void MetodaSzablonowa() {
        ZrobCos();
        JakasInnaMetoda();
        System.out.println("...");
    }
}

class SpecyficznaKlasaA extends KlasaAbstrakcyjna {

    @Override
    public void ZrobCos() {
        System.out.println("SpecyficznaKlasaA.ZrobCos()");
    }

    @Override
    public void JakasInnaMetoda() {
        System.out.println("SpecyficznaKlasaA.JakasInnaMetoda()");
    }
}

class SpecyficznaKlasaB extends KlasaAbstrakcyjna {

    @Override
    public void ZrobCos() {
        System.out.println("SpecyficznaKlasaB.ZrobCos()");
    }

    @Override
    public void JakasInnaMetoda() {
        System.out.println("SpecyficznaKlasaB.JakasInnaMetoda()");
    }
}
