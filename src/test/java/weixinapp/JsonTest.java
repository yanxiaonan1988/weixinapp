package weixinapp;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class JsonTest {

	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub
		
		
		String resStr = "{\"token\":\"5KiMUck6yR26QZUD_9SCUlJX8aqaKhNb6_FPMLypNl5khmne6loofofpo6ha1RitqqqlRWC2Sa9_aqSvBPv4Srk9mmSwuk2E5H_OV2jnFkw\"}";

		System.out.println("*****");
		System.out.println(resStr);
		
		System.out.println("***************");
		JSONObject resJson = new JSONObject(resStr);
		String token = (String) resJson.get("token");
		System.out.println(token);
	}

}
