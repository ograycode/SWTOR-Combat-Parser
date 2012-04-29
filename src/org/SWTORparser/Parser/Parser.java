package org.SWTORparser.Parser;

import java.util.ArrayList;
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
	public Parser parse(){
		long l_index = 1;
		int i_index = 0;
		parsedContents = new ArrayList<>();
		for(String line : fileContents){
			try {
				parsedContents.add(new LogEntry(l_index));
				regex.parse(parsedContents.get(i_index), line);
				l_index++;
				i_index++;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this;
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
	 * @return Results
	 */
	public Results getResults(){
		if(results == null){
			results = new Results(parsedContents);
		}
		return results;
	}
	
	/**
	 * Calculates the results and returns a List<Combat> of all combat sessions.
	 * This method also eliminates the need to call Parser.parse()
	 * @return A list of all Combat sessions parsed
	 */
	public List<Combat> calcResultsGetCombat(){
		this.parse();
		Results results = this.getResults();
		results.calculate();
		return results.getAllCombatResults();
	}

}
