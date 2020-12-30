package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This program allows you to retrieve a list of String from a file, order them
 * alphabetically, counts the number of occurrences, and then deliver the output
 * in a result file.
 * 
 * @author Draflo
 *
 */
public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {

		ISymptomReader symptomreader = new ReadSymptomDataFromFile("symptoms.txt");
		// List of symptoms as it is in the file
		List<String> listsymptom = new ArrayList<String>();
		// Create a permanent list to add what ISymptom reader gets
		listsymptom.addAll(symptomreader.GetSymptoms());
		System.out.println(listsymptom);

		ListNumberedOrdered readytoprint = new ListNumberedOrdered(listsymptom);
		// List of symptoms ordered and with occurrences
		Map<String,Long> symptomcountorder = new TreeMap<String,Long>();
		// Create a permanent map to add our map ordered and counted
		symptomcountorder.putAll(readytoprint.ListCountOrder());
		System.out.println(symptomcountorder);
		

		ResultsWriter results = new ResultsWriter(symptomcountorder);
		results.writeToFile();

	}
}
