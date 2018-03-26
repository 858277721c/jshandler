package com.fanwe.lib.jshandler;

import android.app.Activity;

public class BaseJsHandler
{
    private Activity mActivity;

    public BaseJsHandler(Activity activity)
    {
        mActivity = activity;
        if (activity == null)
        {
            throw new NullPointerException("activity is null");
        }
    }

    public final Activity getActivity()
    {
        return mActivity;
    }

    public String getName()
    {
        return "App";
    }

    protected void onError(Exception e)
    {

    }
}
