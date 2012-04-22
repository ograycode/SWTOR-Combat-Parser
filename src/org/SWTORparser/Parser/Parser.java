package org.SWTORparser.Parser;

import java.util.List;

import swtor.parser.model.*;
import swtor.parser.parser.*;

/**
 * The purpose of this class it to parse the entries and set the results
 * @author Jason Gray
 *
 */
public class Parser {
	
	private List<String> fileContents;
	private Results results;
	private List<LogEntry> parsedContents;
	private LogEntryParser regex = new RegexParser();
	
	public Parser(List<String> fileContents){
		this.fileContents = fileContents;
	}
	
	/**
	 * This method initializes the results
	 */
	public void parse(){
		long index = 0;
		for(String line : fileContents){
			parsedContents.add(new LogEntry(index));
			try {
				regex.parse(parsedContents.get((int)index), line);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * You can use this method to get the contents of a specific line
	 * @param index
	 * @return LogEntry
	 */
	public LogEntry getEntry(int index){
		return parsedContents.get(index);
	}
	
	/**
	 * This method initializes the the Results class, if not already initialized
	 * @return
	 */
	public Results getResults(){
		if(results == null){
			new Results(parsedContents);
		}
		return results;
	}

}
