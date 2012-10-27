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
				tiles[i][j].add(new JLabel("(" + i + "," + j + ")"));
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
			setPanel(1, 1, currentRoom.getRoomPanel());
			//refresh();
			this.repaint();
		}
	}
	
	public void setPanel(int x, int y, JPanel panel) {
		tiles[x][y] = panel;
	}
	
	public void refresh() {
		this.removeAll();
		for (int i=0; i<SIZE; i++ ){
			for (int j=0; j<SIZE; j++) {
				add(tiles[i][j]);
			}
		}
	}

}
