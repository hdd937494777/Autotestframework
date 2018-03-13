<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored ="false" pageEncoding="UTF-8" %>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>米庄测试系统</title>

    <!-- Bootstrap Core CSS -->
    <link href="/web/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/web/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="/web/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="/web/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/web/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/web/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script type="text/JavaScript" language="javascript">
        function runCase(node){
            var trclick= node.parentNode.parentNode;
            dataid = trclick.id;
            name = '${name}'
            var xmlhttp;
            if (window.XMLHttpRequest)
            {// code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp=new XMLHttpRequest();
            }
            else
            {// code for IE6, IE5
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange=function()
            {
                if (xmlhttp.readyState==4 && xmlhttp.status==200)
                {
                    var leng =(trclick.childNodes.length-1)/2-2;
                    var cell = trclick.cells[leng];
                    cell.innerHTML = xmlhttp.responseText;
                }
                else {
                    alert("出错了");
                }
            }
            xmlhttp.open("GET","/mizlicai/qa/getResult?id="+dataid+"&name="+name,true);
            xmlhttp.send();
        }
    </script>
</head>
<body>
<br>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom:0">
            <%@include file="head.jsp"%>
            <%@include file="left.jsp"%>
        </nav>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">auth接口的测试用例</h1>
                </div>
            </div>
            <!-- /.row -->
            <div class ="form-group">
                <label>Text Input with Placeholder</label>
                <input class="form-control" placeholder="Enter text">
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            用例详情
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables">
                                <thead>
                                    <tr>
                                        <c:forEach var="keys" items="${testData['1'].keySet()}">
                                               <td style="word-break:break-all; word-wrap:break-word;">${keys}</td>
                                        </c:forEach>
                                        <td width="10%">结果</td>
                                        <td width="10%">操作</td>
                                    </tr>
                                </thead>
                                <tbody id="databody">
                                <c:forEach var="va" items="${testData}">
                                    <tr id="${va.key}">
                                        <c:forEach var="v" items="${va.value}">
                                            <td style="word-break:break-all; word-wrap:break-word;">${v.value}</td>
                                        </c:forEach>
                                            <td style="word-break:break-all; word-wrap:break-word;"></td>
                                            <td class="center" style="word-break:break-all; word-wrap:break-word;">
                                            <button type="button" class="btn btn-primary btn-xs" onclick="runCase(this)">运行case</button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                       </div>
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
        </div>
    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="/web/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/web/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/web/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="/web/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="/web/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="/web/vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/web/dist/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>
</body>

</html>
