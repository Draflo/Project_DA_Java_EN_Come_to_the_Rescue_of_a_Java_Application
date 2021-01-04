package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class ResultsWriter implements Writer {

	private Map<String, Long> filepath;

	/**
	 * 
	 * @param filepath a full or partial path to the Map with our symptoms and their
	 *                 occurrences
	 */

	public ResultsWriter(Map<String, Long> symptomcountorder) {
		this.filepath = symptomcountorder;
	}

	@Override
	public void writetofile() throws IOException {

		TreeMap<String, Long> map = new TreeMap<String, Long>();
		map.putAll(filepath);
		/**
		 * Create a Map to get all the data of filepath so it can be written in the new
		 * file
		 */
		File file = new File("result.out");
		BufferedWriter bf = new BufferedWriter(new FileWriter(file));
		try {

			for (Map.Entry<String, Long> entry : map.entrySet()) {
				bf.write(entry.getKey() + " = " + entry.getValue());
				bf.newLine();
				bf.flush();
			}
			bf.close();
		} finally {
			if (bf != null)
				bf.close();
		}

	}
}