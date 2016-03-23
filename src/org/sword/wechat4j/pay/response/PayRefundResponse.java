package org.sword.wechat4j.pay.response;

/**
 * 申请退款
 * @author Zhangxs
 * @date 2015-10-10 
 * @version
 */
public class PayRefundResponse extends BasicPaySuccess{
	//微信订单号
	private String transaction_id;//	是	String(32)	1217752501201407033233368018	微信订单号
	//商户订单号
	private String out_trade_no;//	是	String(32)	1217752501201407033233368018	商户系统内部的订单号
//	//商户退款单号
//	private String out_refund_no_$n;//	是	String(32)	1217752501201407033233368018	商户退款单号
//	//微信退款单号
//	private String refund_id_$n;//	是	String(28)	1217752501201407033233368018	微信退款单号
//	//退款渠道
//	//ORIGINAL—原路退款
//	//BALANCE—退回到余额
//	private String refund_channel_$n;//	否	String(16)	ORIGINAL	
//	//退款金额
//	private Integer refund_fee_$n;//	是	Int	100	退款总金额,单位为分,可以做部分退款	
	//订单总金额
	private Integer total_fee;//	是	Int	100	订单总金额，单位为分，只能为整数，详见支付金额
	
	//订单金额货币种类
	private String fee_type;//	否	String(8)	CNY	订单金额货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
	//现金支付金额				
	private Integer cash_fee;//			是	Int			100									现金支付金额订单现金支付金额，详见支付金额
	//现金退款金额
	private Integer cash_refund_fee;//	否	Int	100	现金退款金额，单位为分，只能为整数，详见支付金额
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
	public Integer getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}
	public String getFee_type() {
		return fee_type;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	public Integer getCash_fee() {
		return cash_fee;
	}
	public void setCash_fee(Integer cash_fee) {
		this.cash_fee = cash_fee;
	}
	public Integer getCash_refund_fee() {
		return cash_refund_fee;
	}
	public void setCash_refund_fee(Integer cash_refund_fee) {
		this.cash_refund_fee = cash_refund_fee;
	}
	
//	//代金券或立减优惠退款金额
//	private Integer coupon_refund_fee_$n;//	否	Int	100	代金券或立减优惠退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金，说明详见代金券或立减优惠
//	//代金券或立减优惠使用数量
//	private Integer 	coupon_refund_count_$n;//	否	Int	1	代金券或立减优惠使用数量 ,$n为下标,从0开始编号
//	//代金券或立减优惠批次ID
//	private String 	coupon_refund_batch_id_$n_$m;//	否	String(20)	100	批次ID ,$n为下标，$m为下标，从0开始编号
//	//代金券或立减优惠ID
//	private String coupon_refund_id_$n_$m;//	否	String(20)	10000 	代金券或立减优惠ID, $n为下标，$m为下标，从0开始编号
//	//单个代金券或立减优惠支付金额
//	private Integer 	coupon_refund_fee_$n_$m;//	否	Int	100	单个代金券或立减优惠支付金额, $n为下标，$m为下标，从0开始编号
	
	

}
