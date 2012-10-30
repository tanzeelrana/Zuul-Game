import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * MapView represents the 2D view of a room
 * @author Sean
 *
 */

public class MapView extends JFrame implements Observer {
	
	private static int SIZE = 3;
	private static int WINDOW_SIZE = 600;
	private JPanel[][] tiles;
	private GridLayout layout;
	
	public MapView(String name) {
		super(name);
		
		//Initialize the layout
		layout = new GridLayout(SIZE,SIZE);
		this.setLayout(layout);
		
		tiles = new JPanel[SIZE][SIZE];
		
		//Initialize the tiles
		for (int i=0; i<SIZE; i++ ){
			for (int j=0; j<SIZE; j++) {
				tiles[i][j] = new JPanel();
				//tiles[i][j].add(new JLabel("(" + i + "," + j + ")"));
				add(tiles[i][j]);
			}
		}
		
		//Setup the window
		setSize(WINDOW_SIZE,WINDOW_SIZE);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String args[]) {
		MapView view = new MapView("World of Zuul");
		view.setVisible(true);
	}

	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof DrawableRoom) {
			DrawableRoom currentRoom = (DrawableRoom)arg1;
			
			Room northRoom = currentRoom.getExits("north");
			Room northWest = null;
			Room northEast = null;
			
			if (northRoom != null) {
				northWest = northRoom.getExits("west");
				northEast = northRoom.getExits("east");
			}
			
			Room southRoom = currentRoom.getExits("south");
			Room southWest = null;
			Room southEast = null;
			
			if (southRoom != null) {
				southWest = southRoom.getExits("west");
				southEast = southRoom.getExits("east");
			}
			
			Room eastRoom = currentRoom.getExits("east");
			Room westRoom = currentRoom.getExits("west");
			
			
			//Set the current room to the middle tile (1,1)
			setPanel(1, 1, currentRoom.getRoomPanel());
			

			//North tile
			if (northRoom != null) {
				//Set the panel at (0,1) to the room north of the current room
				setPanel(0,1, ((DrawableRoom) northRoom).getRoomPanel());
			} else {
				setPanel(0,1, new JPanel());
			}
				
			//North West tile
			if (northWest != null) {
				setPanel(0,0,((DrawableRoom) northWest).getRoomPanel());
			} else {
				setPanel(0,0, new JPanel());
			}
			
			//North East tile
			if (northEast != null) {
				setPanel(0,2,((DrawableRoom) northEast).getRoomPanel());
			}else {
				setPanel(0,2, new JPanel());
			}
			
			//South tile
			if (southRoom != null) {
				//Set the panel at (2,1) to the room north of the current room
				setPanel(2,1, ((DrawableRoom) southRoom).getRoomPanel());
			}else {
				setPanel(2,1, new JPanel());
			}
			
			//South West tile
			if (southWest != null) {
				setPanel(2,0,((DrawableRoom) southWest).getRoomPanel());
			}else {
				setPanel(2,0, new JPanel());
			}
			
			//South East tile
			if (southEast != null) {
				setPanel(2,2,((DrawableRoom) southEast).getRoomPanel());
			}else {
				setPanel(2,2, new JPanel());
			}
			
			//East tile
			if (eastRoom != null) {
				setPanel(1,2, ((DrawableRoom) eastRoom).getRoomPanel());
			}else {
				setPanel(1,2, new JPanel());
			}
			
			if (westRoom != null) {
				//Set the panel at (1,0) to the room north of the current room
				setPanel(1,0, ((DrawableRoom) westRoom).getRoomPanel());
			}else {
				setPanel(1,0, new JPanel());
			}
			
			refresh();
		}
	}
	
	public void setPanel(int x, int y, JPanel panel) {
		remove(tiles[x][y]);
		tiles[x][y] = panel;
	}
	
	public void refresh() {
		getContentPane().removeAll();
		
		for (int i=0; i<SIZE; i++ ){
			for (int j=0; j<SIZE; j++) {
				add(tiles[i][j]);
			}
		}
		
		validate();
		repaint();
	}

}
