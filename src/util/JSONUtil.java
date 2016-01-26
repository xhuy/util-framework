package util;

import org.json.JSONObject;

public class JSONUtil {
	public static String toJSON(Object object) {
		JSONObject jsonObject = new JSONObject(object);
		return jsonObject.toString();	
	}
}
