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
		item.setTitle("中国互联网保险第一品牌");
		item.setDescription("点击购买");
		item.setPicUrl("http://static.99bx.cn/static/images/vechile-ad_24.jpg");
		item.setUrl("http://cms.99bx.cn/html/page/sulaibao/autoInsurance/545c4c8debeffb702f989eecd49900c00aa32c8f/a43db6d2163f5c5378b7b171e7d6369be0045feb.html?from=singlemessage&isappinstalled=0");
		List<Item> list = new ArrayList<Item>();
		list.add(item);
		res.setArticles(list);
		return res;	
		
	}
}
