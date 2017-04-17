package application;

public class Game 
{
    private Parser parser;
    private ParserWithFileInput parserWithFileInput;
    private Room currentRoom;
    public static boolean finished = false;
    
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office;
      
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

        currentRoom = outside;  // start game outside
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
        
        //outter if statement to check if currentRoom has no monster else can only do fight commands
        if(command.isUnknown()) {
            //System.out.println("I don't know what you mean...");
            return "I don't know what you mean... \n";
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            //return printHelp();
        	return "Your command words are: 'go','quit','help' \n";
        }
        else if (commandWord.equals("go")) {
            return goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            //wantToQuit = quit(command);
        	return "Goodbye!";
        	
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
            currentRoom = nextRoom;
            return currentRoom.getLongDescription();
        }
    }
    
}
