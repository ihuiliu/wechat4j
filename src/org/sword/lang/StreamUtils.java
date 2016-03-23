/**
 * 
 */
package org.sword.lang;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author ChengNing
 * @date   2014年12月11日
 */
public class StreamUtils {
	
	/**
	 * stream to string
	 * @param is
	 * @return
	 */
	public static String streamToString(InputStream is){
		ByteArrayOutputStream   baos   =   new   ByteArrayOutputStream(); 
        int i=-1; 
        try {
			while((i=is.read())!=-1){ 
			baos.write(i); 
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
       return   baos.toString(); 
	}
	/**
	 * stream to string
	 * @param is
	 * @param charsetName
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String streamToString(InputStream is,String charsetName) throws UnsupportedEncodingException{
		ByteArrayOutputStream   baos   =   new   ByteArrayOutputStream(); 
		int i=-1; 
		try {
			while((i=is.read())!=-1){ 
				baos.write(i); 
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return   baos.toString(charsetName); 
	}
	
	
	/**
	 * string to stream
	 * @param str
	 * @return
	 */
	public static InputStream strToStream(String str){
		InputStream is = new ByteArrayInputStream(str.getBytes());
		return is;
	}
	/**
	 * string to stream
	 * @param str
	 * @param charsetName
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static InputStream strToStream(String str,String charsetName) throws UnsupportedEncodingException{
		InputStream is = new ByteArrayInputStream(str.getBytes(charsetName));
		return is;
	}

}
