package org.sword.wechat4j.pay.response;
/**
 * 查询退款结果
 * @author Zhangxs
 * @date 2015-7-19 
 * @version
 */
public class QueryRefundResponse extends BasicPay {
	//微信订单号
	private String transaction_id;//	是	String(32)	1217752501201407033233368018	微信订单号
	//商户订单号
	private String out_trade_no;//		是	String(32)	1217752501201407033233368018	商户系统内部的订单号
	//订单总金额
	private Integer total_fee;//		是	Int	100	订单总金额，单位为分，只能为整数，详见支付金额
	//订单金额货币种类
	private String fee_type;//			否	String(8)	CNY	订单金额货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
	//现金支付金额				
	private Integer cash_fee;//			是	Int			100									现金支付金额订单现金支付金额，详见支付金额
	//退款笔数	
	private Integer refund_count;//		是	Int			1			退款记录数
//	//商户退款单号
//	private String out_refund_no_$n;//	是	String(32)	1217752501201407033233368018	商户退款单号
//	//微信退款单号
//	private String refund_id_$n;//		是	String(28)	1217752501201407033233368018	微信退款单号
//	//退款渠道
//	//ORIGINAL—原路退款
//	//BALANCE—退回到余额
//	private String refund_channel_$n;//	否	String(16)	ORIGINAL	
//	//退款金额
//	private Integer refund_fee_$n;//	是	Int	100	退款总金额,单位为分,可以做部分退款	
//	
//	//代金券或立减优惠退款金额
//	private Integer coupon_refund_fee_$n;//	否	Int	100	代金券或立减优惠退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金，说明详见代金券或立减优惠
//	//代金券或立减优惠使用数量
//	private Integer coupon_refund_count_$n;//	否	Int	1	代金券或立减优惠使用数量 ,$n为下标,从0开始编号
//	//代金券或立减优惠批次ID
//	private String coupon_refund_batch_id_$n_$m;//	否	String(20)	100	批次ID ,$n为下标，$m为下标，从0开始编号
//	//代金券或立减优惠ID
//	private String coupon_refund_id_$n_$m;//	否	String(20)	10000 	代金券或立减优惠ID, $n为下标，$m为下标，从0开始编号
//	//单个代金券或立减优惠支付金额
//	private Integer coupon_refund_fee_$n_$m;//	否	Int	100	单个代金券或立减优惠支付金额, $n为下标，$m为下标，从0开始编号
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
	public Integer getRefund_count() {
		return refund_count;
	}
	public void setRefund_count(Integer refund_count) {
		this.refund_count = refund_count;
	}
	
	
	//退款状态	
//	退款状态：
//	SUCCESS—退款成功
//	FAIL—退款失败
//	PROCESSING—退款处理中
//	NOTSURE—未确定，需要商户原退款单号重新发起
//	CHANGE—转入代发，退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，资金回流到商户的现金帐号，需要商户人工干预，通过线下或者财付通转账的方式进行退款。
//	private String refund_status_$n;//	是	String(16)	SUCCESS	
	
}
