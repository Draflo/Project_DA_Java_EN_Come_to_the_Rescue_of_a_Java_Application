package com.hemebiotech.analytics;

import java.io.IOException;

/**
 * Write the contents of a map in a new created file, line by line
 * 
 * @author Draflo
 *
 */
public interface Writer {
	/**
	 * Create a new file. Create a new map. Puts the input map in the new one
	 * created and then write its content in the new file, line by line
	 * 
	 * @throws IOException
	 */
	void writetofile() throws IOException;
}
