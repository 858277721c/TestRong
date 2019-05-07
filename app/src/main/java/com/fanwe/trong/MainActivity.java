package com.fanwe.trong;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.rong.imlib.RongIMClient;

public class MainActivity extends AppCompatActivity
{
    public static final String TAG = MainActivity.class.getSimpleName();
    public static final String TOKEN = "XLHwGmxISpuqZFe7y9DeCTxAy4ek0qIgHEzWb/0gOmgf4Ar9mQx9Rk/Q1RE7XW929sta6QUB28o=";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, this + " onCreate savedInstanceState:" + savedInstanceState);

        if (savedInstanceState != null)
        {
            if (RongIMClient.getInstance().getCurrentConnectionStatus() != RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTED)
            {
                connect();
            }
        } else
        {
            connect();
        }
    }

    private void connect()
    {
        RongIMClient.connect(TOKEN, new RongIMClient.ConnectCallback()
        {
            @Override
            public void onTokenIncorrect()
            {
                Log.i(TAG, "connect onTokenIncorrect");
            }

            @Override
            public void onSuccess(String s)
            {
                Log.i(TAG, "connect onSuccess");
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode)
            {
                Log.i(TAG, "connect onError: " + errorCode);
            }
        });
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.i(TAG, this + " onResume");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.i(TAG, this + " onStop");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.i(TAG, this + " onDestroy");
    }
}
