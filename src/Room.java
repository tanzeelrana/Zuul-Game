import java.util.*;

/**
 * Class Room - a room in an adventure game.
 * 
 * This class is part of the "World of Zuul" application. "World of Zuul" is a
 * very simple, text based adventure game.
 * 
 * A "Room" represents one location in the scenery of the game. It is connected
 * to other rooms via exits. The exits are labelled north, east, south, west.
 * For each direction, the room stores a reference to the neighboring room, or
 * null if there is no exit in that direction.
 * 
 */
public class Room {
	private String description;
	private HashMap<String, Room> exits;
	private HashMap<String, Item> items;
	private HashMap<String, Monster> monsters;

	/**
	 * Create a room described "description". Initially, it has no exits.
	 * "description" is something like "a kitchen" or "an open court yard".
	 * 
	 * @param description
	 *            The room's description.
	 */
	public Room(String description) {
		this.description = description;
		exits = new HashMap<>();
		items = new HashMap<String, Item>();
		monsters = new HashMap<String, Monster>();
	}

	/**
	 * Define the exits of this room. Every direction either leads to another
	 * room or is null (no exit there).
	 * 
	 * @param north
	 *            The north exit.
	 * @param east
	 *            The east east.
	 * @param south
	 *            The south exit.
	 * @param west
	 *            The west exit.
	 */
	public void setExits(String direction, Room neighbor) {
		exits.put(direction, neighbor);
	}

	/**
	 * @return The description of the room.
	 */
	public String getDescription() {
		return description;
	}

	public String getExitString() {

		String s = "Exits : ";
		Set<String> keys = exits.keySet();
		for (String exit : keys) {
			s += " " + exit;
		}

		return s + "\n";

	}

	/**
	 * Return a long description of this room, of the form : you are in the
	 * kitchen Exits : north west
	 * 
	 * @return A description of the room, include exits
	 * 
	 */
	public String getLongDescription() {
		return ("You are at the " + description + ".\n" + getExitString() + getItemString() + "\n" + getMonstersString());
	}

	public Room getExits(String direction) {
		return exits.get(direction);
	}

	public void addItem(String key, Item item) {
		items.put(key, item);
	}

	private String getItemString() {
		String itemString = "Items in room : ";
		Set<String> keys = items.keySet();
		for (String item : keys) {
			itemString += " Key : " + item + " Description : "
					+ items.get(item).getItemDescription() + " Weight : "
					+ items.get(item).getItemWeight() + "\n";
		}
		return itemString;
	}
	
	/**
	 * Author: Sean
	 * @return returns a list of the monsters in the room and their health
	 */
	private String getMonstersString() {
		String ret = "Monsters in room:\n";
		Set<String> keys = monsters.keySet();
		for (String monster : keys) {
			if (monsters.get(monster).isAlive()) {
				ret += "- Name : " + monster + " (" + monsters.get(monster).getHealth() + ")\n";
			} else {
				ret += "- Name : " + monster + " (DEAD)\n";
			}
		}
		return ret;
	}

	public void reomoveItem(String itemKey) {
		items.remove(itemKey);
	}

	public Item getItem(String itemKey) {
		return items.get(itemKey);
	}

	public boolean containsItem(String itemKey) {
		return items.containsKey(itemKey);
	}
	
	/**
	 * Modification by Sean
	 * Adds a monster to the room
	 * @param key
	 * @param monster
	 */
	public void addMonster(String key, Monster monster) {
		monsters.put(key, monster);
	}
	
	/**
	 * Modification by Sean
	 * Removes a monster with from the room
	 * @param key
	 */
	public void removeMonster(String key) {
		monsters.remove(key);
	}
	
	/**
	 * Modification by Sean Byron
	 * Gets a monster from the room
	 * @param key
	 * @return
	 */
	public Monster getMonster(String key) {
		return monsters.get(key);
	}

}
