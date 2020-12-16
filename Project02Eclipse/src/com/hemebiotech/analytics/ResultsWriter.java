package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class ResultsWriter {

	private Map<String, Long> filepath;

	public ResultsWriter(Map<String, Long> filepath) {
		this.filepath = filepath;
	}

	public ResultsWriter() {
		
		TreeMap<String, Long> map = new TreeMap<String, Long>();
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