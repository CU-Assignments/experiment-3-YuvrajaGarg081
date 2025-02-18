import java.util.*;
class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
class ATM {
    private String pin = "1234";
    private double balance = 5000;
    public void withdraw(String enteredPin, double withdrawalAmount) throws InvalidPinException, InsufficientBalanceException {
        if (!enteredPin.equals(pin)) {
            throw new InvalidPinException("Error: Invalid PIN entered.");
        }
        if (withdrawalAmount > balance) {
            throw new InsufficientBalanceException("Error: Insufficient balance. Current Balance: " + balance);
        }
        balance -= withdrawalAmount;
        System.out.println("Withdrawal Successful. Remaining Balance: " + balance);
    }
    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

public class ATMWithdrawalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM();
        System.out.print("Enter PIN: ");
        String enteredPin = scanner.nextLine();
        System.out.print("Enter withdrawal amount: ");
        double withdrawalAmount = scanner.nextDouble();
        System.out.println("Before Transaction:");
        atm.displayBalance();
        try {
            atm.withdraw(enteredPin, withdrawalAmount);
        } catch (InvalidPinException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("After Transaction:");
            atm.displayBalance();
        }
        scanner.close();
    }
}
