<%@page import="java.util.Iterator"%>
<%@page import="com.qdu.entity.Products"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
            <title>C@C-首页</title>
            <base href="${pageContext.request.contextPath}/" /> 
            <link rel="stylesheet" type="text/css" href="css/reset.css">
                <link rel="stylesheet" type="text/css" href="css/main.css">
                    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
                    <script type="text/javascript" src="js/jquery-ui.min.js"></script>
                    <script type="text/javascript" src="js/slide.js"></script>
                    </head>
                    <body>
                        <div class="header_con">
                            <div class="header">
                                <div class="welcome fl">欢迎来到C2C!</div>
                                <div class="fr">
                                    <div class="login_btn fl">

                                        <a href="login-1">我是管理员</a>
                                        <span>|</span>
                                        <a href="to_login">登录</a>
                                        <span>|</span>
                                        <a href="user/to_registerDemo">注册</a>
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

                                                        <!--  <a class="btn btn-info" href="to_login">LOGIN</a>-->

                                                        <div class="center_con clearfix">
                                                            <ul class="subnav fl">
                                                                <li><a href="#model01" class="fruit">书</a></li>
                                                                <li><a href="#model02" class="seafood">数码类</a></li>
                                                                <li><a href="queryData/to_shaixuan" class="meet">手机类</a></li>
                                                                <li><a href="#model04" class="egg">衣物</a></li>
                                                                <li><a href="#model05" class="vegetables">租房</a></li>
                                                                <li><a href="#model06" class="ice">其他</a></li>
                                                            </ul>
                                                            <div class="slide fl">
                                                                <ul class="slide_pics">
                                                                    <li><img src="/C2C/img/other/1.png" alt="幻灯片" width="760" height="250"></li>
                                                                    <li><img src="/C2C/img/other/2.jpg" alt="幻灯片" width="760" height="250"></li>
                                                                    <li><img src="/C2C/img/other/3.jpg" alt="幻灯片" width="760" height="250"></li>
                                                                    <li><img src="/C2C/img/other/4.jpg" alt="幻灯片" width="760" height="250"></li>
                                                                </ul>
                                                                <div class="prev"></div>
                                                                <div class="next"></div>
                                                                <ul class="points"></ul>
                                                            </div>
                                                            <div class="adv fl"style="background-color: #D6E9C6">
                                                                <h1>公告</h1>
                                                                <a href="#"><h1><c:forEach var="n" items="${list4}">
                                                                            <li>
                                                                                <h4><a>${n.content}</a></h4>

                                                                            </li>
                                                                        </c:forEach></h1></a>
                                                            </div>
                                                        </div>

                                                        <div class="list_model">
                                                            <div class="list_title clearfix">
                                                                <h3 class="fl" id="model01">数码</h3>
                                                                <div class="subtitle fl">
                                                                    <span>|</span>
                                                                    <a href="#"></a>
                                                                    <a href="#"></a>
                                                                    <a href="#"></a>
                                                                </div>
                                                                <a href="#" class="goods_more fr" id="fruit_more">查看更多 ></a>
                                                            </div>   
                                                            <div class="goods_con clearfix">
                                                                <div class="goods_banner fl"><img src="/C2C/img/other/数码.jpg"></div> 
                                                                <ul class="goods_list fl">
                                                                    <c:forEach var="p" items="${list1}">
                                                                        <li>
                                                                            <h4><a href="getOne?pid=${p.pid}">${p.pname}</a></h4>
                                                                            <a href="#"><img src="/C2C/img/digital/${p.pid}.jpg"</a>
                                                                            <div class="prize">${p.pprice}</div>
                                                                        </li>
                                                                    </c:forEach>
                                                                </ul>
                                                            </div>
                                                        </div>

                                                        <div class="list_model">
                                                            <div class="list_title clearfix">
                                                                <h3 class="fl" id="model02">书</h3>
                                                                <div class="subtitle fl">
                                                                    <span>|</span>
                                                                    <a href="#">手机</a>
                                                                    <a href="#">平板</a>				
                                                                </div>
                                                                <a href="#" class="goods_more fr">查看更多 ></a>
                                                            </div>

                                                            <div class="goods_con clearfix">
                                                                <div class="goods_banner fl"><img src="/C2C/img/other/书.jpg"></div> 
                                                                <ul class="goods_list fl">
                                                                    <c:forEach var="p" items="${list2}">
                                                                        <li>
                                                                            <h4><a href="getOne?pid=${p.pid}">${p.pname}</a></h4>
                                                                            <a href="#"><img src="/C2C/img/digital/${p.pid}.jpg"/></a>
                                                                            <div class="prize">${p.pprice}</div>
                                                                        </li>
                                                                    </c:forEach>
                                                                </ul>
                                                            </div>
                                                        </div>

                                                        <div class="list_model">
                                                            <div class="list_title clearfix">
                                                                <h3 class="fl" id="model03">手机</h3>
                                                                <div class="subtitle fl">
                                                                    <span>|</span>
                                                                    <a href="#">华为</a>
                                                                    <a href="#">小米</a>
                                                                    <a href="#">苹果</a>
                                                                </div>
                                                                <a href="#" class="goods_more fr">查看更多 ></a>
                                                            </div>

                                                            <div class="goods_con clearfix">
                                                                <div class="goods_banner fl"><img src="/C2C/img/other/手机.jpg"></div> 
                                                                <ul class="goods_list fl">
                                                                    <c:forEach var="p" items="${list3}">
                                                                        <li>
                                                                            <h4><a href="getOne?pid=${p.pid}">${p.pname}</a></h4>
                                                                            <a href="#"><img src="/C2C/img/digital/${p.pid}.jpg"</a>
                                                                            <div class="prize">${p.pprice}</div>
                                                                        </li>
                                                                    </c:forEach>
                                                                </ul>
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
                                                        <script type="text/javascript" src="js/slideshow.js"></script>
                                                        <script type="text/javascript">
                                                            BCSlideshow('focuspic');
                                                            var oFruit = document.getElementById('fruit_more');
                                                            var oShownum = document.getElementById('show_count');

                                                            var hasorder = localStorage.getItem('order_finish');

                                                            if (hasorder)
                                                            {
                                                                oShownum.innerHTML = '2';
                                                            }

                                                            oFruit.onclick = function () {
                                                                window.location.href = 'list.html';
                                                            }
                                                        </script>
                                                        </body>
                                                        </html>
