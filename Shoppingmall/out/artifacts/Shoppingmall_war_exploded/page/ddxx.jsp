<%@ page import="com.wbg.entity.OrderIndormation" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 邦杠
  Date: 2018/8/30
  Time: 12:00
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
            <h1 style="color: red; margin: auto;">订单中心</h1>
        </div>
        <div class="col-md-2 column" align="right">
            <a href="/index">返回首页</a>
        </div>
    </div>
    <div class="row well well-sm">
        <div class="col-md-2 column" style="text-align: center" align="left">
        </div>
        <div class="col-md-3 column" align="center">订单详情</div>
        <div class="col-md-2 column" align="center"></div>
        <div class="col-md-1 column" align="center">收货人</div>
        <div class="col-md-2 column" align="center">订单总金额</div>
        <div class="col-md-2 column" align="center">操作</div>
    </div>
    <!-- 购物车列表 -->
    <% for(OrderIndormation orderIndormation : (List<OrderIndormation>)session.getAttribute("OrderIndormation")){ %>
    <div class="row well well-sm box">
        <div class="col-md-2 column" style="text-align: center" align="left">
            <p style="font-size: 12px;"><%=orderIndormation.getOtime()%></p>
            <img alt="80x80" width="60rem" height="50rem" src="https://g-search2.alicdn.com/img/bao/uploaded/i4/i1/263726286/TB2qqpCu2iSBuNkSnhJXXbDcpXa_!!263726286-0-item_pic.jpg_460x460Q90.jpg_.webp" />
        </div>
        <div class="col-md-3 column" align="left">
            <p>
               <%=orderIndormation.getPname()%>
            </p>

        </div>
        <div class="col-md-2 column" align="center">
            <p style="font-size: 12px;margin-top: -20px">订单号</p>
            <p style="font-size: 12px;"><%=orderIndormation.getOid()%></p>
        </div>
        <div class="col-md-1 column" align="center">
            <p style="font-size: 12px;"><%=orderIndormation.getUnameu()%></p>
        </div>
        <div class="col-md-2 column" align="center">
            <p style="color: red; font-size: 13px">¥ <%=orderIndormation.getOmoney()%></p>
        </div>
        <div class="col-md-2 column" align="center">
            <%
                if(orderIndormation.getOstatus().equals("未付款")){  %>
            <a style="font-size: 15px;" href="/OrderIndormationweb?action=ddzhifu&&oid=<%=orderIndormation.getOid()%>"><%=orderIndormation.getOstatus()%></a>
            <% }else{ %>
            <p style="font-size: 15px;color: #337ab7"><%=orderIndormation.getOstatus()%></p>
            <% }%>


        </div>
    </div>
    <% } %>
</div>
</div>
</body>
<script src="../js/operation.js"></script>
</html>

