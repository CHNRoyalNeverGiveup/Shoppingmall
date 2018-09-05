<%@ page import="java.util.List" %>
<%@ page import="com.wbg.entity.ProductType" %>
<%@ page import="com.wbg.entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: 邦杠
  Date: 2018/8/29
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Product> list= (List<Product>) session.getAttribute("product");
        for(Product product:list){%>
<div class="col-md-4">
    <div class="thumbnail">
        <img alt="300x300" src="/<%=product.getPimg()%>"/>
        <div class="caption">
            <h3 style="color: red; font-weight: bold;">¥ <%=product.getPprice()%></h3>
            <p>
                <%if(product.getPname().length()>30){%>
                <%=product.getPname().substring(0,30)+"...."%>
                <%}
                else{%>
                <%=product.getPname()+"...."%>
                <% } %>
            </p>
            <p style="text-align:right">
                <a class="btn btn-primary addcart" data-id="<%=product.getPid()%>">加入购物车</a>
            </p>
        </div>
    </div>
</div>
<%}%>
<script>
    document.querySelector("#active<%=session.getAttribute("active")%>").classList.add("active");
    $(".addcart").click(function () {
        $.ajax({
            type:'post',
            url:'/ShoppingCartweb?action=insert',
            data:{spid:event.target.dataset['id']},
            success:function (data) {
                if(data.msg=="no"){
                    alert("请登录！！！");
                    $('#loginModal').modal('show');
                }else{
                    gwccount();
                    alert("加入成功");
                }
            }
        })
    })

</script>


