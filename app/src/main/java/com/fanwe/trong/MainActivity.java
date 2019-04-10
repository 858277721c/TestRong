package com.fanwe.trong;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.rong.imlib.RongIMClient;

public class MainActivity extends AppCompatActivity
{
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String token = "LOHrQV6XMvO3G4Jxrraokq0NILXdP6D2szGAx3pIbvB4z80anU7DxmjPYouVZsmzI3K7988FFN7Bco9PPlV4YA==";
        RongIMClient.connect(token, new RongIMClient.ConnectCallback()
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
}
