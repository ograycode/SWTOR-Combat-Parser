package org.SWTORparser.Parser;

import java.util.List;

import swtor.parser.model.LogEntry;

public class Results {
	
	List<LogEntry> parsedContents;

	public Results(List<LogEntry> parsedContents) {
		this.parsedContents = parsedContents;
	}
	

}
