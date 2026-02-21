package java;

public class CreditCardPayment extends AbstractPayment{

    private String cardNumber;
    private String cardHolder;
    

    public CreditCardPayment(
        String cardNumber,
        String cardHolder
    ){
        super();
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean authorize(double amount) {
        
        if(amount > 5000) return false;
        this.authorized = true;
        this.authorizedAmount = amount;
        return true;
    }

    @Override
    public void capture(double amount) {
        if(!this.authorized) return;
        this.capturedAmount = amount;
        System.out.println("Captured via credit card");
    }

    @Override
    public void refund(double amount) {
        if(capturedAmount < amount) return;
        this.capturedAmount -= amount;
        System.out.println("Refunded to credit card");
    }

}
