package tpOO.tp07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TulipTest {
    public int id1, id2, id3;
    public double s1, s2, s3;
    public Tulip t1, t2, t3;

    @BeforeEach
    void testInitialization() {
        id1=10; id2=20; id3=30;
        s1=10.0; s2=30.0; s3=40.0;
        t1 = new Tulip(id1, s1);
        t2 = new Tulip(id2, s2);
        t3 = new Tulip(id3, s3);

        t1.setPricePerUnit(1.0);
        t1.setHarvestThreshold(30.0);
    }

    @Test
    void testGetIdentity() {
        assertEquals(id1, t1.getIdentity());
        assertEquals(id2, t2.getIdentity());
        assertEquals(id3, t3.getIdentity());
    }

    @Test
    void testSetIdentity() {
        t1.setIdentity(id2);
        assertEquals(id2, t1.getIdentity());
    }

    @Test
    void testGetSize() {
        assertEquals(s1, t1.getSize());
        assertEquals(s2, t2.getSize());
        assertEquals(s3, t3.getSize());
    }

    @Test
    void testSetSize() {
        t1.setSize(s2);
        assertEquals(s2, t1.getSize());
    }

    @Test
    void testGetPricePerUnit() {
        assertEquals(1.0, t1.getPricePerUnit());
    }

    @Test
    void testGetHarvestThreshold() {
        assertEquals(30.0, t1.getHarvestThreshold());
    }

    @Test
    void testGetPrice() {
        assertEquals(s1*t1.getPricePerUnit(), t1.getPrice());
        assertEquals(s2*t2.getPricePerUnit(), t2.getPrice());
        assertEquals(s3*t3.getPricePerUnit(), t3.getPrice());
    }

    @Test
    void testIsMature() {
        assertFalse(new Tulip(1, 29.9).isMature());
        assertTrue(new Tulip(2, 30.0).isMature());
        assertTrue(new Tulip(3, 30.1).isMature());
    }

    @Test
    void testToString() {
        assertEquals("Tulip [10,10.0]", t1.toString());
    }

    @Test
    void testSetPricePerUnit() {
        t1.setPricePerUnit(2.0);
        assertEquals(2.0, t1.getPricePerUnit());
        assertEquals(2.0, t2.getPricePerUnit());
    }

    @Test
    void testSetHarvestThreshold() {
        t1.setHarvestThreshold(40.0);
        assertEquals(40.0, t1.getHarvestThreshold());
        assertEquals(40.0, t2.getHarvestThreshold());
    }

    @Test
    void testPremiumCare() {
        assertFalse(t1 instanceof IPremiumCare);
    }
}