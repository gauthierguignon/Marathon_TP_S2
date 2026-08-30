package tp09_Exo2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

public class DicoJava {
    
    public static void main (String[] args) {

        StringBuilder sb = new StringBuilder();

        // Création de sb

        try {
            Scanner sc = new Scanner(new File("res/tp09/DicoJava.txt"));
            // le chemin est relatif au working directory, pas au chemin du fichier
            // On fait toujours un Scanner dans un try
            
            while(sc.hasNextLine()){ //tant que sc à une ligne suivante
                String line = sc.nextLine(); // je récupère la ligne en cours
                String[] mots = line.split("\t");
                if(mots.length >= 2 && Objects.equals(mots[1], "Mot-clé")) {
                    sb.append(mots[0] + "\n");
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Chemin fichier " + e.getMessage());
        }

        // print sb dans un fichier

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("res/tp09/MotsJava.txt"));
            bw.write(sb.toString());
            bw.close(); // ne pas oublier de fermer le flux
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

/*
ici j'utilise un try catch donc il faut fermer les flux de sc et bw mais avec un try-with-ressources pas besoin de fermer.
    
    try (BufferedWriter bw = ...) {
        // utilisation du BufferedWriter
    }
*/


    }
}
