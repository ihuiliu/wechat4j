package org.sword.wechat4j.pay.request;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
public class MicropayRequest extends BasicPayRequest{

	//商品描述
	private String body;
	//商户订单号
	private String out_trade_no;
	//总金额 单位：分
	private Integer total_fee;
	//终端IP
	private String spbill_create_ip;
	//授权码
	private String auth_code;
	
	//设备号
	private String device_info;
	//商品详情		
	private String detail;				
	//附加数据		
	private String attach;
	//货币类型		
	private String fee_type;
	//商品标记		
	private String goods_tag;
	//指定支付方式	
	private String limit_pay;
	
	public static String[] CDATA_TAG = {};
	
	public MicropayRequest(String appid,String mch_id,String nonce_str,String sign,String body, String out_trade_no,
			Integer total_fee, String spbill_create_ip, String notify_url,String auth_code) {
		super();
		this.appid = appid;
		this.mch_id = mch_id;
		this.nonce_str = nonce_str;
		this.sign = sign;
		this.body = body;
		this.out_trade_no = out_trade_no;
		this.total_fee = total_fee;
		this.spbill_create_ip = spbill_create_ip;
		this.auth_code=auth_code;
	}
	public MicropayRequest() {
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
	public String getGoods_tag() {
		return goods_tag;
	}
	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}
	public String getAuth_code() {
		return auth_code;
	}
	public void setAuth_code(String auth_code) {
		this.auth_code = auth_code;
	}
	public String getLimit_pay() {
		return limit_pay;
	}
	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}
	
}
