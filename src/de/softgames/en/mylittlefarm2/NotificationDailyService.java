package de.softgames.en.mylittlefarm2;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

public class NotificationDailyService extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
       
            NotificationCompat.Builder mBuilder = 
                    new NotificationCompat.Builder(context)
                    .setSmallIcon(R.drawable.ic_launcher)
                     .setContentTitle("My Little Farm 2")
                     .setContentText("you Farm misses you! Play Little Farm 2 and get your daily reward");
            
            Intent resultIntent = new Intent(context, MyLittleFarm2Activity.class);
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
            stackBuilder.addParentStack(MyLittleFarm2Activity.class);
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
            mBuilder.setContentIntent(resultPendingIntent);
            NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            mBuilder.setDefaults(Notification.DEFAULT_VIBRATE);
            mNotificationManager.notify(1555, mBuilder.build());
        
        
   }

}




