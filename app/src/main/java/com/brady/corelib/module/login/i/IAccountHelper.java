package com.brady.corelib.module.login.i;

/**
 * Created by Brady on 2016/5/3.
 * User manager util class:includes user info manage(save,get)
 */
public interface IAccountHelper {

     /**KEY - 存储 - 用户信息*/
     String KEY_USER_MANAGER = "key_user_manager";
     /**KEY - 存储 - 用户账号*/
     String KEY_ACCOUNT = "account";
     /**KEY - 存储 - 用户密码*/
     String KEY_PASSWORD = "password";


     /**返值 - 错误默认值*/
     int VALUE_NONE_INT = -1;
     /**返值 - 错误默认值*/
     String VALUE_NONE = "";

     /**
      * 获取用户信息
      * @return
      */
     IUserInfo getUser();

     /**
      * 设置用户信息
      * @param iUserInfo
      * @return
      */
     boolean setUser(IUserInfo iUserInfo);

     /**
      * 获取用户类型
      * @return
      */
     int getType();

     /**
      * 获取用户唯一ID
      *
      * @return
      */
     String getUid();

     /**
      * 当前是否登录
      * @return
      */
     boolean isLogin();

     /**
      * 注销登陆，清除用户信息
      */
     void loginOut();

     /**用于处理将bean转换为需要UserBean,如果返回为null，则解析不成功*/
     IUserInfo parse(Object obj);
}