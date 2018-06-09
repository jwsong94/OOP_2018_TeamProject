package MindMap;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class SimpleMindMap extends JFrame{
	TopEvent topEvent;
	TopMenuBar topMenuBar;
	TopToolBar topToolBar;
	Container contentPane;
	JSplitPane subPane;
	JSplitPane mainPane;
	JPanel textEditorPane;
	JPanel mindMapPane;
	JPanel attributePane;
	
	Attribute items = new Attribute();
	
	AttributePane attribute = new AttributePane(items);
	TextPane text = new TextPane();
	MindMapPane center = new MindMapPane(attribute, items);
	
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
		textEditorPane = new JPanel();  
		mindMapPane = new JPanel();  
		attributePane = new JPanel();  

		topMenuBar.attachTopEvent(topEvent);
		topToolBar.attachTopEvent(topEvent);
		
		mainPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		subPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
		

        textEditorPane.setBackground(Color.BLACK);
        mindMapPane.setBackground(Color.GRAY);
        attributePane.setBackground(Color.WHITE);

		contentPane.add(topToolBar, BorderLayout.NORTH);
        contentPane.add(mainPane, BorderLayout.CENTER);  
		
		mainPane.setLeftComponent(text);
		mainPane.setRightComponent(subPane);
		
		mainPane.setContinuousLayout(true);
		subPane.setContinuousLayout(true);
		
		center.setMinimumSize(new Dimension(500, 500));
		
		subPane.setLeftComponent(center);
		subPane.setRightComponent(attribute);
        
		setJMenuBar(topMenuBar);
		setBounds(100, 100, 1000, 500);
		setVisible(true);
	}
}
