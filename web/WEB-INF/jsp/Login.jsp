<%-- 
    Document   : Login
    Created on : 2019-11-28, 8:40:00
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <base href="${pageContext.request.contextPath}/">
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        <script src="js/jquery-3.4.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/script.js"></script>
         


        <!--        <link rel="stylesheet" href="bootstrap">-->
        <link rel="stylesheet" href="css/login.css" />

        <script src="bootstrap/js/bootstrap.min.js"></script>
        <style>
              #ddd{
                background-image: url(/C2C/img/digital/zhuce1.jpg);
                background-size: cover;
            }
        </style>
            
   </head>
    <body id="ddd">
        
        <div class="container" style="margin-top: 200px">
            <form action="login" method="post" class="form-inline text-center">
                <span style="font-size: 30px">登录</span>
                <a href="user/to_registerDemo">注册</a><br><br>
                用户名：<input type="text" class="form-control" name="uname" placeholder="用户名" value="admin" /><br/><br/>
                密码：&nbsp;&nbsp;&nbsp;<input type="password" class="form-control" name="upwd" placeholder="密码" /><br/><br/>
                       <span style="color:#000000">
                                <a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
                            </span> 
                       <input type="submit" value="提交"  class="btn btn-sm btn-danger" />
                      
            </form>
        </div>
    </body>
</html>
