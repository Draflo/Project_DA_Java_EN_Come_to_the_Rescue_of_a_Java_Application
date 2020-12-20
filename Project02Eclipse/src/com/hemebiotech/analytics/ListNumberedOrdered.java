package com.hemebiotech.analytics;

import java.util.stream.Collectors;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;

/**
 * Getting a List of String into a Map alphabetically ordered. 
 * And also associate each input with its number of occurrences. 
 */
public class ListNumberedOrdered {

	private List<String> filepath;

	public ListNumberedOrdered(List<String> filepath) {
		this.filepath = filepath;
	}

	public Map<String, Long> listnumberedordered() {
		Map<String, Long> ListNumbered = filepath.stream()
				.collect(Collectors.groupingBy(e -> e, TreeMap::new, Collectors.counting()));
		return ListNumbered;
	}
}