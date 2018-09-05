package com.wbg.web;

import com.wbg.entity.ProductType;
import com.wbg.service.ProductTypeservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ProductTypeweb")
public class ProductTypeweb extends HttpServlet {
    static ProductTypeservice productTypeservice=new ProductTypeservice();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        switch (action) {
            case "insert":
                response.getWriter().print(productTypeservice.insert(request));
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        switch (action){
            case "gson":
                response.getWriter().print(productTypeservice.finAllGson());
                break;
            case "json":
                response.getWriter().print(productTypeservice.finAllGson());
                break;
            case "layuijson":
                response.getWriter().print(productTypeservice.finjson(Integer.parseInt(request.getParameter("page")),Integer.parseInt(request.getParameter("limit"))));
                break;
            case "layuitid":
                response.getWriter().print(productTypeservice.finjson(Integer.parseInt(request.getParameter("tid"))));
                break;
            case "updatestatus":
                response.getWriter().print(productTypeservice.updatestatus(Integer.parseInt(request.getParameter("tid")),request.getParameter("status")));
                break;
        }

    }
}
