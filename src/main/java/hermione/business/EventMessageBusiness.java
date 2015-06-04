package hermione.business;

import hermione.model.message.EventMessageRequest;
import hermione.model.message.TextMessageResponse;

public class EventMessageBusiness {
	public TextMessageResponse process(EventMessageRequest req){
		System.out.println("####EventMessageBusiness");
		TextMessageResponse res = new TextMessageResponse();
		res.setToUserName(req.getFromUserName());
		res.setFromUserName(req.getToUserName());
		res.setCreateTime(1348831860);
		System.out.println("openid:"+res.getToUserName());
		res.setContent("��˽��룺"+"<a href='http://e.99bx.cn/checkBound?openId="+res.getToUserName()+"'>չҵƽ̨</a>");
		return res;	
		
	}
}