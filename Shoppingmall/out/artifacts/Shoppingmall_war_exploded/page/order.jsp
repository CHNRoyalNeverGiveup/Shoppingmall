<%@ page import="com.wbg.entity.ShoppingCart" %>
<%@ page import="java.util.List" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="com.wbg.entity.Useraddress" %><%--
  Created by IntelliJ IDEA.
  User: 邦杠
  Date: 2018/8/30
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>确认订单</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css" />
    <link rel="stylesheet" href="../css/ext.css" />
</head>

<body>
<div class="container">
    <div class="row box" style="margin-bottom: 2rem; margin-top: 2rem;">
        <div class="col-md-10 column">
            <h1 style="color: red; margin: auto;">确认订单</h1>
        </div>
        <div class="col-md-2 column" align="right">
            <a href="<c:url value="/index"/>">返回首页</a>
        </div>
    </div>
    <!-- 地址信息-->
    <div class="row" style="margin-bottom: 2rem;">
        <div class="col-md-12 column">
            <ul class="nav navcolor nav-pills nav-stacked">
                <li class="active" style="font-size: large;">
                    <a href="#">配送地址</a>
                </li>
                <%
                    for(Useraddress useraddress: (List<Useraddress>)session.getAttribute("Useraddress")){   %>
                <li>
                    <p><input type="radio" class="address" name="address" value="<%=useraddress.getUdid()%>" checked/>&nbsp; <%=useraddress.getAddressu()%>(<%=useraddress.getUnameu()%> 收) <%=useraddress.getUphoneu()%>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" class="updatearr" data-udid="<%=useraddress.getUdid()%>" data-addressu="<%=useraddress.getAddressu()%>" data-unameu="<%=useraddress.getUnameu()%>" data-uphoneu="<%=useraddress.getUphoneu()%>">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" class="deletearr" data-id="<%=useraddress.getUdid()%>">删除</a></p>
                </li>
                <% }%>
                <li>
                    <input type="button" id="newaddr" class="btn btn-info btn-sm" value="使用新地址"/>
                </li>
            </ul>
        </div>
    </div>
    <!-- 订单信息 -->
    <div class="row" style="margin-bottom: 2rem;">
        <div class="col-md-12 column">
            <ul class="nav navcolor nav-pills nav-stacked">
                <li class="active" style="font-size: large;">
                    <a href="#">订单信息</a>
                </li>
                <li>
                    <div class="row">
                        <div class="col-md-1 column" align="left"></div>
                        <div class="col-md-3 column" align="left">商品信息</div>
                        <div class="col-md-3 column" align="left">单价</div>
                        <div class="col-md-2 column" align="left">数量</div>
                        <div class="col-md-3 column" align="left">金额</div>
                    </div>
                    <%
                        BigDecimal zj=new BigDecimal(0);
                        for(ShoppingCart shoppingCart: (List<ShoppingCart>)session.getAttribute("Shopping")){
                            zj=zj.add(new BigDecimal(shoppingCart.getSmoney().toString()));
                    %>
                        <div class="row box">
                        <div class="col-md-1 column" align="left">
                            <img alt="60x60" style="margin: 1rem;" width="60rem" height="60rem" src="https://g-search2.alicdn.com/img/bao/uploaded/i4/i1/263726286/TB2qqpCu2iSBuNkSnhJXXbDcpXa_!!263726286-0-item_pic.jpg_460x460Q90.jpg_.webp" />
                        </div>
                        <div class="col-md-3 column" align="left">
                            <p>
                                <%=shoppingCart.getPname()%>
                            </p>
                        </div>
                        <div class="col-md-3 column" align="left">
                            <p style="font-size: large;">¥ <%=shoppingCart.getPprice()%></p>
                        </div>
                        <div class="col-md-2 column" align="left">
                            <p style="font-size: large;">x  <%=shoppingCart.getShoppingcount()%></p>
                        </div>
                        <div class="col-md-3 column" align="left">
                            <p style="color: red; font-size: large;">¥ <%=shoppingCart.getSmoney()%></p>
                        </div>
                    </div>
                    <% }%>
                </li>
            </ul>
        </div>
    </div>
    <!-- 结算 -->
    <div class="row">
        <div class="col-md-12 column" align="right" style="margin-top: 1rem;">
            <p style="color: red; font-size: large; font-weight: bold;" >实付款：¥ <%=zj%></p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 column" align="right">
            <input type="button" id="suborder" class="btn btn-primary btn-lg" value="提交订单" />
        </div>
    </div>
</div>
<!-- 模式对话框 -->
<div id="addrModal"></div>
</body>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script>
    $(function(){
        //新建地址
        $("#newaddr").on("click",function(){
                $("#newAddrModal").modal('show');
        });
        //删除地址
        $(".deletearr").click(function () {
            if(confirm("是否删除?")){
                $.ajax({
                    type: "post",
                    url: "/Useraddressweb?action=delete",
                    data: {udid: event.target.dataset['id']},
                    success: function (data) {
                        console.log(data);
                        if (data.msg == "删除成功") {
                            location.reload();
                        }
                        alert(data.msg);
                    }
                })
            }
        })
        //修改地址
        $(".updatearr").click(function () {
            var tag=event.target;
            $("#add").html("修改");
            $("#add").val(tag.dataset['udid']);
            $("#unameu").val(tag.dataset['unameu']);
            $("#uphoneu").val(tag.dataset['uphoneu']);
            $("#addressu").val(tag.dataset['addressu']);
            $("#newAddrModal").modal('show');
        })
        //提交订单
        $("#suborder").on("click",function(){
            if($(".address").length==0){
                alert("请选择送货地址");
                return;
            }
            $.ajax({
                type:"post",
                url:"/OrderIndormationweb?action=insert",
                data:{address:$(".address:checked").val()},
                success:function (data) {
                   if(data.msg=="ok"){
                       window.location.href="zhifu.jsp";
                   }
                   else {
                       alert(data.msg);
                   }
                }
            })
            

            //alert("在数据生成订单记录，并更新相应的购物项关联此订单\n，并修改购物项记录的状态为已下单");
        });
        //提交地址
        $("#add").click(function () {
            if($("#unameu").val()==""){alert("收货人不能为空"); return};
            if($("#uphoneu").val()==""){alert("联系电话不能为空"); return};
            if($("#addressu").val()==""){alert("收货地址不能为空"); return};
            if( $("#add").html()!="修改"){
                $.ajax({
                    type:"post",
                    url:"/Useraddressweb?action=insert",
                    data:{
                        unameu:$("#unameu").val(),
                        uphoneu:$("#uphoneu").val(),
                        addressu:$("#addressu").val(),
                    },
                    success:function (data) {
                        if(data.msg=="添加成功"){
                            $("#newAddrModal").modal('hide');
                            location.reload();
                        }
                            alert(data.msg);

                    }
                })
            }else {
                $.ajax({
                    type:"post",
                    url:"/Useraddressweb?action=update",
                    data:{
                        udid:$("#add").val(),
                        unameu:$("#unameu").val(),
                        uphoneu:$("#uphoneu").val(),
                        addressu:$("#addressu").val(),
                    },
                    success:function (data) {
                        if(data.msg=="修改成功"){
                            $("#newAddrModal").modal('hide');
                            location.reload();
                        }
                            alert(data.msg);
                    }
                })
            }

        })

    });
</script>
<div id="newAddrModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document" style="width: 40%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h3 class="modal-title">新建地址</h3>
            </div>
            <div class="modal-body">
                <div class="row" style="margin: 1rem;">
                    <div class="col-md-12">
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <input type="text" class="form-control" id="unameu"  placeholder="收货人"/>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" id="uphoneu"  placeholder="联系电话"/>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" id="addressu"  placeholder="收货地址"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="add" value="">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

</html>