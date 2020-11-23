<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>注册</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <base href="${pageContext.request.contextPath}/">
        <link rel="stylesheet" href="css/bootstrap.min.css"/>      
        <link rel="stylesheet" href="css/reset.css"/>
        <link rel="stylesheet" href="css/main.css"/>
        <script src="js/jquery-3.4.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>     
        <script src="js/register.js"></script>
    </head>



    <body>
        <div class="register_con">
            <div class="l_con fl">
                <a class="reg_logo"><img width="400px" height="400px" src="img/digital/zhuce1.jpg"></a>
                <div class="reg_slogan" >您想要的，我们都有！</div>
                <div class="reg_banner"></div>
            </div>

            <div class="r_con fr">
                <div class="reg_title clearfix">
                    <h1>用户注册</h1>
                    <a href="to_login">登录</a>
                </div>

                <div class="reg_form clearfix">

                    <form class="m-t" role="form" action="<%=request.getContextPath()%>/user/register" method="post">
                        <ul>
                            <li>
                                <div class="form-group">
                                    <label>用户名:</label>
                                    <input id="uname" type="text" name="uname" class="form-control" placeholder="用户名" required
                                           onblur="checkName(this.value)">
                                    <span  style="color: red;font-size: 15px" id="span1"></span>
                                </div>
                            </li>					
                            <li>
                                <div class="form-group">
                                    <label>密码:</label>
                                    <input id="upwd" type="password" name="upwd" class="form-control" placeholder="密码" required>
                                    <span class="error_tip">提示信息</span>
                                </div>

                            </li>
                            <li>
                                <label>确认密码:</label>
                                <input id="cpwd" type="password" name="cpwd" id="cpwd">
                                <span class="error_tip">提示信息</span>
                            </li>
                            <li>
                                <div class="form-group">
                                    <label>密保问题:</label>
                                    <input type="text" name="uquestion" class="form-control" placeholder="密保问题" required>
                                    <span class="error_tip">提示信息</span>
                                </div>

                            </li>
                            <li>
                                <div class="form-group">
                                    <label>答案:</label>
                                    <input type="text" name="uanswer" class="form-control" placeholder="答案" required>
                                    <span class="error_tip">提示信息</span>
                                </div>
                            </li>

                            <li class="agreement">
                                <input type="checkbox" name="allow" id="allow" checked="checked">
                                <label>同意”用户使用协议“</label>
                                <span class="error_tip2">提示信息</span>
                            </li>
                            <li class="reg_sub">
                                <button type="submit" class="btn btn-success block full-width m-b" id="submit" disabled>提交</button>
                               <!--<input type="submit" class="btn btn-primary block full-width m-b" id="submit" disabled>-->
                               <br>
                            </li>
                        </ul>				
                    </form>
                </div>

            </div>

        </div>
                        <br>

	<div class="footer">
		<div class="foot_link">
			<a href="#">关于我们</a>
			<span>|</span>
			<a href="#">联系我们</a>
			<span>|</span>
			<a href="#">招聘人才</a>
			<span>|</span>
			<a href="#">友情链接</a>		
		</div>
		<p>CopyRight © 2019 funny-book哈哈哈哈哈 All Rights Reserved</p>
		<p>电话：155****6998    青岛TCP/IP备*******4号</p>
	</div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>     
        <script src="js/register.js"></script>
        <script>
                                               let curWwwPath = window.document.location.href;
                                               let pathName = window.document.location.pathname;
                                               let pos = curWwwPath.indexOf(pathName);
                                               let localhostPaht = curWwwPath.substring(0, pos);

                                               function checkName(value) {
                                                   $.post(localhostPaht + '/funny-book/user/checkName', 'name=' + value, (msg) => {
                                                       document.getElementById("submit").removeAttribute("disabled");
                                                       if (msg === "success") {
                                                           $("#span1").html("用户名重复");
                                                           $("#submit").attr("disabled", "true");
                                                           console.log("111111111111");
                                                       } else {
                                                           $("#span1").html("");
                                                           console.log("222222222222");
                                                       }
                                                   }, 'text');
                                               }
        </script>
    </body>
</html>
