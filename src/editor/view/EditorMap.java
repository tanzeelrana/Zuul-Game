package editor.view;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import editor.controller.EditorListener;
import editor.controller.EditorUpdateObject;

import model.Room;
import view.FirstPersonRoom;
import view.MapRoom;

/**
 * MapView represents the 2D view of a room
 * @author Sean
 *
 */

public class EditorMap extends JFrame implements Observer {
	
	private static final long serialVersionUID = 1L;
	
	private static int SIZE = 3;
	private static int WINDOW_SIZE = 600;
	private JPanel[][] tiles;
	private GridLayout layout;
	
	private String[][] roomsArray;
	private HashMap<String,FirstPersonRoom> rooms;
	private int x;
	private int y;
	
	private int maxX;
	private int maxY;
	
	private EditorListener mouseListener;
	
	public EditorMap(String name, int x, int y, EditorListener mouseListener) {
		super(name);
		
		maxX = x;
		maxY = y;
		
		//Initialize the starting position to (0,0)
		x = 0;
		y = 0;
		
		//Initialize the layout
		layout = new GridLayout(SIZE,SIZE);
		getContentPane().setLayout(layout);
		
		tiles = new JPanel[SIZE][SIZE];
		
		//Setup the window
		setSize(WINDOW_SIZE,WINDOW_SIZE);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(Color.BLACK);
		
		this.mouseListener = mouseListener;
		
		roomsArray = new String[maxX][maxY];
		rooms = new HashMap<String, FirstPersonRoom>();
		
		update(null,null);
	}

	/**
	 * Update the tiles with the current state of the game
	 */
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof EditorUpdateObject) {
			EditorUpdateObject update = (EditorUpdateObject)arg1;
			
			x = update.getSelectedX();
			y = update.getSelectedY();
			
			roomsArray = update.getRoomsArray();
			rooms = update.getRooms();
		}
		
		if (arg1 instanceof Point) {
			Point point = (Point)arg1;
			
			int tempX = (int) point.getX();
			int tempY  = (int) point.getY();
			
			if (tempX >= 0 && tempX < maxX && tempY >=0 && tempY < maxY) {
				x = tempX;
				y = tempY;
			}
		}

		int tempX = 0;
		int tempY = 0;
		
		//Remove all the current tiles
		getContentPane().removeAll();
		
		for (int i=x-1; i<=x+1; i++) {
			for (int j=y-1; j<=y+1; j++) {
				if (i>=0 && j>=0 && i<maxX && j<maxY) {
					if (rooms.get(roomsArray[i][j]) != null) {
						MapRoom temp = (MapRoom)rooms.get(roomsArray[i][j]);
						tiles[tempX][tempY] = temp.getMapPanel();
						tiles[tempX][tempY].setBorder(BorderFactory.createLineBorder(Color.white));
					} else {
						tiles[tempX][tempY] = new JPanel();
						tiles[tempX][tempY].setBackground(Color.BLACK);
						tiles[tempX][tempY].setBorder(BorderFactory.createLineBorder(Color.white));
						JLabel temp = new JLabel("(" + i + "," + j + ")");
						temp.setForeground(Color.white);
						tiles[tempX][tempY].add(temp);
					}
				} else {
					tiles[tempX][tempY] = new JPanel();
					tiles[tempX][tempY].setBackground(Color.WHITE);
					getContentPane().add(tiles[tempX][tempY]);
				}
				tiles[tempX][tempY].setToolTipText(i+","+j);
				tiles[tempX][tempY].addMouseListener(mouseListener);
				getContentPane().add(tiles[tempX][tempY]);
				tempY++;
			}
			tempY=0;
			tempX++;
		}

		//Set the border of the middle tile to red to indicate its selected
		tiles[1][1].setBorder(null);
		tiles[1][1].setBorder(BorderFactory.createLineBorder(Color.red));

		//Repaint the 2D View
		validate();
		repaint();
	}
}
