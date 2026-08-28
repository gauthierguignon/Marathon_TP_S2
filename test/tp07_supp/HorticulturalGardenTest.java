package tp07_supp;

/*

javac -d bin -cp bin:/usr/share/java/junit-platform-console-standalone.jar test/tp07_supp/HorticulturalGardenTest.java 

*/ 


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp07_supp.Plant;
import tp07_supp.Rose;
import tp07_supp.Shrub;
import tp07_supp.Tulip;



public class HorticulturalGardenTest {
    int id1, id2, id3, id4, id5, id6, size1;
    double s1, s2, s3;
    Rose r1, r2;
    Tulip t1, t2;
    Shrub sh1, sh2;
    HorticulturalGarden garden1, garden2;

    @BeforeEach
    void testInitialization() {
        id1=1; id2=2; id3=10; id4=20; id5=100; id6=200;
        size1=3;

        s1=20.0; s2=60.0; s3=120.0;

        r1 = new Rose(id1, s1);
        r2 = new Rose(id2, s2);
        t1 = new Tulip(id3, s1);
        t2 = new Tulip(id4, s2);
        sh1 = new Shrub(id5, s2);
        sh2 = new Shrub(id6, s3);

        r1.setPricePerUnit(2.0);
        r1.setHarvestThreshold(50.0);
        t1.setPricePerUnit(1.0);
        t1.setHarvestThreshold(30.0);
        sh1.setPricePerUnit(5.0);
        sh1.setHarvestThreshold(100.0);

        garden1 = new HorticulturalGarden(size1);
        garden2 = new HorticulturalGarden();
    }

    @Test
    void testAdd() {
        assertEquals(0, garden1.getGardenSize());
        assertEquals(0, garden2.getGardenSize());

        garden1.add(r1); garden2.add(r1);
        assertEquals(1, garden1.getGardenSize());
        assertEquals(1, garden2.getGardenSize());

        garden1.add(t1); garden2.add(t1);
        assertEquals(2, garden1.getGardenSize());
        assertEquals(2, garden2.getGardenSize());

        garden1.add(sh1); garden2.add(sh1);
        assertEquals(3, garden1.getGardenSize());
        assertEquals(3, garden2.getGardenSize());

        garden1.add(r2); garden2.add(r2);
        assertEquals(3, garden1.getGardenSize());
        assertEquals(4, garden2.getGardenSize());
    }

    @Test
    void testGetNbRose() {
        assertEquals(0, garden1.getNbRose());

        garden1.add(r1);
        assertEquals(1, garden1.getGardenSize());
        assertEquals(1, garden1.getNbRose());

        garden1.add(t1);
        assertEquals(2, garden1.getGardenSize());
        assertEquals(1, garden1.getNbRose());

        garden1.add(r2);
        assertEquals(3, garden1.getGardenSize());
        assertEquals(2, garden1.getNbRose());
    }

    @Test
    void testSearch() {
        garden1.add(r1);
        garden1.add(t1);
        garden1.add(sh1);

        assertEquals(3, garden1.getGardenSize());

        assertSame(r1, garden1.search(id1));
        assertNull(garden1.search(id2));

        assertSame(t1, garden1.search(id3));
        assertNull(garden1.search(id4));

        assertSame(sh1, garden1.search(id5));
        assertNull(garden1.search(id6));
    }

    @Test
    void testGetRose() {
        garden1.add(r1);
        garden1.add(t1);
        garden1.add(r2);

        assertEquals(3, garden1.getGardenSize());
        assertEquals(2, garden1.getNbRose());

        assertSame(r1, garden1.getRose(1));
        assertSame(r2, garden1.getRose(2));
        assertNull(garden1.getRose(3));
    }

    @Test
    void testUpdateSize() {
        garden1.add(r1);
        garden1.add(t1);
        garden1.add(sh1);

        assertEquals(3, garden1.getGardenSize());
        assertEquals(s1, r1.getSize());

        garden1.updateSize(id1, s2);

        assertEquals(s2, r1.getSize());
    }

    @Test
    void testUpdateSizeUnknownPlant() {
        garden1.add(r1);

        garden1.updateSize(id2, s3);

        assertEquals(s1, r1.getSize());
    }

    @Test
    void testIsMature() {
        assertFalse(r1.isMature());
        assertTrue(r2.isMature());

        assertFalse(t1.isMature());
        assertTrue(t2.isMature());

        assertFalse(sh1.isMature());
        assertTrue(sh2.isMature());
    }

    @Test
    void testPotentialProfit() {
        double profit = 0.0;

        assertEquals(0, garden2.getGardenSize());
        assertEquals(profit, garden2.potentialProfit());

        garden2.add(r1); // immature
        assertEquals(1, garden2.getGardenSize());
        assertEquals(profit, garden2.potentialProfit());

        garden2.add(r2); // mature
        profit += r2.getSize() * r2.getPricePerUnit();
        assertEquals(2, garden2.getGardenSize());
        assertEquals(profit, garden2.potentialProfit());

        garden2.add(t1); // immature
        assertEquals(3, garden2.getGardenSize());
        assertEquals(profit, garden2.potentialProfit());

        garden2.add(t2); // mature
        profit += t2.getSize() * t2.getPricePerUnit();
        assertEquals(4, garden2.getGardenSize());
        assertEquals(profit, garden2.potentialProfit());

        garden2.add(sh1); // immature
        assertEquals(5, garden2.getGardenSize());
        assertEquals(profit, garden2.potentialProfit());

        garden2.add(sh2); // mature
        profit += sh2.getSize() * sh2.getPricePerUnit();
        assertEquals(6, garden2.getGardenSize());
        assertEquals(profit, garden2.potentialProfit());
    }

    @Test
    void testHarvest() {
        List<Plant> toHarvest = new ArrayList<Plant>();

        garden2.add(r1);
        garden2.add(t1);

        assertEquals(2, garden2.getGardenSize());

        toHarvest = garden2.harvest();

        assertEquals(2, garden2.getGardenSize());
        assertEquals(0, toHarvest.size());

        garden2.add(r2);

        assertEquals(3, garden2.getGardenSize());

        toHarvest = garden2.harvest();

        assertEquals(2, garden2.getGardenSize());
        assertEquals(1, toHarvest.size());
        assertSame(r2, toHarvest.get(0));

        garden2.add(r2);
        garden2.add(t2);

        assertEquals(4, garden2.getGardenSize());

        toHarvest = garden2.harvest();

        assertEquals(2, garden2.getGardenSize());
        assertEquals(2, toHarvest.size());
        assertSame(r2, toHarvest.get(0));
        assertSame(t2, toHarvest.get(1));
    }

    // @Test
    // void testPotentialPremiumProfit() {
    //     double profit = 0.0;

    //     assertEquals(0, garden2.getGardenSize());
    //     assertEquals(profit, garden2.potentialPremiumProfit());

    //     garden2.add(r1); // immature premium
    //     assertEquals(profit, garden2.potentialPremiumProfit());

    //     garden2.add(r2); // mature premium
    //     profit += 2 * r2.getSize() * r2.getPricePerUnit();
    //     assertEquals(profit, garden2.potentialPremiumProfit());

    //     garden2.add(t2); // mature non premium
    //     assertEquals(profit, garden2.potentialPremiumProfit());

    //     garden2.add(sh1); // immature premium
    //     assertEquals(profit, garden2.potentialPremiumProfit());

    //     garden2.add(sh2); // mature premium
    //     profit += 2 * sh2.getSize() * sh2.getPricePerUnit();
    //     assertEquals(profit, garden2.potentialPremiumProfit());
    // }

    @Test
    void testPremiumCareInterface() {
        assertTrue(r1 instanceof IPremiumCare);
        assertFalse(t1 instanceof IPremiumCare);
        assertTrue(sh1 instanceof IPremiumCare);
    }

    @Test
    void testToString() {
        garden2.add(r1);
        garden2.add(t1);
        garden2.add(sh1);

        assertEquals("[Rose [1,20.0], Tulip [10,20.0], Shrub [100,60.0]]", garden2.toString());
    }
}