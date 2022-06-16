package Strukturalne;

import java.io.IOException;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

/**
 * Structural Design Pattern Flyweight
 **/

public class Pyłek {
    public static void main(String[] args) throws IOException {
        int daneZewnetrzne = 42;

        FabrykaPylkow fabrykaPylkow = new FabrykaPylkow();

        SpecyficznyPylek fq = (SpecyficznyPylek) fabrykaPylkow.GetPylek("Q");
        fq.PrzykladowaMetoda(--daneZewnetrzne);

        SpecyficznyPylek fw = (SpecyficznyPylek) fabrykaPylkow.GetPylek("W");
        fw.PrzykladowaMetoda(--daneZewnetrzne);

        SpecyficznyPylek fe = (SpecyficznyPylek) fabrykaPylkow.GetPylek("E");
        fe.PrzykladowaMetoda(--daneZewnetrzne);

        System.in.read();
    }
}

abstract class AbstrakcyjnyPylek {
    public abstract void PrzykladowaMetoda(int daneZewnetrzne);
}

class SpecyficznyPylek extends AbstrakcyjnyPylek {

    @Override
    public void PrzykladowaMetoda(int daneZewnetrzne) {
        System.out.println("SpecyficznyPylek: " + daneZewnetrzne);
    }
}

class FabrykaPylkow {
    private Map<String, Object> pylki = new HashMap<String, Object>();

    public FabrykaPylkow() {
        pylki.put("Q", new SpecyficznyPylek());
        pylki.put("W", new SpecyficznyPylek());
        pylki.put("E", new SpecyficznyPylek());
    }

    public AbstrakcyjnyPylek GetPylek(String key) {
        return ((AbstrakcyjnyPylek) pylki.get(key));
    }
}
