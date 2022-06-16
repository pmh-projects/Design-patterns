package Behawioralne;

import java.io.IOException;

/**
 * Behavioral Design Pattern Memento
 **/

public class Pamiątka {
    public static void main(String[] args) throws IOException {
        Inicjator inicjator = new Inicjator();
        inicjator.setStan("Włącz");

        Zarzadzajacy zarzadzajacy = new Zarzadzajacy();
        zarzadzajacy.setMemento(inicjator.UtworzPamiatke());

        inicjator.setStan("Wyłącz");

        inicjator.UstawPamiatke(zarzadzajacy.getMemento());

        System.in.read();
    }
}

class Memento {
    private String _stan;

    public Memento(String stan) {
        _stan = stan;
    }

    public String getStan() {
        return _stan;
    }
}

class Zarzadzajacy {
    private Memento _memento;

    public Memento getMemento() {
        return _memento;
    }

    public void setMemento(Memento value) {
        _memento = value;
    }
}


class Inicjator {
    private String _stan;

    public String getStan() {
        return _stan;
    }

    public void setStan(String stan) {
        _stan = stan;
        System.out.println("Stan = " + _stan);
    }

    public Memento UtworzPamiatke() {
        return new Memento(_stan);
    }

    public void UstawPamiatke(Memento memento) {
        System.out.println("Przywracanie stanu...");
        setStan(memento.getStan());
    }

}

