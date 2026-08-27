package tp06;

import java.time.LocalDate;
import java.util.ArrayList;

public class Company {
    
    private ArrayList<Employee> staff;

    public Company() {
        this.staff = new ArrayList<>();
    }

    public void addEmployee(Employee e) {
        this.staff.add(e);
    }

    public void removeEmployee(int i) {
        this.staff.remove(i);
    }

    public void removeEmployee(Employee e) {
        this.staff.remove(e);
    }

    public String toString() {
        return this.staff.toString();
    }

    public int getNbEmployee() {
        return staff.size();
    }

    public int getNbSalesPerson() {
        int counter = 0;
        for(Employee e : staff) {
            if(e instanceof Salesperson)  {
                counter++;
            }
        }
        return counter;
    }

    public int getNbWorker() {
        int counter = 0;
        for(Employee e : staff) {
            if(e instanceof Worker)  {
                counter++;
            }
        }
        return counter;
    }
    
    public void firing(LocalDate fatefulDate) {
        ArrayList<Employee> fired = new ArrayList<>();
        for(Employee e : staff) {
            if(e.getHiringDate().isAfter(fatefulDate)) {
                fired.add(e);
            }
        }
        this.staff.removeAll(fired);
    }

    public void firing() {
        ArrayList<Employee> fired = new ArrayList<>();
        for(Employee e : staff) {
            if(!e.objectiveFulfilled()) {
                fired.add(e);
            }
        }
        this.staff.removeAll(fired);
    }


}
