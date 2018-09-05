package com.wbg.service;

import com.google.gson.Gson;
import com.wbg.Dao.ProductTypeDao;
import com.wbg.Util.DBUtil;
import com.wbg.Util.R;
import com.wbg.entity.ProductType;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ProductTypeservice {
     static ProductTypeDao productTypeDao=new ProductTypeDao();
     static R r=new R();
    public static String finAllGson(){
        return new Gson().toJson(productTypeDao.finAll());
    }
    public static List<ProductType> finAll(){
        return productTypeDao.finAllstatus();
    }
    public static String finjson(int page,int limit){
        r.setCount(productTypeDao.getcount());
        r.setData(productTypeDao.finAlljson(page,limit));
        return DBUtil.toJson(r);
    }
    public static String finjson(int tid){
            r.setCount(1);
            r.setData(productTypeDao.finAll(tid));
            return DBUtil.toJson(r);
    }
    public static  String updatestatus(int tid,String status){
        if(productTypeDao.updatestatus(tid,status))
            r.setMsg("修改成功");
        else r.setMsg("修改失败");
        return DBUtil.toJson(r);
    }
    public static String insert(HttpServletRequest request){
        if(productTypeDao.insert(new ProductType(0,request.getParameter("tname"),request.getParameter("tstatus"))))
            r.setMsg("添加成功");
        else r.setMsg("添加失败");
        return DBUtil.toJson(r);
    }
}
