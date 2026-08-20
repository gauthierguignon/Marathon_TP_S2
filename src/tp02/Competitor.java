package tp02;

import java.util.Objects;

public class Competitor {

    private String numberSign;
    private int time;
    private int score;

    public Competitor (int numberSign, int score , int min, int sec) {
        boolean validation = (
            (numberSign >= 1 && numberSign <= 100) && 
            (score >= 0 && score <= 50) && 
            (min >= 0 && min <= 60) && 
            (sec >= 0 && sec < 60)
        );
        this.numberSign = validation ? "No" + Integer.toString(numberSign) : null;
        this.score = score;
        this.time = min*60+sec;
    }

    public String toString() {
        StringBuilder bs = new StringBuilder("");
        bs.append(numberSign == null ? "- invalide -" : numberSign);
        bs.append(", " + this.score + " points, " + this.time + " s");
        return bs.toString();
    }

    public String getNumberSign() {
        return this.numberSign;
    }

    public int getScore() {
        return this.score;
    }

    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(this.getClass() != obj.getClass()) return false;
        Competitor other = (Competitor) obj;
        if(!Objects.equals(this.numberSign,other.numberSign)) return false;
        if(this.score != other.score) return false;
        return true;
    }

    boolean isFaster(Competitor other) {
        return this.time < other.time;
    }

}
