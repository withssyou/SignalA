package com.hengyi.msignala;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.hengyi.msignala.longpolling.LongPollingTransport;
import com.hengyi.msignala.singala.Connection;
import com.hengyi.msignala.singala.Transport.StateBase;

public class MainActivity extends AppCompatActivity {
    private String address = "http://192.168.1.33/HY-ERPService";
    private String subAddress = "/ERPDataModifyPush";
    private static final String TAG = "JavaWebSocket";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connection();
    }

    /**
     * 链接测试
     */
    private void connection() {
        Connection conn = new Connection(address + subAddress , this ,new LongPollingTransport()){
            @Override
            public void OnError(Exception exception) {
                super.OnError(exception);
                Log.d(TAG ,"OnError==" +  exception.getMessage());
            }

            @Override
            public void OnMessage(String message) {
                super.OnMessage(message);
                Log.d(TAG ,"OnMessage==" + message);
            }

            @Override
            public void OnStateChanged(StateBase oldState, StateBase newState) {
                super.OnStateChanged(oldState, newState);
                Log.d(TAG , "OnStateChanged==" + oldState.getIsRunning() + oldState.getState() + "----" + newState.getIsRunning() + newState.getState());
            }
        };
        conn.Start();
    }
}
