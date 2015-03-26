package de.softgames.en.mylittlefarm2;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;


	public class NotificationCropService extends BroadcastReceiver {

	    @Override
	    public void onReceive(Context context, Intent intent) {
	       
	            NotificationCompat.Builder mBuilder = 
	                    new NotificationCompat.Builder(context)
	                    .setSmallIcon(R.drawable.ic_launcher)
	                    .setContentTitle("Your crops are ready!")
	                    .setContentText("Visit My Little Farm 2 to harvest them!");
	            
	            Intent resultIntent = new Intent(context, MyLittleFarm2Activity.class);
	            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
	            stackBuilder.addParentStack(MyLittleFarm2Activity.class);
	            stackBuilder.addNextIntent(resultIntent);
	            PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
	            mBuilder.setContentIntent(resultPendingIntent);
	            NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
	            mBuilder.setDefaults(Notification.DEFAULT_VIBRATE);
	            mNotificationManager.notify(12444, mBuilder.build());
	        
	        
	   }

 }
	
	
	

