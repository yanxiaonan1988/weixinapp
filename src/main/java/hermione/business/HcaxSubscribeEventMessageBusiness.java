package hermione.business;

import hermione.model.message.EventMessageRequest;
import hermione.model.message.Item;
import hermione.model.message.TextMessageResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HcaxSubscribeEventMessageBusiness {
	public TextMessageResponse process(EventMessageRequest req){
		System.out.println("####HcaxSubscribeEventMessageBusiness");
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
