package tp03;

public class Card {

    private Color color;
    private Rank rank;

    public Card(Color color, Rank rank) {
        this.color = color;
        this.rank = rank;
    }

    public Card(String c, String r) {
        this.color = Color.valueOf(c);
        this.rank = Rank.valueOf(r);
    }

    public Color getColor() {
        return color;
    }

    public Rank getRank() {
        return rank;
    }

    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this == obj) return true;
        if(this.getClass() != obj.getClass()) return false;
        Card other = (Card) obj;
        if(other.getColor() != this.getColor()) return false;
        if(other.getRank() != this.getRank()) return false;
        return true;
    }

    public String toString() {
        return "" + color.name() + rank.name(); 
    }

    

}
