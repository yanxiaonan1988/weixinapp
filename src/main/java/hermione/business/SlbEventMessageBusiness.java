package hermione.business;

import hermione.model.message.EventMessageRequest;
import hermione.model.message.TextMessageResponse;

public class SlbEventMessageBusiness {
	public TextMessageResponse process(EventMessageRequest req){
		System.out.println("####EventMessageBusiness");
		TextMessageResponse res = new TextMessageResponse();
		res.setToUserName(req.getFromUserName());
		res.setFromUserName(req.getToUserName());
		res.setCreateTime(1348831860);
		System.out.println("openid:"+res.getToUserName());
		res.setContent("点此进入："+"<a href='http://121.40.121.237:8082/checkBound?openId="+res.getToUserName()+"'>展业平台</a>");
		return res;	
		
	}
}
