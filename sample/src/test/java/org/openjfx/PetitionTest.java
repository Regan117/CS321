package org.openjfx;

import static org.junit.Assert.*;

import org.junit.Test;

public class PetitionTest{
	public String name = "John joe doe";
	public int DOB = 12311999;
	public String Email = "john@gmail.com";
	public String Country = "Brazil";
	public int ANum = 123456789;
	public petition mockDB[] = new petition[5];

	public final petition p = new petition( name,DOB, Email, Country, ANum);
	public final petition p1 = new petition( "james bo cane",12341989, Email, Country, 999999999);

	@Test
	public void testValidateEntry()throws Exception {
		//Petition p = new Petition( name,DOB, Email, Country, ANum);
		/*assertTrue(name instanceof String);
		assertTrue(p.ValidateEntry(name,DOB,Email,Country,ANum)); */
		assertEquals(true, p.ValidateEntry(name,DOB,Email,Country,ANum));
		assertEquals(false, p.ValidateEntry(name,934372849,Email,Country,ANum));
		assertEquals(false, p.ValidateEntry("123",DOB,Email,Country,ANum));
		assertEquals(false, p.ValidateEntry(name,DOB,"john",Country,ANum));
		assertEquals(false, p.ValidateEntry(name,934372849,Email,"UnitedStates",ANum));
		assertEquals(false, p.ValidateEntry(name,DOB,Email,Country,-2));
		assertEquals(false, p.ValidateEntry(null,DOB,Email,Country,ANum));
		assertEquals(false, p.ValidateEntry(name,-2,Email,Country,ANum));
		assertEquals(false, p.ValidateEntry(name,DOB,null,Country,ANum));
		assertEquals(false, p.ValidateEntry(name,DOB,Email,null,ANum));
	}

	@Test
	public void testSearchDB() throws Exception {
		mockDB[0] = p;

		//returns false if petition is not flaged in the database
		//returns true if petition is not already in the data base
		assertFalse(p.SearchDB(null));
		assertFalse( p.SearchDB(p));
		assertTrue(p1.SearchDB(p1));
	}

	@Test
	public void testPullFromDB() throws Exception {
		mockDB[0] = p;
		//true if petiton is pulled, false otherwise or invalid ANum
		assertTrue(p.PullFromDB(ANum));
		assertFalse(p.PullFromDB(-2));
		assertFalse(p.PullFromDB(0));
		assertFalse(p1.PullFromDB(999999999));
	}

	@Test
	public void testWriteToDB() throws Exception {
		mockDB[0] = p;
		//true if it was able to write false if the petition to write is null or already in DB
		assertTrue(p1.WriteToDB(p1));
		assertFalse(p.WriteToDB(null));
		assertFalse(p.WriteToDB(p));
	}

}


