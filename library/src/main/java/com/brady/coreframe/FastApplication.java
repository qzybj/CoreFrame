package com.brady.coreframe;

import android.app.Application;
import com.brady.coreframe.aosp.picasso.PicassoHelper;
import com.brady.coreframe.module.loadimage.LoadImageManager;


public class FastApplication extends Application {
    private static Application instance;
    public static Application instance(){
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        LoadImageManager.init(new PicassoHelper());
    }
}
