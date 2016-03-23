package org.sword.wechat4j.pay;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.lang3.ArrayUtils;
import org.sword.wechat4j.common.Config;
import org.sword.wechat4j.pay.request.UnifiedOrderRequest;
import org.sword.wechat4j.util.MD5Util;

public class PayUtils {
	public static void main(String[] args) {
		UnifiedOrderRequest unifiedOrderRequest = new UnifiedOrderRequest();
		unifiedOrderRequest.setAttach("aosndfoiadnf");
		unifiedOrderRequest.setAppid("12");
		Map<String, String> toMap = toSortedMap(unifiedOrderRequest,true);
		System.out.println(toMap.toString());
	}
	
//	签名算法
	public static String createSign(SortedMap<String, String> parameters) {
		StringBuffer sb = new StringBuffer();
		Set<Entry<String, String>> es = parameters.entrySet();
		Iterator<Entry<String, String>> it = es.iterator();
		//将集合M内非空参数值的参数按照参数名ASCII码从小到大排序（字典序）
		while (it.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
			String k = entry.getKey();
			String v = entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
				//使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串
				sb.append(k + "=" + v + "&");
			}
		}
		//在字符串最后拼接上key=(API密钥的值)得到stringSignTemp字符串，
		sb.append("key="+ Config.instance().getPartnerKey());
		System.out.println("md5 sb:" + sb);
		//对stringSignTemp进行MD5运算，再将得到的字符串所有字符转换为大写，得到sign值signValue。
		String sign = MD5Util.MD5Encode(sb.toString(), "UTF-8").toUpperCase();
		System.out.println("packge签名:" + sign);
		return sign;
	}
	
	/**
	 * 将对象转换为Map
	 * @param javaBean
	 * @param includeParentClass 是否包含父类属性
	 * @return
	 */
	public static SortedMap<String, String> toSortedMap(Object javaBean,boolean includeParentClass) {
		SortedMap<String, String> result = new TreeMap<String, String>();
		Method[] methods = javaBean.getClass().getDeclaredMethods();
		if (includeParentClass) {
			Class<?> superclass = javaBean.getClass().getSuperclass();
			while (superclass!=null && !superclass.isAssignableFrom(Object.class)) {
				methods = ArrayUtils.addAll(methods, superclass.getDeclaredMethods());
				superclass=superclass.getSuperclass();
			}
		}
		for (Method method : methods) {
			try {
				if (method.getName().startsWith("get")) {
					String field = method.getName();
					field = field.substring(field.indexOf("get") + 3);
					field = field.toLowerCase().charAt(0) + field.substring(1);
					Object value = method.invoke(javaBean, (Object[]) null);
					//result.put(field, null == value ? "" : value.toString());
					if (null != value) {
						result.put(field,value.toString());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	/**
	 * 拼接字符串
	 * 将参数拼接成key1=value1&key2=value2格式
	 * @param parameters
	 * @return
	 */
	public static String spliceString(SortedMap<String, String> parameters){
		StringBuffer sb = new StringBuffer();
		Set<Entry<String, String>> es = parameters.entrySet();
		Iterator<Entry<String, String>> it = es.iterator();
		//将集合M内非空参数值的参数按照参数名ASCII码从小到大排序（字典序）
		while (it.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
			String k = entry.getKey();
			String v = entry.getValue();
			if (null != v && !"".equals(v)) {
				//使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串
				sb.append(k + "=" + v + "&");
			}
		}
		String str = sb.toString();
		str = str.substring(0, str.length()-1);
		return str;
	}
	/**
	 * 取出一个指定长度大小的随机正整数.
	 * 
	 * @param length
	 *            int 设定所取出随机数的长度。length小于11
	 * @return int 返回生成的随机数。
	 */
	public static int buildRandom(int length) {
		int num = 1;
		double random = Math.random();
		if (random < 0.1) {
			random = random + 0.1;
		}
		for (int i = 0; i < length; i++) {
			num = num * 10;
		}
		return (int) ((random * num));
	}

	
	/**
	 * 获取当前时间 yyyyMMddHHmmss
	 * @return String
	 */ 
	public static String getCurrTime() {
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = outFormat.format(now);
		return s;
	}
	/**
	 * 获取当前时间 下单时间
	 * @return String
	 */ 
	public static String getTime_start() {
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = outFormat.format(now);
		return s;
	}
	
	/**
	 * 获取当前时间 失效时间
	 * @return String
	 */ 
	public static String getTime_expire() {
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.MINUTE, 5);
		//Date now = new Date();
		//now.
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = outFormat.format(calendar.getTime());
		return s;
	}
	
	/**
	 * 时间格式化
	 * @param date
	 * @return String
	 */
	public static String formatDate(Date date) {
		return formatDate(date, "yyyyMMdd");
	}
	/**
	 * 时间格式化
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date,String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String strDate = formatter.format(date);
		return strDate;
	}
	/**
	 * 获取unix时间，从1970-01-01 00:00:00开始的秒数
	 * @param date
	 * @return long
	 */
	public static long getUnixTime(Date date) {
		if( null == date ) {
			return 0;
		}
		return date.getTime()/1000;
	}
	/**
	 * 将UNIX时间戳转换成系统可以处理的时间
	 * @param unixTime
	 * @return
	 */
	public static Date unixtime2Date(long unixTime){
		return new Date(unixTime * 1000L);
	}
	/**
	 * 获取当前时间戳(单位:秒)
	 * @return
	 */
	public static String getTimeStamp() {
		return String.valueOf(System.currentTimeMillis() / 1000);
	}
	/**
	 * 获取随机字符串
	 * @return
	 */
	public static String getNonceStr() {
		Random random = new Random();
		return MD5Util.MD5Encode(String.valueOf(random.nextInt(10000)), "UTF-8");
	}
	/**
	 * 获取指定长度的随机串
	 */
	public static String getRandomString(int length) { //length表示生成字符串的长度  
//	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";   
		String base = "0123456789";
	    Random random = new Random();     
	    StringBuffer sb = new StringBuffer();     
	    for (int i = 0; i < length; i++) {     
	        int number = random.nextInt(base.length());     
	        sb.append(base.charAt(number));     
	    }     
	    return sb.toString();     
	 }   
/**
 * 获取指定长度的随机串纯数字
 */
public static String getRandomIntString(int length) { //length表示生成字符串的长度  
    String base = "0123456789";     
    Random random = new Random();     
    StringBuffer sb = new StringBuffer();     
    for (int i = 0; i < length; i++) {     
        int number = random.nextInt(base.length());     
        sb.append(base.charAt(number));     
    }     
    return sb.toString();     
 }   
/**
 * 获取指定长度的订单号
 */
public static String getOut_trade_no() { //length表示生成字符串的长度  
    String base = "0123456789abcdefghijklmnopqrstuvwxyz";     
    Random random = new Random();  
    String time=getCurrTime();
    StringBuffer sb = new StringBuffer();   
    sb.append(time);
    for (int i = 0; i <6; i++) {     
        int number = random.nextInt(base.length());     
        sb.append(base.charAt(number));     
    }     
    return sb.toString();     
 }   


	/**
	 * 元转换成分
	 * @param money
	 * @return
	 */
	public static String getMoney(String amount) {
		if(amount==null){
			return "";
		}
		// 金额转化为分为单位
		String currency =  amount.replaceAll("\\$|\\￥|\\,", "");  //处理包含, ￥ 或者$的金额  
        int index = currency.indexOf(".");  
        int length = currency.length();  
        Long amLong = 0l;  
        if(index == -1){  
            amLong = Long.valueOf(currency+"00");  
        }else if(length - index >= 3){  
            amLong = Long.valueOf((currency.substring(0, index+3)).replace(".", ""));  
        }else if(length - index == 2){  
            amLong = Long.valueOf((currency.substring(0, index+2)).replace(".", "")+0);  
        }else{  
            amLong = Long.valueOf((currency.substring(0, index+1)).replace(".", "")+"00");  
        }  
        return amLong.toString(); 
	}

}
