import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    
    private AtomicInteger count = new AtomicInteger(0);;
    
    public void increment(){
        count.incrementAndGet();
    };
    public int get(){
        return count.get();
    };
}