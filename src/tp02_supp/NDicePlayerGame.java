package tp02_supp;

import java.util.ArrayList;

import tp02.*;

public class NDicePlayerGame {
    
    private DicePlayer [] tab;

    public DicePlayer[] getTab() {
        return tab;
    }

    public NDicePlayerGame(int numberOfPlayer) {
        tab = new DicePlayer[numberOfPlayer];
        for(int i = 0; i < numberOfPlayer; i++) {
            tab[i] = new DicePlayer("Player " + Integer.toString(i));
        }
    }

    public void play(Dice aDice, int objective) {
        for(DicePlayer d : tab) {
            d.playUntil(aDice, objective);
        }
    }

    public DicePlayer[] getWinners() {
        ArrayList <DicePlayer> winners = new ArrayList<>();
        winners.add(this.tab[0]);

        for(int i = 1; i < tab.length; i++) {
            int delta = tab[i].compareNbDiceRolls(winners.get(0));

            if (delta == 0) {
                winners.add(tab[i]);
            } else if (delta > 0) {
                winners.clear();
                winners.add(tab[i]);
            }
        }
        return winners.toArray(new DicePlayer[0]);

    }

    public static void main (String[] args) {

        NDicePlayerGame game = new NDicePlayerGame(10);
        
        Dice d = new Dice(6);
        game.play(d, 421);

        System.out.println("Les gagnants sont : \n");
        
        DicePlayer [] display = game.getWinners();
        for(DicePlayer p : display) {
            System.out.println(p);
        }
        System.out.println("Détails de la partie : ");
        for(DicePlayer t : game.getTab()) {
            System.out.println(t);
        }
        
    }

}
