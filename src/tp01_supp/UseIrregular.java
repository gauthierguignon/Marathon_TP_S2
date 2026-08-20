package tp01_supp;

public class UseIrregular {
 
    public static void main (String[] args) {

        int[] arr = {10,5,5,10, 10};

        Irregular irr = new Irregular(arr);

        irr.randomFilling();
        System.out.println(irr.display());

        System.out.println(irr.isCommun(5));


    }


}
