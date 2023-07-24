package create;

/**
 * 팩토리패턴
 */
public class Factory02 {

    public static void main(String args[]) {
        Coffee coffe = CoffeFactory.createCoffe(CoffeType.LATTE);
        System.out.print(coffe.getName());
    }

}

enum CoffeType {
    LATTE,
    ESPRESSO
}

abstract class Coffee {
    protected String name;

    public String getName() {
        return name;
    }
}

class Latte extends Coffee {
    public Latte() {
        name = "latte";
    }
}

class Espresso extends Coffee {
    public Espresso() {
        name = "Espresso";
    }
}

class CoffeFactory {
    public static Coffee createCoffe(CoffeType type) {
        switch (type) {
            case LATTE : return new Latte();
            case ESPRESSO: return new Espresso();
            default:
                throw new IllegalArgumentException("Invalid coffe type : " + type);
        }
    }
}