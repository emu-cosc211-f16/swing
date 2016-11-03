import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Menus extends JFrame implements ActionListener {

	private static final String EXIT = "Exit";
	private static final String WHITE = "White";
	private static final String YELLOW = "Yellow";
	private static final String ORANGE = "Orange";
	private JPanel orangePanel;
	private JPanel yellowPanel;
	private JPanel whitePanel;

	public Menus() {
		super("Menus demo");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1, 3));

		orangePanel = new JPanel();
		yellowPanel = new JPanel();
		whitePanel = new JPanel();

		orangePanel.setBackground(Color.LIGHT_GRAY);
		yellowPanel.setBackground(Color.LIGHT_GRAY);
		whitePanel.setBackground(Color.LIGHT_GRAY);

		this.add(orangePanel);
		this.add(yellowPanel);
		this.add(whitePanel);

		JMenu outerMenu = new JMenu("Actions");
		JMenu colorMenu = new JMenu("Add colors");
		JMenu newMenu = new JMenu("Bogeuns Menu");

		JMenuItem orangeMenuItem = new JMenuItem(ORANGE);
		JMenuItem yellowMenuItem = new JMenuItem(YELLOW);
		JMenuItem whiteMenuItem = new JMenuItem(WHITE);

		orangeMenuItem.addActionListener(this);
		yellowMenuItem.addActionListener(this);
		whiteMenuItem.addActionListener(this);

		colorMenu.add(orangeMenuItem);
		colorMenu.add(yellowMenuItem);
		colorMenu.add(whiteMenuItem);

		outerMenu.add(colorMenu);

		JMenuItem exitItem = new JMenuItem(EXIT);
		outerMenu.add(exitItem);
		exitItem.addActionListener(this);

		JMenuBar menuBar = new JMenuBar();
		menuBar.add(outerMenu);
		menuBar.add(newMenu);

		this.setJMenuBar(menuBar);
	}

	public static void main(String[] args) {
		Menus menus = new Menus();
		menus.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String itemText = e.getActionCommand();
		if (itemText.equals(ORANGE)) {
			orangePanel.setBackground(Color.ORANGE);
		} else if (itemText.equals(YELLOW)) {
			yellowPanel.setBackground(Color.YELLOW);
		} else if (itemText.equals(WHITE)) {
			whitePanel.setBackground(Color.WHITE);
		} else if (itemText.equals(EXIT)) {
			System.exit(0);
		} else {
			System.out.println("Unexpected error");
		}
	}

}