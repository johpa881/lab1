package lab1;

import java.util.HashMap;


public abstract class Location {
	
	//variabler
	private String name;
	private String description_long;
	private String description_short;
	public HashMap<String, Location> paths;

	//konstruktor
	public Location(String name, String description_short, String description_long) {
		this.name = name;
		this.description_short = description_short;
		this.description_long = description_long;
		this.paths = new HashMap<String, Location>();
		
	}
	
	//Skriver ut name och descrition
	public abstract void describeYourself();
	
	//skriver ut vägar
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
	
	public static void doCommand(String command) {

		
	}
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
