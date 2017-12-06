
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import java.math.BigInteger;

import rpnpackage.SymbolTable;

public class SymbolTableTests {
	
	/**
	 * Tests whether the put will throw an exception
	 * when the same key is already in the symbol table
	*/
	@Test
	public void exceptionPutTest() {

		SymbolTable st = new SymbolTable();

		try {

			st.put("a", 99);
			st.put("b", 91);
			st.put("a", 13);

		} catch (Exception e) {
			System.out.println("Cannot store the same symbol");
			return; //the test will pass
		}

		fail();
	}

	/**
	 * This test will check that two different keys with
	 * the same value are stored correctly
	*/
	@Test
	public void sameValueDifferentKey() throws Exception {

		SymbolTable st = new SymbolTable();

		String aKey = "a";
		String bKey = "b";
		
		try {

			st.put(aKey, 5);
			st.put(bKey, 5);

		} catch (Exception e) {
			fail();
		}

		BigInteger aValue = st.get(aKey);
		BigInteger bValue = st.get(bKey);

		assertEquals(aValue, bValue);
	}

	/**
	 * This test will check to see that variables with 
	 * different case are not stored in the same table
	*/
	@Test
	public void caseTest() {

		SymbolTable st = new SymbolTable();

		String capKey = "A";
		String lowKey = "a";

		try {
			st.put(capKey, 1);
			st.put(lowKey, 5);
		} catch (Exception e) {
			System.out.println("Cannot store the same symbol");
			return; //the test will pass
		}

		fail();

	}

}