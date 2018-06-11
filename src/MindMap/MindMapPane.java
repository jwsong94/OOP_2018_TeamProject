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
	NodeEvent ne;

	public MindMapPane(MindMap mm) {
		nodes = new LinkedList<JLabel>();
		this.mm = mm;
		setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.BLUE, 3);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		
		setVisible(true);
	}
	
	void Update(MindMap mm) {
		this.mm = mm;

		System.out.println("Update MindMapPane");
		
		for(JLabel node : nodes) {
			this.remove(node);
		}
		
		nodes = new LinkedList<JLabel>();
		
		for(MindMapComponant mmc : mm.lists) {
//			System.out.println("add " + mmc);
			node = new JLabel(mmc.text);
			node.setFont(new Font("a", Font.BOLD, 10));
			node.setSize(mmc.w, mmc.h);
			node.setHorizontalAlignment(JLabel.CENTER);
			node.setVerticalAlignment(JLabel.CENTER);
			node.addMouseMotionListener(ne);
			node.addMouseListener(ne);
			node.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
			node.setLocation(mmc.x, mmc.y);
			node.setBackground(new Color(
		            Integer.valueOf( mmc.color.substring( 1, 3 ), 16 ),
		            Integer.valueOf( mmc.color.substring( 3, 5 ), 16 ),
		            Integer.valueOf( mmc.color.substring( 5, 7 ), 16 )));
			nodes.add(node);
			this.add(node);
		}
		
		this.update(getGraphics());
	}
	
	void setNodeEvent(NodeEvent ne) {
		this.ne = ne;
	}
}
