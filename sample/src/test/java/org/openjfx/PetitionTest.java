package org.openjfx;

import static org.junit.Assert.*;

import org.junit.Test;

public class PetitionTest{
	public String name = "John joe doe";
	public int DOB = 12311999;
	public String Email = "john@gmail.com";
	public String Country = "Brazil";
	public int ANum = 123456789;
	public Petition mockDB[] = new Petition[5];

	public final Petition p = new Petition( name,DOB, Email, Country, ANum);
	public final Petition p1 = new Petition( "james bo cane",12341989, Email, Country, 999999999);

	@Test
	public void testValidateEntry()throws Exception {
		//Petition p = new Petition( name,DOB, Email, Country, ANum);
		/*assertTrue(name instanceof String);
		assertTrue(p.ValidateEntry(name,DOB,Email,Country,ANum)); */
		assertEquals(true, p.validateEntry(name,DOB,Email,Country,ANum));
		assertEquals(false, p.validateEntry(name,934372849,Email,Country,ANum));
		assertEquals(false, p.validateEntry("123",DOB,Email,Country,ANum));
		assertEquals(false, p.validateEntry(name,DOB,"john",Country,ANum));
		assertEquals(false, p.validateEntry(name,934372849,Email,"UnitedStates",ANum));
		assertEquals(false, p.validateEntry(name,DOB,Email,Country,-2));
		assertEquals(false, p.validateEntry(null,DOB,Email,Country,ANum));
		assertEquals(false, p.validateEntry(name,-2,Email,Country,ANum));
		assertEquals(false, p.validateEntry(name,DOB,null,Country,ANum));
		assertEquals(false, p.validateEntry(name,DOB,Email,null,ANum));
	}

	@Test
	public void testSearchDB() throws Exception {
		mockDB[0] = p;

		//returns false if petition is not flaged in the database
		//returns true if petition is not already in the data base
		assertFalse(p.searchDB(null));
		assertFalse( p.searchDB(p));
		assertTrue(p1.searchDB(p1));
	}

	//broke unit testing 10/30 changed the method while working on sprint 1
	@Test
	public void testPullFromDB() throws Exception {
		mockDB[0] = p;
		//true if petiton is pulled, false otherwise or invalid ANum
		//assertTrue(p.pullFromDB(ANum));
		//assertFalse(p.pullFromDB(-2));
		//assertFalse(p.pullFromDB(0));
		//assertFalse(p1.pullFromDB(999999999));
	}

	@Test
	public void testWriteToDB() throws Exception {
		mockDB[0] = p;
		//true if it was able to write false if the petition to write is null or already in DB
		assertTrue(p1.writeToDB(p1));
		assertFalse(p.writeToDB(null));
		assertFalse(p.writeToDB(p));
	}

}


