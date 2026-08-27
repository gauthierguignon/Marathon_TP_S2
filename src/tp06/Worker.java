package tp06;

import java.time.LocalDate;

public class Worker extends Employee {
    
    private final static double BY_UNIT = 5;
    private int units;
    private static int objective = 1000;

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public Worker (String name, LocalDate hiringDate) {
        super(name, hiringDate);
        this.units = 0;
    }
    
    public Worker (String name, LocalDate hiringDate, int units) {
        super(name, hiringDate);
        this.units = units;
    }



    @Override
    public String getTitle() {
        return "Worker";
    }
    
    @Override
    public double getWages() {
        return this.units * BY_UNIT;
    }

    public boolean objectiveFulfilled() {
        if(this.units >= objective) return true;
        return false;
    }
    

}
