package lab1;

import java.util.HashSet;
import java.util.Set;

public class Player {
	
	//variabler
	private final String name;
	private Location position;
	private Set<Location> visitedLocations;
	//private int money;
	//private int health;
	
	//konstruktor
	public Player(String name, Location position) {
		this.name = name;
		this.position = position;
		//en m�ngd som inneh�ller alla platser man bes�kt
		visitedLocations = new HashSet<Location>();
		visitedLocations.add(position);
		System.out.println(position.getDescription_long());
		//health = 100;
		//money = 800;	
	}
	public String getName() {
		return name;
	}
	
	//returnar spelarens position
	public Location getLocation() {
		return position;
	}
	
	//kollar om man redan bes�kt platsen
	public boolean visited(Location position) {
		//for-each loop som j�mf�r position med elementen i visitedLocations
		for (Location element : visitedLocations) {
			if (position.getName().equals(element.getName())) {
				return true;
			}
		}
		return false;
	}
	
	//tilldelar spelaren en position
	public void setLocation(Location position) {
		if (!visited(position)) {
			System.out.println(position.getDescription_long());
		}
		this.position = position;
		visitedLocations.add(position);
	}
	
	
	//l�ter spelaren byta position via en v�g
	public void moveTo(String command) {
		//this.position = this.position.getLocation(command);
		if (getLocation().checkPath(command)) {
			setLocation(getLocation().getNext(command));
		}
	}
	
	//vad spelaren kan g�ra
	public void doCommand(String command) {
			moveTo(command);
			if (command.equals("help")) {
				System.out.println("Available commands:");
				position.showOptions();
			}
	}
	
	
}
