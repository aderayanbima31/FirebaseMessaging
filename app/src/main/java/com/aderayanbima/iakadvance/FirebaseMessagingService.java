package com.aderayanbima.iakadvance;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by adera on 11/19/2017.
 */

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage)
    {
        super.onMessageReceived(remoteMessage);

        Log.e("Notification",
                remoteMessage.getData().get("message")
                        + remoteMessage.getData().get("image") + "\n"
                        + remoteMessage.getData().get("segment") + "\n"
                        + remoteMessage.getData().get("url") + "\n");


        showNotification(
                remoteMessage.getData().get("message"),
                remoteMessage.getData().get("image"),
                remoteMessage.getData().get("segment"),
                remoteMessage.getData().get("url")
                );

    }

    private void showNotification(String message, String image, String segment, String url)
    {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setAutoCancel(true)
                .setContentTitle("IAK ADV3 Bandung")
                .setContentText(message + "\n")
                .setSmallIcon(R.mipmap.ic_launcher);

        Notification notification = builder.build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

}
