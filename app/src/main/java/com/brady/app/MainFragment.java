package com.brady.app;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.brady.app.R;
import com.brady.appframe.core.ui.reciverui.adapter.MainAdapter;
import com.brady.appframe.core.ui.reciverui.bean.MainItemBean;
import com.brady.appframe.module.common.ui.SimpleFragment;
import com.brady.appframe.module.common.utils.TabBottomBarUtils;
import com.brady.appframe.module.common.utils.TestDataBuilder;
import com.brady.appframe.module.loadimage.LoadImageFragment;
import com.brady.appframe.module.webview.PullWebviewActivity;
import com.brady.appframe.module.webview.SwipeWebviewActivity;
import com.brady.coreframe.ui.base.FrameBaseFragment;
import com.brady.corelib.fragment.interfaces.impl.BuildParams;
import com.brady.libutil.jump.JumpBaseUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class MainFragment extends FrameBaseFragment implements
        SwipeRefreshLayout.OnRefreshListener,
        BaseQuickAdapter.RequestLoadMoreListener{
    private static final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);

    @BindView(R.id.srlayout_common)
    public SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.rv_common)
    public RecyclerView mRecyclerView;

    protected MainAdapter adapter;

    public MainFragment() {}

    @Override
    public void initConstant(Bundle savedInstanceState) {}

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_main;
    }

    @Override
    public void initContentView(View view) {
        initSwipeRefreshLayout();
        mRecyclerView.addOnItemTouchListener(new SimpleClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if(adapter!=null){
                    MainItemBean item = (MainItemBean)adapter.getItem(position);
                    JumpBaseUtil.go(getBaseActivity(),item.getJumpInfo());
                }
            }

            @Override
            public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getBaseActivity(), "" + Integer.toString(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getBaseActivity(), "" + Integer.toString(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getBaseActivity(), "" + Integer.toString(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        loadData(getShowBeanList());
    }

    protected void loadData(List<MainItemBean> list) {
        if (adapter == null){
            adapter = new MainAdapter(getContext().getApplicationContext(), mRecyclerView,list);
            mRecyclerView.setAdapter(adapter);
        }else{
            adapter.addData(list);
        }
        adapter.notifyDataSetChanged();
    }

    private void initSwipeRefreshLayout() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.CFFFFFF, R.color.C33A6FF,R.color.CFF0000);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setEnabled(true);
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
                onRefreshData();
            }
        }, 1000);
    }
    public void onRefreshData() {
        //adapter.setNewData(getTestData());
        //adapter.notifyDataSetChanged();
    }
    @Override
    public void onLoadMoreRequested() {

    }

    public static ArrayList<MainItemBean> getShowBeanList() {
        ArrayList<MainItemBean> list = new ArrayList<>();
        list.add(TestDataBuilder.getJumpBean("WebView - 样式1",PullWebviewActivity.class,null));
        list.add(TestDataBuilder.getJumpBean("WebView - 样式1",SwipeWebviewActivity.class,null));

        list.add(TestDataBuilder.getJumpBeanF(new BuildParams(SimpleFragment.class,true,true,TabBottomBarUtils.getTestTabItemList())));
        list.add(TestDataBuilder.getJumpBeanF(new BuildParams(LoadImageFragment.class,true,true,TabBottomBarUtils.getTestTabItemList())));
        return list;
    }
}