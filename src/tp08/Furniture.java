package tp08;

public class Furniture implements IProduct {

    private static int counterRefUnknown = 0;
    private String label;
    private double price;

    public Furniture(String label, double price) {
        this.label = this.label == null ? "refUnknown"+counterRefUnknown : label;
        if(label == null) counterRefUnknown++;
        this.price = price;
    }

    public String getLabel() {
        return this.label;
    }

    public double getPrice() {
        return this.price;
    }
    
    public String toString() {
        return "["+label+"="+price+"]";
    }

    public boolean isPerishable() {
        return false;
    }

}
