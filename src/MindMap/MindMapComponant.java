package MindMap;

import java.util.Stack;

public class MindMapComponant {
	int id;
	int parent;
	String text;
	int x, y, w, h, depth;
	String color;
	public MindMapComponant(int id, String text, int parent, int x, int y, int w, int h, int depth, String color) {
		this.id = id;
		this.text = text;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.depth = depth;
		this.color = color;
	}
	public MindMapComponant(int id, String text, int parent, int depth) {
		this(id, text, parent, 150, 150, 60, 30, depth, "000000");
	}
	@Override
	public String toString() {
		return text + "(" + x + ","  + y + "," + w + "," + h + ")";
	}
}