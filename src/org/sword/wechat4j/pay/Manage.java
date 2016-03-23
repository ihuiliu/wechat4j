package org.sword.wechat4j.pay;

import java.io.UnsupportedEncodingException;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.sword.lang.HttpUtils;
import org.sword.lang.JaxbParser;
import org.sword.wechat4j.common.Config;
import org.sword.wechat4j.common.WechatUrl;
import org.sword.wechat4j.pay.exception.WeChatPayException;
import org.sword.wechat4j.pay.request.BasicPayRequest;
import org.sword.wechat4j.pay.request.CloseOrderRequest;
import org.sword.wechat4j.pay.request.DownloadBillRequest;
import org.sword.wechat4j.pay.request.MicropayRequest;
import org.sword.wechat4j.pay.request.PayRefundRequest;
import org.sword.wechat4j.pay.request.QueryOrderRequest;
import org.sword.wechat4j.pay.request.QueryRefundRequest;
import org.sword.wechat4j.pay.request.ShortUrlRequest;
import org.sword.wechat4j.pay.request.UnifiedOrderRequest;
import org.sword.wechat4j.pay.response.CloseOrderResponse;
import org.sword.wechat4j.pay.response.DownloadBillResponse;
import org.sword.wechat4j.pay.response.MicropayResponse;
import org.sword.wechat4j.pay.response.PayRefundResponse;
import org.sword.wechat4j.pay.response.QueryOrderResponse;
import org.sword.wechat4j.pay.response.QueryRefundResponse;
import org.sword.wechat4j.pay.response.ShortUrlResponse;
import org.sword.wechat4j.pay.response.UnifiedOrderResponse;

import com.alibaba.fastjson.JSON;

public class Manage {
	private static Logger logger = Logger.getLogger(Manage.class);
	
	//转换短链接
	private static final String SHORTURL = "https://api.mch.weixin.qq.com/tools/shorturl";
	//转换短链接
	public ShortUrlResponse longToShort(ShortUrlRequest shortUrlRequest,String key) throws UnsupportedEncodingException{
		payBasic(shortUrlRequest);
		JaxbParser jaxbParser = new JaxbParser(ShortUrlResponse.class);
//		jaxbParser.setCdataNode(ShortUrlRequest.CDATA_TAG);
		String data = jaxbParser.toXML(shortUrlRequest);
		String resultXmlStr = HttpUtils.post(SHORTURL, data);
		System.out.println(resultXmlStr);
		ShortUrlResponse shortUrlResponse = (ShortUrlResponse)jaxbParser.toObj(resultXmlStr);
		return shortUrlResponse;
	}
	//下载对账单
	public String downlodbill(DownloadBillRequest downloadBillRequest,String key) {
		payBasic(downloadBillRequest);
		JaxbParser jaxbParser = new JaxbParser(DownloadBillResponse.class);
		jaxbParser.setCdataNode(DownloadBillRequest.CDATA_TAG);
		String data = jaxbParser.toXML(downloadBillRequest);
		String resultXmlStr = HttpUtils.post(WechatUrl.PAY_DOWNLOADBILL, data);
//		try {
//			DownloadBillResponse downloadBillResponse = (DownloadBillResponse)jaxbParser.toObj(resultXmlStr);
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return resultXmlStr;
	}
	
	//统一下单
	public UnifiedOrderResponse payUnifiedOrder(UnifiedOrderRequest unified) throws WeChatPayException{
		payBasic(unified);
		JaxbParser jaxbParser = new JaxbParser(UnifiedOrderResponse.class);
		jaxbParser.setCdataNode(UnifiedOrderRequest.CDATA_TAG);
		String data = jaxbParser.toXML(unified);
		String resultXmlStr = HttpUtils.post(WechatUrl.PAY_UNIFIEDORDER, data);
		System.out.println(resultXmlStr);
//		在这里应该加一个异常判断
		UnifiedOrderResponse unifiedOrderResponse = null;
		try {
			unifiedOrderResponse = (UnifiedOrderResponse)jaxbParser.toObj(resultXmlStr);
			//返回状态码
			if ("FAIL".equals(unifiedOrderResponse.getReturn_code())) {
				//返回信息
				String errMsg = unifiedOrderResponse.getReturn_msg();
				//异常
				throw new WeChatPayException("异常说明:"+errMsg);
			}
			//业务结果
			if ("FAIL".equals(unifiedOrderResponse.getResult_code())) {
				String errCode = unifiedOrderResponse.getErr_code();//错误代码
				String errCodeDes = unifiedOrderResponse.getErr_code_des();//错误代码描述
				//异常
				throw new WeChatPayException("异常码:"+errCode+";异常说明:"+errCodeDes);
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return unifiedOrderResponse;
	}
	//刷卡支付
	public MicropayResponse micropayOrder(MicropayRequest micropay){
		payBasic(micropay);
		JaxbParser jaxbParser = new JaxbParser(MicropayResponse.class);
		jaxbParser.setCdataNode(UnifiedOrderRequest.CDATA_TAG);
		String data = jaxbParser.toXML(micropay);
		String resultXmlStr = HttpUtils.post(WechatUrl.PAY_MICROPAY, data);
		System.out.println(resultXmlStr);
		//在这里应该加一个异常判断
		MicropayResponse micropayResponse = null;
		try {
			micropayResponse = (MicropayResponse)jaxbParser.toObj(resultXmlStr);
			//返回状态码
			if ("FAIL".equals(micropayResponse.getReturn_code())) {
				//返回信息
				micropayResponse.getReturn_msg();
				//异常
			}
			//业务结果
			if ("FAIL".equals(micropayResponse.getResult_code())) {
				micropayResponse.getErr_code_des();//错误代码描述
				micropayResponse.getErr_code();//错误代码
				//异常
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return micropayResponse;
	}
	//公众号支付方式
	public String getJsWxPayParam(String body,String out_trade_no,int total_fee ,String notity_url) throws WeChatPayException{
		UnifiedOrderRequest unifiedOrderRequest = new UnifiedOrderRequest();
//		unifiedOrderRequest.setAppid(appid);
//		unifiedOrderRequest.set...
		UnifiedOrderResponse unifiedOrderResponse = payUnifiedOrder(unifiedOrderRequest);
		String prepayId = getPrepayId(unifiedOrderResponse);
		return getJsWxPayParam(prepayId);
	}
	/**
	 * 获取预支付Id;
	 */
	public String getPrepayId(UnifiedOrderResponse unifiedOrderResponse) {
		String return_code = unifiedOrderResponse.getReturn_code();
		if ("FAIL".equals(return_code)) {
			try {
				throw new Exception(unifiedOrderResponse.getReturn_msg());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String result_code = unifiedOrderResponse.getResult_code();
		if ("FAIL".equals(result_code)) {
			try {
				throw new Exception(unifiedOrderResponse.getErr_code_des());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String prepay_id = unifiedOrderResponse.getPrepay_id();
		return prepay_id;
	}
	/**
	 * 扫码支付（模式一）
	 * @param productId  商户定义的商品id 或者订单号
	 * @return
	 */
	public String bizpayurl(String productId){
		SortedMap<String, String> parameters = new TreeMap<String, String>();
		//公众账号ID	appid	String(32)
		parameters.put("appid",Config.instance().getAppid());
		//商户号	mch_id	String(32)
		parameters.put("mch_id", Config.instance().getPartnerid());
		//商品ID	product_id	String(32)
		parameters.put("product_id", productId);
		//时间戳	time_stamp	String(10)
		parameters.put("time_stamp", PayUtils.getTimeStamp());
		//随机字符串	nonce_str	String(32)
		parameters.put("nonce_str", PayUtils.getNonceStr());
		//签名	sign	String(32)
		parameters.put("sign", PayUtils.createSign(parameters));
		String parametersStr = PayUtils.spliceString(parameters);
		
		StringBuilder sb = new StringBuilder();
		sb.append("weixin://wxpay/bizpayurl?");
		sb.append(parametersStr);
		return sb.toString();
	}
	/**
	 * 扫码支付(模式二)
	 * 注意:有效期两小时
	 * @param unifiedOrderResponse
	 * @return
	 */
	public String getCodeUrl(UnifiedOrderResponse unifiedOrderResponse) {
		String return_code = unifiedOrderResponse.getReturn_code();
		if ("FAIL".equals(return_code)) {
			try {
				throw new Exception(unifiedOrderResponse.getReturn_msg());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String result_code = unifiedOrderResponse.getResult_code();
		if ("FAIL".equals(result_code)) {
			try {
				throw new Exception(unifiedOrderResponse.getErr_code_des());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String codeUrl = unifiedOrderResponse.getCode_url();
		return codeUrl;
	}	
	/**
	 * JS微信支付
	 * 获取js微信支付所需的参数
	 * @param prepayId  预支付Id
	 * @return
	 */
	public String getJsWxPayParam(String prepayId){
		SortedMap<String, String> finalpackage = new TreeMap<String, String>();
		finalpackage.put("appId", Config.instance().getAppid());
		// 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
		finalpackage.put("timeStamp", PayUtils.getTimeStamp()); 
		// 支付签名随机串，不长于 32 位
		finalpackage.put("nonceStr", PayUtils.getNonceStr()); 
		// 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
		finalpackage.put("package", "prepay_id=" + prepayId); 
		// 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
		finalpackage.put("signType", "MD5");
		// 支付签名
		finalpackage.put("paySign", PayUtils.createSign(finalpackage)); 
		//前台参数中不需要appId 将其移除
		//finalpackage.remove("appId");
		return JSON.toJSONString(finalpackage);
	}
	/**
	 * App微信支付
	 * 获取App微信支付所需的参数
	 * @param prepayId  预支付Id
	 * @return
	 */
	public String getAppPayParam(String prepayId){
		SortedMap<String, String> finalpackage = new TreeMap<String, String>();
		//公众账号ID	appid	String(32)
		finalpackage.put("appid", Config.instance().getAppid());
		//商户号	partnerid	String(32)
		finalpackage.put("partnerid", Config.instance().getPartnerid());
		//预支付交易会话ID	prepayid	String(32)
		finalpackage.put("prepayid", prepayId);
		//扩展字段	package	String(128)暂填写固定值Sign=WXPay
		finalpackage.put("package", "Sign=WXPay");
		//随机字符串	noncestr	String(32)
		finalpackage.put("noncestr", PayUtils.getNonceStr()); 
		//时间戳	timestamp	String(10)
		finalpackage.put("timestamp", PayUtils.getTimeStamp()); 
		//签名	sign	String(32)	是
		finalpackage.put("sign", PayUtils.createSign(finalpackage)); 
		return JSON.toJSONString(finalpackage);
	}
	//-------------------------付款通知
	
	//-------------------------退款
	/**
	 * 注意：
	 * 1、交易时间超过一年的订单无法提交退款；
	 * 2、微信支付退款支持单笔交易分多次退款，多次退款需要提交原支付订单的商户订单号和设置不同的退款单号。
	 * 		一笔退款失败后重新提交，要采用原来的退款单号。
	 * 		总退款金额不能超过用户实际支付金额。
	 * @param payResult
	 * @return
	 */
	public PayRefundResponse payResult(PayRefundRequest payRefund){
		payBasic(payRefund);
		//获取对象中所有非null属性
		JaxbParser jaxbParser = new JaxbParser(PayRefundResponse.class);
//		jaxbParser.setCdataNode(PayRefundResponse.CDATA_TAG);
		String data = jaxbParser.toXML(payRefund);
		String resultXmlStr = HttpUtils.clientCustomSSL(WechatUrl.PAY_REFUND, data, Config.instance().getRefundCertificatePath(), Config.instance().getRefundCertificatePath());
		PayRefundResponse payRefundResponse = null;
		try {
			payRefundResponse = (PayRefundResponse) jaxbParser.toObj(resultXmlStr);
			if (payRefundResponse.getReturn_code()!="SUCCESS") {
				//返回信息
				payRefundResponse.getReturn_msg();
				//异常
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return payRefundResponse;
	}
	//-------------------------查询
	/**
	 * 查询订单
	 * @param queryOrder
	 * @return
	 */
	public QueryOrderResponse queryOrder(QueryOrderRequest queryOrder){
		payBasic(queryOrder);
		JaxbParser jaxbParser = new JaxbParser(UnifiedOrderResponse.class);
		jaxbParser.setCdataNode(UnifiedOrderRequest.CDATA_TAG);
		String data = jaxbParser.toXML(queryOrder);
		String resultXmlStr = HttpUtils.post(WechatUrl.PAY_ORDERQUERY, data);
		QueryOrderResponse queryOrderResponse = null;
		try{
			queryOrderResponse = (QueryOrderResponse) jaxbParser.toObj(resultXmlStr);			
			if (queryOrderResponse.getReturn_code()!="SUCCESS") {
				//返回信息
				queryOrderResponse.getReturn_msg();
				//异常
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return queryOrderResponse;
	}
	/**
	 * 查询退款
	 * @param queryRefund
	 * @return
	 */
	public QueryRefundResponse queryRefund(QueryRefundRequest queryRefund){
		payBasic(queryRefund);
		JaxbParser jaxbParser = new JaxbParser(UnifiedOrderResponse.class);
		jaxbParser.setCdataNode(UnifiedOrderRequest.CDATA_TAG);
		String data = jaxbParser.toXML(queryRefund);
		String resultXmlStr = HttpUtils.post(WechatUrl.PAY_REFUNDQUERY, data);
		QueryRefundResponse queryRefundResponse = null;
		try{
			queryRefundResponse = (QueryRefundResponse) jaxbParser.toObj(resultXmlStr);			
			if (queryRefundResponse.getReturn_code()!="SUCCESS") {
				//返回信息
				queryRefundResponse.getReturn_msg();
				//异常
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return queryRefundResponse;
	}
	/**
	 * 关闭订单
	 * 订单生成后不能马上调用关单接口，最短调用时间间隔为5分钟
	 * @param closeOrderRequest
	 * @return
	 */
	public CloseOrderResponse closeOrder(CloseOrderRequest closeOrderRequest){
		payBasic(closeOrderRequest);
		JaxbParser jaxbParser = new JaxbParser(UnifiedOrderResponse.class);
		jaxbParser.setCdataNode(UnifiedOrderRequest.CDATA_TAG);
		String data = jaxbParser.toXML(closeOrderRequest);
		String resultXmlStr = HttpUtils.post(WechatUrl.PAY_CLOSEORDER, data);
		CloseOrderResponse closeOrderResponse = null;
		try{
			closeOrderResponse = (CloseOrderResponse) jaxbParser.toObj(resultXmlStr);			
			if (closeOrderResponse.getReturn_code()!="SUCCESS") {
				//返回信息
				closeOrderResponse.getReturn_msg();
				//异常
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return closeOrderResponse;
		
	}
	//添加支付基本信息
	private void payBasic(BasicPayRequest basicPay){
		basicPay.setAppid(Config.instance().getAppid());
		basicPay.setMch_id(Config.instance().getPartnerid());
		basicPay.setNonce_str(PayUtils.getNonceStr());
		//获取对象中所有非null属性
		SortedMap<String, String> parameters = PayUtils.toSortedMap(basicPay,true);
		//防止开发者自行设置sign参数
		parameters.remove("sign");
		//将请求参数生成签名
		String sign = PayUtils.createSign(parameters);
		basicPay.setSign(sign);
	}
}
