package Behawioralne;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Behavioral Design Pattern Visitor
 **/

public class Odwiedzający {
    public static void main(String[] args) throws IOException {
        Struktura struktura = new Struktura();
        struktura.Dolacz(new SpecyficznyElement());
        struktura.Dolacz(new InnySpecyficznyElement());

        SpecyficznyOdwiedzajacy odwiedzajacy1 = new SpecyficznyOdwiedzajacy();
        InnySpecficznyOdwiedzajacy odwiedzajacy2 = new InnySpecficznyOdwiedzajacy();

        struktura.Akceptuj(odwiedzajacy1);
        struktura.Akceptuj(odwiedzajacy2);

        System.in.read();
    }
}

abstract class Element {
    public abstract void Akceptuj(AbstrakcyjnyOdwiedzajacy odwiedzajacy);
}

class SpecyficznyElement extends Element{

    @Override
    public void Akceptuj(AbstrakcyjnyOdwiedzajacy odwiedzajacy) {
        odwiedzajacy.OdwiedzSpecyicznyElement(this);
    }

    public void ZrobCos() {

    }
}

class InnySpecyficznyElement extends Element{

    @Override
    public void Akceptuj(AbstrakcyjnyOdwiedzajacy odwiedzajacy) {
        odwiedzajacy.OdwiedzInnySpecficznyElement(this);
    }

    public void ZrobCos() {

    }
}

abstract class AbstrakcyjnyOdwiedzajacy {
    public abstract void OdwiedzSpecyicznyElement(SpecyficznyElement element);
    public abstract void OdwiedzInnySpecficznyElement(InnySpecyficznyElement element);
}

class SpecyficznyOdwiedzajacy extends AbstrakcyjnyOdwiedzajacy {

    @Override
    public void OdwiedzSpecyicznyElement(SpecyficznyElement element) {
        System.out.println(MessageFormat.format("{0} odwiedzony przez {1}", element.getClass().getSimpleName(), this.getClass().getSimpleName()));
    }

    @Override
    public void OdwiedzInnySpecficznyElement(InnySpecyficznyElement element) {
        System.out.println(MessageFormat.format("{0} odwiedzony przez {1}", element.getClass().getSimpleName(), this.getClass().getSimpleName()));
    }
}

class InnySpecficznyOdwiedzajacy extends AbstrakcyjnyOdwiedzajacy {

    @Override
    public void OdwiedzSpecyicznyElement(SpecyficznyElement element) {
        System.out.println(MessageFormat.format("{0} odwiedzony przez {1}", element.getClass().getSimpleName(), this.getClass().getSimpleName()));
    }

    @Override
    public void OdwiedzInnySpecficznyElement(InnySpecyficznyElement element) {
        System.out.println(MessageFormat.format("{0} odwiedzony przez {1}", element.getClass().getSimpleName(), this.getClass().getSimpleName()));
    }
}

class Struktura {
    private List<Element> elementy = new ArrayList<Element>();

    public void Dolacz(Element element) {
        elementy.add(element);
    }

    public void Odlacz(Element element) {
        elementy.remove(element);
    }

    public void Akceptuj(AbstrakcyjnyOdwiedzajacy odwiedzajacy){
        for (Element element:elementy) {
            element.Akceptuj(odwiedzajacy);
        }
    }
}