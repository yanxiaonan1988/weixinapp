package hermione.business;

import java.util.ArrayList;
import java.util.List;

import hermione.model.message.Item;
import hermione.model.message.PicAndTextMessageResponse;
import hermione.model.message.TextMessageRequest;
import hermione.model.message.TextMessageResponse;

public class HcaxTextMessageBusiness {
	public String process(TextMessageRequest req) throws ClassNotFoundException{
		System.out.println("####HcaxTextMessageBusiness");
		
		String content = req.getContent();
		System.out.println("Content: "+content);
		if("1".equals(content)){
			PicAndTextMessageResponse res = new PicAndTextMessageResponse();
			res.setToUserName(req.getFromUserName());
			res.setFromUserName(req.getToUserName());
			res.setCreateTime(1348831860);
			res.setArticleCount(1);
			List<Item> articles = new ArrayList<Item>();
			Item item = new Item();
			item.setTitle("公司介绍");
			item.setPicUrl("http://mmbiz.qpic.cn/mmbiz/d4a1pAQE4hT9Tq3SNKfFpK4Z1hV45wpKvTtz5fI45BBX71GWEhmJdUiaMOkiaWafb9TVpGYuLMttW5kG4Uuhrflg/640?wx_fmt=jpeg&tp=webp&wxfrom=5");
			item.setUrl("http://mp.weixin.qq.com/s?__biz=MjM5MzA5MzA3NA==&mid=206689763&idx=1&sn=b570cf9f3498eb29a0468f05cf12b5bf&scene=18#wechat_redirect");
			articles.add(item);
			res.setArticles(articles);
			return res.toWeixinXml();
		}else if("2".equals(content)){
			PicAndTextMessageResponse res = new PicAndTextMessageResponse();
			res.setToUserName(req.getFromUserName());
			res.setFromUserName(req.getToUserName());
			res.setCreateTime(1348831860);
			res.setArticleCount(1);
			List<Item> articles = new ArrayList<Item>();
			Item item = new Item();
			item.setTitle("360°保险管家");
			item.setPicUrl("http://mmbiz.qpic.cn/mmbiz/d4a1pAQE4hT9Tq3SNKfFpK4Z1hV45wpKwbT23VWQSdG0Vdwn5l5QUWPyqZdTs6ybGYVPeGtfnqYMAgPHUenyAA/640?wx_fmt=jpeg&tp=webp&wxfrom=5");
			item.setUrl("http://mp.weixin.qq.com/s?__biz=MjM5MzA5MzA3NA==&mid=206917282&idx=1&sn=c368b1428f1fc46662f5b2cf5a4b82e4&scene=18#wechat_redirect");
			articles.add(item);
			res.setArticles(articles);
			return res.toWeixinXml();
		}else if("3".equals(content)){
			PicAndTextMessageResponse res = new PicAndTextMessageResponse();
			res.setToUserName(req.getFromUserName());
			res.setFromUserName(req.getToUserName());
			res.setCreateTime(1348831860);
			res.setArticleCount(1);
			List<Item> articles = new ArrayList<Item>();
			Item item = new Item();
			item.setTitle("在线投保说明");
			item.setPicUrl("http://mmbiz.qpic.cn/mmbiz/d4a1pAQE4hTwaibBRQmkkDNrQUCkT8RSVDsj02RfPTexcMZKU6TTuUPmrHAZiaLzwj6xs6E0oQh688Onhf2Uuj2Q/640?wx_fmt=jpeg&tp=webp&wxfrom=5");
			item.setUrl("http://mp.weixin.qq.com/s?__biz=MjM5MzA5MzA3NA==&mid=206981981&idx=1&sn=22e61f7d84b63fa45a9c0253641e0fb3&scene=18");
			articles.add(item);
			res.setArticles(articles);
			return res.toWeixinXml();
		}else if("4".equals(content)){
			TextMessageResponse res = new TextMessageResponse();
			res.setToUserName(req.getFromUserName());
			res.setFromUserName(req.getToUserName());
			res.setCreateTime(1348831860);
			res.setContent("您好，这里是您的360°安心卫士，有什么需要咨询的吗。");
			return res.toWeixinXml();
		}else if("5".equals(content)){
			PicAndTextMessageResponse res = new PicAndTextMessageResponse();
			res.setToUserName(req.getFromUserName());
			res.setFromUserName(req.getToUserName());
			res.setCreateTime(1348831860);
			res.setArticleCount(5);
			List<Item> articles = new ArrayList<Item>();
			Item item0 = new Item();
			item0.setTitle("意外保险");
			item0.setPicUrl("http://mmbiz.qpic.cn/mmbiz/d4a1pAQE4hTCkyy5xj5FYo0bgdZYA6xBPEibfsuKv55Yr2lymBfqTQfqx14TbegydPfzLU8HjjLHQHJcOzqQKbg/640?wx_fmt=jpeg&tp=webp&wxfrom=5");
			item0.setUrl("http://mp.weixin.qq.com/s?__biz=MjM5MzA5MzA3NA==&mid=206917878&idx=1&sn=c1b2969966c7c15fc981cd494561f106&scene=18#rd");
			articles.add(item0);
			
			Item item1 = new Item();
			item1.setTitle("重大疾病保险");
			item1.setPicUrl("http://mmbiz.qpic.cn/mmbiz/d4a1pAQE4hTCkyy5xj5FYo0bgdZYA6xBsQyRJcXIibxAwbSpuUZzt0w2bZs88Kv8hgMbjnRXW3RVC2uqhluXIXw/640?wx_fmt=jpeg&tp=webp&wxfrom=5");
			item1.setUrl("http://mp.weixin.qq.com/s?__biz=MjM5MzA5MzA3NA==&mid=206918084&idx=1&sn=03fe8585f7fe4def28c16f68c6660a54&scene=18#rd");
			articles.add(item1);
			
			Item item2 = new Item();
			item2.setTitle("商业养老保险");
			item2.setPicUrl("http://mmbiz.qpic.cn/mmbiz/d4a1pAQE4hTCkyy5xj5FYo0bgdZYA6xBOTusibG20ja8r1t5J6wtoJ0tP8kzManGZaJ0v2B7Ay8FwHyLE34mH4Q/640?wx_fmt=jpeg&tp=webp&wxfrom=5");
			item2.setUrl("http://mp.weixin.qq.com/s?__biz=MjM5MzA5MzA3NA==&mid=206919338&idx=1&sn=4dd5d03532df30fc25c5783afb6919ca&scene=18#rd");
			articles.add(item2);
			
			Item item3 = new Item();
			item3.setTitle("家庭财产保险");
			item3.setPicUrl("http://mmbiz.qpic.cn/mmbiz/d4a1pAQE4hTCkyy5xj5FYo0bgdZYA6xBhJy8ia4cDNbwy1YFPISqBLlXcknnLAmXDZ43r13UEI6xn0I9hiap4r0Q/640?wx_fmt=jpeg&tp=webp&wxfrom=5");
			item3.setUrl("http://mp.weixin.qq.com/s?__biz=MjM5MzA5MzA3NA==&mid=206918270&idx=1&sn=4323419da2e4eb411832e1f5e27830ad&scene=18#rd");
			articles.add(item3);
			
			Item item4 = new Item();
			item4.setTitle("车辆保险");
			item4.setPicUrl("http://mmbiz.qpic.cn/mmbiz/d4a1pAQE4hTCkyy5xj5FYo0bgdZYA6xB6y7dTeKqsNBEXv6OxE8ncAM1k6KicE7ZMKPIxtVsr8225COlqN9qQBw/640?wx_fmt=jpeg&tp=webp&wxfrom=5");
			item4.setUrl("http://mp.weixin.qq.com/s?__biz=MjM5MzA5MzA3NA==&mid=206918633&idx=1&sn=4f76766cd46e62fb1965a533503e2175&scene=18#rd");
			articles.add(item4);
			
			res.setArticles(articles);
			return res.toWeixinXml();
		}else if("6".equals(content)){
			PicAndTextMessageResponse res = new PicAndTextMessageResponse();
			res.setToUserName(req.getFromUserName());
			res.setFromUserName(req.getToUserName());
			res.setCreateTime(1348831860);
			res.setArticleCount(4);
			List<Item> articles = new ArrayList<Item>();
			Item item0 = new Item();
			item0.setTitle("企业财产保险");
			item0.setPicUrl("http://mmbiz.qpic.cn/mmbiz/d4a1pAQE4hQ1Zyn4QBDj7a5COoJGymcf3KYicsvHzmgFRZ0BPKOWicSdyDboleF69FMOOJt26AyP4EibaGu78dswQ/640?wx_fmt=jpeg&tp=webp&wxfrom=5");
			item0.setUrl("http://mp.weixin.qq.com/s?__biz=MjM5MzA5MzA3NA==&mid=206906367&idx=1&sn=0fd01290f0353b875c762b513c83c769#rd");
			articles.add(item0);
			
			Item item1 = new Item();
			item1.setTitle("雇主责任保险");
			item1.setPicUrl("http://mmbiz.qpic.cn/mmbiz/d4a1pAQE4hTCkyy5xj5FYo0bgdZYA6xBdkq8XRwgRMpbbo3blMPsLI2AUcde3ICXmC3R48N7Czj4weU5yibvqpw/640?wx_fmt=jpeg&tp=webp&wxfrom=5");
			item1.setUrl("http://mp.weixin.qq.com/s?__biz=MjM5MzA5MzA3NA==&mid=206906295&idx=1&sn=11a860bdd554824716994d0fb5e770fd&scene=18#rd");
			articles.add(item1);
			
			Item item2 = new Item();
			item2.setTitle("出口信用保险");
			item2.setPicUrl("http://mmbiz.qpic.cn/mmbiz/d4a1pAQE4hQ1Zyn4QBDj7a5COoJGymcfQLMeUeQZJJ7AbWkYLdA1IicTkwmkNot9Pm6Sx7GpwN9L4ibqVAknlgCQ/640?wx_fmt=jpeg&tp=webp&wxfrom=5");
			item2.setUrl("http://mp.weixin.qq.com/s?__biz=MjM5MzA5MzA3NA==&mid=206906589&idx=1&sn=914c964e0434bb69594004f54097bed6#rd");
			articles.add(item2);
			
			Item item3 = new Item();
			item3.setTitle("全球高端医疗");
			item3.setPicUrl("http://mmbiz.qpic.cn/mmbiz/d4a1pAQE4hSgSib88FLqQhdQiaZic6US32oWSYyrZSd9lkgtcTFGtb7nC3jFI7aAMH00mLvib3huicicmGpsyaLiaEL3Q/640?wx_fmt=jpeg&tp=webp&wxfrom=5");
			item3.setUrl("http://mp.weixin.qq.com/s?__biz=MjM5MzA5MzA3NA==&mid=207279405&idx=1&sn=2e0fd82e690db2c9c4a63b92cd561c08&scene=1&from=singlemessage&isappinstalled=0#rd");
			articles.add(item3);
			
			res.setArticles(articles);
			return res.toWeixinXml();
		}else{
			TextMessageResponse res = new TextMessageResponse();
			res.setToUserName(req.getFromUserName());
			res.setFromUserName(req.getToUserName());
			res.setCreateTime(1348831860);
			res.setContent("您好，您留下的对我们公司对我们服务号宝贵的意见，我们会统一进行回复整改。谢谢。\r\n"+
					"1、 公司介绍\r\n"+
					"2、 360°保险管家\r\n"+
					"3、 在线投保说明\r\n"+
					"4、 咨询人工服务\r\n"+
					"5、 百万保家\r\n"+
					"6、 千万保企\r\n"+
					"如有需要投保去保险方面的咨询可回复4进入人工服务。\r\n"+
					"我们为您提供独具匠心的“360度管家式“保险专业服务。\r\n");
			return res.toWeixinXml();
		}
		
		
	}
}
