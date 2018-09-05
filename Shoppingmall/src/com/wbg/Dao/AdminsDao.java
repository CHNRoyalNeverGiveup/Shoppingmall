package com.wbg.Dao;

import com.wbg.DaoInterface.AdminsInterface;
import com.wbg.Util.DBUtil;
import com.wbg.entity.Admins;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminsDao implements AdminsInterface {
    /**
     * 查询所有管理员
     * @return
     */
    @Override
    public List<Admins> finAll() {
        String  sql="select * from Admins";
        List<Admins> list=new ArrayList<>();
        ResultSet rs= DBUtil.executeQuery(sql);
        Admins admins=null;
        try {
            while (rs.next()){
                admins=new Admins(
                        rs.getInt("aid"),
                        rs.getString("alname"),
                        rs.getString("alpwd"),
                        rs.getString("astatus"),
                        rs.getString("aname")
                );
                list.add(admins);
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
     * 根据账号查询  是否模糊查询
     * @param aname
     * @return
     */
    @Override
    public List<Admins> finByName(String aname,boolean bool) {
        String  sql="select * from Admins where aname ='"+aname+"'";
        if(bool)
                sql="select * from Admins where aname like '%"+aname+"%'";
        List<Admins> list=new ArrayList<>();
        ResultSet rs= DBUtil.executeQuery(sql);
        Admins admins=null;
        try {
            while (rs.next()){
                admins=new Admins(
                        rs.getInt("aid"),
                        rs.getString("alname"),
                        rs.getString("alpwd"),
                        rs.getString("astatus"),
                        rs.getString("aname")
                );
                list.add(admins);
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
     * 查询数据库多少条数据
     * @return
     */
    public int count(){
        String sql="select count(*) from admins";
        ResultSet rs=DBUtil.executeQuery(sql);
        try {
            if(rs.next())
                return  rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    /**
     * 根据AID进行查询
     * @param aid
     * @return
     */
    @Override
    public Admins finById(Admins aid) {
        String  sql="select * from Admins where aid="+aid.getAid();
        ResultSet rs= DBUtil.executeQuery(sql);
        try {
           if (rs.next()){
                return new Admins(
                        rs.getInt("aid"),
                        rs.getString("alname"),
                        rs.getString("alpwd"),
                        rs.getString("astatus"),
                        rs.getString("aname")
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
    //添加
    @Override
    public boolean insert(Admins admins) {
        String sql="insert into admins(alname,alpwd,astatus,aname)values(?,?,?,?)";
        Object[]in={admins.getAlname(),admins.getAlpwd(),admins.getAstatus(),admins.getAname()};
        if(DBUtil.executeUpdate(sql,in)>0)
            return true;
        return false;
    }
    /**
     *  修改
     */
    @Override
    public boolean update(Admins admins) {
        String sql="update admins set alname=? ,alpwd=? ,astatus=? ,aname=? where aid=?";
        Object[]in={admins.getAlname(),admins.getAlpwd(),admins.getAstatus(),admins.getAname(),admins.getAid()};
        if(DBUtil.executeUpdate(sql,in)>0)
            return true;
        return false;
    }
    /**
     * 修改状态
     */
    public boolean updastatus(int uid,String status){
        String sql="update admins set astatus=? where aid=?";
        Object[] in={status,uid};
        if(DBUtil.executeUpdate(sql,in)>0)
            return true;
        return false;
    }
    /**
     * 根据状态查询
     */
    public List<Admins> finstatus(String astatus) {
        String  sql="select * from Admins where astatus='"+astatus+"'";
        List<Admins> list=new ArrayList<>();
        ResultSet rs= DBUtil.executeQuery(sql);
        Admins admins=null;
        try {
            while (rs.next()){
                admins=new Admins(
                        rs.getInt("aid"),
                        rs.getString("alname"),
                        rs.getString("alpwd"),
                        rs.getString("astatus"),
                        rs.getString("aname")
                );
                list.add(admins);
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
     * 根据Aid删除操作
     * @param admins
     * @return
     */
    @Override
    public boolean delete(Admins admins) {
        String sql="delete from admins where aid=?";
        Object[]in={admins.getAid()};
        if(DBUtil.executeUpdate(sql,in)>0)
            return true;
        return false;
    }
    public boolean pwd(Admins admins){
        String sql="select count(*) from admins where aname=? and alpwd=? and astatus='可用'";
        Object[]in={admins.getAname(),admins.getAlpwd()};
        ResultSet rs=DBUtil.executeQuery(sql,in);
        try {
            if(rs.next()){
                if(rs.getInt(1)>0)
                    return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
