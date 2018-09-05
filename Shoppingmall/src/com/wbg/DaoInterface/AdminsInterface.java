package com.wbg.DaoInterface;
import com.wbg.entity.Admins;
import java.util.List;
public interface AdminsInterface {
    List<Admins> finAll();
    List<Admins> finByName(String admins,boolean bool);
    Admins finById(Admins admins);
    boolean insert(Admins admins);
    boolean update(Admins admins);
    boolean delete(Admins admins);
}
