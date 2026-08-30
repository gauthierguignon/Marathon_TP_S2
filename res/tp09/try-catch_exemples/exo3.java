public class Main {
    public static void main(String[] args) {

        try {
            int a = 10 / 0;
            System.out.println("A");
        } catch (ArithmeticException e) {
            System.out.println("B");
        } finally {
            System.out.println("D");
        }

        System.out.println("C");
    }
}

// Affiche BDC
