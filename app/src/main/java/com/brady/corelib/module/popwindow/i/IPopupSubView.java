package com.brady.corelib.module.popwindow.i;

import android.view.View;
import android.widget.RelativeLayout;

import com.brady.corelib.module.popwindow.BasePopupWindow;


/**
 *
 * @author Cuckoo
 * @date 2017-03-21
 * @description
 *  定义PopupWindow子view
 */

public interface IPopupSubView {
    /**
     * 传递PopupWindow给子view
     * @param popupWindow
     */
    void setPopupWindow(BasePopupWindow popupWindow);

    /**
     * 获取子view
     * @return
     */
    View getSubView();

    /**
     * 获取子view的LayoutParams
     * @return
     */
    RelativeLayout.LayoutParams getLayoutParams();
}
