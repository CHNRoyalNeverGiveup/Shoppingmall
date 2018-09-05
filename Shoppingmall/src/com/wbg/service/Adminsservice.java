package com.wbg.service;

import com.wbg.Dao.AdminsDao;
import com.wbg.Util.DBUtil;
import com.wbg.Util.R;
import com.wbg.entity.Admins;

import javax.servlet.http.HttpServletRequest;

public class Adminsservice {
    static  AdminsDao adminsDao=new AdminsDao();
   static R r=new R();
   //进行密码验证
    public static String pwd(HttpServletRequest request){
        Admins admin=new Admins();
        admin.setAname(request.getParameter("aname"));
        admin.setAlpwd(request.getParameter("apwd"));
        if(adminsDao.pwd(admin)){
            r.setMsg("ok");
            request.getSession().setAttribute("admins",admin);
        }
        else
            r.setMsg("no");
        return DBUtil.toJson(r);
    }
    //查询全部数据
    public  String finall(){
        r.setCount(adminsDao.count());
        r.setData(adminsDao.finAll());
        return DBUtil.toJson(r);
    }
    //根据账号查询
    public static String finname(String name,boolean bool){
        r.setData(adminsDao.finByName(name,bool));
        return DBUtil.toJson(r);
    }
    //根据状态查询
    public static String finstatus(String status){
        r.setData(adminsDao.finstatus(status));
        return DBUtil.toJson(r);
    }
    //修改状态
    public static String updastatus(int uid,String status){
        if(adminsDao.updastatus(uid,status))
            r.setMsg("修改成功");
        else r.setMsg("修改失败");
        return DBUtil.toJson(r);
    }

}
