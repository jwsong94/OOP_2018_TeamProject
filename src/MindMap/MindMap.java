package MindMap;

import java.util.Arrays;
import java.util.Stack;

public class MindMap {
	MindMapComponant[] dataArr;
	MindMap (String str){
		setMindMap(str);
	}
	void setMindMap(String str){
//		System.out.println(str);
		String[] arr = str.split("\n");
		Stack<MindMapComponant> stack = new Stack<MindMapComponant>();
		dataArr = new MindMapComponant[arr.length];
		for(int i=0; i<arr.length; i++) {
			int depth=0;
			int fromIndex = -1;
			MindMapComponant mmc;
		    while ((fromIndex = arr[i].indexOf(" ", fromIndex + 1)) >= 0) {
		    		depth++;
		    }
//			System.out.println(depth + " : " + arr[i].trim());
			if(i == 0) {
				mmc = new MindMapComponant(null, arr[i].trim(), depth);
				stack.push(mmc);
//				System.out.println(stack.peek());
			}
			else {
				while(depth <= stack.peek().depth) { stack.pop(); }
				MindMapComponant parent = stack.peek();
				mmc = new MindMapComponant(parent, arr[i].trim(), depth);
				parent.addChild(mmc);
				stack.push(mmc);
//				System.out.println(stack.peek());
			}
			dataArr[i] = mmc;
		}
//		for(int i=0; i<dataArr.length; i++) {
//			System.out.println(dataArr[i]);
//		}
	}
	@Override
	public String toString() {
		String str = "";
		for(int i=0; i<dataArr.length; i++) {
			for(int j=0; j<dataArr[i].depth; j++) str+=" ";
			str += dataArr[i].text;
			if(i!=dataArr.length-1) str+="\n";
		}
		return str;
	}
}
