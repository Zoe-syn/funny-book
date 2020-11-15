<%-- 
    Document   : sousuo
    Created on : 2019-12-23, 12:18:59
    Author     : pc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <base href="${pageContext.request.contextPath}/" /> 
        <link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/slide.js"></script>
        <title>uyfuyyuy</title>
    </head>
    <body>
        <div class="header_con">
		<div class="header">
			<div class="welcome fl">欢迎来到C2C!</div>
			<div class="fr">
				<div class="login_btn fl">
					<a href="to_login">登录</a>
					<span>|</span>
					<a href="register.html">注册</a>
				</div>
				<div class="user_link fl">
					<span>|</span>
					<a href="to_cart">我的购物车</a>
					<span>|</span>
					<a href="order">我的订单</a>
				</div>
			</div>
		</div>		
	</div>

	<div class="search_bar clearfix">
		<!--<a href="index.html" class="logo fl"><img src="images/logo.png"></a>-->
             <div class="logo fl">
                <p>当前登录：</p>
                <p>${user.uname}</p>
                <p><a href="logout">退出登录</a></p>
            </div>
		<div class="search_con fl">
                   <!-- <form action="getOne" >
			<input type="text" class="input_text fl" name="pid" placeholder="搜索商品">
			<input type="submit" class="input_btn fr"  value="搜索">
                    </form>-->
                 <form  method="get"   action="sousuo/findSearch" >

                        <input type="text" name="keyword"  class="input_text fl" placeholder="请输入商品名称" >
                        <input type="submit"  class="input_btn fr"  value="搜索" >

                </form>
                     
		</div>
               
		<div class="guest_cart fr">
			<a href="to_cart" class="cart_name fl">我的购物车</a>
			<div class="goods_count fl" id="show_count">1</div>
		</div>
	</div>

	<div class="navbar_con">
		<div class="navbar">
			<h1 class="fl">全部商品分类</h1>
			<ul class="navlist fl">
				<li><a href="">首页</a></li>
				<li class="interval">|</li>
				<li><a href="product">我要发布</a></li>
				<li class="interval">|</li>
				<li><a href="buy">我要求购</a></li>
			</ul>
		</div>
	</div>
                <div>
                    <div class="goods_con clearfix  " style=" margin-left: 100px" >
             <ul class="goods_list fl">	
                   <c:forEach var="p" items="${plist}">
			
                      <li>
					<h4><a href="getOne?pid=${p.pid}">${p.pname}</a></h4>
                                        <a href="#"><img src="/C2C/img/digital/${p.pid}.jpg"</a>
					<div class="prize">${p.pprice}</div>
				</li>
	
                   </c:forEach> </ul>
     </div> 
                </div>
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
		<p>CopyRight © 2019 C2C哈哈哈哈哈 All Rights Reserved</p>
		<p>电话：155****6998    青岛TCP/IP备*******4号</p>
	</div>                     
                               
    </body>
</html>
