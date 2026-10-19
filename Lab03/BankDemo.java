public class BankDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", "Tendai", 500.00);

        // Transactions
        acc.deposit(250.00);
        acc.withdraw(100.00);
        acc.withdraw(5000.00);   // fails, but is recorded in history

        try {
            acc.deposit(-50);    // throws
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        // Current state
        System.out.println(acc);

        // ---- NEW: print the history ----
        System.out.println("\n--- Transaction history ---");
        for (String entry : acc.getHistory()) {
            System.out.println(entry);
        }

        // ---- NEW: prove the history cannot be modified ----
        System.out.println("\n--- Trying to modify history ---");
        try {
            acc.getHistory().add("HACKED: fake deposit");
        } catch (UnsupportedOperationException e) {
            System.out.println("History is protected: " + e.getClass().getSimpleName());
        }
    }
}