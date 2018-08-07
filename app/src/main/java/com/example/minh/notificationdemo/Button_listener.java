package com.example.minh.notificationdemo;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Minh on 8/6/2018.
 */

public class Button_listener extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//        manager.cancel(intent.getExtras().getInt("id"));
        if(intent.getAction()!=null){
            switch (intent.getAction()) {
                case "back_event":
                    Toast.makeText(context, "back", Toast.LENGTH_SHORT).show();
                    break;
                case "pause_event":
                    Toast.makeText(context, "pause", Toast.LENGTH_SHORT).show();
                    break;
                case "next_event":
                    Toast.makeText(context, "next", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

    }
}
