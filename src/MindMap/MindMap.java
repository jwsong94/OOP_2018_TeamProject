package MindMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import com.google.gson.Gson;

public class MindMap {
	int id = 0;	
	double theta = 0;
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
			if(arr[i].trim().length() == 1) continue;
			
			int depth=0;
			int fromIndex = -1;
			MindMapComponant mmc;
		    while ((fromIndex = arr[i].indexOf(" ", fromIndex + 1)) >= 0) {
		    		depth++;
		    }
//			System.out.println(depth + " : " + arr[i].trim());
			if(i == 0) {
				mmc = new MindMapComponant(id, arr[i].trim(), -1, 220, 200, 60, 30, depth, "#0000000");
				stack.push(mmc);
//				System.out.println(stack.peek());
			}
			else {
				while(depth <= stack.peek().depth) { stack.pop(); }
				int d = depth*75;
				int x = (int)(220 + d*Math.sin(theta));
				int y = (int) (200 + d*Math.cos(theta));
				MindMapComponant parent = stack.peek();
				mmc = new MindMapComponant(id, arr[i].trim(), parent.id, x, y, 60, 30, depth, "#0000000");
				stack.push(mmc);
//				System.out.println(stack.peek());
				theta += 30;
			}
			lists.add(mmc);
			id++;
		}
//		for(int i=0; i<dataArr.length; i++) {
//			System.out.println(dataArr[i]);
//		}
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
}
