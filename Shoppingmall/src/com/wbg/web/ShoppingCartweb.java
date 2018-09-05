package com.wbg.web;

import com.wbg.entity.Users;
import com.wbg.service.ShoppingCartservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ShoppingCartweb")
public class ShoppingCartweb extends HttpServlet {
    static ShoppingCartservice shoppingCartservice=new ShoppingCartservice();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        //判断用户是否登录过
        Users user=(Users)request.getSession().getAttribute("user");
        if(user==null){
            response.getWriter().print("{\"msg\":\"no\"}");
            return;
        }
        switch (action){
            case "insert":
                response.getWriter().print(shoppingCartservice.insert(request, response));
                break;
            case "jiesuan":
                response.getWriter().print(shoppingCartservice.jiesuan(request,response));
                break;
            case "delete":
                response.getWriter().print(shoppingCartservice.delete(request,response));
                break;
            case "updatecount":
                response.getWriter().print(shoppingCartservice.updatecount(request,response));
                break;
            case "session":
                user=(Users)request.getSession().getAttribute("user");
                request.getSession().setAttribute("ShoppingCart",shoppingCartservice.finAllsession(user.getUid()));
                response.getWriter().print("{\"msg\":\"ok\"}");
                break;
            case "count":
                response.getWriter().print(shoppingCartservice.count(request));
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        switch (action){
            case "session":
                Users  user=(Users)request.getSession().getAttribute("user");
                request.getSession().setAttribute("ShoppingCart",shoppingCartservice.finAllsession(user.getUid()));
                break;
        }

    }
}
