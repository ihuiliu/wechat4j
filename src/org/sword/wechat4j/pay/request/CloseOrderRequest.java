package org.sword.wechat4j.pay.request;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 关闭订单
 * @author Zhangxs
 * @date 2015-7-20 
 * @version
 */
@XmlRootElement(name="xml")
public class CloseOrderRequest extends BasicPayRequest {
	/*
	字段名		变量名			必填	类型			示例值								描述
	商户订单号		out_trade_no	否	String(32)	1217752501201407033233368018		商户系统内部的订单号
	*/
	private String out_trade_no;

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	
}
