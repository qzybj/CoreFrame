package com.brady.corelib.module.login.i.impl;

import com.brady.corelib.module.login.i.IAccountInfo;
import com.brady.corelib.module.login.i.IUserInfo;


/**
 * Created by Clair
 *
 * @date 2017/7/27
 * @description 账户信息字段
 */
public class AccountInfo implements IAccountInfo {
    private String account;
    private String password;
    private IUserInfo userInfo;
    private boolean isAutoLogin;

    @Override
    public String getAccount() {
        return account;
    }

    @Override
    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public IUserInfo getUser() {
        return userInfo;
    }

    @Override
    public void setUser(IUserInfo iUserInfo) {
        this.userInfo = iUserInfo;
    }

    @Override
    public boolean isAutoLogin() {
        return isAutoLogin;
    }

    @Override
    public void setAutoLogin(boolean autoLogin) {
        this.isAutoLogin = autoLogin;
    }
}