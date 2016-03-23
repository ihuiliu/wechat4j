package cn.jincheng;

import org.sword.wechat4j.pay.Manage;

public class Demo2 {
	public static void main(String[] args) {
		Manage manage=new Manage();
		String s=manage.getJsWxPayParam("1234");
		System.out.println("--------------"+s.substring(1, s.length()-1));
	}
	
	

}
