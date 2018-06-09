package MindMap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class drawNode extends JPanel{
	
	JLabel[] nodes = new JLabel[3];
	String[] nodeNames = {"ex1", "ex2", "ex3"};
	
	public drawNode(AttributePane value1, Attribute value2, MindMapPane value3) {
		setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
		
		//예시용 Draw 나중에 지우
		NodeEvent draw = new NodeEvent(value2, this);
		
		for(int i=0;i<3;i++) {
			nodes[i] = new JLabel(nodeNames[i]);
			nodes[i].addMouseMotionListener((MouseMotionListener) draw);
			nodes[i].addMouseListener((MouseListener) draw);
			nodes[i].setFont(new Font("a", Font.BOLD, 10));
			nodes[i].setSize(60, 30);
			nodes[i].setBorder(border);
			nodes[i].setLocation(100 + (i*50), 100 + (i*50));
			add(nodes[i]);
		}
		
		
	}

}
