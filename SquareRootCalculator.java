import java.util.*;
public class SquareRootCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String input = scanner.nextLine();
        try {
            double number = Double.parseDouble(input);
            if (number < 0) {
                throw new ArithmeticException("Cannot calculate the square root of a negative number.");
            }
            double squareRoot = Math.sqrt(number);
            System.out.println("The square root of " + number + " is: " + squareRoot);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter a valid number.");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
