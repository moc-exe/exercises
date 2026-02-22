import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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

    // public static double totalPaidRevenue(List<Order> orders) signature as per requirements 
    public static double totalPaidRevenueImperative(List<Order> orders){
        double total = 0;
        for (Order o : orders) {
            if(Objects.equals(o.status, "PAID")) total+=o.getAmount();
        }
        return total;
    }

    public static double streamTotalPaidRevenue(List<Order> orders){

        return  orders.stream()
                .filter(order -> order.isPaid())
                .mapToDouble(order -> order.amount)
                .sum();
    }

    public static Map<String, Double> groupTotalRevenueByCustomer(List<Order> orders){

        return orders.stream()
            .filter(order -> order.isPaid())
            .collect(Collectors.toMap(
                order -> order.customerId,
                order -> order.amount,
                (existing, replacement) -> existing + replacement
            ));
    }

    public static Optional<String> getCustomerWithTopRevenue(List<Order> orders){

        return orders.stream()
                .filter(order -> order.isPaid())
                .max(new Comparator<Order>() {
                    @Override
                    public int compare(Order o1, Order o2){ return Double.compare(o1.amount, o2.amount);}
                })
                .map(order -> order.customerId);
                
    }

    public static Map<String, Long> countOrdersPerStatus(List<Order> orders){

        return orders.stream()
                .filter(order -> order.isPaid())
                .collect(Collectors.toMap(
                    order -> order.status,
                    order -> 1L,
                    (existing, replacement) -> existing + 1
                ));
    }

    private boolean isPaid(){ return this.status.equals("PAID");}

}
