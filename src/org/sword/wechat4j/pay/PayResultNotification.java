package org.sword.wechat4j.pay;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sword.lang.JaxbParser;
import org.sword.lang.StreamUtils;
import org.sword.wechat4j.pay.response.PayResultResponse;;
/**
 * 支付结果通知
 */
public abstract class PayResultNotification{
	
	//解析数据
	public String execute(HttpServletRequest request,HttpServletResponse response){
		PayResultResponse payResultResponse = null;
		//这里应该有个消息排重处理
		String xmlStr = null;
		try {
			xmlStr = StreamUtils.streamToString(request.getInputStream(),"UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			JaxbParser jaxbParser = new JaxbParser(PayResultResponse.class);
			payResultResponse = (PayResultResponse)jaxbParser.toObj(xmlStr);
//			if ("FAIL".equals(payResult.getReturn_code())) {
			/*if (!"SUCCESS".equals(payResultResponse.getReturn_code())) {
				//异常
			}*/
			//
		} catch (Exception e) {
			e.printStackTrace();
		}
		return onPayResult(payResultResponse);
	}
	/**
	 * 微信处理结果
	 */
	protected abstract String onPayResult(PayResultResponse payResultResponse) ;
	
	public String success(String returnCode,String returnMsg){
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		sb.append("	<return_code><![CDATA[").append(returnCode).append("]]></return_code>");
		sb.append("	<return_msg><![CDATA[").append(returnMsg).append("]]></return_msg>");
		sb.append("</xml>");
		return sb.toString();
	}
	
}