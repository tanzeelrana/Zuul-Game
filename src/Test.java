import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;


public class Test extends JPanel {

	/**
	 * Create the panel.
	 */
	public Test() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel west = new JPanel();
		west.setBackground(Color.BLACK);
		add(west, BorderLayout.WEST);
		
		JPanel north = new JPanel();
		north.setBackground(Color.BLACK);
		add(north, BorderLayout.NORTH);
		
		JPanel south = new JPanel();
		south.setBackground(Color.BLACK);
		add(south, BorderLayout.SOUTH);
		
		JPanel east = new JPanel();
		east.setBackground(Color.BLACK);
		add(east, BorderLayout.EAST);
		
		JPanel center = new JPanel();
		center.setBackground(Color.WHITE);
		add(center, BorderLayout.CENTER);
		
		JLabel roomName = new JLabel("Room");
		center.add(roomName);

	}

}
