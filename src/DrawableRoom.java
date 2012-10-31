import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;


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
	
	public JPanel getRoomPanel() {
		drawPanel();
		return panel;
	}
	
	private void drawPanel() {
		panel = new JPanel();		
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel west = new JPanel();
		if (this.getExits(WEST) == null) {
			west.setBackground(Color.BLACK);
		} else {
			west.setBackground(Color.WHITE);
		}
		panel.add(west, BorderLayout.WEST);
		
		JPanel north = new JPanel();
		if (this.getExits(NORTH) == null) {
			north.setBackground(Color.BLACK);
		} else {
			north.setBackground(Color.WHITE);
		}
		panel.add(north, BorderLayout.NORTH);
		
		JPanel south = new JPanel();
		if (this.getExits(SOUTH) == null) {
			south.setBackground(Color.BLACK);
		} else {
			south.setBackground(Color.WHITE);
		}
		panel.add(south, BorderLayout.SOUTH);
		
		JPanel east = new JPanel();
		if (this.getExits(EAST)== null) {
			east.setBackground(Color.BLACK);
		} else {
			east.setBackground(Color.WHITE);
		}
		panel.add(east, BorderLayout.EAST);
		
		JPanel center = new JPanel();
		center.setBackground(Color.WHITE);
		panel.add(center, BorderLayout.CENTER);
		
		JLabel roomName = new JLabel(this.getDescription());
		center.add(roomName);
		
		panel.setSize(WINDOW_SIZE,WINDOW_SIZE);
	}

}
