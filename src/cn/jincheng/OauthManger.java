package cn.jincheng;

import org.apache.log4j.Logger;
import org.sword.lang.HttpUtils;
import org.sword.wechat4j.common.Config;
import org.sword.wechat4j.util.HttpRequest;



public class OauthManger {
	Logger logger = Logger.getLogger(OauthManger.class);
	private static final String ACCESS_TOKEN =" https://api.weixin.qq.com/sns/oauth2/access_token";
			//"https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
	public OauthManger() {
		//this.accessToken = TokenProxy.accessToken();
	}
	/**
	 * 创建菜单
	 * @return
	 */
	public String getOpenid(String  code) {
		System.out.println(ACCESS_TOKEN+code+"&grant_type=authorization_code");
		String resultStr = HttpRequest.sendGet(ACCESS_TOKEN,"appid="+Config.instance().getAppid()+"&secret="+Config.instance().getAppSecret()+"&code="+code+"&grant_type=authorization_code");
				
				
				//HttpUtils.get(ACCESS_TOKEN+"appid="+Config.instance().getAppid()+"&secret="+Config.instance().getAppSecret()+"&code="+code+"&grant_type=authorization_code");
		logger.info("return data "+resultStr);
		return resultStr;
	}
	
}
