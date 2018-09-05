package com.wbg.web;

import com.wbg.service.Useraddressservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Useraddressweb")
public class Useraddressweb extends HttpServlet {
    Useraddressservice useraddressservice=new Useraddressservice();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        switch (action){
            case "insert":
                response.getWriter().print(useraddressservice.insert(request,response));
                break;
            case "delete":
            response.getWriter().print(useraddressservice.delete(request));
            break;
            case "update":
                response.getWriter().print(useraddressservice.update(request));
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
