package tp06;

import java.time.LocalDate;

public class Vendor extends Salesperson {

    private final static double PERCENTAGE = 0.20;
    private final static int BONUS = 400;

    public Vendor(String name,LocalDate hiringDate,double turnover) {
        super(name, hiringDate, turnover);
    }

    public String getTitle() {
        return "Vendor";
    }

    public double getWages() {
        return this.getTurnover() * (1+PERCENTAGE) + BONUS;
    }

}
