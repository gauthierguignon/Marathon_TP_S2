package tp08_supp;

/*
javac -d bin -cp bin src/tp08_supp/*.java
javac -d bin -cp bin:/usr/share/java/junit-platform-console-standalone.jar test/tp08_supp/BreedingGroundTest.java
java -jar /usr/share/java/junit-platform-console-standalone.jar execute -cp bin -c tp08_supp.BreedingGroundTest
*/


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BreedingGroundTest {
	public Participant p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
	public BreedingGround v1,v2,v3;
	public List<Participant> partList;
	public Set<Participant> partSet;
	
	@BeforeEach
	public void initTest() {
		partList = new ArrayList<Participant>();
		partSet = new HashSet<Participant>();
		
		p1 = new Participant("alice");
		p2 = new Participant("bruno"); // the cheater registered in v1 and v3
		p3 = new Participant("clement");
		p4 = new Participant("dominique");
		p5 = new Participant("elia");
		p6 = new Participant("flore");
		p7 = new Participant("gudul");
		p8 = new Participant("hercule");
		p9 = new Participant("isidor");
		p10 = new Participant("jules");
		// appariement des participants
		p1.matchWith(p2);
		p5.matchWith(p6);
		p8.matchWith(p9);

		v1 = new BreedingGround();
		v1.registration(p1);
		v1.registration(p2);
		v1.registration(p3);
		v1.registration(p4);
		v2 = new BreedingGround();
		v2.registration(p5);
		v2.registration(p6);
		v3 = new BreedingGround();
		v3.registration(p8);
		v3.registration(p9);
		v3.registration(p10);
		v3.registration(p2);
	}
	
	@Test
	public void testRegistration() {
		assertEquals(4, v1.getApplicants().size());
		assertTrue(v1.getApplicants().contains(p1) && v1.getApplicants().contains(p2) 
				&& v1.getApplicants().contains(p3) && v1.getApplicants().contains(p4));
		v1.clear();
		assertEquals(Collections.emptySet(), v1.getApplicants());
		assertTrue(v1.registration(p1));
		assertEquals(1, v1.getApplicants().size());
		assertTrue(v1.getApplicants().contains(p1));
		assertFalse(v1.registration(p1));
	}
	@Test
	public void testLoners() {
		assertEquals(0, v2.loners().size());
		assertEquals(Collections.emptyList(), v2.loners());
		partList = v1.loners();
		assertEquals(2, partList.size());
		assertTrue(partList.contains(p3) && partList.contains(p4));
	}
	@Test
	public void testLonersCleansing() {
		v1.lonersCleansing();
		assertEquals(2, v1.getApplicants().size());
		assertTrue(v1.getApplicants().contains(p1) && v1.getApplicants().contains(p2));
		v2.lonersCleansing();
		assertEquals(2, v2.getApplicants().size());
		assertTrue(v2.getApplicants().contains(p5) && v2.getApplicants().contains(p6));
	}
	@Test
	public void testCheaters() {
		assertEquals(Collections.emptyList(), v1.cheaters(v2));
		partList.add(p2);
		assertEquals(partList, v1.cheaters(v3));
	}
	@Test
	public void testCheatersBan() {
		assertTrue(p1.isMatchedWith(p2));
		assertTrue(p2.isMatchedWith(p1));
		v1.isolateCheater(p2);
		assertFalse(p1.isMatchedWith(p2));
		assertFalse(p2.isMatchedWith(p1));
	}
	@Test
	public void testCheatersCleansing() {
		partSet = v1.getApplicants();
		v1.cheatersCleansing(v2);
		assertEquals(partSet, v1.getApplicants());
		partSet.clear();
		partSet.add(p1); partSet.add(p3); partSet.add(p4);
		v1.cheatersCleansing(v3);
		assertEquals(partSet, v1.getApplicants());
	}
	@Test
	public void testPossibleMerging() {
		assertFalse(v1.possibleMerging(v1));
		assertTrue(v1.possibleMerging(v2));
		assertFalse(v1.possibleMerging(v3));
	}
	@Test
	public void testMerge() {
		partSet = v1.getApplicants();
		partSet.addAll(v2.getApplicants());
		v1.merging(v2);
		assertEquals(partSet, v1.getApplicants());
		partSet.clear();
		partSet.addAll(v1.getApplicants());
		partSet.addAll(v2.getApplicants());
		partSet.addAll(v3.getApplicants());
		v1.merging(v3);
		assertEquals(partSet, v1.getApplicants());
	}
	@Test
	public void testSecuredMerging() {
		partSet = v1.getApplicants();
		partSet.add(p8); partSet.add(p9); partSet.add(p10);
		v1.securedMerging(v3);
		assertEquals(partSet, v1.getApplicants());
		partSet.addAll(v2.getApplicants());
		v1.securedMerging(v2);
		assertEquals(partSet, v1.getApplicants());
	}
}
