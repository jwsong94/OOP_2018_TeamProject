package MindMap;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class NodeEvent extends MouseAdapter implements MouseListener{
	AttributePane attri;
	Attribute value;
	drawNode draw;
	int x,y,h,w;
	int xPos, yPos, index;
	
	NodeEvent(Attribute item1, drawNode item2){
		value = item1;
		draw = item2;
	}
	
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}
	
	public void mouseClicked(MouseEvent e) {
		JLabel jl = (JLabel) e.getSource();
		
		value.attX.setText(Integer.toString(jl.getX()));
		value.attY.setText(Integer.toString(jl.getY()));
		value.attH.setText(Integer.toString(jl.getHeight()));
		value.attW.setText(Integer.toString(jl.getWidth()));
		value.attName.setText(jl.getText());
	}
	
	public void mouseDragged(MouseEvent e) {
		JLabel node = (JLabel) e.getSource();
		
		int distanceX = e.getX() - x;
		int distanceY = e.getY() - y;
		
		node.setLocation(node.getX() + distanceX, node.getY() + distanceY);
		
		xPos = node.getX() + distanceX;
		yPos = node.getY() + distanceY;
		value.attX.setText(Integer.toString(node.getX()));
		value.attY.setText(Integer.toString(node.getY()));
		value.attH.setText(Integer.toString(node.getHeight()));
		value.attW.setText(Integer.toString(node.getWidth()));
		value.attName.setText(node.getText());
	}
	
	

}
