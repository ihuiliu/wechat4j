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
		})