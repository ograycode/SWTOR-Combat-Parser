package org.SWTORparser.JUnits.Parser;

import static org.junit.Assert.*;

import java.util.List;

import org.SWTORparser.Parser.Parser;
import org.SWTORparser.Utils.FileUtils;
import org.junit.Before;
import org.junit.Test;

import swtor.parser.model.LogEntry;

public class ParserTest {

	List<String> contents;
	
	@Before
	public void setUp() throws Exception {
		contents = new FileUtils("C:\\Users\\jason.a.gray\\git\\swtor-parser\\SampleLogs\\combat_2012-03-17_10_39_06_966767.txt").readFile();
	}

	@Test
	public void testGetEntry() {
		Parser parser = new Parser(contents);
		parser.parse();
		LogEntry entry = parser.getEntry(1);
		assertEquals(entry.getLineNumber(), 2);
	}

}
