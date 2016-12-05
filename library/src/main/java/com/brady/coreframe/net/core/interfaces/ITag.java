package com.brady.coreframe.net.core.interfaces;

import com.brady.coreframe.net.core.config.NetConstants;

/**
 * Created by ZhangYuanBo on 2016/9/5.
 */
public interface ITag {
    int getRequstCode();
    @NetConstants.LoadingType
    int getLoadingType();
    long getRequstTime();
}
