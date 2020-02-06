package lab1;

import java.util.ArrayList;
import java.util.HashMap;

public class Outdoor extends Location {
	private String currentWeather;
	private static ArrayList<String> weather = new ArrayList<>();
	//paths final - skall ej ändras
	private final HashMap<String, Location> paths;
	//konstruktor
	
	public Outdoor(String name, String description_short, String description_long) {
		super(name, description_short, description_long);
		this.paths = new HashMap<String, Location>();
	}
	
	static int usingMathClass() {
		double randomDouble = Math.random();
		randomDouble = randomDouble * weather.size();
		int randomInt = (int) randomDouble;
		return randomInt;
	}
	
	
	@Override
	public void showOptions() {
		for(String mapKey : paths.keySet()) {
		    System.out.println(mapKey);
		}
	}
	
	public static ArrayList<String> getWeather() {
		return weather;
	}

	public static void setWeather(ArrayList<String> weather) {
		Outdoor.weather = weather;
	}

	public String getCurrentWeather() {
		currentWeather = getWeather().get(usingMathClass());
		return currentWeather;
	}


	public void doCommand() {
		
	}
	
	@Override
	public void doCommand(String command) {
		// TODO Auto-generated method stub
		
	}
	
	//skriver ut namn och beskrivning
		@Override
	public void describeYourself() {
		System.out.println("You are at " + super.getName() + ".");
		System.out.println(super.getDescription_short());
		System.out.println(getCurrentWeather());
		
		for(String mapKey : paths.keySet()) {
			System.out.println("There is a path " + mapKey + " leading to " + paths.get(mapKey).getName());
				
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
