public class UseHighScore3 {
    
    public static void main (String[] args) {

        int param = (args.length == 0) ? 20 : Integer.parseInt(args[0]);

        HighScore highScore = new HighScore(param);

        highScore.addOneSlotPerPlayer(new Score("ELon", 1111, "28/08"));
        highScore.addOneSlotPerPlayer(new Score("Bob", 2222, "28/08"));
        highScore.addOneSlotPerPlayer(new Score("ELon", 9999, "28/08"));
        highScore.addOneSlotPerPlayer(new Score("Bob", 8888, "28/08"));

        System.out.println(highScore);

    }

}
