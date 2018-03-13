<#import "/macro.ftl" as m>
<@m.page_header title='后台' />
<script type="text/javascript" src="/assets/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="/assets/ueditor/ueditor.all.js"></script>
<script type="text/javascript" src="/assets/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="/assets/js/md5.js"></script>

<div id="page-content-wrapper">

    <div id="page-title">

        <h3>
        <#if role>修改<#else>添加</#if>角色
        </h3>
    </div>
    <div class="pad10A">
    <#if role>
    <form id="demo-form1" action="/rolemanagement/update" class="col-md-12" method="POST">
        <input id="roleId" type="hidden" name="id" value="${role.id}"/>
    <#else>
    <form id="demo-form1" action="/rolemanagement/add" class="col-md-12" method="POST">
    </#if>
        <div class="form-row">
            <div class="form-label col-md-2">
                <label for="">
                    角色名称:
                    <span class="required">*</span>
                </label>
            </div>
            <div class="form-input col-md-8">
                <input type="text" id="name" name="name" data-trigger="change" data-required="true"
                       class="parsley-validated"
                       value="${((role.name)!'')?xhtml}">
            </div>
        </div>

        <div class="form-row">
            <div class="form-label col-md-2">
                <label for="">
                    备注:<span class="required">*</span>
                </label>
            </div>
            <div class="form-input col-md-8">
                <input type="text" id="info" name="info" data-trigger="change"
                       data-required="true" class="parsley-validated" value="${role.info}">
            </div>
        </div>

        <#list ResourceUrl as res>
            <div class="form-row">
                <input type="hidden" name="resourcesIds" value="${res.id}"/>
                <div class="form-label col-md-2">
                    <label for="">
                        资源权限:
                    </label>
                </div>
                <a onclick="deleter(${res.id}, this)" class="btn medium radius-all-4 mrg5A ui-state-default tooltip-button"
                    href="javascript:void(0);"><i class="glyph-icon icon-minus"></i></a>
                <div class="form-input col-md-2">
                    <label for="">
                        ${res.valueName}
                    </label>
                </div>
                <div class="form-input col-md-4">
                    <label for="">
                        ${res.value}
                    </label>
                </div>
            </div>
        </#list>


        <div class="form-row">
            <div class="form-label col-md-2">
                <a id="add" class="medium btn bg-blue-alt float-right ui-state-default mrg10R tooltip-button white-modal-80"
                   data-placement="left" title="添加权限">
                    <i class="glyph-icon icon-plus"></i>
                </a>
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
                <a href="/rolemanagement/role" class="btn medium primary-bg radius-all-4 col-md-2">
                    取消
                </a>
            </div>
        </div>
    </div>

    <div class="col-md-3">
        <div class="hide" id="white-modal-80" title="资源">
            <div class="pad10A" style="overflow-y:auto;height:500px;">
                <table class="table">
                    <thead>
                        <tr>
                            <td>选择</td>
                            <td>Id</td>
                            <td>资源</td>
                            <td>资源路径</td>
                        </tr>
                    </thead>
                    <tbody id="pad10A">

                    </tbody>
                </table>

                <div class="form-row">

                    <div class="form-input col-md-10 col-md-offset-2">
                        <a href="javascript:;" class="btn medium primary-bg radius-all-4 col-md-2" id="comfirm">
                            确定
                        </a>
                    </div>
                </div>

            </div>
        </div>
    </div>

</div>

<script>
    <#if role!=null>
        var val= true;
    <#else>
        var val= false;
    </#if>

    $(function () {
        //请求数据资源
        $("#add").click(function(){

            $.get("/rolemanagement/resourceurl", function(data){
                var html = "";
                var da = data.resourceurls;
                for(var i = 0; i < da.length; i++){

                    var prt = true;
                    var ids = $("input[name='resourcesIds']");
                    for(var j = 0; ids != undefined && ids.length > 0 && j < ids.length; j++){
                        if(da[i].id == $(ids[j]).val()){
                            prt = false;
                            break;
                        }
                    }

                    if(prt){
                        html += "<tr onclick='chooseOne(this)' style='cursor: pointer'>" +
                                "<td><input class='checkbox' type='checkbox'  onclick='chooseOneTd(this)'/>"+
                                "</td><td>"+da[i].id+"</td><td>"+da[i].valueName+"</td><td>"+da[i].value+"</td></tr>";
                    }

                }
                $("#pad10A").empty();
                $("#pad10A").append(html);
            });
        });

        //添加权限
        $(document.body).delegate("#comfirm", "click", function(){
            var list = $( "input:checked" );
            var html = "";

            for(var i = 0; i < list.length; i++){
                var tr = list[i];

                var valueName = $(tr).parent().next().next().html();
                var value = $(tr).parent().next().next().next().html();
                var id = $(tr).parent().next().html();

                html += '<div class="form-row">'
                        +'<input type="hidden" name="resourcesIds" value="'+id+'"/>'
                        +'<div class="form-label col-md-2">'
                        +'<label for="">'
                        +'权限:'
                        +'</label>'
                        +'</div>'
                        +'<a onclick="deleter('+id+', this)" class="btn medium radius-all-4 mrg5A ui-state-default tooltip-button" title="icon-minus" href="javascript:void(0);"><i class="glyph-icon icon-minus"></i></a>'
                        +'<div class="form-input col-md-2">'
                        +'<label for="">'
                        + valueName
                        +'</label>'
                        +'</div>'
                        +'<div class="form-input col-md-4">'
                        +'<label for="">'
                        + value
                        +'</label>'
                        +'</div>'
                        +'</div>';
            }

            var last = $("#add").parent().parent().prev();

            last.after(html);

            $("#white-modal-80").parent().remove();
        });

    });

    $("#demo-form-2-valid").click(function () {
        $('#demo-form1').parsley('validate');
        $('#demo-form1').trigger('submit');
    });

    //选中
    function chooseOne(tr){
        $(tr).children().first().children().first().click();
    }
	
	//选中
    function chooseOneTd(td){
        $(td).click();
    }

    function choose(tr){
        var valueName = $(tr).children().first().html();
        var value = $(tr).children().first().next().html();
        var id = $(tr).children().first().next().next().html();

        var last = $("#add").parent().parent().prev();

        var html = '<div class="form-row">'
                +'<input type="hidden" name="resourcesIds" value="'+id+'"/>'
                +'<div class="form-label col-md-2">'
                +'<label for="">'
                +'权限:'
                +'</label>'
                +'</div>'
                +'<a onclick="deleter('+id+', this)" class="btn medium radius-all-4 mrg5A ui-state-default tooltip-button" title="icon-minus" href="javascript:void(0);"><i class="glyph-icon icon-minus"></i></a>'
                +'<div class="form-input col-md-2">'
                +'<label for="">'
                + valueName
                +'</label>'
                +'</div>'
                +'<div class="form-input col-md-4">'
                +'<label for="">'
                + value
                +'</label>'
                +'</div>'
                +'</div>';

        last.after(html);

        $(tr).parent().parent().parent().parent().parent().remove();
    }

    //删除
    function deleter(id, a){
        if(val){
            $.get("/rolemanagement/delete", {roleId: $("#roleId").val(), resourceUrlId:id}, function(data){
                $.jGrowl(data, {sticky: !1, position: 'bottom-right', theme: 'bg-green'});

                if("success" == data){
                    $(a).parent().remove();
                }
            });
        }else{
            $(a).parent().remove();
        }

    }



</script>