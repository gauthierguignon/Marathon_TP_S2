package tp05;

// javac -d bin -cp "bin:/usr/share/java/junit-platform-console-standalone.jar" test/tp05/LibraryTest.java

// java -jar /usr/share/java/junit-platform-console-standalone.jar execute -cp bin -c tp05.LibraryTest

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class LibraryTest {
    private int p1, p2;
    private Book b1, b2, b3;
    private Library myLib;
    private ComicBook c1, c2;

    @BeforeEach
    public void initialization() {
        // borrowers
        p1 = 42;
        p2 = 404;
        // books
        b1 = new Book("H2G2", "The Hitchhiker's Guide to the Galaxy", "D. Adams", 1979);
        b2 = new Book("FLTL", "Flatland", "E.Abbott Abbott", 1884);
        b3 = new Book("REU", "The Restaurant at the End of the Universe", "D. Adams", 1980);
        c1 = new ComicBook("LeuG", "Léonard est un Génie", "Bob de Groot", 1977, "Turk");
        c2 = new ComicBook("GVV", "Génie, Vidi, Vici !", "Turk", 2026, "Zidrou");
        // library
        myLib = new Library();
    }

    @Test
    public void scenario1() {
        myLib.addBook(b1); myLib.addBook(b2); myLib.addBook(b3);
        assertEquals(b1, myLib.getBook("H2G2"));
        assertEquals(b2, myLib.getBook("FLTL"));
        assertEquals(b3, myLib.getBook("REU"));
        assertNull(myLib.getBook("ERR"));
        assertEquals(3, myLib.stockSize());
        assertEquals("[Book [H2G2:The Hitchhiker's Guide to the Galaxy->D. Adams,1979], Book [FLTL:Flatland->E.Abbott Abbott,1884], Book [REU:The Restaurant at the End of the Universe->D. Adams,1980]]", myLib.toString());
    }

    @Test
    void scenario2() {
        myLib.addBook(b1); myLib.addBook(b2); myLib.addBook(b3);
        assertEquals("", myLib.borrowings());
        assertEquals(0, myLib.borrowedBookNumber());
        // p1 borrows b1 successfully
        assertTrue(myLib.borrow(b1.getCode(), p1));
        assertEquals(1, myLib.borrowedBookNumber());
        // p2 borrows b1 failed
        assertFalse(myLib.borrow(b1.getCode(), p2));
        assertEquals(1, myLib.borrowedBookNumber());
        // p2 borrows b3 successfully
        assertTrue(myLib.borrow(b3.getCode(), p2));
        assertEquals(2, myLib.borrowedBookNumber());
        // p1 borrows b2 successfully
        assertTrue(myLib.borrow(b2.getCode(), p1));
        assertEquals(3, myLib.borrowedBookNumber());
    }

    @Test
    void scenario3() {
        myLib.addBook(b1); myLib.addBook(c1);
        assertEquals(2, myLib.stockSize());
        assertEquals(0, myLib.borrowedBookNumber());
        assertEquals("[Book [H2G2:The Hitchhiker's Guide to the Galaxy->D. Adams,1979], ComicBook[LeuG:Léonard est un Génie->Bob de Groot,1977,Turk]]", myLib.toString());
        // p1 borrows b1 successfully
        assertTrue(myLib.borrow(b1.getCode(), p1));
        assertEquals(1, myLib.borrowedBookNumber());
        assertEquals("(H2G2)--42", myLib.borrowings());
        // p1 borrows c1 successfully
        assertTrue(myLib.borrow(c1.getCode(), p1));
        assertEquals(2, myLib.borrowedBookNumber());
        assertEquals("(H2G2)--42(LeuG)--42", myLib.borrowings());
    }

    @Test
    void scenario4() {
        myLib.addBook(b1); myLib.addBook(c1); myLib.addBook(c2);
        assertEquals(3, myLib.stockSize());
        assertEquals(0, myLib.borrowedBookNumber());
        assertEquals("[Book [H2G2:The Hitchhiker's Guide to the Galaxy->D. Adams,1979], ComicBook[LeuG:Léonard est un Génie->Bob de Groot,1977,Turk], ComicBook[GVV:Génie, Vidi, Vici !->Turk,2026,Zidrou]]", myLib.toString());
        // p1 borrows b1 successfully
        assertTrue(b1.borrowAgain(p1));
        assertEquals(15, b1.getDurationMax());
        assertEquals(LocalDate.now().plusDays(b1.getDurationMax()), b1.getGiveBackDate());
        assertEquals(1, myLib.borrowedBookNumber());
        assertEquals("(H2G2)--42", myLib.borrowings());
        // p1 borrows c1 successfully
        assertTrue(c1.borrowAgain(p1));
        assertEquals(15, c1.getDurationMax());
        assertEquals(LocalDate.now().plusDays(c1.getDurationMax()), c1.getGiveBackDate());
        assertEquals(2, myLib.borrowedBookNumber());
        assertEquals("(H2G2)--42(LeuG)--42", myLib.borrowings());
        // p1 borrows c2 successfully
        assertTrue(c2.borrowAgain(p1));
        assertEquals(5, c2.getDurationMax());
        assertEquals(LocalDate.now().plusDays(c2.getDurationMax()), c2.getGiveBackDate());
        assertEquals(3, myLib.borrowedBookNumber());
        assertEquals("(H2G2)--42(LeuG)--42(GVV)--42", myLib.borrowings());
    }
}
