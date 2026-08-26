package tpOO.tp05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopTest {
    private String ref1, ref2, ref3, ref4;
    private String label1, label2, label3, label4;
    private double p5, p10, p15, p20;
    private Article a1, a2, a3, a4, a5;
    private ArrayList<Article> arts;
    public Shop mag;

    @BeforeEach
    public void initialization() {
        // articles' references
        ref1 = "refA";
        ref2 = "refB";
        ref3 = "refC";
        ref4 = "refD";
        // articles' labels
        label1 = "a";
        label2 = "b";
        label3 = "c";
        label4 = "d";
        // articles' prices
        p5 = 5.0;
        p10 = 10.0;
        p15 = 15.0;
        p20 = 20.0;
        // articles
        a1 = new Article(ref1, label1, p10);
        a2 = new Article(ref2, label2, p15);
        a3 = new PerishableArticle(ref2, label2, p15);
        a4 = new PerishableArticle(ref3, label3, p20, LocalDate.now().plusDays(5));
        a5 = new PerishableArticle(ref4, label4, p5, LocalDate.now().minusDays(1));
        arts = new ArrayList<Article>();
        arts.add(a1);
        arts.add(a2);
        // shop
        mag = new Shop();
    }

    @Test
    public void toStringArticleTest() {
        assertEquals("Article [refA:a=10.0€/12.0€]", a1.toString());
        assertEquals("Article [refB:b=15.0€/18.0€]", a2.toString());
    }

    @Test
    public void addArticleShopTest1() {
        assertEquals(0, mag.getNbArticle());
        mag.addArticle(a1);
        assertEquals(1, mag.getNbArticle());
        mag.addArticle(a2);
        assertEquals(2, mag.getNbArticle());
    }

    @Test
    public void addArticleShopTest2() {
        assertEquals(0, mag.getNbArticle());
        mag.addArticle(arts);
        assertEquals(2, mag.getNbArticle());
    }

    @Test
    public void toStringPerishableArticleTest() {
        assertEquals("PerishableArticle [refB:b=15.0€/18.0€-->"+LocalDate.now().plusDays(10)+"]", a3.toString());
        assertEquals("PerishableArticle [refC:c=20.0€/24.0€-->"+LocalDate.now().plusDays(5)+"]", a4.toString());
        assertEquals("PerishableArticle [refD:d=5.0€/6.0€-->"+LocalDate.now().minusDays(1)+"]", a5.toString());
    }

    @Test
    public void addArticleShopTest3() {
        assertEquals(0, mag.getNbArticle());
        assertEquals(0, mag.getNbPerishableArticle());
        mag.addArticle(a1);
        assertEquals(1, mag.getNbArticle());
        assertEquals(0, mag.getNbPerishableArticle());
        mag.addArticle(a3);
        assertEquals(2, mag.getNbArticle());
        assertEquals(1, mag.getNbPerishableArticle());
    }

    @Test
    public void discountPerishableTest_none() {
        // no perishable article
        mag.addArticle(a1);
        assertEquals(1, mag.getNbArticle());
        assertEquals(0, mag.getNbPerishableArticle());
        double oldPriceA1 = a1.getSalePrice();
        mag.discountPerishable(LocalDate.now().plusDays(10), 0.5);
        assertEquals(oldPriceA1, a1.getSalePrice());
    }
    @Test
    public void discountPerishableTest_oneOverTwo() {
        // one perishable article concerned
        mag.addArticle(a1);
        mag.addArticle(a3);
        mag.addArticle(a4);
        assertEquals(3, mag.getNbArticle());
        assertEquals(2, mag.getNbPerishableArticle());
        double oldPriceA1 = a1.getSalePrice();
        double oldPriceA3 = a3.getSalePrice();
        double oldPriceA4 = a4.getSalePrice();
        mag.discountPerishable(LocalDate.now().plusDays(8), 0.5);
        assertEquals(oldPriceA1, a1.getSalePrice());
        assertEquals(oldPriceA3, a3.getSalePrice());
        assertEquals(oldPriceA4/2, a4.getSalePrice());
    }
    @Test
    public void discountPerishableTest_all() {
        // all perishable article concerned
        mag.addArticle(a1);
        mag.addArticle(a3);
        mag.addArticle(a4);
        assertEquals(3, mag.getNbArticle());
        assertEquals(2, mag.getNbPerishableArticle());
        double oldPriceA1 = a1.getSalePrice();
        double oldPriceA3 = a3.getSalePrice();
        double oldPriceA4 = a4.getSalePrice();
        mag.discountPerishable(LocalDate.now().plusDays(15), 0.5);
        assertEquals(oldPriceA1, a1.getSalePrice());
        assertEquals(oldPriceA3/2, a3.getSalePrice());
        assertEquals(oldPriceA4/2, a4.getSalePrice());
    }

    @Test
    public void discountNotPerishableTest_none() {
        // only perishable article
        mag.addArticle(a3);
        assertEquals(1, mag.getNbArticle());
        assertEquals(1, mag.getNbPerishableArticle());
        double oldPriceA3 = a3.getSalePrice();
        mag.discountNotPerishable(0.5);
        assertEquals(oldPriceA3, a3.getSalePrice());
    }

    @Test
    public void discountNotPerishableTest_some() {
        // one perishable article and one not perishable article
        mag.addArticle(a1);
        mag.addArticle(a3);
        assertEquals(2, mag.getNbArticle());
        assertEquals(1, mag.getNbPerishableArticle());
        double oldPriceA1 = a1.getSalePrice();
        double oldPriceA3 = a3.getSalePrice();
        mag.discountNotPerishable(0.5);
        assertEquals(oldPriceA1/2, a1.getSalePrice());
        assertEquals(oldPriceA3, a3.getSalePrice());
    }

}
