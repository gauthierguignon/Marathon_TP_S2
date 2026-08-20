public class UseHighScore2 {
    
    public static void main (String[] args){

        int param = (args.length == 0) ? 20 : Integer.parseInt(args[0]);

        HighScore highScore = new HighScore(param);

        highScore.addFirstFreeSlot(new Score("Alice", 300, "29/01"));
        highScore.addFirstFreeSlot(new Score("Bob", 800, "29/01"));
        highScore.addFirstFreeSlot(new Score("Alice", 42, "30/01"));
        highScore.addFirstFreeSlot(new Score("Alice", 650, "31/01"));


        System.out.println(highScore + "\n");

        // highScore.shifting(0);
        highScore.addHighestFirst(new Score("ELon", 1000, "28/08"));
        highScore.addHighestFirst(new Score("ELon", 2000, "28/08"));
        highScore.addHighestFirst(new Score("ELon", 3000, "28/08"));
        highScore.addHighestFirst(new Score("ELon", 6000, "28/08"));
        highScore.addHighestFirst(new Score("ELon", 900, "28/08"));
        highScore.addHighestFirst(new Score("ELon", 5000, "28/08"));
        highScore.addHighestFirst(new Score("ELon", 2200, "28/08"));
        

        System.out.println(highScore);

        highScore.addOneSlotPerPlayer(new Score("ELon", 6666, "28/08"));
        highScore.addOneSlotPerPlayer(new Score("Bob", 7777, "28/08"));

        System.out.println(highScore);

    }


}
