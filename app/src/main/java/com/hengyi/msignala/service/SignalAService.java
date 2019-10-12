package com.hengyi.msignala.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.hengyi.msignala.Constance;
import com.hengyi.msignala.bean.ContentInfo;
import com.hengyi.msignala.longpolling.LongPollingTransport;
import com.hengyi.msignala.singala.Connection;
import com.hengyi.msignala.singala.hubs.HubConnection;
import com.hengyi.msignala.singala.transport.StateBase;
import com.hengyi.msignala.utils.FastJsonUtils;

public class SignalAService extends Service {
    private String address = "http://14.29.87.54:4321/";
    private String subAddress = "ERPDataModifyPush";
    private static final String TAG = "JavaWebSocket";
    private Connection conn;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate(){
        super.onCreate();

    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        connection();
        return super.onStartCommand(intent, flags, startId);
    }
    /**
     * 连接测试
     */
    private void connection() {
            conn = new Connection(address + subAddress , this ,new LongPollingTransport()){
            @Override
            public void OnError(Exception exception) {
                super.OnError(exception);
                Log.d(TAG ,"OnError==" +  exception.getMessage());
            }
            @Override
            public void OnMessage(String message) {
                super.OnMessage(message);
                Log.d(TAG ,"OnMessage==" + message);
                //解析服务器返回的数据
                ContentInfo info = FastJsonUtils.toBean(message , ContentInfo.class);
                Intent intent = null;
                switch (info.getDataModify()){
                    case "order":
                        intent = new Intent(Constance.MESSAGE_ORDER);
                        break;
                    case "":
                        break;
                }
                intent.putExtra("content" , FastJsonUtils.toJSON(info.getContent()));
                sendBroadcast(intent);
            }
            @Override
            public void OnStateChanged(StateBase oldState, StateBase newState) {
                super.OnStateChanged(oldState, newState);
                Log.d(TAG , "OnStateChanged==" + oldState.getIsRunning() + oldState.getState() + "----" + newState.getIsRunning() + newState.getState());
            }
        };
        conn.Start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (conn != null){
            conn.Stop();
        }
    }
}
