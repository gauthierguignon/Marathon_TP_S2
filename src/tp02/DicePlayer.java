package tp02;

public class DicePlayer {

    private String nom;
    private int nbDiceRolls;
    private int totalValue;

    public String getNom() {
        return nom;
    }

    public int getNbDiceRolls() {
        return nbDiceRolls;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public DicePlayer(String nom) {
        this.nom = nom;
        this.nbDiceRolls = 0;
        this.totalValue = 0;
    }

    public String toString() {
        return this.nom + ": " + this.totalValue + " points en " + this.nbDiceRolls + " coups";
    }

    public void play (Dice aDice) {
        aDice.roll();
        this.totalValue += aDice.getValue();
        this.nbDiceRolls++;
    }

    void playUntil(Dice aDice, int objective) {
        do {
            this.play(aDice);
        } while(this.totalValue < objective);
    }


}
