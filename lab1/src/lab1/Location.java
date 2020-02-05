package lab1;

import java.util.HashMap;

public abstract class Location {
	
	//variabler
	private final String name;
	private final String description_long;
	private final String description_short;
	//paths skall flyttas till room/outside och ändras till private
	public final HashMap<String, Location> paths;

	//konstruktor
	public Location(String name, String description_short, String description_long) {
		this.name = name;
		this.description_short = description_short;
		this.description_long = description_long;
		//paths skall flyttas till konstruktor i room och outside
		this.paths = new HashMap<String, Location>();
		
	}
	
	//Skriver ut name och descrition
	public abstract void describeYourself();
	
	//skriver ut vägar - ska ändras till abstract och överskuggas  i arv
	public void showOptions() {
		for(String mapKey : paths.keySet()) {
		    System.out.println(mapKey);
		}
	}
	
	//returnar namn
	public String getName() {
		return name;
	}
	
	public String getDescription_short() {
		return description_short;
	}
	
	public String getDescription_long() {
		return description_long;
	}
	
	public abstract void doCommand(String command);
	/*
	public Location getLocation(String command) {
		
	}*/
	
	//lägger till vägar
	public abstract void setNext(String mapKey, Location position);
	//returnar platsen en "väg" leder till
	public abstract Location getNext(String mapKey);
	//kollar om en väg finns
	public abstract boolean checkPath(String mapKey);
}
