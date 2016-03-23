/**
 * 
 */
package org.sword.wechat4j.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @author ChengNing
 * @date   2014年12月8日
 */
public class Config {
	
	private static Logger logger = Logger.getLogger(Config.class);
	
	private static final String configFile = "/wechat4j.properties";
	//服务器地址
	private String url;
	//令牌
	private String token;
	//消息加解密密钥
	private String encodingAESKey;
	//应用ID
	private String appid;
	//应用密钥
	private String appSecret;
	//商户号
	private String partnerid;
	//商户密钥
	private String partnerKey;
	//退款证书路径
	private String refundCertificatePath;
	//自定义Token类
	private String accessTokenServer;
	//自定义jsApiTicket类
	private String jsApiTicketServer;
	//自定义ApiTicket类
	private String apiTicketServer;
	private static Config config = new Config();
	
	private Config(){
//		ResourceBundle dp = ResourceBundle.getBundle(configFile);
//		dp.getString("")
		Properties p = new Properties();
		InputStream inStream = this.getClass().getResourceAsStream(configFile);
		if(inStream == null){
			logger.error("根目录下找不到wechat4j.properties文件");
			return;
		}
		try {
			p.load(inStream);
			//this.url = p.getProperty("wechat.url").trim();
			//this.encodingAESKey = p.getProperty("wechat.encodingaeskey").trim();
			this.token = p.getProperty("wechat.token").trim();
			this.appid = p.getProperty("wechat.appid").trim();
			this.appSecret = p.getProperty("wechat.appsecret").trim();
			this.partnerid = p.getProperty("wechat.partnerid").trim();
			this.partnerKey = p.getProperty("wechat.partnerKey").trim();
			/*this.refundCertificatePath=p.getProperty("wechat.refundCertificatePath").trim();
			this.accessTokenServer = p.getProperty("wechat.accessToken.server.class").trim();
			this.jsApiTicketServer = p.getProperty("wechat.ticket.jsapi.server.class").trim();
			this.apiTicketServer = p.getProperty("wechat.ticket.api.server.class").trim();*/
			inStream.close();
		} catch (IOException e) {
			logger.error("load wechat4j.properties error,class根目录下找不到wechat4j.properties文件");
			e.printStackTrace();
		}
		logger.info("load wechat4j.properties success");
	}
	
	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		Config.logger = logger;
	}

	public static Config getConfig() {
		return config;
	}

	public static void setConfig(Config config) {
		Config.config = config;
	}

	public static String getConfigfile() {
		return configFile;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setEncodingAESKey(String encodingAESKey) {
		this.encodingAESKey = encodingAESKey;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public void setPartnerid(String partnerid) {
		this.partnerid = partnerid;
	}

	public void setPartnerKey(String partnerKey) {
		this.partnerKey = partnerKey;
	}

	public void setRefundCertificatePath(String refundCertificatePath) {
		this.refundCertificatePath = refundCertificatePath;
	}

	public void setAccessTokenServer(String accessTokenServer) {
		this.accessTokenServer = accessTokenServer;
	}

	public void setJsApiTicketServer(String jsApiTicketServer) {
		this.jsApiTicketServer = jsApiTicketServer;
	}

	public static Config instance(){
		return config;
	}
	public String getToken() {
		return token;
	}
	public String getAppid() {
		return appid;
	}
	public String getAppSecret() {
		return appSecret;
	}

	public String getUrl() {
		return url;
	}

	public String getEncodingAESKey() {
		return encodingAESKey;
	}
	
	public String getPartnerKey() {
		return partnerKey;
	}

	public String getAccessTokenServer(){
		return accessTokenServer;
	}

	public String getJsApiTicketServer() {
		return jsApiTicketServer;
	}

	public String getRefundCertificatePath() {
		return refundCertificatePath;
	}

	public String getPartnerid() {
		return partnerid;
	}

	public String getApiTicketServer() {
		return apiTicketServer;
	}

	public void setApiTicketServer(String apiTicketServer) {
		this.apiTicketServer = apiTicketServer;
	}
	
	
}
