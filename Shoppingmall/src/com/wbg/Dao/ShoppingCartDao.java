package com.wbg.Dao;

import com.wbg.DaoInterface.ShoppingCartInterface;
import com.wbg.Util.DBUtil;
import com.wbg.entity.ShoppingCart;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDao implements ShoppingCartInterface {
    /**
     * 根据用户编号进行查询所有的购物车信息
     * @param suid
     * @return
     */
    @Override
    public List<ShoppingCart> finAll(int suid) {
        String sql="select sid,spid,suid,sstatus,shoppingcount,smoney,pname,pimg,pnumber,pprice from shoppingCart , product where shoppingCart.spid=product.pid and sstatus='否' and suid="+suid;
        ResultSet rs=DBUtil.executeQuery(sql);
        List<ShoppingCart> list=new ArrayList<>();
        ShoppingCart shoppingCart=null;
        try {
            while (rs.next()){
                shoppingCart=new ShoppingCart(
                        rs.getInt("sid"),
                        rs.getString("spid"),
                        rs.getInt("suid"),
                        rs.getString("sstatus"),
                        rs.getInt("shoppingcount"),
                        rs.getBigDecimal("smoney"),
                        rs.getString("pname"),
                        rs.getString("pimg"),
                        rs.getInt("pnumber"),
                        rs.getBigDecimal("pprice")
                );
                list.add(shoppingCart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
               if(rs!=null)
                 rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    public ShoppingCart finById(int sid) {
        String sql="select sid,spid,suid,sstatus,shoppingcount,smoney,pname,pnumber,pimg,pprice from shoppingCart , product where shoppingCart.spid=product.pid and sid="+sid;
        ResultSet rs=DBUtil.executeQuery(sql);
        ShoppingCart shoppingCart=null;
        try {
            while (rs.next()){
                shoppingCart=new  ShoppingCart(
                        rs.getInt("sid"),
                        rs.getString("spid"),
                        rs.getInt("suid"),
                        rs.getString("sstatus"),
                        rs.getInt("shoppingcount"),
                        rs.getBigDecimal("smoney"),
                        rs.getString("pname"),
                       rs.getString("pimg"),
                       rs.getInt("pnumber"),
                       rs.getBigDecimal("pprice")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return shoppingCart;
    }


    /**
     * 查询购物车数量
     * @param suid
     * @return
     */
    public static int fincount(int suid){
        int count=0;
        String sql="select count(*) count from shoppingcart where suid="+suid+" and sstatus='否'";
        ResultSet rs= DBUtil.executeQuery(sql);
        try {
            if(rs.next()){
                count=rs.getInt(1);
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
        return count;
    }
    public static int shoppingcount(ShoppingCart shoppingCart){
        String sql="select shoppingcount from shoppingCart where spid=? and suid=? and sstatus='否'";
        Object[]ins={shoppingCart.getSpid(),shoppingCart.getSuid()};
        ResultSet rs=DBUtil.executeQuery(sql,ins);
        int shoppingcount=0;
        try {
            if(rs.next()){
                shoppingcount=rs.getInt("shoppingcount");
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
        return shoppingcount;
    }
    /**
     * 添加购物信息
     * @param shoppingCart
     * @return
     */
    @Override
    public boolean insert(ShoppingCart shoppingCart) {
        String sql="select shoppingcount,smoney from shoppingCart where spid='"+shoppingCart.getSpid()+"' and suid="+shoppingCart.getSuid()+" and sstatus='否'";
        ResultSet rs=DBUtil.executeQuery(sql);
        int shoppingcount=0;
        BigDecimal smoney=null;
        try {
            if(rs.next()){
                shoppingcount=rs.getInt("shoppingcount");
                smoney=rs.getBigDecimal("smoney");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null)
                rs.close();
                if(shoppingcount>0){
                    sql="update shoppingCart set shoppingcount=?,smoney=? where spid=? and suid=? and sstatus='否'";
                    Object[]in={(shoppingCart.getShoppingcount()+shoppingcount),shoppingCart.getSmoney().add(smoney),shoppingCart.getSpid(),shoppingCart.getSuid()};
                    if(DBUtil.executeUpdate(sql,in)>0)
                        return true;
                }else{
                    sql="insert into shoppingCart(spid,suid,sstatus,shoppingcount,smoney)values(?,?,'否',?,?)";
                    Object[]in={shoppingCart.getSpid(),shoppingCart.getSuid(),shoppingCart.getShoppingcount()+shoppingcount,shoppingCart.getSmoney()};
                    if(DBUtil.executeUpdate(sql,in)>0)
                        return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
    /**
     * 修改购物车的数量和价格
     * @param shoppingCart
     * @return
     */
    @Override
    public ShoppingCart updatecount(ShoppingCart shoppingCart) {
        String sql="update shoppingCart set shoppingcount=?,smoney=? where sid=?";
        Object[]in={shoppingCart.getShoppingcount(),shoppingCart.getSmoney(),shoppingCart.getSid()};
        if(DBUtil.executeUpdate(sql,in)>0)
            return shoppingCart;
        return null;
    }
    /**
     * 修改购物车的状态和订单号
     * @param shoppingCart
     * @return
     */
    @Override
    public boolean updatesstatus(ShoppingCart shoppingCart) {
        String sql="update shoppingCart set sstatus=?,shoppingcount=? where sid=?";
        Object[]in={shoppingCart.getSstatus(),shoppingCart.getShoppingcount(),shoppingCart.getSid()};
        if(DBUtil.executeUpdate(sql,in)>0)
            return true;
        return false;
    }

    /**
     * 删除购物信息
     * @param shoppingCart
     * @return
     */
    @Override
    public boolean delete(ShoppingCart shoppingCart) {
        String sql="delete from shoppingCart where sid=?";
        Object[]in={shoppingCart.getSid()};
        if(DBUtil.executeUpdate(sql,in)>0)
            return true;
        return false;
    }
}
