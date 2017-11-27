
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;

import rpnpackage.SymbolTable;

public class SymbolTableTests {
	
	/**
	 * Tests whether the put will throw an exception
	 * when the same key is already in the symbol table
	*/
	@Test
	public void exceptionPutTest() {

		SymbolTable st = new SymbolTable();
		
		try{
			st.put("a", 99);
			st.put("b", 91);
			st.put("a", 13);

		} catch (Exception e) {
			return; //the test will pass
		}

		fail();
	}

}