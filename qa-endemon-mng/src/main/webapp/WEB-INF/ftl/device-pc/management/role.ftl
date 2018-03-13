<#import "/macro.ftl" as m>
<@m.page_header title='后台' />
<div id="page-content-wrapper">

    <div id="page-title">
        <h3>
            角色管理
        </h3>

        <div id="breadcrumb-right">
            <div class="float-right">
                <a href="/rolemanagement/add" class="btn medium primary-bg">
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
                    <th>序号</th>
                    <th>角色名称</th>
                    <th>备注</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <#list list as roleManager>
                <tr>
                    <td>
                        ${roleManager_index+1}
                    </td>
                    <td>
                        ${roleManager.name}
                    </td>
                    <td>
                        ${roleManager.info}
                    </td>
                    <td>
                        <@resourceAccess url="/rolemanagement/updateRole">
                        <a href="/rolemanagement/update/${roleManager.id}" title="修改"><i class="glyph-icon icon-edit mrg5R"></i>修改</a>
                        </@resourceAccess>
                        <@resourceAccess url="/rolemanagement/deleteRole">
                        <a href="javascript:void(0);" class="font-red del" title="删除" onclick="deleteRole('${roleManager.id}')"><i class="glyph-icon icon-remove mrg5R"></i>删除</a>
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
    $(function () {
    <#if msg!=null>
        $.jGrowl("${msg}", {sticky: !1, position: 'bottom-right', theme: 'bg-green'});
    </#if>
    });

    function deleteRole(role_id) {
        $.messager.confirm('提示', '确认删除角色信息吗？', function () {
            $.ajax({
                url : "/rolemanagement/delete/" + role_id,
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
                    $.jGrowl("删除角色 异常", {sticky:!1,position:"bottom-right",theme:"bg-red"});
                },
            });
        });
    };
</script>