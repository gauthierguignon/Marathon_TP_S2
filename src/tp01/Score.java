public class Score {
    
    String name;
    int score;
    String timestamp;

    Score(String name, int score, String timestamp) {
        this.name = name;
        this.score = score;
        this.timestamp = timestamp;
    }

    public String toString() {
        return "(" + timestamp + ") " + name + " = " + score; 
    }

    boolean isSamePlayer(Score other) {
        return this.name.equals(other.name);
    }

    boolean isHigher(Score other) {
        return this.score > other.score;
    }

}
