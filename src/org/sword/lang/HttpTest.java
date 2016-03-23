package org.sword.lang;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

public class HttpTest {
	public static void main(String[] args) {
		String  url ="http://hb2015.px.teacher.com.cn/home/student/2031/course/learn/2535/6/97";
		try {
//			HttpEntity entity = Request.Get(url)
//					.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
//					.setHeader("Accept-Encoding","gzip, deflate")
//					.setHeader("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
//					.setHeader("Connection","keep-alive")
//					.setHeader("Cookie","Hm_lvt_e2ce0f3627e4ac6c57da0c360ff2e1fb=1446370041; looyu_id=05ee77e86079fcefceb5ba4abcfd67f5d3_24935%3A1; c_ltype=2; c_un=120434; c_ur=i%3D8358417%26n%3D%E6%9D%8E%E8%BE%89%26e%3D%26g%3D0%26u%3D%26l%3D2015-11-12+22%3A41%3A04; c_uid=8358417; Hm_lvt_362f34c5d1545b920d58977b3bf3241c=1446902474,1447338971; CNZZDATA1256643589=2064686380-1446897829-http%253A%252F%252Fcas.teacher.com.cn%252F%7C1447334166; OEL_TP_SID=TLFK8Z-GVV4K1NOSFUL9RUBX5AY1-W0A9CWGI-B6UO; s_d0=eNqFlM1vG0UYxp3IcfyRQAsckOBQVT1wsNc7%2B%2BHdtTiQbJ3W1LGjOE6acnDHu4M9zXpntTNrEiGEEFQqCFq14usAiEoICYlIUbmEItETfwccajeceu0Bqcz4iyBRevD6nXdn5p339zw7509Q5EQhZnvNkHio7NK9o5emKY%2B0sd8MkYtD5LBmFHpyr8NYUMznOy1FBroU7EoMQaeDQskhXcnx8x3SRXnKIhf5LK%2FIqp53SBTSac7uEEKRPcoBXc8DDeQ107RsQy1Zhq5ry0ZBtYCuKGYBGIas6ctqPhVRFK4SF3m2%2FJrjD4tNC2O%2BNZUcyH8e5iUkGLEO%2F8cOZJj4kg3pCqSsMdni81nsxn3YRXOoC7GXaCPfhWHyLRLuRD5mix6fXBGtb%2BAuurwde%2Fejk7ODr68f%2FfphdUauPi8azwGQA8opRSlqoChrLziE7GDU7EEPu5ChpsPryKcMZKqGovBWkAlRy9CB0jJkQ1cBUEGhZczBIMBuJRabWX3zSu5xmpGgBcOmD3txgXGxXqrXy7Vqc7V2tlSR33gbu8XTG5WVC%2Bal3LnNTe0CqNbqK42Ktd5YvqgvbYPclrxk2VvnyrnlQqN2OuuwItA0Q1VNi4NUtCx0xglLNQCHnu3uFg1Flt9JUMzQJrHlV%2F4bLgsh9rHflnpEqg%2BnfpNqhyQKxCAThOQKN4iIF4RQ69xKG3vBP4Mqh50Ug1pQdpMhanNZym56FKxB1smMwgrqIS89mijWxBnfJTFyZjognie4lt1njhVc8rwFsZgyFJ7l6OFssJsYuXN%2BbLnZ%2Fv73%2FZtfxrkbwavd31%2FMGoqlZ5WCZalZxZR1HptAMbKfZgZ3fup%2F%2FMWDr97rH9zgiwafHfAn0K0HN%2FZvHW3Hnn3ut%2FHWr3PNanfTL1%2FLbKw1G%2FXS%2BnqtUtqz5ezT8Z3nygomm%2BS7lMOtRkWj88OINylMSDuEY1qYhOJ9hkYt0bGIU%2BN4ClAkn8ByynoMMRlO1AjHGg0RH2M7Pzwrn4npWtTysJMaw%2BYnOs45OdG29X%2FUHj%2F8oxo%2Fnn70SXpwcDg4vNq%2Ffq9%2F9Zc%2Ff%2Fixf%2FeD%2Bz%2Ffvn%2B437%2F3%2FuDb209Wh0t3NJZypnBrqEa1Wp0qYcvGU%2BBHDHtSyY%2B6NvEpo2ca4w5uDi8DZ2KXOUZ2kL84%2BVAKpmVq8RakKDbfdpsdQtncllIBhX%2FfE%2BIca3%2BduRZLDW9NwTgBFFlTtUt%2FA%2FJB9RQ%3D; hb2015=r-hb2015-2.16; Hm_lpvt_362f34c5d1545b920d58977b3bf3241c=1447339156; tq_source_page_url=http://hb2015.px.teacher.com.cn/; s_cas_tgc=Q0U3NzJBM0VFQkQyRjU1Q0NBQkU4ODNDMjRGQkVBNjYwOTdDNTUwOUUyRUZGQjMxQThENTY0OEU1RUM1MEUyNDQ2RjhGNEZCNjM3NUM0MzRFOTczNTEwQjg3REE5NTM1; s_cas_tgcv0=eNrzEElOLI4vTi0qSy2KL8lMzk4tic9MEbIwNrUwMTRPji%2BOB%2FLjE%2BPLogBCTA7e; TP_ROLE_TYPE=6; TP_ROLE_TYPE=6; c_static_ht=d8292dds21112fy965j; messageFlag_8358417=-1; messageId_8358417=5733")
//					.setHeader("Host","hb2015.px.teacher.com.cn")
//					.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:40.0) Gecko/20100101 Firefox/40.0")
//					.execute().returnResponse().getEntity();
//					System.out.println(EntityUtils.toString(entity,"UTF-8"));
//					var obj = new Object();
//			  		obj.courseId=2535;
//			  		obj.leastTime=25;
//			  		obj.learningTime=50;
//					obj.id = 12916063;
//					obj.cumulativeTime=Math.floor(TimeNum/60)+parseInt($("#cumulativeTime").val());
//					obj.onceTime=Math.floor(TimeNum/60);
//					var inputvalcode1 = $("#inputvalcode1").val();
//				   	$.ajax({
//				 		type:"POST",
//				 		url:"/home/student/2031/course/updateLearnTime",
//				 		data:{"id":12916063,"onceTime":obj.onceTime,"inputvalcode":inputvalcode1,"drawerId":97,"validateType":validateType,"token":token},
//				 	
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("id", 12916063);
					jsonObject.put("onceTime", "13");
					jsonObject.put("inputvalcode", "6158");
					jsonObject.put("drawerId", 97);
					jsonObject.put("validateType", true);
					jsonObject.put("token", "1447341569691");
					
			url="http://hb2015.px.teacher.com.cn/home/student/2035/course/updateLearnTime";
			String data =jsonObject.toJSONString();
			
			HttpEntity entity = Request.Post(url)
					.setHeader("Accept","*/*")
					.setHeader("Accept-Encoding","gzip, deflate")
					.setHeader("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
					.setHeader("Cache-Control","no-cache")
					.setHeader("Connection","keep-alive")
					.setHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8")
					.setHeader("Cookie","Hm_lvt_e2ce0f3627e4ac6c57da0c360ff2e1fb=1446370041; looyu_id=05ee77e86079fcefceb5ba4abcfd67f5d3_24935%3A1; c_ltype=2; c_un=120434; c_ur=i%3D8358417%26n%3D%E6%9D%8E%E8%BE%89%26e%3D%26g%3D0%26u%3D%26l%3D2015-11-12+22%3A41%3A04; c_uid=8358417; Hm_lvt_362f34c5d1545b920d58977b3bf3241c=1446902474,1447338971; CNZZDATA1256643589=2064686380-1446897829-http%253A%252F%252Fcas.teacher.com.cn%252F%7C1447334166; OEL_TP_SID=TLFK8Z-GVV4K1NOSFUL9RUBX5AY1-W0A9CWGI-B6UO; s_d0=eNqFlMtvG0Ucx53ISfxIoDwOSHCoqh442OuZfXi9FgeSrdOaOnYUxwkpBzOendrTrHdWu7MmEUIIQaWCoFUrXgdAVEJISESK4BKKRE%2F9O%2BBQu%2BHElQNSmfGLIFF68Po3v52Z3%2Fw%2B3%2B%2FOhVMhwVFA%2BX4zYC4pO%2BH%2B8fPTlMva1GsGxKEBwbwZBS7odTj3i7lcp6UCaCj%2BnsIJwh0SKJh1FezlOqxLciGPHOLxnAo0I4dZFITTnN1hLCT2KAcNIwd1mNMLBcs2tZJlGoa%2BYuY1CxqqWshD0wS6saLlklFIgjXmENcGL2NvWGxamIqtQwUj8XOpKKGgiHfEP8WIU%2BYpNgpXUcgbky0%2BnaVO3ENdMke6iLrzbeI5KEi8wYLdyKN8yRWTK7L1Tdolr%2B%2FE3v7gqdnBl9ePf3m%2FOgOqz8jGsxBmoXpaVYs6LAL9WczYLiXNHnKpgzhpYlEHnIY6coBlEIwh1ghsFczLGpaNaXkiOiykOPNbKGh6qBeX3OaQ71OnEovNrF2%2Bkn24VC%2FV6%2BVatblWO1eqgNfepE7xzGZl9WLhUvb81pZ%2BEVZr9dVGxdporLxqLO%2FA7DZYtuzt8%2BXsSr5RO5PBvAh13dS0giVAqnoG4VFCh0ZegxBkuntFUwXgrfmQcrLFbPDif8PlAaIe9dpKjyn14dSvku2ARb4cpP2AXREGkfGiFGpDWGlz3%2F9nUBWwE3JQ88tOIiBtIUvZSY2CdcQ76VFYIT3ipkYT5Zo4F7vMj5yZ8pnrSq5l54kTBZddd1EuDjkJzgn0aNbfmx%2B5c2Fsudn%2Bwbf9m5%2FHhRvhS91fn8uYqmVk1LxlaRm1AAwRF6BqZj5OD374sf%2FhZw%2B%2BeKd%2FeEMsGnxyKJ7QsB7cOLh1vBN78ul7461fERrV7qReuJbeXG826qWNjVqltG%2BDzOPxXRBCSyZb7JskFlYLZaMLw0g0KU0YdpjAtDgJ5ft0GLVkxzJOjuMpQJl8BMsp6zHERDBRIxhrNER8gu3C8KxiJg3Xo5ZLcXIMW5zoJOfERNvW%2F1F7%2BMdv1fjJ9J8fpQaHR4Ojq%2F3rd%2FtXf%2F79u%2B%2F7d967%2F9Pt%2B0cH%2FbvvDr6%2B%2FWh1hHTHYyln8reGalSr1akSNjAfAz%2Fi1FVKXtS1mRfy8Gxj3MHN4WWAJ3aZ42yXeEujL8fSTV3XYbyFQhJbaDvNDgv53LZagfl%2F3xPyHOt%2Fnb0WSw5vTcl4HqpA1%2FRLfwPKxPW3; hb2015=r-hb2015-2.16; Hm_lpvt_362f34c5d1545b920d58977b3bf3241c=1447339156; s_cas_tgc=Q0U3NzJBM0VFQkQyRjU1Q0NBQkU4ODNDMjRGQkVBNjYwOTdDNTUwOUUyRUZGQjMxQThENTY0OEU1RUM1MEUyNDQ2RjhGNEZCNjM3NUM0MzRFOTczNTEwQjg3REE5NTM1; s_cas_tgcv0=eNrzEElOLI4vTi0qSy2KL8lMzk4tic9MEbIwNrUwMTRPji%2BOB%2FLjE%2BPLogBCTA7e; TP_ROLE_TYPE=6; TP_ROLE_TYPE=6; c_static_ht=d8292dds21112fy965j; messageFlag_8358417=-1; messageId_8358417=5733")
					.setHeader("Host","hb2015.px.teacher.com.cn")
					.setHeader("Pragma","no-cache")
					.setHeader("Referer","http://hb2015.px.teacher.com.cn/home/student/2031/course/learn/2535/6/97")
					.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:40.0) Gecko/20100101 Firefox/40.0")
					.setHeader("X-Requested-With","XMLHttpRequest")
					.bodyForm(
							new BasicNameValuePair("id", "12916063"),
							new BasicNameValuePair("onceTime", "13"),
							new BasicNameValuePair("inputvalcode", "6158"),
							new BasicNameValuePair("drawerId", "97"),
							new BasicNameValuePair("validateType", "true"),
							new BasicNameValuePair("token", "1447341569651"))
//					.bodyString("id=12916063&onceTime=13&inputvalcode=6158&drawerId=97&validateType=true&token=1447341569651",ContentType.create("text/html", Consts.UTF_8))
					.execute().returnResponse().getEntity();
					
					System.out.println(EntityUtils.toString(entity,"UTF-8"));
					
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String postFile(String url,List<NameValuePair> params,final Map<String, File> files){
		try {
			//HttpEntity reqEntity = MultipartEntityBuilder.create().addTextBody(textName, json,ContentType.APPLICATION_JSON).build();
			
			HttpEntity reqEntity = makeMultipartEntity(params, files);
			Request request = Request.Post(url)
				.setHeader("Content-Type", "application/x-www-form-urlencoded")
				.setHeader("Connection", "keep-alive")
				.setHeader("Accept", "*/*")
				.setHeader("User-Agent", "BaiduNuomiMerchant/1.8.0 (iPhone; iOS 8.4.1; Scale/2.00)")
				.setHeader("Accept-Language", "zh-Hans;q=1, en;q=0.9")
				.setHeader("Accept-Encoding", "gzip, deflate")
				.body(reqEntity);
			HttpEntity resEntity = request.execute().returnResponse().getEntity();
			return resEntity != null ? EntityUtils.toString(resEntity) : null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static HttpEntity makeMultipartEntity(List<NameValuePair> params, final Map<String, File> files) {
	    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
	    builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);  //如果有SocketTimeoutException等情况，可修改这个枚举
	    //builder.setCharset(Charset.forName("UTF-8")); //不要用这个，会导致服务端接收不到参数
	    if (params != null && params.size() > 0) {
	        for (NameValuePair p : params) {
	            builder.addTextBody(p.getName(), p.getValue(), ContentType.TEXT_PLAIN.withCharset("UTF-8"));
	        }
	    }
	    if (files != null && files.size() > 0) {
	        Set<Entry<String, File>> entries = files.entrySet();
	        for (Entry<String, File> entry : entries) {
	            builder.addPart(entry.getKey(), new FileBody(entry.getValue()));
	        }
	    }
	    return builder.build();
	}
}
