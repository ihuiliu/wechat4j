/**
 * 
 */
package org.sword.lang;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

/**
 * @author ChengNing
 * @date   2014年12月7日
 */
public class JaxbParser {
	
	private static Logger logger = Logger.getLogger(JaxbParser.class);
	
	private Class clazz;
	private String[] cdataNode;
	
	/**
	 * 
	 * @param clazz
	 */
	public JaxbParser(Class clazz){
		this.clazz = clazz;
	}
	
	/**
	 * 设置需要包含CDATA的节点
	 * @param cdataNode
	 */
	public void setCdataNode(String[] cdataNode) {
		this.cdataNode = cdataNode;
	}

	/**
	 * 转为xml串
	 * @param obj
	 * @return
	 */
	public String toXML(Object obj){
		String result = null;
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.setProperty(Marshaller.JAXB_FRAGMENT, true);// 去掉报文头
			//----------------------------------------------
			/*StringWriter writer = new StringWriter();
			m.marshal(obj, writer);
			result = writer.toString();*/
			//----------------------------------------------
			ByteArrayOutputStream  os = new ByteArrayOutputStream ();
			XMLSerializer serializer = getXMLSerializer(os);
			m.marshal(obj, serializer.asContentHandler());
			result = new String(os.toByteArray(),"UTF-8");
			//----------------------------------------------
			/*StringWriter writer = new StringWriter();
			m.marshal(obj, writer);
			result = writer.toString();
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
	        DocumentBuilder db = dbf.newDocumentBuilder();  
	        InputSource is = new InputSource(new StringReader(result));  
			final Document document =  db.parse(is);  
	        OutputFormat format = new OutputFormat(document);  
	        format.setLineWidth(65);  
	        format.setIndenting(true);  
	        format.setIndent(2);  
	        Writer out = new StringWriter();  
	        XMLSerializer serializer = new XMLSerializer(out, format);  
	        serializer.serialize(document);  
	        result = out.toString();*/
			//----------------------------------------------
		    /*OutputStream os = new ByteOutputStream();
			XMLSerializer serializer = getXMLSerializer(os);
			m.marshal(obj, serializer.asContentHandler());
			result = os.toString();*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("response text:" + result);
		return result;
	}
	

	/**
	 * 转为对象
	 * @param is
	 * @return
	 */
	public Object toObj(InputStream is){
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(clazz);
			Unmarshaller um = context.createUnmarshaller();
			Object obj = um.unmarshal(is);
			return obj;
		} catch (Exception e) {
			logger.error("post data parse error");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * XML转为对象
	 * @param xmlStr
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public Object toObj(String xmlStr) throws UnsupportedEncodingException{
		InputStream is = StreamUtils.strToStream(xmlStr, "UTF-8");
		return toObj(is);
	}
	
	/**
	 * 设置属性
	 * @param os
	 * @return
	 */
	private XMLSerializer getXMLSerializer(OutputStream os) {
		// configure an OutputFormat to handle CDATA
		// 配置一个OutputFormat处理CDATA
		OutputFormat of = new OutputFormat();
//        formatCDataTag();
	    // specify which of your elements you want to be handled as CDATA.
        // 指定要被处理为CDATA的元素
	    // The use of the '^' between the namespaceURI and the localname
	    // seems to be an implementation detail of the xerces code.
	    // When processing xml that doesn't use namespaces, simply omit the
	    // namespace prefix as shown in the third CDataElement below.
        of.setCDataElements(cdataNode);   
        // set any other options you'd like
        of.setPreserveSpace(true);
        of.setIndenting(true);
        //去掉头
        of.setOmitXMLDeclaration(true);
        // create the serializer
        // 创建序列化器
        XMLSerializer serializer = new XMLSerializer(of);
        serializer.setOutputByteStream(os);
        return serializer;
    }
	
	/**
	 * 适配cdata tag
	 */
	private void formatCDataTag(){
		for(int i=0;i<cdataNode.length;i++){
			cdataNode[i] = "^" + cdataNode[i];
		}
	}
}
