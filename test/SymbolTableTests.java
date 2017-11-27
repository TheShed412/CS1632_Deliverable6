
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
			return; //the test will pass
		}

		fail();
	}

	/**
	 * This test will check that two different keys with
	 * the same value are stored correctly
	*/
	@Test
	public void sameValueDifferentKey() {

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

}