package org.sword.wechat4j.pay.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
public class DownloadBillRequest extends BasicPayRequest{
	//对账单日期
	private String bill_date;//	是	String(8)	20140603	下载对账单的日期，格式：20140603
	//设备号
	private String device_info;
	//账单类型	
	private String bill_type;//	否	String(8)	ALL
	
	public static String[] CDATA_TAG = {"^sign"};
	public String getBill_date() {
		return bill_date;
	}
	public void setBill_date(String bill_date) {
		this.bill_date = bill_date;
	}
	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	public String getBill_type() {
		return bill_type;
	}
	public void setBill_type(String bill_type) {
		this.bill_type = bill_type;
	}
	
}
