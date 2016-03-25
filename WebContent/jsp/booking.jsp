<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
		<title>金诚太悦</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/css/weui.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/css/app.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/css/datepicker.css"/>
        
        <script type="text/javascript" src="${pageContext.request.contextPath }/jsp/js/jquery-1.9.1.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/js/zepto.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/js/amazeui.datetimepicker.min.js" ></script> 
	</head>
	<body>
		<body ontouchstart="" style=" background:#f0f0f2">
			<section class="main ">
				<div class="hd">
					<h1 class="page_title">金诚太悦</h1>
					<div><span>GOLD</span><span>FINANCE</span><span>TAIYYUE</span></div>
					<a href="person.html" class="y-home"></a>
				</div>
				<ul class="tab-ul">
					<li>
						<span class="active"></span>
						<em>门票预订</em>
					</li>
					<li>
						<span></span>
						<em>会员卡订购</em>
					</li>
				</ul>
				<form action="${pageContext.request.contextPath }/index.action" method="post" id="doorTic">
				<input type="hidden" name="code" id="code" value="${code}" />
				<div class="weui_cells weui_cells_form cell-ui slideIn" style="display: block;">
	            	<div class="weui_cell">
		            	<div class="weui_cell_hd">
		            		<label class="weui_label">姓名</label>
		            	</div>
		            	<div class="weui_cell_bd weui_cell_primary">
		                	<input class="weui_input" type="text" name="name" id="name">
		                </div>
	            	</div>
	            	<div class="weui_cell">
	            		<div class="weui_cell_hd">
	            			<label class="weui_label">手机</label>
	            		</div>
	            		<div class="weui_cell_bd weui_cell_primary">
	                         <input class="weui_input" type="number"  name="phone"  id="phone" value="weui input error">
	                     </div>
	            	</div>
	            	<div class="weui_cell cell-3">
	            		<div class="weui_cell_hd"><label class="weui_label">时间</label></div>
	            		<div class="weui_cell_bd weui_cell_primary">
		                    <!-- <input class="weui_input" type="datetime-local" name="time" id="time" value="" placeholder=""> -->
		                    <input class="weui_input" name="time" id="time"  value="" placeholder="">
		                </div>
	            	</div>
	            	<div class="weui_cell">
	            			<div class="weui_cell_hd">
	            					<label class="weui_label">门票数</label>
	            			</div>
			            	<div class="weui_cell_bd weui">
			                          <input class="weui_input ticket-count" type="number" name="tolTic" id="tolTic">
			                </div>
	            			
	            			<div class="weui_cell_hd sum-li">
	            				<label class="weui_label">总价</label>
	            			</div>
				            <div class="weui_cell_bd weui weui_cell_primary">
				                 <input class="weui_input ticket-sum" type="number" name="total" id="total">
				            </div>
	           
	            	</div>
	            	<div class="weui_cell">
	            		<div class="weui_cell_hd">
	            			<label class="weui_label"></label>
	            		</div>
	            		<div class="weui_cell_bd weui_cell_primary sum-title">
		                                                                      温 泉门票单价：298元人民币/人
		                </div>
	            	</div>
	            	<div class="weui_cell">
	            		<div class="weui_cell_hd">
	            			<label class="weui_label">备注</label>
	            		</div>
	            		<div class="weui_cell_bd weui_cell_primary">
	                           <textarea name="detail"  id="detail" rows="5" class="y-textare weui_textarea" ></textarea>
	                      </div>
	            	</div>
	            	
	            	<div class="weui_cell">
	            		<div class="y-btn-box">
		            		<a href="javascript:submit();" class="weui_btn weui_btn_mini weui_btn_primary btn-1">确定</a>
		            	    <a href="javascript:;" class="weui_btn weui_btn_mini weui_btn_default btn-2">取消</a>
	            	   </div>
	            	</div>
	         
	            	
                </div>
                </form>
                <form action="${pageContext.request.contextPath }/show.action" method="post">
				 <div class="weui_cells weui_cells_form cell-ui slideIn">
	            	<div class="weui_cell">
	            		<div class="weui_cell_hd">
	            			<label class="weui_label">姓名</label>
	            		</div>
	            		<div class="weui_cell_bd weui_cell_primary">
	                         <input class="weui_input" name="kname" id="kname" type="text">
	                    </div>
	            	</div>
	            	<div class="weui_cell">
	            		<div class="weui_cell_hd">
	            			<label class="weui_label">手机</label>
	            		</div>
	            		<div class="weui_cell_bd weui_cell_primary">
	                        <input class="weui_input" name="kphone" id="kphone" type="number" value="weui input error">
	                     </div>
	            	</div>
	            	<div class="weui_cell cell-3">
	            		<div class="weui_cell_hd">
	            			<label class="weui_label">会员卡</label>
	            			<label class="weui_label">类型</label>
	            		</div>
	            		<div class="weui_cell_bd weui_cell_primary">
                            <select name="select2" id="select2" class="y-select">
                                <option value="1">普通卡</option>
                                <option value="2">金卡</option>
                                <option value="3">白金卡</option>
                                <option value="4">钻石卡</option>
                                <option value="5">至尊卡</option>
                                <option value="6">顶级至尊卡</option>
                            </select>
                       </div>
	                     
	            	</div>
	            	<div class="weui_cell">
	            		<div class="weui_cell_hd">
	            			<label class="weui_label">备注</label>
	            		</div>
	            		<div class="weui_cell_bd weui_cell_primary">
	                         <textarea name="kdetail" id="kdetail" rows="5" class="y-textare weui_textarea" ></textarea>
	                    </div>
	            	</div>
	            	<div class="weui_cell cell-titles">
	            		<div class="weui_cell_hd">
	            			<label class="weui_label">提醒:</label>
	            		</div>
	            		<div class="weui_cell_hd weui_cell_primary">
	            			<div>会员卡优惠方案及金额，请点击查询微信公众号，或者联系金城太悦会籍部<span>程娟：1323434454</span></div>
	            		</div>
	            	</div>
	            	<div class="weui_cell">
	            		<div class="y-btn-box">
		            		<a href="javascript:ksubmit();" class="weui_btn weui_btn_mini weui_btn_primary btn-1">确定</a>
		            	    <a href="javascript:;" class="weui_btn weui_btn_mini weui_btn_default btn-2">取消</a>
	            	   </div>
	            	</div>
	         
	            	
                </div>
                </form>
			</section>
     
	</body>
	<script type="text/javascript">
	$(function(){
		$(".tab-ul li").each(function(i,e){
			$(e).on('click',function(){
				$(".tab-ul li span").removeClass('active');
				$(this).find('span').addClass('active');
				$('.cell-ui.weui_cells').hide();
				$('.cell-ui.weui_cells').eq(i).show();
			});
		});
		
		
		/*我的订单页面*/
		$(".order-ul li").click(function(){
			if ($(this).find('a').hasClass('active')) {
				$(this).find('a').removeClass('active');
				$(this).find('ul').hide();
			} else{
				$(this).find('a').addClass('active');
				$(this).find('ul').show();
			}
		});
		
		$(".ticket-count").keyup(function(){
		     $(".ticket-sum").val($(".ticket-count").val()*298);;
			
		});
		
		$("#phone").blur(function(){
			var inpVal=$("#phone").val();
			var myreg = /^1[3458]\d{9}$/;
			//var inpVal = this.value;
			if (!myreg.exec(inpVal)){
				alert('请输入正确的手机号')
				
			}
		});
		$("#kphone").blur(function(){
			var inpVal=$("#kphone").val();
			var myreg = /^1[3458]\d{9}$/;
			if (!myreg.exec(inpVal)){
				alert('请输入正确的手机号')
				
			}
		}); 
		
	})
	
		/* */
	
 		var code;
		var detail;
		var name;
		var phone;
		var tolTic;
		var data;
		var appId;
		var timeStamp;
		var nonceStr;
		var package1;
		var paySign;
		var json;
		var status;
		var ka;

	
		function submit(){
			code=$("#code").val();
			detail=$("#detail").val();
			name=$("#name").val();
			phone=$("#phone").val();
			tolTic=$("#tolTic").val();
			data="name="+name+"&phone="+phone+"&tolTic="+tolTic+"&code="+code+"&detail="+detail+"&status=1";
			
		  $.ajax({
              type: "post",
              url: '${pageContext.request.contextPath }/booking.action',
              /* contentType:"application/json;charset=utf-8", */
              data:data,
              success: function (data) {
               
               appId=data.appId;
               timeStamp=data.timeStamp;
               nonceStr=data.nonceStr;
               package1=data.package1; 
               paySign=data.paySign;
              // alert(appId);
               //json='{ "appId":"appId", "sex": "man" }';

               //onBridgeReady();
               //json=data;
               onBridgeReady();
              
              }
          });
		}
		function ksubmit(){
			code=$("#code").val();
			detail=$("#kdetail").val();
			name=$("#kname").val();
			phone=$("#kphone").val();
			tolTic=$("#ktolTic").val();
			ka=$("#select2").val();
			data="name="+name+"&phone="+phone+"&tolTic="+tolTic+"&code="+code+"&detail="+detail+"&status=2&ka="+ka;
			
		  $.ajax({
              type: "post",
              url: '${pageContext.request.contextPath }/booking.action',
              data:data,
              success: function (data) {
               
               appId=data.appId;
               timeStamp=data.timeStamp;
               nonceStr=data.nonceStr;
               package1=data.package1; 
               paySign=data.paySign;
               onBridgeReady();
              
              }
          });
		}
	
	function onBridgeReady(){
		    WeixinJSBridge.invoke(
		       'getBrandWCPayRequest',
		        {
		           "appId" : appId+"",     //公众号名称，由商户传入     
		           "timeStamp":timeStamp+"",         //时间戳，自1970年以来的秒数     
		           "nonceStr" : nonceStr+"", //随机串     
		          "package" : package1+"",     
		           "signType": "MD5",         //微信签名方式：     
		           "paySign" : paySign+"" //微信签名 
		       } ,
		       function(res){     
		           if(res.err_msg == "get_brand_wcpay_request:ok" ) {
		        	  // alert("ok");
		           } else{
		        	  // alert("error");
		           }    // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。 
		       }
		   );  
		}
	
	 $('#time').datetimepicker({
		  format: 'yyyy-mm-dd',
		  autoclose: true,
		  minuteStep: 5  
		}); 
	/* window.onload = function(){
		var inpEle = document.getElementById('ipnumber');
		var myreg = /^1[3458]\d{9}$/;
		inpEle.onblur = function(){
		var inpVal = this.value;
		if (!myreg.exec(inpVal)){
			alert('请输入正确的手机号')
			}
		}
	} */
		/* if (typeof WeixinJSBridge == "undefined"){
		   if( document.addEventListener ){
		       document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
		   }else if (document.attachEvent){
		       document.attachEvent('WeixinJSBridgeReady', onBridgeReady); 
		       document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
		   }
		}else{
		   onBridgeReady();
		}  */
	</script>
	
	
</html>
