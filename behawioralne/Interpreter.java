package Behawioralne;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Behavioral Design Pattern Interpreter
 **/

public class Interpreter {
    public static void main(String[] args) throws IOException {

        Kontekst kontekst = new Kontekst();

        ArrayList wyrazenia = new ArrayList();

        wyrazenia.add(new WyrazenieTerminalne());
        wyrazenia.add(new WyrazenieNieterminalne());
        wyrazenia.add(new WyrazenieTerminalne());
        wyrazenia.add(new WyrazenieTerminalne());

        for (var wyrazenie:wyrazenia) {
            ((WyrazenieAbstrakcyjne)wyrazenie).Interpretuj(kontekst);
        }
    }
}

class Kontekst {

}

abstract class WyrazenieAbstrakcyjne {
    public abstract void Interpretuj(Kontekst kontekst);
}

class WyrazenieTerminalne extends WyrazenieAbstrakcyjne {
    @Override
    public void Interpretuj(Kontekst kontekst) {
        System.out.println("Wywołano WyrazenieTerminalne.Interpretuj");
    }
}

class WyrazenieNieterminalne extends WyrazenieAbstrakcyjne {
    @Override
    public void Interpretuj(Kontekst kontekst) {
        System.out.println("Wywołano WyrazenieNieterminalne.Interpretuj()");
    }
}