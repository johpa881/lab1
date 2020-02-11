package lab1;

import java.util.*;

public class Game {
	
	//deklarerar variabler
    private Scanner keyboard; 
    private ArrayList<Location> world;
    private Player player;
    private ArrayList<String> weather;
    private ArrayList<Item>items;
    
    public Game() {
    	
    	//skapar objekt'
	    keyboard = new Scanner(System.in);
	    world = new ArrayList<>();
	    weather = new ArrayList<String>();
	    items = new ArrayList<Item>();
	    
	    //skapar platser
	    Location longdoors = new Room("Longdoors", "There's is blood on the walls.","The legendary Loongdors has taken many lives. The shootouts have been of the most horrific ones mankind has ever seen.\nYou hear your friend Vadim" + 
	    		"screaming at the top of his lungs.\n       *I FLASH LONG FOR YOU COMRADE*\nYou start to question the decision to run long....\nMaybe you should go middle instead.... ", 10);
	    
	    Location tspawn = new Buyzone("Tspawn", "There is pistols on the ground, a destinct smell of premium vodka and cheap cigarettes.","*You hear Vadim*\nComrade, I drop AK for you, you go open site for me.\nYou feel terrifed, " + 
	    		"maybe this killing stuff is not for you. But you're to far in now and you remember your father Boris last words to you just before he died.\nSTOP SHAKING THE LADDER!!!\nYou feel encurged to go on.");
	    
	    Location outsidetunnels = new Outdoor("Outside tunnels", "Not to many souls around here.","You feel the urge to just keep going no matter what trough smokes and nades. \n*There is nothing more powerful than a B rush.*\n" + 
	    		"Except an Apache helicopter. An Apache helicopter has machine guns AND missiles. It is an unbelievably impressive complement of weaponry, an absolute death machine.");
	    
	    Location along = new Outdoor("Long", "You smell the smell of burnt corpses.","You made up your mind. You'll bait Vadim, your life is more important than his. Then you take a moment to self reflect.\n" + 
	    		"Are anyones life more important than anothers? Or is that just a social construct the elite class of the world made up to controll the rest.\nThe revolution starts now, communism or death.");
	    
	    Location middle = new Outdoor("Middle", "You see complete chaos.","*You hear gunfire in the distance*\n With alot of options you feel overwhelmed. Time is of the essence.");
	    
	    Location tunnels = new Room("Tunnels", "It's dark and smells like western spies. You feel discusted.","The innervoice in your head says that you should peek Bsite, but is that a good idea?\n" + 
	    "You start to question your own reality, you think why am I doing this? What's the point...", 15);
	    
	    Location asite = new Objective("Asite", "This would be a good place to deliver something.","There is boxes with the smell of gasoline, you hear Vadim\n*Slaps top of boxes* This badboy could blow better than a Moscaw glasblower.");
	    
	    Location ctspawn = new Room("CTspawn", "This place is cursed.","You see footsteps created by the enemy, you are discusted. Only the smell of them brings hate into your heart.", 7);
	    
	    Location bsite = new Objective("Bsite", "The rush finally worked.","The smell of gasoline is in the air. Boxes everywhere that looks flamable.");
	    
	    //skapar "vägar"
	    longdoors.setNext("left", tspawn);
	    longdoors.setNext("forward", along);
	    tspawn.setNext("right", longdoors);
	    tspawn.setNext("left", outsidetunnels);
	    tspawn.setNext("forward", middle);
	    outsidetunnels.setNext("right", tspawn);
	    outsidetunnels.setNext("forward", tunnels);
	    along.setNext("back", longdoors);
	    along.setNext("left", middle);
	    along.setNext("forward", asite);
	    middle.setNext("back", tspawn);
	    middle.setNext("right", along);
	    middle.setNext("left", tunnels);
	    middle.setNext("forward", ctspawn);
	    tunnels.setNext("back", outsidetunnels);
	    tunnels.setNext("right", middle);
	    tunnels.setNext("forward", bsite);
	    asite.setNext("back", along);
	    asite.setNext("left", ctspawn);
	    ctspawn.setNext("back", middle);
	    ctspawn.setNext("right", asite);
	    ctspawn.setNext("left", bsite);
	    bsite.setNext("back", tunnels);
	    bsite.setNext("right", ctspawn);
	    
	    //lägger till platser i "världen"
	    world.add(longdoors);
	    world.add(tspawn);
	    world.add(outsidetunnels);
	    world.add(along);
	    world.add(middle);
	    world.add(tunnels);
	    world.add(asite);
	    world.add(ctspawn);
	    world.add(bsite);
	    
	    //lägger till väder
	    weather.add("Sunny");
	    weather.add("Cloudy");
	    weather.add("Rainy");
	    weather.add("Warm");
	    weather.add("Cold");
	    weather.add("Windy");
	    
	    Outdoor.setWeather(weather);
	    
	    //lägger till items
	    Item knife = new Weapon(0.2, "Knife", 0 , 1);
	    Item glock = new Weapon(1.5, "Glock", 150, 2);
	    Item ak47 = new Weapon(7, "AK-47", 2700, 3);
	    Item thepackage = new Tool(3, "The Package", 99999, 4, "fuck java");
	    Item kevlar = new WearableItem(8, "Kevlar", 650, 5, 100);
	    Item helmet = new WearableItem(1, "Helmet", 350, 6, 50);

	    
	    items.add(knife);
	    items.add(glock);
	    items.add(ak47);
	    items.add(thepackage);
	    items.add(kevlar);
	    items.add(helmet);
	    
    }

    public void run() {
    	String name;
    	String command;
	
        System.out.println("Hello comrade! Welcome to the Dust2!\nI'm Vadim. What is your name? My friend.");
        name = keyboard.nextLine();
        System.out.println("Hello " + name + ", welcome to this magical world of preposterous terror!\n*a distant explosion*\nComrade " + name + ", you are needed here....\nYou can move around by typing forward/backward/right/left."
        		+ "\nYou will have to learn more commands as you play the game!"
        		+ "\n(Hint: there is a command \"help\").");
        player = new Player(name, world.get(1), items.get(3));
        
        while (true) {	  
        	System.out.println("");
            player.getLocation().describeYourself();
            System.out.println("What do you want to do?");
            command = keyboard.nextLine();
            System.out.println("");
            player.doCommand(command);
		
	}
        
        
          
    }
}