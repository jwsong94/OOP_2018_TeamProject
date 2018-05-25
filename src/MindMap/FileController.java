package MindMap;

import com.google.gson.Gson;

public class FileController {
	public FileController() {
	}

	String objectToJson() {
		Gson gs = new Gson();
		TempClass tc = new TempClass(10, 3.2, "hello");
		
		return gs.toJson(tc);
	}
	
	String jsonToObject(String json) {
		Gson gs = new Gson();
		System.out.println("input : " + json);
		Object obj = gs.fromJson(json, TempClass.class);
		
		return obj.toString();
	}
	
	class TempClass {
		int value1;
		double value2;
		String value3;
		
		TempClass(int a, double b, String c){
			value1 = a;
			value2 = b;
			value3 = c;
		}

		@Override
		public String toString() {
			return "TempClass [value1=" + value1 + ", value2=" + value2 + ", value3=" + value3 + "]";
		}
	}
}
