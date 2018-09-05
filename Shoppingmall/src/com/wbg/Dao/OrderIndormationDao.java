package com.wbg.Dao;

import com.wbg.DaoInterface.OrderIndormationInterface;
import com.wbg.Util.DBUtil;
import com.wbg.Util.R;
import com.wbg.entity.Index;
import com.wbg.entity.OrderIndormation;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class OrderIndormationDao implements OrderIndormationInterface {

    /**
     * 根据用户编号查询订单信息
     *
     * @param ouid
     * @return
     */
    @Override
    public List<OrderIndormation> finAll(int ouid) {
        String sql = "select * from OrderIndormation where ouid=" + ouid;
        ResultSet rs = DBUtil.executeQuery(sql);
        List<OrderIndormation> list = new ArrayList<>();
        OrderIndormation orderIndormation = null;
        try {
            while (rs.next()) {
                orderIndormation = new OrderIndormation(
                        rs.getString("oid"),
                        rs.getInt("ouid"),
                        rs.getDate("otime"),
                        rs.getDate("osuretime"),
                        rs.getBigDecimal("omoney"),
                        rs.getString("ostatus"),
                        rs.getInt("address")
                );
                list.add(orderIndormation);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 根据用户编号和状态查询订单信息
     *
     * @param ouid
     * @param ostatus
     * @return
     */
    @Override
    public List<OrderIndormation> finselestatus(int ouid, String ostatus) {
        String sql = "select * from OrderIndormation o left join shoppingcart s on o.oid=s.sorder left join product  p on s.spid=p.pid left join useraddress u on  o.address=u.udid left join users e on e.uid=o.ouid where ouid=" + ouid + " and ostatus like '%" + ostatus + "%'";
        ResultSet rs = DBUtil.executeQuery(sql);
        List<OrderIndormation> list = new ArrayList<>();
        OrderIndormation orderIndormation = null;
        try {
            while (rs.next()) {
                orderIndormation = new OrderIndormation(
                        rs.getBigDecimal("smoney"),
                        rs.getString("addressu"),
                        rs.getString("unameu"),
                        rs.getString("uphoneu"),
                        rs.getString("oid"),
                        rs.getInt("ouid"),
                        rs.getDate("otime"),
                        rs.getDate("osuretime"),
                        rs.getBigDecimal("omoney"),
                        rs.getString("ostatus"),
                        rs.getInt("address"),
                        rs.getInt("sid"),
                        rs.getString("spid"),
                        rs.getInt("suid"),
                        rs.getString("sstatus"),
                        rs.getInt("shoppingcount"),
                        rs.getString("pid"),
                        rs.getString("pname"),
                        rs.getInt("ptid"),
                        rs.getString("pimg"),
                        rs.getBigDecimal("pprice"),
                        rs.getString("pstatus"),
                        rs.getInt("pnumber"),
                        rs.getString("detailed")
                );
                list.add(orderIndormation);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 根据状态进行查询
     * @param ostatus
     * @return
     */
    public List<OrderIndormation> finstatusAll(String ostatus) {
        String sql = "select * from OrderIndormation o left join shoppingcart s on o.oid=s.sorder left join product  p on s.spid=p.pid left join useraddress u on  o.address=u.udid left join users e on e.uid=o.ouid where  ostatus like '%" + ostatus + "%'";
        ResultSet rs = DBUtil.executeQuery(sql);
        List<OrderIndormation> list = new ArrayList<>();
        OrderIndormation orderIndormation = null;
        try {
            while (rs.next()) {
                orderIndormation = new OrderIndormation(
                        rs.getBigDecimal("smoney"),
                        rs.getString("addressu"),
                        rs.getString("unameu"),
                        rs.getString("uphoneu"),
                        rs.getString("oid"),
                        rs.getInt("ouid"),
                        rs.getDate("otime"),
                        rs.getDate("osuretime"),
                        rs.getBigDecimal("omoney"),
                        rs.getString("ostatus"),
                        rs.getInt("address"),
                        rs.getInt("sid"),
                        rs.getString("spid"),
                        rs.getInt("suid"),
                        rs.getString("sstatus"),
                        rs.getInt("shoppingcount"),
                        rs.getString("pid"),
                        rs.getString("pname"),
                        rs.getInt("ptid"),
                        rs.getString("pimg"),
                        rs.getBigDecimal("pprice"),
                        rs.getString("pstatus"),
                        rs.getInt("pnumber"),
                        rs.getString("detailed")
                );
                list.add(orderIndormation);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    /**
     * 根据状态进行查询
     * @param oid
     * @return
     */
    public List<OrderIndormation> finoid(String oid) {
        String sql = "select * from OrderIndormation o left join shoppingcart s on o.oid=s.sorder left join product  p on s.spid=p.pid left join useraddress u on  o.address=u.udid left join users e on e.uid=o.ouid  where  oid='"+oid+"'";
        ResultSet rs = DBUtil.executeQuery(sql);
        List<OrderIndormation> list = new ArrayList<>();
        OrderIndormation orderIndormation = null;
        try {
            while (rs.next()) {
                orderIndormation = new OrderIndormation(
                        rs.getBigDecimal("smoney"),
                        rs.getString("addressu"),
                        rs.getString("unameu"),
                        rs.getString("uphoneu"),
                        rs.getString("oid"),
                        rs.getInt("ouid"),
                        rs.getDate("otime"),
                        rs.getDate("osuretime"),
                        rs.getBigDecimal("omoney"),
                        rs.getString("ostatus"),
                        rs.getInt("address"),
                        rs.getInt("sid"),
                        rs.getString("spid"),
                        rs.getInt("suid"),
                        rs.getString("sstatus"),
                        rs.getInt("shoppingcount"),
                        rs.getString("pid"),
                        rs.getString("pname"),
                        rs.getInt("ptid"),
                        rs.getString("pimg"),
                        rs.getBigDecimal("pprice"),
                        rs.getString("pstatus"),
                        rs.getInt("pnumber"),
                        rs.getString("detailed")
                );
                list.add(orderIndormation);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    /**
     * 根据oid查询订单信息
     *
     * @param oid
     * @return
     */
    public OrderIndormation finById(String oid) {
        OrderIndormation orderIndormation = null;
        String sql = "select * from OrderIndormation where oid='" + oid + "'";
        ResultSet rs = DBUtil.executeQuery(sql);
        try {
            if (rs.next()) {
                orderIndormation = new OrderIndormation(
                        rs.getString("oid"),
                        rs.getInt("ouid"),
                        rs.getDate("otime"),
                        rs.getDate("osuretime"),
                        rs.getBigDecimal("omoney"),
                        rs.getString("ostatus"),
                        rs.getInt("address")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orderIndormation;
    }

    /**
     * 添加订单信息
     * ouid、omoney、address
     * 用户编号(外键)、总价、地址(外键)
     *
     * @param orderIndormation
     * @return
     */
    @Override
    public OrderIndormation insert(OrderIndormation orderIndormation, int[] sid, String[] spid, int[] count) {
        String oid = String.valueOf(orderIndormation.getOuid() + System.currentTimeMillis());
        String sql = "insert into OrderIndormation(oid,ouid,omoney,ostatus,address)values(?,?,?,'未付款',?)";
        Object[] in = {oid, orderIndormation.getOuid(), orderIndormation.getOmoney(), orderIndormation.getAddress()};
        if (DBUtil.executeUpdate(sql, in) > 0) {
            int sum = 0;
            for (int i = 0; i < sid.length; i++) {
                //修改购物车状态
                sql = "update shoppingCart set sstatus=? ,sorder=? where  sid=" + sid[i];
                Object[] ins = {"是", oid};
                if (DBUtil.executeUpdate(sql, ins) > 0) {
                    //修改商品数量
                    sql = "update product set  pnumber=(pnumber-" + count[i] + ")  where pid='" + spid[i] + "'";
                    System.out.println(sql);
                    if (DBUtil.executeUpdate(sql) > 0) {
                        sum++;
                    }
                } else {
                    OrderIndormationDao orderIndormationDao = new OrderIndormationDao();
                    orderIndormationDao.delete(oid);
                }
            }
            if (sum == sid.length) {
                return finById(oid);
            }
        }
        return null;
    }

    /**
     * 付款后，修改付款时间osuretime和状态
     *
     * @param orderIndormation
     * @return
     */
    @Override
    public boolean updates(OrderIndormation orderIndormation) {
        String sql = "update OrderIndormation  set osuretime=now(),ostatus=? where oid=?";
        Object[] in = {orderIndormation.getOstatus(), orderIndormation.getOid()};
        if (DBUtil.executeUpdate(sql, in) > 0) {
            return true;
        }
        return false;
    }

    /**
     * 根据oid删除订单商品
     *
     * @param oid
     * @return
     */
    @Override
    public boolean delete(String oid) {
        String sql = "delete from OrderIndormation where oid='" + oid + "'";
        if (DBUtil.executeUpdate(sql) > 0) {
            return true;
        }
        return false;
    }

     /**
     * 今天总价
     * @return
     */
    public static double jtzj() {
        String sql = "select sum(omoney) from OrderIndormation where date_format(otime,'%Y-%m-%d') = date_format(now(),'%Y-%m-%d') and ostatus='已付款'";
        ResultSet rs = DBUtil.executeQuery(sql);
        try {
            if (rs.next()) {
                return rs.getFloat(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
    /**
     * 昨天总价
     * @return
     */
    public static double ztzj() {
        String sql = "select sum(omoney) from OrderIndormation where date_format(otime,'%Y-%m-%d') = date_format(adddate(now(),-1),'%Y-%m-%d') and ostatus='已付款'";

        ResultSet rs = DBUtil.executeQuery(sql);
        try {
            if (rs.next()) {
                return rs.getFloat(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
    /**
     * 查询今天订单量 jtddl
     * @param
     */
    public static int jtddl(){
        int count=0;
        String sql = "select count(*) from OrderIndormation where date_format(otime,'%Y-%m-%d') = curdate() ";
        ResultSet rs = DBUtil.executeQuery(sql);
        try {
            if (rs.next()) {
                count=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }
    /**
     * 今天付款量
     * @return
     */
    public static int jtfkl(){
        int count=0;
        String sql = " select count(*) from OrderIndormation where date_format(otime,'%Y-%m-%d') = curdate() and ostatus='已付款'";
        ResultSet rs = DBUtil.executeQuery(sql);
        try {
            if (rs.next()) {
                count=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }
    /**
     * 今天未付款量
     */
    public static int jtwfkl(){
        int count=0;
        String sql = " select count(*) from OrderIndormation where date_format(otime,'%Y-%m-%d') = curdate() and ostatus='未付款'";
        ResultSet rs = DBUtil.executeQuery(sql);
        try {
            if (rs.next()) {
                count=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }
    /**
     * 查询昨天订单量
     * @param
     */
    public static int ztddl(){
        int count=0;
        String sql = " select count(*) from OrderIndormation where date_format(otime,'%Y-%m-%d') = date_format(adddate(now(),-1),'%Y-%m-%d') ";
        ResultSet rs = DBUtil.executeQuery(sql);
        try {
            if (rs.next()) {
                count=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }
    /**
     * 查询昨天付款量
     * @param
     */
    public static int ztfkl(){
        int count=0;
        String sql = " select count(*) from OrderIndormation where date_format(otime,'%Y-%m-%d') = date_format(adddate(now(),-1),'%Y-%m-%d') and ostatus='已付款'";
        ResultSet rs = DBUtil.executeQuery(sql);
        try {
            if (rs.next()) {
                count=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }
    public static int ztwfkl(){
        int count=0;
        String sql = " select count(*) from OrderIndormation where date_format(otime,'%Y-%m-%d') = date_format(adddate(now(),-1),'%Y-%m-%d') and ostatus='未付款'";
        ResultSet rs = DBUtil.executeQuery(sql);
        try {
            if (rs.next()) {
                count=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }
    public static Index selectIndex(){
        Index index=new Index();
        //---------------------今天
             //今天订单量
            index.setJtddl(jtddl());
            //今天付款量
            index.setJtfkl(jtfkl());
            //今天未付款量
            index.setJtwfkl(jtwfkl());
            //今天收入总价
            if(index.getJtfkl()>0)
                index.setJtzj(jtzj());
            else index.setJtzj(0);
            //----------------------昨天
            //昨天订单量
            index.setZtddl(ztddl());
            //昨天付款量
            index.setZtfkl(ztfkl());
            //昨天未付款量
            index.setZtwfkl(ztwfkl());
            //昨天收入总价
            if(index.getZtfkl()>0)
                index.setZtzj(ztzj());
            else index.setZtzj(0);
        return index;
    }

}
