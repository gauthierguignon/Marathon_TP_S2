package tp08;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Shop {

    private ArrayList<Shelf> shelves;
    
    public Shop() {
        this.shelves = new ArrayList<>();
    }

    public Shop(ArrayList<Shelf> shelves) {
        this.shelves = shelves;
    }

    public String toString() {
        return this.shelves.toString();
    }

    public ArrayList<Shelf> getShelving() {
        return shelves;
    }

    public void tidy(ArrayList<IProduct> aStock) {
        for(IProduct p : aStock) {
            for(Shelf s : shelves) {
                if(s.add(p)) break;
            }
        }
    }

    public ArrayList<IProduct> closeBestBeforeDate(int nbDays) {
        ArrayList<IProduct> producList = new ArrayList<>();
        LocalDate deadline = LocalDate.now().plus(nbDays, ChronoUnit.DAYS);
        for(Shelf s : shelves) {
            for(IProduct p : s.getProducts()) {
                if(p.isPerishable()) {
                    Food f = (Food) p;
                    if(f.isBestBefore(deadline)) {
                        producList.add(f);
                    }
                }
            }
        }
        return producList;
    }

}