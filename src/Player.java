import java.util.*;

/**
 * Write a description of class Player here.
 * 
 * @author Tanzeel
 */
public class Player{
	/**
	 * feilds :
	 */
	private String name;
	private String description;
	private Room currentRoom;
	private double currweight;
	private int weight;
	private HashMap<String,Item> itemsInPossesion;
	private Room previousRoom;
	/**
	 * Constructor for objects of class Player
	 */
	public Player(String name, String description, int weight) {
		this.name = name;
		this.description = description;
		this.weight = weight;
		itemsInPossesion = new HashMap<String,Item>();
	}

	public Room getCurrentPlayerRoom() {
		return currentRoom;
	}

	public String getPlayerDescription() {
		return description;
	}

	public String getPlayerName() {
		return name;
	}

	public String getFullPlayerDescription() {
		return name + " \n Can pick upto : " + weight
				+ " Kg. \n total wight carried : "+this.currweight 
				+ " \n bag pack :\n"  + InventoryToString();
	}

	public boolean pick(String itemName,Item item) {
		if (canPickItem(item)) {
			itemsInPossesion.put(itemName,item);
			currweight += item.getItemWeight();
			return true;
		} else {
			System.out.println("Player can not pick " + item);
			return false;
		}
	}

	public Item drop(String itemName) {
		if (!itemsInPossesion.containsKey(itemName)) {
			return null;
		} else {
			Item itemDropped = itemsInPossesion.get(itemName);
            currweight -= itemDropped.getItemWeight();
            itemsInPossesion.remove(itemName);
			return itemDropped;
		}
	}
	public Item getItem(String key){
        return itemsInPossesion.get(key);
    }
	private boolean canPickItem(Item item) {
		if ((this.currweight + item.getItemWeight()) > weight) {
			return false;
		}
		return true;
	}


	public void printItemsAndWeight() {
	    Set<String> keys = itemsInPossesion.keySet();
		for (String items : keys) {
			System.out.println( itemsInPossesion.get(items).getItemDescription() + " "
					+  itemsInPossesion.get(items).getItemWeight() + "\n");
		}
		System.out.println(this.currweight);

	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	public Room getPreviousRoom() {
		return previousRoom;
	}
	public void setPreviousRoom(Room previousRoom) {
		this.previousRoom = previousRoom;
	}
	public String InventoryToString(){
        String str = "";
        Set<String> keys = itemsInPossesion.keySet();
        for (String items : keys){
            str += itemsInPossesion.get(items).getItemDescription() + " "
                    +  itemsInPossesion.get(items).getItemWeight() + "\n";
        }
        return str;
    }
	  
}

