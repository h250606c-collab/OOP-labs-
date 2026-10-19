abstract class Payment {
    protected final double amount;
    Payment(double amount) { this.amount = amount; }
    public double getAmount() { return amount; }

    // Every subclass MUST say how to process itself
    public abstract void process();
}

class CardPayment extends Payment {
    private final String cardNumber;
    CardPayment(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }
    @Override
    public void process() {
        System.out.printf("Charging card %s for %.2f%n",
            cardNumber, getAmount());
    }
}

class MobileMoneyPayment extends Payment {
    private final String phone;
    MobileMoneyPayment(double amount, String phone) {
        super(amount);
        this.phone = phone;
    }
    @Override
    public void process() {
        System.out.printf("Sending %.2f to mobile %s%n",
            getAmount(), phone);
    }
}

// Adding a new type later = just write this class. No edits to anything else.
class CryptoPayment extends Payment {
    private final String wallet;
    CryptoPayment(double amount, String wallet) {
        super(amount);
        this.wallet = wallet;
    }
    @Override
    public void process() {
        System.out.printf("Broadcasting %.2f to wallet %s%n",
            getAmount(), wallet);
    }
}

public class PaymentProcessorGood {
    public static void main(String[] args) {
        Payment[] payments = {
            new CardPayment(100.00, "4111-1111-1111-1111"),
            new MobileMoneyPayment(250.00, "+263 77 123 4567"),
            new CryptoPayment(500.00, "0xABCDEF")
        };

        for (Payment p : payments) {
            p.process();     // dynamic dispatch — no instanceof anywhere
        }
    }
}
