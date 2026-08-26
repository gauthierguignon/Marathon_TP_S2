package tp05;

import java.time.LocalDate;

public class ComicBook extends Book {
    
    private String illustrator;

    ComicBook(String code, String title, String author, int publicationYear, String illustrator) {
        super(code, title, author, publicationYear);
        this.illustrator = illustrator;
    }

    @Override
    public String toString () {
        return "ComicBook[" + super.getCode() + ":" + super.getTitle()+"->"+super.getAuthor()+","+this.getPublicationYear()+","+this.illustrator+"]";
    }

    @Override
    public int getDurationMax() {
        if((LocalDate.now().getYear()) - this.getPublicationYear() <= 2) return 5;
        return super.getDurationMax();
    }

}
