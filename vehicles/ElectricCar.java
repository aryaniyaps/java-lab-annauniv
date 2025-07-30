package vehicles;

public final class ElectricCar extends Car {
    int charge = 0;
    ElectricCar(int yearOfRegistration, String vehicleNumber, String ownersName) {
        super(yearOfRegistration, vehicleNumber, ownersName);
    }

 @Override
 void startEngine () {
    System.out.println("Starting electric car...");
 }
 
 void chargeBattery(int hours) {
    System.out.println("Charging battery...");
        for (int i = 0; i < hours; i++) {
            if (charge >= 100) return;

            charge += 10;
            
        }
 }

 void showBatteryStatus() {
    System.out.println("Battery status: " + this.charge);
 }
}