package hermione.business;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hermione.model.message.EventMessageRequest;
import hermione.model.message.Item;
import hermione.model.message.PicAndTextMessageResponse;
import hermione.model.message.TextMessageResponse;

public class SlbSubscribeEventMessageBusiness {
	public PicAndTextMessageResponse process(EventMessageRequest req){
		System.out.println("####SlbSubscribeEventMessageBusiness");
		
		String openid = req.getFromUserName();
		String sceneid = null;
		if(req.getEvent().equals("subscribe")){
			if(req.getEventKey()!=null){
				sceneid = req.getEventKey().substring(8, req.getEventKey().length());
				System.out.println("newscan:"+sceneid);
			}
		}
		if(req.getEvent().equals("SCAN")){
			if(req.getEventKey()!=null){
				sceneid = req.getEventKey();
				System.out.println("oldscan:"+sceneid);
			}
		}
		
		URL url;
		try {
			url = new URL("http://wx.99bx.cn/api/sulaibao/wxReferee?openId="+openid+"&sceneId="+sceneid);
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
		
		
		PicAndTextMessageResponse res = new PicAndTextMessageResponse();
		res.setToUserName(req.getFromUserName());
		res.setFromUserName(req.getToUserName());
		res.setCreateTime(new Date().getTime());
		System.out.println("openid:"+res.getToUserName());
		res.setArticleCount(1);
		Item item = new Item();
		item.setTitle("欢迎关注速来保");
		item.setDescription("平台创造机遇 服务成就卓越");
		item.setPicUrl("http://static.99bx.cn/html/ywhz/images/banner.png");
		item.setUrl("http://static.99bx.cn//html/ywhz/ywhz.html");
		List<Item> list = new ArrayList<Item>();
		list.add(item);
		res.setArticles(list);
		return res;	
		
	}
}
