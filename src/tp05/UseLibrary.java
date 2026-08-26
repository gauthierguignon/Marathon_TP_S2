package tp05;

public class UseLibrary {
 
    public static void main (String[] args) {

        Book b1 = new Book("AAA", "Intermezzo", "Sally Rooney", 2024);
        Book b2 = new Book("AAB", "Normal People", "Sally Rooney", 2018);
        Book b3 = new Book("AAC", "Conversations with Friends", "Sally Rooney", 2017);
    
        Library lib = new Library();
        lib.addBook(b1);lib.addBook(b2);lib.addBook(b3);

        System.out.println("A specific book\n" + b1);
        System.out.println(lib);

        System.out.println("Borrowings List\nInitially -->");
        System.out.print(lib.borrowings());
        
        System.out.println(lib.borrow("AAA", 42) + " --> " + lib.borrowings());
        System.out.println(lib.borrow("AAA", 404) + " --> " + lib.borrowings());
        System.out.println(lib.borrow("AAB", 404) + " --> " + lib.borrowings());
        System.out.println(lib.borrow("AAC", 42) + " --> " + lib.borrowings());
        
        ComicBook cb1 = new ComicBook("AAD", "Asterix en Lusitanie", "Fabcaro", 2025, "Didier Conrad");
        lib.addBook(cb1);
        System.out.println(lib.borrow("AAD", 55) + " --> " + lib.borrowings());

        System.out.println("Date de d'un ComicBook récent : " + cb1.getGiveBackDate());

        ComicBook cb2 = new ComicBook("AAE", "Watchmen", "Alan Moore", 1986, "Dave Gibbons");
        lib.addBook(cb2);
        lib.borrow("AAE", 666);
        System.out.println("Date de d'un ComicBook ancien : " + cb2.getGiveBackDate());

        System.out.println("Date de d'un Book : " + b1.getGiveBackDate());

    }

}
