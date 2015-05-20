package hermione.business;

import hermione.model.message.TextMessageRequest;
import hermione.model.message.TextMessageResponse;

public class SlbTextMessageBusiness {
	
	public TextMessageResponse process(TextMessageRequest req){
		System.out.println("####TextMessageBusiness");
		TextMessageResponse res = new TextMessageResponse();
		res.setToUserName(req.getFromUserName());
		res.setFromUserName(req.getToUserName());
		res.setCreateTime(1348831860);
		res.setContent("hello "+req.getContent()+", this is Sulaibao");
		return res;	
		
	}
}
