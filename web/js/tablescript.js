
var currentProductId;

function findAll() {

    $.ajax({
        url: 'userinfo/findAll',
        type: "POST",
        success: function (list) {

            $("#dataTable tr.datarow").remove();

            $.each(list, function (index, p) {
                //console.log(p);
                var str = "<tr id=tr" + p.uid + " class=\"datarow\">" +
                        "<td>" + p.uid + "</td>" +
                        "<td>" + p.uname + "</td>" +
                        "<td>" + p.ugender + "</td>" +
                        "<td>" + p.ucontact + "</td>" +
                        "<td>" +
                        "<a href=\"javascript:popupEdit('" + p.uid + "');\">编辑</a>&nbsp;&nbsp;" +
                        "<a href=\"javascript:delete_userinfo('" + p.uid + "');\">删除</a>" +
                        "</td></tr>";

                $("#dataTable").append(str);
            });
        },
        error: function (req, status, error) {
            alert("Ajax请求失败！" + error);
        }
    });
}


function popupEdit(uid) {

    currentProductId = uid;
    $.ajax({
        url: 'userinfo/get_userinfo_to_edit',
        type: 'POST',
        data: {userInfoid: uid}, //发送一个请求参数，参数名为proId，参数值为传入的pid变量的值
        success: function (pro) {
            $("#inputId").val(pro.uid);
            $("#inputName").val(pro.uname);
            $("#inputPrice").val(pro.ugender);
            $("#inputUnit").val(pro.ucontact);

            $('#editModal').modal('show');
        },
        error: function (req, status, error) {
            alert("Ajax请求失败，错误：" + error);
        }
    });
}

function popupAdd() {
    $('#addModal').modal('show');
    $("#addForm")[0].reset();
}

//定义一个函数,根据编号删除产品
function delete_userinfo(uid) {
    $.ajax({
        url: 'userinfo/delete',
        type: 'POST',
        data: {userInfoid: uid}, //发送一个请求参数，参数名为proId，参数值为传入的pid变量的值
        success: function () {
            //如果能执行到success，说明后台删除成功，这里同时将表格中对应的数据行删除
            $("#tr" + uid).remove(); // remove是删除当前元素和其内容
        },
        error: function (req, status, error) {
            alert("Ajax请求失败，错误：" + error);
        }
    });
}

$(document).ready(function () {

    $("#btnEdit").click(function () {
        $.ajax({
            url: 'userinfo/edit_userinfo',
            type: 'POST',
            data: $("#editForm").serialize(),
            success: function () {
//                $("#tr" + currentProductId).children().eq(1).html($("#inputId").val());
                $("#tr" + currentProductId).children().eq(1).html($("#inputName").val());
                $("#tr" + currentProductId).children().eq(2).html($("#inputPrice").val());
                $("#tr" + currentProductId).children().eq(3).html($("#inputUnit").val());

                $('#editModal').modal('hide');
            },
            error: function (req, status, error) {
                alert("Ajax请求失败，错误：" + error);
            }
        });
    });

    $("#btnAdd").click(function () {
        $.ajax({
            url: 'userinfo/add_userinfo',
            type: 'POST',
            data: $("#addForm").serialize(),

            success: function () {
                var p = {
                    uid: $("#proId").val(),
                    uname: $("#proName").val(),
                    ugender: $("#proPrice").val(),
                    ucontact: $("#proUnit").val()

                };

                var str = "<tr id=tr" + p.uid + " class=\"datarow\">" +
                        "<td>" + p.uid + "</td>" +
                        "<td>" + p.uname + "</td>" +
                        "<td>" + p.ugender + "</td>" +
                        "<td>" + p.ucontact + "</td>" +
                        "<td>" +
                       "<a href=\"javascript:popupEdit('" + p.uid + "');\">编辑</a>&nbsp;&nbsp;" +
                        "<a href=\"javascript:delete_userinfo('" + p.uid + "');\">删除</a>" +
                        "</td></tr>";

                $("#dataTable").append(str);

                $("#addModal").modal("hide");
            },
            error: function (req, status, error) {
                alert("Ajax请求失败，错误：" + error);
            }
        });
    });
});
