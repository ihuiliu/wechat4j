package org.sword.wechat4j.pay;

import java.io.IOException;
import java.util.SortedMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.sword.lang.JaxbParser;
import org.sword.lang.StreamUtils;
import org.sword.wechat4j.pay.exception.WeChatPayException;
import org.sword.wechat4j.pay.request.UnifiedOrderRequest;
import org.sword.wechat4j.pay.response.UnifiedOrderResponse;

public abstract class Native {
	Logger logger = Logger.getLogger(Native.class);
	
	public String execute(HttpServletRequest request){
		String postDataStr = null;
		try{
			postDataStr = StreamUtils.streamToString(request.getInputStream(),"UTF-8");
		} catch (IOException e) {
			logger.error("post data deal failed!");
			e.printStackTrace();
		}
		logger.info("parse post data:" + postDataStr);
		UnifiedOrderRequest unifiedOrderRequest=null;
		JaxbParser jaxbParser = new JaxbParser(NativeInput.class);
		try {
			NativeInput nativeInput = (NativeInput)jaxbParser.toObj(postDataStr);
			unifiedOrderRequest = callback(nativeInput);
		} catch (Exception e) {
			logger.error("post data parse error");
			e.printStackTrace();
		}
		Manage manage = new Manage();
		NativeOutput nativeOutput = new NativeOutput();
		try {
			UnifiedOrderResponse unifiedOrderResponse = manage.payUnifiedOrder(unifiedOrderRequest);
			String returnCode = unifiedOrderResponse.getReturn_code();
			nativeOutput.setReturnCode(returnCode);
			nativeOutput.setReturnMsg(unifiedOrderResponse.getReturn_msg());
			if ("SUCCESS".equals(returnCode)) {
				nativeOutput.setAppid(unifiedOrderResponse.getAppid());
				nativeOutput.setMch_id(unifiedOrderResponse.getMch_id());
				nativeOutput.setErrCodeDes(unifiedOrderResponse.getErr_code_des());
				String resultCode = unifiedOrderResponse.getResult_code();
				nativeOutput.setResultCode(resultCode);
				if ("SUCCESS".equals(resultCode)) {
					nativeOutput.setPrepayId(unifiedOrderResponse.getPrepay_id());					
				}
				nativeOutput.setNonce_str(PayUtils.getNonceStr());
				SortedMap<String, String> parameters = PayUtils.toSortedMap(nativeOutput, true);
				nativeOutput.setSign(PayUtils.createSign(parameters));				
			}
		} catch (WeChatPayException e) {
			e.printStackTrace();
		}
		jaxbParser.setCdataNode(NativeOutput.CDATA_TAG);
		String result = jaxbParser.toXML(nativeOutput);
		return result;
	}
	
	public abstract UnifiedOrderRequest callback(NativeInput nativeInput);
}
