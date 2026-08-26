package tp05;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Book {
    
    private String code;
    private String title;
    private String author;
    private int publicationYear;
    private int borrower;
    private LocalDate borrowingDate;

    public LocalDate getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(LocalDate borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public void setBorrower(int borrower) {
        this.borrower = borrower;
    }

    public int getBorrower() {
        return borrower;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public Book(String code, String title, String author, int publicationYear) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.borrower = 0;
    }

    public int getDurationMax() {
        return 15;
    }

    public LocalDate getGiveBackDate() {
        if (borrowingDate == null) {
            throw new IllegalStateException("Ce livre n'est pas emprunté");
        }
        return borrowingDate.plus(this.getDurationMax(), ChronoUnit.DAYS);
    }

    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(obj.getClass() != this.getClass()) return false;
        Book other = (Book) obj;
        if(!Objects.equals(other.code, this.code)) return false;
        if(!Objects.equals(other.title, this.title)) return false;
        if(!Objects.equals(other.author, this.author)) return false;
        if(!Objects.equals(other.code, this.code)) return false;
        if(!Objects.equals(other.publicationYear, this.publicationYear)) return false;
        return true;
    }

    public String toString() {
        return "Book [" + this.code + ":" + this.title+"->"+this.author+","+this.publicationYear+"]";
    }

    public boolean borrow(int borrower) {
        if(this.borrower != 0) return false;
        this.borrower = borrower;
        this.borrowingDate = LocalDate.now();
        return true;
    }

    public boolean giveBack() {
        if(this.borrower == 0) return false;
        this.borrower = 0;
        this.borrowingDate = null;
        return true;
    }

    public boolean isAvailable() {
        return this.borrower == 0 ? true : false;
    }

    // Permet d'emprunter un livre (ou de renouveler l'emprunt si déjà pris par le même emprunteur)
    public boolean borrowAgain(int borrower) {
        if (this.borrower != 0 && this.borrower != borrower) return false;
        this.borrower = borrower;
        this.borrowingDate = LocalDate.now();
        return true;
    }

}
