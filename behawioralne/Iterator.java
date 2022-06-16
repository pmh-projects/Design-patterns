package Behawioralne;

import javax.management.ObjectName;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Behavioral Design Pattern Iterator
 **/

public class Iterator {
    public static void main(String[] args) throws IOException {
        ManagerImion managerImion = new ManagerImion();
        managerImion.set(0, "Piotr");
        managerImion.set(1, "Jan");
        managerImion.set(2, "Daria");
        managerImion.set(3, "Paweł");
        managerImion.set(4, "Ania");

        AbstrakcyjnyIterator iterator = managerImion.StworzIterator();
        System.out.println("Iteracja kolejki:");

        Object element = iterator.Pierwszy();
        while (element != null) {
            System.out.println(element);
            element = iterator.Nastepny();
        }

        System.in.read();
    }
}

abstract class AbstrakcyjnyIterator {
    public abstract Object Pierwszy();
    public abstract Object Nastepny();
    public abstract boolean CzyKoniec();
    public abstract Object PobierzElement();
}

abstract class Manager {
    public abstract AbstrakcyjnyIterator StworzIterator();
}

class ManagerImion extends Manager {

    private List _elementy = new ArrayList();

    @Override
    public AbstrakcyjnyIterator StworzIterator() {
        return new ManagerImionIterator(this);
    }

    public int getIlosc() {
        return _elementy.size();
    }

    public Object get(int index) {
        return _elementy.get(index);
    }

    public void set(int index, Object value) {
        _elementy.add(index, value);
    }
}

class ManagerImionIterator extends AbstrakcyjnyIterator {
    private ManagerImion _kontener;
    private int _obecny = 0;

    public ManagerImionIterator(ManagerImion kontener) {
        _kontener = kontener;
    }


    @Override
    public Object Pierwszy() {
        return _kontener.get(0);
    }

    @Override
    public Object Nastepny() {
        Object ret = null;
        if (_obecny < _kontener.getIlosc() - 1)
        {
            ret = _kontener.get(++_obecny);
        }

        return ret;
    }

    @Override
    public boolean CzyKoniec() {
        return _obecny >= _kontener.getIlosc();
    }

    @Override
    public Object PobierzElement() {
        return _kontener.get(_obecny);
    }
}

