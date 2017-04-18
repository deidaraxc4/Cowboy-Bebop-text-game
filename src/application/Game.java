package application;

public class Game 
{
    private Parser parser;
    private ParserWithFileInput parserWithFileInput;
    private Room currentRoom;
    public static boolean finished = false;
    private Player player;
    
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        player = new Player("Dirty Dan",10);
        
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        /*Room outside, theater, pub, lab, office;
      
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        theater.setExit("west", outside);
        pub.setExit("east", outside);
        lab.setExit("north", outside);
        lab.setExit("east", office);
        office.setExit("west", lab);
        currentRoom = outside;*/  // start game outside
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
    	return currentRoom.getLongDescription();
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
        
        if(currentRoom.hasMonster() == true) {
    		//cannot leave
    		if(!commandWord.equals("fire")) {
    			return "You cannot run away from battle \n";
    		} else if(commandWord.equals("fire") && player.hasWeapon()) {
    			//do damage and take damge then check monster health
    			
    		} else if(commandWord.equals("fire") && !player.hasWeapon()) {
    			return "You do not have a weapon to fire! \n";
    		} else if(commandWord.equals("help")) {
    			return "Your command words are: 'go','quit','help','look,'pickup' \n";
    		} else if(commandWord.equals("quit")) {
    			return "Goodbye!";
    		}
    	} else {
    		if (commandWord.equals("help")) {
            	return "Your command words are: 'go','quit','help','look',pickup' \n";
            }
            else if (commandWord.equals("go")) {
                return goRoom(command);
            }
            else if (commandWord.equals("look")) {
            	return currentRoom.getLongDescription()+"\n";
            }
            else if (commandWord.equals("pickup")) {
            	if(currentRoom.hasWeapon() == true) {
            		player.assignWeapon(currentRoom.getWeapon());
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
	        			+ "then leave." + currentRoom.getLongDescription()+"\n";
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
			            	return "You are in the general store. After you mention your mission to Bill, \n"
			            			+ "the store clerk, he offers you a rope. You take it.";
			            }
			            if(currentRoom.getShortDescription().equals("in the saloon")){
			            	player.drink1 = true;
			            	return "You swing open the doors of the saloon and enter in style. \n"
			            			+ "The bartender, your old friend John, offers you a free drink \n"
			            			+ "of whiskey, and you accept.";
			            }
			            if(currentRoom.getShortDescription().equals("in the bath house")){
			            	player.drink2 = true;
			            	return "You are in the bath house. Paul, the owner, mentions that you smell fine \n"
			            			+ "by wild west standards and that you don't need a bath. \"What you need,\" \n"
			            			+ "he says, \"is a drink!\" He then offers you a drink of whiskey, and you accept.";
			            }
			            if(currentRoom.getShortDescription().equals("in the cafe with some delicious ole coffee to sober you up!")){
			            	player.coffee = true;
			            	return "You are in the cafe. You notice a coffee pot with the logo \"Jittery Jim's\" on it. Coffee \n"
			            			+ "is just what you need to sober up for the fight, so you drink a cup.";
			            }
			            }
			            if(currentRoom.hasMonster()) {
		            		return "There is a "+currentRoom.getMonster().getName()+" and they want to duel! \n";
		            	} 
		            	else {
		            	return currentRoom.getLongDescription()+"\n";
		            	}
		            }
            	
             }
            
        
            	
        
    }
    
}