package vehicles;

public class Car extends Vehicle implements FuelEfficiency {
    Car(int yearOfRegistration, String vehicleNumber, String ownersName) {
        super(yearOfRegistration, vehicleNumber, ownersName);
    }
 @Override
 void startEngine () {
    System.out.println("Starting car...");
 }

 @Override
 void reverse() {
    System.out.println("Reverse cam is supported...");
    System.out.println("Closeness detection is supported...");
    System.out.println("Car is Taking reverse...");
 }

 public void calculateFuelEfficiency(
    int distanceTravelled, int fuelConsumed
) {
    try {
    int efficiency = (distanceTravelled / fuelConsumed) * 2;
    System.out.println("Efficiency: " + efficiency);   
    } catch (ArithmeticException e) {
        System.out.println("Efficiency could not be calculated!");
    }
}
}
