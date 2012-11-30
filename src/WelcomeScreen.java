import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import editor.EditorDriver;
import editor.model.LevelEditor;
import editor.view.EditorView;

import javax.swing.JLabel;
import javax.swing.JTextField;

import save.GameSave;
import javax.swing.JSeparator;


public class WelcomeScreen {

	private JFrame frame;
	private GameDriver gameDriver;
	private EditorDriver editorDriver;
	private JTextField txtPath;
	private JTextField width;
	private JTextField height;
	private JTextField txtpathtolevelxml;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeScreen window = new WelcomeScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WelcomeScreen() {
		gameDriver = new GameDriver();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 333, 329);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JButton btnStartGame = new JButton("Start New Game");
		btnStartGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameDriver.startDefaultGame();
			}
		});
		
		JLabel lblWelcomeToWorld = new JLabel("Welcome to World of Zuul!");
		frame.getContentPane().add(lblWelcomeToWorld, "2, 2, 3, 1, center, default");
		frame.getContentPane().add(btnStartGame, "2, 4, 3, 1");
		
		JSeparator separator = new JSeparator();
		frame.getContentPane().add(separator, "2, 6, 3, 1");
		
		JLabel lblPath = new JLabel("Path:");
		frame.getContentPane().add(lblPath, "2, 8, right, default");
		
		txtPath = new JTextField();
		txtPath.setText("/path/to/gamesave");
		frame.getContentPane().add(txtPath, "4, 8, fill, default");
		txtPath.setColumns(10);
		
		JButton btnLoadGame = new JButton("Load Game");
		btnLoadGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GameSave save = new GameSave();
				if (txtPath.getText() != null) {
					boolean success = save.loadFromSerial(txtPath.getText());
					if (success) {
						gameDriver.startGame(save.getPlayer(), save.getRooms());
					} else {
						JOptionPane.showMessageDialog(frame, "Error loading game. Please ensure the specified path exists");
					}
				}
			}
		});
		frame.getContentPane().add(btnLoadGame, "4, 10");
		
		JSeparator separator_1 = new JSeparator();
		frame.getContentPane().add(separator_1, "2, 12, 3, 1");
		
		JLabel lblWidth = new JLabel("Width:");
		frame.getContentPane().add(lblWidth, "2, 14, right, default");
		
		width = new JTextField();
		width.setText("5");
		frame.getContentPane().add(width, "4, 14, fill, default");
		width.setColumns(10);
		
		JLabel lblHeight = new JLabel("Height:");
		frame.getContentPane().add(lblHeight, "2, 16, right, default");
		
		height = new JTextField();
		height.setText("5");
		frame.getContentPane().add(height, "4, 16, fill, default");
		height.setColumns(10);
		
		JButton btnLevelEditor = new JButton("Create Level");
		btnLevelEditor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String x = width.getText();
				String y = height.getText();
				
				if (x != null && y != null) {
					editorDriver = new EditorDriver(Integer.parseInt(x), Integer.parseInt(y));
					editorDriver.show();
				} else {
					JOptionPane.showMessageDialog(frame, "Unable to open level editor. Please enter a valid integer width and height");
				}
				
				editorDriver.show();
			}
		});
		frame.getContentPane().add(btnLevelEditor, "4, 18");
		
		JSeparator separator_2 = new JSeparator();
		frame.getContentPane().add(separator_2, "2, 20, 3, 1");
		
		JLabel lblPath_1 = new JLabel("Path:");
		frame.getContentPane().add(lblPath_1, "2, 22, right, default");
		
		txtpathtolevelxml = new JTextField();
		txtpathtolevelxml.setText("/path/to/level.xml");
		frame.getContentPane().add(txtpathtolevelxml, "4, 22, fill, default");
		txtpathtolevelxml.setColumns(10);
		
		JButton btnOpenLevel = new JButton("Open Level");
		frame.getContentPane().add(btnOpenLevel, "4, 24");
	}

}
