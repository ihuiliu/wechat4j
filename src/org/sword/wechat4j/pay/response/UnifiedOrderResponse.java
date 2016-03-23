package org.sword.wechat4j.pay.response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 统一下单结果
 * @author Zhangxs
 * @date 2015-7-19 
 * @version
 */
@XmlRootElement(name="xml")
public class UnifiedOrderResponse extends BasicPaySuccess {


	//以下字段在return_code 和result_code都为SUCCESS的时候有返回
	//字段名			变量名		必填		类型			示例值									描述
	//交易类型			
	private String trade_type;//	是		String(16)	JSAPI									调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP，详细说明见参数规定
	//预支付交易会话标识	
	private String prepay_id;//	是		String(64)	wx201410272009395522657a690389285100	微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
	//二维码链接			
	private String code_url;//	否		String(64)	URl：weixin://wxpay/s/An4baqw			trade_type为NATIVE是有返回，可将该参数值生成二维码展示出来进行扫码支付

	/*返回结果 		
	字段名			变量名		必填		类型			示例值									描述		
	返回状态码			return_code	是		String(16)	SUCCESS									SUCCESS/FAIL 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
	返回信息			return_msg	否		String(128)	签名失败									返回信息，如非空，为错误原因	签名失败		参数格式校验错误

	以下字段在return_code为SUCCESS的时候有返回
	字段名			变量名		必填		类型			示例值									描述
	公众账号ID		appid		是		String(32)	wx8888888888888888						调用接口提交的公众账号ID
	商户号			mch_id		是		String(32)	1900000109								调用接口提交的商户号 
	设备号 			device_info	否		String(32)	013467007045764							调用接口提交的终端设备号，
	随机字符串			nonce_str	是		String(32)	5K8264ILTKCH16CQ2502SI8ZNMTM67VS		微信返回的随机字符串
	签名				sign		是		String(32)	C380BEC2BFD727A4B6845133519F3AD6		微信返回的签名，详见签名算法
	业务结果			result_code	是		String(16)	SUCCESS									SUCCESS/FAIL
	错误代码			err_code	否		String(32)	SYSTEMERROR								详细参见第6节错误列表
	错误代码描述		err_code_des否		String(128)	系统错误									错误返回的信息描述

	以下字段在return_code 和result_code都为SUCCESS的时候有返回
	字段名			变量名		必填		类型			示例值									描述
	交易类型			trade_type	是		String(16)	JSAPI									调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP，详细说明见参数规定
	预支付交易会话标识	prepay_id	是		String(64)	wx201410272009395522657a690389285100	微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
	二维码链接			code_url	否		String(64)	URl：weixin://wxpay/s/An4baqw			trade_type为NATIVE是有返回，可将该参数值生成二维码展示出来进行扫码支付
*/
	/*
	 错误码
	名称		 				描述 					原因						解决方案
	NOAUTH					商户无此接口权限		商户未开通此接口权限			请商户前往申请此接口权限
	NOTENOUGH				余额不足				用户帐号余额不足			用户帐号余额不足，请用户充值或更换支付卡后再支付
	ORDERPAID				商户订单已支付			商户订单已支付，无需重复操作	商户订单已支付，无需更多操作
	ORDERCLOSED				订单已关闭				当前订单已关闭，无法支付		当前订单已关闭，请重新下单
	SYSTEMERROR				系统错误				系统超时					系统异常，请用相同参数重新调用
	APPID_NOT_EXIST			APPID不存在			参数中缺少APPID			请检查APPID是否正确
	MCHID_NOT_EXIST			MCHID不存在			参数中缺少MCHID			请检查MCHID是否正确
	APPID_MCHID_NOT_MATCH	appid和mch_id不匹配	appid和mch_id不匹配		请确认appid和mch_id是否匹配
	LACK_PARAMS				缺少参数				缺少必要的请求参数			请检查参数是否齐全
	OUT_TRADE_NO_USED		商户订单号重复			同一笔交易不能多次提交		请核实商户订单号是否重复提交
	SIGNERROR				签名错误				参数签名结果不正确			请检查签名参数和方法是否都符合签名算法要求
	XML_FORMAT_ERROR		XML格式错误			XML格式错误				请检查XML参数格式是否正确
	REQUIRE_POST_METHOD		请使用post方法			未使用post传递参数 			请检查请求参数是否通过post方法提交
	POST_DATA_EMPTY			post数据为空			post数据不能为空			请检查post数据是否为空
	NOT_UTF8				编码格式错误			未使用指定编码格式			请使用NOT_UTF8编码格式*/

	
	public String getReturn_code() {
		return return_code;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	public String getReturn_msg() {
		return return_msg;
	}
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getPrepay_id() {
		return prepay_id;
	}
	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}
	public String getCode_url() {
		return code_url;
	}
	public void setCode_url(String code_url) {
		this.code_url = code_url;
	}

	
	
}
