package com.brady.app;


import com.brady.coreframe.FastApplication;
import com.brady.libutil.UtilsManager;
import com.brady.libutil.cache.SPUtil;
import com.qzybj.libimageload.LoadImageManager;


public class CApplication extends FastApplication {
    public final static String SHARED_PATH = "custom_shared";
    @Override
    public void onCreate() {
        super.onCreate();
        LoadImageManager.init(this);
        UtilsManager.init(this);
        SPUtil.renameStoreName(SHARED_PATH);
        SPUtil.instance();
    }
}
