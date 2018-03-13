<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>米庄理财QA管理系统登录</title>
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />


    <link rel="stylesheet" type="text/css" href="/assets/css/minified/aui-production.min.css" />
    <link id="layout-theme" rel="stylesheet" type="text/css" href="/assets/themes/minified/fides/color-schemes/dark-blue.min.css" />
    <script type="text/javascript" src="/assets/js/minified/aui-production.js"></script>
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
</head>
<body style="overflow: hidden;">

<div id="loading" class="ui-front loader ui-widget-overlay bg-white opacity-100">
    <img src="/assets/images/loader-dark.gif" alt="" />
</div>
<div id="page-wrapper" class="demo-example">
<div id="page-header" class="clearfix">
</div><!-- #page-header -->
<div id="page-content">
<div class="pad20A mrg25T">
    <div class="row mrg25T">
        <form id="form" action="/login" class="col-md-4 center-margin form-vertical mrg25T" method="POST">
            <div class="ui-dialog modal-dialog mrg25T" id="login-form" style="position: relative !important;">
                <div class="ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix">
                    <span class="ui-dialog-title">米庄理财QA管理系统登录</span>
                </div>
                <div class="pad20A pad0B ui-dialog-content ui-widget-content">
                	<#if errorMsg??>
                		<div class="infobox error-bg mrg20B">
		                    <p>${errorMsg}</p>
		                </div>	
                	</#if>
                    <div class="form-row">
                        <div class="form-label col-md-2">
                            <label for="">
                                用户名:
                            </label>
                        </div>
                        <div class="form-input col-md-10">
                            <div class="form-input-icon">
                                <i class="glyph-icon icon-phone ui-state-default"></i>
                                <input placeholder="用户名" value="" type="text" name="username" id="username" data-required="true">
                            </div>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-label col-md-2">
                            <label for="">
                                密码:
                            </label>
                        </div>
                        
                        <div class="form-input col-md-10">
                            <div class="form-input-icon">
                                <i class="glyph-icon icon-unlock-alt ui-state-default"></i>
                                <input placeholder="密码" value="" type="password" name="password" id="pass" data-required="true">
                            </div>
                        </div>
                    </div>
                    <#if ipIllegal == true>
                        <input type="hidden" name="certify" value="true"/>
                        <div class="form-row">
                            <div class="form-label col-md-2">
                                <label for="">
                                    验证码:
                                </label>
                            </div>
                            <div class="form-input col-md-10">
                                <div class="form-input-icon">
                                    <i class="glyph-icon icon-unlock-alt ui-state-default"></i>
                                    <input placeholder="验证码" value="" type="text" name="code" id="code" style="width: auto">
                                    <#--<input type="button" onclick="sendCode()" class="btn" style="width: auto" value="发送验证码">-->
                                    <a href="javascript:;" class="btn large primary-bg radius-all-2" id="search" title="Validate!" onclick="sendCode();">
                                    <span class="button-content" id="sendcode">
                                       发送验证码
                                    </span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    <#else>
                        <input type="hidden" name="certify" value="false"/>
                    </#if>
                </div>
                <div class="ui-dialog-buttonpane text-center">

                    <button type="submit" class="btn large primary-bg text-transform-upr font-bold font-size-11 radius-all-4" id="demo-form-valid" title="Validate!"
                    	onclick="$('#form').parsley( 'validate' );">
                        <span class="button-content">
                            登录
                        </span>
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>

</div><!-- #page-content -->
</div><!-- #page-main -->
</div><!-- #page-wrapper -->
</body>
<script>

    var enableSend = true;
    function sendCode(){
        if(enableSend){
            $.get("/sendcode", {username:$("#username").val(),password:$("#pass").val() }, function(data){
                if("" != data){
                    alert("用户名或密码错误!");
                } else {
                    time($('#sendcode'));
                }
            });
        }
    }

    // 倒计时
    var wait = 15;
    function time(o) {
        if (wait == 0) {
            enableSend = true;
            $('#search').attr("class","btn large primary-bg radius-all-2");
            $('#search').attr("onClick","sendCode();");
            o.html("发送验证码");
            wait = 15;
        } else {
            enableSend = false;
            $('#search').attr("class","btn large ui-state-default");
            $('#search').attr("onClick","");
            o.html("重新发送(" + wait + ")");
            wait--;
            setTimeout(function () {
                        time(o)
                    },
                    1000)
        }
    }
</script>
</html>
