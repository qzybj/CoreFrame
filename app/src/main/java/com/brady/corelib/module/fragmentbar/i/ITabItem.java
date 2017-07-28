package com.brady.corelib.module.fragmentbar.i;


import java.io.Serializable;

/**
 * Created by Brady on 2016/5/30.
 *  用于Fragment与activity的数据
 */
public interface ITabItem  extends Serializable {
    /**获取图片resourceid*/
    int getImageResId();
    /**获取展示用的text文本*/
    String getText();
}