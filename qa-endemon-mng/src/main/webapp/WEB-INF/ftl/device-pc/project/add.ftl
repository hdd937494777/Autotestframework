<#import "/macro.ftl" as m>
<@m.page_header title='后台' />
<script type="text/javascript" src="/assets/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="/assets/ueditor/ueditor.all.js"></script>
<script type="text/javascript" src="/assets/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="/assets/js/md5.js"></script>

<div id="page-content-wrapper">

    <div id="page-title">

        <h3>
        <#if member>修改<#else>添加</#if>服务
        </h3>
    </div>
    <div class="pad10A">
    <#if project>
    <form id="demo-form1" action="/project/update" class="col-md-12" method="POST">
        <input type="hidden" name="id" value="${((project.id)!'')}"/>
    <#else>
    <form id="demo-form1" action="/project/add" class="col-md-12" method="POST">
    </#if>
        <div class="form-row">
            <div class="form-label col-md-2">
                <label for="">
                    项目名:
                    <span class="required">*</span>
                </label>
            </div>
            <div class="form-input col-md-8">
                <input type="text" id="projectName" name="projectName" data-trigger="change" data-required="true"
                       class="parsley-validated"
                       value="${((project.projectName)!'')}">
            </div>
        </div>

		<div class="form-row">
            <div class="form-label col-md-2">
                <label for="">
                    项目host:
                    <span class="required">*</span>
                </label>
            </div>
            <div class="form-input col-md-8">
                <input type="text" id="projectHost" name="projectHost" data-trigger="change" data-required="true"
                       class="parsley-validated"
                       value="${((project.projectHost)!'')}">
            </div>
        </div>


    </form>
        <div class="divider"></div>
        <div class="form-row">
            <div class="form-input col-md-10 col-md-offset-2">
                <a href="javascript:;" class="btn medium primary-bg radius-all-4 col-md-2" id="demo-form-2-valid">
                    提交
                </a>
                <a href="/project/list" class="btn medium primary-bg radius-all-4 col-md-2">
                    取消
                </a>
            </div>
        </div>
    </div>
</div>


<script>
    $("#demo-form-2-valid").click(function () {
        $('option').val();
        $('#demo-form1').parsley('validate');
        $('#demo-form1').trigger('submit');
    });
</script>