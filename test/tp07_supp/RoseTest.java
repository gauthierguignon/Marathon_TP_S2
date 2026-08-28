package tp07_supp;

/*
javac -d bin -cp bin src/tp07_supp/*.java
javac -d bin -cp bin:/usr/share/java/junit-platform-console-standalone.jar test/tp07_supp/TulipTest.java
java -jar /usr/share/java/junit-platform-console-standalone.jar execute -cp bin -c tp07_supp.Tulip
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RoseTest {
    public int id1, id2, id3;
    public double s1, s2, s3;
    public Rose r1, r2, r3;

    @BeforeEach
    void testInitialization() {
        id1=10; id2=20; id3=30;
        s1=10.0; s2=50.0; s3=60.0;
        r1 = new Rose(id1, s1);
        r2 = new Rose(id2, s2);
        r3 = new Rose(id3, s3);

        r1.setPricePerUnit(2.0);
        r1.setHarvestThreshold(50.0);
    }

    @Test
    void testGetIdentity() {
        assertEquals(id1, r1.getIdentity());
        assertEquals(id2, r2.getIdentity());
        assertEquals(id3, r3.getIdentity());
    }

    @Test
    void testSetIdentity() {
        r1.setIdentity(id2);
        assertEquals(id2, r1.getIdentity());
    }

    @Test
    void testGetSize() {
        assertEquals(s1, r1.getSize());
        assertEquals(s2, r2.getSize());
        assertEquals(s3, r3.getSize());
    }

    @Test
    void testSetSize() {
        r1.setSize(s2);
        assertEquals(s2, r1.getSize());
    }

    @Test
    void testGetPricePerUnit() {
        assertEquals(2.0, r1.getPricePerUnit());
    }

    @Test
    void testGetHarvestThreshold() {
        assertEquals(50.0, r1.getHarvestThreshold());
    }

    @Test
    void testGetPrice() {
        assertEquals(s1*r1.getPricePerUnit(), r1.getPrice());
        assertEquals(s2*r2.getPricePerUnit(), r2.getPrice());
        assertEquals(s3*r3.getPricePerUnit(), r3.getPrice());
    }

    @Test
    void testIsMature() {
        assertFalse(new Rose(1, 49.9).isMature());
        assertTrue(new Rose(2, 50.0).isMature());
        assertTrue(new Rose(3, 50.1).isMature());
    }

    @Test
    void testToString() {
        assertEquals("Rose [10,10.0]", r1.toString());
    }

    @Test
    void testSetPricePerUnit() {
        r1.setPricePerUnit(3.0);
        assertEquals(3.0, r1.getPricePerUnit());
        assertEquals(3.0, r2.getPricePerUnit());
    }

    @Test
    void testSetHarvestThreshold() {
        r1.setHarvestThreshold(60.0);
        assertEquals(60.0, r1.getHarvestThreshold());
        assertEquals(60.0, r2.getHarvestThreshold());
    }

    @Test
    void testPremiumCare() {
        assertTrue(r1 instanceof IPremiumCare);
    }
}