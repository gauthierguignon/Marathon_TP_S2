public class Exercice {

  public int counter;

  public int divisionPar(int i) throws IllegalArgumentException { 
    if(i == 0) throw new IllegalArgumentException("Mauvais argument !");
    return this.counter/i;
  }

	public static void main (String[] args) {
	  Exercice e = new exercice();
	  try {
	    e.divisionPar(0);
	  } catch (IllegalArgumentException e) {
	    System.out.println(e.getMessage());
	  }
	}
}


// on est pas obligé de l'expliciter car c'est une erreur Unchecked 
//(checkec au runtime pas à la compile)
// si on ne spécifie pas le type d'erreur, ça aurait lancé une ArithmeticException
