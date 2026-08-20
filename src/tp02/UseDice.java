package tp02;

public class UseDice {
    
    public static void main (String[] args) {

        Dice d = new Dice(6);

        // for(int i = 0; i < 21; i++) {
        //     d.roll();
        //     System.out.println(d);
        // }

        DicePlayer dp = new DicePlayer("joueur");
        
        dp.playUntil(d, 120);

        System.out.println(dp);

    }


}
