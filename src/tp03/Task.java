package tp03;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Task {
    
    private static int counter = 0;
    private int idTask;
    private LocalDate creationDate;
    private LocalDate deadline;
    private TaskStatus state;
    private String description;
    private int duration;
    
    public int getIdTask() {
        return idTask;
    }
    public LocalDate getDeadline() {
        return deadline;
    }
    public TaskStatus getState() {
        return state;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public String getDescription() {
        return description;
    }
    public int getDuration() {
        return duration;
    }
    
    public Task(String description, LocalDate creation, LocalDate deadline, int duration) {
        this.idTask = counter++;
        this.description = description;
        this.creationDate = creation;
        this.deadline = deadline;
        this.duration = duration;
        this.state = TaskStatus.TODO;
    }

    public Task(String description, int duration) {
        this(description, LocalDate.now(), LocalDate.now().plusDays(10), duration);
    }

    public String toString() {
        return "T"+this.idTask+" = "+this.description+":"+this.state+'('+this.duration+')'+this.deadline;
    }

    public void changeStatus(TaskStatus st) {
        this.state = st;
    }

    public void changeStatus() {
        int nouveauStatus = this.state.ordinal() + 1;
        TaskStatus[] taches = TaskStatus.values();
        this.changeStatus(taches[nouveauStatus%taches.length]);
    }

    public boolean isLate() {
        if(this.state == TaskStatus.FINISHED) return false;
        if(this.deadline.isAfter(LocalDate.now())) return false;
        return true;
    }

    public void delay(int nbDays) {
        this.deadline = deadline.plusDays(nbDays);
    }

    /*
    ** COMPARABLE **

    Si on veut comparer les tâches d'une seule façon, on implémente une méthode compareTo :

            public int compareTo(Task other) {
                return this.deadline.compareTo(other.deadline);
            }

    A utiliser ainsi : 

            Collections.sort(maListe);

    Et il faut que la classe "implements Comparable <Type T>"


    ** COMPARATOR **
    
    Sinon, si on veut pouvoir comparer les tâches différemment il faut passer en paramètre un comparator.

    Exemple d'utilisation de comparator :

            Comparator<Task> parDeadline =
            Comparator.comparing(Task::getDeadline);

            Comparator<Task> parDuration =
                Comparator.comparing(Task::getDuration);

            Comparator<Task> parCreationDate =
                Comparator.comparing(Task::getCreationDate);
    
    A utiliser ainsi :

            Collections.sort(maListe, parDeadLine);

    Si on crèe des classes Comparator il faudra les instancier ainsi : 

            Collections.sort(maListe, new ComparatorParDeadLine());

    On utilise :

    "Collections.sort" pour les listes

    "Arrays.sort" pour les tableaux


    */

}

