import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


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
		
		panel.setBackground(Color.WHITE);
		panel.setBorder(null);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel south = new JLabel("");
		south.setBorder(null);
		south.setBackground(Color.WHITE);
		if (this.getExits(SOUTH) != null) {
			south.setIcon(new ImageIcon(DrawableRoom.class.getResource("/img/exit-south.gif")));
		} else {
			south.setIcon(new ImageIcon(DrawableRoom.class.getResource("/img/wall-south.gif")));
		}
		panel.add(south, BorderLayout.SOUTH);
		
		JLabel west = new JLabel("");
		west.setBackground(Color.WHITE);
		if (this.getExits(WEST) != null) {
			west.setIcon(new ImageIcon(DrawableRoom.class.getResource("/img/exit-west.gif")));
		} else {
			west.setIcon(new ImageIcon(DrawableRoom.class.getResource("/img/wall-west.gif")));
		}
		panel.add(west, BorderLayout.WEST);
		
		JLabel north = new JLabel("");
		if (this.getExits(NORTH) != null) {
			north.setIcon(new ImageIcon(DrawableRoom.class.getResource("/img/exit-north.gif")));
		} else {
			north.setIcon(new ImageIcon(DrawableRoom.class.getResource("/img/wall-north.gif")));
		}
		panel.add(north, BorderLayout.NORTH);
		
		JLabel east = new JLabel("");
		if (this.getExits(EAST) != null) {
			east.setIcon(new ImageIcon(DrawableRoom.class.getResource("/img/exit-east.gif")));
		} else {
			east.setIcon(new ImageIcon(DrawableRoom.class.getResource("/img/wall-east.gif")));
		}
		panel.add(east, BorderLayout.EAST);
		
		JLabel room = new JLabel(this.getDescription());
		room.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(room, BorderLayout.CENTER);
		
//		JPanel west = new JPanel();
//		if (this.getExits(WEST) == null) {
//			west.setBackground(Color.BLACK);
//		} else {
//			west.setBackground(Color.WHITE);
//		}
//		panel.add(west, BorderLayout.WEST);
//		
//		JPanel north = new JPanel();
//		if (this.getExits(NORTH) == null) {
//			north.setBackground(Color.BLACK);
//		} else {
//			north.setBackground(Color.WHITE);
//		}
//		panel.add(north, BorderLayout.NORTH);
//		
//		JPanel south = new JPanel();
//		if (this.getExits(SOUTH) == null) {
//			south.setBackground(Color.BLACK);
//		} else {
//			south.setBackground(Color.WHITE);
//		}
//		panel.add(south, BorderLayout.SOUTH);
//		
//		JPanel east = new JPanel();
//		if (this.getExits(EAST)== null) {
//			east.setBackground(Color.BLACK);
//		} else {
//			east.setBackground(Color.WHITE);
//		}
//		panel.add(east, BorderLayout.EAST);
//		
//		JPanel center = new JPanel();
//		center.setBackground(Color.WHITE);
//		panel.add(center, BorderLayout.CENTER);
//		
//		JLabel roomName = new JLabel(this.getDescription());
//		center.add(roomName);
		
		panel.setSize(WINDOW_SIZE,WINDOW_SIZE);
	}

}
