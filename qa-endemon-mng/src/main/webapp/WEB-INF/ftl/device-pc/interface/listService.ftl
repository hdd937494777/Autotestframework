<#import "/macro.ftl" as m>
<@m.page_header title='后台' />
<div id="page-content-wrapper">

    <div id="page-title">
        <h3>
            接口服务管理
        </h3>

        <div id="breadcrumb-right">
            <div class="float-right">
                <a href="/interface/addservices" class="btn medium primary-bg">
                    <span class="button-content">
                    <i class="glyph-icon icon-cog float-left"></i>
                    添加
                    </span>
                </a>
            </div>
        </div>
    </div>

    <div id="page-content">
        <form id="normal-form-1" action="/interface/servicelist" method="GET">

            <div class="form-row">
                <div class="form-input col-md-1">
                    <div class="form-label">
                        <label for="datepicker2"> 服务名称: </label>
                    </div>
                </div>
                <div class="form-input col-md-2">
                    <div class="form-input">
                        <input type="text" placeholder="服务名称" name="serviceName"
                               id="serviceName" value="${services.serviceName }" />
                    </div>
                </div>
                    <div class="form-input col-md-1">
                        <div class="form-label">
                            <label for="datepicker2"> 所属项目: </label>
                        </div>
                    </div>
                    <div class="form-input col-md-2">
                        <div class="form-input">
                            <input type="text" placeholder="所属项目" name="project"
                                   id="project" value="${services.project }" />
                        </div>
                    </div>
                <div class="form-input col-md-1">
                    <div class="form-label">
                        <label for="datepicker2">
                            状态:
                        </label>
                    </div>
                </div>
                <div class="form-input col-md-2">
                    <div class="form-input">
                        <select name="isNormal" id="isNormal">
                            <option value="">--请选择--</option>
                            <option value="NO" <#if services.isNormal == 'NO'>selected</#if>>不正常</option>
                            <option value="YES" <#if services.isNormal == 'YES'>selected</#if>>正常</option>
                        </select>
                    </div>
                </div>
            <div class="form-input col-md-1">
                <a href="javascript:;" class="btn large primary-bg radius-all-4"
                   id="search" title="Validate!" onclick="searchKeyword()"> <span
                        class="button-content"> 查询</span>
                </a>
            </div>


    </div>
    </form>


        <table class="table" id="exp">
            <thead>
            <tr>
                <th>服务名称</th>
                <th>所属项目</th>
                <th>是否正常</th>
                <th>请求地址</th>
                <th>请求方法</th>
                <th>入参地址</th>
                <th>期望返回数据地址</th>
                <th>是否需要如参</th>
                <th>超时时间</th>
                <th>并发数量</th>
                <th>描述</th>
                <th>创建时间</th>
                <th>操作人</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <#list list as service>
                <#if service.isNormal == "YES">
                <tr id="${service.id}" onclick="displayDetail(${service.id});" style="color: darkgrey">
                <#else>
                <tr id="${service.id}" onclick="displayDetail(${service.id});" style="background-color:coral">
                </#if>
                <td>
                   ${service.serviceName}
                </td>
                <td>
                    ${service.project}
                </td>
            <td>
                <#if service.isNormal == "NO">
                    否
                <#else >
                     是
                </#if>
            </td>
                <td>
                    ${service.requestUrl}
                </td>
                <td>
                      ${service.requestType}
                </td>
                <td>
                      ${service.requestDataUrl}
                </td>
                <td>
                      ${service.responseDataUrl}
                </td>
                <td>
                    <#if service.needParameter == "YES">
                        是
                    <#else >
                        否
                    </#if>
                </td>
                <td>
                ${service.timeOut}
                </td>
                <td>
                ${service.concurrentCount}
                </td>
                <td>
                ${service.description}
                </td>
                <td>
                    ${(service.createTime?string("yyyy-MM-dd"))!}
                </td>
                <td>
                ${service.operatorName}
                </td>
                <td>
                    <@resourceAccess url="/interface/interfacetest">
                        <a href="javascript:void(0);" class=" del" title="触发接口测试" onclick="interfacetest('${service.id}');">
                            <i class="glyph-icon icon-hand-up mrg5R"></i>触发接口重试</a>
                    </@resourceAccess>
                    <@resourceAccess url="/interface/exceptionlist">
                        <a href="/interface/exceptionlist?serviceId=${service.id}" class=" del" title="异常详情" ">
                            <i class="glyph-icon icon-hand-up mrg5R"></i>异常详情</a>
                    </@resourceAccess>
                    <@resourceAccess url="/interface/updateservice">
                         <a href="/interface/updateservice/${service.id}" title="修改">
                             <i class="glyph-icon icon-edit mrg5R"></i>修改</a>
                    </@resourceAccess>
                    <@resourceAccess url="/interface/deleteservice">
                          <a href="javascript:void(0);" class=" del" title="删除" onclick="deleteService('${service.id}');">
                              <i class="glyph-icon icon-remove mrg5R"></i>删除</a>
                    </@resourceAccess>
                </td>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>
    <div class="button-group center-div">
    ${pagerHelper.content}
    </div>
</div>
<script>
    function searchKeyword(){
        $("#normal-form-1").trigger("submit");
    }

    $(function () {
    <#if msg!=null>
        $.jGrowl("${msg}", {sticky: !1, position: 'bottom-right', theme: 'bg-green'});
    </#if>
    });
</script>
<script language="JavaScript">
    function displayDetail(serviceId){

        $("#"+serviceId+"").after();
    }

    $(function () {
    <#if msg!=null>
        $.jGrowl("${msg}", {sticky: !1, position: 'bottom-right', theme: 'bg-green'});
    </#if>
    });
    
    function deleteService(serviceId) {
        $.messager.confirm('提示', '确认删除服务信息吗？', function () {
            $.ajax({
                url : "/interface/deleteservice/" + serviceId,
                type : 'get',
                contentType : 'application/json',
                success : function (data) {
                    if (data.success) {
                        $.jGrowl(data.message, {sticky:!1,position:"bottom-right",theme:"bg-green"});
                        window.location.reload();
                    } else {
                        $.jGrowl(data.message, {sticky:!1,position:"bottom-right",theme:"bg-red"});
                    }
                },
                error : function () {
                    $.jGrowl("删除服务异常", {sticky:!1,position:"bottom-right",theme:"bg-red"});
                },
            });
        });
    };
    function interfacetest(serviceId) {
        $.messager.confirm('提示', '确认触发该服务请求吗？', function () {
            $.ajax({
                url : "/interface/interfacetest/" + serviceId,
                type : 'get',
                contentType : 'application/json',
                success : function (data) {
                    if (data.success) {
                        $.jGrowl(data.message, {sticky:!1,position:"bottom-right",theme:"bg-green"});
                        window.location.reload();
                    } else {
                        $.jGrowl(data.message, {sticky:!1,position:"bottom-right",theme:"bg-red"});
                    }
                },
                error : function () {
                    $.jGrowl("该服务请求异常", {sticky:!1,position:"bottom-right",theme:"bg-red"});
                },
            });
        });
    };


</script>