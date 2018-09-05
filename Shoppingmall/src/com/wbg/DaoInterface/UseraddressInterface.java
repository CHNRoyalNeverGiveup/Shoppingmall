package com.wbg.DaoInterface;
import com.wbg.entity.Useraddress;
import java.util.List;
public interface UseraddressInterface {
    List<Useraddress> finAll();
    List<Useraddress> finById(Integer uidu);
    boolean insert(Useraddress useraddress);
    boolean update(Useraddress useraddress);
    boolean delete(int udid);
}
