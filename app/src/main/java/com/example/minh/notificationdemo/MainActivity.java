package com.example.minh.notificationdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {
    private NotificationCompat.Builder builder;
    private NotificationManager notificationManager;
    private int notification_id;
    private RemoteViews remoteViews;
    private Context context;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.button_notification);
        context = this;
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        remoteViews = new RemoteViews(getPackageName(),R.layout.custom_notification);
        remoteViews.setImageViewResource(R.id.image_title,R.drawable.zing);
        remoteViews.setTextViewText(R.id.text_song_name,"You belong with me 1");
        remoteViews.setTextViewText(R.id.text_song_author,"Taylor Swift 1");

        notification_id = (int) System.currentTimeMillis();

        Intent intent_back = new Intent("back_event");
        Intent intent_pause = new Intent("pause_event");
        Intent intent_next = new Intent("next_event");



        PendingIntent p_button_intent_back = PendingIntent.getBroadcast(context,123,intent_back,0);
        PendingIntent p_button_intent_pause = PendingIntent.getBroadcast(context,123,intent_pause,0);
        PendingIntent p_button_intent_next = PendingIntent.getBroadcast(context,123,intent_next,0);

        remoteViews.setOnClickPendingIntent(R.id.image_back,p_button_intent_back);
        remoteViews.setOnClickPendingIntent(R.id.image_pause,p_button_intent_pause);
        remoteViews.setOnClickPendingIntent(R.id.image_next,p_button_intent_next);
        setEven();
    }

    private void setEven() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent notification_intent = new Intent(context,MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(context,0,notification_intent,0);

                builder = new NotificationCompat.Builder(context);
                builder.setSmallIcon(R.drawable.zing)
                        .setAutoCancel(true)
                        .setCustomBigContentView(remoteViews)
                        .setContentIntent(pendingIntent);
                notificationManager.notify(notification_id,builder.build());
            }
        });
    }
}
