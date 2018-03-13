<#import "/macro.ftl" as m>
<@m.page_header title='后台' />


<style>
	.bor{border:1px dashed #F00;width:33%;height:105px;margin-top:10px} 
	span{display:block}
	.image1{ 
        margin-top: 10px; 
        width:200%; 
        height:175px; 
        border-radius:200px; 
    }
    .leftDiv{
    	border:1px dashed gray;
    	width:14%;
    	height:200px;
    	float:left;
    	background:#CCCCFF;
    	margin:0,auto
    	
    }
    .rightDiv{
    	border:1px dashed #0066CC;
    	width:58%;
    	height:200px;
    	float:left
    
    }
	.rowDiv{
		margin-top:4px;
		width:100%;
		height:40px
	
	}
	.rowlineDiv{
		margin-top:4px;
		width:100%;
		height:38px
	
	}
	
	.hr{
		width:100%;
		border:none;
		border-top:1px dashed #0066CC;
	}
	
	.orderDiv{
		width:48%;
		float:left
	
	}
	.userDiv{
		width:48%;
		float:right
	
	}
</style>


<div id="page-content-wrapper">
	<div id="page-title">
        <div>
           	<div style="width:800px;">
           		<span style="width:420px;font-size: 30px;color:#2381E9;"> 米庄理财QA管理系统v-1.0</span>
	        	
	        </div>
        </div>
    </div>
	
	<div class="pad10A">

		<div style="float:left">
			<img class="image1" src="/assets/images/gravatar2.jpg"/>
		</div>
		

		<div style="float:right;width:70%;height:95px;margin-top:40px">
            <div class="bor" style="float:right">
                <div class="form-row">
                    <div class="form-label">
                        <label for="" style="text-align:center;font-size:30px;color:red" >
						${interfaceRequestCounts}
                        </label>
                    </div>
                    <div class="form-label">
                        <label for="" style="text-align:center;font-size:21px" >
                            <a href="interface/requestlist" title="接口测试发起总数">
                                接口测试发起总数
                            </a>

                        </label>
                    </div>
                </div>

            </div>
			
			<div class="bor" style="float:right">
				<div class="form-row">
           			 <div class="form-label">
                		<label for="" style="text-align:center;font-size:30px;color:red" >
                    		${serviceCount}
                		</label>
                	 </div>	
                	  <div class="form-label">
                		<label for="" style="text-align:center;font-size:21px" >
                            <a href="/interface/servicelist" title="接口总数">
                    		接口总数
							</a>
                		</label>
                	 </div>	
                  </div>

        </div>
			
			<div class="bor" style="float:right">
				<div class="form-row">
           			 <div class="form-label">
                		<label for="" style="text-align:center;font-size:30px;color:red" >
                    		${errorServiceCount}
                		</label>
                	 </div>	
                	 <div class="form-label">
                		<label for="" style="text-align:center;font-size:21px" >
                            <a href="/interface/servicelist?isNormal=NO" title="异常接口总数">
                    		异常接口总数
							</a>
                		</label>
                	 </div>	
                  </div>	 	
			</div>
			</div>
   </div>
  
   <div style="margin-top:230px">
   		<div class="orderDiv">
   			<div style="background:#CCCCFF;height:100px">
   				<span style="font-size:20px;text-align:center">测&nbsp试&nbsp接&nbsp口</span>
            	<div>
	            		<div style="width:28%;margin-left:54px;float:left">
	            			<div id="todayOrderCounts" class="form-label col-md-4" style="font-size:20px;color:red;width:100%">
	                			<label for="">
	                  			
	                			</label>
	            			</div>
	            			<a href="#" id="today_order" class="form-input col-md-2" style="font-size:20px;width:100%">
	               			今&nbsp&nbsp日
	            			</a>
	            		
	            		</div>
            		
	            		<div style="width:28%;float:left">
	            			<div id="weekOrderCounts"class="form-label col-md-4" style="font-size:20px;color:red;width:100%">
	                			<label for="">
	         
	                			</label>
	            			</div>
	            			<a href="#" id="week_order" class="form-input col-md-2" style="font-size:20px;width:100%">
	               			本&nbsp&nbsp周
	            			</a>
	            		
	            		</div>
            		
	            		<div style="width:28%;float:right">
	            			<div id="monthOrderCounts" class="form-label col-md-4" style="font-size:20px;color:red;width:100%">
	                			<label for="">
	             
	                			</label>
	            			</div>
	            			<a href="#" id="month_order" class="form-input col-md-2" style="font-size:20px;width:100%">
	               			本&nbsp&nbsp月
	            			</a>
	            		
	            		</div>
            		
            	</div>	
   			</div>
   			
   			<#--<div style="height:70px;100%">
   				
   				<div style="width:50%;float:left">
   					<div style="height:40px;background:gray;text-align:center;font-size:18px">
   						新用户
   					</div>
   					<div id="newOrderAccountCounts" style="border:1px dashed #CCCCFF;height:35px;text-align:center;font-size:18px">
   						
   					</div>
   				</div>
   				
   				<div style="width:50%;float:left">
   					<div  style="height:40px;background:gray;text-align:center;font-size:18px">
   						老用户
   					</div>
   					<div id="oldOrderAccountCounts" style="border:1px dashed #CCCCFF;height:35px;text-align:center;font-size:18px">
   				
   					</div>
   				</div>
   				
   			</div>-->
   			
   			
   		</div>
   	
   		
   		
   		<div class="userDiv">
   			<div style="background:#CCCCFF;height:100px">
   				<span style="font-size:20px;text-align:center">测&nbsp试&nbsp异&nbsp常&nbsp接&nbsp口</span>
            	<div>
	            		<div style="width:28%;margin-left:54px;float:left">
	            			<div  id="todayUserCounts" class="form-label col-md-4" style="font-size:20px;color:red;width:100%">
	                			<label for="">
	                  			
	                			</label>
	            			</div>
	            			<a href="#" id="today_user" class="form-input col-md-2" style="font-size:20px;width:100%">
	               			今&nbsp&nbsp日
	            			</a>
	            		
	            		</div>
            		
	            		<div style="width:28%;float:left">
	            			<div id="weekUserCounts"class="form-label col-md-4" style="font-size:20px;color:red;width:100%">
	                			<label for="">
	                  			
	                			</label>
	            			</div>
	            			<a href="#" id="week_user" class="form-input col-md-2" style="font-size:20px;width:100%">
	               			本&nbsp&nbsp周
	            			</a>
	            		
	            		</div>
            		
	            		<div style="width:32%;float:right">
	            			<div id="monthUserCounts" class="form-label col-md-4" style="font-size:20px;color:red;width:100%">
	                			<label for="">
	                  			
	                			</label>
	            			</div>
	            			<a href="#" id="month_user" class="form-input col-md-2" style="font-size:20px;width:100%">
	               			本&nbsp&nbsp月
	            			</a>
	            		
	            		</div>
            		
            	</div>	
   			</div>
   			
   			<<#--div style="height:70px;100%">
   				
   				<div style="width:33%;float:left">
   					<div style="height:40px;background:gray;text-align:center;font-size:18px">
   						已实名
   					</div>
   					<div id="actualUserCounts" style="border:1px dashed #CCCCFF;height:35px;text-align:center;font-size:18px">
   						
   					</div>
   				</div>
   				
   				<div style="width:33%;float:left">
   					<div  style="height:40px;background:gray;text-align:center;font-size:18px">
   						未实名
   					</div>
   					<div id="unActualUserCounts" style="border:1px dashed #CCCCFF;height:35px;text-align:center;font-size:18px">
   					</div>
   				</div>
   				
   				<div style="width:33%;float:left">
   					<div  style="height:40px;background:gray;text-align:center;font-size:18px">
   						黑名单
   					</div>
   					<div id="blackUserCounts" style="border:1px dashed #CCCCFF;height:35px;text-align:center;font-size:18px">
   					</div>
   				</div>
   			</div>-->
   			
   			
   		</div>
   </div>   
   
   
  <div id="canvas-holder">
		<div class="center-div">
			<div class="col-md-6" id="order" >
			</div> 
	   </div>
  </div> 
  
   <div id="canvas-holder">
		<div class="center-div">
			<div class="col-md-6" id="user" >
			</div> 
	   </div>
  </div>  
   
   
</div>

<script type="text/javascript" src="/assets/js/minified/demo/exporting.js"></script>
<script type="text/javascript" src="/assets/js/minified/demo/highcharts.js"></script>
<script>

   function orderChart(categories,series){
    $('#order').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '接口请求统计（个）'
        },
        xAxis: {
            categories: categories
        },
        yAxis: {
            min: 0,
            title: {
                text: '个'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y}单</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: '接口总数',
            data: series
        }]   
    });
	}


	function userChart(categories,series){
		$('#user').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: '异常接口统计（个）'
	        },
	        xAxis: {
	            categories:categories
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '个'
	            }
	        },
	        tooltip: {
	            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	            pointFormat: '<tr><td style="color:red;padding:0">{series.name}: </td>' +
	                '<td style="padding:0"><b>{point.y}个</b></td></tr>',
	            footerFormat: '</table>',
	            shared: true,
	            useHTML: true
	        },
	        plotOptions: {
	            column: {
	                pointPadding: 0.2,
	                borderWidth: 0
	            }
	        },
	        series: [{
	             name: '异常接口',
	             data: series
	        }]
	    });
	}

$.ajax({ 
     	type: "post", 
		url: "/getRecent12Month", 
		dataType: "json", 
        success: function (data) { 
                getRecent12MonthUsers(data);
        }
});  
function getRecent12MonthUsers(categories){
	$.ajax({ 
     	type: "post", 
		url: "/getRecent12MonthUsers", 
		dataType: "json", 
        success: function (data) { 
    		     userChart(categories,data);
        }
	});
}
 
  
$.ajax({ 
     	type: "post", 
		url: "/getRecent12Month", 
        dataType: "json", 
        success: function (data) { 
                getRecent12MonthOrders(data);
        }
});  
function getRecent12MonthOrders(categories){
	$.ajax({ 
     	type: "post", 
		url: "/getRecent12MonthOrders", 
        dataType: "json", 
        success: function (data) { 
    		     orderChart(categories,data);
        }
	});
}


$.ajax({ 
     	type: "post", 
		url: "/getDiffTimeOrdersCounts", 
        dataType: "json", 
        success: function (data) { 
				$('#todayOrderCounts').text(data.todayOrderCounts);
				$('#weekOrderCounts').text(data.weekOrderCounts);
				$('#monthOrderCounts').text(data.monthOrderCounts);
				$('#newOrderAccountCounts').text(data.todayNewAccountCounts);
				$('#oldOrderAccountCounts').text(data.oldAccountCounts);        		
        }
});


$.ajax({ 
     	type: "post", 
		url: "/getDiffTimeUserCounts", 
        dataType: "json", 
        success: function (data) { 
        		$('#todayUserCounts').text(data.todayCounts);
				$('#weekUserCounts').text(data.weekCounts);
				$('#monthUserCounts').text(data.monthCounts);
				$('#actualUserCounts').text(data.todayActualRegisterCounts);
				$('#unActualUserCounts').text(data.todayUnActualCounts);    
				$('#blackUserCounts').text(data.blackCounts);       
        }
});




$("#month_order").click(
	function(){
		$.ajax({
			type:"post",
			url:"/ajaxGetOrdersCountsType",
			data:{type:'MONTH'},
			dataType:"json",
			success:function(data){
				$('#newOrderAccountCounts').text(data.newUserOrderCounts);
				$('#oldOrderAccountCounts').text(data.oldUserOrderCounts);
			}
		});
	}
)


$("#week_order").click(
	function(){
		$.ajax({
			type:"post",
			url:"/ajaxGetOrdersCountsType",
			data:{type:'WEEK'},
			dataType:"json",
			success:function(data){
				$('#newOrderAccountCounts').text(data.newUserOrderCounts);
				$('#oldOrderAccountCounts').text(data.oldUserOrderCounts);
			}
		});
	}
)

$("#today_order").click(
	function(){
		$.ajax({
			type:"post",
			url:"/ajaxGetOrdersCountsType",
			data:{type:'TODAY'},
			dataType:"json",
			success:function(data){
				$('#newOrderAccountCounts').text(data.newUserOrderCounts);
				$('#oldOrderAccountCounts').text(data.oldUserOrderCounts);
			}
		});
	}
)


$("#month_user").click(
	function(){
		$.ajax({
			type:"post",
			url:"/ajaxGetUserCountsType",
			data:{type:'MONTH'},
			dataType:"json",
			success:function(data){
				$('#actualUserCounts').text(data.actualNameCounts);
				$('#unActualUserCounts').text(data.unactualNameCounts);    
				$('#blackUserCounts').text(data.blacks);
			}
		});
	}
)

$("#week_user").click(
	function(){
		$.ajax({
			type:"post",
			url:"/ajaxGetUserCountsType",
			data:{type:'WEEK'},
			dataType:"json",
			success:function(data){
				$('#actualUserCounts').text(data.actualNameCounts);
				$('#unActualUserCounts').text(data.unactualNameCounts);    
				$('#blackUserCounts').text(data.blacks);
			}
		});
	}
)

$("#today_user").click(
	function(){
		$.ajax({
			type:"post",
			url:"/ajaxGetUserCountsType",
			data:{type:'TODAY'},
			dataType:"json",
			success:function(data){
				$('#actualUserCounts').text(data.actualNameCounts);
				$('#unActualUserCounts').text(data.unactualNameCounts);    
				$('#blackUserCounts').text(data.blacks);
			}
		});
	}
)


</script>