package lab1;


public abstract class Location {
	
	//variabler
	private final String name;
	private final String description_long;
	private final String description_short;


	//konstruktor
	public Location(String name, String description_short, String description_long) {
		this.name = name;
		this.description_short = description_short;
		this.description_long = description_long;
	}
	
	//Skriver ut name och descrition
	public abstract void describeYourself();
	
	//skriver ut vägar - ska ändras till abstract och överskuggas  i arv
	public abstract void showOptions();
	
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
	
	//lägger till vägar
	public abstract void setNext(String mapKey, Location position);
	//returnar platsen en "väg" leder till
	public abstract Location getNext(String mapKey);
	//kollar om en väg finns
	public abstract boolean checkPath(String mapKey);
}