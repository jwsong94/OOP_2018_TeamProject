package MindMap;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Attribute extends JPanel{
	
	JTextField attName, attX, attY, attH, attW, attColor;
	
	void Text() {
	       JLabel text = new JLabel("Text : ");
	       text.setFont(new Font("a", Font.PLAIN, 20));
	       
	       attName = new JTextField();
	       attName.setForeground(Color.red);
	       attName.setFont(new Font("b", Font.BOLD, 20));
	       attName.setEnabled(false);
	       add(text);
	       add(attName);
	       setVisible(true);
	    }

	 void X() {
	       JLabel xPos = new JLabel("X : ");
	       xPos.setFont(new Font("a", Font.PLAIN, 20));
	       attX = new JTextField(5);
	       add(xPos);
	       add(attX);
	       setVisible(true);
	    }

	 void Y() {
	       JLabel yPos = new JLabel("Y : ");
	       yPos.setFont(new Font("a", Font.PLAIN, 20));
	       attY = new JTextField(5);
	       add(yPos);
	       add(attY);
	       setVisible(true);
	    }

	 void H() {
	       JLabel hPos = new JLabel("H : ");
	       hPos.setFont(new Font("a", Font.PLAIN, 20));
	       attH = new JTextField(5);
	       add(hPos);
	       add(attH);
	       setVisible(true);
	    }

	 void W() {
	       JLabel wPos = new JLabel("W : ");
	       wPos.setFont(new Font("a", Font.PLAIN, 20));
	       attW = new JTextField(5);
	       add(wPos);
	       add(attW);
	       setVisible(true);
	    }

	 void Colors() {
	       JLabel colors = new JLabel("Color : ");
	       colors.setFont(new Font("a", Font.PLAIN, 20));
	       attColor = new JTextField(5);
	       add(colors);
	       add(attColor);
	       setVisible(true);
	    }
	 
	 public Attribute() {
		 setLayout(new GridLayout(6,1,0,15));
		 Text();
		 X();
		 Y();
		 H();
		 W();
		 Colors();
		 Color colorbg = new Color(212,244,255);
		 this.setBackground(colorbg);
		 setVisible(true);
	 }

	 public void setName(String name) {
		 attName.setText(name);
	 }

	 public void setX(int x) {
		 attX.setText(x+"");
	 }
	 
	 public void setY(int y) {
		 attY.setText(y+"");
	 }
	 
	 public void setH(int h) {
		 attH.setText(h+"");
	 }

	 public void setW(int w) {
		 attW.setText(w+"");
	 }
	 
	 public void setColor(String color) {
		 attColor.setText(color);
		 attColor.setBackground(new Color(
		            Integer.valueOf( color.substring( 1, 3 ), 16 ),
		            Integer.valueOf( color.substring( 3, 5 ), 16 ),
		            Integer.valueOf( color.substring( 5, 7 ), 16 )));
	 }

	 public String getName(String name) {
		 return attName.getText();
	 }

	 public int getX(String x) {
		 return Integer.parseInt(attX.getText());
	 }
	 
	 public int getY(String y) {
		 return Integer.parseInt(attY.getText());
	 }
	 
	 public int getH(String h) {
		 return Integer.parseInt(attH.getText());
	 }

	 public int getW(String w) {
		 return Integer.parseInt(attW.getText());
	 }
	 
	 public String sgtColor(String color) {
		 return attColor.getText();
	 }
}
