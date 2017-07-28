package com.brady.corelib.module.fragmentbar.i.impl;

import com.brady.corelib.module.fragmentbar.i.ITabItem;

/**
 * Created by Clair
 *
 * @date 2017/7/27
 * @description
 */
public class TabItem implements ITabItem {
    private int imageResId;
    private String text;

    public TabItem(int imageResId, String text) {
        this.imageResId = imageResId;
        this.text = text;
    }

    @Override
    public int getImageResId() {
        return imageResId;
    }

    @Override
    public String getText() {
        return text;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public void setText(String text) {
        this.text = text;
    }
}
