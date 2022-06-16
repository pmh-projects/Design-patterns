package Konstrukcyjne;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Creational Design Pattern Factory Method
 **/

public class Fabryka {

    public static void main(String[] args) throws Exception {
        
        var pizzerias = new Pizzeria[2];
        pizzerias[0] = new Rogata();
        pizzerias[1] = new Leone();

        for (var pizzeria:pizzerias) {
            var pizza = pizzeria.AddPizza("Pepperoni");

            System.out.println(MessageFormat.format("Utworzono w pizzerii {0} pizzę {1} o składnikach: ", pizzeria.getClass().getSimpleName(), pizza.getClass().getSimpleName()));

            for (var ingredient:pizza.Ingredients) {
                String ingredientTypeValue = "";
                var ingredientType = ingredient.getType();

                if (ingredientType != null) {
                    ingredientTypeValue = ingredientType;
                }

                System.out.println(MessageFormat.format("{0} - {1}: {2}kg",
                        ingredient.getClass().getSimpleName(),
                        ingredientTypeValue,
                        ingredient.Weight ));
            }
        }

        System.in.read();
        
    }
}

abstract class Pizza {

    public List<Ingredient> Ingredients = new ArrayList<Ingredient>();
    public List<Ingredient> getIngredients() {
        return Ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        Ingredients = ingredients;
    }
}

class Margarita extends Pizza {

}

class Pepperoni extends Pizza {

}

abstract class Ingredient
{
    public float Weight;

    public float getWeight() {
        return Weight;
    }

    public void setWeight(float weight) {
        Weight = weight;
    }

    public String Type;
    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
class Cheese extends Ingredient {

}

class Sause extends Ingredient {

}

class Meat extends Ingredient {

}

abstract class Pizzeria {
    public abstract Pizza AddPizza(String name) throws Exception;
}

class Rogata extends Pizzeria {

    public String Name;

    @Override
    public Pizza AddPizza(String name) throws Exception {
        switch (name) {
            case "Pepperoni":
                Cheese cheese = new Cheese() {{Type="Mozarella"; Weight=0.5f;}};
                Meat meat = new Meat() {{Type="Salami Peperoni"; Weight=0.8f;}};
                Pepperoni pepperoni = new Pepperoni();
                pepperoni.Ingredients.add(cheese);
                pepperoni.Ingredients.add(cheese);
                return pepperoni;
            default:
                throw new Exception("Nie ma takiej pizzy");
        }
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

}

class Leone extends Pizzeria {

    public String Name;

    @Override
    public Pizza AddPizza(String name) throws Exception {
        switch (name) {
            case "Pepperoni":
                Cheese cheese = new Cheese() {{Type="Mozarella"; Weight=0.3f;}};
                Meat meat = new Meat() {{Type="Salami Peperoni"; Weight=0.5f;}};
                Pepperoni pepperoni = new Pepperoni();
                pepperoni.Ingredients.add(cheese);
                pepperoni.Ingredients.add(cheese);
                return pepperoni;
            default:
                throw new Exception("Nie ma takiej pizzy");
        }
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

}
