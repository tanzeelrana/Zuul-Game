package editor.controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class EditorListener extends Observable implements MouseListener {

	public EditorListener() {

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {		
		if (arg0.getSource() instanceof JPanel) {
			JPanel source = (JPanel)arg0.getSource();
			String[] temp = source.getToolTipText().split(",");
			
			int x = Integer.parseInt(temp[0]);
			int y = Integer.parseInt(temp[1]);
			
			setChanged();
			notifyObservers(new Point(x, y));
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		return;
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		return;
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		return;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		return;
	}

}
