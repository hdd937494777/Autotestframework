<#macro page_header title='' >
<!-- AUI Framework -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>${title} - 米庄理财QA管理系统</title>
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

    <!-- Fides Admin JS -->

    <script type="text/javascript" src="/assets/js/minified/aui-production.js"></script>
    <script type="text/javascript" src="/assets/js/messager.js"></script>
    <script type="text/javascript" src="/assets/js/util.js"></script>
    <script type="text/javascript" src="/assets/timeplug/WdatePicker.js"></script>
    <script>
        jQuery(window).load(
                function(){
                    var wait_loading = window.setTimeout( function(){
                                $('#loading').slideUp('fast');
                                jQuery('body').css('overflow','auto');
                            },1000
                    );
                });

    </script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
    <style>
    	.spanClass{
    		color:red;
    		font-weight:bold;
    		display:inline
    	
    	}
    </style>
    
</head>
<body style="overflow: hidden;">


<div id="loading" class="ui-front loader ui-widget-overlay bg-white opacity-100">
    <img src="/assets/images/loader-dark.gif" alt="" />
</div>

<div id="page-wrapper" class="demo-example">

<div class="theme-customizer">
    <a href="javascript:;" class="change-theme-btn" title="Change theme">
        <i class="glyph-icon icon-cog"></i>
    </a>
    <div class="theme-wrapper">

        <div class="popover-title">Boxed layout options</div>
        <div class="pad10A clearfix">
            <a class="fluid-layout-btn hidden bg-blue-alt medium btn" href="javascript:;" title=""><span class="button-content">Full width layout</span></a>
            <a class="boxed-layout-btn bg-blue-alt medium btn" href="javascript:;" title=""><span class="button-content">Boxed layout</span></a>
        </div>
        <div class="popover-title">Boxed layout backgrounds</div>
        <div class="popover-title">Color schemes</div>
        <div class="pad10A clearfix change-layout-theme">
            <p class="font-gray-dark font-size-11 pad0B">More color schemes will be available soon!</p>
            <div class="divider mrg10T mrg10B"></div>
            <a href="javascript:;" class="choose-theme" layout-theme="dark-blue" title="">
                <span style="background: #2381E9;"></span>
            </a>
            <a href="javascript:;" class="choose-theme opacity-30 mrg15R" layout-theme="white-blue" title="">
                <span style="background: #2381E9;"></span>
            </a>
            <a href="javascript:;" class="choose-theme" layout-theme="dark-green" title="D">
                <span style="background: #78CE12;"></span>
            </a>
            <a href="javascript:;" class="choose-theme opacity-30 mrg15R" layout-theme="white-green" title="D">
                <span style="background: #78CE12;"></span>
            </a>
            <a href="javascript:;" class="choose-theme" layout-theme="dark-orange" title="">
                <span style="background: #FF6041;"></span>
            </a>
            <a href="javascript:;" class="choose-theme opacity-30 mrg15R" layout-theme="white-orange" title="">
                <span style="background: #FF6041;"></span>
            </a>
        </div>

    </div>
</div>

<div id="page-header" class="clearfix">
<div id="header-logo">
    <a href="javascript:;" class="tooltip-button" data-placement="bottom" title="Close sidebar" id="close-sidebar">
        <i class="glyph-icon icon-caret-left"></i>
    </a>
    <a href="javascript:;" class="tooltip-button hidden" data-placement="bottom" title="Open sidebar" id="rm-close-sidebar">
        <i class="glyph-icon icon-caret-right"></i>
    </a>
    <a href="javascript:;" class="tooltip-button hidden" title="Navigation Menu" id="responsive-open-menu">
        <i class="glyph-icon icon-align-justify"></i>
    </a>
    <a href="/gotoMain" style="width: auto;float:none;">米庄理财QA管理系统</a>
</div>
<div class="hide" id="black-modal-60" title="Modal window example">
    <div class="pad20A">

        <div class="infobox notice-bg">
            <div class="bg-azure large btn info-icon">
                <i class="glyph-icon icon-bullhorn"></i>
            </div>
            <h4 class="infobox-title">Modal windows</h4>
            <p>Thanks to the solid modular Fides Admin arhitecture, modal windows customizations are very flexible and easy to apply.</p>
        </div>


        <a class="btn medium radius-all-4 mrg5A ui-state-default tooltip-button" title="icon-compass" href="../icon/compass"><i class="glyph-icon icon-compass"></i></a>


    </div>
</div>
<div class="user-profile dropdown">
    <a href="javascript:;" title="" class="user-ico clearfix" data-toggle="dropdown">
        <img width="36" src="/assets/images/gravatar.jpg" alt="" />
        <span><#if sn_miz_admin_usersession.chineseName??>${sn_miz_admin_usersession.chineseName}<#else>${sn_miz_admin_usersession.name}</#if></span>
        <i class="glyph-icon icon-chevron-down"></i>
    </a>
    <ul class="dropdown-menu float-right">
    	<li>
            <a href="/modifypassword" title="">
                <i class="glyph-icon icon-cog font-size-13 mrg5R"></i>
                <span class="font-bold">修改密码</span>
            </a>
        </li>
        <li>
            <a href="/logout" title="">
                <i class="glyph-icon icon-signout font-size-13 mrg5R"></i>
                <span class="font-bold">退出</span>
            </a>
        </li>
    </ul>
</div>
<div class="top-icon-bar">
<div class="dropdown">

    <a data-toggle="dropdown" a-href="javascript:;" id="dropdown" title="">
        <span class="badge badge-absolute bg-orange" ><div  id="messageNotifyTotalNumbers"></div></span>
        <i class="glyph-icon icon-envelope-alt"></i>
    </a>
    <div class="dropdown-menu">

        <div class="scrollable-content medium-box scrollable-small" style="width:550px">

            <ul class="no-border messages-box" id="message-ul">
            
            </ul>

        </div>
        <div class="pad10A button-pane button-pane-alt">
            <a href="messaging.html" class="btn small float-left bg-white">
                <span class="button-content text-transform-upr font-size-11">All messages</span>
            </a>
            <div class="button-group float-right">
                <a href="javascript:;" class="btn small primary-bg">
                    <i class="glyph-icon icon-star"></i>
                </a>
                <a href="javascript:;" class="btn small primary-bg">
                    <i class="glyph-icon icon-random"></i>
                </a>
                <a href="javascript:;" class="btn small primary-bg">
                    <i class="glyph-icon icon-map-marker"></i>
                </a>
            </div>
            <a href="javascript:;" class="small btn bg-red float-right mrg10R tooltip-button" data-placement="left" title="Remove comment">
                <i class="glyph-icon icon-remove"></i>
            </a>
        </div>

    </div>
</div>

</div>

</div><!-- #page-header -->

<div id="page-sidebar" class="scrollable-content">

<div id="sidebar-menu">
<ul>

<li>
    <a href="javascript:;" title="Setting">
        <i class="glyph-icon icon-cog"></i>
        设置
    </a>

</li>



<li>
    <a href="javascript:;" title="资源角色管理">
        <i class="glyph-icon icon-female"></i>
        资源角色管理
    </a>
    <ul>
    <@resourceAccess url="/rolemanagement/member">
        <li>
            <a href="/rolemanagement/member" title="账户管理">
                <i class="glyph-icon icon-chevron-right"></i>
                账户管理
            </a>
        </li>
    </@resourceAccess>
    <@resourceAccess url="/rolemanagement/role">
        <li>
            <a href="/rolemanagement/role" title="角色管理">
                <i class="glyph-icon icon-chevron-right"></i>
                角色管理
            </a>
        </li>
    </@resourceAccess>
    <@resourceAccess url="/rolemanagement/resources">
        <li>
            <a href="/rolemanagement/resources" title="权限管理">
                <i class="glyph-icon icon-chevron-right"></i>
                权限管理
            </a>
        </li>
    </@resourceAccess>
    </ul>
</li>


    <li>
        <a href="javascript:;" title="接口测试管理">
            <i class="glyph-icon icon-female"></i>
            接口测试管理
        </a>
        <ul>
            <@resourceAccess url="/project/list">
                <li>
                    <a href="/project/list" title="项目管理">
                        <i class="glyph-icon icon-chevron-right"></i>
                        项目管理
                    </a>
                </li>
            </@resourceAccess>
            <@resourceAccess url="/interface/servicelist">
                <li>
                    <a href="/interface/servicelist" title="服务列表管理">
                        <i class="glyph-icon icon-chevron-right"></i>
                        服务列表管理
                    </a>
                </li>
            </@resourceAccess>
            <@resourceAccess url="/interface/requestlist">
                <li>
                    <a href="/interface/requestlist" title="请求管理">
                        <i class="glyph-icon icon-chevron-right"></i>
                        请求管理
                    </a>
                </li>
            </@resourceAccess>
            <@resourceAccess url="/interface/exceptionlist">
                <li>
                    <a href="/interface/exceptionlist" title="异常请求管理">
                        <i class="glyph-icon icon-chevron-right"></i>
                        异常请求管理
                    </a>
                </li>
            </@resourceAccess>
            <@resourceAccess url="/common/gosign">
                <li>
                    <a href="/common/gosign" title="签名请求管理">
                        <i class="glyph-icon icon-chevron-right"></i>
                        签名请求管理
                    </a>
                </li>
            </@resourceAccess>
        </ul>
    </li>
</ul>
<script>

    $(function(){
        // 移除没有二级菜单的一级菜单
        var lis = $('#sidebar-menu > ul > li');
        for(var i = lis.length - 1; i >= 0; i--){
            li = lis[i];
            var a = $(li).find('> a');
            if(a.attr('href') == 'javascript:;'){
                var items = $(li).find('ul > li');
                var length = items.length;
                if(length < 1){
                    $(li).remove();
                }
            }
        }
    });
    
    
    setInterval(()=>getMessageNotifys(),60000);
    getMessageNotifys();
    function getMessageNotifys(){
    	$.ajax({
	        type:"post",
	        url:"/message/getMessageNotifys",
	        success:function(data){
	            $('#messageNotifyTotalNumbers').text(data);
	        }
	    });
    }
	
	
	
	 $(function(){
        $("#dropdown").click(function(){
          $.ajax({
          		type:"post",
          		url:"/message/getMessageNotifyLists",
          		dataType:"json",
          		success:function(data){
            			$("#message-ul").empty();
            			var messageBody = "";
            			
          				for(i=0;i<data.length;i++){
          				
             				var $tr=`<li>
                    					<div class="messages-img">
                        					<img width="32" src="/assets/images/gravatar.jpg" alt="" />
                    					</div>
                    					<div class="messages-content">
                       						 <div class="messages-title">
                            						<i class="glyph-icon icon-warning-sign font-red"></i>
                            						<a href="`+data[i].url+`" title="Message title">`+data[i].titl+`</a>
                            						<div class="messages-time">`+data[i].generateTime+`
                                						<span class="glyph-icon icon-time"></span>
                            						</div>
                        					</div>
                        				<div class="messages-text">
                            					`+data[i].content+`
                       					 </div>
                    					</div>
               						 </li>`
               						 
             				messageBody += $tr; 
            				
           				 }
           				 document.getElementById("message-ul").innerHTML=messageBody;
         			 }
          		});
           
        	});
      });
</script>
</div>

</div><!-- #page-sidebar -->

<div id="page-content">
</#macro>


<#macro page_footer>




</div><!-- #page-content -->
</div><!-- #page-main -->
</div><!-- #page-wrapper -->

</body>
</html>
</#macro>



<#macro p page totalpage>
    <@compress single_line=true>
        <#if (request.queryString)??>
            <#assign requestParams=request.queryString?replace("\\&?p=(\\d+)\\&?","","r") />
            <#if requestParams?has_content>
                <#assign requestParams = '&' + requestParams />
            </#if>
        </#if>
        <#assign currentPage=page?number >
        <#if currentPage-4 gt 0>
            <#assign beginPage = currentPage-4 />
        <#else>
            <#assign beginPage = 1 />
        </#if>
        <#if totalpage-currentPage lt 4>
            <#assign beginPage = beginPage - (4-totalpage + currentPage)  />
            <#if beginPage lt 1>
                <#assign beginPage = 1 />
            </#if>
        </#if>
        <#if currentPage-1 gt 0>
        <a class="page_a page_prev" href="?p=${currentPage-1}${requestParams}"></a>
        <#else>
        <span class="page_a page_prev" class="disabled"></span>
        </#if>
        <#if currentPage gt 5 && totalpage gt 10 >
        <a class="page_a" href="?p=1${requestParams}">1</a> <span>...</span>
        </#if>
        <#assign endPage=beginPage+8 />
        <#if endPage gt totalpage>
            <#assign endPage=totalpage />
            <#assign beginPage=endPage-8 />
        </#if>
        <#if beginPage lt 1>
            <#assign beginPage = 1 />
        </#if>
        <#if endPage lt 1>
            <#assign endPage = 1 />
        </#if>
        <#list beginPage..endPage as x>
            <#if x == currentPage>
            <span class="current page_a page_a_now">${x}</span>
            <#else>
            <a class="page_a" href="?p=${x}${requestParams}">${x}</a>
            </#if>
        </#list>
        <#if currentPage lte totalpage - 5 && totalpage gt 10>
        <span class="page_dots">...</span> <a href="?p=${totalpage}${requestParams}" class="page_a">${totalpage}</a>
        </#if>
        <#if currentPage lt totalpage>
        <a class="page_a page_next" href="?p=${currentPage+1}${requestParams}"></a>
        <#else>
        <span class="disabled page_a page_next"></span>
        </#if>
    </@compress>
</#macro>
