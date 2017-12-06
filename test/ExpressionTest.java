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

	/**
	 * Testing that multi-digit numbers are treated as numbers
	*/

	@Test
	public void evaluateDoubleDigitTest() throws Exception {
		String rpnStr = "12 3 - 3 /";
		int expected = 3;

		Expression exp = new Expression(rpnStr);

		SymbolTable st = Mockito.mock(SymbolTable.class);

		BigInteger actualBI = exp.evaluate(st);

		int actual = getInt(actualBI);

		assertEquals(actual, expected);
	}

	/**
	 * Testing that negative numbers are evaluated correctly
	*/

	@Test
	public void evaluateNegativeTest() throws Exception {
		String rpnStr = "-3";
		int expected = -3;

		Expression exp = new Expression(rpnStr);

		SymbolTable st = Mockito.mock(SymbolTable.class);

		BigInteger actualBI = exp.evaluate(st);

		int actual = getInt(actualBI);

		assertEquals(actual, expected);
	}

	@Test
	public void evaluateNegative2Test() throws Exception {
		String rpnStr = "-3 2 +";
		int expected = -1;

		Expression exp = new Expression(rpnStr);

		SymbolTable st = Mockito.mock(SymbolTable.class);

		BigInteger actualBI = exp.evaluate(st);

		int actual = getInt(actualBI);

		assertEquals(actual, expected);
	}

	/**
	 * Cases of really big and really small numbers
	*/

	@Test
	public void evaluateBigNumTest() throws Exception {
		String rpnStr = "9999999999999999999999999 " +
							"1234635373264729 +";
		String expected = "10000000001234635373264728";

		Expression exp = new Expression(rpnStr);

		SymbolTable st = Mockito.mock(SymbolTable.class);

		BigInteger actualBI = exp.evaluate(st);

		String actual = actualBI.toString();

		assertEquals(actual, expected);
	}

	@Test
	public void evaluateSmallNumTest() throws Exception {
		String rpnStr = "-9999999999999999999999999 " +
							"9999999999999999999999999 +";
		String expected = "0";

		Expression exp = new Expression(rpnStr);

		SymbolTable st = Mockito.mock(SymbolTable.class);

		BigInteger actualBI = exp.evaluate(st);

		String actual = actualBI.toString();

		assertEquals(actual, expected);
	}

	/**
	 * Tests that are for invalid expressions
	*/
	
	@Test
	public void invalideExpressionTest() throws Exception {
		String invalideRpn = "3 4";

		Expression exp = new Expression(invalideRpn);

		SymbolTable st = Mockito.mock(SymbolTable.class);

		try {
			exp.evaluate(st);
		} catch (Exception e) {
			return;
		}

		fail();
	}

	@Test
	public void invalideExpressionTest2() throws Exception {
		String invalideRpn = "3 4 + +";

		Expression exp = new Expression(invalideRpn);

		SymbolTable st = Mockito.mock(SymbolTable.class);

		try {
			exp.evaluate(st);
		} catch (Exception e) {
			return;
		}

		fail();
	}

	@Test
	public void invalideExpressionTest3() throws Exception {
		String invalideRpn = "3 4 6 +";

		Expression exp = new Expression(invalideRpn);

		SymbolTable st = Mockito.mock(SymbolTable.class);

		try {
			exp.evaluate(st);
		} catch (Exception e) {
			return;
		}

		fail();
	}

	@Test
	public void invalideExpressionTest4() throws Exception {
		String invalideRpn = "* +";

		Expression exp = new Expression(invalideRpn);

		SymbolTable st = Mockito.mock(SymbolTable.class);

		try {
			exp.evaluate(st);
		} catch (Exception e) {
			return;
		}

		fail();
	}

	@Test
	public void invalideExpressionTest5() throws Exception {
		String invalideRpn = "&";

		Expression exp = new Expression(invalideRpn);

		SymbolTable st = Mockito.mock(SymbolTable.class);

		try {
			exp.evaluate(st);
		} catch (Exception e) {
			return;
		}

		fail();
	}

	private int getInt(BigInteger bi) {
		String str = bi.toString();
		return Integer.parseInt(str);
	}

}