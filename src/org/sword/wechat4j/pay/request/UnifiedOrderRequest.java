package org.sword.wechat4j.pay.request;

import javax.xml.bind.annotation.XmlRootElement;

import org.sword.wechat4j.pay.TradeType;

/**
 * 统一下单请求
 * @author Zhangxs
 * @date 2015-7-20 
 * @version
 */
@XmlRootElement(name="xml")
public class UnifiedOrderRequest extends BasicPayRequest{
	
	//商品描述
	private String body;
	//商户订单号
	private String out_trade_no;
	//总金额 单位：分
	private Integer total_fee;
	//终端IP
	private String spbill_create_ip;
	//通知地址
	private String notify_url;
	//交易类型
	private TradeType trade_type;
	
	//用户子标识
	private String sub_openid;//	否	String(128)	oUpF8uMuAJO_M2pxb1Q9zNjWeS6o	trade_type=JSAPI，此参数必传，用户在子商户appid下的唯一标识。openid和sub_openid可以选传其中之一，如果选择传sub_openid,则必须传sub_appid。下单前需要调用【网页授权获取用户信息】接口获取到用户的Openid。
	//商品ID		
	private String product_id;
	//用户标识		
	private String openid;
	//设备号
	private String device_info;
	//商品详情		
	private String detail;				
	//附加数据		
	private String attach;
	//货币类型		
	private String fee_type;
	//交易起始时间	
	private String time_start;
	//交易结束时间	
	private String time_expire;
	//商品标记		
	private String goods_tag;
	
	public static String[] CDATA_TAG = {"^attach","^body","^sign"};
	
	public UnifiedOrderRequest(String appid,String mch_id,String nonce_str,String sign,String body, String out_trade_no,
			Integer total_fee, String spbill_create_ip, String notify_url,
			TradeType trade_type) {
		super();
		this.appid = appid;
		this.mch_id = mch_id;
		this.nonce_str = nonce_str;
		this.sign = sign;
		this.body = body;
		this.out_trade_no = out_trade_no;
		this.total_fee = total_fee;
		this.spbill_create_ip = spbill_create_ip;
		this.notify_url = notify_url;
		this.trade_type = trade_type;
	}
	public UnifiedOrderRequest() {
		super();
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
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
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}
	public String getNotify_url() {
		return notify_url;
	}
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public TradeType getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(TradeType trade_type) {
		this.trade_type = trade_type;
	}
	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public String getFee_type() {
		return fee_type;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	public String getTime_start() {
		return time_start;
	}
	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}
	public String getTime_expire() {
		return time_expire;
	}
	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}
	public String getGoods_tag() {
		return goods_tag;
	}
	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getSub_openid() {
		return sub_openid;
	}
	public void setSub_openid(String sub_openid) {
		this.sub_openid = sub_openid;
	}	
	
	
}
