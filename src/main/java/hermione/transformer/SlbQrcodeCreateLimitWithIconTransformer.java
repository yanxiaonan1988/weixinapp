package hermione.transformer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.DataBufferByte;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;

import javax.imageio.ImageIO;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

public class SlbQrcodeCreateLimitWithIconTransformer extends
		AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		String openid = message.getInboundProperty("openid");
		String sceneid = message.getInboundProperty("sceneid");
		System.out.println(openid);
		System.out.println(sceneid);
		
		URL url = null;
		try {
			url = new URL("http://127.0.0.1:8000/webService/connectWeixin/sulaibao/user/info?openid="+openid);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        URLConnection conn = null;
        BufferedReader in = null;
        String resStr = "";
		try {
			conn = url.openConnection();
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) 
	            resStr += inputLine;
	        in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(resStr);
		JSONObject resJson = null;
		String headimgurl = null;
		try {
			resJson = new JSONObject(resStr);
			System.out.println("*****");
			System.out.println(resStr);
			System.out.println("***************");
			headimgurl = (String) resJson.get("headimgurl");
			System.out.println("headimgurl:"+headimgurl);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		InputStream inImage1 = null;
		InputStream inImage2 = null;
		InputStream qrCodeInputStream = null;
		InputStream inputStream = null;
		try {
			URL url1 = new URL("http://127.0.0.1:8000/webService/connectWeixin/sulaibao/qrcode/create/limit?openid="+openid+"&sceneid="+sceneid);
			URLConnection conn1 = null;
			conn1 = url1.openConnection();
			inImage1 = conn1.getInputStream();
			
			URL url2 = new URL(headimgurl);
			URLConnection conn2 = null;
			conn2 = url2.openConnection();
			inImage2 = conn2.getInputStream();
			
			BufferedImage image=ImageIO.read(inImage1);
	        BufferedImage image2=ImageIO.read(inImage2);
	        
	        ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_sRGB);
			ColorConvertOp op = new ColorConvertOp(cs, null);
			image = op.filter(image, null);
	        
	        Graphics g=image.getGraphics();
	        g.drawImage(image2,170,170,90,90,null);
	        
	        ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(image, "jpg", os);
			qrCodeInputStream = new ByteArrayInputStream(os.toByteArray());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		try {
			InputStream backInputStream = this.getClass()
					.getResource("/card-head-back.png").openStream();
			InputStream cardBackInputStream = this.getClass()
					.getResource("/card-back.png").openStream();
			String name = message.getInboundProperty("name");
			String location = message.getInboundProperty("location");
			String position = message.getInboundProperty("position");
			String phone = message.getInboundProperty("phone");
			System.out.println("name:"+name);
			
			if (name == null) {
				name = "黄飞鸿";
			}else{
				name = URLDecoder.decode(name,"utf-8");
				System.out.println("name:"+name);
			}

			if (location == null) {
				location = "上海-浦东新区";
			}else{
				location = URLDecoder.decode(location,"utf-8");
			}

			if (position == null) {
				position = "高级销售经理";
			}else{
				position = URLDecoder.decode(position,"utf-8");
			}

			if (phone == null) {
				phone = "188-8888-8888";
			}


			//InputStream myPicInputStream = inImage2;
			URL url2 = new URL(headimgurl);
			URLConnection conn2 = null;
			conn2 = url2.openConnection();
			InputStream myPicInputStream = conn2.getInputStream();

			BufferedImage backImg = ImageIO.read(backInputStream);
			BufferedImage qrCodeImg = ImageIO.read(qrCodeInputStream);
			BufferedImage myPicImg = ImageIO.read(myPicInputStream);
			BufferedImage cardBackImg = ImageIO.read(cardBackInputStream);
//			Graphics graphics = backImg.getGraphics();
			
			
			BufferedImage convertedImage=new BufferedImage(backImg.getWidth(), backImg.getHeight(), BufferedImage.TYPE_INT_RGB );
			Graphics graphics = convertedImage.getGraphics();
			graphics.drawImage(backImg,0,0,null);

			
			graphics.setFont(new Font("宋体", Font.BOLD, 34));
			graphics.setColor(new Color(0xff9c1e));

			int qrCodeImgWidth = 180;
			int qrCodeImgHeight = 180;

			graphics.drawImage(myPicImg, 15, 40, qrCodeImgWidth,
					qrCodeImgHeight, null);
			graphics.drawImage(cardBackImg, 10 + qrCodeImgWidth - 10, 40,
					cardBackImg.getWidth(), qrCodeImgHeight, null);
			graphics.drawImage(qrCodeImg,
					10 + qrCodeImgWidth + cardBackImg.getWidth() - 5, 40,
					qrCodeImgWidth, qrCodeImgHeight, null);
			graphics.drawString(name, 10 + qrCodeImgWidth + 20, 40 + 40);

			graphics.setFont(new Font("宋体", Font.PLAIN, 24));
			graphics.setColor(Color.DARK_GRAY);

			graphics.drawString(position, 10 + qrCodeImgWidth + 47 +5, 80 + 40+4);
			graphics.drawString(location, 10 + qrCodeImgWidth + 47 +5, 80 + 80+3);
			graphics.drawString(phone, 10 + qrCodeImgWidth + 47 +5, 80 + 120+2);

			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(convertedImage, "png", os);
			inputStream = new ByteArrayInputStream(os.toByteArray());

			graphics.dispose();
			backInputStream.close();
			cardBackInputStream.close();
			os.close();
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


		
		
		//byte b[] = ((DataBufferByte)image.getData().getDataBuffer()).getData();
		//message.setOutboundProperty("qrcodejpg", b);
		
		return inputStream;
	}

}
