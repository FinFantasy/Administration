<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta name="viewport" content="width=device-width, intial-scale=1.0">
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <style type="text/css">
        body {
            background: url("/images/timgk.jpeg") repeat;
        }
        #login-box {
            padding: 35px;
            border-radius: 15px;
            background: #87CEEB;
            color: #4A708B;
        }
    </style>
</head>
<body>
<div class="container" id="top">
    <div class="row" style="margin-top: 280px;">
        <div class="col-md-4"></div>
        <div class="col-md-4" id="login-box">
            <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/login"
                  id="form1" method="post">
                <div class="form-group">
                    <label for="userID" class="col-sm-3 control-label">用户</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="userID" placeholder="请输入名字" name="username">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">密码</label>
                    <div class="col-sm-9">
                        <input type="password" class="form-control" id="password" placeholder="请输入密码" name="password">
                    </div>
                </div>
                <div class="form-group">
                    <label for="vcode" class="col-sm-3 control-label">验证码</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="vcode" name="vcode"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4">
                        <input type="checkbox" name="rememberMe" id="rememberMe"/>记住我
                    </div>
                    <div class="col-sm-6">
                        <img src="/getGifCode" alt="验证码">
                    </div>
                    <div class="col-sm-2">
                        <button type="submit" class="btn btn-default btn-info">登录</button>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-6 text-center">
                        <label class="control-label">${message}</label>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
</body>
</html>
