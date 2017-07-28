package com.brady.corelib.module.fragmentbar;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brady.app.R;
import com.brady.corelib.module.fragmentbar.i.ITitleBarClickListener;
import com.brady.libutil.data.StringUtil;
import com.brady.libutil.view.TextViewUtil;


/**
 * Created by Brady on 2016/5/27.
 * TitleBar 模块：页面项部标题栏的实现
 */
public class TitleBarFragment extends Fragment implements View.OnClickListener{
    LinearLayout layout_leftBtn;
    TextView tv_left;
    TextView tv_title;
    LinearLayout layout_rightBtn;
    TextView tv_right;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_frame_titlebar, container, false);
        layout_leftBtn = (LinearLayout)view.findViewById(R.id.titlebar_layout_left);
        layout_rightBtn = (LinearLayout)view.findViewById(R.id.titlebar_layout_right);
        tv_title = (TextView)view.findViewById(R.id.titlebar_tv_title);
        tv_left = (TextView)view.findViewById(R.id.titlebar_tv_left);
        tv_right = (TextView)view.findViewById(R.id.titlebar_tv_right);
        layout_leftBtn.setOnClickListener(this);
        layout_rightBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if (getActivity() instanceof ITitleBarClickListener) {
            ITitleBarClickListener listener = (ITitleBarClickListener) getActivity();
            if (layout_leftBtn == view) {
                listener.onClickTitleLeft(view);
            } else if (layout_rightBtn == view) {
                listener.onClickTitleRight(view);
            } else{
                listener.onTitleBarClick(view);
            }
        }
    }

    //--------------------设置标题栏展示实现方法
    /**
     * 设置title内容
     * @param titleResid
     */
    public final void setTitle(int titleResid) {
        setTitle(getString(titleResid));
    }

    /**
     * 设置title内容
     *
     * @param titleStr
     */
    public final void setTitle(String titleStr) {
        TextViewUtil.setValue(tv_title,titleStr,false);
    }

    /**
     * 控制标题栏左边按钮显示或隐藏
     */
    public final void setLeftVisibility(boolean isVisibility) {
        if (layout_leftBtn != null) {
            layout_leftBtn.setVisibility(isVisibility ? View.VISIBLE : View.GONE);
        }
    }

    /**
     * 设置title左边按钮的显示内容
     *
     * @param titleResid
     */
    public final void setLeftText(int titleResid) {
        if (titleResid > 0) {
            setLeftText(getString(titleResid));
        }
    }

    /**
     * 设置title左边按钮的显示内容
     *
     * @param titleStr
     */
    public final void setLeftText(String titleStr) {
        if (tv_left != null && StringUtil.isNotEmpty(titleStr)) {
            TextViewUtil.setValue(tv_left,titleStr,false);
        }
    }

    /**
     * 设置title左边按钮的显示图片
     * @param drawableResid
     */
    public final void setLeftDrawable(int drawableResid, int padding) {
        if (tv_left != null) {
            if (drawableResid > 0) {
                Drawable drawable = getResources().getDrawable(drawableResid);
                if (drawable != null) {
                    TextViewUtil.setDrawable(tv_left, drawable, padding,0);
                }
            } else {
                TextViewUtil.setDrawable(tv_left, null, padding,0);
            }
        }
    }


    /**
     * 控制标题栏右边按钮显示或隐藏
     */
    public final void setRightVisibility(boolean isVisibility) {
        if (layout_rightBtn != null) {
            layout_rightBtn.setVisibility(isVisibility ? View.VISIBLE : View.GONE);
        }
    }

    /**
     * 设置title右边按钮的显示内容
     *
     * @param titleResid
     */
    public final void setRightText(int titleResid) {
        if (titleResid > 0) {
            setRightText(getString(titleResid));
        }
    }

    /**
     * 设置title右边按钮的显示内容
     *
     * @param title
     */
    public final void setRightText(String title) {
        TextViewUtil.setValue(tv_right,title,false);
    }

    /**
     * 设置title右边按钮的显示图片
     * @param drawableResid
     */
    public final void setRightDrawable(int drawableResid, int padding) {
        if (tv_right != null && drawableResid > 0) {
            Drawable drawable = getResources().getDrawable(drawableResid);
            if (drawable != null) {
                setRightVisibility(true);
                TextViewUtil.setDrawable(tv_right, drawable, padding,0);
            }
        }
    }
}