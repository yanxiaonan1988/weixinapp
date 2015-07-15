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
		res.setContent("���ã���л����ע���ǵĺͳϰ��ı����������޹�˾�ٷ�΢��ƽ̨��ȫ���ͷ����ߣ�4009267777����һ�������ǽ�һֱ���͹�ע���ı���������˽����ͳϰ��ı����������޹�˾��ظ�1���ͳϰ��ı��ղ�Ʒ�Ƽ���ظ�2���ͳϰ��ı����˹�������ظ�3���ͳ���������С��ʿ��ظ�4�� ����һ����ظ�5.");
		
		return res;	
		
	}
}
