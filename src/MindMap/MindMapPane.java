package MindMap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MindMapPane extends JPanel{
	MindMap mm;
	List<JLabel> nodes;
	JLabel node;

	JLabel[] test = new JLabel[3];
	String[] nodeNames = {"ex1", "ex2", "ex3"};
	
	public MindMapPane(AttributePane value1, Attribute value2, MindMap mm) {
		nodes = new LinkedList<JLabel>();
		this.mm = mm;
		setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.BLUE, 3);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

		System.out.println("Initialize MindMapPane");

		for(MindMapComponant mmc : mm.lists) {
			node.setSize(mmc.w, mmc.h);
			node.setBorder(border);
			node.setLocation(mmc.x, mmc.y);
			nodes.add(node);
			this.add(node);
		}
		
		setVisible(true);
	}
	
	void Update(MindMap mm) {
		this.mm = mm;

		System.out.println("Update MindMapPane");
		
		for(MindMapComponant mmc : mm.lists) {
//			System.out.println("add " + mmc);
			node = new JLabel(mmc.text);
			node.setFont(new Font("a", Font.BOLD, 10));
			node.setSize(mmc.w, mmc.h);
			node.setHorizontalAlignment(JLabel.CENTER);
			node.setVerticalAlignment(JLabel.CENTER);
			node.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
			node.setLocation(mmc.x, mmc.y);
			nodes.add(node);
			this.add(node);
		}
		
		this.update(getGraphics());
	}
}
