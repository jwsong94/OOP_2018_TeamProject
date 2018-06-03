package MindMap;

import java.util.Stack;

public class MindMapComponant {
	MindMapComponant parent;
	Stack<MindMapComponant> child;
	String text;
	int x, y, w, h, depth;
	String color;
	public MindMapComponant(MindMapComponant parent, String text, int x, int y, int w, int h, int depth, String color) {
		this.parent = parent;
		this.text = text;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.depth = depth;
		this.color = color;
		child = new Stack<MindMapComponant>();
	}
	public MindMapComponant(MindMapComponant acient, String text, int depth) {
		this(acient, text, 0, 0, 0, 0, depth, "000000");
	}
	@Override
	public String toString() {
		return "(parent=" + parent + ", text=" + text + ")";
	}
	void addChild(MindMapComponant child) {
		this.child.push(child);
	}
}