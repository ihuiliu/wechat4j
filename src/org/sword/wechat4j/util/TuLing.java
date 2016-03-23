package org.sword.wechat4j.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;


/**
 * 调用图灵机器人HTTP协议接口
 * @author tom
 * 2015.12.15
 */
public class TuLing {
	private static Logger logger = Logger.getLogger(TuLing.class);
	
	/**
	 * 调用图灵机器人HTTP协议接口
	 * @param content 请求的内容
	 * @param openId 用户openId
	 * @return String 回答的内容
	 */
	public static String chatWithTuLing(String content,String openId){
		String result = "";
		String reply = "";
		JSONObject jsonResult = null;
		String url = "http://www.tuling123.com/openapi/api";
		
		//去除空格
		content = content.replace(" ", "");
		String param = "key=f8e2ef91f9c351ca335bf67eff6c5c10&info="+content+"&userid="+openId;
		
		result = HttpRequest.sendGet(url, param);
		
		try {
			System.out.println(result);
			jsonResult=JSONObject.fromObject(result);
			//jsonResult = new JSONObject(result);
			Integer code = jsonResult.getInt("code");
			if(code == 100000){
				String text = jsonResult.getString("text");
				reply = text;
			}
			if(code == 200000){
				String text = jsonResult.getString("text");
				url = jsonResult.getString("url");
				if(url.equals("")){
					reply = text;
				}else{
					reply = text+"\n<a href=\""+url+"\">点击这里</a>";
				}
			}
			if(code == 302000){
				String text = jsonResult.getString("text");
				JSONArray list = jsonResult.getJSONArray("list");
				for(int i=0;i<list.size();i++){
					jsonResult = (JSONObject) list.get(i);
					String article = jsonResult.getString("article");
					String source = jsonResult.getString("source");
					String detailurl = jsonResult.getString("detailurl");
					reply = reply + article+"\n"+source+"\n"+"<a href=\""+detailurl+"\">点击这里</a>\n";
				}
				reply = text+"\n"+reply;
			}
			if(code == 308000){
				String text = jsonResult.getString("text");
				JSONArray list = jsonResult.getJSONArray("list");
				jsonResult = (JSONObject) list.get(0);
				String name = jsonResult.getString("name");
				String info = jsonResult.getString("info");
				String detailurl = jsonResult.getString("detailurl");
				reply = text+"\n"+name+"\n"+info+"<a href=\""+detailurl+"\">点击这里</a>";
			}
		} catch (Exception e) {
			logger.warn("JSON解析出错");
			e.printStackTrace();
			return "error";
		}
		
		return reply;
	}
}
