package MindMap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class TopEvent {
	String filePath = "";
	TextPane tp;
	MindMap mm;
	MindMapPane mp;
	
	void setTargetTaxtPane(TextPane tp) {
		this.tp = tp;
	}

	void setTargetMindMap(MindMap mm) {
		this.mm = mm;
	}
	
	void setTargetMindMapPane(MindMapPane mp) {
		this.mp = mp;
	}
	
	ActionListener getNewEvent() {
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				mm.setMindMap("");
				tp.Update(mm.toString());
				filePath = "";
				*/
				mm.setMindMap("계절\n 봄\n  황사\n 여름\n  장마\n  태풍\n 가을\n  단풍\n 겨울\n  폭설");
				tp.Update(mm.toString());
				mp.Update(mm);
//				String temp = mm.toJsonString();
//				System.out.println(temp);
//				mm.fromJsonString(temp);
			}
		});
	}
	ActionListener getLoadEvent() {
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Load");   
				
				int userSelection = fileChooser.showOpenDialog(fileChooser);
				 
				if (userSelection == JFileChooser.APPROVE_OPTION) {
				    File fileToLoad = fileChooser.getSelectedFile();
				    filePath = fileToLoad.getAbsolutePath();
				}

				try {
		            File file = new File(filePath) ;
		            
		            FileReader fr = new FileReader(file);
		            BufferedReader br = new BufferedReader(fr);
		            String json = "";
		            
				    String line;
						line = br.readLine();
	
				    while (line != null) {
				    		json += line;
				        line = br.readLine();
				    }
				    
				    System.out.println(json);
				    
				    mm.fromJsonString(json);
					tp.Update(mm.toString());
					mp.Update(mm);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	ActionListener getSaveEvent() {
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(filePath.length() == 0) {
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setDialogTitle("Save");   
					
					int userSelection = fileChooser.showSaveDialog(fileChooser);
					 
					if (userSelection == JFileChooser.APPROVE_OPTION) {
					    File fileToSave = fileChooser.getSelectedFile();
					    filePath = fileToSave.getAbsolutePath();
					}
				}

	            try {
		            File file = new File(filePath) ;
		            
		            FileWriter fw = new FileWriter(file, false) ;
		             
		            fw.write(mm.toJsonString());
		            fw.flush();
		 
		            fw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	            
			}
		});
	}
	ActionListener getSaveAsEvent() {
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Save As");   
				
				int userSelection = fileChooser.showSaveDialog(fileChooser);
				 
				if (userSelection == JFileChooser.APPROVE_OPTION) {
				    File fileToSaveAs = fileChooser.getSelectedFile();
				    filePath = fileToSaveAs.getAbsolutePath();
				}
				
	            try {
		            File file = new File(filePath) ;
		            
		            FileWriter fw = new FileWriter(file, false) ;
		             
		            fw.write(mm.toJsonString());
		            fw.flush();
		 
		            fw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	ActionListener getExitEvent() {
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	ActionListener getSetEvent() {
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(tp.text.getText());
				mm.setMindMap(tp.text.getText());
				tp.Update(mm.toString());
				mp.Update(mm);
			}
		});
	}
}
