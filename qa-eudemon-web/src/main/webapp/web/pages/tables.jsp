<%@ page isELIgnored ="false" pageEncoding="UTF-8" %>
<html lang="en">

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

</head>

<body>
 <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <%@include file="head.jsp"%>
            <%@include file="left.jsp"%>
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">收银台接口</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            备注：
                        </div>

                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                <tr>
                                    <th>接口名称</th>
                                    <th>接口功能描述</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr class="odd gradeX">
                                    <td>auth</td>
                                    <td>认证网管</td>
                                    <td class="center">
                                        <button type="button" class="btn btn-primary btn-xs" onclick="javascript:window.location.href='/web/pages/grid.jsp'">查看详情</button>
                                        <button type="button" class="btn btn-primary btn-xs" onclick="javascript:window.location.href='/mizlicai/qa/detail?name=auth'">接口用例</button>
                                    </td>
                                </tr>
                                <tr class="even gradeC">
                                    <td width="15%">authConfirm</td>
                                    <td width="75%">确认认证网管</td>
                                    <td class="center" width="30%">
                                        <button type="button" class="btn btn-primary btn-xs" onclick="javascript:window.location.href='/web/pages/grid.jsp?name=userinfo'">查看详情</button>
                                        <button type="button" class="btn btn-primary btn-xs" onclick="javascript:window.location.href='/mizlicai/qa/detail?name=authConfire'">接口用例</button>
                                    </td>
                                </tr>
                                <tr class="even gradeC">
                                    <td width="15%">isNeedChecked</td>
                                    <td width="75%">查询是否需要认证</td>
                                    <td class="center" width="30%">
                                        <button type="button" class="btn btn-primary btn-xs" onclick="javascript:window.location.href='/web/pages/grid.jsp'">查看详情</button>
                                        <button type="button" class="btn btn-primary btn-xs" onclick="javascript:window.location.href='/mizlicai/qa/detail?name=needchecked'">接口用例</button>
                                    </td>
                                </tr>
                                <tr class="even gradeC">
                                    <td width="15%">normalPay</td>
                                    <td width="75%">普通代付</td>
                                    <td class="center" width="30%">
                                        <button type="button" class="btn btn-primary btn-xs" onclick="javascript:window.location.href='/web/pages/grid.jsp'">查看详情</button>
                                        <button type="button" class="btn btn-primary btn-xs" onclick="javascript:window.location.href='/mizlicai/qa/detail?name=normalpay'">接口用例</button>
                                    </td>
                                </tr>
                                <tr class="even gradeC">
                                    <td width="15%">easyPayBefore</td>
                                    <td width="75%">快捷支付预付</td>
                                    <td class="center" width="30%">
                                        <button type="button" class="btn btn-primary btn-xs" onclick="javascript:window.location.href='/web/pages/grid.jsp'">查看详情</button>
                                        <button type="button" class="btn btn-primary btn-xs" onclick="javascript:window.location.href='/mizlicai/qa/detail?name=easypaybefore'">接口用例</button>
                                    </td>
                                </tr>
                                <tr class="even gradeC">
                                    <td width="15%">easyPay</td>
                                    <td width="75%">快捷支付</td>
                                    <td class="center" width="30%">
                                        <button type="button" class="btn btn-primary btn-xs" onclick="javascript:window.location.href='/web/pages/grid.jsp'">查看详情</button>
                                        <button type="button" class="btn btn-primary btn-xs" onclick="javascript:window.location.href='/mizlicai/qa/detail?name=easypay'">接口用例</button>
                                    </td>
                                </tr>
                                <tr class="even gradeC">
                                    <td width="15%">list</td>
                                    <td width="75%">银行信息查询</td>
                                    <td class="center" width="30%">
                                        <button type="button" class="btn btn-primary btn-xs" onclick="javascript:window.location.href='/web/pages/grid.jsp'">查看详情</button>
                                        <button type="button" class="btn btn-primary btn-xs" onclick="javascript:window.location.href='/mizlicai/qa/detail?name=banklist'">接口用例</button>
                                    </td>
                                </tr>
                                <tr class="even gradeC">
                                    <td width="15%">info</td>
                                    <td width="75%">用户信息查询</td>
                                    <td class="center" width="30%">
                                        <button type="button" class="btn btn-primary btn-xs" onclick="javascript:window.location.href='/web/pages/grid.jsp'">查看详情</button>
                                        <button type="button" class="btn btn-primary btn-xs" onclick="javascript:window.location.href='/mizlicai/qa/detail?name=userinfo'">接口用例</button>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <script src="/web/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/web/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/web/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="/web/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="/web/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="/web/vendor/datatables-responsive/dataTables.responsive.js"></script>
    <script src="/web/dist/js/sb-admin-2.js"></script>
</body>
</html>
