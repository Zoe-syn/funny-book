

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="utf-8">
        <title>修改密码</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <base href="${pageContext.request.contextPath}/">
        <link rel="stylesheet" href="lib/layui-v2.5.4/css/layui.css" media="all">
        <link rel="stylesheet" href="css/public.css" media="all">
        <script src="lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
        <style>
            .layui-form-item .layui-input-company {width: auto;padding-right: 10px;line-height: 38px;}
        </style>
    </head>
    <body>
        <div class="layuimini-container">
            <div class="layuimini-main">

                <div class="layui-form layuimini-form">
                    <div class="layui-form-item">
                        <label class="layui-form-label required">旧的密码</label>
                        <div class="layui-input-block">
                            <input type="password" id="old_password" name="old_password" lay-verify="required" lay-reqtext="旧的密码不能为空" placeholder="请输入旧的密码"  value="" class="layui-input">
                            <!--                    <tip id="msg1">填写自己账号的旧的密码。</tip>-->
                            <h4 id="msg1"></h4>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label required">新的密码</label>
                        <div class="layui-input-block">
                            <input type="password" id="new_password" name="new_password" lay-verify="required" lay-reqtext="新的密码不能为空" placeholder="请输入新的密码"  value="" class="layui-input">

                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label required">重复密码</label>
                        <div class="layui-input-block">
                            <input type="password" id="again_password" name="again_password" lay-verify="required" lay-reqtext="新的密码不能为空" placeholder="请输入新的密码"  value="" class="layui-input">
                            <!--                            <tip id="msg2"></tip>-->
                            <h4 id="msg2"></h4>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button id="btn" class="layui-btn" lay-submit lay-filter="saveBtn">确认保存</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <script>

            $(document).ready(function () {

                // var username_result = false;
                //var userpwd_result = false;

                $("#old_password").blur(function () {

                    $.ajax({
                        url: "mpwd/yzmm",
                        type: "POST",
                        data: {old_password: $("#old_password").val()}, //将id为nameText文本框的值作为一个请求参数发送给控制器
                        success: function (data) { //success对应的函数可以添加一个参数，接收控制器返回的数据
                            //如果请求处理成功，将返回的数据设置为id为msg的元素的内容
                            $("#msg1").html(data);
                        },
                        error: function (req, status, error) {
                            //error对应的函数的三个参数：请求对象、请求状态、错误信息
                            alert("Ajax请求处理失败，错误：" + error);
                        }
                    });

                });

                $("#again_password").blur(function () {
                    $.ajax({
                        url: "mpwd/yzyz",
                        type: "POST",
                        data: {again_password: $("#again_password").val(), new_password: $("#new_password").val()}, //将id为nameText文本框的值作为一个请求参数发送给控制器
                        success: function (data) { //success对应的函数可以添加一个参数，接收控制器返回的数据
                            //如果请求处理成功，将返回的数据设置为id为msg的元素的内容
                            $("#msg2").html(data);
                        
                        },
                        error: function (req, status, error) {
                            //error对应的函数的三个参数：请求对象、请求状态、错误信息
                            alert("Ajax请求处理失败，错误：" + error);
                        }
                    });

                });
                
                   $("#btn").click(function () {
                    $.ajax({
                        url: "mpwd/gxmm",
                        type: "POST",
                        data: {new_password: $("#new_password").val()}, //将id为nameText文本框的值作为一个请求参数发送给控制器
                        success: function () { //success对应的函数可以添加一个参数，接收控制器返回的数据
                            //如果请求处理成功，将返回的数据设置为id为msg的元素的内容
                            alert("密码更改成功！");
                            
                        },
                        error: function (req, status, error) {
                            //error对应的函数的三个参数：请求对象、请求状态、错误信息
                            alert("密码更改成功");
                        }
                    });

                });
                
                
                
            });
        </script>

    </body>
</html>