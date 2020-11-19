<%-- 
    Document   : order
    Created on : 2019-12-18, 8:14:03
    Author     : lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>funny-book</title>
        <link rel="stylesheet" type="text/css" href="css/reset.css">
        <link rel="stylesheet" href="css/carts.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <base href="${pageContext.request.contextPath}/" /> 
    </head>
    <body>
        <div class="header_con">
            <div class="header">
                <div class="welcome fl">欢迎来到funny-book!</div>
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
            <div class="logo fl">
                <p>当前登录：</p>
                <p>${user.uname}</p>
                <p><a href="logout">退出登录</a></p>
            </div>
            <div class="sub_page_name fl">|&nbsp;&nbsp;&nbsp;&nbsp;用户中心</div>
            <div class="search_con fr">
                <input type="text" class="input_text fl" name="" placeholder="搜索商品">
                <input type="button" class="input_btn fr" name="" value="搜索">
            </div>		
        </div>

        <div class="main_con clearfix">
            <div class="left_menu_con clearfix">
                <h3>用户订单</h3>
                <ul>

<!--                    <li class="active"> 订单</li>-->
                    <li><a href="order" class="active">·订单 </a></li>
                    <li><a href="totalOrder" >· 全部订单</a></li>

                </ul>
            </div>
            <div class="right_content clearfix">
                <form name="order" action="updateOrder" target="_blank" method="post">
                    <h3 class="common_title2">订单</h3>

                    <c:forEach var="c" items="${orderList}">
                      
                        <ul class="order_list_th w978 clearfix">
                            <li class="col01">${c.orderDate}</li>
                            <li class="col02">订单号：${c.orderId}</li>
                            <li class="col02 stress">${c.pstatus}</li>		
                        </ul>

                        <table class="order_list_table w980">
                            <tbody>
                                <tr>
                                    <td width="55%">
                                        <ul class="order_goods_list clearfix">					
                                            <li class="col01"><img src="/funny-book/img/digital/${c.pid}.jpg"></li>
                                            <!--<li class="col01"></li>-->
                                            <!--<li class="col01"></li>-->
                                            <!--<li class="col01"></li>-->
                                            <!--<li class="col02"></li>-->	
                                            <!--<li class="col02"></li>-->	
                                            <li class="col04">收货人：${c.receiverName}</li>	
                                            <li class="col04">联系电话：${c.buyerPhone}</li>	
                                            <li class="col04">收获地址：${c.buyerAddress}</li>	
                                            <li class="col04">总金额：${c.pprice}</li>	
                                        </ul>
                                    </td>

                                    <td width="15%">${c.pstatus}</td>

                                </tr>
                            </tbody>
                        </table>
                       <%--</c:forEach>--%>
                    </c:forEach>
                    <div class="bar-wrapper" style=" left: 50px">
                       
                        <div style="float: right;right: 50px;">
                             付款金额：${total} 
                            <input type="submit" class="oper_btn" value="去付款" style="background-color: #e4b9b9;width:80px ;height: 50px;right: 50px">
                        </div>
                    </div>

                </form>
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
            <p>CopyRight © 2019 funny-book哈哈哈哈哈 All Rights Reserved</p>
            <p>电话：155****6998    青岛TCP/IP备*******4号</p>
        </div>
    </body>
</html>
