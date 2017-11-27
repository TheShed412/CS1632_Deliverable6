package rpnpackage;

import java.util.HashMap;

/**
 * This will be the table the stores all of the variables
 * 
 * It should be fast for look up and the variables are
 * case-insensitive (a = A) so we will store the lowercase
*/

public class SymbolTable extends HashMap<String, Integer> {


	/**
	 * Overriding the hashmap put method
	 * 
	 * if the value is already in the map, throw exception
	 * if not
	 * 	- make lowercase
	 * 	- add to map
	*/
	@Override
	public Integer put(String key, Integer value){

		return value;
	}

}