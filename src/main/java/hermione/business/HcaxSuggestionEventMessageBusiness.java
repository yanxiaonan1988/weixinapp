package hermione.business;

import hermione.model.message.EventMessageRequest;
import hermione.model.message.TextMessageResponse;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class HcaxSuggestionEventMessageBusiness {
	public TextMessageResponse process(EventMessageRequest req){
		System.out.println("####HcaxSuggestionEventMessageBusiness");
		
		TextMessageResponse res = new TextMessageResponse();
		res.setToUserName(req.getFromUserName());
		res.setFromUserName(req.getToUserName());
		System.out.println("openid:"+res.getToUserName());
		res.setCreateTime(new Date().getTime());
		res.setContent("请留下您对我们公司对我们服务号宝贵得意见，我们会统一进行整改去答复，谢谢。");
		
		return res;	
		
	}
}
