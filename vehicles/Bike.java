package vehicles;

public class Bike extends Vehicle implements FuelEfficiency {
    Bike(int yearOfRegistration, String vehicleNumber, String ownersName) {
        super(yearOfRegistration, vehicleNumber, ownersName);
    }
 @Override
 void startEngine () {
    System.out.println("Starting bike...");
 }

 @Override
 void reverse() {
    System.out.println("Reverse cam is not supported...");
    System.out.println("Bike is Taking reverse...");
 }

 public void calculateFuelEfficiency(
    int distanceTravelled, int fuelConsumed
) {
    try {
    int efficiency = (distanceTravelled / fuelConsumed) * 4;
    System.out.println("Efficiency: " + efficiency);   
    } catch (ArithmeticException e) {
        System.out.println("Efficiency could not be calculated!");
    }
}
}
