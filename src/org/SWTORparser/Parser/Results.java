package org.SWTORparser.Parser;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import swtor.parser.constant.EntryType;
import swtor.parser.model.LogEntry;

/**
 * Calculates the results of the parsed contents of a file
 * @author Jason Gray
 *
 */
public class Results {
	
	private List<LogEntry> parsedContents;
	@Deprecated
	private List<Integer> damage;
	@Deprecated
	private List<Calendar> startTime;
	@Deprecated
	private List<Calendar> endTime;
	@Deprecated
	private List<String> fightName;
	
	private List<Combat> combat;

	public Results(List<LogEntry> parsedContents) {
		this.parsedContents = parsedContents;
		damage = new ArrayList<>();
		startTime = new ArrayList<>();
		endTime = new ArrayList<>();
		fightName = new ArrayList<>();
		combat = new ArrayList<>();
	}
	
	public void calculate(){
		boolean inCombat = false;
		int index = 0;
		for(LogEntry entry : parsedContents){
			if (entry.getType() == EntryType.ENTER_COMBAT){
				inCombat = true;
				this.damage.add(0);
				this.startTime.add(entry.getTime());
				//Added for refactoring
				this.combat.add(new Combat(this.parsedContents));
				this.combat.get(index).setStartTime(entry.getTime());
				this.combat.get(index).setPlayerName(entry.getSource());
			}
			if (inCombat){
				if(entry.sourceIsPlayer()){
					if (entry.getType() == EntryType.DAMAGE){
						addDamage(index, entry.getValue());
						//Added for refactoring
						this.combat.get(index).addDamage(entry.getValue());
					}
					else if(entry.getType() == EntryType.HEAL){
						this.combat.get(index).addToHealing(entry.getValue());
					}
				}
				else if(entry.targetIsPlayer()){
					if(entry.getType() == EntryType.DAMAGE){
						this.combat.get(index).addTakenDamage(entry.getValue());
					}
					else if (entry.getType() == EntryType.HEAL){
						this.combat.get(index).addToPlayerReceivedHealing(entry.getValue());
					}
				}
			}
			if (entry.getType() == EntryType.EXIT_COMBAT){
				inCombat = false;
				//Added for refactoring
				this.combat.get(index).setEndTime(entry.getTime());
				//Old code below
				index++;
				this.endTime.add(entry.getTime());
			}
		}
	}
	@Deprecated
	public Integer getDamage(int index){
		return this.damage.get(index);
	}
	@Deprecated
	private void addDamage(int index, int damage){
		int updatedDamage = this.damage.get(index) + damage;
		this.damage.set(index, updatedDamage);
	}
	@Deprecated
	public Calendar getStartTime(int index){
		return this.startTime.get(index);
	}
	@Deprecated
	public Calendar getEndTime(int index){
		return this.endTime.get(index);
	}
	@Deprecated
	public double getDPS(int index){
		return (new Double(this.damage.get(index))/new Double(this.getCombatLengthInSeconds(index)));
	}
	@Deprecated
	public int getCombatCount(){
		return this.damage.size();
	}
	@Deprecated
	public long getCombatLengthInSeconds(int index){
		return (this.getEndTime(index).getTimeInMillis()-this.getStartTime(index).getTimeInMillis())/1000;
	}

	@Deprecated
	public double getDPS(Calendar startTime, long seconds) {
		double dps = 0;
		long localEndTime = startTime.getTimeInMillis()/1000;
		localEndTime = localEndTime+seconds;
		for (LogEntry entry : parsedContents){
			if (entry.getTime().getTimeInMillis() >= startTime.getTimeInMillis()
					&& entry.getTime().getTimeInMillis()/1000 <= localEndTime
					&& entry.sourceIsPlayer()
					&& entry.getType() == EntryType.DAMAGE){
				dps += entry.getValue();
			}
		}
		
		return dps/seconds;
	}
	
	public Combat getCombatResult(int index){
		return this.combat.get(index);
	}
	
	public List<Combat> getAllCombatResults(){
		return this.combat;
	}

}
