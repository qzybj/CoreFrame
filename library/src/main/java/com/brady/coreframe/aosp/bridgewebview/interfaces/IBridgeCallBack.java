package com.brady.coreframe.aosp.bridgewebview.interfaces;


/**
 * Created by ZhangYuanBo on 2016/5/23.
 * Bridge处理的回调
 */
public interface IBridgeCallBack {

    /**
     * 解析处理JS调用客户端方法,发送过来的message
     * @param bean
     */
     void paserJsCallApp(IJSBridgeBean bean) ;

    /**
     * 解析处理调用JS方法之后回调客户端的message
     * @param json
     */
     void paserCallJsCallback(String json);

    /**
     * 解析处理未知的数据传递
     * @param json
     */
     void paserOtherCallback(Object json);
}
