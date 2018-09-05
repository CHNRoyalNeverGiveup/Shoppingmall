package com.wbg.DaoInterface;
import com.wbg.entity.ShoppingCart;
import java.util.List;
public interface ShoppingCartInterface {
    /**
     * 根据用户查询购物车所有的信息
     * @param suid
     * @return
     */
    List<ShoppingCart> finAll(int suid);
    boolean insert(ShoppingCart shoppingCart);
    /**
     * 修改购物车的数量以及总价
     * @param shoppingCart
     * @return
     */
    ShoppingCart updatecount(ShoppingCart shoppingCart);
    /**
     * 修改购物车的状态和订单号
     * @param shoppingCart
     * @return
     */
    boolean updatesstatus(ShoppingCart shoppingCart);

    boolean delete(ShoppingCart shoppingCart);
}
