package com.brady.corelib.module.fragmentcontainer.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


/**
 * Created by Brady on 2017/1/23.
 * 用于Fragment的操作
 */
public class FragmentHelper {

    /**
     * 显示Fragment
     * @param fm
     * @param frameLayoutResId
     * @param source
     * @param target
     */
    public static void showFragment(FragmentManager fm,int frameLayoutResId,Fragment source,Fragment target){
        if (target!=null&&target!= source) {
            FragmentTransaction transaction =  fm.beginTransaction();//开启Fragment事务
            if(source !=null){
                transaction.hide(source);
            }
            if (!target.isAdded()) {
                transaction.add(frameLayoutResId, target);
            } else {
                transaction.show(target);
            }
            transaction.commit();
        }
    }

    /**
     * 显示/隐藏 Fragment
     * @param fm
     * @param frameLayoutResId
     * @param target
     * @param isShow
     */
    public static  void setVisible(FragmentManager fm, int frameLayoutResId, Fragment target, boolean isShow){
        if (fm != null && !fm.isDestroyed() &&
                frameLayoutResId > 0 && target != null) {
            FragmentTransaction transaction = fm.beginTransaction();
            if(isShow){
                if (!target.isAdded()) {
                    transaction.add(frameLayoutResId, target);
                }else{
                    transaction.show(target);
                }
            }else{
                transaction.hide(target);
            }
            transaction.commit();
        }
    }
}
