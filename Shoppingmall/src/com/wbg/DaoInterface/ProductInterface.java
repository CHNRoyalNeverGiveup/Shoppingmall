package com.wbg.DaoInterface;
import com.wbg.entity.Product;
import java.util.List;
public interface ProductInterface {
    List<Product> finAll();
    List<Product> finByName(String product);
    Product finById(String pid);
    boolean insert(Product product);
    boolean update(Product product);
    boolean delete(Product product);
}
