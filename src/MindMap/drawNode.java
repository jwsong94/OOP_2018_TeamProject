package MindMap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class drawNode extends JPanel{
	
	List<JLabel> nodes = new LinkedList<JLabel>();
	String[] nodeNames = {"ex1", "ex2", "ex3"};
	
	public drawNode(AttributePane value1, Attribute value2, MindMapPane value3, MindMap mm) {
		setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
		//예시용 Draw 나중에 지우
		NodeEvent draw = new NodeEvent(value2, this);
		
		for(MindMapComponant mmc : mm.lists) {
			JLabel node = new JLabel(mmc.text);
			node.setSize(mmc.w, mmc.h);
			node.setBorder(border);
			node.setLocation(mmc.x, mmc.y);
			nodes.add(node);
			this.add(node);
		}
	}

}
