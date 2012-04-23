package org.SWTORparser.JUnits.Parser;

import static org.junit.Assert.*;

import java.util.List;

import org.SWTORparser.Parser.Parser;
import org.SWTORparser.Parser.Results;
import org.SWTORparser.Utils.FileUtils;
import org.junit.Before;
import org.junit.Test;

public class ResultsTest {
	
	Results results;
	int index = 0; 

	@Before
	public void setUp() throws Exception {
		List<String> contents = new FileUtils("C:\\Users\\jason.a.gray\\git\\swtor-parser\\SampleLogs\\combat_2012-03-18_05_59_29_235600.txt").readFile();
		results = new Parser(contents).parse().getResults();
		results.calculate();
	}
	
	@Test
	public void testGetCombatCount(){
		assertEquals(3, results.getCombatCount());
		System.out.println("Combat Sessions: " + results.getCombatCount());
	}

	@Test
	public void testGetDamage() {
		System.out.println("Damage: "+results.getDamage(index));
	}

	@Test
	public void testGetStartTime() {
		System.out.println("Start Time: "+results.getStartTime(index));
	}

	@Test
	public void testGetEndTime() {
		System.out.println("End Time: "+results.getEndTime(index));
	}
	
	@Test
	public void testGetCombatLengthInSeconds(){
		assertEquals(22, results.getCombatLengthInSeconds(index));
		System.out.println("Combat length in seconds: "+results.getCombatLengthInSeconds(index));
	}

	@Test
	public void testGetDPS() {
		System.out.println("DPS: "+results.getDPS(index));
	}

}
