import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;

public class SimpleMindMap {

	public static void main(String[] args) {
		JFrame window = new JFrame("SimpleMindMap");
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu Bar");
		JMenuItem menuNew = new JMenuItem("새로 만들기");
		JMenuItem menuLoad = new JMenuItem("열기");
		JMenuItem menuSave = new JMenuItem("저장");
		JMenuItem menuSaveAs = new JMenuItem("다른 이름으로 저장");
		JMenuItem menuExit = new JMenuItem("닫기");
		
		JToolBar toolBar = new JToolBar();
		JButton buttonNew = new JButton("New");
		JButton buttonLoad = new JButton("Load");
		JButton buttonSave = new JButton("Save");
		JButton buttonSaveAs = new JButton("SaveAs");
		JButton buttonExit = new JButton("Exit");
		
		menuBar.add(menu);
		menu.add(menuNew);
		menu.add(menuLoad);
		menu.add(menuSave);
		menu.add(menuSaveAs);
		menu.add(menuExit);

		toolBar.add(buttonNew);
		toolBar.add(buttonLoad);
		toolBar.add(buttonSave);
		toolBar.add(buttonSaveAs);
		toolBar.add(buttonExit);
		
		Container contentPane = window.getContentPane();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
        JPanel paneAttribute = new JPanel();  
        contentPane.add(paneAttribute, BorderLayout.EAST);  
		
		window.setJMenuBar(menuBar);
		window.setSize(400, 400);
		window.setVisible(true);
	}

}
