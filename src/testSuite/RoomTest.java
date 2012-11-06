package testSuite;

import view.DrawableRoom;
import model.Room;
import junit.framework.TestCase;

public class RoomTest extends TestCase {
	private final static String NORTH = "north";
	private final static String SOUTH = "south";
	private final static String EAST = "east";
	private final static String WEST = "west";
	
	private Room gallery;
	private Room workshop;
	private Room lobby;
	
	protected void setUp() throws Exception {
		super.setUp();
		gallery = new Room("Gallery");
		workshop = new Room("Workshop");
		lobby = new Room("Lobby");
	}

	public void testSetExits() {
		gallery.setExits(NORTH, workshop);
	}

	public void testGetDescription() {
		fail("Not yet implemented");
	}

	public void testGetLongDescription() {
		fail("Not yet implemented");
	}

	public void testGetExit() {
		fail("Not yet implemented");
	}

	public void testAddItem() {
		fail("Not yet implemented");
	}

	public void testReomoveItem() {
		fail("Not yet implemented");
	}

	public void testGetItem() {
		fail("Not yet implemented");
	}

	public void testContainsItem() {
		fail("Not yet implemented");
	}

	public void testAddMonster() {
		fail("Not yet implemented");
	}

	public void testRemoveMonster() {
		fail("Not yet implemented");
	}

	public void testGetMonster() {
		fail("Not yet implemented");
	}

	public void testVisit() {
		fail("Not yet implemented");
	}

	public void testHasBeenVisited() {
		fail("Not yet implemented");
	}

}
