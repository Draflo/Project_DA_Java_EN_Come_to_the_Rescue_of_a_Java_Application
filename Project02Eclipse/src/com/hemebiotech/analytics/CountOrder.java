package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Gets a list of string from anything, count the number of occurrences and then
 * orders it alphabetically in a map
 * 
 * @author Draflo
 *
 */
public interface CountOrder {
	/**
	 * Create a map to add each symptom associated with its number of occurrences
	 * 
	 * @return A map alphabetically ordered where Long represents the number of
	 *         occurrences of the correspondent String
	 */
	Map<String, Long> listCountOrder();

}
