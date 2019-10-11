package com.hengyi.msignala;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OrderBroadCastReceiver receiver = new OrderBroadCastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Constance.MESSAGE_ORDER);
        registerReceiver(receiver , filter);

    }
    class OrderBroadCastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            String str = intent.getStringExtra("content");
            Log.d("TAG" , str);
        }
    }

}
