package com.wbg.Dao;

import com.wbg.DaoInterface.UsersIntface;
import com.wbg.Util.DBUtil;
import com.wbg.entity.Useraddress;
import com.wbg.entity.Users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDao implements UsersIntface {
    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<Users> finAll() {
        String  sql="select * from Users";
        List<Users> list=new ArrayList<>();
        ResultSet rs= DBUtil.executeQuery(sql);
        Users users=null;
        try {
            while (rs.next()){
                users=new Users(
                        rs.getInt("uid"),
                        rs.getString("uLName"),
                        rs.getString("uLPwd"),
                        rs.getString("uEmail"),
                        rs.getString("uName"),
                        rs.getString("uTel"),
                        rs.getString("ustatus")
                );
                list.add(users);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    public int count(){
        String sql="select count(*) from Users";
        ResultSet rs=DBUtil.executeQuery(sql);
        try {
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }
    /**
     * 模糊查询姓名操作判断是否模糊查询
     * @param uName
     * @return
     */
    @Override
    public List<Users> finByName(String uName,boolean bool) {
        String  sql="select * from Users where uName='"+uName+"'";
        if(bool)
                sql="select * from Users where uName like '%"+uName+"%'";
        List<Users> list=new ArrayList<>();
        ResultSet rs= DBUtil.executeQuery(sql);
        Users users=null;
        try {
            while (rs.next()){
                users=new Users(
                        rs.getInt("uid"),
                        rs.getString("uLName"),
                        rs.getString("uLPwd"),
                        rs.getString("uEmail"),
                        rs.getString("uName"),
                        rs.getString("uTel"),
                        rs.getString("ustatus")
                );
                list.add(users);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public List<Users> finstatus(String status) {
        String  sql="select * from Users where ustatus='"+status+"'";
        List<Users> list=new ArrayList<>();
        ResultSet rs= DBUtil.executeQuery(sql);
        Users users=null;
        try {
            while (rs.next()){
                users=new Users(
                        rs.getInt("uid"),
                        rs.getString("uLName"),
                        rs.getString("uLPwd"),
                        rs.getString("uEmail"),
                        rs.getString("uName"),
                        rs.getString("uTel"),
                        rs.getString("ustatus")
                );
                list.add(users);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 修改用户状态
     */
    public boolean updastatus(int uid,String ustatus){
        String sql="update Users set ustatus=? where uid=?";
        Object[]in={ustatus,uid};
        if(DBUtil.executeUpdate(sql,in)>0)
            return true;
        return false;
    }
    /**
     * 根据uid进行查询
     * @param users
     * @return
     */
    @Override
    public Users finById(Users users) {
        String  sql="select * from Users where uid ="+users.getUid();
                ResultSet rs= DBUtil.executeQuery(sql);
                try {
                    if (rs.next()){
                        return new Users(
                                rs.getInt("uid"),
                                rs.getString("uLName"),
                                rs.getString("uLPwd"),
                                rs.getString("uEmail"),
                                rs.getString("uName"),
                                rs.getString("uTel"),
                                rs.getString("ustatus")
                        );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 添加操作
     * @param users
     * @return
     */
    @Override
    public Users insert(Users users) {
        String sql="select count(*) from Users where uLName=? ";
        Object[]in={users.getuLName()};
        ResultSet rs= DBUtil.executeQuery(sql,in);
        try {
            if (rs.next()) {
                if(rs.getInt(1)>0)
                    return null;
            }
            }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(!rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        sql="insert into Users(uLName,uLPwd,uEmail,uName,uTel,ustatus)values(?,?,?,?,?,'可用')";
        Object[]ins={users.getuLName(),users.getuLPwd(),users.getuEmail(),users.getuName(),users.getuTel()};
        if(DBUtil.executeUpdate(sql,ins)>0)
            return  password(users);
        else{
            return null;
        }
    }

    /**
     * 进行账号密码核对
     * @param users
     * @return
     */
    public Users password(Users users){
        String sql="select * from users where uLName=? and uLPwd=? or uTel=? and uLPwd=? ";
        Object[]in={users.getuLName(),users.getuLPwd(),users.getuTel(),users.getuLPwd()};
        ResultSet rs=DBUtil.executeQuery(sql,in);
        try {
            if (rs.next()) {
                return new Users(
                        rs.getInt("uid"),
                        rs.getString("uLName"),
                        rs.getString("uLPwd"),
                        rs.getString("uEmail"),
                        rs.getString("uName"),
                        rs.getString("uTel"),
                        rs.getString("ustatus")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 进行修改操作
     * @param users
     * @return
     */
    @Override
    public boolean update(Users users) {
        String sql="update Users set uLName=?,uLPwd=?,uEmail=?,uName=?,uTel=?,ustatus=? where uid=?";
        Object[]in={users.getuLName(),users.getuLPwd(),users.getuEmail(),users.getuName(),users.getuTel(),users.getUstatus(),users.getUid()};
        if(DBUtil.executeUpdate(sql,in)>0)
            return true;
        return false;
    }

    /**
     * 删除操作
     * @param users
     * @return
     */
    @Override
    public boolean delete(Users users) {
        String sql="delete from Users where uid=?";
        Object[]in={users.getUid()};
        if(DBUtil.executeUpdate(sql,in)>0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        UsersDao usersDao=new UsersDao();
        Users users=usersDao.finById(new Users(2));
        users.setuLName("456");
        usersDao.update(users);
        System.out.println(usersDao.delete(new Users(2)));
        System.out.println(usersDao.finAll());
    }
}
