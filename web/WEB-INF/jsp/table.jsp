
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <base href="${pageContext.request.contextPath}/">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="lib/layui-v2.5.4/css/layui.css" media="all">
    <link rel="stylesheet" href="css/public.css" media="all">
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        <script src="js/jquery-3.4.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/tablescript.js"></script>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main" >




        <div class="container text-center">
            <br>
            <h1 class="text-warning">用户列表</h1>

            <a href="javascript:findAll();" class="btn btn-info">查询所有用戶</a>
            <hr>
            <a href="javascript:popupAdd();">+添加用戶信息</a>
            &nbsp;&nbsp;
            <a href="index"><<返回首页</a>
            <br>
            <hr>

            <table id="dataTable" class="table table-hover table-striped">
                <tr>
                    <th>用户编号</th>                                      
                    <th>用户姓名</th>

                    <th>性别</th>
                    <th>电话</th>
                    <th>操作</th>
                </tr>

                </tr>
            </table>
            <br>

             <!--Modal--> 
            <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h2  class="modal-title text-danger" id="editModalLabel">编辑用户信息</h2>
                        </div>
                        <div class="modal-body">
                            <form id="editForm" class="form-inline" method="post">
                                <span>用户编号：</span>
                                <input type="text" id="inputId" name="uid" class="form-control" readonly>
                                <br><br>
                                <span>用户姓名：</span>
                                <input type="text" id="inputName" name="uname" class="form-control">
                                <br><br>
                                <span>性别：</span>
                                <input type="text" id="inputPrice" name="ugender" class="form-control">
                                <br><br>
                                <span>电话：</span>
                                <input type="text" id="inputUnit" name="ucontact" class="form-control">   
                                <br><br>

                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button id="btnEdit" type="button" class="btn btn-primary">保存修改</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h2 class="modal-title text-danger" id="addModalLabel">添加新用户</h2>
                        </div>
                        <div class="modal-body">
                            <form id="addForm" class="form-inline" method="post">
                                <span>用户编号：</span>
                                <input type="text" id="proId" name="uid" class="form-control" placeholder="在此输入用户编号">
                               <br><br>
                                <span>用户姓名：</span>
                                <input type="text" id="proName" name="uname" class="form-control" placeholder="在此输入用户姓名">
                                <br><br>
                                <span>性别：</span>
                                <input type="text" id="proPrice" name="ugender" class="form-control" placeholder="在此输入用户性别">
                                <br><br>
                                <span>电话：</span>
                                <input type="text" id="proUnit" name="ucontact" class="form-control" placeholder="在此输入用户电话">   
                                <br><br>

                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button id="btnAdd" type="button" class="btn btn-primary">添加</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>



    </div>
</div>


</body>
</html>