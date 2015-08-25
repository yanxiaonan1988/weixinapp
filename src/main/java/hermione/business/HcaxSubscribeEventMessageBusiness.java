package hermione.business;

import hermione.model.message.EventMessageRequest;
import hermione.model.message.TextMessageResponse;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class HcaxSubscribeEventMessageBusiness {
	public TextMessageResponse process(EventMessageRequest req){
		System.out.println("####HcaxSubscribeEventMessageBusiness");
		
		String openid = req.getFromUserName();
		String sceneid = null;
		if(req.getEvent().equals("subscribe")){
			if(req.getEventKey()!=null && !req.getEventKey().equals("")){
				sceneid = req.getEventKey().substring(8, req.getEventKey().length());
				System.out.println("newscan:"+sceneid);
			}
		}
		if(req.getEvent().equals("SCAN")){
			if(req.getEventKey()!=null && !req.getEventKey().equals("")){
				sceneid = req.getEventKey();
				System.out.println("oldscan:"+sceneid);
			}
		}
		
		URL url;
		try {
			url = new URL("http://wx.99bx.cn/api/hcax/wxReferee?openId="+openid+"&sceneId="+sceneid);
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			in.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TextMessageResponse res = new TextMessageResponse();
		res.setToUserName(req.getFromUserName());
		res.setFromUserName(req.getToUserName());
		System.out.println("openid:"+res.getToUserName());
		res.setCreateTime(new Date().getTime());
		res.setContent("您好，感谢您关注我们的和诚安心保险销售有限公司官方微信平台！\r\n" +
				"全国客服热线：0571-86578905\r\n" +
				"从这一刻起，我们将一直陪伴和关注您的保险情况。");
		
		return res;	
		
	}
}
