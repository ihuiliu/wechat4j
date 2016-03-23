package org.sword.wechat4j.pay;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.sword.wechat4j.pay.request.BasicPayRequest;
/**
 * 
 * @author Zhangxs
 * @date 2015-8-18 
 * @version
 */
@XmlRootElement(name="xml")
public class NativeOutput extends BasicPayRequest{
	public static String CDATA_TAG [] =new String[]{"^return_code","^return_msg"};
	//返回状态码

	@XmlElement(name="return_code")
	private String returnCode;//	String(16)	是	SUCCESS	SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
	//返回信息
	@XmlElement(name="return_msg")
	private String returnMsg;//	String(128)	否	签名失败	返回信息，如非空，为错误原因;签名失败;具体某个参数格式校验错误.
	//预支付ID
	@XmlElement(name="prepay_id")
	private String prepayId;//	String(64)	是	wx201410272009395522657a690389285100	调用统一下单接口生成的预支付ID
	//业务结果
	@XmlElement(name="result_code")
	private String resultCode;//	String(16)	是	SUCCESS	SUCCESS/FAIL
	//错误描述
	@XmlElement(name="err_code_des")
	private String errCodeDes;//	String(128)	否		当result_code为FAIL时，商户展示给用户的错误提
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getReturnMsg() {
		return returnMsg;
	}
	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	public String getPrepayId() {
		return prepayId;
	}
	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getErrCodeDes() {
		return errCodeDes;
	}
	public void setErrCodeDes(String errCodeDes) {
		this.errCodeDes = errCodeDes;
	}
	

}
