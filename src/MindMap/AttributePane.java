package MindMap;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class AttributePane extends JPanel{
	
	public AttributePane(Attribute item){
		setLayout(new BorderLayout(0, 10));
		Color colorbg = new Color(212,244,255);
		Border border = BorderFactory.createLineBorder(Color.BLUE, 3);
		AttributeButton abtn = new AttributeButton();
		//pane.setBorder(border);
		this.setBackground(colorbg);
		this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		
		add(item, BorderLayout.CENTER);
		add(abtn, BorderLayout.SOUTH);
		setVisible(true);
		
	}

}