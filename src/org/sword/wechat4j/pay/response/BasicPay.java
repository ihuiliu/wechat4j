package org.sword.wechat4j.pay.response;

public class BasicPay {
	//字段名		变量名		必填	类型			示例值		描述	
	//返回状态码		
	protected String return_code;//		是	String(16)	SUCCESS		SUCCESS/FAIL	此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
	//返回信息		
	protected String return_msg;//		否	String(128)	签名失败	 	返回信息，如非空，为错误原因	签名失败	参数格式校验错误
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
	
}
