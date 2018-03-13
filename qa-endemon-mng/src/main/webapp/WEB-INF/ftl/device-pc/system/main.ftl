
<!-- AUI Framework -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>${title} - 信程分期运营管理系统</title>
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

    <!-- Favicons -->

    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/assets/images/icons/apple-touch-icon-144-precomposed.png" />
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/assets/images/icons/apple-touch-icon-114-precomposed.png" />
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/assets/images/icons/apple-touch-icon-72-precomposed.png" />
    <link rel="apple-touch-icon-precomposed" href="/assets/images/icons/apple-touch-icon-57-precomposed.png" />
    <link rel="shortcut icon" href="/assets/images/icons/favicon.ico" />

    <!--[if lt IE 9]>
    <script src="/assets/js/minified/core/html5shiv.min.js"></script>
    <script src="/assets/js/minified/core/respond.min.js"></script>
    <![endif]-->

    <!-- Fides Admin CSS Core -->

    <link rel="stylesheet" type="text/css" href="/assets/css/minified/aui-production.min.css" />

    <!-- Theme UI -->

    <link id="layout-theme" rel="stylesheet" type="text/css" href="/assets/themes/minified/fides/color-schemes/dark-blue.min.css" />

    <!-- Fides Admin Responsive -->

    <link rel="stylesheet" type="text/css" href="/assets/themes/minified/fides/common.min.css" />
    <link rel="stylesheet" type="text/css" href="/assets/themes/minified/fides/responsive.min.css" />
    <link rel="stylesheet" type="text/css" href="/assets/multiupload/fileupload.css" />
    
    <script type="text/javascript" src="/assets/js/minified/aui-production.js"></script>
    

   
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body style="overflow: auto;" style="text-align:center;width:100%">
	<div  class="demo-example">
		<div id="page-title" >
			<h3 style="text-align:center;width:100%">
				信程分期数据统计
			</h3>
    	</div>
	</div>
		
        <div class="tabs ui-tabs ui-widget ui-widget-content ui-corner-all" >
            <ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist" style="text-align:center">
                <li class="ui-state-default ui-corner-top ui-tabs-active ui-state-active" role="tab" tabindex="0" aria-controls="icon-only-tabs-1" aria-labelledby="ui-id-7" aria-selected="true" >
                    <a href="#icon-only-tabs-1" title="Tab 1" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-7">今日统计</a>
                </li>
                <li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="icon-only-tabs-2" aria-labelledby="ui-id-8" aria-selected="false" >
                    <a href="#icon-only-tabs-2" title="Tab 2" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-8">昨日统计</a>
                </li>
                <li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="icon-only-tabs-3" aria-labelledby="ui-id-9" aria-selected="false" >
                    <a href="#icon-only-tabs-3" title="Tab 3" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-9">七日统计</a>
                </li>
            </ul>
            
            <#list list as dayList>
             <div id="icon-only-tabs-${dayList.index}" aria-labelledby="ui-id-7" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="true" aria-hidden="false" style="display: block;text-align:center;width:100%">
                	
                	<table stle="width:92%">
                		<tr><td colspan="2" style="text-align:left;">交易量（元）</td></tr>
                		<tr><td colspan="2"  style="text-align:center;font-size: 48px;color: red">${dayList.paidAmount}</td></tr>
                		<tr style="text-align:left;"><td >累计交易量：${dayList.sales}元</td><td >保有量：${dayList.inven}元</td></tr>
                		
                	</table>
                	
                <div class="divider"></div>
                
                	<table width="92%"  >
						<tr><td colspan="2" style="text-align:left;">用户统计</td></tr>
                		<tr><td colspan="2" class="divider" style="text-align:left;"></td></tr>
                		<tr style="text-align:left;"><td >新注册用户：${dayList.dayOfRegister}</td><td >交易用户：${dayList.numOfBuyers}</td></tr>
                		<tr style="text-align:left;"><td >首次交易用户：${dayList.numOfNewBuyers}</td><td >新注册交易用户：${dayList.registerBuyers}</td></tr>
                		<tr style="text-align:left;"><td >二次交易用户：${dayList.twiceBuyers}</td><td >交易金额大于1500元：${dayList.fifteenBuyers}</td></tr>
                		
					</table>
					
				<div class="divider"></div>
				<div style="text-align:left;">渠道统计</div>
				
				
					<#list dayList.map?keys as paygateKey>
					<table width="92%" border="1" >
	                		<tr ><td width="20%"><#if paygateKey=="offline">线下交易<#elseif paygateKey=="LLPay">连连支付<#elseif paygateKey=="YeePay">易宝支付<#elseif paygateKey=="ChinaPay">银联支付<#elseif paygateKey=="Mizb">信程分期宝支付</#if>支付渠道</td><td width="20%">总金额（元）</td><td width="20%">成功金额（元）</td><td width="5%">总笔数</td><td width="5%">成功笔数</td><td width="10%">成功率</td></tr>
	                			<#list dayList.map[paygateKey]?keys as paygate>
								<tr ><td >${paygate}</td><td >${dayList.map[paygateKey][paygate].amount}</td>
								
								<td >${dayList.map[paygateKey][paygate].samount}</td>
								<td >${dayList.map[paygateKey][paygate].total}</td>
								<td >${dayList.map[paygateKey][paygate].success}</td>
								
								<td>
								<#if dayList.map[paygateKey][paygate].success==dayList.map[paygateKey][paygate].total>
									${dayList.map[paygateKey][paygate].success/dayList.map[paygateKey][paygate].total*100}%
								<#else>
									${(dayList.map[paygateKey][paygate].success/dayList.map[paygateKey][paygate].total*100)?string('0.00')}%
								
								</#if>
								</td>
	                			</tr>
	                			</#list>
					</table>
					<div class="divider"></div>
					</#list>
					
             </div>
            </#list>
            
            
            
        </div>

</body >

