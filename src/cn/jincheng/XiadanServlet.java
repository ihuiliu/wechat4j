package cn.jincheng;

import java.io.IOException;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import net.sf.json.JSONObject;

import org.sword.wechat4j.common.Config;
import org.sword.wechat4j.pay.Manage;
import org.sword.wechat4j.pay.PayUtils;
import org.sword.wechat4j.pay.TradeType;
import org.sword.wechat4j.pay.exception.WeChatPayException;
import org.sword.wechat4j.pay.request.UnifiedOrderRequest;
import org.sword.wechat4j.pay.response.UnifiedOrderResponse;


/**
 * Servlet implementation class XiadanServlet
 */
public class XiadanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XiadanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UnifiedOrderRequest  orderRequest=new UnifiedOrderRequest();
		String code=request.getParameter("code");
		OauthManger manger=new OauthManger();
		String ret=manger.getOpenid(code);
		OauthResponse oauthResponse=(OauthResponse) JSONObject.toBean(JSONObject.fromObject(ret),OauthResponse.class);
		System.out.println("------------------"+oauthResponse);
		
		
		//orderRequest.setAppid("wx5b7493d652383835");
		//orderRequest.setMch_id("1320087901");
		orderRequest.setDevice_info("WEB");
		//orderRequest.setNonce_str("5K8264ILTKCH16CQ2502SI8ZNMTM67VS");
		//orderRequest.setSign("C380BEC2BFD727A4B6845133519F3AD6");
		orderRequest.setBody("Ipad mini  16G  白色");
		orderRequest.setDetail("Ipad mini  16G  白色");
		orderRequest.setAttach("深圳分店");
		orderRequest.setOut_trade_no(PayUtils.getOut_trade_no());
		orderRequest.setFee_type("CNY");
		orderRequest.setTotal_fee(10);
		orderRequest.setSpbill_create_ip(request.getRemoteAddr());
		orderRequest.setTime_start(PayUtils.getTime_start());
		orderRequest.setTime_expire(PayUtils.getTime_expire());
		//orderRequest.setGoods_tag("");
		orderRequest.setNotify_url(" http://wxpay.gold-finance.com.cn/wechat4j/PayBackServlet");
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
			
				request.setAttribute("appId",  Config.instance().getAppid());
				request.setAttribute("timeStamp", finalpackage.get("timeStamp"));
				request.setAttribute("nonceStr",  finalpackage.get("nonceStr"));
				request.setAttribute("package1", finalpackage.get("package"));
				request.setAttribute("signType", "MD5");
				request.setAttribute("paySign", finalpackage.get("paySign"));
			
			//request.setAttribute("json", json);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (WeChatPayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
