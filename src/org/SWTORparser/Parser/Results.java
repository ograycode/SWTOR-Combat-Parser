package org.SWTORparser.Parser;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import swtor.parser.constant.EntryType;
import swtor.parser.model.LogEntry;

public class Results {
	
	List<LogEntry> parsedContents;
	List<Integer> damage;
	List<Calendar> startTime;
	List<Calendar> endTime;
	List<String> fightName;

	public Results(List<LogEntry> parsedContents) {
		this.parsedContents = parsedContents;
		damage = new ArrayList<>();
		startTime = new ArrayList<>();
		endTime = new ArrayList<>();
		fightName = new ArrayList<>();
	}
	
	public void calculate(){
		boolean inCombat = false;
		int index = 0;
		for(LogEntry entry : parsedContents){
			if (entry.getType() == EntryType.ENTER_COMBAT){
				inCombat = true;
				this.damage.add(0);
				this.startTime.add(entry.getTime());
			}
			if (inCombat){
				if(entry.sourceIsPlayer()){
					addDamage(index, entry.getValue());
				}
			}
			if (entry.getType() == EntryType.EXIT_COMBAT){
				inCombat = false;
				index++;
				this.endTime.add(entry.getTime());
			}
		}
	}
	
	public Integer getDamage(int index){
		return this.damage.get(index);
	}
	
	private void addDamage(int index, int damage){
		this.damage.add(index, this.damage.get(index) + damage);
	}
	
	public Calendar getStartTime(int index){
		return this.startTime.get(index);
	}
	
	public Calendar getEndTime(int index){
		return this.getEndTime(index);
	}
	
	public long getDPS(int index){
		//TODO
		return 0;
	}

}
