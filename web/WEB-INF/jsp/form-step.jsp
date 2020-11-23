

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>分步表单</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="stylesheet" href="lib/layui-v2.5.4/css/layui.css" media="all">
        <link rel="stylesheet" href="css/public.css" media="all">
        <link rel="stylesheet" href="lib/lay-module/step-lay/step.css" media="all">
        <script src="js/jquery-3.4.1.min.js"></script>
        
    </head>
    <script>
        $(function () {
            $("#yes").click(function () {
                $.ajax({
                    type: 'POST',
                    url: "userinfo/sendEmail",
                    data: "recieve=" + $("#receive").html(),
                    success: function (data) {
                        console.log(data);
                    },
                    error: function (jqXHR) {
                        alert(jqXHR.status);
                    }
                    

                });
            });
        });
    </script>
    <body>
        <div class="layuimini-container">
            <div class="layuimini-main">

                <div class="layui-fluid">
                    <div class="layui-card">
                        <div class="layui-card-body" style="padding-top: 40px;">
                            <div class="layui-carousel" id="stepForm" lay-filter="stepForm" style="margin: 0 auto;">
                                <div carousel-item>
                                    <div>
                                        <form class="layui-form" style="margin: 0 auto;max-width: 460px;padding-top: 40px;">
                                            <div class="layui-form-item">
                                                <label class="layui-form-label">用户邮件地址:</label>
                                                <div class="layui-input-block">
                                                    <input type="text" placeholder="请填写用户邮箱" class="layui-input" lay-verify="number" required />
                                                </div>
                                            </div>
                                            
                                            <div class="layui-form-item">
                                                <label class="layui-form-label">类型:</label>
                                                <div class="layui-input-block">
                                                    <select lay-verify="required">
                                                        <option value="1" selected>QQ邮件</option>
                                                        <option value="2">163邮件</option>
                                                    </select>
                                                </div>
                                            </div>
                                            
                                            <div class="layui-form-item">
                                                <label class="layui-form-label">备注说明:</label>
                                                <div class="layui-input-block">
                                                    <textarea placeholder="入款备注" value="" class="layui-textarea"></textarea>
                                                </div>
                                            </div>
                                            <div class="layui-form-item">
                                                <div class="layui-input-block">
                                                    <button class="layui-btn" lay-submit lay-filter="formStep">
                                                        &emsp;下一步&emsp;
                                                    </button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <div>
                                        <form class="layui-form" style="margin: 0 auto;max-width: 460px;padding-top: 40px;">
                                            <div class="layui-form-item">
                                                <label  class="layui-form-label">收件人:</label>
                                                <div class="layui-input-block">
                                                    <div id="receive" class="layui-form-mid layui-word-aux">1062679091@qq.com</div>
                                                </div>
                                            </div>
                                            
                                            <div class="layui-form-item">
                                                <label class="layui-form-label">类型:</label>
                                                <div class="layui-input-block">
                                                    <div class="layui-form-mid layui-word-aux">发送邮件警告</div>
                                                </div>
                                            </div>
                                           
                                           
                                            <div class="layui-form-item">
                                                <div class="layui-input-block">
                                                    <button type="button" class="layui-btn layui-btn-primary pre">上一步</button>
                                                    <button id="yes" class="layui-btn" lay-submit lay-filter="formStep2">
                                                        &emsp;确认入款&emsp;
                                                    </button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <div>
                                        <div style="text-align: center;margin-top: 90px;">
                                            <i class="layui-icon layui-circle"
                                               style="color: white;font-size:30px;font-weight:bold;background: #52C41A;padding: 20px;line-height: 80px;">&#xe605;</i>
                                            <div style="font-size: 24px;color: #333;font-weight: 500;margin-top: 30px;">
                                                发送邮件成功
                                            </div>

                                        </div>
                                        <div style="text-align: center;margin-top: 50px;">
                                            <button class="layui-btn next">再来一封</button>
                                            <button class="layui-btn layui-btn-primary">查看账单</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <hr>

                        </div>
                    </div>
                </div>

            </div>
        </div>
        <script src="lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
        <script src="js/lay-config.js?v=1.0.4" charset="utf-8"></script>
        <script>
        layui.use(['form', 'step'], function () {
            var $ = layui.$,
                    form = layui.form,
                    step = layui.step;

            step.render({
                elem: '#stepForm',
                filter: 'stepForm',
                width: '100%', //设置容器宽度
                stepWidth: '750px',
                height: '500px',
                stepItems: [{
                        title: '填写发送信息'
                    }, {
                        title: '确认发送信息'
                    }, {
                        title: '完成'
                    }]
            });


            form.on('submit(formStep)', function (data) {
                step.next('#stepForm');
                return false;
            });

            form.on('submit(formStep2)', function (data) {
                step.next('#stepForm');
                return false;
            });

            $('.pre').click(function () {
                step.pre('#stepForm');
            });

            $('.next').click(function () {
                step.next('#stepForm');
            });
        })
        </script>
    </body>
</html>