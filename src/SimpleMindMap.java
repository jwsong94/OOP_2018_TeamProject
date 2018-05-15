import javax.swing.JFrame;
import javax.swing.JMenuItem;
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
		
		menuBar.add(menu);
		menu.add(menuNew);
		menu.add(menuLoad);
		menu.add(menuSave);
		menu.add(menuSaveAs);
		menu.add(menuExit);
		
		window.setJMenuBar(menuBar);
		window.setSize(400, 400);
		window.setVisible(true);
	}

}
