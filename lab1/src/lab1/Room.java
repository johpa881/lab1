package lab1;

import java.util.HashMap;

public class Room extends Location {
	
	//paths final - skall ej ändras
	private final HashMap<String, Location> paths;
	private final int size;
	//konstruktor
	public Room(String name, String description_short, String description_long, int size) {
		super(name, description_short, description_long);
		this.paths = new HashMap<String, Location>();
		this.size = size;
	}
		
	public void doCommand() {
		
	}
	
	@Override
	public void doCommand(String command) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void showOptions() {
		for(String mapKey : paths.keySet()) {
		    System.out.println(mapKey);
		}
	}
	//skriver ut namn och beskrivning
	@Override
	public void describeYourself() {
		System.out.println("You are at " + super.getName() + ".");
		System.out.println("The room is " + size + " square-meters big.");
		System.out.println(super.getDescription_short());
		for(String mapKey : paths.keySet()) {
			System.out.println("There is a door " + mapKey + " leading to " + paths.get(mapKey).getName());
			
		}
	}
	
	//skapar vägar
	@Override
	public void setNext(String mapKey, Location position) {
		this.paths.put(mapKey, position);	
	}
	
	//returnar en plats som vägen man skickar in leder till
	@Override
	public Location getNext(String mapKey) {
		return this.paths.get(mapKey);
	}
	
	//kollar om en väg finns
	@Override
	public boolean checkPath(String mapKey) {
		return this.paths.containsKey(mapKey);
	}
}