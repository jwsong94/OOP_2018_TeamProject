package MindMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import com.google.gson.Gson;

public class MindMap {
	private static int id = 0;	
	private static double theta = 0;
	List<MindMapComponant> lists;
	
	MindMap(){
		lists = new ArrayList<MindMapComponant>();
	}
	MindMap (String str){
		setMindMap(str);
	}
	void setMindMap(String str){
		System.out.println(str);
		String[] arr = str.split("\n");
		Stack<MindMapComponant> stack = new Stack<MindMapComponant>();
		lists = new ArrayList<MindMapComponant>();
		for(int i=0; i<arr.length; i++) {
			if(arr[i].trim().length() == 0) continue;

			int depth=0;
			int fromIndex = -1;
			MindMapComponant mmc;
		    while ((fromIndex = arr[i].indexOf(" ", fromIndex + 1)) >= 0) {
		    		depth++;
		    }
//			System.out.println(depth + " : " + arr[i].trim());
			if(i == 0) {
				mmc = new MindMapComponant(id, arr[i].trim(), -1, 220, 200, 60, 30, depth, "#ffffff");
				stack.push(mmc);
//				System.out.println(stack.peek());
			}
			else {
				while(depth <= stack.peek().depth) { stack.pop(); }
				int d = depth*75;
				int x = (int)(220 + d*Math.sin(theta));
				int y = (int) (200 + d*Math.cos(theta));
				String color = "000000";
				switch(depth) {
				case 1:
					color = "#ff0000";
					break;
				case 2:
					color = "#00ff00";
					break;
				case 3:
					color = "#0000ff";
					break;
				}
				MindMapComponant parent = stack.peek();
				mmc = new MindMapComponant(id, arr[i].trim(), parent.id, x, y, 60, 30, depth, color);
				stack.push(mmc);
//				System.out.println(stack.peek());
				theta += Math.PI/5;
			}
			lists.add(mmc);
			id++;
		}
		for(MindMapComponant mmc : lists) {
			System.out.println(mmc);
		}
	}
	@Override
	public String toString() {
		String str = "";
		if(lists.isEmpty()) return str;
		for(MindMapComponant mmc : lists) {
			for(int j=0; j<mmc.depth; j++) str+=" ";
			str += mmc.text;
			str+="\n";
		}
		return str;
	}
	
	public String toJsonString() {
		if(lists.isEmpty()) return "";
		Gson gson = new Gson();
		String json = gson.toJson(this);
		System.out.println(json);
		
		return json;
	}
	
	public void fromJsonString(String json) {
		Gson gson = new Gson();
		MindMap temp = gson.fromJson(json, MindMap.class);

		lists = new ArrayList<MindMapComponant>();
		for(MindMapComponant mmc : temp.getLists()) {
			lists.add(mmc);
		}
		System.out.println(this.toString());
	}
	
	public List<MindMapComponant> getLists() {
		return lists;
	}

	public MindMapComponant getParents(MindMapComponant mmc) {
		MindMapComponant target = null;
		for(MindMapComponant current : lists) {
			if(mmc.parent == current.id) {
				target = current;
				break;
			}
		}
		return target;
	}
}
