package org.sword.wechat4j.pay;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.sword.wechat4j.pay.request.BasicPayRequest;
/**
 * 回调支付输入参数
 * @author Zhangxs
 * @date 2015-8-18 
 * @version
 */
@XmlRootElement(name="xml")
public class NativeInput extends BasicPayRequest{
	//用户标识	
	private String openid;//	String(128)	是	o8GeHuLAsgefS_80exEr1cTqekUs	用户在商户appid下的唯一标识
	//是否关注公众账号	
	private String isSubscribe;//	String(1)	是	Y	用户是否关注公众账号，仅在公众账号类型支付有效，取值范围：Y或N;Y-关注;N-未关注
	//商品ID	
	private String productId;//	String(32)	是	88888	商户定义的商品id 或者订单号
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	@XmlElement(name="is_subscribe")
	public String getIsSubscribe() {
		return isSubscribe;
	}
	public void setIsSubscribe(String isSubscribe) {
		this.isSubscribe = isSubscribe;
	}
	@XmlElement(name="product_id")
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
}
