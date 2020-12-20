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
<<<<<<< HEAD
		try (// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"))) {
			String line = reader.readLine();
=======
		ISymptomReader symptomReader = new ReadSymptomDataFromFile("symptoms.txt");
		//Créer une list fixe
		System.out.println(symptomReader.GetSymptoms());
		// List of symptoms as it is in the file
>>>>>>> refs/heads/release/V1_GetSymptom_Count_Order

<<<<<<< HEAD
			
			while (line != null) {
				System.out.println("symptom from file: " + line);
				if (line.equals("headache")) {
					headacheCount++;
					System.out.println("number of headaches: " + headacheCount);
				}
				else if (line.equals("rash")) {
					rashCount++;
					System.out.println("number of rash: " + rashCount);
				}
				else if (line.contains("pupils")) {
					pupilCount++;
					System.out.println("number of pupils: " + pupilCount);
				}

				line = reader.readLine();	// get another symptom
			}
		}
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
=======
		ListNumberedOrdered ReadyToPrint = new ListNumberedOrdered(symptomReader.GetSymptoms());
		//Créer une map fixe
		System.out.println(ReadyToPrint.listnumberedordered());
		// List of symptoms ordered and with occurrences
		
		ResultsWriter Results = new ResultsWriter(ReadyToPrint);
		Results.writeToFile();
>>>>>>> refs/heads/release/V1_GetSymptom_Count_Order
	}
}
