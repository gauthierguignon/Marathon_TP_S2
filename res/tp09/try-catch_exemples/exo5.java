import java.util.Scanner;

public class Exercice {

  public static void main (String[] args) {
    
    int solde = 100;
    
    Scanner s = new Scanner(System.in);
    
    System.out.println("Combien voulez-vous retirer ?");
    String somme = s.nextLine();
    
    try {
      if(Integer.parseInt(somme) > solde) throw new IllegalArgumentException("Solde Insuffisant");
      solde = solde - Integer.parseInt(somme);
      System.out.println("Nouveau solde"+" : "+solde);          
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    } finally {
      System.out.println("Opération terminée");
    }
    
    
    
    
  }
  
}
