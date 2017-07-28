package com.brady.corelib.module.jump;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.brady.app.bean.MainItemBean;
import com.brady.corelib.module.fragmentbar.i.ITabItem;
import com.brady.corelib.module.fragmentcontainer.ContainerActivity;
import com.brady.corelib.module.fragmentcontainer.i.impl.BuildParams;
import com.brady.corelib.module.jump.impl.JumpInfo;
import com.brady.corelib.utils.TestDataBuilder;
import com.brady.libutil.data.RandomUtil;
import com.brady.libutil.jump.JumpBaseUtil;

import java.text.DateFormat;
import java.util.ArrayList;

/**
 * Created by Brady on 2016/9/8.
 */
public class JumpUtil extends JumpBaseUtil {

    /**
     * 生成 IJumpInfo
     * @param target
     * @param title
     * @param args
     * @return
     */
    public static IJumpInfo buildJumpInfo(Class target, String title, Bundle args) {
        return new JumpInfo(target,title,args);
    }

    /**
     * 以指定Activity展示的界面
     * @param target
     * @param describe
     * @return
     */
    public static MainItemBean buildJump(Class target, String describe) {
        return buildJump(target,null,describe,null);
    }

    /**
     * 以指定Activity展示的界面
     * @param target
     * @param describe
     * @param args
     * @return
     */
    public static MainItemBean buildJump(Class target, String describe, Bundle args) {
        return buildJump(target,null,describe,args);
    }

    /**
     * 以Fragment展示的界面
     * @param target
     * @param fragment
     * @param describe
     * @return
     */
    public static MainItemBean buildJump(Class target,
                                         Class<? extends Fragment> fragment,
                                         String describe) {
        return buildJump(target,fragment,describe,null);
    }

    /**
     * 以Fragment展示的界面
     * @param target
     * @param fragment
     * @param describe
     * @param args
     * @return
     */
    public static MainItemBean buildJump(Class target,
                                         Class<? extends Fragment>  fragment,
                                         String describe, Bundle args) {
        return buildJump(target,fragment,true,false,null,describe,args);
    }

    /**
     * 以容器 ContainerActivity 为展示界面的 fragment
     * @param fragment
     * @param isEnableTitleBar
     * @param isEnableBottomTabBar
     * @param tabItems
     * @return
     */
    public static MainItemBean buildJump(Class<? extends Fragment> fragment,
                                         boolean isEnableTitleBar,
                                         boolean isEnableBottomTabBar,
                                         ArrayList<ITabItem> tabItems) {
        return buildJump(ContainerActivity.class,
                fragment,
                isEnableTitleBar,
                isEnableBottomTabBar, tabItems,fragment.getSimpleName(),
                null);
    }

    /**
     *
     * @param target
     * @param fragment
     * @param isEnableTitleBar
     * @param isEnableBottomTabBar
     * @param tabItems
     * @param describe
     * @param args
     * @return
     */
    public static MainItemBean buildJump(Class target,
                                         Class<? extends Fragment> fragment,
                                         boolean isEnableTitleBar,
                                         boolean isEnableBottomTabBar,
                                         ArrayList<ITabItem> tabItems,
                                         String describe,
                                         Bundle args) {
        if(target!=null){
            if(args==null){
                args = new Bundle();
            }
            BuildParams buildParams = new BuildParams(fragment,isEnableTitleBar,isEnableBottomTabBar,tabItems);
            args.putSerializable(ContainerActivity.KEY_FRAGMENT,buildParams);
            JumpInfo jumpInfo = new JumpInfo(target,describe,args);

            MainItemBean bean = new MainItemBean();
            bean.setTitle(target.getSimpleName());
            bean.setContent(describe);
            bean.setDate(DateFormat.getDateInstance(DateFormat.SHORT).toString());
            bean.setImageUrl(TestDataBuilder.imageUrls[RandomUtil.getRandom(TestDataBuilder.imageUrls.length-1)]);
            bean.setJumpInfo(jumpInfo);
            return bean;
        }
        return null;
    }
}