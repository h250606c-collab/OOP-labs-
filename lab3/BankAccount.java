import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccount {

    private final String accountNumber;
    private String ownerName;
    private double balance;
    private final List<String> history = new ArrayList<>();

    public BankAccount(String accountNumber, String ownerName, double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        setOwnerName(ownerName);
        this.balance = openingBalance;
        history.add("OPEN: " + String.format("%.2f", openingBalance));
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName()     { return ownerName; }
    public double getBalance()       { return balance; }

    // GOOD: unmodifiable view -> caller cannot modify our internal list
    public List<String> getHistory() {
        return Collections.unmodifiableList(history);
    }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException("Owner name required");
        }
        this.ownerName = ownerName.trim();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
        history.add(String.format("DEPOSIT %.2f -> balance %.2f", amount, balance));
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive");
        }
        if (amount > balance) {
            history.add(String.format("FAILED WITHDRAW %.2f (insufficient)", amount));
            return false;
        }
        balance -= amount;
        history.add(String.format("WITHDRAW %.2f -> balance %.2f", amount, balance));
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s [%s] balance: %.2f", accountNumber, ownerName, balance);
    }
}