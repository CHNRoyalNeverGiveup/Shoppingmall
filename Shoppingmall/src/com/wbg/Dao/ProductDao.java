package com.wbg.Dao;
import com.wbg.DaoInterface.ProductInterface;
import com.wbg.Util.DBUtil;
import com.wbg.entity.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ProductDao implements ProductInterface {
    /****
     * 查询所有商品
     * @return List<Product>
     */
    @Override
    public List<Product> finAll() {
        String sql="select * from product";
        ResultSet rs= DBUtil.executeQuery(sql);
        List<Product> list=new ArrayList<>();
        Product product=null;
        try {
            while (rs.next()){
                    product=new Product(
                            rs.getString("pid"),
                            rs.getString("pname"),
                            rs.getInt("ptid"),
                            rs.getString("pimg"),
                            rs.getBigDecimal("pprice"),
                            rs.getString("pstatus"),
                            rs.getInt("pnumber"),
                            rs.getString("detailed")

                    );
                    list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    public List<Product> finAllstatus() {
        String sql="select * from product where pstatus='上架中'";
        ResultSet rs= DBUtil.executeQuery(sql);
        List<Product> list=new ArrayList<>();
        Product product=null;
        try {
            while (rs.next()){
                product=new Product(
                        rs.getString("pid"),
                        rs.getString("pname"),
                        rs.getInt("ptid"),
                        rs.getString("pimg"),
                        rs.getBigDecimal("pprice"),
                        rs.getString("pstatus"),
                        rs.getInt("pnumber"),
                        rs.getString("detailed")

                );
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    /**
     * 获取行数方法,返回多少行
     * @param
     * @return
     */
    public static int getcount(int ptid){
        int count=0;
        String sql = "select count(*) from product where ptid="+ptid;
        ResultSet rs = DBUtil.executeQuery(sql);
        try {
            while(rs.next()) {
                count=rs.getInt(1);
            }
            DBUtil.close(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    /**
     * 获取行数方法,返回多少行
     * @param
     * @return
     */
    public static int getcount(){
        int count=0;
        String sql = "select count(*) from product";
        ResultSet rs = DBUtil.executeQuery(sql);
        try {
            while(rs.next()) {
                count=rs.getInt(1);
            }
            DBUtil.close(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    /**
     * 分页查询,类型
     */
    public static List<Product> finlimit(int tid,int page,int limit) {
        //开始
        //第几页-1乘每页多少条数据+1
        int start = (page - 1) * limit + 1;//公式用于获取从哪里开始
        //结束
        //第几页乘每页多少条数据
        int end = page * limit;
        String sql="select * from product,producttype where ptid=tid and tid="+tid+" limit "+(start-1)+","+end;
        ResultSet rs= DBUtil.executeQuery(sql);
        List<Product> list=new ArrayList<>();
        Product product=null;
        try {
            while (rs.next()){
                product=new Product(
                        rs.getString("pid"),
                        rs.getString("pname"),
                        rs.getInt("ptid"),
                        rs.getString("pimg"),
                        rs.getBigDecimal("pprice"),
                        rs.getString("pstatus"),
                        rs.getInt("pnumber"),
                        rs.getString("detailed"),
                        rs.getString("tname")
                );
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    /**
     * 分页查询
     */
    public static List<Product> finlimit(int page,int limit) {
        //开始
        //第几页-1乘每页多少条数据+1
        int start = (page - 1) * limit + 1;//公式用于获取从哪里开始
        //结束
        //第几页乘每页多少条数据
        int end = page * limit;
        String sql="select * from product,producttype where ptid=tid limit "+(start-1)+","+end;
        ResultSet rs= DBUtil.executeQuery(sql);
        List<Product> list=new ArrayList<>();
        Product product=null;
        try {
            while (rs.next()){
                product=new Product(
                        rs.getString("pid"),
                        rs.getString("pname"),
                        rs.getInt("ptid"),
                        rs.getString("pimg"),
                        rs.getBigDecimal("pprice"),
                        rs.getString("pstatus"),
                        rs.getInt("pnumber"),
                        rs.getString("detailed"),
                        rs.getString("tname")
                );
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    /**
     * 根据商品名称模糊查询
     * @param pname
     * @return
     */
    @Override
    public List<Product> finByName(String pname) {
        String sql="select * from product where pname like '%"+pname+"%'";
        ResultSet rs= DBUtil.executeQuery(sql);
        List<Product> list=new ArrayList<>();
        Product product=null;
        try {
            while (rs.next()){
                product=new Product(
                        rs.getString("pid"),
                        rs.getString("pname"),
                        rs.getInt("ptid"),
                        rs.getString("pimg"),
                        rs.getBigDecimal("pprice"),
                        rs.getString("pstatus"),
                        rs.getInt("pnumber"),
                        rs.getString("detailed")
                );
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 根据编号查询商品
     * @param pid
     * @return
     */
    @Override
    public Product finById(String pid) {
        String sql="select * from product where pid=?";
        Object [] in={pid};
        ResultSet rs= DBUtil.executeQuery(sql,in);
        try {
            if (rs.next()){
                return new Product(
                        rs.getString("pid"),
                        rs.getString("pname"),
                        rs.getInt("ptid"),
                        rs.getString("pimg"),
                        rs.getBigDecimal("pprice"),
                        rs.getString("pstatus"),
                        rs.getInt("pnumber"),
                        rs.getString("detailed")
                );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    /** 根据编号查询商品
     * @param pid
     * @return
             */
    public List<Product> finByIdlist(String pid) {
        String sql="select * from product where pid=?";
        Object [] in={pid};
        ResultSet rs= DBUtil.executeQuery(sql,in);
        List<Product> list=new ArrayList<>();
        Product product=null;
        try {
            while (rs.next()){
                product=new Product(
                        rs.getString("pid"),
                        rs.getString("pname"),
                        rs.getInt("ptid"),
                        rs.getString("pimg"),
                        rs.getBigDecimal("pprice"),
                        rs.getString("pstatus"),
                        rs.getInt("pnumber"),
                        rs.getString("detailed")
                );
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 查询类型
     * @param ptid
     * @return
     */
    public List<Product> finPtid(int ptid) {
        String sql="select * from product where pstatus='上架中'and ptid="+ptid;
        ResultSet rs= DBUtil.executeQuery(sql);
        List<Product> list=new ArrayList<>();
        Product product=null;
        try {
            while (rs.next()){
                product=new Product(
                        rs.getString("pid"),
                        rs.getString("pname"),
                        rs.getInt("ptid"),
                        rs.getString("pimg"),
                        rs.getBigDecimal("pprice"),
                        rs.getString("pstatus"),
                        rs.getInt("pnumber"),
                        rs.getString("detailed")
                );
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    /**
     * 添加商品操作
     * @param product
     * @return
     */
    @Override
    public boolean insert(Product product) {
        String sql="insert into Product(pid,pname,ptid,pimg,pprice,pstatus,pnumber,detailed)values(?,?,?,?,?,?,?,?)";
        Object[] in={product.getPid(),product.getPname(),product.getPtid(),product.getPimg(),product.getPprice(),product.getPstatus(),product.getPnumber(),product.getDetailed()};
        if(DBUtil.executeUpdate(sql,in)>0)
            return true;
            return false;
    }

    /**
     * 修改操作
     * @param product
     * @return
     */
    @Override
    public boolean update(Product product) {
        String sql="update Product set pname=?,ptid=?,pimg=?,pprice=?,pstatus=?,pnumber=?,detailed=? where pid=?";
        Object[] in={product.getPname(),product.getPtid(),product.getPimg(),product.getPprice(),product.getPstatus(),product.getPnumber(),product.getDetailed(),product.getPid()};
        if(DBUtil.executeUpdate(sql,in)>0)
            return true;
        return false;
    }
    public boolean updatestatus(String pid,String pstatus) {
        String sql="update Product set pstatus=? where pid=?";
        Object[] in={pstatus,pid};
        if(DBUtil.executeUpdate(sql,in)>0)
            return true;
        return false;
    }
    /**
     * 删除商品
     * @param product
     * @return
     */
    @Override
    public boolean delete(Product product) {
        String sql="delete from Product where pid=?";
        Object[] in={product.getPid()};
        if(DBUtil.executeUpdate(sql,in)>0)
            return true;
        return false;
    }
}
