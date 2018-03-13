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
    <#if services>
    <form id="demo-form1" action="/interface/updateservice" class="col-md-12" method="POST">
        <input type="hidden" name="id" value="${((services.id)!'')}"/>
    <#else>
    <form id="demo-form1" action="/interface/addservice" class="col-md-12" method="POST">
    </#if>
        <div class="form-row">
            <div class="form-label col-md-2">
                <label for="">
                    服务名:
                    <span class="required">*</span>
                </label>
            </div>
            <div class="form-input col-md-8">
                <input type="text" id="serviceName" name="serviceName" data-trigger="change" data-required="true"
                       class="parsley-validated"
                       value="${((services.serviceName)!'')}">
            </div>
        </div>

		<div class="form-row">
            <div class="form-label col-md-2">
                <label for="">
                    所属项目名:
                    <span class="required">*</span>
                </label>
            </div>
            <div class="form-input col-md-4">
                <select id="project" name="project" multiple="" class="chosen-select">
                <#list projectList as project>
                    <option name="roleManagers" value="${project.projectName}" <#if project.projectName == services.project>selected</#if>>${project.projectName}</option>
                </#list>
                </select>
            </div>
        </div>

        <div class="form-row">
            <div class="form-label col-md-2">
                <label for="">
                    请求地址:
                    <span class="required">*</span>
                </label>
            </div>
            <div class="form-input col-md-2">
                <input type="text" id="requestUrl" name="requestUrl" data-trigger="change"
               value="${((services.requestUrl)!'')}">
            </div>
        </div>

        <div class="form-row">
            <div class="form-label col-md-2">
                <label for="">
                    请求类型: <span class="required">*</span>
                </label>
            </div>
            <div class="form-input col-md-2">
                <select id="requestType" name="requestType" multiple="" class="chosen-select">
                    <option name="roleManagers" value="POST" <#if services.requestType == 'POST'>selected</#if>>POST</option>
                    <option name="roleManagers" value="GET" <#if services.requestType == 'GET'>selected</#if>>GET</option>
                </select>
            </div>

        </div>

        <div class="form-row">
            <div class="form-label col-md-2">
                <label for="">
                   入参地址:<span class="required">*</span>
                </label>
            </div>
            <div class="form-input col-md-2">
                <input type="text" id="requestDataUrl" name="requestDataUrl" data-trigger="change"
                       class="parsley-validated" value="${services.requestDataUrl}">
            </div>
        </div>
        <div class="form-row">
            <div class="form-label col-md-2">
                <label for="">
                    响应数据地址: <span class="required">*</span>
                </label>
            </div>
            <div class="form-input col-md-2">
                <input type="text" id="responseDataUrl" name="responseDataUrl" data-trigger="change"
                       class="parsley-validated" value="${services.responseDataUrl}">
            </div>
        </div>
        <div class="form-row">
            <div class="form-label col-md-2">
                <label for="">
                    响应时间: <span class="required">*</span>
                </label>
            </div>
            <div class="form-input col-md-2">
                <input type="text" id="timeOut" name="timeOut" data-trigger="change"
                       class="parsley-validated" value="${services.timeOut}">
            </div>
        </div>
        <div class="form-row">
            <div class="form-label col-md-2">
                <label for="">
                    并发数量: <span class="required">*</span>
                </label>
            </div>
            <div class="form-input col-md-2">
                <input type="text" id="concurrent_count" name="concurrentCount" data-trigger="change"
                       class="parsley-validated" value="${services.concurrentCount}">
            </div>
        </div>
        <div class="form-row">
            <div class="form-label col-md-2">
                <label for="">
                    服务描述:
                </label>
            </div>
            <div class="form-input col-md-2">
                <input type="text" id="description" name="description" data-trigger="change"
                       class="parsley-validated" value="${services.description}">
            </div>
        </div>
        <div class="form-row">
            <div class="form-label col-md-2">
                <label for="">
                    是否需要参数: <span class="required">*</span>
                </label>
            </div>
            <div class="form-input col-md-8">
                <div class="form-checkbox-radio col-md-10">
                    <input type="radio" name="needParameter" value=1 id="needParameter"  <#if services.needParameter == "YES" >checked="" </#if>/>
                    <label for="">是</label>
                    <input type="radio" name="needParameter" value=0 id="needParameter" <#if services.needParameter == "NO">checked="" </#if>/>
                    <label for="">否</label>
                </div>
            </div>
        </div>

    </form>
        <div class="divider"></div>
        <div class="form-row">
            <input type="hidden" name="superhidden" id="superhidden">

            <div class="form-input col-md-10 col-md-offset-2">
                <a href="javascript:;" class="btn medium primary-bg radius-all-4 col-md-2" id="demo-form-2-valid">
                    提交
                </a>
                <a href="/interface/servicelist" class="btn medium primary-bg radius-all-4 col-md-2">
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