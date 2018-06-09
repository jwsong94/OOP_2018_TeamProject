package MindMap;

public class Model {
	public int x, y, x2, y2, w, h, color;
	public String title;
	
	public Model(int x, int y, int x2, int y2, String title, int color) {
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
		this.w = Math.abs(x-x2);
		this.h = Math.abs(y-y2);
		this.title = title;
		this.color = color;
		
	}

}
