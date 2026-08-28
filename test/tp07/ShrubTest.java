package tpOO.tp07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShrubTest {
    public int id1, id2, id3;
    public double s1, s2, s3;
    public Shrub srb1, srb2, srb3;

    @BeforeEach
    void testInitialization() {
        id1=10; id2=20; id3=30;
        s1=10.0; s2=100.0; s3=120.0;
        srb1 = new Shrub(id1, s1);
        srb2 = new Shrub(id2, s2);
        srb3 = new Shrub(id3, s3);

        srb1.setPricePerUnit(5.0);
        srb1.setHarvestThreshold(100.0);
    }

    @Test
    void testGetIdentity() {
        assertEquals(id1, srb1.getIdentity());
        assertEquals(id2, srb2.getIdentity());
        assertEquals(id3, srb3.getIdentity());
    }

    @Test
    void testSetIdentity() {
        srb1.setIdentity(id2);
        assertEquals(id2, srb1.getIdentity());
    }

    @Test
    void testGetSize() {
        assertEquals(s1, srb1.getSize());
        assertEquals(s2, srb2.getSize());
        assertEquals(s3, srb3.getSize());
    }

    @Test
    void testSetSize() {
        srb1.setSize(s2);
        assertEquals(s2, srb1.getSize());
    }

    @Test
    void testGetPricePerUnit() {
        assertEquals(5.0, srb1.getPricePerUnit());
    }

    @Test
    void testGetHarvestThreshold() {
        assertEquals(100.0, srb1.getHarvestThreshold());
    }

    @Test
    void testGetPrice() {
        assertEquals(s1*srb1.getPricePerUnit(), srb1.getPrice());
        assertEquals(s2*srb2.getPricePerUnit(), srb2.getPrice());
        assertEquals(s3*srb3.getPricePerUnit(), srb3.getPrice());
    }

    @Test
    void testIsMature() {
        assertFalse(new Shrub(1, 99.9).isMature());
        assertTrue(new Shrub(2, 100.0).isMature());
        assertTrue(new Shrub(3, 100.1).isMature());
    }

    @Test
    void testToString() {
        assertEquals("Shrub [10,10.0]", srb1.toString());
    }

    @Test
    void testSetPricePerUnit() {
        srb1.setPricePerUnit(6.0);
        assertEquals(6.0, srb1.getPricePerUnit());
        assertEquals(6.0, srb2.getPricePerUnit());
    }

    @Test
    void testSetHarvestThreshold() {
        srb1.setHarvestThreshold(110.0);
        assertEquals(110.0, srb1.getHarvestThreshold());
        assertEquals(110.0, srb2.getHarvestThreshold());
    }

    @Test
    void testPremiumCare() {
        assertTrue(srb1 instanceof IPremiumCare);
    }
}