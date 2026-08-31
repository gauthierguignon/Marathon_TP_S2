package tp09_Exo4;

public class InvalidStructureException extends Exception {
    
    public InvalidStructureException() {
        super("La structure du fichier n'est pas correcte");
    }
    
    public InvalidStructureException(String message) {
        super(message);
    }


}
