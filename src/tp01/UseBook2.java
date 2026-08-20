public class UseBook2 {
    
    public static void main (String[] args) {

        Book b1 = new Book("Le Petit Prince", "Antoine de Saint-Exupéry", 1943);
        Book b2 = new Book("1984", "George Orwell", 1949);
        Book b3 = new Book("Harry Potter à l'école des sorciers", "J.K. Rowling", 1997);
        Book b4 = new Book("L'Étranger", "Albert Camus", 1942);
        Book b5 = new Book("Les Misérables", "Victor Hugo", 1862);


        Book[] bibliothèque = {b1, b2, b3, b4, b5};

        System.out.println("Affichage de la bibliothèque : ");
        for(Book b : bibliothèque) {
            System.out.println(b);
        }

        System.out.println();

        System.out.println("Affichage du livre le plus vieux : ");
        Book older = bibliothèque[0];
        for (int i = 1; i < bibliothèque.length; i++) {
            if(bibliothèque[i].year<older.year){
                older = bibliothèque[i];
            }
        }
        System.out.println(older);
    
        System.out.println();
        System.out.println("Affichage du livre le plus vieux avec isOlder: ");
        Book older2 = bibliothèque[0];
        for (int i = 1; i < bibliothèque.length; i++) {
            if(bibliothèque[i].isOlder(older2)){
                older = bibliothèque[i];
            }
        }
        System.out.println(older);

    
    }

}
