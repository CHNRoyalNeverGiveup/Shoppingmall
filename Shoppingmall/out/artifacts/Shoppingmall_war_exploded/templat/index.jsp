<%@ page import="com.wbg.entity.ProductType" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 邦杠
  Date: 2018/8/29
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title><sitemesh:title></sitemesh:title></title>
    <!--样式-->
     <%@include file="css.jsp"%>
    <!--脚本-->
    <%@include file="js.jsp"%>
</head>
<body>
    <!--body-->
    <div class="container">
        <!--头部-->
        <%@include file="top.jsp"%>
        <!-- 商品列表 -->
        <div class="row">
            <!--左边-->
            <div class="col-md-2 column">
                <%@include file="left.jsp"%>
            </div>
            <!--右边-->
            <div class="col-md-10 column">
                <sitemesh:body></sitemesh:body>
            </div>
        </div>
        <!-- 模态框 -->
        <div id="modal1">
            <div id="loginModal" class="modal fade" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document" style="width: 30%;">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h3 class="modal-title">用户登陆</h3>
                        </div>
                        <div class="modal-body">
                            <div class="row" style="margin: 1rem;">
                                <div class="col-md-12">
                                    <form class="form-horizontal" role="form">
                                        <div class="form-group">
                                            <!--<label for="account" style="font-size: large;">账 号</label>-->
                                            <input type="text" class="form-control" id="uLName"  placeholder="账号/手机/邮箱"/>
                                        </div>
                                        <div class="form-group">
                                            <!--<label for="password" style="font-size: large;">密 码</label>-->
                                            <input type="password" class="form-control" id="uLPwd" placeholder="密 码"/>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="button" id="login" class="btn btn-primary">登陆</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
        </div>
        <div id="modal2">
            <div id="regModal" class="modal fade" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document" style="width: 30%;">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h3 class="modal-title">用户注册</h3>
                        </div>
                        <div class="modal-body">
                            <div class="row" style="margin: 1rem;">
                                <div class="col-md-12">
                                    <form class="form-horizontal" role="form">
                                        <div class="form-group">
                                            <input type="text" class="form-control" id="account" placeholder="账号"/>
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control" id="password" placeholder="密码"/>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" id="uName" name="uName" placeholder="姓名"/>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" id="uTel" name="uTel" maxlength="11" placeholder="手机号码"/>
                                        </div>
                                        <div class="form-group">
                                            <input type="email" class="form-control" id="email" placeholder="邮箱"/>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="button" id="zhuche" class="btn btn-primary">注册</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
        </div>
      </div>
    <script>
        $(function(){
            $("#loginhref").click(function () {
                    $('#loginModal').modal('show');
                    $("#uLName").val("");
                    $("#uLPwd").val("");
            });
            $("#reghref").on("click",function(){
                $('#regModal').modal('show');
                $("#password").val("");
                $("#uName").val("");
                $("#uTel").val("");
                $("#email").val("");
            });
            $("#login").click(function () {
                if($("#uLName").val()==""){ alert("账号不能为空"); return ;  }
                if($("#uLPwd").val()==""){alert("密码不能为空"); return;}
                $.ajax({
                    type:"post",
                    url:"/Usersweb?action=password",
                    data:{
                        uLName:$("#uLName").val(),
                        uLPwd:$("#uLPwd").val()
                    },
                    success:function (data) {
                        if(data.msg=="ok"){
                           alert("登录成功");
                            $('#loginModal').modal('hide');
                            gwccount();
                            dlzc();
                        }
                        else {
                            alert(data.msg);
                        }
                    }
                })
            });
            $("#zhuche").click(function () {
                if($("#account").val()==""){ alert("账号不能为空");  return ; }
                if($("#password").val()==""){ alert("密码不能为空");  return ; }
                if($("#uName").val()==""){ alert("姓名不能为空");  return ; }
                $.ajax({
                    type:"post",
                    url:"/Usersweb?action=insert",
                    data:{
                        //账号
                        uLName:$("#account").val(),
                       //姓名
                        uName:$("#uName").val(),
                        //面貌
                        uLPwd:$("#password").val(),
                        //手机号码
                        uTel:$("#uTel").val(),
                        //qq邮件
                        uEmail:$("#email").val()
                    },
                    success:function (data) {
                        if(data.msg=="注册成功")
                        {
                            $('#regModal').modal('hide');
                            gwccount();
                            dlzc();
                        }
                        alert(data.msg);
                    }
                })
            });
        })
    function cgdl(name) {
            $("#dlzc").html(name);
    }

    </script>

</body>

</html>
