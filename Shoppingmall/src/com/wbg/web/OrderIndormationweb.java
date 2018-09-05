package com.wbg.web;

import com.wbg.Dao.OrderIndormationDao;
import com.wbg.Util.DBUtil;
import com.wbg.entity.OrderIndormation;
import com.wbg.service.OrderIndormationservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/OrderIndormationweb")
public class OrderIndormationweb extends HttpServlet {
    OrderIndormationservice orderIndormationservice=new OrderIndormationservice();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getParameter("action")){
            case "insert":
                response.getWriter().print(orderIndormationservice.insert(request,response));
                break;
                //购物车支付
            case "zhifu":
                response.getWriter().print(orderIndormationservice.update(request,response));
                break;
                //返回ajax
            case "session":
                response.getWriter().print(orderIndormationservice.session(request));
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        switch (action){
            //重定向
            case "session":
               orderIndormationservice.session(request,response);
                break;
            //订单支付
            case "ddzhifu":
                OrderIndormation orderIndormation=new OrderIndormation();
                orderIndormation=orderIndormationservice.finById(request.getParameter("oid"));
                request.getSession().setAttribute("zhifuOrderIndormation",orderIndormation);
               response.sendRedirect("/page/zhifu.jsp");
                break;
            //管理员查询价格
            case "admindex":
                response.getWriter().print(orderIndormationservice.selectindex());
                break;
             //根据状态进行查询所有信息  当为空的时候会查询全部
            case "finall":
                String ostatus=request.getParameter("ostatus");
                if(ostatus==null)
                    ostatus="";
                response.getWriter().print(orderIndormationservice.finall(ostatus));
                break;
                //根据编号进行查询
            case "finoid":
                response.getWriter().print(orderIndormationservice.finoid(request.getParameter("oid")));
                break;
        }
    }
}
