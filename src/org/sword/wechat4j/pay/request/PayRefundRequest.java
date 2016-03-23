package org.sword.wechat4j.pay.request;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 申请退款
 * @author Zhangxs
 * @date 2015-7-20 
 * @version
 */
@XmlRootElement(name="xml")
public class PayRefundRequest extends BasicPayRequest{
	private String device_info;
	private String transaction_id;
	private String out_trade_no;
	private String out_refund_no;
	private Integer total_fee;
	private Integer refund_fee;
	private String refund_fee_type;
	private String op_user_id;
/*	字段名		变量名			必填		类型			示例值								描述
	设备号		device_info		否		String(32)	013467007045764						终端设备号		
	微信订单号		transaction_id	是		String(28)	1217752501201407033233368018		微信订单号
	商户订单号		out_trade_no	是		String(32)	1217752501201407033233368018		商户系统内部的订单号,transaction_id、out_trade_no二选一，如果同时存在优先级：transaction_id> out_trade_no
	商户退款单号	out_refund_no	是		String(32)	1217752501201407033233368018		商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔
	总金额		total_fee		是		Int			100									订单总金额，单位为分，只能为整数，详见支付金额
	退款金额		refund_fee		是		Int			100									退款总金额，订单总金额，单位为分，只能为整数，详见支付金额
	货币种类		refund_fee_type	否		String(8)	CNY									货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
	操作员		op_user_id		是		String(32)	1900000109							操作员帐号, 默认为商户号*/
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
	public Integer getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}
	public Integer getRefund_fee() {
		return refund_fee;
	}
	public void setRefund_fee(Integer refund_fee) {
		this.refund_fee = refund_fee;
	}
	public String getRefund_fee_type() {
		return refund_fee_type;
	}
	public void setRefund_fee_type(String refund_fee_type) {
		this.refund_fee_type = refund_fee_type;
	}
	public String getOp_user_id() {
		return op_user_id;
	}
	public void setOp_user_id(String op_user_id) {
		this.op_user_id = op_user_id;
	}
}
