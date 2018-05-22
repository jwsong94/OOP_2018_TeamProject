package MindMap;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class TopMenuBar extends JMenuBar implements TopBar{
	JMenu menu;
	JMenuItem menuNew;
	JMenuItem menuLoad;
	JMenuItem menuSave;
	JMenuItem menuSaveAs;
	JMenuItem menuExit;
	public TopMenuBar () {
		super();
		init();
	}
	
	private void init() {
		menu = new JMenu("Menu");
		menuNew = new JMenuItem("새로 만들기");
		menuLoad = new JMenuItem("열기");
		menuSave = new JMenuItem("저장");
		menuSaveAs = new JMenuItem("다른 이름으로 저장");
		menuExit = new JMenuItem("닫기");

		this.add(menu);
		menu.add(menuNew);
		menu.add(menuLoad);
		menu.add(menuSave);
		menu.add(menuSaveAs);
		menu.add(menuExit);
	}

	@Override
	public void attachTopEvent(TopEvent te) {
		menuNew.addActionListener(te.getNewEvent());
		menuLoad.addActionListener(te.getLoadEvent());
		menuSave.addActionListener(te.getSaveEvent());
		menuSaveAs.addActionListener(te.getSaveAsEvent());
		menuExit.addActionListener(te.getExitEvent());
	}
}
