package tp08;

/*
javac -d bin -cp bin src/tp08/*.java
javac -d bin -cp bin:/usr/share/java/junit-platform-console-standalone.jar test/tp08/ShopTest.java
java -jar /usr/share/java/junit-platform-console-standalone.jar execute -cp bin -c tp08.ShopTest
*/


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopTest {
    public IProduct p1, p2, p3, p4, p5;
    public ArrayList<IProduct> aStock;
    public Shelf e1, e2, e3, e4;
    public ArrayList<Shelf> shelves;
    public Shop m;

    @BeforeEach
    public void initialization() {
        this.p1 = new Food("pasta", 3.25, LocalDate.of(2019, 1, 1));
		this.p2 = new Furniture("chair", 50.0);
		this.p3 = new Furniture("table", 100.0);
		this.p4 = new Food("fish", 10.0);
		this.p5 = new Food("meat", 15.0, LocalDate.of(2019, 1, 1));
		this.aStock = new ArrayList<IProduct>();
		this.aStock.add(p1); this.aStock.add(p2); this.aStock.add(p3); this.aStock.add(p4); this.aStock.add(p5);
		
		this.e1 = new Shelf(false, 1);
		this.e2 = new Shelf(false, 2);
		this.e3 = new Shelf(true, 2);
		this.e4 = new Shelf(true, 2);
		this.shelves = new ArrayList<Shelf>();
		this.shelves.add(e1); this.shelves.add(e2); this.shelves.add(e3); this.shelves.add(e4);

        this.m = new Shop(shelves);
    }

    @Test
    public void initTest() {
        ArrayList<Shelf> tmp = m.getShelving();
        assertEquals(4, tmp.size());
        assertTrue(tmp.get(0).isEmpty());
        assertFalse(tmp.get(0).isRefrigerated());
        assertTrue(tmp.get(1).isEmpty());
        assertFalse(tmp.get(1).isRefrigerated());
        assertTrue(tmp.get(2).isEmpty());
        assertTrue(tmp.get(2).isRefrigerated());
        assertTrue(tmp.get(3).isEmpty());
        assertTrue(tmp.get(3).isRefrigerated());
    }
    @Test
    public void tidyTest() {
        ArrayList<Shelf> tmp = m.getShelving();
        m.tidy(this.aStock);
        assertTrue(tmp.get(0).isFull());
        assertEquals(this.p2, tmp.get(0).getProducts().get(0));
        assertFalse(tmp.get(1).isFull());
        assertFalse(tmp.get(1).isEmpty());
        assertEquals(this.p3, tmp.get(1).getProducts().get(0));
        assertTrue(tmp.get(2).isFull());
        assertEquals(this.p1, tmp.get(2).getProducts().get(0));
        assertEquals(this.p4, tmp.get(2).getProducts().get(1));
        assertFalse(tmp.get(3).isFull());
        assertFalse(tmp.get(3).isEmpty());
        assertEquals(this.p5, tmp.get(3).getProducts().get(0));
    }
    @Test
    public void closeBeforeDateTest() {
        m.tidy(this.aStock);
        ArrayList<IProduct> res = m.closeBestBeforeDate(-3);
        assertEquals(2, res.size());
        assertEquals(this.p1, res.get(0));
        assertEquals(this.p5, res.get(1));
    }
}
