
function findAll() {

    $.ajax({
        url: 'buy/findAll',
        type: "POST",
        success: function (list) {

            $("#dataTable tr.datarow").remove();

            $.each(list, function (index, p) {
                //console.log(p);
                var str = "<tr id=tr" + p.buyId+ " class=\"datarow\">" +
                    
                        "<td>" + p.pname + "</td>" +
                        
                        "<td>" +
                        "<a href=\"javascript:popupEdit(" + p.buyId + ");\">编辑</a>&nbsp;&nbsp;" +
                        "<a href=\"javascript:delete_product(" + p.buyId + ");\">删除</a>" +
                        "</td></tr>";

                $("#dataTable").append(str);
            });
        },
        error: function (req, status, error) {
            alert("Ajax请求失败！" + error);
        }
    });
}

//定义一个函数,根据编号删除产品
function delete_product(buyId) {
    $.ajax({
        url: 'buy/deleteBuy',
        type: 'POST',
        data: {proId: buyId}, //发送一个请求参数，参数名为proId，参数值为传入的buyId变量的值
        success: function () {
            //如果能执行到success，说明后台删除成功，这里同时将表格中对应的数据行删除
            $("#tr" + buyId).remove(); // remove是删除当前元素和其内容
        },
        error: function (req, status, error) {
            alert("Ajax请求失败，错误：" + error);
        }
    });
}



