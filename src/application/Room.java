package application;
import java.util.Set;
import java.util.HashMap;



public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private Monster monster;
    private Weapon weapon;
    private String lookText;
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description, Weapon weapon, Monster monster, String lookText)//add monster and weapon
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        this.monster = monster;
        this.weapon = weapon;
        this.lookText = lookText;
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getLookText()
    {
    	return lookText + getExitString();
    }
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }
    

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString +"\n";
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    public Weapon getWeapon() {
    	return weapon;
    }
    
    public Monster getMonster() {
    	return monster;
    }
    
    public boolean hasWeapon() {
    	if(weapon!=null) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public boolean hasMonster() {
    	if(monster!=null) {
    		return true;
    	} else {
    		return false;
    	}
    }
}