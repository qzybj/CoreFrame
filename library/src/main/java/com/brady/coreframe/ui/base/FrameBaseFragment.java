package com.brady.coreframe.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brady.coreframe.ui.base.i.IBaseUI;
import com.brady.libutil.log.CLog;
import butterknife.ButterKnife;

/**
 * 框架 - Fragment的base基类，只包含最基本的
 */
public abstract class FrameBaseFragment extends Fragment implements IBaseUI {
    protected Activity mParentActivity;
    private View mRootView ;

    @Override
    public final void onCreate(@Nullable Bundle savedInstanceState) {
        mParentActivity  = this.getActivity();
        super.onCreate(savedInstanceState);
    }

    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int layoutResId = getLayoutResId();
        if (layoutResId>0) {
            try {
                mRootView  = inflater.inflate(layoutResId, container, false);
            } catch (Exception e) {
                CLog.e(e);
            }
            if (mRootView != null) {
                ButterKnife.bind(this, mRootView);
                initContentView(mRootView);
                return mRootView;
            }
        }
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData(savedInstanceState);
    }

    public Activity getBaseActivity(){
        return mParentActivity;
    }

}