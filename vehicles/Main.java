package vehicles;

public class Main {
    public static void main(String[] args) {
        Bike bike = new Bike(
            2019, 
            "TN072025", 
            "Aryan Iyappan"
        );

        Car car = new Car(
            2015, 
            "TN0112075", 
            "Alston Peter"
        );

        Truck truck = new Truck(
            2015, 
            "TN0132175", 
            "Krithik Peter"
        );

        Vehicle[] vehicles = {
            bike, car, truck
        };

        for (Vehicle elem : vehicles) {
            elem.displayRegistrationDetails();
            elem.startEngine();
            elem.reverse();
        }

        ElectricCar electricCar = new ElectricCar(
            2015, 
            "TN0112075", 
            "Alston Peter"
        );

        electricCar.startEngine();
        electricCar.displayRegistrationDetails();
        electricCar.calculateFuelEfficiency(10, 2);
        electricCar.chargeBattery(5);
        electricCar.showBatteryStatus();
    }
}
