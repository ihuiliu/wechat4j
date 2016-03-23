package org.sword.wechat4j.pay.request;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 查询订单请求
 * @author Zhangxs
 * @date 2015-7-20 
 * @version
 */
@XmlRootElement(name="xml")
public class QueryOrderRequest extends BasicPayRequest{
	private String transaction_id;
	private String out_trade_no;
	/*
	微信订单号		transaction_id	否	String(32)	013467007045764						微信的订单号，优先使用
	商户订单号		out_trade_no	否	String(32)	1217752501201407033233368018		商户系统内部的订单号，当没提供transaction_id时需要传这个。
	*/
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
	
}
