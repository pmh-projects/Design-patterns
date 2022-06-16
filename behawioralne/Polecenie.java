package Behawioralne;

import java.io.IOException;

/**
 * Behavioral Design Pattern Command
 **/

public class Polecenie {
    public static void main(String[] args) throws IOException {
        Odbiorca odbiorca = new Odbiorca();
        Nakazanie nakazanie = new SpecyficzneNakazanie(odbiorca);
        ObiektWywolujacy wywolujacy = new ObiektWywolujacy();

        wywolujacy.UstawNakazanie(nakazanie);
        wywolujacy.WykonajNakazanie();

        System.in.read();
    }
}

abstract class Nakazanie {
    protected Odbiorca _odbiorca;
    public Nakazanie(Odbiorca odbiorca) {
        this._odbiorca = odbiorca;
    }
    public abstract void Wykonaj();
}

class Odbiorca {
    public void Uruchom() {
        System.out.println("Wywołano Odbiorca.Uruchom()");
    }
}

class SpecyficzneNakazanie extends Nakazanie {
    public SpecyficzneNakazanie(Odbiorca odbiorca){
        super(odbiorca);
    }

    @Override
    public void Wykonaj() {
        _odbiorca.Uruchom();
    }
}

class ObiektWywolujacy {
    private Nakazanie _nakazanie;

    public void UstawNakazanie(Nakazanie nakazanie) {
        this._nakazanie = nakazanie;
    }

    public void WykonajNakazanie() {
        _nakazanie.Wykonaj();
    }
}