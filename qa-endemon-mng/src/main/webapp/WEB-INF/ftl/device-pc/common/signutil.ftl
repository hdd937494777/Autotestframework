<#import "/macro.ftl" as m>
<@m.page_header title='后台' />
<script type="text/javascript" src="/assets/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="/assets/ueditor/ueditor.all.js"></script>
<script type="text/javascript" src="/assets/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="/assets/js/md5.js"></script>

<div id="page-content-wrapper">

    <div id="page-title">

        <h3>
        加签
        </h3>
    </div>
    <div class="pad10A">
        <div class="form-row">
            <div class="form-label col-md-2">
                <label for="">
                    requestId:
                    <span class="required">*</span>
                </label>
            </div>
            <div class="form-input col-md-8">
                <input type="text" id="requestId" name="requestId" data-trigger="change" data-required="true"
                       class="parsley-validated"
                       value="">
            </div>
        </div>

        <div class="form-row">
            <div class="form-label col-md-2">
                <label for="">
                    加密字段:
                    <span class="required">*</span>
                </label>
            </div>
            <div class="form-input col-md-8">
                <input type="textarea" id="data" name="data" data-trigger="change" data-required="true"
                       class="parsley-validated"
                       value="">
            </div>
        </div>

		<div class="form-row">
            <div class="form-label col-md-2">
                <label for="">
                    加密后字段:
                    <span class="required">*</span>
                </label>
            </div>
            <div class="form-input col-md-8">
                <input type="textarea" id="signData" name="signData" data-trigger="change" data-required="true"
                       class="parsley-validated"
                       value="">
            </div>
        </div>

        <div class="form-row">
            <div class="form-label col-md-2">
                <label for="">
                    加密后获得token:
                    <span class="required">*</span>
                </label>
            </div>
            <div class="form-input col-md-8">
                <input type="text" id="token" name="token" data-trigger="change" data-required="true"
                       class="parsley-validated"
                       value="">
            </div>
        </div>

        <div class="divider"></div>
        <div class="form-row">
            <input type="hidden" name="superhidden" id="superhidden">

            <div class="form-input col-md-10 col-md-offset-2">
                <a href="javascript:void(0);" class="btn medium primary-bg radius-all-4 col-md-2" id="demo-form-2-valid"  onclick="tokens();">
                    获取token
                </a>
                <a href="javascript:void(0);" class="btn medium primary-bg radius-all-4 col-md-2" id="demo-form-2-valid"  onclick="signs();">
                   加密
                </a>
            </div>
        </div>
    </div>
</div>
<script>
   // console.log("fsfsf")
</script>


<script  language="JavaScript">
    function signs(){
        var data1 = $("#data").val();
        $.ajax({
            url : "/common/sign",
            type : 'post',
            data:{
                signData:data1
            },
            success : function (data) {
                if (data.retCode == 'SUCCESS') {
                    $("#signData").val(data.cipher);
                    $.jGrowl(data.retMsg, {sticky:!1,position:"bottom-right",theme:"bg-green"});
                } else {
                    $.jGrowl(data.retMsg, {sticky:!1,position:"bottom-right",theme:"bg-red"});
                }
            },
            error : function () {
                $.jGrowl("加密请求异常", {sticky:!1,position:"bottom-right",theme:"bg-red"});
            },
        });
    };


    function tokens(){
        var requestId = $("#requestId").val();
        $.ajax({
            url : "/common/token",
            type : 'post',
            data:{
                requestId:requestId
            },
            success : function (data) {
                if (data.retCode) {
                    $("#token").val(data.token);
                    $.jGrowl(data.retMsg, {sticky:!1,position:"bottom-right",theme:"bg-green"});
                } else {
                    $.jGrowl(data.retMsg, {sticky:!1,position:"bottom-right",theme:"bg-red"});
                }
            },
            error : function () {
                $.jGrowl("加密请求异常", {sticky:!1,position:"bottom-right",theme:"bg-red"});
            },
        });
    };

</script>