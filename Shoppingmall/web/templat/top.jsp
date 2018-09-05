<%@ page import="com.wbg.entity.Users" %><%--
  Created by IntelliJ IDEA.
  User: 邦杠
  Date: 2018/8/29
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row box" style="margin-top: 2rem; margin-bottom: 2rem;">
    <div class="col-md-3 column">
        <!-- 修改bootstrap中h1的margin-->
        <h1 style="color: red; margin: auto;">挖宝网</h1>
    </div>
    <div class="col-md-6 column">
        <form role="form" class="form-inline" >
            <div class="form-group">
                <input type="text" size="60" class="form-control"  id="search" placeholder="搜一下"/>
                <input type="button" class="btn btn-primary" id="sousuo" value="搜索"/>
            </div>
        </form>
    </div>
    <div class="col-md-2 column" align="right">
        <a id="wddd"href="#"  >我的订单</a>
        <a id="carthref" href="#"  ><span class="badge pull-right" id="gwccount">0</span>我的购物车</a>
    </div>
    <div class="col-md-1 column " style="text-align: center" id="dlzc" align="right">
        <a href="#" id="loginhref">登陆</a>/<a href="#" id="reghref">注册</a>
    </div>

</div>
<script>
    //登录注册
   function dlzc(){
        $.post("/Usersweb?action=hqzh",function (data) {
            if(data.msg!="no"){
                var p=$("<p/>");
                $("<a style='color: blue'/>").html(data.msg).appendTo(p);
                $("#dlzc").html(p).append($("<a href='/Usersweb?action=delete'>").html("注销"));
            }
        })
   }
    $(function () {
        dlzc();
        gwccount();
    })
    //搜索
    $("#sousuo").click(function () {
        $.post("/Productweb?action=selename",{pname:$("#search").val()},function () {
            location.reload();
        })
    })
   //购物车
    $("#carthref").click(function () {
        $.ajax({
            type:'post',
            url:'/ShoppingCartweb?action=session',
            success:function (data) {
                if (data.msg == "no") {
                    alert("请登录！");
                    $('#loginModal').modal('show');
                } else {
                    window.location.href = "/page/cart.jsp";
                }
            }
        })
    })
    //我的订单
    $("#wddd").click(function () {
        $.ajax({
            type:'post',
            url:'/OrderIndormationweb?action=session',
            success:function (data) {
                if (data.msg == "no") {
                    alert("请登录！");
                    $('#loginModal').modal('show');
                } else {
                    window.location.href = "/page/ddxx.jsp";
                }
            }
        })
    })
    //购物车的数量
    function gwccount() {
        $.post("/ShoppingCartweb?action=count",function (data) {
            $("#gwccount").html(data.count)
        })
    }
</script>



