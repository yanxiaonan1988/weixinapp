package hermione.model.message;

import java.util.List;

public class PicAndTextMessageResponse {
	//initial capital is convenient
	private String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private String MsgType = "news";
	private int ArticleCount;
	List<Item> Articles;
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
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<Item> getArticles() {
		return Articles;
	}
	public void setArticles(List<Item> articles) {
		Articles = articles;
	}
	
	
}
