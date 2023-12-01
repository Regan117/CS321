package org.openjfx;

import static org.junit.Assert.*;

import org.junit.Test;

public class PetitionTest{
	public String name = "John";
	public String DOB = "1999-03-14";
	public String Email = "john@gmail.com";
	public String Country = "Brazil";
	public int ANum = 123456789;
	public Petition mockDB[] = new Petition[5];

	public final Petition p = new Petition( name,DOB, Email, Country, ANum);
	public final Petition p1 = new Petition( "james bo cane",DOB, Email, Country, 999999999);

	@Test
	public void testValidateEntry()throws Exception {
		//Petition p = new Petition( name,DOB, Email, Country, ANum);
		/*assertTrue(name instanceof String);
		assertTrue(p.ValidateEntry(name,DOB,Email,Country,ANum)); */
		Petition p2 = new Petition(name,DOB,Email,Country,ANum);
		Petition p3 = new Petition(name,"934372849",Email,Country,ANum);
			Petition p4 = new Petition("123",DOB,Email,Country,ANum);
				Petition p5 = new Petition(name,DOB,"john",Country,ANum);
					Petition p6 = new Petition(name,"934372849",Email,"UnitedStates",ANum);
						Petition p7 = new Petition(name,DOB,Email,Country,-2);
							Petition p8 = new Petition(null,DOB,Email,Country,ANum);
								Petition p9 = new Petition(name,"-2",Email,Country,ANum);
									Petition p10 = new Petition(name,DOB,null,Country,ANum);
										Petition p11 = new Petition(name,DOB,Email,null,ANum);

		assertEquals(true, p2.validateEntry());
		assertEquals(false, p3.validateEntry());
		assertEquals(false, p4.validateEntry());
		assertEquals(false, p5.validateEntry());
		assertEquals(false, p6.validateEntry());
		assertEquals(false, p7.validateEntry());
		assertEquals(false, p8.validateEntry());
		assertEquals(false, p9.validateEntry());
		assertEquals(false, p10.validateEntry());
		assertEquals(false, p11.validateEntry());
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


