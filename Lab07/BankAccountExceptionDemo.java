// Checked exception: extends Exception, so callers MUST handle it
class InsufficientFundsException extends Exception {
    private final double shortfall;

    InsufficientFundsException(double shortfall) {
        super(String.format("Insufficient funds: short by %.2f", shortfall));
        this.shortfall = shortfall;
    }

    public double getShortfall() { return shortfall; }
}

class BankAccount {
    private final String accountNumber;
    private final String ownerName;
    private double balance;

    BankAccount(String accountNumber, String ownerName, double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = openingBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
    }

    // CHANGED: no longer returns boolean; now throws if insufficient
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundsException(amount - balance);
        }
        balance -= amount;
    }

    public double getBalance() { return balance; }

    @Override
    public String toString() {
        return String.format("%s [%s] balance: %.2f", accountNumber, ownerName, balance);
    }
}

public class BankAccountExceptionDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", "Tendai", 500.00);

        try {
            acc.deposit(250);
            System.out.println("After deposit: " + acc);

            acc.withdraw(100);
            System.out.println("After withdraw 100: " + acc);

            acc.withdraw(5000);   // throws
            System.out.println("NEVER REACHED");
        } catch (InsufficientFundsException e) {
            System.out.println("Caught: " + e.getMessage());
            System.out.println("  shortfall = " + e.getShortfall());
        }

        System.out.println("Final: " + acc);
    }
}