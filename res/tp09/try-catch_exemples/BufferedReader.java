pubic class BufferedReader {

  public static void main (String[] args) {
  
    try (BufferedReader br = new BufferedReader(new FileReader(***cheminFichier***))) {
        String ligne = br.readLine();  // peut lancer une IOException
        while (ligne != null) {
            // traiter la ligne ici
            System.out.println(ligne);
            ligne = br.readLine();
        }
    } catch (FileNotFoundException e) {
        System.out.println("Fichier introuvable : " + e.getMessage());
    } catch (IOException e) {
        System.out.println("Erreur de lecture : " + e.getMessage());
    }
    
  }
}

// BufferedReader renvoie toujours une String, il faut faire les conversions à la main. C'est bien pour lire l'entrée standard.


//Scanner renvoie toujours une variable typée. C'est bien pour parse des fichiers ordonnés, comme un csv.
