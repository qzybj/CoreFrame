package com.brady.appframe.core.ui.reciverui.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.brady.app.R;
import com.brady.appframe.core.ui.reciverui.bean.MainItemBean;
import com.brady.appframe.module.common.decoration.GridDecoration;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qzybj.libimageload.LoadImageManager;

import java.util.List;


public class MainAdapter extends BaseQuickAdapter<MainItemBean> {
    private Context mContext;

    public MainAdapter(Context context, RecyclerView recyclerView, List data) {
        super(R.layout.rvadatper_main_item,data);
        mContext = context;
        initAdapter(recyclerView);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainItemBean item) {
        helper.setText(R.id.tv_title, item.getTitle());
        helper.setText(R.id.tv_content, item.getContent());
        helper.setVisible(R.id.tv_date,false);
        LoadImageManager.instance().loadImage((ImageView)(helper.getView(R.id.iv_icon)),item.getImageUrl());
    }

    private void initAdapter(RecyclerView recyclerView){
        if(recyclerView!=null&&getContext()!=null){
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            recyclerView.addItemDecoration(new GridDecoration(getContext(), GridDecoration.STYLE_VERTICAL));//设定分隔线
            openLoadAnimation();
        }
    }
    private Context getContext(){
        return mContext;
    }
}