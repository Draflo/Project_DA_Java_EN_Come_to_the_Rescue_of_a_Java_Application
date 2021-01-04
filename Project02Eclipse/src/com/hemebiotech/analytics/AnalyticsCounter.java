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

	static Map<String, Long> symptomcountorder = new TreeMap<String, Long>();
	/**
	 * Create a permanent map to add our map ordered and counted
	 */
	static List<String> listsymptom = new ArrayList<String>();

	/**
	 * Create a permanent list to add what ISymptom reader gets
	 */
	public static void main(String args[]) throws Exception {

		ISymptomReader symptomreader = new ReadSymptomDataFromFile("symptoms.txt");
		/**
		 * List of symptoms as it is in the file
		 */

		listsymptom.addAll(symptomreader.getSymptoms());

		ListNumberedOrdered readytoprint = new ListNumberedOrdered(listsymptom);
		/**
		 * List of symptoms ordered and with occurrences
		 */

		symptomcountorder.putAll(readytoprint.listCountOrder());

		ResultsWriter results = new ResultsWriter(symptomcountorder);
		results.writetofile();
		
		System.out.println("The results of the data extraction is located in the result.out file");

	}
}
