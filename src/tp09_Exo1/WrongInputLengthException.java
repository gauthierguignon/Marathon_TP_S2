package tp09_Exo1;

public class WrongInputLengthException extends Exception {
    
    public WrongInputLengthException() {
        super("Input > 10 char");
    }

}
