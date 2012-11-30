package model.object;

import java.io.Serializable;
import java.util.*;

import model.Room;

/**
 * Write a description of class Player here.
 * 
 * @author Tanzeel
 */
public class Player implements Serializable {

	private static final int DEFAULT_WEIGHT = 10;
	private static final int DEFAULT_HEALTH = 20;
	
	private static final long serialVersionUID = -1328953072318488091L;
	private String name;
	private Room currentRoom;
	private int currentWeight;
	private int maxWeight;
	private HashMap<String, Item> itemsInPossesion;
	private int health;
	private String lookingDirection = "north";

	/**
	 * Constructor for objects of class Player
	 */
	public Player() {
		this(DEFAULT_WEIGHT,DEFAULT_HEALTH);
	}
	
	
	public Player(int weight, int health) {
		this("Me", weight, health);
	}
	
	public Player(String name, int maxWeight, int health) {
		this.name = name;
		this.maxWeight = maxWeight;
		this.health = health;
		currentWeight = 0;
		itemsInPossesion = new HashMap<String, Item>();
	}

	/**
	 * Get the room the player is currently in
	 * 
	 * @return current room
	 */
	public Room getCurrentPlayerRoom() {
		return currentRoom;
	}

	/**
	 * Get the player's name
	 * 
	 * @return name
	 */
	public String getPlayerName() {
		return name;
	}

	/**
	 * Sets the players name
	 * 
	 * @param name
	 */
	public void setPlayerName(String name) {
		this.name = name;
	}

	/**
	 * Pick up an item
	 * 
	 * @param itemName
	 * @param item
	 * @return
	 */
	public boolean pick(String itemName, Item item) {
		if (canPickItem(item)) {
			itemsInPossesion.put(itemName, item);
			currentWeight += item.getItemWeight();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Drop the item called itemName
	 * 
	 * @param itemName
	 * @return
	 */
	public Item drop(String itemName) {
		if (!itemsInPossesion.containsKey(itemName)) {
			return null;
		} else {
			Item itemDropped = itemsInPossesion.get(itemName);
			currentWeight -= itemDropped.getItemWeight();
			itemsInPossesion.remove(itemName);
			return itemDropped;
		}
	}

	/**
	 * Returns a reference to the item in the inventory with key key. Does not
	 * remove the item from the inventory
	 * 
	 * @param key
	 * @return
	 */
	public Item getItem(String key) {
		return itemsInPossesion.get(key);
	}

	/**
	 * @param item
	 * @return true if user has room in the inventory
	 */
	private boolean canPickItem(Item item) {
		if ((currentWeight + item.getItemWeight()) > maxWeight) {
			return false;
		}
		return true;
	}

	/**
	 * Set the players current room
	 * 
	 * @param currentRoom
	 */
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	public int getCurrentWeight() {
		return currentWeight;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void attacked(String monsterName) {
		health--;
	}

	public void unAttacked() {
		health++;
	}

	public void heal() {
		health += 5;
	}

	public int getHealth() {
		return health;
	}

	public String getLookingDirection() {
		return lookingDirection;
	}

	public void setLookingDirection(String lookingDirection) {
		this.lookingDirection = lookingDirection;
	}

	public ArrayList<String> getItemsInPosession() {
		return new ArrayList<String>(itemsInPossesion.keySet());
	}

}