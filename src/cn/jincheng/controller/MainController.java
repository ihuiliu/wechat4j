package cn.jincheng.controller;

import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.sword.wechat4j.common.Config;
import org.sword.wechat4j.pay.Manage;
import org.sword.wechat4j.pay.PayUtils;
import org.sword.wechat4j.pay.TradeType;
import org.sword.wechat4j.pay.exception.WeChatPayException;
import org.sword.wechat4j.pay.request.UnifiedOrderRequest;
import org.sword.wechat4j.pay.response.UnifiedOrderResponse;

import cn.jincheng.OauthManger;
import cn.jincheng.OauthResponse;
import cn.jincheng.domain.PayJsapi;
import cn.jincheng.domain.Person;

@Controller
public class MainController {
	
	@RequestMapping("/index.action")
    public ModelAndView toIndex() {
	 ModelAndView model=new ModelAndView();
	 model.setViewName("index");
        return model;
    }
	@RequestMapping("/show.action")
    public ModelAndView toShow() {
	 ModelAndView model=new ModelAndView();
	 model.setViewName("show");
        return model;
    }
	/*@RequestMapping("/booking2.action")
    public @ResponseBody ModelAndView toBooking2(String name,String phone,String tolTic,String time,String total) {
		//System.out.println(name+"-"+phone+"-"+tolTic+"-"+time+"-"+total);
	 ModelAndView model=new ModelAndView();
	 model.setViewName("booking");
        return model;
    }*/
	@RequestMapping("/toBooking.action")
    public @ResponseBody ModelAndView toBooking(String code) {
	 ModelAndView model=new ModelAndView();
	 model.addObject("code", code);
	 System.out.println("-----------------code--------------"+code);
	 model.setViewName("booking");
     return model;
    }
	/*@RequestMapping("/booking.action")
    public @ResponseBody Person toBooking(@RequestBody Person person) {
		System.out.println("----------");
		Person person=new Person();
		person.setName(name);
		person.setPhone(phone);
		System.out.println(person);
	 //ModelAndView model=new ModelAndView();
	// model.setViewName("booking");
        return person;
    }*/
	@RequestMapping("/booking.action")
	public @ResponseBody PayJsapi bookIng(HttpServletRequest request,String code,String name,String phone,String tolTic,String detail,String status,String ka){
		PayJsapi jsapi=new PayJsapi();
		UnifiedOrderRequest  orderRequest=new UnifiedOrderRequest();
		//String code=request.getParameter("code");
		OauthManger manger=new OauthManger();
		String ret=manger.getOpenid(code);
		OauthResponse oauthResponse=(OauthResponse) JSONObject.toBean(JSONObject.fromObject(ret),OauthResponse.class);
		System.out.println("------------------"+oauthResponse);
		//orderRequest.setAppid("wx5b7493d652383835");
		//orderRequest.setMch_id("1320087901");
		orderRequest.setDevice_info("WEB");
		//orderRequest.setNonce_str("5K8264ILTKCH16CQ2502SI8ZNMTM67VS");
		//orderRequest.setSign("C380BEC2BFD727A4B6845133519F3AD6");
		if("1".equals(status)){
			orderRequest.setBody("金诚太悦温泉门票"+tolTic+"张");
		}else{
			if("1".equals(ka)){
				orderRequest.setBody("金诚太悦温泉普通卡");
			}else if("2".equals(ka)){
				orderRequest.setBody("金诚太悦温泉金卡");
			}else if("3".equals(ka)){
				orderRequest.setBody("白金卡");
			}else if("4".equals(ka)){
				orderRequest.setBody("钻石卡");
			}else if("5".equals(ka)){
				orderRequest.setBody("至尊卡");
			}else if("6".equals(ka)){
				orderRequest.setBody("顶级至尊卡");
			}
			
		}
		orderRequest.setDetail(detail);
		orderRequest.setAttach("无锡太岳");
		orderRequest.setOut_trade_no(PayUtils.getOut_trade_no());
		orderRequest.setFee_type("CNY");
		orderRequest.setTotal_fee(1);
		orderRequest.setSpbill_create_ip(request.getRemoteAddr());
		orderRequest.setTime_start(PayUtils.getTime_start());
		orderRequest.setTime_expire(PayUtils.getTime_expire());
		//orderRequest.setGoods_tag("");
		orderRequest.setNotify_url("http://wxpay.gold-finance.com.cn/wechat4j/PayBackServlet");
		orderRequest.setTrade_type(TradeType.JSAPI);
		//orderRequest.setProduct_id("");
		orderRequest.setOpenid(oauthResponse.getOpenid());
		Manage  manage=new Manage();
		try {
			 UnifiedOrderResponse unifiedOrderResponse= manage.payUnifiedOrder(orderRequest);
			 System.out.println(unifiedOrderResponse);
			 request.setAttribute("unifiedOrderResponse", unifiedOrderResponse);
			String json= manage.getJsWxPayParam(unifiedOrderResponse.getPrepay_id());
			json=json.replaceAll("\"", "\'");
			json=json.substring(1, json.length()-1);
			
			SortedMap<String, String> finalpackage = new TreeMap<String, String>();
			finalpackage.put("appId", Config.instance().getAppid());
			// 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
			finalpackage.put("timeStamp", PayUtils.getTimeStamp()); 
			// 支付签名随机串，不长于 32 位
			finalpackage.put("nonceStr", PayUtils.getNonceStr()); 
			// 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
			finalpackage.put("package", "prepay_id=" + unifiedOrderResponse.getPrepay_id()); 
			// 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
			finalpackage.put("signType", "MD5");
			// 支付签名
			finalpackage.put("paySign", PayUtils.createSign(finalpackage)); 
			
			/*modelAndView.addObject("appId",  Config.instance().getAppid());
			modelAndView.addObject("timeStamp", finalpackage.get("timeStamp"));
			modelAndView.addObject("nonceStr",  finalpackage.get("nonceStr"));
			modelAndView.addObject("package1", finalpackage.get("package"));
			modelAndView.addObject("signType", "MD5");
			modelAndView.addObject("paySign", finalpackage.get("paySign"));*/
			jsapi.setAppId(Config.instance().getAppid());
			jsapi.setTimeStamp(finalpackage.get("timeStamp"));
			jsapi.setNonceStr(finalpackage.get("nonceStr"));
			jsapi.setPackage1(finalpackage.get("package"));
			jsapi.setSignType("MD5");
			jsapi.setPaySign(finalpackage.get("paySign"));
			return jsapi;
			
		} catch (WeChatPayException e) {
			e.printStackTrace();
		}
		return jsapi;
	}

}
