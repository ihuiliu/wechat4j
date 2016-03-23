package org.sword.wechat4j.pay.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
public class ShortUrlRequest extends BasicPayRequest{
	private String long_url;

	public String getLong_url() {
		return long_url;
	}

	public void setLong_url(String long_url) {
		this.long_url = long_url;
	}
	
}
