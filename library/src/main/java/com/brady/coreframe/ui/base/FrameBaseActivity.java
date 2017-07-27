package com.brady.coreframe.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.brady.coreframe.ui.base.i.IBaseUI;
import com.brady.libutil.log.CLog;
import com.brady.libutil.view.ViewUtil;

import butterknife.ButterKnife;

/**
 * 框架 - Activity的base基类，只包含最基本的
 */
public abstract class FrameBaseActivity extends AppCompatActivity implements View.OnClickListener,IBaseUI {
	private Activity mBaseActivity;
	private View mRootView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBaseActivity= this;
		int layoutResId = getLayoutResId();
		if (layoutResId>0) {
			try {
				mRootView = ViewUtil.loadView(getBaseActivity(),layoutResId);
			} catch (Exception e) {
				CLog.e(e);
			}
			if (mRootView != null) {
				setContentView(mRootView);
				ButterKnife.bind(this);
				initTitleBar(mRootView);
				initContentView(mRootView);
			}
		}
		initConstant(savedInstanceState);
		initData(savedInstanceState);
	}
	public Activity getBaseActivity(){
		return mBaseActivity;
	}

	/**
	 * 初始化标题栏
	 * @param view
	 */
	protected abstract void initTitleBar(View view);

	@Override
	public void initConstant(Bundle savedInstanceState) {}
}