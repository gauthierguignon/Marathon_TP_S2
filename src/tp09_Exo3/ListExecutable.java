package tp09_Exo3;

/*

javac -d bin -cp bin:lib/tp09-res.jar src/tp09_Exo3/ListExecutable.java
java -cp bin:lib/tp09-res.jar tp09_Exo3.ListExecutable

*/

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import util.HierarchyCreation;

public class ListExecutable {

    public void printExecutable(File file) {
        if (file.isFile()) {
            // cas de base : on teste et on affiche
            if (file.canExecute() && !file.isHidden()) {
                System.out.println(file.getAbsolutePath());
            }
        } else if (file.isDirectory()) {
            // cas récursif : on descend dans chaque élément du dossier
            File[] contenu = file.listFiles();
            if (contenu != null) {
                for (File element : contenu) {
                    printExecutable(element);
                }
            }
        }
    }
    

    public static void main(String[] args) {
        
        try {
            HierarchyCreation.hierarchyCreation("res/tp09/");
        } catch (IOException e) {
            e.printStackTrace();
        }

        File f = new File("res/tp09/hierarchy");
        ListExecutable le = new ListExecutable();
        le.printExecutable(f);
    }
}
