package com.brady.corelib.module.jump.impl;

import android.os.Bundle;

import com.brady.libutil.jump.JumpBaseUtil;

/**
 * Created by Clair
 *
 * @date 2017/7/27
 * @description
 */
public class JumpInfo implements JumpBaseUtil.IJumpInfo {
    private Class cls;
    private String title;
    private Bundle args;

    public JumpInfo(Class cls, String title, Bundle args) {
        this.cls = cls;
        this.title = title;
        this.args = args;
    }

    @Override
    public Class getTarget() {
        return cls;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Bundle getArgs() {
        return args;
    }
}