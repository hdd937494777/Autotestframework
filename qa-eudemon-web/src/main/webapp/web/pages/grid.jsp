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
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <%@include file="head.jsp"%>
            <%@include file="left.jsp"%>
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">auth接口详情</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <h4>入参字段详情</h4>
                            <p>
                                <small>Y:必须返回;C:条件成立时返回;O:选填属性;R:必须原样返回</small>
                            </p>
                            <div class="table-responsive">
                                <table class="table table-bordered table-striped">
                                    <thead>
                                        <tr>
                                            <td colspan="7">接口参数</td>
                                        </tr>
                                        <tr>
                                            <td>字段</td>
                                            <td>描述</td>
                                            <td>类型</td>
                                            <td>备注</td>
                                            <td>必填</td>
                                            <td>版本</td>
                                            <td>示例</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                       <tr>
                                           <td>merchantAccount</td>
                                           <td>商户帐号</td>
                                           <td>String</td>
                                           <td></td>
                                           <td>Y</td>
                                           <td>1.0.0</td>
                                           <td>004306b3f1a2b646e9</td>
                                       </tr>
                                    </tbody>
                                </table>
                            </div>
                            <p>备注:</p>
                        </div>
                    </div>
                </div>
            </div>      <!-- /.col-lg-12 -->

            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <h4>入参字段详情</h4>
                            <p>
                                <small>Y:必须返回;C:条件成立时返回;O:选填属性;R:必须原样返回</small>
                            </p>
                            <div class="table-responsive">
                                <table class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <td colspan="7">结果返回</td>
                                    </tr>
                                    <tr>
                                        <td>字段</td>
                                        <td>描述</td>
                                        <td>类型</td>
                                        <td>备注</td>
                                        <td>必填</td>
                                        <td>版本</td>
                                        <td>示例</td>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>code</td>
                                        <td>返回码</td>
                                        <td>String</td>
                                        <td>返回吗</td>
                                        <td>Y</td>
                                        <td>1.0.0</td>
                                        <td>0</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <p>备注:</p>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
            <!-- /.row -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="/web/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/web/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/web/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/web/dist/js/sb-admin-2.js"></script>

</body>

</html>
