package tp05;

import java.util.ArrayList;
import java.util.Objects;

public class Library {
 
    public ArrayList<Book> library;

    public Library() {
        this.library = new ArrayList<>();
    }
    
    public Library(ArrayList<Book> list) {
        this.library = list;
    }

    public Book getBook(String code) {
        for(Book b : library) {
            if(Objects.equals(b.getCode(), code)) return b;
        }
        return null;
    }

    public boolean addBook(Book b) {
        return library.add(b);
    }

    public boolean removeBook(String aCode) {
        Book recherche = this.getBook(aCode);
        if(recherche == null) return false;
        return library.remove(recherche);
    }

    public boolean removeBook(Book b) {
        return library.remove(b);
    }

    public String toString() {
        return library.toString();
    }

    public String borrowings() {
        StringBuilder sb = new StringBuilder();
        for(Book b : library) {
            if(b.getBorrower() != 0) {
                sb.append("(" + b.getCode() + ")" + "--" +b.getBorrower() );
            }
        }
        return sb.toString();
    }

    public boolean borrow(String code, int borrower) {
        if(this.getBook(code) == null) return false;
        return this.getBook(code).borrow(borrower);
    }

    public boolean giveBack(String code) {
        if(this.getBook(code) == null) return false;
        return this.getBook(code).giveBack();
    }

    public int stockSize() {
        return this.library.size();
    }

    public int borrowedBookNumber() {
        int counter = 0;
        for(Book b : library) {
            if(b.getBorrower() != 0) {
                counter++;
            }
        }
        return counter;
    }

}