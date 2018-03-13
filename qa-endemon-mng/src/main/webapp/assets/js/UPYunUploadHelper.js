/*
使用规则：
    html格式：输入框 + 上传按钮 上传按钮赋值 id="uploadButton"。有必要按照这样的html结构，
    因为需要把上传图片的地址重新返回给输入框，所以后台上传的时候需要按照这种格式。会继续优化考虑使用很好地解决办法
 <div class="form-input col-md-4">
     <div class="row">
         <div class="col-md-8">
            <input placeholder="" data-required="true" type="text" name="iOSBanner" id="iOSBanner" value=""/>
         </div>
         <div class="form-label col-md-2">
             <a id="uploadButton" class="btn medium primary-bg radius-all-4">  //注意：如果上传的是ios图加上 data-title="ios"
                <span class="button-content">上传图片</span>
             </a>
         </div>
     </div>
 </div>
 
  js调用： 参数为又拍云图片目录，输入地址请仔细填写，现在地址检查只做了空判断
          可选地址："upload/images/","upload/images/activity/"（活动图片banner路径）
 
(2015.1.19)参数更新：可以填写第二个参数，数值2 ，表示上传的是文件而不是图片
 
       具体问 @clt
 $("#uploadButton").click(function(){
    $(this).addMyUpload("upload/images/");
 });
 
*/
 
//给对象增加方法
;(function($){
   $.fn.addMyUpload = function uploadDialog(dir, type) {
        if(type == 2){
            helperUrl = "bucketapioffile";
        }else{
            helperUrl = "bucketapi";
        }
        if(dir === undefined){
            throw "addMyUpload()方法没有指定上传地址参数！none dir";
        }
        UPYDirectory = dir;  //上传目录
 
        helperUploadText = this.parent().prev().children()[0];
        if(helperUploadText === undefined){
            throw "html格式不正确！"
        }
 
        var uploadMethod = "";
        if (this.data("title") == "ios"){
            uploadMethod = "$.UPYunUploadHelper.uploadIOSImage(this)";
        }else if(this.attr("data-title") == "android"){
            uploadMethod = "$.UPYunUploadHelper.uploadImage(this)";
        }else{
            uploadMethod = "$.UPYunUploadHelper.uploadImage(this)";
        }
 
        var html =
                '<div id="dialog" class="hide" title="图片上传">' +
                '<div id="uploadImageDialog">'+
                '<div  style=" width:120px; height:120px;margin:auto">'+
                '<img id="ImgPr" width="120" height="120" style="display: inherit;" />'+
                '</div>'+
                '<input id="fileupload" type="file" multiple style="margin-left:100px;margin-top:20px" onchange="$.UPYunUploadHelper.preview(this)"/>'+
                '<div style="margin-top: 20px;margin-left: 100px">'+
                '地址：<a id="uploadAddress"></a>'+
                '</div >'+
                '<div style="width:60px;  margin:auto; margin-top:20px">'+
                '<a class="btn medium primary-bg radius-all-4" onclick="'+uploadMethod+'">'+
                '<span class="button-content">上传</span>'+
                '</a>'+
                '</div>'+
                '</div>'+
                '</div>';
        $("#uploadButon").val();
        $( html ).dialog({
            resizable:!0,
            minWidth:700,
            minHeight:350,
            modal:!0,
            dialogClass:"modal-dialog",
            closeOnEscape:!0,
            close : function() {
                $(this).dialog( "destroy" );
            },
            buttons: {
                确定: function() {
                    $(this).dialog( "destroy" );
                }
            }
        });
 
        return this;
    };
 
    //静态方法
    jQuery.UPYunUploadHelper = {
 
        preview:function(a) {
            var objUrl = $.UPYunUploadHelper.getObjectURL(a.files[0]) ;
            //console.log("objUrl = "+objUrl) ;
            if (objUrl) {
                // attr("src", objUrl);'<img width="120" height="120" style="display: inherit;" src="'+objUrl+'" />'
                //console.log($("#ImgPr"));
                $("#ImgPr").attr("src", objUrl);
            }
            return;
        },
 
        getObjectURL:function(file) {
            var url = null ;
            if (window.createObjectURL!=undefined) { // basic
                url = window.createObjectURL(file) ;
            } else if (window.URL!=undefined) { // mozilla(firefox)
                url = window.URL.createObjectURL(file) ;
            } else if (window.webkitURL!=undefined) { // webkit or chrome
                url = window.webkitURL.createObjectURL(file) ;
            }
            return url ;
        },
 
        uploadImage: function (a) {
            $.get("/upyun/"+helperUrl, function (data) {
 
                var config = {
                    api: 'http://v0.api.upyun.com/',
                    bucket: data.bucket,
 
                    // 空间的表单 API
                    form_api: data.formId
                };
 
                var inputText = $(a).parent().prev().children("#text")[0];
 
                var file = $("#fileupload")[0].files[0];
 
 
                if (!file) {
                    console.log('no file is selected');
                    return;
                }
 
                var dir = UPYDirectory;
                // 计算 policy 和 signature 所需的参数
                // 详情见： http://docs.upyun.com/api/form_api/#表单API接口简介
                var options = {
                    bucket: config.bucket,
                    expiration: Math.floor(new Date().getTime() / 1000) + 86400,
                    'save-key': dir+file.name
                };
 
                var policy = window.btoa(JSON.stringify(options));
                var signature = CryptoJS.MD5(policy + '&' + config.form_api);
 
                var dataform = new FormData();
                dataform.append('policy', policy);
                dataform.append('signature', signature);
                dataform.append('file', file);
 
                var request = new XMLHttpRequest();
                request.open('POST', config.api + options.bucket);
 
                request.onload = function (e) {
                    var jsonResponse = JSON.parse(request.response);
                    if (jsonResponse.code == "200") {
                        uploadUrl = data.returnUrl + '/'+dir + file.name;
 
                        $(inputText).val(data.returnUrl + '/'+dir + file.name);
                        $(helperUploadText).val(uploadUrl);
 
                        //dialog上显示图片空间地址
                        $("#uploadAddress").attr("href", data.returnUrl + '/'+dir + file.name);
                        $("#uploadAddress").text(uploadUrl);
 
                        uploadUrl = "";
                        helperUploadText = "";
                        $.jGrowl("上传成功", {sticky: !1, position: "top-right", theme: "bg-green"});
 
                    } else {
                        uploadUrl = "";
                        helperUploadText = "";
                        $.jGrowl("上传失败，错误代码"+jsonResponse.code, {sticky: !1, position: "top-right", theme: "bg-green"});
                    }
                };
 
                request.send(dataform);
 
            });
        },
 
        uploadIOSImage: function(a){
            $.get("/upyun/bucketapi", function (data) {
 
                var config = {
                    api: 'http://v0.api.upyun.com/',
                    bucket: data.bucket,
 
                    // 空间的表单 API
                    form_api: data.formId
                };
 
                var inputtext = $(a).parent().prev().children("#text")[0];
                var inputfile = $(a).parent().children("#file")[0];
 
                var file = $("#fileupload")[0].files[0];
 
 
                if (!file) {
                    console.log('no file is selected');
                    return;
                }
                var dir = "upload/images/activity/";
                // 计算 policy 和 signature 所需的参数
                // 详情见： http://docs.upyun.com/api/form_api/#表单API接口简介
                var options = {
                    bucket: config.bucket,
                    expiration: Math.floor(new Date().getTime() / 1000) + 86400,
                    'save-key': dir+file.name
                };
 
                var policy = window.btoa(JSON.stringify(options));
                var signature = CryptoJS.MD5(policy + '&' + config.form_api);
 
                var dataform = new FormData();
                dataform.append('policy', policy);
                dataform.append('signature', signature);
                dataform.append('file', file);
 
                var request = new XMLHttpRequest();
                request.open('POST', config.api + options.bucket);
 
                request.onload = function (e) {
                    var jsonResponse = JSON.parse(request.response);
                    if (jsonResponse.code == "200") {
                        uploadUrl = data.returnUrl + '/'+dir + file.name;
 
                        $(inputtext).val(data.returnUrl + '/'+dir + file.name);
                        $(helperUploadText).val(uploadUrl);
 
                        $("#uploadAddress").attr("href", data.returnUrl + '/'+dir + file.name);
                        $("#uploadAddress").text(uploadUrl);
 
                        uploadUrl = "";
                        helperUploadText = "";
                        $.jGrowl("ios默认尺寸，上传成功", {sticky: !1, position: "top-right", theme: "bg-green"});
 
                    } else {
                        uploadUrl = "";
                        helperUploadText = "";
                        $.jGrowl("上传失败，错误代码"+jsonResponse.code, {sticky: !1, position: "top-right", theme: "bg-green"});
                    }
                };
 
                request.send(dataform);
 
 
                //600*188
                var options1 = {
                    bucket: config.bucket,
                    expiration: Math.floor(new Date().getTime() / 1000) + 86400,
                    'save-key': dir+file.name+"1",
                    'x-gmkerl-type': "fix_scale",
                    'x-gmkerl-value':"50"
                };
 
                policy = window.btoa(JSON.stringify(options1));
                signature = CryptoJS.MD5(policy + '&' + config.form_api);
 
                dataform = new FormData();
                dataform.append('policy', policy);
                dataform.append('signature', signature);
                dataform.append('file', file);
 
                var request1 = new XMLHttpRequest();
                request1.open('POST', config.api + options.bucket);
 
                request1.onload = function (e) {
                    var jsonResponse = JSON.parse(request1.response);
                    if (jsonResponse.code == "200") {
                        $.jGrowl("ios,600*188尺寸，上传成功", {sticky: !1, position: "top-right", theme: "bg-green"});
                    } else {
                        $.jGrowl("上传失败，错误代码"+jsonResponse.code, {sticky: !1, position: "top-right", theme: "bg-green"});
                    }
                };
 
                request1.send(dataform);
 
                //710*222
                var options2 = {
                    bucket: config.bucket,
                    expiration: Math.floor(new Date().getTime() / 1000) + 86400,
                    'save-key': dir+file.name+"2",
                    'x-gmkerl-type': "fix_scale",
                    'x-gmkerl-value':"60"
                };
 
                policy = window.btoa(JSON.stringify(options2));
                signature = CryptoJS.MD5(policy + '&' + config.form_api);
 
                dataform = new FormData();
                dataform.append('policy', policy);
                dataform.append('signature', signature);
                dataform.append('file', file);
 
                var request2 = new XMLHttpRequest();
                request2.open('POST', config.api + options.bucket);
 
                request2.onload = function (e) {
                    var jsonResponse = JSON.parse(request2.response);
                    if (jsonResponse.code == "200") {
                        $.jGrowl("ios,710*222尺寸，上传成功", {sticky: !1, position: "top-right", theme: "bg-green"});
                    } else {
                        $.jGrowl("上传失败，错误代码"+jsonResponse.code, {sticky: !1, position: "top-right", theme: "bg-green"});
                    }
                };
 
                request2.send(dataform);
 
 
                //1182*370
                var options3 = {
                    bucket: config.bucket,
                    expiration: Math.floor(new Date().getTime() / 1000) + 86400,
                    'save-key': dir+file.name+"3",
                    'x-gmkerl-type': "fix_scale",
                    'x-gmkerl-value':"100"
                };
 
                policy = window.btoa(JSON.stringify(options3));
                signature = CryptoJS.MD5(policy + '&' + config.form_api);
 
                dataform = new FormData();
                dataform.append('policy', policy);
                dataform.append('signature', signature);
                dataform.append('file', file);
 
                var request3 = new XMLHttpRequest();
                request3.open('POST', config.api + options.bucket);
 
                request3.onload = function (e) {
                    var jsonResponse = JSON.parse(request3.response);
                    if (jsonResponse.code == "200") {
                        $.jGrowl("ios,1182*370尺寸，上传成功", {sticky: !1, position: "top-right", theme: "bg-green"});
                    } else {
                        $.jGrowl("上传失败，错误代码"+jsonResponse.code, {sticky: !1, position: "top-right", theme: "bg-green"});
                    }
                };
 
                request3.send(dataform);
            });
        }
    };
}(jQuery));