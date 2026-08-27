package tp06_supp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Dealership {
    
    private ArrayList<Car> autos;

    public Dealership () {
        this.autos = new ArrayList<>();
    }

    public void addCar(Car c) {
        this.autos.add(c);
    }

    public Car createCar(String brand, LocalDate onRoad, double purchasePrice, int mileage) {
        if(ChronoUnit.YEARS.between(onRoad, LocalDate.now()) >= 30) {
            return new VintageCar(brand, onRoad, purchasePrice, mileage);
        }
        return new Car(brand, onRoad, purchasePrice, mileage);
    }

    public String toString () {
        return autos.toString();
    }
}
