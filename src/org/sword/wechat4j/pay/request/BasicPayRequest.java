package org.sword.wechat4j.pay.request;

public class BasicPayRequest {
	//子商户公众账号ID	
	protected String sub_appid;//	否	String(32)	wx8888888888888888	微信分配的子商户公众账号ID，如需在支付完成后获取sub_openid则此参数必传。
	//子商户号	
	protected String sub_mch_id;//	是	String(32)	1900000109	微信支付分配的子商户号
	//公众账号ID
	protected String appid;
	//商户号	
	protected String mch_id;
	//随机字符串	
	protected String nonce_str;
	//签名	
	protected String sign;
	/*
	公众账号ID	appid			是	String(32)	wx8888888888888888					微信分配的公众账号ID（企业号corpid即为此appId）
	商户号		mch_id			是	String(32)	1900000109							微信支付分配的商户号
	随机字符串		nonce_str		是	String(32)	5K8264ILTKCH16CQ2502SI8ZNMTM67VS	商户系统内部的订单号,32个字符内、可包含字母, 其他说明见商户订单号
	签名			sign			是	String(32)	C380BEC2BFD727A4B6845133519F3AD6	签名，详见签名生成算法
	*/
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getSub_appid() {
		return sub_appid;
	}
	public void setSub_appid(String sub_appid) {
		this.sub_appid = sub_appid;
	}
	public String getSub_mch_id() {
		return sub_mch_id;
	}
	public void setSub_mch_id(String sub_mch_id) {
		this.sub_mch_id = sub_mch_id;
	}
	

}
