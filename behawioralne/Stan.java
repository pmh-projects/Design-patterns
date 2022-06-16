package Behawioralne;

import java.io.IOException;

/**
 * Behavioral Design Pattern State
 **/

public class Stan {
    public static void main(String[] args) throws IOException {
        SwiatloKontekst kontekst = new SwiatloKontekst(new Zielone());

        kontekst.Pokaz();
        kontekst.Pokaz();
        kontekst.Pokaz();
        kontekst.Pokaz();

        System.in.read();
    }
}

abstract class Swiatlo {
    public abstract void Zmien(SwiatloKontekst kontekst);
}

class SwiatloKontekst{
    private Swiatlo _stan;

    public SwiatloKontekst(Swiatlo swiatlo) {
        setStan(swiatlo);
    }

    public Swiatlo getStan() {
        return _stan;
    }

    public void setStan(Swiatlo swiatlo) {
        this._stan = swiatlo;
        System.out.println("Swiatlo: " + _stan.getClass().getSimpleName());
    }

    public void Pokaz(){
        _stan.Zmien(this);
    }
}

class Zielone extends Swiatlo{
    @Override
    public void Zmien(SwiatloKontekst kontekst) {
        kontekst.setStan(new Zolte());
    }
}

class Zolte extends Swiatlo{
    @Override
    public void Zmien(SwiatloKontekst kontekst) {
        kontekst.setStan(new Czerwone());
    }
}

class Czerwone extends Swiatlo{
    @Override
    public void Zmien(SwiatloKontekst kontekst) {
        kontekst.setStan(new Zielone());
    }
}