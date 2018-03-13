<#import "/macro.ftl" as m>
<@m.page_header title='后台' />
<div id="page-content-wrapper">

    <div id="page-title">
        <h3>
            异常接口服务管理
        </h3>


    </div>

    <div id="page-content">
        <table class="table" id="exp">
            <thead>

            <tr>
                <th>服务名称</th>
                <th>测试点</th>
                <th>错误原因</th>
                <th>请求地址</th>
                <th>请求参数</th>
                <th>响应状态</th>
                <th>期望响应状态</th>
                <th>响应编码</th>
                <th>期望响应编码</th>
                <th>请求时间</th>
                <th>响应时间</th>
                <th>响应数据</th>
                <th>操作</th>

            </tr>
            </thead>
            <tbody>
        <#list list as exception>
        <tr id="${exception.id}" onclick="displayDetail(${exception.id});">

        <td>
        ${exception.serviceName}
        </td>
        <td>
        ${exception.testPoint}
        </td>
        <td>
        ${exception.result}
        </td>
        <td>
        ${exception.requestUrl}
        </td>
        <td>
        ${exception.requestData}
        </td>
        <td>
        ${exception.responseStatus}
        </td>
        <td>
        ${exception.expectResponseStatus}
        </td>
        <td>
        ${exception.responseCode}
        </td>
        <td>
        ${exception.expectResponseCode}
        </td>
        <td>
        ${(exception.requestTime?string("yyyy-MM-dd HH:mm:ss"))!}
        </td>
        <td>
        ${(exception.responseTime?string("yyyy-MM-dd HH:mm:ss"))!}
        </td>
        <td>
        ${exception.responseData}
        </td>
            <td>
                    <@resourceAccess url="/interface/deleteexception">
                          <a href="javascript:void(0);" class="font-red del" title="删除" onclick="deleteexception('${exception.id}');"><i class="glyph-icon icon-remove mrg5R"></i>删除</a>
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
<script language="JavaScript">
    function displayDetail(exceptionId){

        $("#"+exceptionId+"").after();
    }

    $(function () {
    <#if msg!=null>
        $.jGrowl("${msg}", {sticky: !1, position: 'bottom-right', theme: 'bg-green'});
    </#if>
    });
    
    function deleteexception(exceptionId) {
        $.messager.confirm('提示', '确认删除异常请求信息吗？', function () {
            $.ajax({
                url : "/interface/deleteexception/" + exceptionId,
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
                    $.jGrowl("删除异常请求异常", {sticky:!1,position:"bottom-right",theme:"bg-red"});
                },
            });
        });
    };

</script>