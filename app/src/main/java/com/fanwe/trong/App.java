package com.fanwe.trong;

import android.app.Application;
import android.util.Log;

import io.rong.imlib.RongIMClient;

public class App extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        RongIMClient.init(this, "3argexb63qjpe");
        RongIMClient.setConnectionStatusListener(new RongIMClient.ConnectionStatusListener()
        {
            @Override
            public void onChanged(ConnectionStatus connectionStatus)
            {
                Log.i(MainActivity.TAG, "ConnectionStatus:" + connectionStatus);
            }
        });
    }
}
