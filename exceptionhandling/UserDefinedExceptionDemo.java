package exceptionhandling;

import java.util.Scanner;

// User-defined exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class UserDefinedExceptionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();


        try {
            checkAge(age);
            System.out.println("You are eligible to vote.");
        } catch (InvalidAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Method to check age
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above to vote.");
        }
    }
}{

}
