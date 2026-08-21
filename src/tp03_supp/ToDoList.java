package tp03_supp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import tp03.Task;

public class ToDoList {
    
    private Task[] chores;

    public ToDoList() {
        chores = new Task[5];
    }

    public void enlarge() {
        Task[] tab = new Task[this.chores.length+5];
        for(int i = 0; i < chores.length; i++) {
            tab[i] = chores[i];
        }
        this.chores = tab;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Task t : chores) {
            if(t!=null) {
                sb.append(t);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public void addTask(Task aTask) {
        for(int i = 0; i < this.chores.length; i++) {
            if( this.chores[i] == null ) {
                this.chores[i] = aTask;
                return;
            }
        }
        this.enlarge();
        this.chores[chores.length - 5] = aTask;
    }
        
    public void removeTask(int i) {
        if (i >= 0 && i < this.chores.length) {
            this.chores[i] = null;
        }
    }

    public void removeTask(Task aTask) {
        for (int i = 0; i < this.chores.length; i++) {
            if (this.chores[i] == aTask) {
                this.removeTask(i);
                return;
            }
        }
    }

    public boolean isOverwhelmed() {
        int counter = 0;
        for(Task t : chores) {
            if(t != null) counter++;
        } 
        return counter == this.chores.length;
    }

    public int getNbTask() {
        int counter = 0;
        for(Task t : chores) {
          if(t != null) counter++;  
        } 
        return counter;
    }

    public void onSickLeave(int nbDays) {
        for(Task t : chores) {
            if(t != null) {
                t.delay(nbDays);
            }
        }
    }

    public Task[] dueTasks() {
        ArrayList<Task> tachesAEcheances = new ArrayList<>();
        
        for(Task t : chores) {
            if(t != null) {
                tachesAEcheances.add(t);
            }
        }
        return tachesAEcheances.toArray(new Task[0]);
    }

    public void emergencySort() {
        Arrays.sort(this.chores, new ComparateurParDeadline());
    }

    void durationSort(){
        Arrays.sort(this.chores, new ComparateurParDuree());
    }

    void senioritySort() {
        Arrays.sort(this.chores, new ComparateurParAnciennete());
    }

}
