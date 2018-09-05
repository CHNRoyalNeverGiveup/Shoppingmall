package com.wbg.web;

import com.wbg.entity.Product;
import com.wbg.service.Productservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Productweb")
public class Productweb extends HttpServlet {
    static Productservice productservice = new Productservice();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "selename":
                request.getSession().setAttribute("product", productservice.finName(request.getParameter("pname")));
                response.getWriter().print("{\"msg\":\"ok\"}");
                break;
            //添加
            case "insert":
                response.getWriter().print(productservice.insert(request));
                break;
            case "update":
                response.getWriter().print(productservice.update(request));
                break;
            case "delete":
                response.getWriter().print(productservice.delete(request));
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "gson":
                response.getWriter().print(productservice.finAllGson());
                break;
            case "session":
                request.getSession().setAttribute("product", Productservice.finById(Integer.parseInt(request.getParameter("ptid"))));
                request.getSession().setAttribute("active", request.getParameter("ptid"));
                response.sendRedirect("jsp/main.jsp");
                break;
            case "finAlljson":
                response.getWriter().print(
                        productservice.finAlljson(
                                Integer.parseInt(request.getParameter("page")),
                                Integer.parseInt(request.getParameter("limit"))
                        ));
                //根据类型返回json
            case "fintypejson":
                response.getWriter().print(
                        productservice.fintypejson(
                                Integer.parseInt(request.getParameter("tid")),
                                Integer.parseInt(request.getParameter("page")),
                                Integer.parseInt(request.getParameter("limit"))
                        ));
                break;
                //根据pid返回json
            case "finpidjson":
                response.getWriter().print(
                        productservice.finpidjson(
                                request.getParameter("pid")
                        ));
                break;
            case "updatestatus":
                response.getWriter().print(productservice.updatestatus(request.getParameter("pid"),request.getParameter("pstatus")));
                break;

        }
    }
}
