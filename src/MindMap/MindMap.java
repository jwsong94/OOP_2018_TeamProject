package MindMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import com.google.gson.Gson;

public class MindMap {
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
				mmc = new MindMapComponant(-1, arr[i].trim(), depth);
				stack.push(mmc);
//				System.out.println(stack.peek());
			}
			else {
				while(depth <= stack.peek().depth) { stack.pop(); }
				MindMapComponant parent = stack.peek();
				mmc = new MindMapComponant(parent.id, arr[i].trim(), depth);
				stack.push(mmc);
//				System.out.println(stack.peek());
			}
			lists.add(mmc);
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
