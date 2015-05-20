package hermione.filter;

import hermione.util.CommonUtil;

import java.util.Arrays;

import org.mule.api.MuleMessage;
import org.mule.api.routing.filter.Filter;

public class WeixinSignatureFilter implements Filter {
	String token = "HUIBAO_WEIXIN_DEFAULT_TOKONS";
	@Override
	public boolean accept(MuleMessage message) {
		String signature = message.getInboundProperty("signature");
		String timestamp = message.getInboundProperty("timestamp");
		String nonce = message.getInboundProperty("nonce");
//		String echostr = message.getInboundProperty("echostr");
		System.out.println(message.getInboundProperty("http.query.string"));
		if(signature == null || timestamp == null || nonce == null){
			return false;
		}
		String[] ss = new String[]{timestamp,nonce,token};
		Arrays.sort(ss);
		for(String s:ss){
			System.out.println(s);
		}
		String tempStr = CommonUtil.SHA1(ss[0]+ss[1]+ss[2]);
		System.out.println("my signature *"+tempStr+"* VS their signature *"+signature+"*");
		if(tempStr.equals(signature)){
			return true;
		}
		return false;
	}

}
