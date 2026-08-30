public class Main {
    public static void main(String[] args) {

        int[] nombres = {10, 20, 30};

        try {
            int resultat = 10 / 0;
            int valeur = nombres[5];
        } catch (ArithmeticException e) {
           System.out.println("Division par zéro");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index invalide");
        }
    }
}

