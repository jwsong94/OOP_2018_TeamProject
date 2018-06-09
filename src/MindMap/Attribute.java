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
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Attribute();

	}

}
