package com.hemebiotech.analytics;

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
		//Créer une list fixe
		System.out.println(symptomReader.GetSymptoms());
		// List of symptoms as it is in the file

		ListNumberedOrdered ReadyToPrint = new ListNumberedOrdered(symptomReader.GetSymptoms());
		//Créer une map fixe
		System.out.println(ReadyToPrint.listnumberedordered());
		// List of symptoms ordered and with occurrences
		
		ResultsWriter Results = new ResultsWriter(ReadyToPrint);
		Results.writeToFile();
	}
}
