package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class ResultsWriter {

	private ListNumberedOrdered filepath;
	
	public ResultsWriter(ListNumberedOrdered readyToPrint) {
		this.filepath = readyToPrint;
	}

	public void writeToFile() {
		
		TreeMap<String, Long> map = new TreeMap<String, Long>();
		map.put("rash", (long) 5);
		map.put("vision", (long) 2);
		map.put("vomit", (long) 1);
		map.put("cough", (long) 4);
		File file = new File("result.out");
		try {

			BufferedWriter bf = new BufferedWriter(new FileWriter(file));
			for (Map.Entry<String, Long> entry : map.entrySet()) {
				bf.write(entry.getKey() + " = " + entry.getValue());
				bf.newLine();
				bf.flush();
			}
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}