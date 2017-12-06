package rpnpackage;

import java.util.HashMap;
import java.math.BigInteger;

/**
 * This will be the table the stores all of the variables
 * 
 * It should be fast for look up and the variables are
 * case-insensitive (a = A) so we will store the lowercase
 * 
 * We extend hash mapusing string and biginteger for generics
*/

public class SymbolTable extends HashMap<String, BigInteger> {


	/**
	 * Overriding the hashmap put method
	 * 
	 * if the value is already in the map, throw exception
	 * if not
	 * 	- make lowercase
	 * 	- add to map
	*/
	@Override
	public BigInteger put(String key, BigInteger value){

		key = key.toLowerCase();

		if (this.containsKey(key)) {
			throw new IllegalStateException("symbol already in table");
		} else {
			super.put(key, value);
		}

		return value;
	}

	/**
	 * Overloading the hashmap put method
	 * 
	 * I just make the integer value coming in in to a 
	 * BigInteger value. This will be for any number that is
	 * not big enough to be e big int but so that we can 
	 * seemlessly use one method
	 * 
	 * Also returns the biginteger version of the number
	*/
	public BigInteger put(String key, Integer _value){

		key = key.toLowerCase();
		BigInteger value = new BigInteger(_value.toString());

		put(key, value);

		return value;
	}

	/**
	 * This will overridde the hashmaps get method
	 * 
	 * We will throw an exception if the value returned
	 * is null
	*/

	public BigInteger get(String key) throws Exception{

		BigInteger value = super.get(key);

		if (value == null) {
			throw new Exception("variable" + key + "was not initialized");
		}

		return value;
	}

}