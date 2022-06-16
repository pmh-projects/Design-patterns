package Konstrukcyjne;

import java.text.MessageFormat;

public class Fabryka_FabrykaDokumentów {
    public static void main(String[] args) throws Exception {
        Sprzedaz[] sprzedaz = new Sprzedaz[2];
        sprzedaz[0] = new SprzedażFirma();
        sprzedaz[1] = new SprzedazIndywiduzalny();

        for (var dokument:sprzedaz) {
            var pozycja = dokument.utworzDokumentSprzedazy();

            System.out.println(MessageFormat.format("Utworzono dokumenty: {0}, liczba: {1}, cena: {2}",
                    dokument.getClass().getSimpleName() + " " + pozycja.Nazwa,
                    pozycja.LiczbaSztuk,
                    pozycja.CenaSztuka
                    ));
        }

        System.in.read();
    }
}

abstract class PozycjaZamowienia {
    public String Nazwa;
    public int LiczbaSztuk;
    public float CenaSztuka;
}

class Pozycja1 extends PozycjaZamowienia { }
class Pozycja2 extends PozycjaZamowienia { }

abstract class Sprzedaz {
    public abstract PozycjaZamowienia utworzDokumentSprzedazy();
}

class SprzedazIndywiduzalny extends Sprzedaz {

    @Override
    public PozycjaZamowienia utworzDokumentSprzedazy() {
        return new Pozycja1(){
            {
                Nazwa = "Laptop";
                LiczbaSztuk = 1;
                CenaSztuka = 5900;
            };
        };
    }
}

class SprzedażFirma extends Sprzedaz {

    @Override
    public PozycjaZamowienia utworzDokumentSprzedazy() {
        return new Pozycja2(){
            {
                Nazwa = "Smartfon";
                LiczbaSztuk = 2;
                CenaSztuka = 1200;
            }
        };
    }
}