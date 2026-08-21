package tp03_supp;

import java.util.Comparator;

import tp03.Task;

public class ComparateurParDuree implements Comparator <Task> {

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
        return o1.getDuration() - o2.getDuration();
    }

}
