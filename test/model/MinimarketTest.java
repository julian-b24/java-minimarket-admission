package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import exceptions.NotMatchIdDateException;
import exceptions.TiTypeException;

class MinimarketTest {

	private Minimarket market;
	
	public void setupScenary1() {	
		market = new Minimarket(LocalDate.parse("2021-02-20"));
	}
	
	public void setupScenary2() {
		market = new Minimarket(LocalDate.parse("2021-02-15"));
	}
	
	public void setupScenary3() {
		market = new Minimarket(LocalDate.parse("2021-02-06"));
		market.getPersons().add(new Person("4783297", "CC"));
		market.setNumAttemps(4);
	}
	
	public void setupScenary4() {
		market = new Minimarket(LocalDate.parse("2021-02-07"));
		market.getPersons().add(new Person("234443", "CC"));
		market.getPersons().add(new Person("1919121", "PP"));
	}
	
	@Test
	public void testAdmissionEvenDayAdmitted() {
		
		try {
			setupScenary1();
			String id1 = "12477654";
			String type1 = "CC";
			assertEquals(true, market.addmission(id1, type1));
			assertEquals(1, market.getPersons().size());
			assertEquals(1, market.getNumAttemps());
			
			setupScenary1();
			String id2 = "10572298";
			String type2 = "PP";
			assertEquals(true, market.addmission(id2, type2));
			assertEquals(1, market.getPersons().size());
			assertEquals(1, market.getNumAttemps());
			
			setupScenary1();
			String id3 = "13605272";
			String type3 = "CE";
			assertEquals(true, market.addmission(id3, type3));
			assertEquals(1, market.getPersons().size());
			assertEquals(1, market.getNumAttemps());
			
		} catch (NotMatchIdDateException dateExcp) {
			fail("Excepción fecha lanzada");
		} catch(TiTypeException tiExcp) {
			fail("Excepción TI lanzada");
		}
	}
	
	@Test
	public void testAdmissionOddDayAdmitted() {
		
		try {
			setupScenary2();
			String id1 = "372184721";
			String type1 = "CC";
			assertEquals(true, market.addmission(id1, type1));
			assertEquals(1, market.getPersons().size());
			assertEquals(1, market.getNumAttemps());
			
			setupScenary2();
			String id2 = "367284362";
			String type2 = "PP";
			assertEquals(true, market.addmission(id2, type2));
			assertEquals(1, market.getPersons().size());
			assertEquals(1, market.getNumAttemps());
			
			setupScenary2();
			String id3 = "567839262";
			String type3 = "CE";
			assertEquals(true, market.addmission(id3, type3));
			assertEquals(1, market.getPersons().size());
			assertEquals(1, market.getNumAttemps());
			
		} catch (NotMatchIdDateException dateExcp) {
			fail(dateExcp.toString());
		} catch(TiTypeException tiExcp) {
			fail(tiExcp.toString());
		}
	}
	
	@Test
	public void testAdmissionTiId1() {
		
		setupScenary1();
		String id1 = "20194040";
		String type1 = "TI";
		try {
			market.addmission(id1, type1);
			fail("Person not Rejected");
		} catch (NotMatchIdDateException dateExcp) {
			fail("Person Rejected by the wrong reason");
		} catch (TiTypeException tiExcp) {
			assertEquals(id1, tiExcp.getId());
			assertEquals(1, market.getNumAttemps());
		}
		
		setupScenary2();
		String id2 = "20173030";
		String type2 = "TI";
		try {
			market.addmission(id2, type2);
			fail("Person not Rejected");
		} catch (NotMatchIdDateException dateExcp) {
			fail("Person Rejected by the wrong reason");
		} catch (TiTypeException tiExcp) {
			assertEquals(id2, tiExcp.getId());
			assertEquals(1, market.getNumAttemps());
		}
		
	}
	
	@Test
	public void testAdmissionEvenDayRejected() {
		
		setupScenary1();
		String id1 = "5657666";
		String type1 = "CC";
		try {
			market.addmission(id1, type1);
			fail("Person not Rejected");
		} catch (NotMatchIdDateException dateExcp) {
			assertEquals(id1, dateExcp.getId());
			assertEquals(1, market.getNumAttemps());
			
		} catch (TiTypeException tiExcp) {
			fail("Person Rejected by the wrong reason");
		}
		
		
		setupScenary1();
		String id2 = "45783844";
		String type2 = "PP";
		try {
			market.addmission(id2, type2);
			fail("Person not Rejected");
		} catch (NotMatchIdDateException dateExcp) {
			assertEquals(id2, dateExcp.getId());
			assertEquals(1, market.getNumAttemps());
			
		} catch (TiTypeException tiExcp) {
			fail("Person Rejected by the wrong reason");
		}
		
		setupScenary1();
		String id3 = "67676381";
		String type3 = "CE";
		try {
			market.addmission(id3, type3);
			fail("Person not Rejected");
		} catch (NotMatchIdDateException dateExcp) {
			assertEquals(id3, dateExcp.getId());
			assertEquals(1, market.getNumAttemps());
			
		} catch (TiTypeException tiExcp) {
			fail("Person Rejected by the wrong reason");
		}
		
	}
	
	public void testAdmissionOddDayRejected() {
		
		setupScenary2();
		String id1 = "7878998";
		String type1 = "CC";
		try {
			market.addmission(id1, type1);
			fail("Person not Rejected");
		} catch (NotMatchIdDateException dateExcp) {
			assertEquals(id1, dateExcp.getId());
			assertEquals(1, market.getNumAttemps());
			
		} catch (TiTypeException tiExcp) {
			fail("Person Rejected by the wrong reason");
		}
		
		
		setupScenary2();
		String id2 = "4564572";
		String type2 = "PP";
		try {
			market.addmission(id2, type2);
			fail("Person not Rejected");
		} catch (NotMatchIdDateException dateExcp) {
			assertEquals(id2, dateExcp.getId());
			assertEquals(1, market.getNumAttemps());
			
		} catch (TiTypeException tiExcp) {
			fail("Person Rejected by the wrong reason");
		}
		
		setupScenary2();
		String id3 = "62347833";
		String type3 = "CE";
		try {
			market.addmission(id3, type3);
			fail("Person not Rejected");
		} catch (NotMatchIdDateException dateExcp) {
			assertEquals(id3, dateExcp.getId());
			assertEquals(1, market.getNumAttemps());
			
		} catch (TiTypeException tiExcp) {
			fail("Person Rejected by the wrong reason");
		}
		
	}

}
