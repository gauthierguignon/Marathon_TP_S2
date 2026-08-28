package tp07_supp;

import java.util.ArrayList;
import java.util.List;

public class HorticulturalGarden {
    
    private ArrayList<Plant> plants;
    private int maxSize;

    public HorticulturalGarden(int maxSize){
        this.maxSize = maxSize;
        this.plants = new ArrayList<>();
    }

    public HorticulturalGarden() {
        this(2000);
    }

    public String toString() {
        return this.plants.toString();
    }

    public void add(Plant plant) {
        if(plants.size() >= this.maxSize) return;
        plants.add(plant);
    }

    public int getNbRose() {
        int counter = 0;
        for(Plant p : plants) {
            if(p instanceof Rose) counter++;
        }
        return counter;
    }
    
    public int getGardenSize() {
        return plants.size();
    }

    public Plant search(int identity) {
        for(Plant p : plants) {
            if(p.getIdentity() == identity) return p;
        }
        return null;
        // throw new IllegalArgumentException ("La plante n'est pas présente");
    }

    public Rose getRose(int i) {
        int counter = 0;
        for(Plant p : plants) {
            if(p instanceof Rose) counter++;
            if(counter == i) return (Rose) p;
        }
        return null;
    }

    public void updateSize(int identity, double size) {
        Plant plant = this.search(identity);
        if (plant != null) {
            plant.size = size;
        }
    }

    public double potentialProfit() {
        double profit = 0;
        for (Plant p : plants) {
            if(p.isMature()) {
                profit += p.getPrice();
            }
        }
        return profit;
    }

    public List<Plant> harvest() {
        // on parcours à l'envers pour supprimer de la liste
        ArrayList<Plant> harvestable = new ArrayList<>();
        for(int i = this.plants.size()-1; i >= 0; i--) {
            if(plants.get(i).isMature()) {
                // mais on ajoute au début de la liste pour garder le bon ordre pour le test
                harvestable.add(0, plants.get(i));
                this.plants.remove(i);
            }
        }
        return harvestable;
    }

    /* iterator : 
    public List<Plant> harvest() {
    List<Plant> harvestable = new ArrayList<>();

    Iterator<Plant> iterator = plants.iterator();

    while (iterator.hasNext()) {
        Plant plant = iterator.next();

        if (plant.isMature()) {
            harvestable.add(plant);
            iterator.remove();
        }
    }

    return harvestable;
    }
     */

}
