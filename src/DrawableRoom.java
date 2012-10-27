import javax.swing.JLabel;
import javax.swing.JPanel;


public class DrawableRoom extends Room {

	public DrawableRoom(String description) {
		super(description);
	}
	
	public JPanel getRoomPanel() {
		JPanel panel = new JPanel();
		panel.add(new JLabel(this.getDescription()));
		return panel;
	}

}
