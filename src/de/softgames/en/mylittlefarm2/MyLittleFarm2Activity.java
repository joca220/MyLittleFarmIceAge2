package de.softgames.en.mylittlefarm2;

import java.util.Calendar;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.analytics.tracking.android.Tracker;
import com.jirbo.adcolony.AdColony;
import com.jirbo.adcolony.AdColonyAd;
import com.jirbo.adcolony.AdColonyAdAvailabilityListener;
import com.jirbo.adcolony.AdColonyAdListener;
import com.jirbo.adcolony.AdColonyVideoAd;

import de.softgames.en.mylittlefarm2.GameCanvas.GameThread;
import de.softgames.en.mylittlefarm2.util.IabHelper;
import de.softgames.en.mylittlefarm2.util.IabResult;
import de.softgames.en.mylittlefarm2.util.Inventory;
import de.softgames.en.mylittlefarm2.util.Purchase;

public class MyLittleFarm2Activity extends Activity implements AdColonyAdListener, AdColonyAdAvailabilityListener{

    private static final String TAG = MyLittleFarm2Activity.class
	    .getSimpleName();

    // (arbitrary) request code for the purchase flow
    private static final int RC_REQUEST = 10001;
    protected static final int DIALOG_INFO = 1;
    public GameCanvas gameCanvas;
    private GameThread gameThread;
    protected ImageView loadingScreen;
  //  private SGAdView sgAdView;
   // private MoreGamesButton sgMoreGamesButton;
    //protected Button skipTutorialButton;
    private ImageButton sgButtonNoAds;

    public Integer[] foundRefunds = null;
    public String androidId = "";
    public String iMEI = "";
    public String base64EncodedPublicKey //= "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjT1x/wfYHNfN9gfYJnN8mv21J5LCWR+Mnva5rRCpqB6Nr0arciImyNLgLwgmURPdVLLsMUSnuLPGDOsE9GLn7z9oe8Px/Ig2wXgzNHT1ObLJCRedQVKCXyRghnDTuIxb5OuLAPEEcal78gEfQ6fhPkWdANFa15lE0AGUpBbKertoFcOt33JzAiLbYLeGESktWiClwQFSgUPFE4dX/lwYU8LX1JZvi8Pmr66AcE01fn2H5+dNiw2kOw9qz+7RmvPGWBkuy7u/p4MYGh9+SpWYCMl2xShIORNUrIT9lCrgWF+/AhjlL2zMZQs3/+Zbmatun5TjSJy2MOIUw64VnU++8wIDAQAB";
    // =   "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAo0RnVEswktPqHu8XAjQ3Uowmug/hizLqBmBiT57H2betPDDJV5Zm+McwmBTCEmdaHeJOAae3JRpUK9h9UgSulg97L5IH5WYNWJrkRcctp55kLCQMw+KbIR/mTO0oRj8U3bHy2E4RXSdza1h/V/yUBxP3ZH3VyCZGSuo7iwOAyfxXuKxBecl4wzFPS1t9ibcif7Wja75awqvH7rddZtiahVRnmBjFek4gxbGX/rs4mS8R8zIWS9/gZ4LarKGTUVajJI2Hnj1flN4cpHjHOP2wR9+H5pgUg9Daq1/+9QoIjYL5pOX2tfnNTPQVK4fsIgvkqi609ERVr6eobdKHgLsyHwIDAQAB";
   // = 	   "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAm/7pVJI74U+HlmM45Dpp7kA3HFcEtiGIUc9smJO79wcaMxTbh2u/1OCf3d0sHJLjvzzXjy0Q47L2nrDboliWoDRxs54LfRMWcGyXZF5FGs8YzEFzx0vtqjjOA93hcmAGK1ucjQQnzIbbLUXAJXRXcQh/9oi+kG7fp2T2YTqbsxvmtiRDEl6U9PYRJ40UOBHyZJcDjSEjxHswLCeeosqxpDyXh7sQp5Y+SQFruBdkO4KA26jnAwv4gEeYJivvXKjvSogBdyfZZCHRWsEK3FWMI4xcrb/37RBQU1XU0qM/XI2UqRjRv5VQnRHUR6kBaT6736ADv/QT3/FCUFDUlXahgQIDAQAB";
    
    = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjZxd3vgAz+ovHXH+jpaxqv7BybOcXjV1kaOofsF/UfjdXkBomI1++uUYtiwhf9QyndFUJnVmftPZKVBaxoZZjvE2T2MF6LT4VNSRyhU45rNa2TP/4h8PTz6pudJj1ZoQMm0c9cS/IyBS16l7SFWpBUDNi+gs/GnTFSplsiruJwk/lgHfgnh5FdfdhnOepy0lUgLs4xeS0eDQ27Xqb9AM5TV8LV6r8mvUWr8TwwXXAmPuYoonuaFowvfF/U/rHQZ9ZFX1QDRDYi4wxZ3bhzXuIwq/2obChZYbiiFm3FPRtnLmDuJx/YiBvjXxZGwdwRRDR6FkYHByBPu70lO31392sQIDAQAB";
    // The helper object
    private IabHelper mHelper;
    private Tracker mTracker;
    
    final static String APP_ID  = "app4eae1e78b23240eea3";
    final static String ZONE_ID = "vz3154f1b8f18a45c793";
    final static String ZONE_ID2 = "vz78e3bc13135346f7bb";
    final static String ZONE_ID3 = "vzee4b4f0deffe4d27a6";
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	  requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.main);
	
	



	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
	getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
		WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	//requestWindowFeature(Window.FEATURE_NO_TITLE);
	
	
	 AdColony.configure( this, "version:1.0,store:google", APP_ID, ZONE_ID, ZONE_ID2, ZONE_ID3 );
	 
	  AdColony.addAdAvailabilityListener(this);

	    // Disable rotation if not on a tablet-sized device (note: not
	    // necessary to use AdColony).
	    if ( !AdColony.isTablet() )
	    {
	      setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE );
	    }
	
	  mHelper = new IabHelper(this, base64EncodedPublicKey);

    
      // Start setup. This is asynchronous and the specified listener
      // will be called once setup completes.
      Log.d(TAG, "Starting setup.");
      mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
          public void onIabSetupFinished(IabResult result) {
              Log.d(TAG, "Setup finished.");

              if (!result.isSuccess()) {
                  // Oh noes, there was a problem.
                 // complain("Problem setting up in-app billing: " + result);
                  return;
              }

              // Have we been disposed of in the meantime? If so, quit.
              if (mHelper == null) return;

              // IAB is fully set up. Now, let's get an inventory of stuff we own.
              Log.d(TAG, "Setup successful. Querying inventory.");
              mHelper.queryInventoryAsync(mGotInventoryListener);
          }
      });

	loadingScreen = (ImageView) findViewById(R.id.loadingScreenGame);
	gameCanvas = (GameCanvas) findViewById(R.id.View);
	

//	sgAdView = (SGAdView) findViewById(R.id.sgadview);
//	sgAdView.setVisibility(View.GONE);
	
//	sgMoreGamesButton = (MoreGamesButton) findViewById(R.id.sgMoreGamesButton);
  //      sgMoreGamesButton.setVisibility(View.GONE);
        
        //skipTutorialButton = (Button) findViewById(R.id.buttonSkipTutorial);
       
        
        // The google analytics object instance
       /* GoogleAnalytics mInstance = GoogleAnalytics.getInstance(this);
        // Get the existing tracker
        mTracker = mInstance.getDefaultTracker();
        mTracker.sendView("/MainGame");

        sgButtonNoAds =  (ImageButton) findViewById(R.id.sg_button_no_ads);
        sgButtonNoAds.setOnClickListener(new OnClickListener() {            
            @Override
            public void onClick(View v) {
                Constants.SKU_BUY = Constants.HF3_NO_ADS;
                buyInGame();
            }
        });*/
        
        
	
	TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        iMEI = telephonyManager.getDeviceId();
        androidId = Secure.getString(getContentResolver(), Secure.ANDROID_ID);

	
	
	gameThread = gameCanvas.getThread(this);
	
	
	 /*skipTutorialButton.setOnClickListener(new View.OnClickListener() {            
         @Override
         public void onClick(View v) {
             gameThread.tutorialGame = false;
             gameThread.stepTutorial = Constants.STEP_TUTORIAL_YOU_MADE;
             gameThread.saveGame();
             FlurryAgent.logEvent("TUTORIAL_SKIPPED");
             skipTutorialButton.setVisibility(View.GONE);
         }
     });*/
	 
	 
	 try {
		    // Load game texts
		    final int chosenLanguage = Constants.LANG_ENGLISH;
		    gameCanvas.texts = new TextsLoaderTask(getResources(),
			    chosenLanguage).execute().get();
		    // Load game levels
		    gameCanvas.levels = new LevelsLoaderTask(getResources()).execute()
			    .get();

		} catch (InterruptedException e) {

		} catch (ExecutionException e) {

		}
		 setVolumeControlStream(AudioManager.STREAM_MUSIC);
		 
		 
		 final  AdColonyVideoAd ad = new AdColonyVideoAd( ZONE_ID ).withListener( this );
		 ad.show();
	      /*  new java.util.Timer().schedule( 
	                new java.util.TimerTask() {
	                    @Override
	                    public void run() {
	                    	System.out.println("corre ad show app");
	                    	 ad.show();
	                    }
	                }, 
	                1500 
	        );*/
	       
    }

    public void showAdWhirl() {
	runOnUiThread(new Runnable() {
	    public void run() {
		//sgAdView.setVisibility(View.VISIBLE);
	    }
	});
    }
    

    public void hideAdWhirl() {
        runOnUiThread(new Runnable() {
            public void run() {
               // sgAdView.setVisibility(View.GONE);
            }
        });
    }

    public void showButtonSkipTutorial() {
        runOnUiThread(new Runnable() {
            public void run() {
                //skipTutorialButton.setVisibility(View.VISIBLE);
            }
        });
    }
    
    public void hideLoadingScreen() {
	runOnUiThread(new Runnable() {
	    public void run() {
		loadingScreen.setVisibility(View.GONE);
		loadingScreen = null;
		System.gc();
	    }
	});
    }


    // Listener that's called when we finish querying the items we own
    IabHelper.QueryInventoryFinishedListener mGotInventoryListener = new IabHelper.QueryInventoryFinishedListener() {
	public void onQueryInventoryFinished(IabResult result,
		Inventory inventory) {
	    if (result.isFailure()) {
		return;
	    }

	    /*if (inventory.hasPurchase(Constants.HF3_NO_ADS)) {
	    	gameCanvas.isNoAdsItemPurchased = true;
                // mHelper.consumeAsync(inventory.getPurchase(Constants.SKU_BUY),
                // mConsumeFinishedListener);
		return;
	    }*/
	    Purchase gasPurchase = inventory.getPurchase(Constants.SKU_BUY);
        if (gasPurchase != null) {
            mHelper.consumeAsync(inventory.getPurchase(Constants.SKU_BUY), mConsumeFinishedListener);
            return;
        }

	}
    };

    public void buyInGame() {
	Log.d(TAG, "buyInGame() SKU_BUY: " + Constants.SKU_BUY);
	//Workaround to avoid IllegalStateException
	
	mHelper.launchPurchaseFlow(this, Constants.SKU_BUY, RC_REQUEST,
		mPurchaseFinishedListener, "");
    }

    
    // Callback for when a purchase is finished
    IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener() {

        public void onIabPurchaseFinished(IabResult result, Purchase purchase) {
            Log.d(TAG, "onIabPurchaseFinished() SKU_BUY: " + Constants.SKU_BUY);
            if (result.isFailure()) {
                Log.d(TAG, "Error purchasing: " + result);
                return;
            }
            String currentSKU = purchase.getSku();

            if (currentSKU.equals(Constants.SKU_BUY)
                    && !currentSKU.equals(Constants.HF3_NO_ADS)) {
                mHelper.consumeAsync(purchase, mConsumeFinishedListener);

            }
            Toast.makeText(getApplicationContext(),
                    "Congrats!! Your purchase was succesful!",
                    Toast.LENGTH_LONG).show();

        }
    };

    // Called when consumption is complete
    IabHelper.OnConsumeFinishedListener mConsumeFinishedListener = new IabHelper.OnConsumeFinishedListener() {
	public void onConsumeFinished(Purchase purchase, IabResult result) {
	    Log.d(TAG, "onConsumeFinished() ");
	    if (result.isSuccess()) {
		gameCanvas.gameThread.payPurcharse();
	    }
	}
    };

    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent msg) {
	gameCanvas.onKeyDown(keyCode, msg);
	return true;
    }
    
    public void createNotificationDaily(long timeServer){
            	
        	Intent myIntent = new Intent(this , NotificationDailyService.class);
            AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
            
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    		
            Calendar calendar = Calendar.getInstance();
         
           alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis() + 24*60*60*1000, 24*60*60*1000 , pendingIntent); ///set repeating every 24 hours

     	}
        
       // private Timer timer=new Timer();
    	
    	public void createNotificationCrops(long time){
    		     Intent myIntent = new Intent(this , NotificationCropService.class);
    			  AlarmManager alarmManager =
    			  (AlarmManager)getSystemService(ALARM_SERVICE); 
    			  
    			  PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    			  
    			  Calendar calendar = Calendar.getInstance();
    			  alarmManager.set(AlarmManager.RTC_WAKEUP,  calendar.getTimeInMillis() + time,
    			  pendingIntent);
    	}

    
    public void cancelNotifications(){
   	 String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);
        mNotificationManager.cancelAll();
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        Intent myIntent = new Intent(this , NotificationGameActivity.class);
        PendingIntent  pendingIntent = PendingIntent.getActivity(this, 0, myIntent, 0);
        alarmManager.cancel(pendingIntent);
      
        
        
        
        Intent myIntent3 = new Intent(this , NotificationDailyService.class);
        PendingIntent  pendingIntent3 = PendingIntent.getBroadcast(this, 0, myIntent3, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.cancel(pendingIntent3);
        
        Intent myIntent4 = new Intent(this , NotificationCropService.class);
        PendingIntent  pendingIntent4 = PendingIntent.getBroadcast(this, 0, myIntent4, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.cancel(pendingIntent4);
   }

    @Override
    protected Dialog onCreateDialog(int id) {
	switch (id) {
	case DIALOG_INFO:
	  //  return buildInfoDialog(this);
	}
	return null;
    }

    public Dialog buildInfoDialog(final Context mCtx) {
        final Dialog dialog = new Dialog(MyLittleFarm2Activity.this);
    //    dialog.setContentView(R.layout.dialog_refunds);
                
	Resources res = mCtx.getResources();	
	String version = "";
	
	try {
	    version = mCtx.getPackageManager().getPackageInfo(
		    mCtx.getPackageName(), 0).versionName;
	} catch (NameNotFoundException e) {
	    Log.e(TAG, "Could not get the package name!");
	}

	StringBuilder titleDialogInfo = new StringBuilder().append(res
		.getString(R.string.app_name) + " v" + version + "\n");

	dialog.setTitle(titleDialogInfo);
	dialog.setCancelable(true);
	
	String textInDialog = "";

	if (iMEI == null && androidId != null && !androidId.equals("")) {
	    textInDialog = String.format(res.getString(R.string.android_id_label), androidId);
	}

	if (iMEI != null && !iMEI.equals("")) {
	    textInDialog = String.format(res.getString(R.string.imei_label), iMEI);
	}
        
       /* TextView androidIdText =  (TextView) dialog.findViewById(R.id.text_device_id);
        androidIdText.setText(textInDialog);
        
        ImageButton buttonCheckRefunds =  (ImageButton) dialog.findViewById(R.id.button_refunds);
        buttonCheckRefunds.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View paramView) {
                dialog.dismiss();
                invokeRefundsTask(iMEI, androidId);        
            }
           
        });
        
        Button buttonOk =  (Button) dialog.findViewById(R.id.dialog_btn_ok);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View paramView) {
                dialog.dismiss();
            }
        });*/
        
        return dialog;
    }
    
    private void invokeRefundsTask(String iMEI, String androidId) {
        try {
            foundRefunds = new CheckRefundsTask(this, iMEI, androidId)
            .execute(Constants.REFUND_ALL).get();
        } catch (InterruptedException e) {
           
        } catch (ExecutionException e) {
           
        }
        
    }
    
    public void refillValuesFound() {
        boolean isSomethingRefilled = false;

        gameCanvas.quantitySeeds += foundRefunds[0];
        gameCanvas.quantityExp += foundRefunds[1];
        gameCanvas.quantityCoins += foundRefunds[2];
        gameCanvas.quantityDiamonds += foundRefunds[3];

        for (int i = 0; i < foundRefunds.length; i++) {
            if (foundRefunds[i] != 0) {
                isSomethingRefilled = true;
            }
        }
        if (!isSomethingRefilled) {
            Toast.makeText(getApplicationContext(),
                    getResources().getString(R.string.no_refunds_found),
                    Toast.LENGTH_SHORT).show();
        } else {
            gameThread.saveGame();
            String sRefundsFound = getResources().getString(
                    R.string.refunds_found);
            sRefundsFound = String.format(sRefundsFound, foundRefunds[0],
                    foundRefunds[1], foundRefunds[2], foundRefunds[3]);
            Toast.makeText(getApplicationContext(), sRefundsFound,
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onDestroy() {
	super.onDestroy();
	if (mHelper != null) {
	    mHelper.dispose();
	}
	mHelper = null;
    }

    @Override
    protected void onResume() {
	super.onResume();
	Log.e(TAG, "onResume");
	//AdjustIo.onResume("wlq3mkqdj2v5", this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

	Log.e(TAG, "onActivityResult() requestCode: " + requestCode
		+ ", resultCode: " + resultCode);
	if (!mHelper.handleActivityResult(requestCode, resultCode, data)) {
	    Log.d(TAG, "cleared the launch flow");
	    // not handled, so handle it ourselves (here's where you'd
	    // perform any handling of activity results not related to in-app
	    // billing...
	    super.onActivityResult(requestCode, resultCode, data);
	}
    }

    @Override
    protected void onPause() {
	super.onPause();
	Log.e(TAG, "onPause");
	//AdjustIo.onPause();
    }

    @Override
    protected void onStop() {
	super.onStop();
	Log.e(TAG, "onStop");
    }

    @Override
    protected void onStart() {
	super.onStart();
	//FlurryAgent.onStartSession(this, "SB6ZGJ3SWRPX73XCPDPX");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
	super.onSaveInstanceState(outState);
    }

    /*********************************
     * 
     * Legacy Facebook SDK integration
     * 
     *********************************/

   /* protected void inviteFacebookFriends() {
	Constants.pressedMarket = true;
	
	
     
	
	Bundle parameters = new Bundle();
	parameters.putString("message", "I am playing this awesome game!");
	Utility.mFacebook.dialog(this, "apprequests", parameters,
		new Facebook.DialogListener() {
		    @Override
		    public void onComplete(Bundle values) {
			Toast toast = Toast.makeText(getApplicationContext(),
				"Game request sent!", Toast.LENGTH_SHORT);
			toast.show();
		    }

		    @Override
		    public void onFacebookError(FacebookError e) {
			Log.e(TAG, "Error sending request", e);
			Toast.makeText(getApplicationContext(),
				"Error sending the game request",
				Toast.LENGTH_SHORT).show();
		    }

		    @Override
		    public void onError(DialogError e) {
			Log.e(TAG, "Error sending request", e);
		    }

		    @Override
		    public void onCancel() {
			Toast.makeText(getApplicationContext(),
				"Game request cancelled", Toast.LENGTH_SHORT)
				.show();
		    }
		});
    }*/

   /* protected void postOnMyWall(boolean mission, int nMission) {
	Constants.pressedMarket = true;

	String msg = "reached Level " + (nMission + 1);
	if (mission) {
	    msg = "reached Mission " + (nMission + 1);
	}

	Bundle params = new Bundle();
	params.putString("caption",
		getApplicationContext().getString(R.string.app_name));
	params.putString("description", String.format(getApplicationContext()
		.getString(R.string.wallpost), msg));
	params.putString("picture", Utility.HACK_ICON_URL);
	params.putString("link", "http://goo.gl/Kd7LI");
	params.putString("name", "Join my island in My Little Farm 2!");

	Utility.mFacebook.dialog(this, "feed", params,
		new UpdateStatusListener());
	// String access_token = Utility.mFacebook.getAccessToken();

    }*/

    /*public final class LoginDialogListener implements DialogListener {
	@Override
	public void onComplete(Bundle values) {
	    SessionEvents.onLoginSuccess();
	    if (gameThread.facebookAction == Constants.FACEBOOK_INVITE_FRIENDS) {
		inviteFacebookFriends();
	    } else if (gameThread.facebookAction == Constants.FACEBOOK_POST_LEVELUP) {
		postOnMyWall(false, gameThread.getCurrentLevel());
	    } else if (gameThread.facebookAction == Constants.FACEBOOK_POST_MISSION) {
		// FIXME post the actual mission
		postOnMyWall(true, 1);
	    }

	}

	@Override
	public void onFacebookError(FacebookError error) {
	    SessionEvents.onLoginError(error.getMessage());
	}

	@Override
	public void onError(DialogError error) {
	    SessionEvents.onLoginError(error.getMessage());
	}

	@Override
	public void onCancel() {
	    SessionEvents.onLoginError("Action Canceled");
	}
    }

    public class FriendsRequestListener extends BaseRequestListener {
	protected JSONArray jsonArray;

	@Override
	public void onComplete(final String response, final Object state) {
	    
	    if (Utility.profilePics == null) {
		Utility.profilePics = new FriendsGetProfilePics();
	    }

	    try {
		jsonArray = new JSONArray(response);
		gameThread.friendsFacebok = jsonArray.length();
		int backupFriends = gameThread.totalfriends;
		gameThread.totalfriends = gameThread.friendsFacebok
			+ gameThread.fakeFriends;
		for (int i = 0; i < gameThread.totalfriends - backupFriends; i++) {
		    gameThread.restValueMission(Constants.ADD_HELPER, 0);
		}

		JSONObject jsonObject = null;
		for (int i = gameThread.indexProFace; i < gameThread.indexProFace + 3; i++) {
		    try {
			jsonObject = jsonArray.getJSONObject(i);
		    } catch (JSONException e1) {
			return;
		    }

		    Profile profi = new Profile();

		    profi.setName(jsonObject.getString("name"));
		    profi.setUuid(jsonObject.getString("uid"));
		    profi.setPicture(Utility.profilePics.getImage(
			    jsonObject.getString("uid"),
			    jsonObject.getString("pic_square")));
		    gameThread.profilesFace.add(profi);
		}
	    } catch (JSONException e) {
		return;
	    }
	    
	}

	public void onFacebookError(FacebookError error) {

	}
    }*/

  /*  public class UpdateStatusListener extends BaseDialogListener {
	@Override
	public void onComplete(Bundle values) {
	    final String postId = values.getString("post_id");
	    if (postId != null) {
		Toast toast = Toast.makeText(getApplicationContext(),
			"The event was shared on your timeline!",
			Toast.LENGTH_SHORT);
		toast.show();
		gameThread.rewardDiamonds(1);
	    } else {
		Toast toast = Toast.makeText(getApplicationContext(),
			"No post made", Toast.LENGTH_SHORT);
		toast.show();
	    }

	}

	@Override
	public void onFacebookError(FacebookError error) {
	    Toast.makeText(getApplicationContext(),
		    "Facebook Error: " + error.getMessage(), Toast.LENGTH_SHORT)
		    .show();
	}

	@Override
	public void onCancel() {
	    Toast toast = Toast.makeText(getApplicationContext(),
		    "Update status cancelled", Toast.LENGTH_SHORT);
	    toast.show();
	}
    }*/
    /*
     * End Facebook
     */
    
    public void closeGame() {
	this.finish();
	System.runFinalizersOnExit(true);
	System.exit(0);
    }

    public void showMoreGamesButton() {
        runOnUiThread(new Runnable() {            
            @Override
            public void run() {
                //sgMoreGamesButton.setVisibility(View.VISIBLE);
            }
        });
    }
    
    public void hideMoreGamesButton() {
        runOnUiThread(new Runnable() {            
            @Override
            public void run() {
               // sgMoreGamesButton.setVisibility(View.GONE);
            }
        });
    }

    public void hideButtonSkipTutorial() {
        runOnUiThread(new Runnable() {            
            @Override
            public void run() {
                //skipTutorialButton.setVisibility(View.GONE);
            }
        });
    }
    
    //Ad Started Callback - called only when an ad successfully starts playing
    public void onAdColonyAdStarted( AdColonyAd ad )
    {
  	Log.d("AdColony", "onAdColonyAdStarted");
    }

    //Ad Attempt Finished Callback - called at the end of any ad attempt - successful or not.
    public void onAdColonyAdAttemptFinished( AdColonyAd ad )
    {
  	// You can ping the AdColonyAd object here for more information:
  	// ad.shown() - returns true if the ad was successfully shown.
  	// ad.notShown() - returns true if the ad was not shown at all (i.e. if onAdColonyAdStarted was never triggered)
  	// ad.skipped() - returns true if the ad was skipped due to an interval play setting
  	// ad.canceled() - returns true if the ad was cancelled (either programmatically or by the user)
  	// ad.noFill() - returns true if the ad was not shown due to no ad fill.
  	  
      Log.d("AdColony", "onAdColonyAdAttemptFinished");
      System.out.println("debio finalizar");
      	if(gameCanvas.gameThread.isActiveColony()){
      		gameCanvas.stateColony = 1;
      	}
    }
    
    //Ad Availability Change Callback - update button text
    public void onAdColonyAdAvailabilityChange(boolean available, String zone_id) 
    {
    	//if (available) button_text_handler.post(button_text_runnable);
    	 Log.d("AdColony", "listo para cobrar");
    }

}