package exceptionhandling;

public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        int[] numbers = { 10, 20, 30, 40, 50 };

        try {
            // ArithmeticException demonstration
            int result = numbers[2] / 0; // Division by zero
            System.out.println("Result: " + result);

            // ArrayIndexOutOfBoundsException demonstration
            System.out.println("Accessing invalid index: " + numbers[10]);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        }
    }