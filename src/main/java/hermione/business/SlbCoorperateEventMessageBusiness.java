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

public class SlbCoorperateEventMessageBusiness {
	public PicAndTextMessageResponse process(EventMessageRequest req){
		System.out.println("####SlbCoorperateEventMessageBusiness");
		
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
