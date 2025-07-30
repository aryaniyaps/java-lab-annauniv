package daytwo;

class BaseCar {
    String company;
    Integer yearOfManufacturing;
    String name;

    void start() {
        System.out.println(name + " starting.");
        System.out.println("Created by " + company);
        System.out.println(yearOfManufacturing + " model");
        System.out.println("Can recline: " + canRecline());
        System.out.println();
    }

    boolean canRecline() {
        return true;
    }
    
}


class Corolla extends BaseCar {
    public Corolla() {
        company = "Toyota";
        yearOfManufacturing = 2014;
        name = "Corolla";
    }

    @Override
    boolean canRecline() {
        return true;
    }
}


class Thar extends BaseCar {
    public Thar() {
        company = "Mahindra";
        yearOfManufacturing = 2020;
        name = "Thar";
    }

    @Override
    boolean canRecline() {
        return false;
    }
}


public class Car {
    public static void main(String[] args) {
        Corolla car1 = new Corolla();

        Thar car2 = new Thar();

        car1.start();

        car2.start();
    }
}