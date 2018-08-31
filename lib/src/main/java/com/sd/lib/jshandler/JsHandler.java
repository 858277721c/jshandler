package com.sd.lib.jshandler;

import android.app.Activity;
import android.content.Intent;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;

import com.sd.lib.jshandler.model.StartAppPageJsonModel;

public class JsHandler extends BaseJsHandler
{
    public JsHandler(Activity activity)
    {
        super(activity);
    }

    /**
     * 退出登录
     */
    @JavascriptInterface
    public void logout()
    {
        CookieManager.getInstance().removeSessionCookie();
    }

    /**
     * 关闭当前页面
     */
    @JavascriptInterface
    public void close_page()
    {
        getActivity().finish();
    }

    /**
     * 打开某个页面
     *
     * @param json
     */
    @JavascriptInterface
    public void start_app_page(String json)
    {
        try
        {
            final StartAppPageJsonModel model = new StartAppPageJsonModel();
            model.parseJson(json);
            onStartAppPage(model);
        } catch (Exception e)
        {
            onError(e);
        }
    }

    protected void onStartAppPage(StartAppPageJsonModel model)
    {
        final String packageName = getActivity().getPackageName();
        final String target = model.getAndroid_page();
        final String json = model.getJson();

        final Intent intent = new Intent();
        intent.setClassName(packageName, target);
        intent.putExtra("data", json);

        getActivity().startActivity(intent);
    }
}
