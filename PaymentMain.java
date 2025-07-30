abstract class Payment {
    public abstract void pay(double amount);

    public void showPaymentType() {
        System.err.println("Generic payment method");
    }
}

class CreditCardPayment extends Payment {
    @Override
    public void pay(double amount) {
        System.err.println("Paid " + amount + " using credit card");
    }
}

public class PaymentMain {
    public static void main(String[] args) {
        Payment p = new CreditCardPayment();
        p.showPaymentType();
        p.pay(1500.75);
    }   
}
