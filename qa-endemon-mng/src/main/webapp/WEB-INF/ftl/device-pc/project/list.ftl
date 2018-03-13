<#import "/macro.ftl" as m>
<@m.page_header title='后台' />
<div id="page-content-wrapper">

    <div id="page-title">
        <h3>
            项目管理
        </h3>

        <div id="breadcrumb-right">
            <div class="float-right">
                <a href="/project/add" class="btn medium primary-bg">
                    <span class="button-content">
                    <i class="glyph-icon icon-cog float-left"></i>
                    添加
                    </span>
                </a>
            </div>
        </div>
    </div>

    <div id="page-content">


        <table class="table" id="exp">
            <thead>
            <tr>
                <th>项目</th>
                <th>项目host</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <#list list as project>
               <tr id="${project.id}" >
                <td>
                   ${project.projectName}
                </td>
                <td>
                    ${project.projectHost}
                </td>
                   <td>
                   ${(project.createTime?string("yyyy-MM-dd HH:mm:ss"))!}
                   </td>
                <td>
                    <@resourceAccess url="/project/update">
                         <a href="/project/update/${project.id}" title="修改">
                             <i class="glyph-icon icon-edit mrg5R"></i>修改</a>
                    </@resourceAccess>
                    <@resourceAccess url="/project/delete">
                          <a href="javascript:void(0);" class=" del" title="删除" onclick="deleteproject('${project.id}');">
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

    $(function () {
    <#if msg!=null>
        $.jGrowl("${msg}", {sticky: !1, position: 'bottom-right', theme: 'bg-green'});
    </#if>
    });
    
    function deleteproject(projectId) {
        $.messager.confirm('提示', '确认删除项目信息吗？', function () {
            $.ajax({
                url : "/project/delete/" + projectId,
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
                    $.jGrowl("删除项目异常", {sticky:!1,position:"bottom-right",theme:"bg-red"});
                },
            });
        });
    };

</script>