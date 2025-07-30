package vehicles;

public abstract class Vehicle {
    final int yearOfRegistration;
    String vehicleNumber;
    public static int vehiclesCreated;
    String ownersName;

    public Vehicle(int yearOfRegistration, String vehicleNumber, String ownersName) {
        this.vehiclesCreated ++;
        this.yearOfRegistration = yearOfRegistration;
        this.vehicleNumber = vehicleNumber;
        this.ownersName = ownersName;
    }

    abstract void startEngine();

    abstract void reverse();

    final public void displayRegistrationDetails() {
        System.out.println("Registration details");
        System.out.println("Registration number: " + vehicleNumber);
        System.out.println("Year of Registration: " + yearOfRegistration);
        System.out.println("Owner's name: " + ownersName);
    }
}