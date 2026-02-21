package java;
import java.util.Objects;
import java.util.UUID;

public class Product{

    private final String sku; 
    private String name;
    private double price;

    Product(){
        sku = UUID.randomUUID().toString();
        name = "random name";
        price = 0.00;
    }

    Product(String sku, String name, double price){

        this.sku = sku;
        this.name = name;
        this.price = price;

    }

    // copy 
    Product(Product other){
        this(
            other.sku,
            other.name,
            other.price
        );
    }

    public String getSku(){
        return this.sku;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    @Override
    public boolean equals(Object other){
        
        if(this==other) return true;
        if(!(other instanceof Product)) return false;
        Product p = (Product) other;
        return Objects.equals(this.sku, p.sku);
    }

    @Override
    public int hashCode(){
        return Objects.hash(sku);
    }
    
    
};