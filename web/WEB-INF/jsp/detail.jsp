<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Date"%>
<%@page import="com.qdu.entity.Products"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>C@C-首页</title>
        <base href="${pageContext.request.contextPath}/">
	<base href="${pageContext.request.contextPath}/">
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" crossorigin="anonymous">
            <link rel="stylesheet" href="css/pl.css"/>
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
             
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/slide.js"></script>
           <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" crossorigin="anonymous"></script>
        </head>
<body>
     
	<div class="header_con">
		<div class="header">
			<div class="welcome fl">欢迎来到C@C!</div>
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
		<a href="index.html" class="logo fl"><img src="images/logo.png"></a>
		<div class="search_con fl">
			<input type="text" class="input_text fl" name="" placeholder="搜索商品">
			<input type="button" class="input_btn fr" name="" value="搜索">
		</div>
		<div class="guest_cart fr">
			<a href="#" class="cart_name fl">我的购物车</a>
			<div class="goods_count fl" id="show_count">1</div>
		</div>
	</div>

	<div class="navbar_con">
		<div class="navbar clearfix">
			<div class="subnav_con fl">
				<h1>全部商品分类</h1>	
				<span></span>			
				<ul class="subnav">
                                                               <li><a href="#model01" class="fruit">文学</a></li>
                                                                <li><a href="#model02" class="seafood">科幻</a></li>
                                                                <li><a href="queryData/to_shaixuan" class="meet">心理</a></li>
                                                                <li><a href="#model04" class="egg">悬疑</a></li>
                                                                <li><a href="#model05" class="vegetables">小说</a></li>
                                                                <li><a href="#model06" class="ice">其他</a></li>
				</ul>
			</div>
			<ul class="navlist fl">
				<li><a href="">首页</a></li>
				<li class="interval">|</li>
				<li><a href="">C@C</a></li>
				<li class="interval">|</li>
				<li><a href="">抽奖</a></li>
			</ul>
		</div>
	</div>
                                <div class="container"  style=" margin-left: 100px">
	<div class="breadcrumb">
		<a href="#">全部分类</a>
		<span>></span>
		<a href="#">类型</a>
		<span>></span>
		<a href="#">商品详情</a>
	</div>

	<div class="goods_detail_con clearfix">
            <div class="goods_detail_pic fl">
                    <img src="/funny-book/img/digital/${product.pid}.jpg" height="250px" width="200px"/>
            </div>

                <%--
                 Products p=(Products) request.getAttribute("product");
                --%>
                
                
		<div class="goods_detail_list fr">
                    
			<h3>${product.pname}<%--=p.getPname()--%></h3>
			<p>${product.pdesc}</p>
			<div class="prize_bar">
				<span class="show_pirze">¥<em>${product.pprice}</em></span>
				
			</div>

			<div class="total">
                            价格：<em>${product.pprice}</em></div>
			<div class="operate_btn">
				<a href="javascript:;" class="buy_btn">立即购买</a>
                               <a href="addCart" class="add_cart" id="add_cart"/>加入购物车</a>				
			</div>
                    
		</div>
	</div>
 </div>
	<div class="main_wrap clearfix">
	
<!--            <h1>评论</h1>-->

<!--		<div class="r_wrap fr clearfix">-->
			<ul class="detail_tab clearfix">
			
				<li>评论</li>
			</ul>

			

		</div>
	</div>
 <input id="loginUid" type="hidden" value="${user.uid}">             
 <input id="loginUname" type="hidden" value="${user.uname}">
                      <!--评论-->
  <div class="container">
        <div id="a-comment">
            <c:forEach items="${commentList}" var="c" varStatus="status">
                <div id="con-1">
                    <div id="user-area">
                        <input type="hidden" class="aid" id="id${status.index+1}1" value="${c.id.pid}">
                        <input type="hidden" id="id${status.index+1}2" value="${c.id.uid}">
                      
                        <br>                <!-- list从0开始存，index也是从0开始迭代，如果是count的话，由于count是从1开始迭代，需要用count-1-->
                        <font style="font-weight: bold">${userList[status.index].uname}</font>
                      
                        <p style="font-size: 12px;">${c.ctime}评</p>
                    </div>
                    <div id="comment-area${status.index+1}" class="comment-area">
                      
                        <p style="font-size: 16px;">${c.cdetail}</p>
                        <a id="id${status.index+1}"  class="bbb glyphicon glyphicon-thumbs-up btn">有用(<span id="id${status.index+1}3">${c.clike}</span>)</a>
                        <a href="javascript:test('${status.index+1}')"  class="aaa glyphicon glyphicon-pencil btn"><span id="id${status.index+1}4">回复/留言</span></a>
                        <hr>           <!--第一个是该活动id 第二个id是登录后的账户名，这里先用发布人的用户名暂代，第三个是被回复的用户id-->

                        <c:forEach items="${recommentList}" var="r" varStatus="status">
                            <c:choose>
                                <c:when test="${r.ruid==c.id.uid}">
                                    <div id="recomment-area">
                                        <div id="re-1">
                                            <p>[${recommentUserList[status.index].uname}回复]</p>
                                        </div>
                                        <div id="re-2">
                                              <p>${r.rdetail} &nbsp;&nbsp;    ${r.rtime}</p>
                                        </div>
                                    </div>
                                </c:when>
                            </c:choose>
                        </c:forEach>
                    </div>
                </div>
            </c:forEach> 
        </div>
    </div>

 
  <!--添加评论、以及报名活动-->
    <div style="margin-bottom: 20px;" class="container join">
        <div id="join-1">
            <a href="javascript:add('${user.uname}')" type="button" class="btn btn-default" data-dismiss="modal">添加评论</a>
          
        </div>
    </div>

    <!--     Modal 添加回复-->
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h2 class="modal-title text-danger" id="addModalLabel">回复留言</h2>
                </div>
                <div class="modal-body">
                    <form id="addForm" class="form-inline" method="post">
                        <span>昵称：</span>
                        <input type="text" id="person1" name="productPrice" class="form-control" value="本人是肖战" readonly>
                        <br><br>
                        <span>被评论人：</span>
                        <input type="text" id="person2" name="productUnit" class="form-control" readonly>   
                        <br><br>
                        <%
                            Date d = new Date();
                            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");  //HH:mm:ss
                            String now = df.format(d);
                        %>

                        <span>回复时间：</span>
                        <input type="text" id="reTime" name="productStock" class="form-control" value="<%=now%>" readonly>
                        <br><br>
                        <span>回复内容：</span>
                        <textarea id="reDetail" name="productName" class="form-control" placeholder="在此输入留言"></textarea>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button id="btnAdd" type="button" class="btn btn-danger">添加</button>
                </div>
            </div>
        </div>
    </div>
 
                        
     <!--     Modal 添加评论-->
    <div class="modal fade" id="addCommentModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h2 class="modal-title text-danger" id="addModalLabel">评论留言</h2>
                </div>
                <div class="modal-body">
                    <form id="addForm" class="form-inline" method="post">
                        <span>昵称：</span>
                        <input type="text" id="uname" class="form-control" value="lalala" readonly>
                        <input type="hidden" id="uid" class="form-control" value="${user.uid}" readonly >
                        <br><br>
                        <span>评论时间：</span>
                        <input type="text" id="ctime" class="form-control" value="<%=now%>" readonly>
                        <br><br>
                        <span>评论内容：</span>
                        <textarea id="cdetail"  class="form-control" placeholder="在此输入留言"></textarea>
                        <input type="hidden" id="aid" class="form-control" value="${product.pid}" readonly> 
                        <input type="hidden" id="clike" class="form-control" value="0" readonly>
                    </form>
                </div>
                <div class="modal-footer">
                    <button id="addComment" type="button" class="btn btn-danger">评论</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
    </div>                   


                        
     <script>

        var commentid;

        function test(id) {

            var btnId = "id"+id;
            commentid="#comment-area"+id;
//            alert(commentid);

            $.ajax({
                url: 'get_recomment_to_add',
                type: 'POST',
                data: {uid: $("#loginUid").val(), ruid: $("#" + btnId + 2).val()}, //发送一个请求参数，参数名为rid，参数值为传入的rid变量的值
                success: function (data) {
                    $("#person1").val(data.uid);
                    $("#person2").val(data.ruid);
                    $('#addModal').modal('show');
                },
                error: function (req, status, error) {
                    alert("Ajax请求失败，错误：" + error);
                }
            });
        }
 function add(name) {

            var loginuser = name;

            $("#uname").val(loginuser);
            $('#addCommentModal').modal('show');

        }
       

        $(document).ready(function () {
            
            

            $(".bbb").click(function () {

                var btnId = $(this).attr("id");

                $.ajax({
                    url: "likeNum",
                    type: "POST",
                    data: {id1: $("#" + btnId + "1").val(), id2: $("#" + btnId + 2).val(), num: $("#" + btnId + 3).html()},
                    success: function (data) {
                        $("#" + btnId + 3).html(data);
                    },
                    error: function (req, status, error) {
                        alert("Ajax请求处理失败，错误：" + error);
                    }

                });
            });

            $("#btnAdd").click(function () {

                $.ajax({
                    url: 'add_recomment',
                    type: 'POST',
                    data: {pid: $(".aid").val(),
                        uname: $("#person1").val(),
                        runame: $("#person2").val(),
                        time: $("#reTime").val(),
                        detail: $("#reDetail").val()},
                    success: function (data) {

                        var p = {
                            person1: $("#person1").val(),
                            time: $("#reTime").val(),
                            detail: $("#reDetail").val()
                        };

                        var str = "<div id=\"recomment-area\">"
                                + "<div id=\"re-1\">"
                                + "<p>[" + p.person1 + "回复]</p>"
                                + "</div>"
                                + "<div id=\"re-2\">"
                                + "<p>" + p.detail + "</p>"
                                + "<p>" + p.time +"</p>"
                                + "</div>"
                                + "</div>";


                        $(commentid).append(str);  //怎样获取到不同评论区的id值

                        $('#addModal').modal("hide");
                    },
                    error: function (req, status, error) {
                        alert("Ajax请求失败，错误：" + error);
                    }
                });
            });

            $("#addComment").click(function () {
                $.ajax({
                    url: 'add_comment',
                    type: 'POST',
                    data: {pid: $("#aid").val(),
                        uid: $("#uid").val(),
                        cdetail: $("#cdetail").val(),
                        clike: $("#clike").val(),
                        ctime: $("#ctime").val()
                    },
                    success: function (data) {
                        var c = {
                            uname: $("#uname").val(),
                            ctime: $("#ctime").val(),
                            cdetail: $("#cdetail").val(),
                            clike: $("#clike").val()
//                          
                        };

                        var str = "<div id=\"con-1\">"
                                + "<div id=\"user-area\">"
//                              
                                + "<br>"
                                + "<font style=\"font-weight: bold\">" + c.uname + "</font>"
//                              
                                + "<p style=\"font-size: 12px;\">" + c.ctime + "评</p>"
                                + "</div>"
                                + "<div class=\"comment-area\">"
//                                + "<p style=\"font-size: 14px;\">添加了对<span style=\"color: #ff9d33\">" + c.atheme + "</span>的评论</p>"
                                + "<p style=\"font-size: 16px;\">" + c.cdetail + "</p>"
                                + "<a class=\"bbb glyphicon glyphicon-thumbs-up btn\">有用(<span>" + c.clike + "</span>)</a>"
                                + "<a class=\"aaa glyphicon glyphicon-pencil btn\"><span>回复/留言</span></a>"
                                + "<hr>         "
                                + "</div>"
                                + "</div>";

                        $("#a-comment").append(str);

                        $('#addCommentModal').modal("hide");

                    },
                    error: function (req, status, error) {
                        alert("Ajax请求失败，错误：" + error);
                    }
                });
            });

        });

    </script>


</html>
