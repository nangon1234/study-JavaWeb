package com.bo.entity;

import java.time.LocalDate;

/**
 * @Author nangon1234
 * @ClassName User
 * @Description TODO
 * @Date 2019/10/1
 * @Version 1.0
 **/
public class User
{
    private Integer id;           //标识号
    private String account;       //账号
    private String password;      //密码
    private String nickname;      //昵称
    private String avatar;        //头像
    private String address;        //地址
    private LocalDate joinDate;   //加入时间
    public User(Integer id, String account, String password, String nickname, String avatar,String  address,LocalDate joinDate)
    {
        this.id = id;
        this.account = account;
        this.password = password;
        this.nickname = nickname;
        this.avatar = avatar;
        this.address =  address;
        this.joinDate = joinDate;
    }

    public String getAccount() { return account; }

    public Integer getId() { return id; }

    public String getPassword() { return password; }

    public String getAddress() { return address; }

    public LocalDate getJoinDate() { return joinDate; }

    public String getNickname() { return nickname; }

    public String getAvatar() { return avatar; }


    public void setId(Integer id) { this.id = id; }

    public void setAccount(String account) { this.account = account; }

    public void setPassword(String password) { this.password = password; }

    public void setNickname(String nickname) { this.nickname = nickname; }

    public void setAvatar(String avatar) { this.avatar = avatar; }

    public void setAddress(String address) { this.address = address; }

    public void setJoinDate(LocalDate joinDate) { this.joinDate = joinDate; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", address='" + address + '\'' +
                ", joinDate=" + joinDate +
                '}';
    }
}

