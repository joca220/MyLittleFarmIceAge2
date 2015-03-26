package de.softgames.en.mylittlefarm2;


import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;


public class NotificationGameActivity extends Activity {

    private static int messageId = 0;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        moveTaskToBack(true);
        super.onCreate(savedInstanceState);
        
        String title = "";
        String info1 = "";
        String info2 = "";
        int idNotification = 0;
        
        if (this.getIntent().getExtras() != null) {
            Bundle bundle = this.getIntent().getExtras();
            if (bundle.getString("TITLE") != null) {
                title = bundle.getString("TITLE");
            }

            if (bundle.getString("INFO1") != null) {
                info1 = bundle.getString("INFO1");
            }

            if (bundle.getString("INFO2") != null) {
                info2 = bundle.getString("INFO2");
            }

            if (bundle.getString("IDNOTIF") != null) {
                idNotification = Integer.parseInt(bundle.getString("IDNOTIF"));
            }
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                getApplicationContext())
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentText(info2).setContentTitle(info1)
                .setWhen(System.currentTimeMillis());
        
        mBuilder.setDefaults(Notification.DEFAULT_VIBRATE);
        mBuilder.setDefaults(Notification.DEFAULT_SOUND);
        
        // Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(getApplicationContext(),
                MyLittleFarm2Activity.class);

        /**
         * The stack builder object will contain an artificial back stack for
         * the started Activity. This ensures that navigating backward from the
         * Activity leads out of your application to the Home screen.
         */
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(MyLittleFarm2Activity.class);
        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,
                PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // _message_id allows you to update the notification later on.
        notificationManager.notify(messageId++, mBuilder.build());

        finish();
    }

}
