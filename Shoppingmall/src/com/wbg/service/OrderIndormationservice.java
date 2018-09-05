package com.wbg.service;

import com.wbg.Dao.OrderIndormationDao;
import com.wbg.Util.DBUtil;
import com.wbg.Util.R;
import com.wbg.entity.OrderIndormation;
import com.wbg.entity.ShoppingCart;
import com.wbg.entity.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class OrderIndormationservice {
    static OrderIndormationDao orderIndormationDao=new OrderIndormationDao();
    static R r=new R();
    //生成订单
    public String insert(HttpServletRequest request,HttpServletResponse response){
        String msg="操作失败";
        BigDecimal zj=new BigDecimal(0);
        List<ShoppingCart> list=(List<ShoppingCart>)request.getSession().getAttribute("Shopping");
        int[] sid=new int [list.size()] ;
        String[] spid=new String [list.size()] ;
        int[] count=new int[list.size()];
        for(int i=0;i<list.size();i++){
            zj=zj.add(new BigDecimal(list.get(i).getSmoney().toString()));
            sid[i]=list.get(i).getSid();
            spid[i]=list.get(i).getSpid();
            count[i]=list.get(i).getShoppingcount();
        }
        Users users=(Users) request.getSession().getAttribute("user");
        OrderIndormation orderIndormation=new OrderIndormation();
        orderIndormation.setAddress(Integer.parseInt(request.getParameter("address")));
        orderIndormation.setOmoney(zj);
        orderIndormation.setOuid(users.getUid());
        //地址id 价格 uid 商品pid 商品数量
        OrderIndormation order=orderIndormationDao.insert(orderIndormation,sid,spid,count);
        if(order!=null){
            request.getSession().setAttribute("zhifuOrderIndormation",order);
            msg="ok";
        }
        return "{\"msg\":\""+msg+"\"}";
    }
    //查询价格
    public static String selectindex(){
        R r=new R();
        r.setData(orderIndormationDao.selectIndex());
        return DBUtil.toJson(r);
    }
    public static OrderIndormation finById(String oid){
        return orderIndormationDao.finById(oid);
    }
    //支付后进入订单
    public static void session(HttpServletRequest request,HttpServletResponse response){
        //用户id
        Users user=(Users)request.getSession().getAttribute("user");
        request.getSession().setAttribute("OrderIndormation",orderIndormationDao.finselestatus(user.getUid(),""));

        try {
            response.sendRedirect("/page/ddxx.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //我的订单
    public static String session(HttpServletRequest request){
        //用户id
        String msg="ok";
        Users user=(Users)request.getSession().getAttribute("user");
        if(user!=null)
        request.getSession().setAttribute("OrderIndormation",orderIndormationDao.finselestatus(user.getUid(),""));
        else {
           msg="no";
        }
        return "{\"msg\":\""+msg+"\"}";
    }
    //修改付款
    public static String update(HttpServletRequest request,HttpServletResponse response){
       String msg="no";
        OrderIndormation orderIndormation= (OrderIndormation) request.getSession().getAttribute("zhifuOrderIndormation");
        orderIndormation.setOstatus("已付款");
        if(orderIndormationDao.updates(orderIndormation)){
            msg="ok";
        }
        return "{\"msg\":\""+msg+"\"}";
    }
    //根据状态进行查询所有订单数据
    public static String finall(String ostatus){
            r.setData(orderIndormationDao.finstatusAll(ostatus));
        return DBUtil.toJson(r);
    }
    //根据订单编号查询
    public static String finoid(String oid){
        r.setData(orderIndormationDao.finoid(oid));
        return DBUtil.toJson(r);
    }
    public static void main(String[] args) {
        System.out.println(orderIndormationDao.finstatusAll(""));
    }
}
