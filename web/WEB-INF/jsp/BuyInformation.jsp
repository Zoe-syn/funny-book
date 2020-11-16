<%-- 
    Document   : Buy
    Created on : 2019-11-21, 21:25:02
    Author     : lihexiao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>我要发布</title>
        <base href="${pageContext.request.contextPath}/">
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        <script src="js/jquery-3.4.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/script.js"></script>
        <style>
            #ddd{
                background-image: url(/C2C/img/back.jpg);
                background-size: cover;
            }
        </style>

    </head>
    <body class="container" id="ddd">
        <h1 style="margin-left: 100px;">发布求购信息</h1>
        <div class="modal-body" style="margin-left: 100px;" >
            <form id="editForm" class="form-inline" method="post" action="buy/buy">

                <input type="hidden" id="inputId"  class="form-control" >
                <br><br>
                <span>用户编号：</span>
                <input type="text" id="inputName" name="uid" class="form-control" value="${user.uid}" readonly>
                <br><br>
                <span>产品名称：</span>
                <input type="text" id="inputPrice" name="productName" class="form-control">
                <br><br>
                <span>产品品牌：</span>
                <input type="text" id="inputUnit" name="productBrand" class="form-control">   
                <br><br>
                <span>最低价格：</span>
                <input type="text" id="inputStock" name="productLower" class="form-control">
                <br><br>
                <span>最高价格：</span>
                <input type="text" id="inputStock" name="productHigher" class="form-control">
                <br><br>

                <!--<span>添加时间：</span>-->

                <input type="hidden" id="inputStock"  class="form-control"> <br><br>
                <span>产品描述：</span>
                <textarea rows="7" cols="50" id="inputStock" name="productDesc" class="form-control">
                </textarea>
                <br><br>
                <div class="modal-footer">
                    <button type="reset" class="btn btn-default" data-dismiss="modal">重置</button>
                    <button id="btnAdd" type="submit" class="btn btn-danger">添加</button>
                </div>
            </form>
        </div>


    </body>
</html>
