package tp03;

import java.time.LocalDate;

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

    
}

