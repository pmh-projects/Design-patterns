package Strukturalne;

import java.io.IOException;

/**
 * Structural Design Pattern Proxy
 **/

public class Pełnomocnik {
    public static void main(String[] args) throws IOException {

        PelnomocnikFolder pelnomocnik1 = new PelnomocnikFolder("zlehaslo");
        System.out.println(pelnomocnik1.PobierzDane());
        System.out.println("___________________________");

        PelnomocnikFolder pelnomocnik2 = new PelnomocnikFolder("haslo");
        System.out.println(pelnomocnik2.PobierzDane());
        System.out.println("___________________________");

        System.in.read();
    }
}
abstract class Folder {
    public abstract String PobierzDane();
}

class KonkretnyFolder extends Folder {
    private String Dane;

    public KonkretnyFolder() {
        System.out.println("KonkretnyFolder: Uruchomiony");
        Dane = "Bardzo ważne dane";
    }

    @Override
    public String PobierzDane() {
        return Dane;
    }
}

class PelnomocnikFolder extends Folder {
    private KonkretnyFolder _konretnyFolder;
    private boolean _autoryzowany;
    private String _haslo = "haslo";

    public PelnomocnikFolder(String haslo) {
        if(haslo == _haslo) {
            _autoryzowany = true;
            System.out.println("Pełnomocnik: Uruchomiony");
        }
    }


    @Override
    public String PobierzDane() {
        if (_autoryzowany) {
            if (_konretnyFolder == null) {
                _konretnyFolder = new KonkretnyFolder();
            }
            return "Dane z pełnomocnika to " + _konretnyFolder.PobierzDane();
        }
        else {
            return "Pełnomocnik: odmowa dostępu";
        }
    }
}
