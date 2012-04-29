package org.SWTORparser.Utils;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * A simple class to abstract manipulating files
 * 
 * @author Jason Gray
 *
 */
public class FileUtils {

	private Path file;

	/**
	 * Pass the full file and path to initialize
	 * @param fileName
	 */
	public FileUtils(String file) {
		this.setFile(file);
	}
	
	/**
	 * Default constructor
	 */
	public FileUtils(){}
	
	/**
	 * Sets the file to be manipulated
	 * @param file
	 */
	public void setFile(String file){
		this.file = FileSystems.getDefault().getPath(file);
	}
	
	/**
	 * Read the file one line at a time, and return an array of lines
	 * @return List<String>
	 */
	public List<String> readFile() {
		List<String> lines = new ArrayList<>();
		try (InputStream in = Files.newInputStream(file);
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(in))) {
			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			reader.close();
		} catch (IOException x) {
			System.err.println(x);
		}
		return lines;
	}

}
