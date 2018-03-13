<#import "/macro.ftl" as m>
<@m.page_header title='后台' />
<div id="page-content-wrapper">

    <div id="page-title">
        <h3>
            账户管理
        </h3>

        <div id="breadcrumb-right">
            <div class="float-right">
                <a href="/rolemanagement/addmember" class="btn medium primary-bg">
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
                <th>账户名</th>
                <th>中文名</th>
                <th>角色</th>
                <th>手机</th>
                <th>部门</th>
                <th>email</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <#list list as member>
            <tr id="${member.id}" onclick="displayDetail(${member.id});">
                <td>
                ${member.name}
                </td>
                <td>
                ${member.chineseName!}
                </td>
                <td>
                <#list member.roleManagers as roleManager>
                    ${roleManager.name}.
                </#list>

                </td>
                <td>
                ${member.mobile}
                </td>
                <td>
                ${member.department}
                </td>
                <td>
                ${member.email}
                </td>
                <td>
                    <@resourceAccess url="/rolemanagement/updatemember">
                    <a href="/rolemanagement/updatemember/${member.id}" title="修改"><i class="glyph-icon icon-edit mrg5R"></i>修改</a>
                    </@resourceAccess>
                    <@resourceAccess url="/rolemanagement/deletemember">
                    <a href="javascript:void(0);" class="font-red del" title="删除" onclick="deletemember('${member.id}');"><i class="glyph-icon icon-remove mrg5R"></i>删除</a>
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
    function displayDetail(memberId){

        $("#"+memberId+"").after();
    }

    $(function () {
    <#if msg!=null>
        $.jGrowl("${msg}", {sticky: !1, position: 'bottom-right', theme: 'bg-green'});
    </#if>
    });
    
    function deletemember(member_id) {
        $.messager.confirm('提示', '确认删除账户信息吗？', function () {
            $.ajax({
                url : "/rolemanagement/deletemember/" + member_id,
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
                    $.jGrowl("删除账户 异常", {sticky:!1,position:"bottom-right",theme:"bg-red"});
                },
            });
        });
    };

</script>