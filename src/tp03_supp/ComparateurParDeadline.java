package tp03_supp;

import java.util.Comparator;

import tp03.Task;

public class ComparateurParDeadline implements Comparator <Task> {

    @Override
    public int compare(Task o1, Task o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o1 == null) {
            return 1;
        }
        if (o2 == null) {
            return -1;
        }
        return o1.getDeadline().compareTo(o2.getDeadline());
    }

/*
    Ici on peut directement utiliser compareTo car 2 dates sont comparables entre elles par défaut. 

    Mais pour comparer les int directement on aurait pu écrire (ou un truc du genre)

        return (int) o1.getDeadline().until(o2.getDeadline(), ChronoUnit.DAYS);

*/

}
