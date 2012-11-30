package save;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

import view.FirstPersonRoom;

import model.object.Player;

public class GameSave implements Serializable {

	private static final long serialVersionUID = 7983237743914423243L;
	private Player player;
	private HashMap<String, FirstPersonRoom> rooms;
	
	public GameSave(Player player, HashMap<String, FirstPersonRoom> rooms) {
		this.player = player;
		this.rooms = rooms;
	}
	
	public GameSave() {
		this(null, null);
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public HashMap<String, FirstPersonRoom> getRooms() {
		return rooms;
	}
	
	public void setRooms(HashMap<String, FirstPersonRoom> rooms) {
		this.rooms = rooms;
	}
	
	public boolean serialize(String path) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(path)));
			out.writeObject(this);
			out.close();
			return true;
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
	}
	
	public boolean loadFromSerial(String path) {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(path)));
			Object object = in.readObject();
			in.close();
			
			if (object instanceof GameSave) {
				GameSave save = (GameSave)object;
				setPlayer(save.getPlayer());
				setRooms(save.getRooms());
				return true;
			}
			
			return false;
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		} catch (ClassNotFoundException e) {
			return false;
		}
		
	}

}
