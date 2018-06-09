package MindMap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class AttributeButton extends JPanel{
	public AttributeButton() {
		setLayout(new BorderLayout());
		JButton btn = new JButton("Update");
		btn.setBackground(Color.RED);
		btn.setFont(new Font("a", Font.BOLD, 15));
		add(btn, BorderLayout.SOUTH);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TextButton();

	}

}
