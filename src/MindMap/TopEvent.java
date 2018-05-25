package MindMap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopEvent {
	ActionListener getNewEvent() {
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Click New");
			}
		});
	}
	ActionListener getLoadEvent() {
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FileController fc = new FileController();
				String temp = fc.objectToJson();
				System.out.println(fc.jsonToObject(temp));
				System.out.println("Click Load");
			}
		});
	}
	ActionListener getSaveEvent() {
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FileController fc = new FileController();
				System.out.println(fc.objectToJson());
				System.out.println("Click Save");
			}
		});
	}
	ActionListener getSaveAsEvent() {
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Click SaveAs");
			}
		});
	}
	ActionListener getExitEvent() {
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Click Exit");
			}
		});
	}
}
