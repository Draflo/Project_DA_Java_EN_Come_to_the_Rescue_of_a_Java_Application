package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class ResultsWriter {

	private Map<String, Long> filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to the Map with our symptoms and their occurrences
	 */
	
	public ResultsWriter(Map<String, Long> symptomcountorder) {
		this.filepath = symptomcountorder;
	}

	public void writeToFile() {
		
		TreeMap<String, Long> map = new TreeMap<String, Long>();
		map.putAll(filepath);
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