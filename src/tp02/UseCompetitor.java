package tp02;

public class UseCompetitor {
 
    public static void main (String[] args) {

        Competitor comp = new Competitor(7,42,13,50);

        Competitor[] tab = new Competitor [100];

        tab[0] = new Competitor(1,45,15,20);
        tab[1] = new Competitor(2,32,12,45);
        tab[2]= new Competitor(5,12,13,59);
        tab[3] = new Competitor(12,12,15,70);
        tab[4] = new Competitor(32,75,15,20);

        for(Competitor c : tab) {
            if(c != null && c.getNumberSign() != null) System.out.println(c);
        }

        for(Competitor c : tab) {
            if(c !=null && c.isFaster(comp)) System.out.println(c +" est plus rapide que " + comp);
        }

    }

}
