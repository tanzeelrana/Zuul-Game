package view;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Room;

/**
 * DrawableRoom extends Room and provides support for drawing a visual representation
 * of the room on a JPanel
 * @author sean byron
 *
 */

public class DrawableRoom extends Room {

	private static final String SOUTH = "south";
	private static final String EAST = "east";
	private static final String WEST = "west";
	private static final String NORTH = "north";
	
	private static final int WINDOW_SIZE = 200;
	
	private JPanel panel;
	
	public DrawableRoom(String description) {
		super(description);
	}
	
	/**
	 * Returns a JPanel representing the room visually. Exits are shown.
	 * @return
	 */
	public JPanel getRoomPanel() {
		panel = new JPanel();		
		panel.setLayout(new BorderLayout(0, 0));
		
		panel.setBackground(Color.WHITE);
		panel.setBorder(null);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel south = new JLabel("");
		south.setBorder(null);
		south.setBackground(Color.WHITE);
		if (this.getExit(SOUTH) != null) {
			south.setIcon(new ImageIcon(DrawableRoom.class.getResource("/img/exit-south.gif")));
		} else {
			south.setIcon(new ImageIcon(DrawableRoom.class.getResource("/img/wall-south.gif")));
		}
		panel.add(south, BorderLayout.SOUTH);
		
		JLabel west = new JLabel("");
		west.setBackground(Color.WHITE);
		if (this.getExit(WEST) != null) {
			west.setIcon(new ImageIcon(DrawableRoom.class.getResource("/img/exit-west.gif")));
		} else {
			west.setIcon(new ImageIcon(DrawableRoom.class.getResource("/img/wall-west.gif")));
		}
		panel.add(west, BorderLayout.WEST);
		
		JLabel north = new JLabel("");
		if (this.getExit(NORTH) != null) {
			north.setIcon(new ImageIcon(DrawableRoom.class.getResource("/img/exit-north.gif")));
		} else {
			north.setIcon(new ImageIcon(DrawableRoom.class.getResource("/img/wall-north.gif")));
		}
		panel.add(north, BorderLayout.NORTH);
		
		JLabel east = new JLabel("");
		if (this.getExit(EAST) != null) {
			east.setIcon(new ImageIcon(DrawableRoom.class.getResource("/img/exit-east.gif")));
		} else {
			east.setIcon(new ImageIcon(DrawableRoom.class.getResource("/img/wall-east.gif")));
		}
		panel.add(east, BorderLayout.EAST);
		
		JLabel room = new JLabel(this.getDescription());
		room.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(room, BorderLayout.CENTER);
		
		panel.setSize(WINDOW_SIZE,WINDOW_SIZE);
		
		return panel;
	}
}
