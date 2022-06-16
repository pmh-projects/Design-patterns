package Strukturalne;

import java.io.IOException;

/**
 * Structural Design Pattern Facade
 **/

public class Fasada {
    public static void main(String[] args) throws IOException {
        FasadaPodsystemow fasada = new FasadaPodsystemow();
        fasada.MetodaA();
        fasada.MetodaB();

        System.in.read();
    }
}

class PodsystemPierwszy {
    public void MetodaPierwsza() {
        System.out.println("PodsystemPierwszy MetodaPierwsza");
    }
}

class PodsystemDrugi {
    public void MetodaDruga() {
        System.out.println("PodsystemDrugi MetodaDruga");
    }
}

class PodsystemTrzeci {
    public void MetodaTrzecia(){
        System.out.println("PodsystemTrzeci MetodaTrzecia");
    }
}

class PodsystemCzwarty {
    public void MetodaCzwarta() {
        System.out.println("PodsystemCzwarty MetodaCzwarta");
    }
}

class FasadaPodsystemow {
    private PodsystemPierwszy podsystemPierwszy;
    private PodsystemDrugi podsystemDrugi;
    private PodsystemTrzeci podsystemTrzeci;
    private PodsystemCzwarty podsystemCzwarty;

    public FasadaPodsystemow() {
        podsystemPierwszy = new PodsystemPierwszy();
        podsystemDrugi = new PodsystemDrugi();
        podsystemTrzeci = new PodsystemTrzeci();
        podsystemCzwarty = new PodsystemCzwarty();
    }

    public void MetodaA() {
        System.out.println("MetodaA() ---");
        podsystemPierwszy.MetodaPierwsza();
        podsystemDrugi.MetodaDruga();
        podsystemCzwarty.MetodaCzwarta();
    }

    public void MetodaB() {
        System.out.println("MetodaB() ---");
        podsystemDrugi.MetodaDruga();
        podsystemTrzeci.MetodaTrzecia();
    }
}