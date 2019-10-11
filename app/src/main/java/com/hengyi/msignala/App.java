package com.hengyi.msignala;

import android.app.Application;
import android.content.Intent;

import com.hengyi.msignala.service.SignalAService;

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        startService(new Intent(this , SignalAService.class ));
    }
}
