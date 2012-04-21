package org.SWTORparser.JUnits.Gui;

import static org.junit.Assert.*;

import org.SWTORparser.Gui.Settings;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit class to test org.SWTORparser.Gui.Settings
 * @author Jason Gray
 *
 */
public class SettingsTest {

	private Settings settings; 
	private String combatLogDir = "C:\\SWTOR-Log-Dir";
	
	@Before
	public void setUp() throws Exception {
		settings = new Settings();
	}
	
	@Test
	public void testSetLogDir() {
		settings.setLogDir(combatLogDir);
		assertEquals(combatLogDir, settings.getLogDir());
	}

	@Test
	public void testGetLogDir() {
		assertEquals(combatLogDir, settings.getLogDir());
	}


}
