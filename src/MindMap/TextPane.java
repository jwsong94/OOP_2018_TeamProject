package MindMap;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class TextPane extends JPanel{
	JTextArea text = new JTextArea(7,20);
	TopEvent te;
	JButton tbtn;
	
	public TextPane(){
		setLayout(new BorderLayout());
		tbtn = new JButton("적용");
		//pane.setBorder(border);
		text.setBackground(Color.cyan);
		this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		
		add(new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), 
				BorderLayout.CENTER);
		add(tbtn, BorderLayout.SOUTH);
		setVisible(true);
		
	}
//	public static void main(String [] args) {
//		new TextPane();
//	}

	public void Update(String text) {
		this.text.setText(text);
	}
	
	void attachTopEvent(TopEvent te) {
		this.te = te;
		tbtn.addActionListener(te.getSetEvent());
	}
}
