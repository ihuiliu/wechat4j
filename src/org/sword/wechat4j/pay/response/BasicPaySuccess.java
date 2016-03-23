package org.sword.wechat4j.pay.response;

public class BasicPaySuccess extends BasicPay{
	//子商户公众账号ID	服务商模式使用
	protected String sub_appid;
	//子商户号	服务商模式使用
	protected String sub_mch_id;
	//以下字段在return_code为SUCCESS的时候有返回
	//字段名			变量名		必填		类型			示例值									描述
	//公众账号ID		
	protected String appid;//		是		String(32)	wx8888888888888888						调用接口提交的公众账号ID
	//商户号			
	protected String mch_id;//		是		String(32)	1900000109								调用接口提交的商户号 
	//设备号 			
	protected String device_info;//	否		String(32)	013467007045764							调用接口提交的终端设备号，
	//随机字符串			
	protected String nonce_str;//	是		String(32)	5K8264ILTKCH16CQ2502SI8ZNMTM67VS		微信返回的随机字符串
	//签名				
	protected String sign;//		是		String(32)	C380BEC2BFD727A4B6845133519F3AD6		微信返回的签名，详见签名算法
	//业务结果			
	protected String result_code;//	是		String(16)	SUCCESS									SUCCESS/FAIL
	//错误代码			
	protected String err_code;//	否		String(32)	SYSTEMERROR								详细参见第6节错误列表
	//错误代码描述		
	protected String err_code_des;//否		String(128)	系统错误	
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
	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
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
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getErr_code() {
		return err_code;
	}
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	public String getErr_code_des() {
		return err_code_des;
	}
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
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
