package json;

import org.json.JSONObject;

public class JsonCreator {
	
	public static void main(String[] args) {
		System.out.println(createJson());
	}
	
	private static String createJson(){
		JSONObject json = new JSONObject();
		json.put("city","xi'an");
		json.put("country", "China");
		return json.toString();
	}
}
