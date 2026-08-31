package tp09_Exo4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
javac -d bin -cp bin src/tp09_Exo4/*.java 
java -cp bin tp09_Exo4.Validation

Notes : 
obligé de mettre le scanner dans un try with ressources parce que le sc.close ne serait jamais executé en cas d'exception

Oui je crois que l'exercice voulait qu'on utilise nextInt() avec ";" en délimiteur. Je contourne le problème avec NumberFormatException.
Je préfère ma méthode.

*/


public class Validation {
 
    static boolean checkFile(String pathName) throws InputMismatchException, InvalidStructureException, FileNotFoundException {

        File file = new File(pathName);
        if(!file.exists()) throw new FileNotFoundException();
        int lineCounter = 0;

        try(Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()) {
                String ligneEnCours = scanner.nextLine();
                lineCounter++;
                String [] mots = ligneEnCours.split(";");

                //test du nombre de données
                int nbDeDonnées;
                try {
                    nbDeDonnées = Integer.parseInt(mots[1]);
                } catch (NumberFormatException e) {
                    throw new InvalidStructureException("Structure Invalide : le deuxième champ doit être de type int");
                }
                if(nbDeDonnées + 2 != mots.length) {
                    throw new InvalidStructureException("Structure Invalide : la ligne" + lineCounter + "n'indique pas le bon nombre d'éléments");
                }
                if(nbDeDonnées == 0) {
                    throw new InvalidStructureException("Le nombre de données ne peut pas être zéro");
                }

                //test du type
                String typeDeDonnée = mots[0];

                for(int i = 2; i < nbDeDonnées + 2; i++) {
                    if(typeDeDonnée.equals("1")) { // booléen
                        if(!mots[i].equals("false") && !mots[i].equals("true")) {
                            throw new InvalidStructureException("Le type de donnée à la ligne " + lineCounter + " colonne " + i + " ne correspond pas ");
                        }
                    } else if(typeDeDonnée.equals("2")) { // int
                        try {
                            Integer.parseInt(mots[i]);
                        } catch (NumberFormatException e) {
                            throw new InvalidStructureException("Structure Invalide : le deuxième champ doit être de type int");
                        }
                    }
                }  
            }
            return true;
        }
    }


    public static void main (String[] args) {


        try {
            System.out.println(Validation.checkFile("res/tp09/testScan.csv"));
        } catch (FileNotFoundException e) {
            System.out.println("Fichier introuvable");
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        } catch (InvalidStructureException e) {
            System.out.println(e.getMessage());
        }



    }

}
