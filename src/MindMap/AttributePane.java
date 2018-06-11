package MindMap;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class AttributePane extends JPanel{
	MindMap mm;
	MindMapComponant mmc;
	Attribute item;
	JButton abtn;
	NodeEvent ne;
	
	public AttributePane(){
		setLayout(new BorderLayout(0, 10));
		item = new Attribute();
		Color colorbg = new Color(212,244,255);
		Border border = BorderFactory.createLineBorder(Color.BLUE, 3);
		abtn = new JButton("Edit");
		
		//pane.setBorder(border);
		this.setBackground(colorbg);
		this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		
		add(item, BorderLayout.CENTER);
		add(abtn, BorderLayout.SOUTH);
		setVisible(true);
	}

	public void Update() {
		item.setName(mmc.text);
		item.setX(mmc.x);
		item.setY(mmc.y);
		item.setH(mmc.h);
		item.setW(mmc.w);
		item.setW(mmc.w);
		item.setColor(mmc.color);
	}
	
	public void setMindMapComponant(MindMapComponant mmc) {
		this.mmc = mmc;
		Update();
	}
	
	void setNodeEvent(NodeEvent ne) {
		this.ne = ne;
		abtn.addActionListener(ne.getEditEvent());
	}
}