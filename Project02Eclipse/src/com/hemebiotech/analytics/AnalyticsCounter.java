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

		ISymptomReader symptomReader = new ReadSymptomDataFromFile("symptoms.txt");
		// List of symptoms as it is in the file
		List<String> listsymptom = new ArrayList<String>();
		// Créer une list fixe
		listsymptom.addAll(symptomReader.GetSymptoms());
		System.out.println(listsymptom);

		ListNumberedOrdered ReadyToPrint = new ListNumberedOrdered(listsymptom);
		// List of symptoms ordered and with occurrences
		Map<String,Long> symptomcountorder = new TreeMap<String,Long>();
		// Créer une map fixe
		symptomcountorder.putAll(ReadyToPrint.listnumberedordered());
		System.out.println(symptomcountorder);
		

		ResultsWriter Results = new ResultsWriter(symptomcountorder);
		Results.writeToFile();

	}
}
