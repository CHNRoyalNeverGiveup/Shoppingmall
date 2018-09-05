package com.wbg.service;

import com.wbg.Dao.UsersDao;
import com.wbg.Util.DBUtil;
import com.wbg.Util.R;
import com.wbg.entity.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Usersservice {
    static UsersDao usersDao=new UsersDao();
    static R r=new R();
    public static void insert(HttpServletRequest request, HttpServletResponse response){
           //账号
           String uLName= request.getParameter("uLName");
           //姓名
           String uName= request.getParameter("uName");
           //密码
           String uLPwd= request.getParameter("uLPwd");
             //手机号码
           String uTel= request.getParameter("uTel");
             //qq邮件
           String uEmail= request.getParameter("uEmail");
                 Users users= new Users();
                 users.setuLName(uLName);
                 users.setuLPwd(uLPwd);
                users.setuEmail(uEmail);
                 users.setuName(uName);
                 users.setuTel(uTel);
             users=usersDao.insert(users);
             String msg="注册失败";
            if(users!=null){
                request.getSession().setAttribute("user",users);
                msg="注册成功";
            }
        try {
            response.getWriter().print("{\"msg\":\""+msg+"\"}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void password(HttpServletRequest request, HttpServletResponse response){
        String req=null;
        //账号
        String uLName= request.getParameter("uLName");
        //密码
        String uLPwd= request.getParameter("uLPwd");
        Users users=new Users();
        users.setuLName(uLName);
        users.setuLPwd(uLPwd);
        users=  usersDao.password(users);
        if(users!=null){
            req="ok";
            request.getSession().setAttribute("user",users);
        }else{
            req="账号密码不一致!";
        }
        try {
            response.getWriter().print("{\"msg\":\""+req+"\"}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String finall(){
        r.setCount(usersDao.count());
        r.setData(usersDao.finAll());
        return DBUtil.toJson(r);
    }
    public static String finname(String name,boolean bool){
        r.setData(usersDao.finByName(name,bool));
        return DBUtil.toJson(r);
    }
    //根据状态查询
    public static String finstatus(String status){
        r.setData(usersDao.finstatus(status));
        return DBUtil.toJson(r);
    }
    public static String updastatus(int uid,String status){
        if(usersDao.updastatus(uid,status))
            r.setMsg("修改成功");
        else r.setMsg("修改失败");
        return DBUtil.toJson(r);
    }

    public static void main(String[] args) {
        System.out.println(finall());
    }
}
