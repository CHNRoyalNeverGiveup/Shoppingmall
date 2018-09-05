package com.wbg.service;

import com.google.gson.Gson;
import com.wbg.Dao.ProductDao;
import com.wbg.Util.DBUtil;
import com.wbg.Util.R;
import com.wbg.entity.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

public class Productservice {
    static ProductDao productDao=new ProductDao();
    public static String finAllGson(){
        return new Gson().toJson(productDao.finAll());
    }

    public static String finpidjson(String tid){
        R r=new R();
        r.setCount(1);
        r.setData(productDao.finByIdlist(tid));
        return DBUtil.toJson(r);
    }
    public static String updatestatus(String tid,String pstatus){
        R r=new R();
        if(productDao.updatestatus(tid,pstatus))
            r.setMsg("修改成功");
        else
            r.setMsg("修改失败");
        return DBUtil.toJson(r);
    }
    public static String fintypejson(int tid,int page,int limit){
        R r=new R();
        r.setCount(productDao.getcount(tid));
        r.setData(productDao.finlimit(tid,page,limit));
        return DBUtil.toJson(r);
    }
    public static String finAlljson(int page,int limit){
        R r=new R();
        r.setCount(productDao.getcount());
        r.setData(productDao.finlimit(page,limit));
        return DBUtil.toJson(r);
    }
    public static String insert(HttpServletRequest request){
        R r=new R();
        if(productDao.insert(product(request)))
        r.setMsg("添加成功");
        else
         r.setMsg("添加失败");
        return DBUtil.toJson(r);
    }
    public static String delete(HttpServletRequest request){
        R r=new R();
        if(productDao.delete(new Product(request.getParameter("pid"))))
            r.setMsg("删除成功");
        else
            r.setMsg("删除失败");
        return DBUtil.toJson(r);
    }
    public static String update(HttpServletRequest request){
        R r=new R();
        if(productDao.update(product(request)))
            r.setMsg("修改成功");
        else
            r.setMsg("修改失败");
        return DBUtil.toJson(r);
    }
    public static Product product(HttpServletRequest request){
        Product product=new Product();
        product.setPid(request.getParameter("pid"));
        product.setPname(request.getParameter("pname"));
        product.setPtid(Integer.parseInt(request.getParameter("ptid")));
        product.setPimg(request.getParameter("pimg"));
        product.setPprice(new BigDecimal(request.getParameter("pprice")));
        product.setPstatus(request.getParameter("pstatus"));
        product.setPnumber(Integer.parseInt(request.getParameter("pnumber")));
        product.setDetailed(request.getParameter("detailed"));
        return product;
    }
    public static List<Product> finAll(){
        return productDao.finAll();
    }

    public static List<Product> finById(int ptid){
        return productDao.finPtid(ptid);
    }
    public static String finByName(String name){
        return new Gson().toJson(productDao.finByName(name));
    }
    public static List<Product> finName(String pname){
        return productDao.finByName(pname);
    }
    public static String finByName(HttpServletRequest request,HttpServletResponse response){
        return new Gson().toJson(productDao.finByName(request.getParameter("name")));
    }
}
