package tp07;

// javac -d bin -cp bin:lib/tp07-res.jar src/tp07/*.java
// javac -d bin -cp bin:/usr/share/java/junit-platform-console-standalone.jar:lib/tp07-res.jar test/tp07/ProPhoneNumberTest.java 
// java -jar /usr/share/java/junit-platform-console-standalone.jar execute -cp bin:lib/tp07-res.jar -c tp07.ProPhoneNumberTest


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProPhoneNumberTest {
    public String s1, s2;
    public ProPhoneNumber un, deux, trois, quatre;

    @BeforeEach
    void initialization() {
        s1 = "1234";
        s2 = "1111";
        un = new ProPhoneNumber(s1, UniversityDepartment.IUT);
        deux = new ProPhoneNumber(s1, UniversityDepartment.FST);
        trois = new ProPhoneNumber(s2, UniversityDepartment.IUT);
        quatre = new ProPhoneNumber(s1, UniversityDepartment.IUT);
    }

    @Test
    void testEquals() {
        assertTrue(un.equals(un));
        assertFalse(un.equals(deux));
        assertFalse(un.equals(trois));
        assertTrue(un.equals(quatre));
        assertFalse(deux.equals(trois));
        assertFalse(deux.equals(quatre));
    }

    @Test
    void testEquals2() {
        assertTrue(un.equals(s1));
        assertFalse(un.equals(s2));
        assertTrue(deux.equals(s1));
        assertFalse(deux.equals(s2));
    }

    @Test
    void testInternToString() {
        String res = "31234(" + UniversityDepartment.IUT.getLabelShort() + ")";
        assertEquals(res, un.internToString());
        res = "21234(" + UniversityDepartment.FST.getLabelShort() + ")";
        assertEquals(res, deux.internToString());
        res = "31111(" + UniversityDepartment.IUT.getLabelShort() + ")";
        assertEquals(res, trois.internToString());
        res = "31234(" + UniversityDepartment.IUT.getLabelShort() + ")";
        assertEquals(res, quatre.internToString());
    }

    @Test
    void testExternToString() {
        String res = "+33.3.20.03.12.34 (" + UniversityDepartment.IUT.getLabelLong() + ")";
        assertEquals(res, un.externToString());
        res = "+33.3.20.02.12.34 (" + UniversityDepartment.FST.getLabelLong() + ")";
        assertEquals(res, deux.externToString());
        res = "+33.3.20.03.11.11 (" + UniversityDepartment.IUT.getLabelLong() + ")";
        assertEquals(res, trois.externToString());
        res = "+33.3.20.03.12.34 (" + UniversityDepartment.IUT.getLabelLong() + ")";
        assertEquals(res, quatre.externToString());
    }

    @Test
    void testGetDepartment() {
        assertEquals(UniversityDepartment.IUT, un.getDepartment());
        assertEquals(UniversityDepartment.FST, deux.getDepartment());
        assertEquals(UniversityDepartment.IUT, trois.getDepartment());
        assertEquals(UniversityDepartment.IUT, quatre.getDepartment());
    }
}
