package tp06;

import java.time.LocalDate;

public abstract class Employee {
    
    private String name;
    private LocalDate hiringDate;

    public LocalDate getHiringDate() {
        return hiringDate;
    }

    public Employee(String name, LocalDate hiringDate) {
        this.name = name;
        this.hiringDate = hiringDate;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name + " " + this.getTitle();
    }

    public abstract String getTitle();
    public abstract double getWages();
    public abstract boolean objectiveFulfilled();

}
