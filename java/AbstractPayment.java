import java.util.UUID;

public abstract class AbstractPayment implements PaymentMethod {

    protected String transactionId;
    protected double authorizedAmount;
    protected double capturedAmount;
    protected boolean authorized;

    public AbstractPayment(){
        this.transactionId = UUID.randomUUID().toString();
        this.authorizedAmount = 0;
        this.capturedAmount = 0;
        this.authorized = false;
    }

    public void logTransaction(){
        System.out.println("Transaction transactionId: " + transactionId + "completed successfully!");
    }

    public final void process(double amount){

        if(amount <= 0) return;
        var isAuthorized = authorize(amount);
        if(!isAuthorized) throw new RuntimeException("not authorized");
        capture(amount);
        logTransaction();
    }

}
