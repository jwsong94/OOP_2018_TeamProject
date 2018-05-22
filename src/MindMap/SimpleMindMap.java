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
		/*
		JFrame window = new JFrame("SimpleMindMap");
		TopEvent topEvent = new TopEvent();
		TopMenuBar topMenuBar = new TopMenuBar();
		TopToolBar topToolBar = new TopToolBar();
		
		topMenuBar.attachTopEvent(topEvent);
		topToolBar.attachTopEvent(topEvent);

		Container contentPane = window.getContentPane();
		
		JSplitPane mainPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
        JPanel textEditorPane = new JPanel();  
        textEditorPane.setBackground(Color.BLACK);

        JPanel mindMapPane = new JPanel();  
        mindMapPane.setBackground(Color.GRAY);
        
        JPanel attributePane = new JPanel();  
        attributePane.setBackground(Color.WHITE);

		contentPane.add(topToolBar, BorderLayout.NORTH);
        contentPane.add(mainPane, BorderLayout.CENTER);  
        
		window.setJMenuBar(topMenuBar);
		window.setSize(400, 400);
		window.setVisible(true);

        mainPane.setContinuousLayout(true);
		mainPane.setRightComponent(attributePane);
		mainPane.setLeftComponent(textEditorPane);
		mainPane.setDividerLocation((int)window.getSize().getWidth()/2);
		*/
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
