<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="js/jquery-1.9.1.min.js"></script>
</head>
<body>
<%-- <input type="text" name="a" value="${unifiedOrderResponse.mch_id }" />
<input type="text" name="b" value="${unifiedOrderResponse.device_info }" />
<input type="text" name="c" value="${unifiedOrderResponse.sign }" />
<input type="text" name="d" value="${unifiedOrderResponse.nonce_str }" />
<input type="text" name="e" value="prepay_id=${unifiedOrderResponse.nonce_str }" /> --%>
<%-- <input type="hidden" name="f"  id="json" value="${json }" /> --%>
<%-- <input type="hidden" name="a"  id="appId" value="${json }" />
<input type="hidden" name="b"  id="timeStamp" value="${json }" />
<input type="hidden" name="c"  id="nonceStr" value="${json }" />
<input type="hidden" name="d"  id="package" value="${json }" />
<input type="hidden" name="e"  id="signType" value="${json }" />
<input type="hidden" name="f"  id="paySign" value="${json }" /> --%>
<input type="button" value="zhifu" onclick="onBridgeReady()"/> 

</body>
<script type="text/javascript">
function change(){
	
	alert(111);
}

/*  $(document).ready(function(){
	var aa=$("#aa").val();
	aa="{"+aa+"}";
	alert(aa);
	});  */
function onBridgeReady(){
	/* var json=$("#json").val();
	
	json=json.replace(/\'/g,"\"");
	json="{"+json+"}";
	alert(json); */
	//alert("{"+json+"}");
	//var appId=$("#appId").val();
	//var timeStamp=$("#timeStamp").val();
	//var nonceStr=$("#nonceStr").val();
	//var package1=$("#package1").val();
	//var paySign=$("#paySign").val();
	//var json=$("#json").val();
	alert("${appId}");
	    WeixinJSBridge.invoke(
	       'getBrandWCPayRequest',
	        {
	           "appId" : "${appId}",     //公众号名称，由商户传入     
	           "timeStamp":"${timeStamp}",         //时间戳，自1970年以来的秒数     
	           "nonceStr" : "${nonceStr}", //随机串     
	          "package" : "${package1}",     
	           "signType": "MD5",         //微信签名方式：     
	           "paySign" : "${paySign}" //微信签名 
	       } ,
	       function(res){     
	           if(res.err_msg == "get_brand_wcpay_request：ok" ) {
	        	   alert("ok");
	           } else{
	        	   alert("error");
	           }    // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。 
	       }
	   );  
	}
	if (typeof WeixinJSBridge == "undefined"){
	   if( document.addEventListener ){
	       document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
	   }else if (document.attachEvent){
	       document.attachEvent('WeixinJSBridgeReady', onBridgeReady); 
	       document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
	   }
	}else{
	   onBridgeReady();
	} 


</script>
</html>