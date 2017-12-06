import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import java.math.BigInteger;

import rpnpackage.*;

public class ExpressionTest {

	@Test
	public void evaluateSimpleTest() throws Exception {
		String rpnStr = "3 2 -";
		int expected = 1;

		Expression exp = new Expression(rpnStr);

		SymbolTable st = Mockito.mock(SymbolTable.class);

		BigInteger actualBI = exp.evaluate(st);

		int actual = getInt(actualBI);

		assertEquals(actual, expected);
	}

	private int getInt(BigInteger bi) {
		String str = bi.toString();
		return Integer.parseInt(str);
	}

}