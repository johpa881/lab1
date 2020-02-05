package lab1;

import java.util.*;

public class Game {
	
	//deklarerar variabler
    private Scanner keyboard; 
    private ArrayList<Location> locations;
    private Player player;
    
    public Game() {
    	
    	//skapar objekt
	    keyboard = new Scanner(System.in);
	    locations = new ArrayList<>();
	    
	    //skapar platser
	    Location longdoors = new Room("Longdoors", "Teamflashes and molotovs are flying in.","long description");
	    Location tspawn = new Buyzone("Tspawn", "Buy your weapons here.","long description");
	    Location outsidetunnels = new Outdoor("Outside tunnels", "There is a distant scream and you can make out RUUUSH B, COMRADE!","long description");
	    Location along = new Outdoor("Long", "You see a a AWP:er rushing back after missing his entry shoot.","long description");
	    Location middle = new Outdoor("Middle", "Complete madness.","long description");
	    Location tunnels = new Room("Tunnels", "It's dark and you're scared.","long description");
	    Location asite = new Objective("Asite", "You open your backpack and hear the usual tic...tock...tic..","long description");
	    Location ctspawn = new Room("CTspawn", "You see evidence that the CT:s been here.","long description");
	    Location bsite = new Objective("Bsite", "The rush finally worked.","long description");
	    
	    
	    //skapar "vägar"
	    //Longdoors
	    longdoors.setNext("left", tspawn);
	    longdoors.setNext("forward", along);
	    //Tspawn
	    tspawn.setNext("right", longdoors);
	    tspawn.setNext("left", outsidetunnels);
	    tspawn.setNext("forward", middle);
	    //Outside tunnels
	    outsidetunnels.setNext("right", tspawn);
	    outsidetunnels.setNext("forward", tunnels);
	    //Long
	    along.setNext("back", longdoors);
	    along.setNext("left", middle);
	    along.setNext("forward", asite);
	    //Middle
	    middle.setNext("back", tspawn);
	    middle.setNext("right", along);
	    middle.setNext("left", tunnels);
	    middle.setNext("forward", ctspawn);
	    //Tunnels
	    tunnels.setNext("back", outsidetunnels);
	    tunnels.setNext("right", middle);
	    tunnels.setNext("forward", bsite);
	    //Asite
	    asite.setNext("back", along);
	    asite.setNext("left", ctspawn);
	    //CTSpawn
	    ctspawn.setNext("back", middle);
	    ctspawn.setNext("right", asite);
	    ctspawn.setNext("left", bsite);
	    //Bsite
	    bsite.setNext("back", tunnels);
	    bsite.setNext("right", ctspawn);
	    
	    //lägger till platser i "världen"
	    locations.add(longdoors);
	    locations.add(tspawn);
	    locations.add(outsidetunnels);
	    locations.add(along);
	    locations.add(middle);
	    locations.add(tunnels);
	    locations.add(asite);
	    locations.add(ctspawn);
	    locations.add(bsite);
	    
	 
    }

    public void run() {
    	String name;
    	String command;
    	
	
        System.out.println("Hello comrade! Welcome to the Dust2!\nI'm Vadim. What is your name? My friend.");
        name = keyboard.nextLine();
        player = new Player(name, locations.get(1));
        System.out.println("Hello " + name + ", welcome to this magical world of preposterous terror!\n*a distant explosion*\nComrade " + name + ", you are needed here....\nYou can move around by typing forward/backward/right/left."
        		+ "\nYou will have to learn more commands as you play the game!"
        		+ "\n(Hint: there is a command \"help\").");
  
       
        while (true) {
	    
            player.getLocation().describeYourself();
            System.out.println("What do you want to do?");
            command = keyboard.nextLine();
            player.doCommand(command);
		
	}
        
        
          
    }
}