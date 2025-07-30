package vehicles;

public class Truck extends Vehicle implements FuelEfficiency {
    Truck(int yearOfRegistration, String vehicleNumber, String ownersName) {
        super(yearOfRegistration, vehicleNumber, ownersName);
    }
 @Override
 void startEngine () {
    System.out.println("Starting truck...");
 }

 @Override
 void reverse() {
    System.out.println("Reverse cam is not supported...");
    System.out.println("Car is Taking reverse...");
 }

 public void calculateFuelEfficiency(
    int distanceTravelled, int fuelConsumed
) {
    try {
    int efficiency = (distanceTravelled / fuelConsumed) * 3;
    System.out.println("Efficiency: " + efficiency);   
    } catch (ArithmeticException e) {
        System.out.println("Efficiency could not be calculated!");
    }
}
}
