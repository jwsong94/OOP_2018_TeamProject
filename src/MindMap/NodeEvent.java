package MindMap;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
		for(int i=0;i<draw.nodes.length; i++) {
			if(draw.nodes[i] == e.getSource()) {
				index = i;
				break;
			}
		}
		
		value.attX.setText(Integer.toString(draw.nodes[index].getX()));
		value.attY.setText(Integer.toString(draw.nodes[index].getY()));
		value.attH.setText(Integer.toString(draw.nodes[index].getHeight()));
		value.attW.setText(Integer.toString(draw.nodes[index].getWidth()));
		value.attName.setText(draw.nodes[index].getText());
	}
	
	public void mouseDragged(MouseEvent e) {
		
		for(int i=0;i<draw.nodes.length; i++) {
			if(draw.nodes[i] == e.getSource()) {
				index = i;
				break;
			}
		}
		int distanceX = e.getX() - x;
		int distanceY = e.getY() - y;
		
		draw.nodes[index].setLocation(draw.nodes[index].getX() + distanceX, 
				draw.nodes[index].getY() + distanceY);
		
		xPos = draw.nodes[index].getX() + distanceX;
		yPos = draw.nodes[index].getY() + distanceY;
		value.attX.setText(Integer.toString(draw.nodes[index].getX()));
		value.attY.setText(Integer.toString(draw.nodes[index].getY()));
		value.attH.setText(Integer.toString(draw.nodes[index].getHeight()));
		value.attW.setText(Integer.toString(draw.nodes[index].getWidth()));
		value.attName.setText(draw.nodes[index].getText());
		
		
	}
	
	

}
