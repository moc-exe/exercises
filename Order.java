import java.util.Objects;

public class Order {
    // immutable

    private final String orderId;
    private final String customerId;
    private final double amount;
    private final String status;

    public Order(String order, String customer, double amount, String status){
        this.orderId = order;
        this.customerId = customer;
        this.amount = amount;
        this.status = status;
    }

    public String getOrderId(){return orderId;}

    public String getCustomerId(){return customerId;}

    public double getAmount(){ return amount;}

    public String getStatus(){return status;}

    @Override
    public boolean equals(Object o){
        
        if(o == null) return false;
        if(this == o) return true;
        if(this.getClass() != o.getClass()) return false;
        Order other = (Order) o;
        return Objects.equals(this.orderId, other.orderId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(orderId); 
    }
        
}
