package hermione.transformer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

public class SlbSnsapiBaseTransformer extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		// TODO Auto-generated method stub
		String code = message.getInboundProperty("code");
		String state = message.getInboundProperty("state");
		System.out.println("code:"+code);
		System.out.println("state:"+state);
		
		String tokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=&secret=&code="+code+"&grant_type=authorization_code";
		
		URL url = null;
		try {
			url = new URL(tokenUrl);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        URLConnection conn = null;
        BufferedReader in = null;
        String resStr = "";
		try {
			conn = url.openConnection();
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) 
	            resStr += inputLine;
	        in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(resStr);
		JSONObject resJson = null;
		String openid = null;
		try {
			resJson = new JSONObject(resStr);
			System.out.println("*****");
			System.out.println(resStr);
			System.out.println("***************");
			openid = (String) resJson.get("openid");
			System.out.println("openid:"+openid);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(openid != null){
			message.setOutboundProperty("zyUrl", "http://121.40.121.237:8082/checkBound?openId="+openid);
		}
		
		return message;
	}

}
