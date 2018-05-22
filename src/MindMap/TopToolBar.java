package MindMap;
import javax.swing.JButton;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class TopToolBar extends JToolBar implements TopBar{
	JButton buttonNew;
	JButton buttonLoad;
	JButton buttonSave;
	JButton buttonSaveAs;
	JButton buttonExit;
	
	public TopToolBar () {
		super();
		init();
	}

	private void init() {
		buttonNew = new JButton("New");
		buttonLoad = new JButton("Load");
		buttonSave = new JButton("Save");
		buttonSaveAs = new JButton("SaveAs");
		buttonExit = new JButton("Exit");

		this.add(buttonNew);
		this.add(buttonLoad);
		this.add(buttonSave);
		this.add(buttonSaveAs);
		this.add(buttonExit);
	}

	@Override
	public void attachTopEvent(TopEvent te) {
		buttonNew.addActionListener(te.getNewEvent());
		buttonLoad.addActionListener(te.getLoadEvent());
		buttonSave.addActionListener(te.getSaveEvent());
		buttonSaveAs.addActionListener(te.getSaveAsEvent());
		buttonExit.addActionListener(te.getExitEvent());
	}
}
