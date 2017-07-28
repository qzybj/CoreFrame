package com.brady.corelib.module.login.i.impl;

import com.brady.corelib.module.login.i.IAccountHelper;
import com.brady.corelib.module.login.i.IUserInfo;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Clair
 *
 * @date 2017/7/27
 * @description 用户信息
 */
public class UserInfo implements IUserInfo {
    @SerializedName("uid")
    private String uid = IAccountHelper.VALUE_NONE;
    @SerializedName("user_token")
    private String token = IAccountHelper.VALUE_NONE;
    @SerializedName("user_type")
    private int type = IAccountHelper.VALUE_NONE_INT;
    @SerializedName("username")
    private String name = IAccountHelper.VALUE_NONE;
    @SerializedName("head_img")
    private String headImg = IAccountHelper.VALUE_NONE;

    @Override
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String getToken() {
        return token;
    }
    @Override
    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public int getType() {
        return type;
    }
    @Override
    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getHeadImg() {
        return headImg;
    }
    @Override
    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
}
