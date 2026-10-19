abstract class Account {
    private final String accountNumber;
    private final String ownerName;
    private double balance;

    Account(String accountNumber, String ownerName, double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = openingBalance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName()     { return ownerName; }
    public double getBalance()       { return balance; }

    // Concrete — shared by all accounts
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
    }

    // Abstract — each subclass charges a different fee
    public abstract double monthlyFee();

    // Concrete — uses the abstract method (template pattern in action)
    public void applyMonthlyFee() {
        double fee = monthlyFee();
        if (fee > balance) {
            System.out.printf("  [%s] fee %.2f exceeds balance %.2f; account would go negative%n",
                accountNumber, fee, balance);
            return;
        }
        balance -= fee;
        System.out.printf("  [%s] fee charged: %.2f -> new balance: %.2f%n",
            accountNumber, fee, balance);
    }

    protected void setBalance(double balance) { this.balance = balance; }
}

class SavingsAccount extends Account {
    private static final double FEE = 15.00;

    SavingsAccount(String accountNumber, String ownerName, double openingBalance) {
        super(accountNumber, ownerName, openingBalance);
    }

    @Override
    public double monthlyFee() { return FEE; }
}

class CurrentAccount extends Account {
    private static final double RATE = 0.005;   // 0.5% of balance

    CurrentAccount(String accountNumber, String ownerName, double openingBalance) {
        super(accountNumber, ownerName, openingBalance);
    }

    @Override
    public double monthlyFee() { return getBalance() * RATE; }
}

public class AccountDemo {
    public static void main(String[] args) {
        Account[] accounts = {
            new SavingsAccount("SAV-001", "Tariro", 500.00),
            new CurrentAccount("CUR-001", "Farai", 10_000.00),
            new SavingsAccount("SAV-002", "Rudo", 8.00)   // too small for fee
        };

        for (Account a : accounts) {
            System.out.printf("%s (%s), balance=%.2f%n",
                a.getAccountNumber(), a.getOwnerName(), a.getBalance());
            a.deposit(100);
            System.out.printf("  after deposit: %.2f%n", a.getBalance());
            a.applyMonthlyFee();
            System.out.println();
        }
    }
}
