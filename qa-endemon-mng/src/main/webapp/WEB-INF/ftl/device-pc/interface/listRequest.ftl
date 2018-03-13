<#import "/macro.ftl" as m>
<@m.page_header title='后台' />
<script type="text/javascript" src="/assets/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="/assets/ueditor/ueditor.all.js"></script>
<script type="text/javascript" src="/assets/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="/assets/js/md5.js"></script>
<div id="page-content-wrapper">

    <div id="page-title">
        <h3>
            请求接口服务管理
        </h3>


    </div>

    <div id="page-content">
        <table class="table" id="exp">
            <thead>
            <tr>
                <th>服务名称</th>
                <th>测试点</th>
                <th>请求地址</th>
                <th>请求参数</th>
                <th>响应状态</th>
                <th>期望响应状态</th>
                <th>响应编码</th>
                <th>期望响应编码</th>
                <th>请求方法</th>
                <th>请求时间</th>
                <th>响应时间</th>
                <th>响应数据</th>
                <th>是否已校验</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <#list list as request>
            <tr id="${request.id}" onclick="displayDetail(${request.id});">
                <td>
                   ${request.serviceName}
                </td>
                <td>
                ${request.testPoint}
                </td>
                <td>
                    ${request.requestUrl}
                </td>
                <td>
                    ${request.requestData}
                </td>
                <td>
                ${request.responseStatus}
                </td>
                <td>
                ${request.expectResponseStatus}
                </td>
                <td>
                ${request.responseCode}
                </td>
                <td>
                ${request.expectResponseCode}
                </td>
                <td>
                ${request.requestType}
                </td>
                <td>
                      ${(request.requestTime?string("yyyy-MM-dd HH:mm:ss"))!}
                </td>
                <td>
                    ${(request.responseTime?string("yyyy-MM-dd HH:mm:ss"))!}
                </td>
                <td>
                ${request.responseData}
                </td>
                <td>
                    <#if request.isCheck == "YES">
                        是
                    <#else >
                        否
                    </#if>
                </td>
                <td>
                    <@resourceAccess url="/interface/deleterequest">
                          <a href="javascript:void(0);" class="font-red del" title="删除" onclick="deleterequest('${request.id}');"><i class="glyph-icon icon-remove mrg5R"></i>删除</a>
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
    function displayDetail(requestId){

        $("#"+requestId+"").after();
    }

    $(function () {
    <#if msg!=null>
        $.jGrowl("${msg}", {sticky: !1, position: 'bottom-right', theme: 'bg-green'});
    </#if>
    });
    
    function deleterequest(requestId) {
        $.messager.confirm('提示', '确认删除请求信息吗？', function () {
            $.ajax({
                url : "/interface/deleterequest/" + requestId,
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
                    $.jGrowl("删除请求异常", {sticky:!1,position:"bottom-right",theme:"bg-red"});
                },
            });
        });
    };

</script>