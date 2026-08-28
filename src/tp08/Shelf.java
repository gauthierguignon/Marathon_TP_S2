package tp08;

import java.util.ArrayList;

public class Shelf {

    private boolean refrigerated;
    private int capacityMax;
    private ArrayList<IProduct> products;

    public Shelf(boolean refrigerated, int capacityMax) {
        this.refrigerated = refrigerated;
        this.capacityMax = capacityMax;
    }

    public ArrayList<IProduct> getProducts() {
        return this.products;
    }

    public boolean isFull() {
        return this.products.size() >= this.capacityMax;
    }

    public boolean isEmpty() {
        return this.products.isEmpty();
    }

    boolean isRefrigerated() {
        return this.refrigerated;
    }

    public String toString() {
        return "["+this.refrigerated+" : "+this.capacityMax+" -> "+products.toString()+"]";
    }

    public boolean add(IProduct p) {
        if(p.isPerishable() != this.isRefrigerated()) return false;
        if(this.isFull()) return false;
        return this.products.add(p);
    }


}
