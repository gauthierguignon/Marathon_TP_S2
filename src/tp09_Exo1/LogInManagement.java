package tp09_Exo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LogInManagement {

    public static final String LOGIN = "gauthier";
    public static final String PWD = "password";

    public boolean getUserPwd() throws IOException, WrongLoginException {
        BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
        String pwd = clavier.readLine(); 
        //readLine() peut lancer une checked exception donc il faut la gérer explicitement : throws IOException
        if(PWD.equals(pwd)) return true;
            throw new WrongLoginException();
    }

    public void getUserCredentials() throws IOException, WrongLoginException, WrongPwdException, WrongInputLengthException {
        BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Entrez votre nom d'utilisateur");
        String userName = clavier.readLine();
        if(userName.length() > 10) throw new WrongInputLengthException();
        if(!userName.equals(LOGIN)) throw new WrongLoginException();
        System.out.println("Entrez votre nom d'utilisateur");
        String pwd = clavier.readLine();
        if(pwd.length() > 10) throw new WrongInputLengthException();
        if(!pwd.equals(PWD)) throw new WrongPwdException();
    }


    public static void main(String[] args) {
        
        LogInManagement l = new LogInManagement();


        // Version 1
        // boolean flag = false;
        // do {
        //     try {
        //         flag = l.getUserPwd();
        //         System.out.println(true);
        //     } catch (WrongLoginException e) {
        //         System.out.println(e.getMessage());
        //     } catch (IOException e) {}
        // } while (!flag);

        //Version 2
        try {
            l.getUserCredentials();
        } catch (WrongInputLengthException e) {
            System.out.println(e.getMessage());    
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        } catch (WrongPwdException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {}
    
    
    }

}
