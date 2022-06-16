package Konstrukcyjne;

import java.io.IOException;

/**
 * Creational Design Pattern Abstract Factory
 **/

public class FabrykaAbstrakcyjna {
    public static void main(String[] args) throws Exception {
        FabrykaJednostekWOjskowych malachitowaFabryka = new MalachitowaFabryka();
        FabrykaJednostekWOjskowych amarantowaFabryka = new AmarantowaFabryka();

        NaziemnaJednostka malachitowyCzolg = malachitowaFabryka.stworzNaziemnaJednostke(JednostkaTyp.CZOLG);
        PieszaJednostka malachitowyWojskowy = malachitowaFabryka.stworzPieszaJednostke(JednostkaTyp.STRZELEC);
        PowietrznaJednostka malachitowHelikopter = malachitowaFabryka.stworzPowietrznaJednostke(JednostkaTyp.HELIKOPTER);

        NaziemnaJednostka amarantowyCzolg = amarantowaFabryka.stworzNaziemnaJednostke(JednostkaTyp.CZOLG);
        PieszaJednostka amarantowyWojskowy = amarantowaFabryka.stworzPieszaJednostke(JednostkaTyp.STRZELEC);
        PowietrznaJednostka amarantowyHelikopter = amarantowaFabryka.stworzPowietrznaJednostke(JednostkaTyp.HELIKOPTER);

        System.out.println("Malachitowy czołg - życie: ");
        System.out.println(malachitowyCzolg.zycie);

        System.out.println("Amarantowy czołg - życie: ");
        System.out.println(amarantowyCzolg.zycie);

        System.out.println("Malachitowy wojskowy - siła zniszczeń: ");
        System.out.println(malachitowyWojskowy.silaZniszczen);

        System.out.println("Amarantowy wojskowy - siła zniszczeń: ");
        System.out.println(amarantowyWojskowy.silaZniszczen);

        System.out.println("Malachitowy helikopter - doświadczenie: ");
        System.out.println(malachitowHelikopter.doswiadczenie);

        System.out.println("Amarantowy helikopter - doświadczenie: ");
        System.out.println(malachitowHelikopter.doswiadczenie);
    }

}

enum JednostkaTyp {
    STRZELEC,
    CZOLG,
    HELIKOPTER
}

//fabryka abstrakcyjna
abstract class FabrykaJednostekWOjskowych {
    public abstract PieszaJednostka stworzPieszaJednostke(JednostkaTyp typ) throws IOException;
    public abstract NaziemnaJednostka stworzNaziemnaJednostke(JednostkaTyp typ) throws IOException;
    public abstract PowietrznaJednostka stworzPowietrznaJednostke(JednostkaTyp typ) throws IOException;
}

//fabryki:

class MalachitowaFabryka extends FabrykaJednostekWOjskowych {

    @Override
    public PieszaJednostka stworzPieszaJednostke(JednostkaTyp typ) throws IOException {
        switch (typ)
        {
            case STRZELEC:
                return new Strzelec(25, 0, 5);
            default:
                throw new IOException("Nieznany typ");
        }
    }

    @Override
    public NaziemnaJednostka stworzNaziemnaJednostke(JednostkaTyp typ) throws IOException {
        switch (typ)
        {
            case CZOLG:
                return new Czolg(100, 0, 25);
            default:
                throw new IOException("Nieznany typ");
        }
    }

    @Override
    public PowietrznaJednostka stworzPowietrznaJednostke(JednostkaTyp typ) throws IOException {
        switch (typ)
        {
            case HELIKOPTER:
                return new Helikopter(50, 0, 25);
            default:
                throw new IOException("Nieznany typ");
        }
    }
}

class AmarantowaFabryka extends FabrykaJednostekWOjskowych {

    @Override
    public PieszaJednostka stworzPieszaJednostke(JednostkaTyp typ) throws IOException {
        switch (typ)
        {
            case STRZELEC:
                return new Strzelec(80, 0, 500);
            default:
                throw new IOException("Nieznany typ");
        }
    }

    @Override
    public NaziemnaJednostka stworzNaziemnaJednostke(JednostkaTyp typ) throws IOException {
        switch (typ)
        {
            case CZOLG:
                return new Czolg(200, 0, 8990);
            default:
                throw new IOException("Nieznany typ");
        }
    }

    @Override
    public PowietrznaJednostka stworzPowietrznaJednostke(JednostkaTyp typ) throws IOException {
        switch (typ)
        {
            case HELIKOPTER:
                return new Helikopter(440, 0, 335);
            default:
                throw new IOException("Nieznany typ");
        }
    }
}

abstract class NaziemnaJednostka
{
    protected NaziemnaJednostka(int zycie, int doswiadczenie, int silaZniszczen)
    {
        this.zycie = zycie;
        this.doswiadczenie = doswiadczenie;
        this.silaZniszczen = silaZniszczen;
    }

    public int zycie;

    public int doswiadczenie;

    public int silaZniszczen;
}

abstract class PowietrznaJednostka
{
    protected PowietrznaJednostka(int zycie, int doswiadczenie, int silaZniszczen)
    {
        this.zycie = zycie;
        this.doswiadczenie = doswiadczenie;
        this.silaZniszczen = silaZniszczen;
    }

    public int zycie;

    public int doswiadczenie;

    public int silaZniszczen;
}

abstract class PieszaJednostka
{
    protected PieszaJednostka(int zycie, int doswiadczenie, int silaZniszczen)
    {
        this.zycie = zycie;
        this.doswiadczenie = doswiadczenie;
        this.silaZniszczen = silaZniszczen;
    }

    public int zycie;

    public int doswiadczenie;

    public int silaZniszczen;
}

class Strzelec extends PieszaJednostka {
    protected Strzelec(int zycie, int doswiadczenie, int silaZniszczen)
    {
        super(zycie, doswiadczenie, silaZniszczen);
    }
}

class Czolg extends NaziemnaJednostka {
    protected Czolg(int zycie, int doswiadczenie, int silaZniszczen)
    {
        super(zycie, doswiadczenie, silaZniszczen);
    }
}

class Helikopter extends PowietrznaJednostka {
    protected Helikopter(int zycie, int doswiadczenie, int silaZniszczen)
    {
        super(zycie, doswiadczenie, silaZniszczen);
    }
}
