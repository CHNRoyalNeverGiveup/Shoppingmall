package com.wbg.DaoInterface;
import com.wbg.entity.OrderIndormation;
import java.util.List;
public interface OrderIndormationInterface {
    List<OrderIndormation> finAll(int ouid);
    List<OrderIndormation> finselestatus(int ouid,String ostatus);
    OrderIndormation insert(OrderIndormation orderIndormation ,int[] sid,String[]spid,int [] count);
    boolean updates(OrderIndormation orderIndormation);
    boolean delete(String oid);
}
