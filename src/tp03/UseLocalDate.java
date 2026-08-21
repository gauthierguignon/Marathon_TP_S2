package tp03;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class UseLocalDate {
 
    public static void main (String[] args) {

        LocalDate d1 = LocalDate.now();
        LocalDate d2 = LocalDate.of(1996, 11, 19);
        
        System.out.println(d1);
        System.out.println(d2);

        LocalDate borneMin = d1.minusYears(30);
        long nbOfDays = ChronoUnit.DAYS.between(borneMin, d1);
        //équivalent de : long nbOfDays = borneMin.until(d1, ChronoUnit.DAYS)
        Random rand = new Random();
        long interval = rand.nextLong(nbOfDays + 1);
        LocalDate d3 = LocalDate.now().minusDays(interval);

        System.out.println(d3);

        System.out.println("La date la plus ancienne est : ");
        System.out.println(d2.isBefore(d3) ? d2 : d3 );
        
        System.out.println(d1.plusDays(7));

        System.out.print("J'ai vécu ");
        System.out.print(d2.until(d1, ChronoUnit.DAYS));
        System.out.println(" jours");

        System.out.println(d1.minusDays(867));
    }
    


}
