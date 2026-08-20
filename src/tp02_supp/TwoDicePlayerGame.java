package tp02_supp;

import java.util.Objects;

import tp02.*;

public class TwoDicePlayerGame {
    
    private DicePlayer p1;
    private DicePlayer p2;
    
    
    public TwoDicePlayerGame(DicePlayer p1, DicePlayer p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void play(Dice aDice, int objective) {
        this.p1.playUntil(aDice, objective);
        this.p2.playUntil(aDice, objective);
    }

    public DicePlayer getWinner() {
        if(p1.isWinner(p2)) return p1;
        return p2;
    }

    public DicePlayer reversePlayer(DicePlayer p) {
        return Objects.equals(p, this.p1) ? p2 : p1;
    }

    public static void main (String[] args) {

        TwoDicePlayerGame game = new TwoDicePlayerGame(new DicePlayer("hugo"), new DicePlayer("Jules"));
        Dice d = new Dice(6);
        game.play(d, 421);

        System.out.println("Le gagnant est : " + game.getWinner());
        System.out.println("Le perdant est : " + game.reversePlayer(game.getWinner()));

        

    }

}
