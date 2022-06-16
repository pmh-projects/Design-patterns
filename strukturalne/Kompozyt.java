package Strukturalne;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Structural Design Pattern Composite
 **/

public class Kompozyt {
    public static void main(String[] args) throws IOException {
        KompozytDzieci root  = new KompozytDzieci("root");
        root.Dodaj(new Lisc("Liść A"));
        root.Dodaj(new Lisc("Liść B"));

        KompozytDzieci comp = new KompozytDzieci("Kompozyt X");
        comp.Dodaj(new Lisc("Liść AX"));
        comp.Dodaj(new Lisc("Liść XB"));

        root.Dodaj(comp);
        root.Dodaj(new Lisc("Liść C"));

        Lisc leaf = new Lisc("Liść D");
        root.Dodaj(leaf);
        root.Usun(leaf);

        root.Pokaz(1);

        System.in.read();
    }
}

abstract class Element {
    protected String nazwa;

    public Element(String nazwa) {
        this.nazwa = nazwa;
    }

    public abstract void Dodaj(Element c);
    public abstract void Usun(Element c);
    public abstract void Pokaz(int poziom);
}

class KompozytDzieci extends Element {
    private List<Element> _dzieci = new ArrayList<Element>();
    String dash = "-";

    public KompozytDzieci(String nazwa) {
        super(nazwa);
    }

    @Override
    public void Dodaj(Element element) {
        _dzieci.add(element);
    }

    @Override
    public void Usun(Element element) {
        _dzieci.remove(element);
    }

    @Override
    public void Pokaz(int poziom) {
        System.out.println(dash.repeat(poziom) + nazwa);

        for (Element element:_dzieci) {
            element.Pokaz(poziom+2);
        }
    }
}

class Lisc extends Element {

    String dash = "-";

    public Lisc(String nazwa) {
        super(nazwa);
    }

    @Override
    public void Dodaj(Element c) {
        System.out.println("Nie mozna dodac liscia");
    }

    @Override
    public void Usun(Element c) {
        System.out.println("Nie można usunac liscia");
    }

    @Override
    public void Pokaz(int poziom) {
        System.out.println(dash.repeat(poziom) + nazwa);
    }
}