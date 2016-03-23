package cn.jincheng;

import org.sword.wechat4j.pay.PayUtils;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;


public class Demo {

	public static void main(String[] args) throws JSONException {
		System.out.println(PayUtils.getOut_trade_no());
		System.out.println(PayUtils.getTime_start());
		System.out.println(PayUtils.getTime_expire());
		/*String s="{\"openid\":\"OPENID\", \"scope\":\"SCOPE\"}";
		JSONObject jsonObject = new JSONObject();
		//jsonObject=jsonObject.getJSONObject(s);
		//jsonObject=jsonObject.parseObject(s);
		System.out.println(jsonObject.getString("openid"));*/
		/*// TODO Auto-generated method stub
		//getMenu();
		InputStream in=Demo.class.getClassLoader().getResourceAsStream("menu.txt");
		byte[] b=new byte[1024*4];
		
		try {
			in.read(b);
			System.out.println(new String(b));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//OutputStream outputStream=new 
*/
	}

	public static void getMenu() {
		ViewButton btn11 = new ViewButton();  
        btn11.setName("持有资产");  
        btn11.setType("view");  
        btn11.setUrl("http://daxue.easybao.com/hi/zyzc.jsp");
       
  
        ViewButton btn12 = new ViewButton();  
        btn12.setName("历史记录");  
        btn12.setType("view");  
        btn12.setUrl("http://daxue.easybao.com/hi/lsjl.jsp");
  
        ClickButton btn21 = new ClickButton();  
        btn21.setName("积分兑换");  
        btn21.setType("click");  
        btn21.setKey("reward_points");
  
        ViewButton btn22 = new ViewButton();  
        btn22.setName("预约理财师");  
        btn22.setType("view");  
        btn22.setUrl("http://daxue.easybao.com/hi/2.jsp"); 
        ClickButton btn23 = new ClickButton();  
        btn23.setName("账号绑定");  
        btn23.setType("view");  
        btn23.setKey("bind_account");
  
        ComplexButton mainBtn1 = new ComplexButton();  
        mainBtn1.setName("我的资产");  
        mainBtn1.setSub_button(new ViewButton[] { btn11, btn12 });  
  
        ComplexButton mainBtn2 = new ComplexButton();  
        mainBtn2.setName("服务");  
        mainBtn2.setSub_button(new Button[] { btn21, btn22,btn23});  
  
  
        ViewButton btn234 = new ViewButton();  
        btn234.setName("理财产品");  
        btn234.setType("view");  
        btn234.setUrl("http://daxue.easybao.com/hi/lccp.jsp"); 
       
        Menu menu = new Menu();  
        menu.setButton(new Button[] {btn234, mainBtn1, mainBtn2});  
        JSONObject jsonObject = new JSONObject();
       // String s=jsonObject.toJSONString(menu);
       // System.out.println(s);
	}

}
