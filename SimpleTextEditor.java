import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SimpleTextEditor extends JFrame implements ActionListener{

	private static final String OPEN = "Open";
	private JTextArea textEditor;
	private JPanel commandPanel;

	public SimpleTextEditor(){
		super("Text Editor");
		this.setSize(500, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		textEditor = new JTextArea(30, 30);
		textEditor.setLineWrap(true);
		
		this.add(textEditor, BorderLayout.CENTER);
		
		commandPanel = new JPanel();
		JButton saveButton = new JButton("Save");
		JButton openButton = new JButton(OPEN);
		
		saveButton.addActionListener(this);
		openButton.addActionListener(this);
		
		commandPanel.add(saveButton);
		commandPanel.add(openButton);
		
		this.add(commandPanel, BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String buttonText = event.getActionCommand();
		JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
		if (buttonText.equals(OPEN)){
			fileChooser.showOpenDialog(commandPanel);
		}
		
	}
	
	public static void main(String[] args) {
		SimpleTextEditor simpleTextEditor = new SimpleTextEditor();
		simpleTextEditor.setVisible(true);
	}

}
