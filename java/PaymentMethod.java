public interface PaymentMethod {

    boolean authorize(double amount);
    void capture(double amount);
    void refund(double amount);

}
