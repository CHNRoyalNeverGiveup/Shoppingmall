package com.wbg.Dao;

import com.wbg.DaoInterface.ProductTypeInterface;
import com.wbg.Util.DBUtil;
import com.wbg.entity.ProductType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductTypeDao implements ProductTypeInterface {
    /**
     * 全部查询商品类型
     * @return
     */
    @Override
    public List<ProductType> finAll() {
        String sql="select * from productType";
        ResultSet rs= DBUtil.executeQuery(sql);
        List<ProductType> list=new ArrayList<>();
        ProductType productType=null;
        try {
            while (rs.next()){
                productType=new ProductType(
                        rs.getInt("tid"),
                        rs.getString("tname"),
                        rs.getString("tstatus")
                );
                list.add(productType);
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
     * layui查询
     * @return
     */
    public List<ProductType> finAlljson(int page,int limit) {
        //开始
        //第几页-1乘每页多少条数据+1
        int start = (page - 1) * limit + 1;//公式用于获取从哪里开始
        //结束
        //第几页乘每页多少条数据
        int end = page * limit;
        String sql="select * from productType limit "+(start-1)+","+end;
        ResultSet rs= DBUtil.executeQuery(sql);
        List<ProductType> list=new ArrayList<>();
        ProductType productType=null;
        try {
            while (rs.next()){
                productType=new ProductType(
                        rs.getInt("tid"),
                        rs.getString("tname"),
                        rs.getString("tstatus")
                );
                list.add(productType);
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
    public List<ProductType> finAllstatus() {
        String sql="select * from productType where tstatus='上架'";
        ResultSet rs= DBUtil.executeQuery(sql);
        List<ProductType> list=new ArrayList<>();
        ProductType productType=null;
        try {
            while (rs.next()){
                productType=new ProductType(
                        rs.getInt("tid"),
                        rs.getString("tname"),
                        rs.getString("tstatus")
                );
                list.add(productType);
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
    public List<ProductType> finAll(int tid) {
        String sql="select * from productType where tid="+tid;
        ResultSet rs= DBUtil.executeQuery(sql);
        List<ProductType> list=new ArrayList<>();
        ProductType productType=null;
        try {
            while (rs.next()){
                productType=new ProductType(
                        rs.getInt("tid"),
                        rs.getString("tname"),
                        rs.getString("tstatus")
                );
                list.add(productType);
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
     * 根据商品类型名称查询
     * @param tname
     * @return
     */
    @Override
    public List<ProductType> finByName(String tname) {
        String sql="select * from productType where tname like '%"+tname+"%'";
        ResultSet rs= DBUtil.executeQuery(sql);
        List<ProductType> list=new ArrayList<>();
        ProductType productType=null;
        try {
            while (rs.next()){
                productType=new ProductType(
                        rs.getInt("tid"),
                        rs.getString("tname"),
                        rs.getString("tstatus")
                );
                list.add(productType);
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
     * 根据商品类型id进行查询
     * @param productType
     * @return
     */
    @Override
    public ProductType finById(ProductType productType) {
        String sql="select * from productType where tid="+productType.getTid();
        ResultSet rs= DBUtil.executeQuery(sql);
        List<ProductType> list=new ArrayList<>();
        try {
            if (rs.next()){
                return new ProductType(
                        rs.getInt("tid"),
                        rs.getString("tname"),
                        rs.getString("tstatus")
                );
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
        return null;
    }

    /**
     * 添加操作
     * @param productType
     * @return
     */
    @Override
    public boolean insert(ProductType productType) {
        String sql="select count(*) from productType where tname='"+productType.getTname()+"'";
        ResultSet rs= DBUtil.executeQuery(sql);
        List<ProductType> list=new ArrayList<>();
        try {
            if (rs.next()){
                if(rs.getInt(1)>0)
                    return false;
                else
                {
                    sql="insert into productType(tname,tstatus)values(?,?)";
                    Object[]in={productType.getTname().trim(),productType.getTstatus()};
                    if(DBUtil.executeUpdate(sql,in)>0)
                        return true;
                }
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
        return false;
    }

    /**
     * 修改操作
     * @param productType
     * @return
     */
    @Override
    public boolean update(ProductType productType) {
        String sql="update productType set tname=?,tstatus=? where tid=?";
        Object[]in={productType.getTname(),productType.getTstatus(),productType.getTid()};
        if(DBUtil.executeUpdate(sql,in)>0)
            return true;
        return false;
    }
    public boolean updatestatus(int tid,String status) {
        String sql="update productType set tstatus=? where tid=?";
        Object[]in={status,tid};
        if(DBUtil.executeUpdate(sql,in)>0)
            return true;
        return false;
    }

    /**
     * 删除操作
     * @param productType
     * @return
     */
    @Override
    public boolean delete(ProductType productType) {
        String sql="delete from productType where tid=?";
        Object[]in={productType.getTid()};
        if(DBUtil.executeUpdate(sql,in)>0)
            return true;
        return false;
    }
    /**
     * 获取行数方法,返回多少行
     * @param
     * @return
     */
    public static int getcount(){
        int count=0;
        String sql = "select count(*) from productType";
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
    public static void main(String[] args) {
        ProductTypeDao productTypeDao=new ProductTypeDao();
        ProductType s=productTypeDao.finById(new ProductType(2));
        System.out.println(s);
        s.setTstatus("上架中");
        productTypeDao.update(s);
        System.out.println(productTypeDao.finById(new ProductType(2)));
        System.out.println(productTypeDao.delete(new ProductType(2)));
    }
}
