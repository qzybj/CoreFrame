package com.brady.corelib.module.fragmentcontainer.i;

import com.brady.corelib.module.fragmentbar.TitleBarFragment;
import com.brady.corelib.module.fragmentdialog.i.IDialogCallBack;
import com.brady.corelib.module.fragmentbar.i.ITabBarClickListener;
import com.brady.corelib.module.fragmentbar.i.ITitleBarClickListener;

/**
 * Created by Brady on 2016/5/30.
 *  用于绑定Fragment与activity的交互
 */
public interface IBindFragment2Container {
    /**
     * 用于绑定项部分栏于底部栏的点击触发事件
     * @param titleBarListener
     * @param tabBarClickListener
     */
    void bindListener(ITitleBarClickListener titleBarListener, ITabBarClickListener tabBarClickListener);

    /**
     * 用于绑定弹出类Fragment的callback事件
     * @param callBack
     */
    void bindFragmentCallBack(IDialogCallBack callBack);

    /**
     * 接收Fragment发送的数据
     * @param tag Fragment tag
     * @param obj
     */
    void receive(String tag, Object obj);

    /**
     * 获取TitleBar进行操作
     */
    TitleBarFragment getTitleBar();
}
