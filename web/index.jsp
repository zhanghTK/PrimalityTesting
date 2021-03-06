<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<%
    String logined = (String) request.getAttribute("logined");
    System.out.println(!"true".equals(logined));
    if (!"true".equals(logined)){
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>素性检测算法</title>

    <!-- Bootstrap core CSS -->
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/starter-template.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="resources/jquery.js"></script>
</head>

<body background="resources/xiyou.jpg">
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">素性检测算法</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <!--<li><a href="#about">About</a></li>-->
                <!--<li><a href="#contact">Contact</a></li>-->
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="container">

    <div class="starter-template">
        <h1>素性检测</h1>
        <div style="padding: 100px 100px 10px;">
            <input name="num" type="text" class="form-control" placeholder="请输入待检测数字..."><br/>
            <button id="certain" type="button" class="btn btn-primary" title="检测结果:"
                    data-container="body" data-toggle="popover" data-placement="right"
                    data-content="" onclick="javascript:test();">
                确认性检测算法
            </button><br/><br/>
            <button id="miller-rabin" type="button" class="btn btn-primary" title="检测结果:"
                    data-container="body" data-toggle="popover" data-placement="right"
                    data-content="" onclick="javascript:test();">
                MillerRabin检测算法
            </button><br/><br/>
            <button id="solovayStrassen" type="button" class="btn btn-primary" title="检测结果:"
                    data-container="body" data-toggle="popover" data-placement="right"
                    data-content="" onclick="javascript:test();">
                MillerRabin检测算法
            </button><br/><br/>
        </div>
    </div>

</div><!-- /.container -->
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script>$(function () {
    $("input[name='num']").on('input', function(){
        test();
    });

    $("[data-toggle='popover']").popover();
});
</script>
<script>
    function test(){
        console.log("hello");
        var num = $("input[name='num']").val();
        if(!num){
            return;
        }
        $.ajax({
            type: "GET",
            url: "/primality/certainly?num="+num,
            success: function (data) {
                $("button[id='certain']").attr("data-content", data);
            }
        });

        $.ajax({
            type: "GET",
            url: "/primality/miller-rabin?num="+num,
            success: function (data) {
                $("button[id='miller-rabin']").attr("data-content", data);
            }
        });

        $.ajax({
            type: "GET",
            url: "/primality/solovayStrassen?num="+num,
            success: function (data) {
                $("button[id='solovayStrassen']").attr("data-content", data);
            }
        });
    }
</script>
</body>
</html>
