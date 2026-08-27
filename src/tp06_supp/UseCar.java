package tp06_supp;

import java.time.LocalDate;

public class UseCar {
    
    public static void main(String[] args) {
        
        Car c1 = new Car("Peugeot", LocalDate.of(1999, 8, 18), 20000, 250000);
        VintageCar c2 = new VintageCar("Citroën", LocalDate.of(1999, 8, 18), 20000, 250000);

        System.out.println(c1+"\n"+c2);

        System.out.println("DEALERSHIP : ");
        Dealership d = new Dealership();
        
        Car c3 = d.createCar("Peugeot", LocalDate.of(2013, 8, 18),20000, 250000);
        Car c4 = d.createCar("Citroën", LocalDate.of(1995, 8, 18),20000, 250000);
        
        d.addCar(c3);
        d.addCar(c4);

        System.out.println(d);

    }

}
