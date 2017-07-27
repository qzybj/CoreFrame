package com.brady.appframe.core.ui.reciverui.bean;


import com.brady.libutil.jump.JumpBaseUtil;

public class MainItemBean {
    private String title;
    private String content;
    private String date;
    private String imageUrl;
    private JumpBaseUtil.IJumpInfo jumpInfo;
    private boolean isShowFlag;

    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public JumpBaseUtil.IJumpInfo getJumpInfo() {
        return jumpInfo;
    }
    public void setJumpInfo(JumpBaseUtil.IJumpInfo jumpInfo) {
        this.jumpInfo = jumpInfo;
    }

    public boolean isShowFlag() {
        return isShowFlag;
    }

    public void setShowFlag(boolean showFlag) {
        isShowFlag = showFlag;
    }
}