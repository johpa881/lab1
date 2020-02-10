package lab1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Player {
	
	//variabler
	private final String name;
	private Location position;
	private Set<Location> visitedLocations;
	private int money;
	private int health;
	private HashMap<String, Item> inventory;
	
	//konstruktor
	public Player(String name, Location position, Item item) {
		this.name = name;
		this.position = position;
		//en mängd som innehåller alla platser man besökt
		visitedLocations = new HashSet<Location>();
		visitedLocations.add(position);
		System.out.println(position.getDescription_long());
		health = 100;
		money = 800;
		inventory = new HashMap<String, Item>();
		inventory.put(item.getName(), item);
	}
	
	public String getName() {
		return name;
	}
	
	//returnar spelarens position
	public Location getLocation() {
		return position;
	}

	//getters och setters för health och money
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
	//kollar om man redan besökt platsen
	public boolean visited(Location position) {
		//for-each loop som jämför position med elementen i visitedLocations
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
	
	
	//låter spelaren byta position via en väg
	public void moveTo(String command) {
		if (getLocation().checkPath(command)) {
			setLocation(getLocation().getNext(command));
		}
	}
	
	
	
	public void doCommand(Tool tool) {
		tool.useTool(this);
	}
	
	public void doCommand(Weapon weapon) {
		
	}
	
	public void doCommand(WearableItem wearableitem) {
		
	}
	
	public void doCommand(Item item) {
		System.out.println("Det blev fel");
	}
	
	
	//vad spelaren kan göra
	public void doCommand(String command) {
			moveTo(command);
			if (command.equals("help")) {
				System.out.println("Available commands:");
				position.showOptions();
			}else if (command.equals("deliver")) {
				
				doCommand(inventory.get("The Package"));
				
				
				/*
				for (String itemKey : inventory.keySet()) {
					inventory.get(itemKey);
				}*/
			}
			
	}
	
	
	public void addItem(Item item) {
		inventory.put(item.getName(), item);
	}
	
	public void dropItem(Item item) {
		inventory.remove(item.getName());
	}
	
	public void equipItem(Item item) {
		if (!item.isEquipped()) {
			item.setEquipped(true);
			
		}
	}
	 public void unequipItem(Item item) {
		 if (item.isEquipped()) {
				item.setEquipped(false);
			}
	 }
	
	
	
	
}