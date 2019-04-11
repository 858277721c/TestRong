package com.fanwe.trong;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import java.util.List;

import io.rong.imlib.RongIMClient;

public class App extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        if (getPackageName().equals(getProcessName(this)))
        {
            // 主进程初始化
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

    private static String getProcessName(Context context)
    {
        final ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        final List<ActivityManager.RunningAppProcessInfo> list = manager.getRunningAppProcesses();
        if (list == null || list.isEmpty())
            return null;

        final int pid = android.os.Process.myPid();
        for (ActivityManager.RunningAppProcessInfo item : list)
        {
            if (item.pid == pid)
                return item.processName;
        }
        return null;
    }
}
