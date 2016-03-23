package org.sword.wechat4j.pay.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
public class ShortUrlResponse extends BasicPaySuccess{
	private String short_url;

	public String getShort_url() {
		return short_url;
	}

	public void setShort_url(String short_url) {
		this.short_url = short_url;
	}
	
}
