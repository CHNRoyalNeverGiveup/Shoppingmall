package com.wbg.service;

import com.wbg.Dao.UseraddressDao;
import com.wbg.entity.Useraddress;
import com.wbg.entity.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Useraddressservice {
    static UseraddressDao useraddressDao=new UseraddressDao();

    public String insert(HttpServletRequest request,HttpServletResponse response){
        String msg="添加失败";
        Users uid=(Users)request.getSession().getAttribute("user");
        if(useraddressDao.insert(new Useraddress(
                request.getParameter("addressu"),
                uid.getUid(),
                request.getParameter("unameu"),
                request.getParameter("uphoneu")
        ))){
                msg="添加成功";
            request.getSession().setAttribute("Useraddress",useraddressDao.finAll(uid.getUid()));
        }
        return "{\"msg\":\""+msg+"\"}";
    }
    public String delete(HttpServletRequest request){
        String msg="删除失败";
        if(useraddressDao.delete(Integer.parseInt(request.getParameter("udid")))){
            Users uid=(Users)request.getSession().getAttribute("user");
            request.getSession().setAttribute("Useraddress",useraddressDao.finAll(uid.getUid()));
            msg="删除成功";
        }

        return "{\"msg\":\""+msg+"\"}";
    }
    public  String update(HttpServletRequest request){
        String msg="修改失败";
        Useraddress useraddress=new Useraddress();
        useraddress.setUdid(Integer.parseInt(request.getParameter("udid")));
        useraddress.setAddressu(request.getParameter("addressu"));
        useraddress.setUnameu(request.getParameter("unameu"));
        useraddress.setUphoneu(request.getParameter("uphoneu"));
        if(useraddressDao.update(useraddress)){
            msg="修改成功";
            Users uid=(Users)request.getSession().getAttribute("user");
            request.getSession().setAttribute("Useraddress",useraddressDao.finAll(uid.getUid()));
        }

        return "{\"msg\":\""+msg+"\"}";
    }
}
