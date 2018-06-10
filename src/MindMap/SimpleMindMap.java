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
	MindMap mm;
	
	Attribute items;
	AttributePane attribute;
	TextPane text;
	MindMapPane center;
	
	public SimpleMindMap() {
		super("SimpleMindMap");
		init();
	}

	public static void main(String[] args) {
		SimpleMindMap simpleMindMap = new SimpleMindMap();
	}

	private void init() {
		topEvent = new TopEvent();
		topMenuBar = new TopMenuBar();
		topToolBar = new TopToolBar();
		contentPane = getContentPane();
		mm = new MindMap();
		items = new Attribute();
		attribute = new AttributePane(items);
		text = new TextPane();
		center = new MindMapPane(attribute, items, mm);

		topEvent.setTargetMindMap(mm);
		topEvent.setTargetTaxtPane(text);
		topEvent.setTargetMindMapPane(center);
		
		topMenuBar.attachTopEvent(topEvent);
		topToolBar.attachTopEvent(topEvent);
		
		mainPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		subPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

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
