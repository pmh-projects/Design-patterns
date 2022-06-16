package Behawioralne;

import java.io.IOException;
import java.text.MessageFormat;

/**
 * Behavioral Design Pattern Chain od Responsibility
 **/

public class ŁańcuchZobowiązań {
    public static void main(String[] args) throws IOException {
        AbstrakcyjnaObsluga obsluga1 = new SpecyficznaObsluga1();
        AbstrakcyjnaObsluga obsluga2 = new SpecyficznaObsluga2();

        obsluga1.UstawNastepce(obsluga2);

        int[] zobowiazania = {4 , 6, 13, 23, 54, 1, 34, 19, 12, 8};

        for (int zobowiazanie:zobowiazania) {
            obsluga1.Obsluz(zobowiazanie);
        }

        System.in.read();
    }
}

abstract class AbstrakcyjnaObsluga {
    protected AbstrakcyjnaObsluga nastepca;

    public void UstawNastepce(AbstrakcyjnaObsluga nastepca) {
        this.nastepca = nastepca;
    }

    public abstract void Obsluz(int zobowiazanie);
}

class SpecyficznaObsluga1 extends AbstrakcyjnaObsluga {

    @Override
    public void Obsluz(int zobowiazanie) {
        if (zobowiazanie >= 0 && zobowiazanie < 10) {
            System.out.println(MessageFormat.format("{0} Obsłużono zobowiązanie {1}", this.getClass().getSimpleName(), zobowiazanie));
        }
        else if (nastepca != null){
            nastepca.Obsluz(zobowiazanie);
        }
    }
}

class SpecyficznaObsluga2 extends AbstrakcyjnaObsluga {

    @Override
    public void Obsluz(int zobowiazanie) {
        if (zobowiazanie >= 10 && zobowiazanie < 20) {
            System.out.println(MessageFormat.format("{0} Obsłużono zobowiązanie {1}", this.getClass().getSimpleName(), zobowiazanie));
        }
        else if (nastepca != null){
            nastepca.Obsluz(zobowiazanie);
        }
    }
}