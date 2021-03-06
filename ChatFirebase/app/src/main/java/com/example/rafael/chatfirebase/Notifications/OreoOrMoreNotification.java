package com.example.rafael.chatfirebase.Notifications;


import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Build;

import com.example.rafael.chatfirebase.Model.ChatList;

public class OreoOrMoreNotification extends ContextWrapper {

    private static final String ChannelID = "com.example.rafel.chatfirebase";
    private static final String ChannelNAME = "ChatFirebase";
    private static final int Importance = 1;

    private NotificationManager notificationManager;

    public OreoOrMoreNotification(Context base) {

        super(base);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            createChannel();
        }
    }
    @TargetApi(Build.VERSION_CODES.O)
    private void createChannel() {

        NotificationChannel channel = new NotificationChannel(ChannelID,ChannelNAME,NotificationManager.IMPORTANCE_DEFAULT);
        channel.enableLights(false);
        channel.enableVibration(true);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);


    }


    public NotificationManager getManager(){


        if(notificationManager == null){
            notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        }
        return notificationManager;
    }


    @TargetApi(Build.VERSION_CODES.O)
    public Notification getOreoNotification(String title, String body, PendingIntent pendingIntent, Uri soundUri, String icon){

        return new Notification.Builder(getApplicationContext(),ChannelID)
                .setContentIntent(pendingIntent)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(Integer.parseInt(icon))
                .setSound(soundUri)
                .setAutoCancel(true)
                .build();


    }
}
