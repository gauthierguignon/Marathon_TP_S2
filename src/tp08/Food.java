package tp08;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Food implements IProduct, Comparable<Food> {

    private static int counterRefUnknown = 0;
    private String label;
    private double price;
    private LocalDate bestBeforeDate;

       
    public String getLabel() {
        return label;
    }

    public LocalDate getBestBeforeDate() {
        return bestBeforeDate;
    }

    public double getPrice() {
        return price;
    }

    public boolean isPerishable() {
        return true;
    }

    public Food(String label, double price, LocalDate bestBeforeDate) {
        this.label = this.label == null ? "refUnknown"+counterRefUnknown : label;
        if(label == null) counterRefUnknown++;
        this.bestBeforeDate = bestBeforeDate;
        this.price = price;
    }

    public Food(String label, double price) {

        this(label, price, LocalDate.now().plus(10, ChronoUnit.DAYS));
    }
    
    public String toString() {
        return "["+label+"="+price+" -> before "+bestBeforeDate+"]";
    }
    
    public boolean isBestBefore(LocalDate date) {
        return bestBeforeDate.isBefore(date) || bestBeforeDate.isEqual(date);
    }


    public int compareTo(Food f) {
        if(this.isBestBefore(f.getBestBeforeDate())) return 1;
        return -1;
    }

    

}
