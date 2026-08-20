public class HighScore {
    
    Score[] top;

    HighScore(int i) {
        this.top = new Score[i];
    }

    HighScore() {
        this(100);
    }

    public int getNbFreeSlot() {
        int dernierIndex = 0;
        for(int i = top.length - 1; i > 0; i--) {
            if(top[i] != null) {
                dernierIndex = i;
                break;
            }
        }
        return top.length - dernierIndex - 1;
    }

    public String toString() {
        // on détermine jusqu'où il faudra afficher des scores
        int index = top.length - this.getNbFreeSlot();

        // on construit la chaine
        String output = "";
        output += "TOP SCORES : \n";

        for(int i = 0; i < index; i++) {
                output += top[i] + "\n";
        }

        output += "**" + getNbFreeSlot() + " free slots **";
        return output;
    }

    boolean addFirstFreeSlot(Score newScore) {
        for(int i = 0; i < top.length; i++) {
            if (top[i] == null) {
                top[i] = newScore;
                return true;
            }
        }
        return false;
    }

    void shifting(int idx) {
        for(int i = top.length - 1; i > idx; i--) {
            top[i] = top[i-1];
        }
        top[idx] = null;
    }

    boolean addHighestFirst(Score newScore) {
        int idx = - 1;
        // déterminer l'idx où mettre le score
        for(int i = 0; i < top.length; i++) {
            if(top[i] != null && top[i].score <= newScore.score) {
                idx = i;
                break;
            }
        }
        if(idx != -1) {
            this.shifting(idx);
            this.addFirstFreeSlot(newScore);
            return true;
        }
        return false;
    }

    boolean addOneSlotPerPlayer(Score newScore) {

        // Cherche si le joueur existe déjà
        for (int i = 0; i < top.length; i++) {
            if (top[i] != null && newScore.isSamePlayer(top[i])) {

                // Le nouveau score n'est pas meilleur
                if (!newScore.isHigher(top[i])) {
                    return false;
                }

                // On retire l'ancien score
                for (int j = i; j < top.length - 1; j++) {
                    top[j] = top[j + 1];
                }

                top[top.length - 1] = null;
                break;
            }
        }

        // Cherche la position du nouveau score
        int idx = 0;

        while (idx < top.length &&
            top[idx] != null &&
            top[idx].score > newScore.score) {
            idx++;
        }

        // Tableau plein et score trop faible
        if (idx == top.length) {
            return false;
        }

        // Décale vers la droite
        for (int i = top.length - 1; i > idx; i--) {
            top[i] = top[i - 1];
        }

        top[idx] = newScore;

        return true;
    }


}
