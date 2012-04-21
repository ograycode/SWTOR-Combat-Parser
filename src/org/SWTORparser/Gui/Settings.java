package org.SWTORparser.Gui;

import java.io.File;
import java.io.IOException;
import org.ini4j.*;

/**
 * Manipulation, storing and reading of settings file.
 * 
 * @author jason.a.gray
 *
 */
public class Settings {
	
	private String settingsFile = "settings.ini";
	private String logDir;
	
	public Settings(){
		this.initialize();
	}
	
	/**
	 * Gets the combat log. 
	 * @return Combat log directory
	 */
	public String getLogDir() {
		if (logDir == null){
			try {
				this.setSettings();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return logDir;
	}
	
	/**
	 * Sets the directory where the combat log is stored, and writes it to the settings file
	 * @param logDir Where the combat log is stored
	 */
	public void setLogDir(String logDir) {
		this.logDir = logDir;
		try {
			this.storeSettings("settings", "logDir", logDir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates a new settings file, if it does not already exist.
	 */
	private void initialize(){
		try {
			 new File(settingsFile).createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Initializes the settings
	 * @throws IOException
	 */
	private void setSettings() throws IOException{
		Wini ini = new Wini(new File(settingsFile));
        logDir = ini.get("settings", "logDir");
	}

	/**
	 * Stores the settings into the ini file. 
	 * @param section The section that the key is stored under
	 * @param key The key to the map
	 * @param value The value to be stored
	 * @throws IOException
	 */
	private void storeSettings(String section, String key, Object value) throws IOException{
		Wini ini = new Wini(new File(settingsFile));
        ini.put(section, key, value);
        ini.store();
	}
	
	
	
}
