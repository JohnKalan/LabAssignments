package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* The FileIO provides simple file input/output operations
* that serve as hands-on practice on Unit Testing.
*
* @author  JohnKalan
* @version 2.0
* @since   2023-05-20
*/
public class FileIO {
	
	/**
	 * Reads a file that contains different type of values line by line 
	 * and returns an array of the integers found in the file.
	 * @param filepath the file that contains the numbers
	 * @return an array of numbers
	 * @exception IllegalArgumentException when the given file does not exist
	 * @exception IllegalArgumentException when the given file is empty
	 * @exception IOException when an IO interruption occurs (not required to be tested)
	 */
	public int[] readFile(String filepath) {
		File file = new File(filepath);
		if (!file.exists()) 
			throw new IllegalArgumentException("Input file does not exist");
		
		List<Integer> numbersList = new ArrayList<>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (isInteger(line)) {
					int number = Integer.parseInt(line);
					numbersList.add(number);		
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (numbersList.size() == 0) 
			throw new IllegalArgumentException("Given file is empty");
		
		// Convert a List to an array using 
		return numbersList.stream().mapToInt(i -> i).toArray();
	}

	/**
	 * Checks whether the given value is an Integer.
	 * @param value the input value
	 * @return boolean value true or false
	 */
	public static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
