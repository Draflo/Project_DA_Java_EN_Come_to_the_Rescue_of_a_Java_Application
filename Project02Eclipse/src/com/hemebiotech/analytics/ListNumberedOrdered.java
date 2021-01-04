package com.hemebiotech.analytics;

import java.util.stream.Collectors;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;

/**
 * Gets the List of String into a Map alphabetically ordered. And also
 * associate each input with its number of occurrences.
 */
public class ListNumberedOrdered implements CountOrder {

	private List<String> filepath;

	/**
	 * 
	 * @param filepath a full or partial path to the list of symptom extracted by
	 *                 ISymptomReader
	 */

	public ListNumberedOrdered(List<String> filepath) {
		this.filepath = filepath;
	}

	@Override
	public Map<String, Long> listCountOrder() {
		return filepath.stream().collect(Collectors.groupingBy(e -> e, TreeMap::new, Collectors.counting()));

	}
}