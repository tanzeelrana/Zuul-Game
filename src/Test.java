import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;


public class Test extends JPanel {

	/**
	 * Create the panel.
	 */
	public Test() {
		setBackground(Color.WHITE);
		setBorder(null);
		setLayout(new BorderLayout(0, 0));
		
		JLabel south = new JLabel("");
		south.setBorder(null);
		south.setBackground(Color.WHITE);
		south.setIcon(new ImageIcon(Test.class.getResource("/img/exit-south.gif")));
		add(south, BorderLayout.SOUTH);
		
		JLabel west = new JLabel("");
		west.setBackground(Color.WHITE);
		west.setIcon(new ImageIcon(Test.class.getResource("/img/exit-west.gif")));
		add(west, BorderLayout.WEST);
		
		JLabel north = new JLabel("");
		north.setIcon(new ImageIcon(Test.class.getResource("/img/exit-north.gif")));
		add(north, BorderLayout.NORTH);
		
		JLabel east = new JLabel("");
		east.setIcon(new ImageIcon(Test.class.getResource("/img/exit-east.gif")));
		add(east, BorderLayout.EAST);
		
		JLabel room = new JLabel("Room");
		room.setHorizontalAlignment(SwingConstants.CENTER);
		add(room, BorderLayout.CENTER);

	}

}
