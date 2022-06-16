package Konstrukcyjne;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Dictionary;
import java.util.HashMap;

/**
 * Creational Design Pattern Prototype
 **/

public class Prototyp {
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        KolorSerwis kolorSerwis = new KolorSerwis();

        //Inicjalizacja standardowych kolorów
        kolorSerwis.set("czerwony", new Kolor(255, 0, 0));
        kolorSerwis.set("zielony", new Kolor(0,255,0));
        kolorSerwis.set("niebieski", new Kolor(0, 0, 255));

        //Dodanie spersonalizowanych kolorów użytkowników
        kolorSerwis.set("piekny", new Kolor(255, 53, 1));
        kolorSerwis.set("piekniejszy", new Kolor(128, 210, 127));
        kolorSerwis.set("najpiekniejszy", new Kolor(211, 33, 19));

        KolorPrototyp kolor1 = kolorSerwis.get("zielony").Klonuj();
        KolorPrototyp kolor2 = kolorSerwis.get("piekny").Klonuj();
        KolorPrototyp kolor3 = kolorSerwis.get("najpiekniejszy").Klonuj();

        System.in.read();
    }
}

abstract class KolorPrototyp {
    public abstract  KolorPrototyp Klonuj() throws CloneNotSupportedException;
}

class Kolor extends KolorPrototyp implements Cloneable{
    private int _red;
    private int _green;
    private int _blue;

    public Kolor(int red, int green, int blue) {
        _red = red;
        _green = green;
        _blue = blue;
    }

    @Override
    public KolorPrototyp Klonuj() throws CloneNotSupportedException {
        System.out.println(MessageFormat.format("Klonowanie koloru RGB: {0}, {1}, {2}", _red, _green, _blue));

        return (Kolor) this.clone();
    }
}

class KolorSerwis {
    private HashMap<String, KolorPrototyp> _kolory = new HashMap<String, KolorPrototyp>();

    public KolorPrototyp get(String key) {
        return  _kolory.get(key);
    }
    public void set(String key, KolorPrototyp value){
        _kolory.put(key, value);
    }
}
