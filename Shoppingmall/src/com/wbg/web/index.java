package com.wbg.web;

import com.wbg.service.ProductTypeservice;
import com.wbg.service.Productservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class index extends HttpServlet {
    ProductTypeservice productTypeservice=new ProductTypeservice();
    Productservice productservice=new Productservice();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("productType",productTypeservice.finAll());
        request.getSession().setAttribute("product",Productservice.finById(1));
        request.getSession().setAttribute("active",1);
        response.sendRedirect("jsp/main.jsp");
    }
}
