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

}