package MindMap;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MindMapPane extends JPanel{
	
	public MindMapPane(AttributePane value1, Attribute value2) {
		setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.BLUE, 3);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		
		drawNode draw = new drawNode(value1, value2, this);
		
		add(draw);
		
		
		setVisible(true);
	}

}
