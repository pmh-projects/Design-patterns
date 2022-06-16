package Konstrukcyjne;

import java.io.Console;
import java.io.IOException;

/**
 * Creational Design Pattern Builder
 **/

public class Budowniczy {
    public static void main(String[] args) throws IOException {
        KreatorOdtwarzaczaHTML kreatorOdtwarzaczaHTML = new KreatorOdtwarzaczaHTML();
        KreatorOdtwarzaczaFlash kreatorOdtwarzaczaFlash = new KreatorOdtwarzaczaFlash();
        Generator generator = new Generator();
        Odtwarzacz odtwarzacz;

        generator.Skladaj(kreatorOdtwarzaczaHTML);
        kreatorOdtwarzaczaHTML
                .ZwrocOdtwarzacz()
                .Pokaz();

        generator.Skladaj(kreatorOdtwarzaczaFlash);
        kreatorOdtwarzaczaFlash
                .ZwrocOdtwarzacz()
                .Pokaz();

        System.in.read();
    }
}

class Odtwarzacz {
    private String _nazwa;

    public void UstawNazwe(String nazwa){
        _nazwa = nazwa;
    }

    public void Pokaz() {
        System.out.println("\n" + _nazwa);
    }
}

abstract class BudowniczyOdtwarzaczy {
    public abstract void ZbudujOdtwarzacz();
    public abstract Odtwarzacz ZwrocOdtwarzacz();
}

class KreatorOdtwarzaczaFlash extends BudowniczyOdtwarzaczy {
    private Odtwarzacz _odtwarzacz;

    public KreatorOdtwarzaczaFlash() {
        _odtwarzacz = new Odtwarzacz();
    }

    @Override
    public void ZbudujOdtwarzacz() {
        _odtwarzacz.UstawNazwe("Odtwarzacz Flash");
    }

    @Override
    public Odtwarzacz ZwrocOdtwarzacz() {
        return _odtwarzacz;
    }
}

class KreatorOdtwarzaczaHTML extends BudowniczyOdtwarzaczy {
    private Odtwarzacz _odtwarzacz;

    public KreatorOdtwarzaczaHTML() {
        _odtwarzacz = new Odtwarzacz();
    }

    @Override
    public void ZbudujOdtwarzacz() {
        _odtwarzacz.UstawNazwe("Odtwarzacz HTML");
    }

    @Override
    public Odtwarzacz ZwrocOdtwarzacz() {
        return _odtwarzacz;
    }
}

class Generator {

    public void Skladaj(BudowniczyOdtwarzaczy budowniczyOdtwarzaczy) {
        budowniczyOdtwarzaczy.ZbudujOdtwarzacz();
    }
}