package com.brady.corelib.module.fragmentbar.i;

import android.view.View;

/**
 * Created by Brady on 2016/5/30.
 * 用于底部Tab栏的点击事件监听回调
 */
public interface ITabBarClickListener {
    /**
     * 底部Tab栏的点击事件监听回调
     * @param view
     */
    boolean onTabClick(View view);
}
