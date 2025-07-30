package exceptionhandling;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArraySortingWithExceptions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];

        try {
            System.out.println("Enter 10 integers:");
            for (int i = 0; i < 10; i++) {
                numbers[i] = Integer.parseInt(scanner.nextLine()); // NumberFormatException
            }

            // Sorting the array
            Arrays.sort(numbers);

            // Displaying the sorted array
            System.out.println("Sorted array:");
            for (int i = 0; i <= 10; i++) { // ArrayIndexOutOfBoundsException
                System.out.print(numbers[i] + " ");
            }
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: Please enter valid integers.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: Invalid index access.");
        } finally {
            scanner.close();
        }
    }
}{

}
