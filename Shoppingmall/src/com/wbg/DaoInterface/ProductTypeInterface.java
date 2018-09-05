package com.wbg.DaoInterface;

import com.wbg.entity.ProductType;

import java.util.List;

public interface ProductTypeInterface {
    List<ProductType> finAll();
    List<ProductType> finByName(String tname);
    ProductType finById(ProductType productType);
    boolean insert(ProductType productType);
    boolean update(ProductType productType);
    boolean delete(ProductType productType);
}
