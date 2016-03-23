package org.sword.wechat4j.pay.response;


/**
 * 查询订单结果
 * @author Zhangxs
 * @date 2015-7-19 
 * @version
 */
public class QueryOrderResponse extends BasicPaySuccess{

	//用户标识					
	private String openid;//			是	String(128)	wxd930ea5d5a258f4f					用户在商户appid下的唯一标识
	//是否关注公众账号			
	private String is_subscribe;//		是	String(1)	Y									用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
	//交易类型					
	private String trade_type;//		是	String(16)	JSAPI								JSAPI、NATIVE、APP
	/*
	 * 交易状态
	 * SUCCESS—支付成功
	 * REFUND—转入退款
	 * NOTPAY—未支付
	 * CLOSED—已关闭
	 * REVOKED—已撤销（刷卡支付）
	 * USERPAYING--用户支付中
	 * PAYERROR--支付失败(其他原因，如银行返回失败)
	 */
	private String trade_state;//		是	String(32)	SUCCESS	
	//付款银行					
	private String bank_type;//			是	String(16)	CMC									银行类型，采用字符串类型的银行标识，银行列表见银行类型
	//总金额					
	private Integer total_fee;//		是	Int			100									订单总金额，单位为分
	//货币种类					
	private String fee_type;//			否	String(8)	CNY									货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
	//现金支付金额				
	private Integer cash_fee;//			是	Int			100									现金支付金额订单现金支付金额，详见支付金额
	//现金支付货币类型			
	private String cash_fee_type;//		否	String(16)	CNY									货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
	//代金券或立减优惠金额			
	private Integer coupon_fee;//		否	Int			10									代金券或立减优惠金额<=订单总金额，订单总金额-代金券或立减优惠金额=现金支付金额，详见支付金额
	//代金券或立减优惠使用数量		
	private Integer coupon_count;//		否	Int			1									代金券或立减优惠使用数量
//	//代金券或立减优惠ID			
//	private String coupon_id_$n;//		否	String(20)	10000 								代金券或立减优惠ID, $n为下标，从0开始编号
//	//单个代金券或立减优惠支付金额	
//	private Integer coupon_fee_$n;//	否	Int			100									单个代金券或立减优惠支付金额, $n为下标，从0开始编号
	//微信支付订单号				
	private String transaction_id;//	是	String(32)	1217752501201407033233368018		微信支付订单号
	//商户订单号					
	private String out_trade_no;//		是	String(32)	1212321211201407033568112322		商户系统的订单号，与请求一致。
	//商家数据包					
	private String attach;//			否	String(128)	123456								商家数据包，原样返回
	//支付完成时间				
	private String time_end;//			是	String(14)	20141030133525
	//交易状态描述
	private String trade_state_desc;//	是	String(256)	支付失败，请重新下单支付	对当前查询订单状态的描述和下一步操作的指引
	//用户子标识
	private String sub_openid;//	否	String(128)	wxd930ea5d5a258f4f	用户在子商户appid下的唯一标识
	//是否关注子公众账号
	private String sub_is_subscribe;//	是	String(1)	Y	用户是否关注子公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getIs_subscribe() {
		return is_subscribe;
	}
	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getTrade_state() {
		return trade_state;
	}
	public void setTrade_state(String trade_state) {
		this.trade_state = trade_state;
	}
	public String getBank_type() {
		return bank_type;
	}
	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
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
	public String getCash_fee_type() {
		return cash_fee_type;
	}
	public void setCash_fee_type(String cash_fee_type) {
		this.cash_fee_type = cash_fee_type;
	}
	public Integer getCoupon_fee() {
		return coupon_fee;
	}
	public void setCoupon_fee(Integer coupon_fee) {
		this.coupon_fee = coupon_fee;
	}
	public Integer getCoupon_count() {
		return coupon_count;
	}
	public void setCoupon_count(Integer coupon_count) {
		this.coupon_count = coupon_count;
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
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public String getTime_end() {
		return time_end;
	}
	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}
	public String getTrade_state_desc() {
		return trade_state_desc;
	}
	public void setTrade_state_desc(String trade_state_desc) {
		this.trade_state_desc = trade_state_desc;
	}
	public String getSub_openid() {
		return sub_openid;
	}
	public void setSub_openid(String sub_openid) {
		this.sub_openid = sub_openid;
	}
	public String getSub_is_subscribe() {
		return sub_is_subscribe;
	}
	public void setSub_is_subscribe(String sub_is_subscribe) {
		this.sub_is_subscribe = sub_is_subscribe;
	}
	
}
