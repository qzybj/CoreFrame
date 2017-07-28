package com.brady.corelib.module.login.util;


import com.brady.corelib.module.login.i.IAccountHelper;
import com.brady.corelib.module.login.i.IUserInfo;
import com.brady.corelib.module.login.i.impl.AccountInfo;
import com.brady.corelib.module.login.i.impl.UserInfo;
import com.brady.libutil.cache.SPUtil;


/**
 * 用户管理辅助类<br/>
 * 用户信息管理、自动登录
 * Created by Brady on 2016/4/8.
 */
public class AccountHelper implements IAccountHelper {

    private static AccountHelper instance;

    private IUserInfo userInfo = null;

    public static AccountHelper instance(){
        if(instance==null){
            instance = new AccountHelper();
        }
        return instance;
    }

    /**
     * 设为登录状态，并记下来账号密码<br/>
     * 需要把用户名和密码进行存储，下次进入软件的时候，如果有用户名和密码，则提交用户登录，能登录成功则直接跳转到首页
     * @param userInfo
     * @param account
     * @param password
     */
    public void saveUser(UserInfo userInfo, String account, String password) {
        setUser(userInfo);
        setSave(IAccountHelper.KEY_ACCOUNT, account);
        setSave(IAccountHelper.KEY_PASSWORD, password);
    }

    @Override
    public IUserInfo getUser() {
        return userInfo;
    }

    @Override
    public boolean setUser(IUserInfo iUserInfo) {
        this.userInfo = iUserInfo;
        return true;
    }

    @Override
    public int getType() {
        if (userInfo != null) {
            return userInfo.getType();
        }
        return IAccountHelper.VALUE_NONE_INT;
    }

    /**
     * 获取user token
     * @return
     */
    public String getUid() {
        if (userInfo != null) {
            return userInfo.getUid();
        }
        return IAccountHelper.VALUE_NONE;
    }

    @Override
    public void loginOut() {
        userInfo = null;
        //清除记录的账号
        setSave(IAccountHelper.KEY_ACCOUNT, IAccountHelper.VALUE_NONE);
        setSave(IAccountHelper.KEY_PASSWORD, IAccountHelper.VALUE_NONE);
    }

    @Override
    public boolean isLogin() {
        return userInfo != null;
    }

    @Override
    public IUserInfo parse(Object obj) {
        return null;
    }

    /**
     * 获取用户的账号密码
     * @return
     */
    public AccountInfo getAccount() {
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAccount(getValue(IAccountHelper.KEY_ACCOUNT));
        accountInfo.setPassword(getValue(IAccountHelper.KEY_PASSWORD));
        return accountInfo;
    }

    /**
     * 保存值的实现
     * @param key
     * @param value
     */
    private void setSave(String key,String value){
        SPUtil.instance().setString(key,value);
    }

    /**
     * 获取值的实现
     * @param key
     * @return
     */
    private String getValue(String key){
        return SPUtil.instance().getString(key);
    }
}