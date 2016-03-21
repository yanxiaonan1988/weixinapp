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
		res.setContent("您好，欢迎关注【和诚安心保销】，您可以回复以下数字来了解我们。\r\n"+
				"1、 公司介绍\r\n"+
				"2、 360°保险管家\r\n"+
				"3、 在线投保说明\r\n"+
				"4、 咨询人工服务\r\n"+
				"5、 百万保家\r\n"+
				"6、 千万保企\r\n"+
				"如有需要投保去保险方面的咨询可回复4进入人工服务。\r\n"+
				"我们为您提供独具匠心的“360度管家式“保险专业服务。\r\n");
		
		return res;	
		
	}
}
