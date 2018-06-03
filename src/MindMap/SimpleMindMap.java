package MindMap;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class SimpleMindMap extends JFrame{
	TopEvent topEvent;
	TopMenuBar topMenuBar;
	TopToolBar topToolBar;
	Container contentPane;
	JSplitPane mainPane;
	JPanel textEditorPane;
	JPanel mindMapPane;
	JPanel attributePane;
	public SimpleMindMap() {
		super("SimpleMindMap");
		init();
	}

	public static void main(String[] args) {
		SimpleMindMap simpleMindMap = new SimpleMindMap();
		MindMap mm = new MindMap("계절\n 봄\n  황사\n 여름\n  장마\n  태풍\n 가을\n  단풍\n 겨울\n  폭설");
		System.out.println(mm);
	}

	private void init() {
		topEvent = new TopEvent();
		topMenuBar = new TopMenuBar();
		topToolBar = new TopToolBar();
		contentPane = getContentPane();
		mainPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		textEditorPane = new JPanel();  
		mindMapPane = new JPanel();  
		attributePane = new JPanel();  

		topMenuBar.attachTopEvent(topEvent);
		topToolBar.attachTopEvent(topEvent);

        textEditorPane.setBackground(Color.BLACK);
        mindMapPane.setBackground(Color.GRAY);
        attributePane.setBackground(Color.WHITE);

		contentPane.add(topToolBar, BorderLayout.NORTH);
        contentPane.add(mainPane, BorderLayout.CENTER);  
        
        mainPane.setContinuousLayout(true);
		mainPane.setRightComponent(attributePane);
		mainPane.setLeftComponent(textEditorPane);
		mainPane.setDividerLocation((int)this.getSize().getWidth()/2);

		setJMenuBar(topMenuBar);
		setSize(400, 400);
		setVisible(true);
	}
}
