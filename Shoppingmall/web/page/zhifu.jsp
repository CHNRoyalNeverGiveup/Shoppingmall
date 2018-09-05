<%@ page import="com.wbg.entity.OrderIndormation" %><%--
  Created by IntelliJ IDEA.
  User: 邦杠
  Date: 2018/8/31
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css" />
    <link rel="stylesheet" href="../css/ext.css"/>
</head>
<body>
<div class="container">
    <div class="row box" style="margin-bottom: 2rem; margin-top: 2rem;">
        <div class="col-md-10 column">
            <h1 style="color: red; margin: auto;">支付中心</h1>
        </div>
        <div class="col-md-2 column" align="right">
            <a href="/index">返回首页</a>
        </div>
    </div>
</div>
<%
    OrderIndormation orderIndormation= (OrderIndormation) session.getAttribute("zhifuOrderIndormation");
%>
<div class="row well well-sm box">
    <div class="col-md-4 column" style="text-align: center" align="left">
        <p style="font-size: 20px;"><%=orderIndormation.getOtime()%></p>
    </div>
    <div class="col-md-4 column" align="center">
        <p style="font-size: 20px;">订单号:<%=orderIndormation.getOid()%></p>
    </div>
    <div class="col-md-4 column" align="left">
        <p style="color: red; font-size: 20px">¥ <%=orderIndormation.getOmoney()%></p>
    </div>
</div>
<div class="modal-body">
    <div class="row" style="margin: 1rem;">
        <div class="col-md-12">
            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <!--<label for="password" style="font-size: large;">密 码</label>-->
                    <input type="password" class="form-control" id="password" placeholder="密 码"/>
                    <button type="button" style="width: 100%;margin-top: 5%;" id="zhifuok"class="btn btn-primary">确认支付</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/operation.js"></script>
<script>
    $("#zhifuok").click(function () {
        $.ajax({
            type:"post",
            url:"/OrderIndormationweb?action=zhifu",
            success:function (data) {
                if(data.msg=="ok"){
                    alert("支付成功");
                    window.location.href="/OrderIndormationweb?action=session"
                }
                else {
                    alert("支付失败");
                }
            }
        })
    })
</script>
</body>

</html>

