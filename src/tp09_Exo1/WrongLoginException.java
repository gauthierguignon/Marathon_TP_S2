package tp09_Exo1;

public class WrongLoginException extends Exception {
    
    public WrongLoginException() {
        super("Login incorrect");
    }

}
