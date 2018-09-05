<%@ page import="java.util.List" %>
<%@ page import="com.wbg.entity.ShoppingCart" %><%--
  Created by IntelliJ IDEA.
  User: 邦杠
  Date: 2018/8/29
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <link rel="stylesheet" href=<c:url value="/css/bootstrap.min.css" />>
    <link rel="stylesheet" href=<c:url value="/css/ext.css"/>>
</head>
<body>
<div class="container">
    <div class="row box" style="margin-bottom: 2rem; margin-top: 2rem;">
        <div class="col-md-10 column">
            <h1 style="color: red; margin: auto;">我的购物车</h1>
        </div>
        <div class="col-md-2 column" align="right">
            <a href="<c:url value="/index"/>">返回首页</a>
        </div>
    </div>
    <div class="row well well-sm">
        <div class="col-md-2 column" align="left">
            <input type="checkbox" class="checkedAll"/>&nbsp;全选
        </div>
        <div class="col-md-3 column" align="left">商品信息</div>
        <div class="col-md-2 column" align="left">单价</div>
        <div class="col-md-2 column" align="left">数量</div>
        <div class="col-md-2 column" align="left">金额</div>
        <div class="col-md-1 column" align="left">操作</div>
    </div>
    <!-- 购物车列表 -->
    <%
        if(session.getAttribute("ShoppingCart")!=null){
        List<ShoppingCart> list= (List<ShoppingCart>) session.getAttribute("ShoppingCart");
        for(ShoppingCart shoppingCart:list){ %>
    <div class="row well well-sm box">
        <div class="col-md-2 column" align="left">
            <input type="checkbox" class="check" value="<%=shoppingCart.getSid()%>" />
            <img alt="120x120" width="120rem" height="120rem" src="https://g-search2.alicdn.com/img/bao/uploaded/i4/i1/263726286/TB2qqpCu2iSBuNkSnhJXXbDcpXa_!!263726286-0-item_pic.jpg_460x460Q90.jpg_.webp" />
        </div>
        <div class="col-md-3 column" align="left">
            <p>
                <%=shoppingCart.getPname()%>
            </p>
        </div>
        <div class="col-md-2 column" align="left">
            <p style="font-size: large;">¥ <%=shoppingCart.getPprice()%></p>
        </div>
        <div class="col-md-2 column" align="left">
            <p><input type="number" style="width:40%" class="buyNum" data-id="<%=shoppingCart.getSid()%>" data-price="<%=shoppingCart.getPprice()%>" value="<%=shoppingCart.getShoppingcount()%>"/>&nbsp;<span style="font-size:10px">库存<%=shoppingCart.getPnumber()%></span></p>
        </div>
        <div class="col-md-2 column" align="left">
            <p style="color: red; font-size: large;">¥ <span id="zj<%=shoppingCart.getSid()%>"><%=shoppingCart.getSmoney()%></span></p>
        </div>
        <div class="col-md-1 column" align="left">
            <input type="button" class="btn btn-danger delete"  data-id="<%=shoppingCart.getSid()%>" name="del" value="删除"/>
        </div>
    </div>
    <%}
    }%>

    <!-- 结算 -->
    <div class="row well well-sm" >
        <div class="col-md-12 column" align="right" style="margin-top: 1rem;">
            <p style="color: red; font-size: large; font-weight: bold;">合计：¥ <span id="hj">0</span></p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 column" align="right">
            <input type="button" class="btn btn-primary btn-lg " id="jiesuan" value="结算" />
        </div>
    </div>
</div>
<%@include file="../templat/js.jsp"%>
<script>
    //全选
    $(".checkedAll").click(function () {
        $(".box input").prop("checked",$(this).prop("checked"));
        zongjiage();
    })
    //结算
    $("#jiesuan").click(function () {
        var checked=$(".box input:checked")
        var sid=[];
        if(checked.length==0){ alert("请选择商品!"); return; }
            checked.each(function() {sid.push($(this).val())});
        $.post("/ShoppingCartweb?action=jiesuan",{sid:sid.join(",")},function () {
            window.location.href="/page/order.jsp";
        })
    })
    //删除按钮
    $(".delete").click(function () {
        if(confirm("真的删除吗?")){
            $.post("/ShoppingCartweb?action=delete",{sid:event.target.dataset['id']},function (data) {
                if(data.msg=="ok"){
                    alert("删除成功")
                    location.reload();
                } else
                alert("删除失败")
            })
        }
    })
    //修改个数
    $(".buyNum").change(function () {
        var sid=event.target.dataset['id'];
        if($(this).val()<1){
            $(this).val(1);
            return;
        }
        if($(this).val()>100){
            $(this).val(100);
            return;
        }
        $.post("/ShoppingCartweb?action=updatecount",{shoppingcount:$(this).val(),smoney:accMul(event.target.dataset['price'],$(this).val()),sid:sid},function (data) {
            if(data.msg=="no"){
                alert("出错");
                location.reload();
            }
            location.reload();
        })
    })
    //总价
    $(".check").change(function () {
        zongjiage();
    })
    function zongjiage() {
        var sum=0;
        $.each($(".check:checked"),function (index,obj) {
            sum= accAdd(sum,$("#zj"+$(this).val()).html())
        })
            $("#hj").html(sum);
    }

</script>
</body>
</html>

