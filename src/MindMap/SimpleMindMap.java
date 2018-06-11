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
	
	AttributePane attrPane;
	TextPane textPane;
	MindMapPane mapPane;
	NodeEvent nodeEvent;
	
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
		attrPane = new AttributePane();
		textPane = new TextPane();
		mapPane = new MindMapPane(mm);
		nodeEvent = new NodeEvent(attrPane);
		
		nodeEvent.setMindMap(mm);
		mapPane.setNodeEvent(nodeEvent);
		topEvent.setTargetMindMap(mm);
		topEvent.setTargetTaxtPane(textPane);
		topEvent.setTargetMindMapPane(mapPane);
		
		topMenuBar.attachTopEvent(topEvent);
		topToolBar.attachTopEvent(topEvent);
		textPane.attachTopEvent(topEvent);
		
		mainPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		subPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

		contentPane.add(topToolBar, BorderLayout.NORTH);
        contentPane.add(mainPane, BorderLayout.CENTER);  
		
		mainPane.setLeftComponent(textPane);
		mainPane.setRightComponent(subPane);
		
		mainPane.setContinuousLayout(true);
		subPane.setContinuousLayout(true);
		
		mapPane.setMinimumSize(new Dimension(500, 500));
		
		subPane.setLeftComponent(mapPane);
		subPane.setRightComponent(attrPane);
        
		setJMenuBar(topMenuBar);
		setBounds(100, 100, 1000, 500);
		setVisible(true);
	}
}
