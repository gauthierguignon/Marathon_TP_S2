package tp06_supp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Car {
    
    private final String BRAND;
    private final LocalDate ON_ROAD;
    private final double PURCHASE_PRICE;
    private int mileage;    

    public String getBRAND() {
        return BRAND;
    }

    public LocalDate getON_ROAD() {
        return ON_ROAD;
    }

    public double getPURCHASE_PRICE() {
        return PURCHASE_PRICE;
    }


    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    // package-private
    Car(String brand, LocalDate onRoad, double purchasePrice, int mileage) {
        this.BRAND = brand;
        this.ON_ROAD = onRoad;
        this.PURCHASE_PRICE = purchasePrice;
        this.mileage= mileage;
    }

    public double getTemporalDropRate() {
        return 0.001;
    }

    public double getMileageDropRate() {
        return 0.002;
    }

    public double computeDropRate() {
        return (
            (this.getTemporalDropRate() * (double) (LocalDate.now().until(ON_ROAD, ChronoUnit.MONTHS) * -1)) 
            +
            (this.getMileageDropRate()  * (mileage/1000.0))
        );
    }

    public double getSalePrice() {
        return PURCHASE_PRICE - (PURCHASE_PRICE * this.computeDropRate());
    }

    public String toString() {
    return "Car ["+BRAND+","+ON_ROAD+","+mileage+"km,"+this.getSalePrice()+"euros]";
    }



}
