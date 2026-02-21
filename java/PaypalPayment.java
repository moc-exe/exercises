package java;

public class PaypalPayment extends AbstractPayment{

    private String email;

    public PaypalPayment(String email){
        super();
        this.email = email;
    }

    @Override
    public boolean authorize(double amount) {

        if(!email.contains("@")) return false;
        this.authorized = true;
        return true;
    }

    @Override
    public void capture(double amount) {
        if(!this.authorized) return;
        this.capturedAmount = amount;
        System.out.println("Captured via PayPal");
    }

    @Override
    public void refund(double amount) {
        if(capturedAmount < amount) return;
        this.capturedAmount -= amount;
        System.out.println("Refunded via PayPal");
    }


    
}
