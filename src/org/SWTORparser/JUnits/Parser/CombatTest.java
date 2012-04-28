package org.SWTORparser.JUnits.Parser;

import static org.junit.Assert.*;

import java.util.List;

import org.SWTORparser.Parser.Combat;
import org.SWTORparser.Parser.Parser;
import org.SWTORparser.Parser.Results;
import org.SWTORparser.Utils.FileUtils;
import org.junit.Before;
import org.junit.Test;

public class CombatTest {
	
	private Combat combat;
	private JUnitHelper helper;
	

	@Before
	public void setUp() throws Exception {
		helper = new JUnitHelper();
		List<String> contents = new FileUtils(helper.getSampleCombatLog()).readFile();
		Results results = new Parser(contents).parse().getResults();
		results.calculate();
		combat = results.getCombatResult(0);
	}

	@Test
	public void testGetStartTime() {
		System.out.println("StartTime: " + combat.getStartTime());
	}

	@Test
	public void testGetEndTime() {
		System.out.println("End Time: " + combat.getEndTime());
	}

	@Test
	public void testGetDamage() {
		int damage = combat.getDamage();
		assertEquals(492, damage);
		System.out.println("Damage: " + damage);
	}

	@Test
	public void testGetDps() {
		double dps = combat.getDPS();
		assertEquals(22.363636363636363, dps, helper.getDelta());
		System.out.println("DPS : " + combat.getDPS());
	}

	@Test
	public void testGetPlayerName() {
		String player = combat.getPlayerName();
		assertEquals("Cathese", player);
		System.out.println("Player Name: " + player);
	}

	@Test
	public void testGetTargets() {
		System.out.println("Targets: " + combat.getTargets());
		fail("Not yet implemented");
	}

	@Test
	public void testGetCombatLengthInSeconds() {
		long length = combat.getCombatLengthInSeconds();
		assertEquals(22, length, helper.getDelta());
		System.out.println("Combat Length: " + combat.getCombatLengthInSeconds());
	}

	@Test
	public void testGetDPSCalendarLong() {
		double dps = combat.getDPS(combat.getStartTime(), 1);
		assertEquals(29, dps, helper.getDelta());
		System.out.println("One Sec DPS: " + dps);
	}

}
