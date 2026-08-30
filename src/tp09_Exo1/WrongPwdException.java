package tp09_Exo1;

public class WrongPwdException extends Exception {
    
    public WrongPwdException() {
        super("C'est le mauvais mot de passe");
    }

}
