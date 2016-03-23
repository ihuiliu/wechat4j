/**
 * 
 */
package org.sword.lang;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;


/**
 * 
 * @author chengn
 * @date 2014年12月12日
 */
public class HttpUtils {
	private static Logger logger = Logger.getLogger(HttpUtils.class);

	public static final int timeout = 10;

	/**
	 * post 请求
	 * 
	 * @param url
	 * @return
	 */
	public static String post(String url) {
		return post(url, "");
	}
	
	/**
	 * post请求
	 * @param url
	 * @param data
	 * @return
	 */
	public static String post(String url, String data){
		return httpPost(url, data);
	}
	
	/**
	 * 发送http post请求
	 * @param url       url
	 * @param instream  post数据的字节流
	 * @return
	 */
	public static String post(String url, InputStream instream){
		try {
			HttpEntity entity = Request.Post(url)
					.bodyStream(instream,ContentType.create("text/html", Consts.UTF_8))
					.execute().returnResponse().getEntity();
			return entity != null ? EntityUtils.toString(entity) : null;
		} catch (Exception e) {
			logger.error("post请求异常，" + e.getMessage() + "\n post url:" + url);
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * get请求
	 * @param url
	 * @return
	 */
	public static String get(String url){
		return httpGet(url);
	}

	/**
	 * post 请求
	 * 
	 * @param url
	 * @param data
	 * @return
	 */
	private static String httpPost(String url, String data) {
		try {
			HttpEntity entity = Request.Post(url)
					.bodyString(data,ContentType.create("text/html", Consts.UTF_8))
					.execute().returnResponse().getEntity();
			String res = entity != null ? EntityUtils.toString(entity,"UTF-8") : null;
			System.out.println("接口响应数据："+res);
			return res;
		} catch (Exception e) {
			logger.error("post请求异常，" + e.getMessage() + "\n post url:" + url);
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 上传文件
	 * @param url    URL
	 * @param name   文件的post参数名称
	 * @param file   上传的文件
	 * @return
	 */
	public static String postFile(String url,String name,File file){
		try {
			HttpEntity reqEntity = MultipartEntityBuilder.create().addBinaryBody(name, file).build();
			Request request = Request.Post(url);
			request.body(reqEntity);
			HttpEntity resEntity = request.execute().returnResponse().getEntity();
			return resEntity != null ? EntityUtils.toString(resEntity) : null;
		} catch (Exception e) {
			logger.error("postFile请求异常，" + e.getMessage() + "\n post url:" + url);
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 上传文件
	 * @param url    URL
	 * @param name   文件的post参数名称
	 * @param file   上传的文件
	 * @param textName 文本的post参数名称
	 * @param json	上传的json内容
	 * @return
	 */
	public static String postFile(String url,String name,File file,String textName,String json){
		try {
			HttpEntity reqEntity = MultipartEntityBuilder.create().addBinaryBody(name, file).addTextBody(textName, json,ContentType.APPLICATION_JSON).build();
			Request request = Request.Post(url);
			request.body(reqEntity);
			HttpEntity resEntity = request.execute().returnResponse().getEntity();
			return resEntity != null ? EntityUtils.toString(resEntity) : null;
		} catch (Exception e) {
			logger.error("postFile请求异常，" + e.getMessage() + "\n post url:" + url);
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 下载文件
	 * @param url   URL
	 * @return      文件的二进制流，客户端使用outputStream输出为文件
	 */
	public static byte[] getFile(String url){
		try {
			Request request = Request.Get(url);
			HttpEntity resEntity = request.execute().returnResponse().getEntity();
			return EntityUtils.toByteArray(resEntity);
		} catch (Exception e) {
			logger.error("postFile请求异常，" + e.getMessage() + "\n post url:" + url);
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 下载文件
	 * @param url   URL
	 * @param data	请求数据
	 * @return      文件的二进制流，客户端使用outputStream输出为文件
	 */
	public static byte[] getFile(String url,String data){
		try {
			HttpEntity entity = Request.Post(url)
					.bodyString(data,ContentType.create("text/html", Consts.UTF_8))
					.execute().returnResponse().getEntity();
			return entity != null ? EntityUtils.toByteArray(entity) : null;
		} catch (Exception e) {
			logger.error("post请求异常，" + e.getMessage() + "\n post url:" + url);
			e.printStackTrace();
		}
		return null;
		
	}
	/**
	 * 发送get请求
	 * 
	 * @param url
	 * @return
	 */
	private static String httpGet(String url) {
		try {
			HttpEntity entity = Request.Get(url).
					execute().returnResponse().getEntity();
			return entity != null ? EntityUtils.toString(entity,"UTF-8") : null;
		} catch (Exception e) {
			logger.error("get请求异常，" + e.getMessage() + "\n get url:" + url);
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param url 
	 * @param data
	 * @param keyPassword 密钥
	 * @param certificatePathName 证书的路径
	 * @return
	 * @throws Exception
	 */
	public static String clientCustomSSL(String url ,String data,String keyPassword,String  certificatePathName){
		try{
	        KeyStore keyStore  = KeyStore.getInstance("PKCS12");
	        FileInputStream instream = new FileInputStream(new File(certificatePathName));
	        try {
	            keyStore.load(instream, keyPassword.toCharArray());
	        }finally {
	            instream.close();
	        }
	        // Trust own CA and all self-signed certs
	        SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, keyPassword.toCharArray()).build();
	        // Allow TLSv1 protocol only
	        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
	        		sslcontext,
	                new String[] { "TLSv1" },
	                null,
	                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
					
	        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
	        try {
		        HttpPost httpPost = new HttpPost(url);//退款接口
		        StringEntity reqEntity  = new StringEntity(data,"UTF-8");
			    // 设置类型 
			    reqEntity.setContentType("application/x-www-form-urlencoded"); 
			    httpPost.setEntity(reqEntity);
	            CloseableHttpResponse response = httpclient.execute(httpPost);
	            HttpEntity entity = response.getEntity();
	            try {
	                return entity != null ? EntityUtils.toString(entity) : null;  
	            } finally {
	            	EntityUtils.consume(entity);
	                response.close();
	            }
	        } finally {
	            httpclient.close();
	        }
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * post方式提交表单（模拟用户登录请求） 方式一
	 * @param url
	 * @param data
	 * @return
	 */
	private static String httpPost(String url, List<NameValuePair> formParams) {
		try {
			HttpEntity entity = Request.Post(url)
					.bodyForm(formParams)
					.execute().returnResponse().getEntity();
			return entity != null ? EntityUtils.toString(entity,"UTF-8") : null;
		} catch (Exception e) {
			logger.error("post请求异常，" + e.getMessage() + "\n post url:" + url);
			e.printStackTrace();
		}
		return null;
	}
	/** 
     * post方式提交表单（模拟用户登录请求） 方式二
     */  
    public void postForm(String url ,List<NameValuePair> formParams) {  
        // 创建默认的httpClient实例.    
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        // 创建httppost    
        HttpPost httppost = new HttpPost(url);  
        // 创建参数队列    
        UrlEncodedFormEntity uefEntity;  
        try {  
            uefEntity = new UrlEncodedFormEntity(formParams, "UTF-8");  
            httppost.setEntity(uefEntity);  
//            httppost.setHeader(name, value)
            System.out.println("executing request " + httppost.getURI());  
            CloseableHttpResponse response = httpclient.execute(httppost);  
            try {  
                HttpEntity entity = response.getEntity();  
                if (entity != null) {  
                    System.out.println("--------------------------------------");  
                    System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));  
                    System.out.println("--------------------------------------");  
                }  
            } finally {  
                response.close();  
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e1) {  
            e1.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            // 关闭连接,释放资源    
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}
