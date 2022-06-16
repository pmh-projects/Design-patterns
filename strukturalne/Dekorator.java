package Strukturalne;

import java.io.IOException;

/**
 * Structural Design Pattern Decorator
 **/

public class Dekorator {
    public static void main(String[] args) throws IOException {
        Produkt p = new Produkt();
        DekoratorA dekoratorA = new DekoratorA();
        DekoratorB dekoratorB = new DekoratorB();

        dekoratorB.UstawKomponent(p);
        System.out.println("______________________");

        dekoratorA.UstawKomponent(dekoratorB);
        System.out.println("______________________");

        dekoratorA.Operacja();
        System.out.println("______________________");

        System.in.read();
    }
}

abstract class Komponent {
    public abstract void Operacja();
}

class Produkt extends Komponent {

    @Override
    public void Operacja() {
        System.out.println("Produkt.Operacja()");
    }
}

 abstract class DekoratorKomponent extends Komponent {
    protected Komponent _komponent;

    public void UstawKomponent(Komponent komponent) {
        this._komponent = komponent;
    }

     @Override
     public void Operacja() {
         if (_komponent != null) {
             _komponent.Operacja();
         }
     }
 }

 class DekoratorA extends DekoratorKomponent {
     @Override
     public void Operacja() {
         super.Operacja();
         DodanaFunkcjonalnosc();
         System.out.println("DekoratorA.Operacja()");
     }

     void DodanaFunkcjonalnosc() {
         System.out.println("Wywołano dodatkową funkcjonalność z dekoratora A");
     }
 }

 class DekoratorB extends DekoratorKomponent {
     @Override
     public void Operacja() {
         super.Operacja();
         System.out.println("DekoratorB.Operacja()");
     }
 }

