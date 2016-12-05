package com.brady.coreframe.net.core.bean;

import com.brady.coreframe.net.core.NetDataServer;
import com.brady.coreframe.net.core.config.NetConstants;
import com.brady.coreframe.net.core.interfaces.ITag;

public class TagBean implements ITag {

    private long requestTime;
    private int requestCode = NetDataServer.DEFAULT_REQUEST_CODE;

    @NetConstants.LoadingType
    private int loadingType = NetConstants.LoadingType.LOADING_NORMAL;

    public TagBean(BasicRequest req) {
        this.requestTime = System.currentTimeMillis();
        if(req!=null){
            this.requestCode = req.getRequestCode();
            this.loadingType = req.getLoadType();
        }
    }

    @Override
    public int getRequstCode() {
        return requestCode;
    }

    @Override
    public int getLoadingType() {
        return loadingType;
    }

    @Override
    public long getRequstTime() {
        return requestTime;
    }

    public void setRequestTime(long requestTime) {
        this.requestTime = requestTime;
    }

    public void setRequestCode(int requestCode) {
        this.requestCode = requestCode;
    }
    public void setLoadingType(int loadingType) {
        this.loadingType = loadingType;
    }
}
