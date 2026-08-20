package tp01_supp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Irregular {
    
    public int[][] irr;

    Irregular(int[] lineSize) {
        this.irr = new int[lineSize.length][];
        for(int i = 0; i < lineSize.length; i++) {
            this.irr[i] = new int[lineSize[i]];
        }
    }

    void randomFilling() {
        Random rand = new Random();
        for(int i = 0; i < this.irr.length; i++) {
            for(int j = 0; j < this.irr[i].length; j++) {
                this.irr[i][j] = rand.nextInt(10);
            }
        }
    }

    String display() {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < this.irr.length; i++) {
            for(int j = 0; j < this.irr[i].length; j++) {
                sb.append(this.irr[i][j] + " ");
            }
            if(i!= this.irr.length -1) sb.append("\n");
        }
        return sb.toString();
    }

    boolean isCommun(int element) {
        for(int i = 0; i < this.irr.length; i++) {
            for(int j = 0; j < this.irr[i].length; j++) {
                if(this.irr[i][j] == element) {
                    break;
                }
                if( j == this.irr[i].length -1 && this.irr[i][j] != element) return false;
            }
        }
        return true;
    }

    boolean existCommon() {
        // On stock la première ligne dans une hash map
        HashMap <Integer, Boolean> map = new HashMap<>();
        for(int i = 0 ; i < this.irr[0].length; i++) {
            map.put(this.irr[0][i], false);
        }

        // On parcours irr
        for(int i = 0; i < this.irr.length; i++) {
            for(int j = 0; j < this.irr[i].length; j++) {
                // est-ce que le Int en cours est dans map ?
                if(map.containsKey(this.irr[i][j])) {
                    map.put(this.irr[i][j], true);
                }
            }
            // Après avoir vérifié une ligne, on retire de la map toutes les valeurs non présentes
            map.entrySet().removeIf(entry -> entry.getValue() == false);
            // Si aucun n'est trouvé dans la ligne
            if(map.isEmpty()) return false;
            // Et on remet à false toutes les valeurs restantes
            for(Map.Entry<Integer, Boolean> entry : map.entrySet()) {
                map.replace(entry.getKey(), true, false);
            }
        }
    return !map.isEmpty();
    }

    /* CORRECTION AVEC UN SET
        boolean existCommon() {
        HashSet<Integer> common = new HashSet<>();

        for (int value : this.irr[0]) {
            common.add(value);
        }

        for (int i = 1; i < this.irr.length; i++) {
            HashSet<Integer> current = new HashSet<>();

            for (int value : this.irr[i]) {
                if (common.contains(value)) {
                    current.add(value);
                }
            }

            common = current;

            if (common.isEmpty()) {
                return false;
            }
        }

        return true;
    }
    */


}