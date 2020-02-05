package lab1;



public class Room extends Location {
	//konstruktor
	public Room(String name, String description_short, String description_long) {
		super(name, description_short, description_long);
	}
		
	public void doCommand() {
		
	}
	
	//skriver ut namn och beskrivning
	@Override
	public void describeYourself() {
		System.out.println("You are at " + super.getName() + ".");
		System.out.println(super.getDescription_short());
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
