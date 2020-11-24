<%--<%@page import="java.util.Iterator"%>
<%@page import="com.qdu.entity.Products"%>
<%@page import="java.util.List"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <!--<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">-->
        <title>按区间搜索商品</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <base href="${pageContext.request.contextPath}/"> 
                <link rel="stylesheet" href="css/bootstrap.min.css"/> 
                <link rel="stylesheet" type="text/css" href="css/reset.css">
                    <link rel="stylesheet" type="text/css" href="css/main.css">    
                        <link rel="stylesheet" href="css/shaixuan.css"/>
                        <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
                        <script type="text/javascript" src="js/jquery-ui.min.js"></script> 
                        <script src="js/bootstrap.min.js"></script> 
                        <script type="text/javascript" src="js/slide.js"></script>
                        <script src="js/shaixuan.js"></script>

                        </head>
                        <body>
                            <div class="header_con">
                                <div class="header">
                                    <div class="welcome fl">欢迎来到funny-book!</div>
                                    <div class="fr">
                                        <div class="login_info fl">
                                            欢迎您：<em>${user.uname}</em>
                                        </div>
                                        <div class="login_btn fl">
                                            <a href="to_login">登录</a>
                                            <span>|</span>
                                            <a href="register.html">注册</a>
                                        </div>
                                        <div class="user_link fl">
                                            <span>|</span>
                                            <a href="user_center_info.html">用户中心</a>
                                            <span>|</span>
                                            <a href="cart.html">我的购物车</a>
                                            <span>|</span>
                                            <a href="user_center_order.html">我的订单</a>
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

                                                <hr style="border-color: #00bc6f">

                                                    <div class="container">
                                                        <div id="box">
<!--                                                            <dl>
                                                                <dt>品牌：</dt>
                                                                <dd><label style="cursor: inherit"><input type="radio" name="pin" value="苹果">苹果</label></dd>
                                                                <dd><label style="cursor: inherit"><input type="radio" name="pin" value="三星">三星</label></dd>
                                                                <dd><label style="cursor: inherit"><input type="radio" name="pin" value="小米">小米</label></dd>
                                                                <dd><label style="cursor: inherit"><input type="radio" name="pin" value="华为">华为</label></dd>
                                                                <dd><label style="cursor: inherit"><input type="radio" name="pin" value="OPPO">OPPO</label></dd>
                                                                <dd><label style="cursor: inherit"><input type="radio" name="pin" value="vivo">vivo</label></dd>
                                                                <dd><label style="cursor: inherit"><input type="radio" name="pin" value="魅族">魅族</label></dd>
                                                                <dd><label style="cursor: inherit"><input type="radio" name="pin" value="诺基亚">诺基亚</label></dd>
                                                                <dd><label style="cursor: inherit"><input type="radio" name="pin" value="其他">其他</label></dd>
                                                            </dl>-->
                                                            <dl>
                                                                <dt>价格：</dt>
                                                                <dd><label style="cursor: inherit"><input type="radio" name="price" value="0-10">10元以下</label></dd>
                                                                <dd><label style="cursor: inherit"><input type="radio" name="price" value="10-20">10元-20元</label></dd>
                                                                <dd><label style="cursor: inherit"><input type="radio" name="price" value="20-30">20元-30元</label></dd>
                                                                <dd><label style="cursor: inherit"><input type="radio" name="price" value="30-40">30元-40元</label></dd>
                                                                <dd><label style="cursor: inherit"><input type="radio" name="price" value="40-50">40元-50元</label></dd>
                                                                <dd><label style="cursor: inherit"><input type="radio" name="price" value="50-60">50元-60元</label></dd>
                                                                <dd><label style="cursor: inherit"><input type="radio" name="price" value="60-70">60元-70元</label></dd>
                                                            </dl>

                                                            <b><button id="btnQuery" class="btn btn-info" type="button" style="width: 100%;height: 50px;float: right;color: #eea236;font-size: 17px;background-color: #f0fdec;border-color: #00bc6f;">查询</button></b>
                                                            <!--                                                        <br>-->
                                                        </div>
                                                        <br><br>                                                    <!--显示出来的商品的图片和说明-->
                                                                <div class="ibox-content">
                                                                    <div class="row" id="data">
                                                                    </div>
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

                                                                <script>
                                                                    let curWwwPath = window.document.location.href;
                                                                    let pathName = window.document.location.pathname;
                                                                    let pos = curWwwPath.indexOf(pathName);
                                                                    let localhostPaht = curWwwPath.substring(0, pos);
                                                                    //            let price = $("input[name='price']:checked").val();
                                                                    let name = $("input[name='pin']:checked").val();
                                                                    let price = "0-100000";

                                                                    $(document).ready(function () {

                                                                        $("#btnQuery").click(function () {
                                                                            name = $("input[name='pin']:checked").val();
                                                                            price = $("input[name='price']:checked").val();
                                                                            queryAll(name, price);
                                                                        });

                                                                    });

                                                                    //            $(function () {
                                                                    //                
                                                                    //            });

                                                                    function queryAll(name, price) {

                                                                        $.post(localhostPaht + '/funny-book/queryData/queryDataByCondition',
                                                                                'name=' + name + '&price=' + price, (msg) => {
                                                                            let td = "";
                                                                            $.each(msg, (index, product) => {
                                                                                td += "<div>" +
                                                                                        "<div class='col-md-3 col-sm-6'>" +
                                                                                        "<div class='thumbnail'>" +
                                                                                        "<a href='#'><img src='img/digital/" + product.pid + ".jpg' style='height: 200px;'></a>" +
                                                                                        "<div class='caption'>" +
                                                                                        "<h3 style='text-align: center'><b style='color: orange;font-size:15px'>仅售：" + product.pprice + "</b></h3>" +
                                                                                        "<br>" +
                                                                                        "<h4 style='text-align: center;font-size:15px'>" + product.pdesc + "</h4>" +
                                                                                        "<br>" +
                                                                                        "<p><a href='#' class='btn btn-success ' style='width: 100%' role='button'>下单</a></p>" +
                                                                                        "</div> </div> </div> </div>";
                                                                            });
                                                                            $("#data").html(td);
                                                                        }, 'json');
                                                                    }

                                                                </script>

                                                                </body>
                                                                </html>
