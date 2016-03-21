package hermione.model.message;

import com.thoughtworks.xstream.XStream;

public class TextMessageResponse {
	
	private String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private String MsgType = "text";
	private String Content;
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	
	public String toWeixinXml() throws ClassNotFoundException{
		XStream xs = new XStream();
		xs.alias("xml", Class.forName("hermione.model.message.TextMessageResponse"));
		return xs.toXML(this);
	}
	
}
