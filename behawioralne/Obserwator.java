package Behawioralne;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Behavioral Design Pattern Observer
 **/

public class Obserwator {
    public static void main(String[] args) throws IOException {
        Amazon amazon = new Amazon("AWS", 340.00);
        amazon.Dolacz(new Inwestor("Mach"));
        amazon.Dolacz(new Inwestor("Łuniewska"));

        amazon.setCena(220.50);
        amazon.setCena(312.50);
        amazon.setCena(450.50);
        amazon.setCena(340.50);

        System.in.read();
    }
}

interface IInwestor {
    void Aktualizuj(PapierWartosciowy akcja);
}

abstract class PapierWartosciowy {
    private String _symbol;
    private double _cena;
    private List<IInwestor> _inwestorzy = new ArrayList<IInwestor>();

    public PapierWartosciowy(String symbol, double cena) {
        this._symbol = symbol;
        this._cena = cena;
    }

    public void Dolacz(IInwestor inwestor) {
        _inwestorzy.add(inwestor);
    }

    public void Odejdz(IInwestor inwestor) {
        _inwestorzy.remove(inwestor);
    }

    public void Powiadom() {
        for (var inwestor: _inwestorzy) {
            inwestor.Aktualizuj(this);
        }
    }

    public double getCena() {
        return _cena;
    }

    public void setCena(double value) {
        if (_cena != value) {
            this._cena = value;
            Powiadom();
        }
    }

    public String getSymbol() {
        return _symbol;
    }
}

class Amazon extends PapierWartosciowy {
    public Amazon(String symbol, double cena){
        super(symbol, cena);
    }
}

class Inwestor implements IInwestor {

    private String _imie;
    private PapierWartosciowy PapierWartościowy;

    public PapierWartosciowy getPapierWartościowy() {
        return PapierWartościowy;
    }

    public void setPapierWartościowy(PapierWartosciowy papierWartościowy) {
        PapierWartościowy = papierWartościowy;
    }

    public Inwestor(String imie) {
        this._imie = imie;
    }

    public void Aktualizuj(PapierWartosciowy akcja) {
        System.out.println(MessageFormat.format("Poinformowano {0} z {1}, zamiana wynosi {2}", _imie, akcja.getSymbol(), akcja.getCena()));
    }
}

