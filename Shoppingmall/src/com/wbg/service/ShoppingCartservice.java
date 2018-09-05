package com.wbg.service;

import com.wbg.Dao.ProductDao;
import com.wbg.Dao.ShoppingCartDao;
import com.wbg.Dao.UseraddressDao;
import com.wbg.Dao.UsersDao;
import com.wbg.entity.Product;
import com.wbg.entity.ShoppingCart;
import com.wbg.entity.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartservice {
    static ShoppingCartDao shoppingCartDao=new ShoppingCartDao();
    public static List<ShoppingCart> finAllsession(int suid) {
        return shoppingCartDao.finAll(suid);
    }
    public String delete(HttpServletRequest request, HttpServletResponse response){
        String msg="删除失败";
        if(shoppingCartDao.delete(new ShoppingCart((Integer.parseInt(request.getParameter("sid")))))){
            msg="ok";
            //购物车数量
            count(request);
            request.getSession().setAttribute("ShoppingCart",finAllsession((int)request.getSession().getAttribute("user")));
        }
        return "{\"msg\":\""+msg+"\"}";
    }
    public String insert(HttpServletRequest request, HttpServletResponse response){
        String msg="加入购物车失败";
        ProductDao productDao=new ProductDao();
        ShoppingCart shoppingCart=new ShoppingCart();
        Product product=productDao.finById(request.getParameter("spid"));
        shoppingCart.setSpid(request.getParameter("spid"));
        //获取用户ID
        Users users=(Users)request.getSession().getAttribute("user");
        shoppingCart.setSuid(users.getUid());
        shoppingCart.setShoppingcount(1);
        shoppingCart.setSmoney(product.getPprice());

        //Integer.parseInt(request.getParameter("shoppingcount"));
        if(shoppingCartDao.insert(shoppingCart)){
            msg="加入购物车成功";
        }
        //购物车数量
        count(request);
    return "{\"msg\":\""+msg+"\"}";
    }
    public String updatecount(HttpServletRequest request, HttpServletResponse response){
        ShoppingCart shoppingCart=new ShoppingCart();
        shoppingCart.setSid(Integer.parseInt(request.getParameter("sid")));
        shoppingCart.setShoppingcount(Integer.parseInt(request.getParameter("shoppingcount")));
        shoppingCart.setSmoney(new BigDecimal(request.getParameter("smoney")));
        if(shoppingCartDao.updatecount(shoppingCart)!=null){
            Users users=(Users)request.getSession().getAttribute("user");
            request.getSession().setAttribute("ShoppingCart",shoppingCartDao.finAll(users.getUid()));
            return "{\"msg\":\"ok\",\"shoppingcount\":\""+shoppingCart.getShoppingcount()+"\",\"smoney\":\""+shoppingCart.getSmoney()+"\"}";
        }
        return "{\"msg\":\"no\"}";
    }
    public  String  jiesuan(HttpServletRequest request, HttpServletResponse response){
        UseraddressDao useraddressDao=new UseraddressDao();
            String [] sid=request.getParameterValues("sid");
            sid=sid[0].split(",");
             List<ShoppingCart> list=new ArrayList<>();

        for(int i=0;i<sid.length;i++){
            list.add(shoppingCartDao.finById(Integer.parseInt(sid[i])));
        }
        //地址
        Users uid=(Users)request.getSession().getAttribute("user");
        request.getSession().setAttribute("Useraddress", useraddressDao.finAll(uid.getUid()));
        //购物商品
        request.getSession().setAttribute("Shopping",list);
        for(ShoppingCart shoppingCart:list){
            System.out.println(shoppingCart.getSmoney());
        }

        return "{\"msg\":\"ok\"}";
    }
    public static String count(HttpServletRequest request){
        Users users=(Users) request.getSession().getAttribute("user");
        return "{\"count\":\""+shoppingCartDao.fincount(users.getUid())+"\"}";
    }

}
