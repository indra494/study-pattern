package create;

/**
 * 팩토리패턴
 */
public class Factory01 {

    public static void main(String args[]) {
        CarFactory bmwFactory = new BmwCarFactory();
        Car firstCar = bmwFactory.create("indra");
        firstCar.carBreak();
        firstCar.carExcel();

        CarFactory hyunCarFactory = new HyunCarFactory();
        Car secondCar = hyunCarFactory.create("indra02");
        secondCar.carBreak();
        secondCar.carExcel();
    }
}

abstract class Car {
    abstract void carExcel();
    abstract void carBreak();
}

abstract class CarFactory {
    public final Car create(String name) {
        Car car = carMake(name);
        return car;
    }
    protected abstract Car carMake(String name);
}

class BmwCar extends Car {
    private String name;
    BmwCar(String name) {
        this.name = name;
    }

    @Override
    void carBreak() {
        System.out.println("## " + name + "님의 bmw차가 브레이크를 밟았습니다.");
    }

    @Override
    void carExcel() {
        System.out.println("## " + name + "님의 bmw차가 엑셀을 밟았습니다.");
    }
}

class BmwCarFactory extends CarFactory {
    @Override
    protected Car carMake(String name) {
        return new BmwCar(name);
    }
}


class HyunCar extends Car {
    private String name;
    HyunCar(String name) {
        this.name = name;
    }

    @Override
    void carBreak() {
        System.out.println("## " + name + "님의 Hyun차가 브레이크를 밟았습니다.");
    }

    @Override
    void carExcel() {
        System.out.println("## " + name + "님의 Hyun차가 엑셀을 밟았습니다.");
    }
}

class HyunCarFactory extends CarFactory {
    @Override
    protected Car carMake(String name) {
        return new HyunCar(name);
    }
}