package com.brady.corelib.module.login.i;

/**
 * Created by Clair
 *
 * @date 2017/7/27
 * @description 账号管理用
 */
public interface IAccountInfo {

    /**
     * 获取 账号
     * @return
     */
    String getAccount();

    /**
     * 设置账号
     * @param account
     */
    void setAccount(String account);

    /**
     * 获取 密码
     * @return
     */
    String getPassword();

    /**
     * 设置密码
     * @param password
     */
    void setPassword(String password);

    /**
     * 获取用户信息
     *
     * @return
     */
    IUserInfo getUser();

    /**
     * 设置用户信息
     *
     * @param iUserInfo
     * @return
     */
    void setUser(IUserInfo iUserInfo);

    /**
     * 是否自动登录
     */
    boolean isAutoLogin();

    void setAutoLogin(boolean autoLogin);

}
