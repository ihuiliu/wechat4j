package org.sword.wechat4j.pay;

import java.util.HashMap;
import java.util.Map;
/**
 * 银行类型
 */
public class BankType {
    private final static Map<String, String> BankleitzahlMap = new HashMap<String, String>();

    static {
    	BankleitzahlMap.put("ICBC_DEBIT", "工商银行(借记卡)");
	    BankleitzahlMap.put("ICBC_CREDIT", "工商银行(信用卡)");
		BankleitzahlMap.put("ABC_DEBIT", "农业银行(借记卡)");
		BankleitzahlMap.put("ABC_CREDIT", "农业银行 (信用卡)");
		BankleitzahlMap.put("PSBC_DEBIT", "邮政储蓄(借记卡)");
		BankleitzahlMap.put("PSBC_CREDIT", "邮政储蓄 (信用卡)");
		BankleitzahlMap.put("CCB_DEBIT", "建设银行(借记卡)");
		BankleitzahlMap.put("CCB_CREDIT", "建设银行 (信用卡)");
		BankleitzahlMap.put("CMB_DEBIT", "招商银行(借记卡)");
		BankleitzahlMap.put("CMB_CREDIT", "招商银行(信用卡)");
		BankleitzahlMap.put("COMM_DEBIT", "交通银行(借记卡)");
		BankleitzahlMap.put("BOC_CREDIT", "中国银行(信用卡)");
		BankleitzahlMap.put("SPDB_DEBIT", "浦发银行(借记卡)");
		BankleitzahlMap.put("SPDB_CREDIT", "浦发银行 (信用卡)");
		BankleitzahlMap.put("GDB_DEBIT", "广发银行(借记卡)");
		BankleitzahlMap.put("GDB_CREDIT", "广发银行(信用卡)");
		BankleitzahlMap.put("CMBC_DEBIT", "民生银行(借记卡)");
		BankleitzahlMap.put("CMBC_CREDIT", "民生银行(信用卡)");
		BankleitzahlMap.put("PAB_DEBIT", "平安银行(借记卡)");
		BankleitzahlMap.put("PAB_CREDIT", "平安银行(信用卡)");
		BankleitzahlMap.put("CEB_DEBIT", "光大银行(借记卡)");
		BankleitzahlMap.put("CEB_CREDIT", "光大银行(信用卡)");
		BankleitzahlMap.put("CIB_DEBIT", "兴业银行 (借记卡)");
		BankleitzahlMap.put("CIB_CREDIT", "兴业银行(信用卡)");
		BankleitzahlMap.put("CITIC_DEBIT", "中信银行(借记卡)");
		BankleitzahlMap.put("CITIC_CREDIT", "中信银行(信用卡)");
		BankleitzahlMap.put("SDB_CREDIT", "深发银行(信用卡)");
		BankleitzahlMap.put("BOSH_DEBIT", "上海银行(借记卡)");
		BankleitzahlMap.put("BOSH_CREDIT", "上海银行 (信用卡)");
		BankleitzahlMap.put("CRB_DEBIT", "华润银行(借记卡)");
		BankleitzahlMap.put("HZB_DEBIT", "杭州银行(借记卡)");
		BankleitzahlMap.put("HZB_CREDIT", "杭州银行(信用卡)");
		BankleitzahlMap.put("BSB_DEBIT", "包商银行(借记卡)");
		BankleitzahlMap.put("BSB_CREDIT", "包商银行 (信用卡)");
		BankleitzahlMap.put("CQB_DEBIT", "重庆银行(借记卡)");
		BankleitzahlMap.put("SDEB_DEBIT", "顺德农商行 (借记卡)");
		BankleitzahlMap.put("SZRCB_DEBIT", "深圳农商银行(借记卡)");
		BankleitzahlMap.put("HRBB_DEBIT", "哈尔滨银行(借记卡)");
		BankleitzahlMap.put("BOCD_DEBIT", "成都银行(借记卡)");
		BankleitzahlMap.put("GDNYB_DEBIT", "南粤银行 (借记卡)");
		BankleitzahlMap.put("GDNYB_CREDIT", "南粤银行 (信用卡)");
		BankleitzahlMap.put("GZCB_CREDIT", "广州银行(信用卡)");
		BankleitzahlMap.put("JSB_DEBIT", "江苏银行(借记卡)");
		BankleitzahlMap.put("JSB_CREDIT", "江苏银行(信用卡)");
		BankleitzahlMap.put("NBCB_DEBIT", "宁波银行(借记卡)");
		BankleitzahlMap.put("NBCB_CREDIT", "宁波银行(信用卡)");
		BankleitzahlMap.put("NJCB_DEBIT", "南京银行(借记卡)");
		BankleitzahlMap.put("QDCCB_DEBIT", "青岛银行(借记卡)");
		BankleitzahlMap.put("ZJTLCB_DEBIT", "浙江泰隆银行(借记卡)");
		BankleitzahlMap.put("XAB_DEBIT", "西安银行(借记卡)");
		BankleitzahlMap.put("CSRCB_DEBIT", "常熟农商银行 (借记卡)");
		BankleitzahlMap.put("QLB_DEBIT", "齐鲁银行(借记卡)");
		BankleitzahlMap.put("LJB_DEBIT", "龙江银行(借记卡)");
		BankleitzahlMap.put("HXB_DEBIT", "华夏银行(借记卡)");
		BankleitzahlMap.put("CS_DEBIT", "测试银行借记卡快捷支付 (借记卡)");
		BankleitzahlMap.put("AE_CREDIT", "AE (信用卡)");
		BankleitzahlMap.put("JCB_CREDIT", "JCB (信用卡)");
		BankleitzahlMap.put("MASTERCARD_CREDIT", "MASTERCARD (信用卡)");
		BankleitzahlMap.put("VISA_CREDIT", "VISA (信用卡)");
    }
}
