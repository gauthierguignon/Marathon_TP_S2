package tp06_supp;

import java.time.LocalDate;

public class VintageCar extends Car {
    
    // package-private
    VintageCar(String brand, LocalDate onRoad, double purchasePrice, int mileage) {
            super(brand, onRoad, purchasePrice, mileage);
    }

    @Override
    public double computeDropRate() {
        return (
            (this.getMileageDropRate()  * (this.getMileage()/1000.0))
        );
    }

    @Override
    public String toString() {
        return "Vintage"+super.toString();
    }

}
