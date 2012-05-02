package org.SWTORparser.Parser;

import java.util.Calendar;
import java.util.List;

import swtor.parser.constant.EntryType;
import swtor.parser.model.LogEntry;

public class Combat {
	
	private Calendar startTime, endTime;
	private int damage, healing, takenDamage;
	private String playerName, targets;
	private List<LogEntry> logEntries;
	
	public Combat(List<LogEntry> logEntries){
		this.logEntries = logEntries;
	}
	
	/**
	 * Gets a specific log entry
	 * @param index
	 * @return the LogEntry
	 */
	public LogEntry getLogEntry(int index){
		return this.logEntries.get(index);
	}
	
	/**
	 * Sets log entries
	 * @param logEntries
	 */
	public void setLogEntries(List<LogEntry> logEntries){
		this.logEntries = logEntries;
	}
	
	/**
	 * @return the startTime
	 */
	public Calendar getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public Calendar getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}
	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}
	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}
	/**
	 * @param playerName the playerName to set
	 */
	public void setPlayerName(String playerName) {
		if (playerName.startsWith("@")){
			playerName = playerName.substring(1);
		}
		this.playerName = playerName;
	}
	/**
	 * @return the targets
	 */
	public String getTargets() {
		return targets;
	}
	/**
	 * @param targets the targets to set
	 */
	public void setTargets(String targets) {
		this.targets = targets;
	}
	
	/**
	 * @param damageToAdd add damage
	 */
	public void addDamage(int damageToAdd){
		this.setDamage(this.getDamage()+damageToAdd);
	}
	
	/**
	 * Calculate the combat length, in seconds
	 * @return combat length
	 */
	public long getCombatLengthInSeconds(){
		return (this.getEndTime().getTimeInMillis()-this.getStartTime().getTimeInMillis())/1000;
	}
	
	/**
	 * Calculate dps over a given period of time.
	 * @param startTime State time of the calculation.
	 * @param seconds How many seconds to calculate from the start time
	 * @return DPS
	 */
	public double getDPS(Calendar startTime, long seconds) {
		double dps = 0;
		long localEndTime = startTime.getTimeInMillis()/1000;
		localEndTime = localEndTime+seconds;
		for (LogEntry entry : this.logEntries){
			if (entry.getTime().getTimeInMillis() >= startTime.getTimeInMillis()
					&& entry.getTime().getTimeInMillis()/1000 <= localEndTime
					&& entry.sourceIsPlayer()
					&& entry.getType() == EntryType.DAMAGE){
				dps += entry.getValue();
			}
		}
		return dps/seconds;
	}
	
	/**
	 * Get the damage per second for the whole fight.
	 * @return DPS
	 */
	public double getDPS(){
		return (new Double(this.getDamage())/new Double(this.getCombatLengthInSeconds()));
	}

	/**
	 * @return the healing
	 */
	public int getHealing() {
		return healing;
	}

	/**
	 * @param healing the healing to set
	 */
	public void setHealing(int healing) {
		this.healing = healing;
	}
	
	/**
	 * Add a specified amount to healing
	 * @param healing
	 */
	public void addToHealing (int healing){
		this.setHealing(this.getHealing() + healing);
	}

	/**
	 * Add damage player has taken
	 * 
	 * @param value Damage taken
	 */
	public void addTakenDamage(int value) {
		this.setTakenDamange(this.getTakenDamage() + value);
	}
	
	/**
	 * Returns the player's taken damage
	 * @return taken damage
	 */
	public int getTakenDamage(){
		return this.takenDamage;
	}
	
	/**
	 * Sets the taken damage with a specified value
	 * @param value
	 */
	public void setTakenDamange(int value){
		this.takenDamage = value;
	}

}
