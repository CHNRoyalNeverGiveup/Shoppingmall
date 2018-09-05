package com.wbg.web;

import com.wbg.entity.Users;
import com.wbg.service.Usersservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Usersweb")
public class Usersweb extends HttpServlet {
    Usersservice usersservice=new Usersservice();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        switch (action){
            case "insert":
                usersservice.insert(request,response);
                break;
            case "password":
                usersservice.password(request,response);
                break;
            case "hqzh":
                //判断用户是否登录过
                Users user=(Users)request.getSession().getAttribute("user");
                if(user==null){
                    response.getWriter().print("{\"msg\":\"no\"}");
                    return;
                }
                response.getWriter().print("{\"msg\":\""+user.getuLName()+"\"}");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        switch (action){
            //退出登录
            case "delete":
               request.getSession().setAttribute("user",null);
               response.sendRedirect("/index");
                break;
             //查询所有用户
            case "finAll":
                 response.getWriter().print(usersservice.finall());
                return;
            case "updastatus":
                response.getWriter().print(usersservice.updastatus(Integer.parseInt(request.getParameter("uid")),request.getParameter("status")));
                return;
            case "finname":
                //直接获取uname   然后判断转过来是否为true
                response.getWriter().print(usersservice.finname(request.getParameter("uname"),request.getParameter("mhcx").equals("true")));
                return;
            case "status":
                response.getWriter().print(usersservice.finstatus(request.getParameter("pstatus")));
                return;

        }
    }
}
