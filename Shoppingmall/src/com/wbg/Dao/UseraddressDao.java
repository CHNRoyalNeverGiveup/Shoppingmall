package com.wbg.Dao;

import com.wbg.DaoInterface.UseraddressInterface;
import com.wbg.DaoInterface.UsersIntface;
import com.wbg.Util.DBUtil;
import com.wbg.entity.Useraddress;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UseraddressDao implements UseraddressInterface {
    /**
     * 查询所有地址
     * @return
     */
    @Override
    public List<Useraddress> finAll() {
        String sql="select * from useraddress";
        ResultSet rs= DBUtil.executeQuery(sql);
        List<Useraddress> list=new ArrayList<>();
        Useraddress useraddress=null;
        try {
            while (rs.next()){
                useraddress=new Useraddress(
                        rs.getInt("udid"),
                        rs.getString("addressu"),
                        rs.getInt("uidu"),
                        rs.getString("unameu"),
                        rs.getString("uphoneu")
                );
                list.add(useraddress);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    public List<Useraddress> finAll(int uidu) {
        String sql="select * from useraddress where uidu="+uidu;
        ResultSet rs= DBUtil.executeQuery(sql);
        List<Useraddress> list=new ArrayList<>();
        Useraddress useraddress=null;
        try {
            while (rs.next()){
                useraddress=new Useraddress(
                        rs.getInt("udid"),
                        rs.getString("addressu"),
                        rs.getInt("uidu"),
                        rs.getString("unameu"),
                        rs.getString("uphoneu")
                );
                list.add(useraddress);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    /**
     * 根据用户编号uidu获取地址信息
     * @param uidu
     * @return
     */
    @Override
    public List<Useraddress> finById(Integer uidu) {
        String sql="select * from useraddress where uidu="+uidu;
        ResultSet rs= DBUtil.executeQuery(sql);
        List<Useraddress> list=new ArrayList<>();
        Useraddress useraddress=null;
        try {
            while (rs.next()){
                useraddress=new Useraddress(
                        rs.getInt("udid"),
                        rs.getString("addressu"),
                        rs.getInt("uidu"),
                        rs.getString("unameu"),
                        rs.getString("uphoneu")
                );
                list.add(useraddress);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 添加操作
     * @param useraddress
     * @return
     */
    @Override
    public boolean insert(Useraddress useraddress) {
        String sql="insert into useraddress(addressu,uidu,unameu,uphoneu) values(?,?,?,?)";
        Object[]in={useraddress.getAddressu(),useraddress.getUidu(),useraddress.getUnameu(),useraddress.getUphoneu()};
        if(DBUtil.executeUpdate(sql,in)>0)
            return true;
        return false;
    }

    /**
     * 修改操作
     * @param useraddress
     * @return
     */
    @Override
    public boolean update(Useraddress useraddress) {
        String sql="update useraddress set addressu=?,unameu=?,uphoneu=? where udid=?";
        Object[]in={useraddress.getAddressu(),useraddress.getUnameu(),useraddress.getUphoneu(),useraddress.getUdid()};
        if(DBUtil.executeUpdate(sql,in)>0)
            return true;
        return false;
    }

    /**
     * 删除操作
     * @param udid
     * @return
     */
    @Override
    public boolean delete(int udid) {
        String sql="delete from useraddress where udid=?";
        Object[]in={udid};
        if(DBUtil.executeUpdate(sql,in)>0)
            return true;
        return false;
    }

}
