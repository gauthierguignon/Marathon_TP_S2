package tp02;

import java.util.Random;

public class Dice {
    
    
    private int numberSides;
    private Random rand;
    private int value;

    public int getNumberSides() {
        return numberSides;
    }

    public Random getRand() {
        return rand;
    }

    public int getValue() {
        return value;
    }

    public Dice(int nbface){
        this.numberSides = nbface > 0 ? nbface : 1;
        this.rand = new Random();
        this.roll();
    }

    public void roll() {
        this.value = 1 + rand.nextInt(numberSides);
    }

    public String toString() {
        return Integer.toString(value);
    }



}
