package com.wbg.DaoInterface;

import com.wbg.entity.Users;

import java.util.List;
public interface UsersIntface {
    List<Users> finAll();
    List<Users> finByName(String name,boolean bool);
    Users finById(Users users);
    Users insert(Users users);
    boolean update(Users users);
    boolean delete(Users users);
}
