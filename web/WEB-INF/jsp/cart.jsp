<%-- 
    Document   : cart
    Created on : 2019-12-3, 13:48:26
    Author     : lihexiao
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>购物车</title>
        <link rel="stylesheet" href="css/re.css">
        <link rel="stylesheet" href="css/carts.css">
        <base href="${pageContext.request.contextPath}/"> 
        <link rel="stylesheet" type="text/css" href="css/reset.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui.min.js"></script>



    </head>
    <body>
        <section class="cartMain">
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
                <!--<a href="index.html" class="logo fl"><img src="images/logo.png"></a>-->
                <div class="logo fl">
                    <p>当前登录：</p>
                    <p>${user.uname}</p>
                    <p><a href="logout">退出登录</a></p>
                </div>
                <div class="search_con fl">
                    <form action="getOne">
                        <input type="text" class="input_text fl" name="pid" placeholder="搜索商品">
                        <input type="submit" class="input_btn fr"  value="搜索">
                    </form>
                </div>
                <div class="guest_cart fr">
                    <a href="to_cart" class="cart_name fl">我的购物车</a>
                    <div class="goods_count fl" id="show_count">1</div>
                </div>
            </div>
            <div class="cartMain_hd">
                <ul class="order_lists cartTop">
                    <li class="list_chk">
                        <!--所有商品全选-->
                        <input type="checkbox" id="all" class="whole_check">
                        <label for="all"></label>
                        全选
                    </li>
                    <li class="list_con">商品信息</li>
                    <li class="list_info">加购时间</li>
                    <li class="list_price">单价</li>
                    <li class="list_amount">数量</li>
                    <li class="list_sum">金额</li>
                    <li class="list_op">操作</li>
                </ul>
            </div>
            <form action="addOrder" method="post">
                <div class="cartBox">

                    <div class="order_content">


                        <c:forEach var="c" items="${list}">
                            <ul class="order_lists" id="ul{c.cartId}" >
                                <li class="list_chk">
                                    <input type="checkbox" class="son_check" id="${c.cartId}" name="getCart" value="${c.cartId}">
                                    <label for="${c.cartId}"></label>
                                </li>
                                <li class="list_con">

                                    <div class="list_text"><a href="javascript:;">${c.pname}</a></div>
                                    <div class="list_img"><a href="javascript:;"><img src="/funny-book/img/digital/${c.pid}.jpg" alt="" width="100" height="100"></a></div>

                                </li>
                                <li class="list_info">
                                    <p>规格：默认</p>
                                    <p>${c.ctime}</p>
                                </li>
                                <li class="list_price">
                                    <p class="price">￥${c.cprice}</p>
                                </li>
                                <li class="list_amount">

                                    <div class="amount_box">
                                        <a href="javascript:;" class="reduce reSty">-</a>
                                        <input type="text" value=${c.cquantity} class="sum">
                                        <a href="javascript:;" class="plus">+</a>
                                    </div>
                                </li>
                                <li class="list_sum">
                                    <p class="sum_price">￥${c.cprice}</p>
                                </li>
                                <li class="list_op">
                                    <p class="del"><a href="javascript:;" id="remove" class="delBtn"  >移除商品</a></p>
                                    <!--<p class="del"><a href="delete/" id="remove" class="delBtn"  >移除商品</a></p>-->
                                </li>
                            </ul>
                        </c:forEach>

                    </div>
                </div>

<!--                <script>
                   
                   function delete(){
                       var datas={"id","C20191222124918"};
                            //调用jQuery提供的ajax函数发送ajax请求给servlet7这个Servlet，
                            //提交表单中的5个数据，添加一名新的学生到数据库中
                            $.ajax({
                                url: 'delete', //请求发送给url为servlet7的Servlet
                                type: 'POST', //请求发送方式可以用GET或POST等
                                data: datas,
                                success: function (data) { //返回的数据是一个json对象，包含两个数据，msg和class，也就是消息和消息的样式类名称
                                   $("#ul" + id).remove(); 
                                },
                                error: function () { //error属性指定如果请求失败，要调用的函数
                                    alert("出现错误!");
                                }
                        });
                    };
                </script>-->
                <!--底部-->
                <div class="bar-wrapper">
                    <div class="bar-right">
                        <div class="piece">已选商品<strong class="piece_num">0</strong>件</div>
                        <!--<div class="totalMoney">共计: <strong class="total_text">0.00</strong></div>-->
                        <div class="calBtn">
                            <input type="submit" value="结算" style="background-color: #e4b9b9;width:80px ;height: 50px;"/>
                            <!--                            <a href="order"></a>--></div>
                    </div>
                </div>
            </form>
        </section>
        <section class="model_bg"></section>
        <section class="my_model">
            <p class="title">删除宝贝<span class="closeModel">X</span></p>
            <p>您确认要删除该宝贝吗？</p>
            <div class="opBtn"><a href="javascript:;" class="dialog-sure">确定</a><a href="javascript:;" class="dialog-close">关闭</a></div>
        </section>

        <script src="js/jquery.min.js"></script>
        <script src="js/carts.js"></script>
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
