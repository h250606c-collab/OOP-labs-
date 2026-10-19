abstract class Payment {
    protected final double amount;
    Payment(double amount) { this.amount = amount; }
    public double getAmount() { return amount; }
}

class CardPayment extends Payment {
    private final String cardNumber;
    CardPayment(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }
    public String getCardNumber() { return cardNumber; }
}

class MobileMoneyPayment extends Payment {
    private final String phone;
    MobileMoneyPayment(double amount, String phone) {
        super(amount);
        this.phone = phone;
    }
    public String getPhone() { return phone; }
}

public class PaymentProcessorBad {

    public static void pay(Payment p) {
        if (p instanceof CardPayment c) {
            System.out.printf("Charging card %s for %.2f%n",
                c.getCardNumber(), c.getAmount());
        } else if (p instanceof MobileMoneyPayment m) {
            System.out.printf("Sending %.2f to mobile %s%n",
                m.getAmount(), m.getPhone());
        } else {
            throw new IllegalArgumentException(
                "Unknown payment type: " + p.getClass().getName());
        }
    }

    public static void main(String[] args) {
        Payment[] payments = {
            new CardPayment(100.00, "4111-1111-1111-1111"),
            new MobileMoneyPayment(250.00, "+263 77 123 4567")
        };

        for (Payment p : payments) {
            pay(p);
        }
    }
}
