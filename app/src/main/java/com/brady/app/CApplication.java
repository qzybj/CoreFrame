package com.brady.app;


import com.brady.coreframe.FastApplication;
import com.brady.libutil.UtilsManager;
import com.qzybj.libimageload.LoadImageManager;


public class CApplication extends FastApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        LoadImageManager.init(this);
        UtilsManager.init(this);
    }
}
