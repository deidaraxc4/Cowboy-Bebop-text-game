package application;

import java.util.ArrayList;

public class Game 
{
    private Parser parser;
    private ParserWithFileInput parserWithFileInput;
    private Room currentRoom;
    public static boolean finished = false;
    private Player player;
    private int x,y;
    private ArrayList<Weapon> weapons;
    private ArrayList<Monster> monsters;
    
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        //createRooms();
        player = new Player("Dirty Dan",10);
        weapons = new ArrayList<Weapon>();
        monsters = new ArrayList<Monster>();
        createAllWeapons();
        createAllMonsters();
        createRooms();
        
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, saddleSt, rodeoDr, lonestarRd, whiskeyBend, bathHouse, generalStore, behindTheGeneralStore, countyJail, saloon, 
        townSquare, emptyRoom, stable, secretArea, outsideHideOut, darkChamber, blackChamber,bada$$Room, breakRoom, jitteryJims, 
        darkerChamber, biscuitsNBread, whiskeyBent, youreFuqd;
        
        // create the rooms
        outside = new Room("outside the main entrance of Waverly Hills",null,null);
        saddleSt = new Room("on Saddle St.",null,null);
        rodeoDr = new Room("on Rodeo Dr.",null,null);
        lonestarRd = new Room("on Lonestar Rd.",null,null);
        whiskeyBend = new Room("on Whiskey Bend",null,null);
        bathHouse = new Room("in the bath house",null,null);
        generalStore = new Room("in the general store",null,null);
        behindTheGeneralStore = new Room("behind the general store",null,null);
        countyJail = new Room("in the county jail",weapons.get(0),null);
        saloon = new Room("in the saloon",null,null);
        townSquare = new Room("in the town square",weapons.get(1),monsters.get(0));
        stable = new Room("in the stable",null,null);
        secretArea = new Room("- WOW there's a helicopter", weapons.get(3), null);

        
        //hide out rooms
        
        outsideHideOut = new Room("outside Mad Dog Tannen's Hideout after a long ride",null,null);
        emptyRoom = new Room("in an empty room",null,null);
        darkChamber = new Room("in the dark chamber with a Goon!",null, monsters.get(3));
        blackChamber = new Room("in the black chamber with a Goon!",null, monsters.get(4));
        bada$$Room = new Room("in the bada$$ room and there are Dual-Wield 12-inch Revolvers",weapons.get(2),null);
        breakRoom = new Room("in the break room",null, null);
        jitteryJims = new Room("in the café with some delicious ole coffee to sober you up!", null, null);
        darkerChamber = new Room("in the darker chamber with a high Goon!", null, monsters.get(1));
        biscuitsNBread = new Room("in the delicious diner grab some gravy!", null, null);
        whiskeyBent = new Room("in the bar take a break come grab some whiskey and dance!", null, null); 
        youreFuqd = new Room("in a room with the Top Goon!", null, monsters.get(2));


        // initialise room exits
        outside.setExit("north", saddleSt);
        outside.setExit("south", secretArea);
       
        saddleSt.setExit("west", bathHouse);
        saddleSt.setExit("north", rodeoDr);
        saddleSt.setExit("east", generalStore);
        saddleSt.setExit("south", outside);
        
        bathHouse.setExit("east", saddleSt);
        
        rodeoDr.setExit("north", lonestarRd);
        rodeoDr.setExit("south", saddleSt);
        rodeoDr.setExit("east", saloon);
        rodeoDr.setExit("west", countyJail);
        
        behindTheGeneralStore.setExit("west", generalStore);
        
        generalStore.setExit("west", saddleSt);
        generalStore.setExit("east", behindTheGeneralStore);

        countyJail.setExit("east", rodeoDr);

        saloon.setExit("north", whiskeyBend);
        saloon.setExit("west", rodeoDr);


        lonestarRd.setExit("south", rodeoDr);
        lonestarRd.setExit("east", whiskeyBend);

        whiskeyBend.setExit("south", saloon);
        whiskeyBend.setExit("east", townSquare);
        whiskeyBend.setExit("west", lonestarRd);

        townSquare.setExit("north", stable);
        townSquare.setExit("west", whiskeyBend);
        
        stable.setExit("south", townSquare);
        stable.setExit("north", outsideHideOut);
        
        outsideHideOut.setExit("south", emptyRoom);
        
        emptyRoom.setExit("north",outsideHideOut);
        emptyRoom.setExit("west", darkChamber);
        emptyRoom.setExit("east", blackChamber);
        emptyRoom.setExit("south", breakRoom);
        
        darkChamber.setExit("south", bada$$Room);
        darkChamber.setExit("east",emptyRoom);
        
        blackChamber.setExit("west", emptyRoom);
        blackChamber.setExit("south", jitteryJims);
        
        bada$$Room.setExit("north", darkChamber);
        bada$$Room.setExit("east", breakRoom);
        bada$$Room.setExit("south", darkerChamber);
        
        breakRoom.setExit("north", emptyRoom);
        breakRoom.setExit("west", bada$$Room);
        breakRoom.setExit("east", jitteryJims);
        breakRoom.setExit("south", biscuitsNBread);
        
        jitteryJims.setExit("north",blackChamber);
        jitteryJims.setExit("south",whiskeyBent);
        jitteryJims.setExit("west",breakRoom);
        
        darkerChamber.setExit("north", bada$$Room);
        darkerChamber.setExit("east", biscuitsNBread);
        
        biscuitsNBread.setExit("west", darkerChamber);
        biscuitsNBread.setExit("north", breakRoom);
        biscuitsNBread.setExit("east", whiskeyBent);
        biscuitsNBread.setExit("south", youreFuqd);
        
        whiskeyBent.setExit("north",jitteryJims);
        whiskeyBent.setExit("west", biscuitsNBread);
        
        youreFuqd.setExit("north",biscuitsNBread);
        
        
       



        currentRoom = outside;  // start game outside
    }

    public void createAllWeapons()
    {
        Weapon sixInchRevolver = new Weapon("6-inch Revolver",0,6);
        Weapon twelveInchRevolver = new Weapon("12-inch Revolver",0,8);
        Weapon DualWield = new Weapon("Dual Wield 12-inch Revolver",6,12);
        Weapon Helicopter = new Weapon("Apache Attack Helicopter (How did this thing get to the wild west?)",1000,1000);
        weapons.add(sixInchRevolver);
        weapons.add(twelveInchRevolver);
        weapons.add(DualWield);
        weapons.add(Helicopter);
    }

    public void createAllMonsters()
    {
        Monster lowGoon = new Monster("Goon",3,0,2);
        Monster lowGoon2 = new Monster("Goon",3,0,2);
        Monster lowGoon3 = new Monster("Goon",3,0,2);
        Monster highGoon = new Monster("Middle Management Goon",8,1,3);
        Monster topGoon = new Monster("Mad Dog Tannen",20,1,5);
        monsters.add(lowGoon);
        monsters.add(highGoon);
        monsters.add(topGoon);
        monsters.add(lowGoon2);
        monsters.add(lowGoon3);
        //name,health, minhit, maxhit 
    }

    /**
     * Print out the opening message for the player.
     */
    public String printWelcome()
    {
        return "Welcome to unknown town! \n"
        		+ "Type 'help' if you need help. \n";
    }
    
    public String getRoomDesc() {
    	if(currentRoom.getShortDescription().equals("outside the main entrance of Waverly Hills")){
    		return "You are outside the main entrance of your hometown, Waverly Hills. \n"
    				+ "Exits: north\n";
    	}
    	else{
    		return currentRoom.getLongDescription();
    	}
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    public String processCommand(Command command) 
    {
        if(command.isUnknown()) {
            //System.out.println("I don't know what you mean...");
            return "I don't know what you mean... \n";
        }

        String commandWord = command.getCommandWord();
        
        if(currentRoom.hasMonster() == true && currentRoom.getMonster().checkDeath() == false) {
    		//cannot leave
        	if(commandWord.equals("fire") && player.hasWeapon()) {
    			//do damage and take damage then check monster health
    			x = player.attack();
    			y = currentRoom.getMonster().attack();
    			currentRoom.getMonster().takeDmg(x);
    			player.takeDmg(y);
    			if(player.checkDeath()) {
    				//end game
    				return "You have died!\n";
    			} else if(currentRoom.getMonster().checkDeath()) {
    				return "You have killed the bad guy!\n";
    			} else {
    				return "You dealt "+x+" damage and got hit for "+y+"\n";
    			}
    			
    		} else if(commandWord.equals("fire") && !player.hasWeapon()) {
    			y = currentRoom.getMonster().attack();
    			player.takeDmg(y);
    			return "You do not have a weapon to fire! \n"+"You take "+y+" amount of dmg!\n";
    		} else if(commandWord.equals("help")) {
    			return "Your command words are: 'quit','help','fire','health' \n";
    		} else if(commandWord.equals("health")) {
    			return "Your current health is: "+player.getHealth()+"\n";
    		} else if(commandWord.equals("quit")) {
    			return "Goodbye!";
    		} else if(!commandWord.equals("fire")) {
    			return "You cannot run away from battle \n";
    		}
        	
    	} else {
    		if (commandWord.equals("help")) {
            	return "Your command words are: 'go','quit','fire','help','inventory','look',pickup','health' \n";
            }
            else if (commandWord.equals("go")) {
                return goRoom(command);
            }
            else if (commandWord.equals("look")) {
            	if(currentRoom.getShortDescription().equals("outside the main entrance of Waverly Hills")) {
            		return "Upon closer inspection you notice an exit to the south \n";
            	} else if(currentRoom.getWeapon()!=null) {
            		return "You see a "+currentRoom.getWeapon().getDesc()+ " on the floor\n";
            	} else {
            		return currentRoom.getLongDescription()+"\n";
            	}
            }
            else if(commandWord.equals("inventory")) {
            	if(player.getWeapon()==null) {
            		return "You are wielding your bare hands \n";
            	} else {
            		return "you are wielding a "+player.getWepName()+"\n";
            	}
            }
            else if(commandWord.equals("health")) {
    			return "Your current health is: "+player.getHealth()+"\n";
    		} 
            else if(commandWord.equals("fire")) {
    			return "You probably shouldn't randomly fire shots in public... \n";
    		} 
            else if (commandWord.equals("pickup")) {
            	if(currentRoom.hasWeapon() == true) {
            		player.assignWeapon(currentRoom.getWeapon());
            		return "You pickup a "+currentRoom.getWeapon().getDesc()+"\n";
            	} else if(currentRoom.hasWeapon() == false) {
            		return "There's nothing to pickup! \n";
            	}
            }
            else if (commandWord.equals("quit")) {
                //wantToQuit = quit(command);
            	return "Goodbye!";
            }		
    	}
        // else command not recognised.
        return null;
    }

    /** 
     * Try to in to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     * @return 
     */
    private String goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            return "Go where? \n";
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            return "There is no door! \n";
        }
        else {
        	if(currentRoom.getShortDescription().equals("in the town square")) {
	        	player.drink3 = true;
	        	currentRoom = nextRoom;
	        	return "Before you leaving, you notice a flask has fallen from the goon. You grab it, take a swig, \n"
	        			+ "then leave. " + currentRoom.getLongDescription()+"\n";
	        	}
        	if(currentRoom.getShortDescription().equals("in the stable")){
	        	if(command.getSecondWord().equals("north"))	
	        	{
        			if(player.rope == false || player.drink1 == false || player.drink2 == false || player.drink3 == false)
	        		{
	        			return "You aren't yet ready to ride to Mad Dog Tannen's hideout. Make sure you have a rope,"
	        					+ " and that you have taken three drinks (but no more, as per the rules). \n"
	        					+ currentRoom.getLongDescription()+"\n";
	        		}
	        	}
        	}
        	if(currentRoom.getShortDescription().equals("in a room with the Top Goon!")){
        		if(player.coffee == false)
        		{
        			return "While you needed some liquid courage to ride to the hideout, you know you'll"
        					+ " need to sober up before facing Mad Dog Tannen. Find some coffee. \n"
        					+ currentRoom.getLongDescription()+"\n";
        		}
        		
        	}
	        else{
		        		currentRoom = nextRoom;
			            if(currentRoom.getShortDescription().equals("behind the general store")) {
			            	return "You have been attacked by a bear and have died. \n ";
			            			
			            	//player dies
			            	//end game
			            }
			            if(currentRoom.getShortDescription().equals("in the general store")){
			            	player.rope = true;
			            	return "You are in the general store. After you mention your mission to Bill,"
			            			+ " the store clerk, he offers you a rope. You take it. ";
			            }
			            if(currentRoom.getShortDescription().equals("in the saloon")){
			            	player.drink1 = true;
			            	return "You swing open the doors of the saloon and enter in style."
			            			+ " The bartender, your old friend John, offers you a free drink"
			            			+ " of whiskey, and you accept.\n";
			            }
			            if(currentRoom.getShortDescription().equals("in the bath house")){
			            	player.drink2 = true;
			            	return "You are in the bath house. Paul, the owner, mentions that you smell fine"
			            			+ "by wild west standards and that you don't need a bath. \"What you need,\" "
			            			+ "he says, \"is a drink!\" He then offers you a drink of whiskey, and you accept. \n";
			            }
			            if(currentRoom.getShortDescription().equals("in the cafe with some delicious ole coffee to sober you up!")){
			            	player.coffee = true;
			            	return "You are in the cafe. You notice a coffee pot with the logo \"Jittery Jim's\" on it. Coffee"
			            			+ " is just what you need to sober up for the fight, so you drink a cup. \n";
			            }
			            }
			            if(currentRoom.hasMonster() && currentRoom.getMonster().checkDeath() == false) {
		            		if(currentRoom.getMonster().getName() == "Mad Dog Tannen")
		            		{
		            			return "You see Mad Dog Tannen. He stands up, looks you in the eye and says,"
		            					+ " \"Let's settle this like men.\" \n";
		            		}
		            		else
		            		{
		            			return "There is a "+currentRoom.getMonster().getName()+" and they want to duel! \n";
		            		}
		            	} 
		            	else {
		            	return currentRoom.getLongDescription()+"\n";
		            	}
        }
    }
    
}
