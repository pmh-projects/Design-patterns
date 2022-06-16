package Behawioralne;

import java.io.IOException;

/**
 * Behavioral Design Pattern Strategy
 **/

public class Strategia {
    public static void main(String[] args) throws IOException {
        KontekstStrategia kontekst;

        kontekst = new KontekstStrategia(new SpecyficznaStrategiaA());
        kontekst.ZwrocProblem();

        kontekst = new KontekstStrategia(new SpecyficznaStrategiaB());
        kontekst.ZwrocProblem();

        System.in.read();
    }
}

abstract class AbstrakcyjnaStrategia {
    public abstract void RozwiazProblem();
}

class SpecyficznaStrategiaA extends AbstrakcyjnaStrategia {

    @Override
    public void RozwiazProblem() {
        System.out.println("Wywolano SpecyficznaStrategiaA.RozwiazProblem()");
    }
}

class SpecyficznaStrategiaB extends AbstrakcyjnaStrategia {

    @Override
    public void RozwiazProblem() {
        System.out.println("Wywołano SpecyficznaStrategiaB.RozwiazProblem()");
    }
}

class KontekstStrategia {
    private AbstrakcyjnaStrategia _strategia;

    protected KontekstStrategia(AbstrakcyjnaStrategia strategia) {
        this._strategia = strategia;
    }

    public void ZwrocProblem() {
        _strategia.RozwiazProblem();
    }
}