package org.sword.wechat4j.pay.request;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 查询退款
 * @author Zhangxs
 * @date 2015-7-20 
 * @version
 */
@XmlRootElement(name="xml")
public class QueryRefundRequest extends BasicPayRequest{
	private String device_info;
	private String transaction_id;
	private String out_trade_no;
	private String out_refund_no;
	private String refund_id;
/*	
	
	设备号		device_info		否	String(32)	013467007045764						商户自定义的终端设备号，如门店编号、设备的ID等
	微信订单号		transaction_id	否	String(28)	1217752501201407033233368018		微信订单号
	商户订单号		out_trade_no	是	String(32)	1217752501201407033233368018		商户系统内部的订单号
	商户退款单号	out_refund_no	否	String(32)	1217752501201407033233368018		商户退款单号
	微信退款单号	refund_id		否	String(28)	1217752501201407033233368018		微信退款单号		refund_id、out_refund_no、out_trade_no、transaction_id四个参数必填一个，如果同时存在优先级为：	refund_id>out_refund_no>transaction_id>out_trade_no*/
	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getOut_refund_no() {
		return out_refund_no;
	}
	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}
	public String getRefund_id() {
		return refund_id;
	}
	public void setRefund_id(String refund_id) {
		this.refund_id = refund_id;
	}
}
