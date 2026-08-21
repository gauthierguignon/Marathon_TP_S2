package tp03_supp;

import java.util.Comparator;

import tp03.Task;

public class ComparateurParAnciennete implements Comparator <Task> {
    
    public int compare (Task o1, Task o2) {
        // il faut gérer les emplacements null
        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o1 == null) {
            return 1;
        }
        if (o2 == null) {
            return -1;
        }
        return o1.getCreationDate().compareTo(o2.getCreationDate());
    }
    
}
