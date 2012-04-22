package org.SWTORparser.JUnits.Parser;

import static org.junit.Assert.*;

import java.util.List;

import org.SWTORparser.File.File;
import org.SWTORparser.Parser.Parser;
import org.SWTORparser.Parser.Results;
import org.junit.Before;
import org.junit.Test;

public class ResultsTest {
	
	Results results;

	@Before
	public void setUp() throws Exception {
		List<String> contents = new File("C:\\Users\\jason.a.gray\\git\\swtor-parser\\SampleLogs\\combat_2012-03-17_10_39_06_966767.txt").readFile();
		results = new Parser(contents).getResults();
	}

	@Test
	public void testGetDamage() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStartTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEndTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDPS() {
		fail("Not yet implemented");
	}

}
