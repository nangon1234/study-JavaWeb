package com.bo.service;

import com.bo.entity.User;
import com.bo.utils.Md5Util;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * @author nangon1234
 * @ClassName UserService
 * @Description 用户业务逻辑类
 * @Date 2019/9/27
 * @Version 1.0
 **/
public class UserService
{
    private List<User> userList;

    public void setUserList(List<User> userList)
    {
        this.userList = userList;
    }

    /**
     * @param  【account,password】
     * @return user
     * @description 用户登陆功能
     */
    public User signIn(String account, String password)
    {
        for (User user : userList)
        {
            if (user.getAccount().equals(account) && user.getPassword().equals(Md5Util.crypt(password)))
            {
                return user;
            }
        }
        return null;
    }
}
