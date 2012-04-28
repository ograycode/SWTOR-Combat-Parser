package org.SWTORparser.JUnits.Parser;

public class JUnitHelper {
	
	private String sampleCombatLog = "/home/jgray/git/swtor-parser/SampleLogs/combat_2012-03-18_05_59_29_235600.txt";
	private double delta = 1e-9;
	
	public String getSampleCombatLog(){
		return sampleCombatLog;
	}
	
	public double getDelta(){
		return delta;
	}

}
