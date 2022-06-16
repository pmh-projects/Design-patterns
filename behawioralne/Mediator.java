package Behawioralne;

import java.io.IOException;

/**
 * Behavioral Design Pattern Mediator
 **/

class Program {
    public static void main(String[] args) throws IOException {
        SpecyficznyMediator mediator = new SpecyficznyMediator();

        SpecyficznyObiekt1 obiekt1 = new SpecyficznyObiekt1(mediator);
        SpecyficznyObiekt2 obiekt2 = new SpecyficznyObiekt2(mediator);

        mediator.setWspolpracownik1(obiekt1);
        mediator.setWspolpracownik2(obiekt2);

        obiekt1.Wyslij("Poproszę banana i jabłko");
        obiekt2.Wyslij("Niestety nie ma banana");
        obiekt1.Wyslij("W takim razie jabłko wystarczy");
        obiekt2.Wyslij("Proszę");
        obiekt1.Wyslij("Dziękuję");

        System.in.read();
        
    }
}
abstract class Mediator {
    public abstract void Wyslij(String wiadomosc, ObiektWspolpracownika wspolpracownik);
}

abstract class ObiektWspolpracownika {
    protected Mediator _mediator;

    public ObiektWspolpracownika(Mediator mediator){
        this._mediator = mediator;
    }
}

class SpecyficznyObiekt1 extends ObiektWspolpracownika {
    public SpecyficznyObiekt1(Mediator mediator){
        super(mediator);
    }

    public void Wyslij(String wiadomosc) {
        _mediator.Wyslij(wiadomosc, this);
    }

    public void Powiadom(String wiadomosc){
        System.out.println("SpecyficznyObiekt1 dostaje wiadomoc: " + wiadomosc);
    }
}

class SpecyficznyObiekt2 extends ObiektWspolpracownika {
    public SpecyficznyObiekt2(Mediator mediator) {
        super(mediator);
    }

    public void Wyslij(String wiadomosc){
        _mediator.Wyslij(wiadomosc, this);
    }

    public void Powiadom(String wiadmosc) {
        System.out.println("SpecyficznyObiekt2 dostaje wiadomosc: " + wiadmosc);
    }
}

class SpecyficznyMediator extends Mediator {
    private SpecyficznyObiekt1 _wspolpracownik1;
    private SpecyficznyObiekt2 _wspolpracownik2;

    public void setWspolpracownik1(SpecyficznyObiekt1 _wspolpracownik1) {
        this._wspolpracownik1 = _wspolpracownik1;
    }

    public void setWspolpracownik2(SpecyficznyObiekt2 _wspolpracownik2) {
        this._wspolpracownik2 = _wspolpracownik2;
    }

    @Override
    public void Wyslij(String wiadomosc, ObiektWspolpracownika wspolpracownik) {
        if (wspolpracownik == _wspolpracownik1) {
            _wspolpracownik2.Powiadom(wiadomosc);
        }
        else {
            _wspolpracownik1.Powiadom(wiadomosc);
        }
    }
}