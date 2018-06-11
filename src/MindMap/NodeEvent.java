package MindMap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class NodeEvent extends MouseAdapter implements MouseListener{
	MindMap mm;
	AttributePane attrPane;
	MindMapPane mapPane;
	int x,y,h,w;
	int xPos, yPos, index;
	
	NodeEvent(AttributePane attrPane, MindMapPane mapPane){
		this.attrPane = attrPane;
		this.mapPane = mapPane;
	}
	
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}
	
	public void mouseClicked(MouseEvent e) {
		JLabel node = (JLabel) e.getSource();
		
		MindMapComponant mmc = getMindMapComponant(node.getText());
		attrPane.setMindMapComponant(mmc);
//		value.attX.setText(Integer.toString(jl.getX()));
//		value.attY.setText(Integer.toString(jl.getY()));
//		value.attH.setText(Integer.toString(jl.getHeight()));
//		value.attW.setText(Integer.toString(jl.getWidth()));
//		value.attName.setText(jl.getText());
	}
	
	public void mouseDragged(MouseEvent e) {
		JLabel node = (JLabel) e.getSource();
		
		int distanceX = e.getX() - x;
		int distanceY = e.getY() - y;
		
		node.setLocation(node.getX() + distanceX, node.getY() + distanceY);

		MindMapComponant mmc = getMindMapComponant(node.getText());
		mmc.x = node.getX();
		mmc.y = node.getY();
		attrPane.setMindMapComponant(mmc);
	}
	
	private MindMapComponant getMindMapComponant(String text) {
		MindMapComponant target = null;
		for(MindMapComponant mmc : mm.lists) {
			if(mmc.text.equals(text)) {
				target = mmc;
				break;
			}
		}
		return target;
	}
	
	void setMindMap(MindMap mm) {
		this.mm = mm;
	}
	
	ActionListener getEditEvent() {
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MindMapComponant mmc = getMindMapComponant(attrPane.item.getNameValue());
				mmc.x = attrPane.item.getXValue();
				mmc.y = attrPane.item.getYValue();
				mmc.h = attrPane.item.getHValue();
				mmc.w = attrPane.item.getWValue();
				mmc.color = attrPane.item.getColorValue();
				mapPane.Update(mm);
			}
		});
	}
}
