package com.brady.corelib.module.login.i;

/**
 * Created by Brady on 2016/5/3.
 * 用户信息接口
 */
public interface IUserInfo {
    /**
     * 获取用户唯一ID
     *
     * @return
     */
    String getUid();

    /**
     * 设置用户唯一ID
     *
     * @param uid
     */
    void setUid(String uid);

    /**
     * 获取用户Token
     * @return
     */
    String getToken();

    /**
     * 设置用户Token
     * @param userToken
     */
    void setToken(String userToken);

    /**
     * 获取用户类型
     * @return
     */
    int getType();

    /**
     * 设置用户类型
     * @param userType
     */
    void setType(int userType);

    /**
     * 获取用户名称
     * @return
     */
    String getName();

    /**
     * 设置用户名称
     * @param userName
     */
    void setName(String userName);

    /**
     * 获取用户头像
     * @return
     */
    String getHeadImg();

    /**
     * 设置用户头像
     * @param headImg
     */
    void setHeadImg(String headImg);
}
