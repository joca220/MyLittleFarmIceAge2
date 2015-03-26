package de.softgames.en.mylittlefarm2;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;


public class SoundUtil {

    private static final String TAG = SoundUtil.class.getSimpleName();

    public static final int SOUND_MISSION_COMPLETE = 1;
    public static final int SOUND_LEVEL_UP = 2;
    public static final int SOUND_ACHIEVEMENT_COMPLETE = 3;
    public static final int SOUND_CONSTRUCTION_PLACED = 4;
    public static final int SOUND_FEED_ANIMAL = 5;
    public static final int SOUND_CONSTRUCTION_BOOST = 6;
    public static final int SOUND_CONSTRUCTION_FINISHED = 7;
    public static final int SOUND_RANDOM_BACKGROUND_SOUND = 8;
    public static final int SOUND_RANDOM_BACKGROUND_SOUND2 = 9;
    public static final int SOUND_RANDOM_BACKGROUND_SOUND3 = 10;
    public static final int SOUND_BAKERY = 11;
    public static final int SOUND_CAKESHOP = 12;
    public static final int SOUND_ANIMAL_FOODMACHINE = 13;
    public static final int SOUND_DAIRY = 14;
    public static final int SOUND_SUGARFACTORY = 15;
    public static final int SOUND_TAILOR = 16;
    public static final int SOUND_WEAVING = 17;
    public static final int SOUND_MILL = 18;
    public static final int SOUND_GRILL = 19;
    public static final int SOUND_GOURMET = 20;
    public static final int SOUND_JUICERY = 21;
    public static final int SOUND_CHICKEN = 22;
    public static final int SOUND_COW = 23;
    public static final int SOUND_SHEEP = 24;
    public static final int SOUND_PIG = 25;
    public static final int SOUND_GOAT = 26;

    public static final int SOUND_EARNED_GOLD = 27;
    public static final int SOUND_EARNED_DIAMONDS = 28;
    public static final int SOUND_EARNED_XP = 29;
    public static final int SOUND_SPENT_DIAMONDS = 30;
    public static final int SOUND_SPENT_GOLD = 31;
    public static final int SOUND_PLOW = 32;
    public static final int SOUND_HARVEST = 33;
    public static final int SOUND_PLANT = 34;
    public static final int SOUND_CLICK = 35;
    public static final int SOUND_BUILDING_UPGRADE = 36;
    public static final int SOUND_REMOVE_GRASS = 37;
    public static final int SOUND_REMOVE_STONE = 38;
    public static final int SOUND_REMOVE_TREE = 39;
    public static final int SOUND_AREA_UNLOCKED = 40;
    
    public static final int SOUND_GOOSE = 41;
    public static final int SOUND_DUCK = 42;
    public static final int SOUND_HORSE = 43;
    public static final int SOUND_ANGORA = 44;

    private static AudioManager audio;
    private static MediaPlayer mp;
   // private static Resources mRes;

    public static void playSound(Context context, int type,
            MyLittleFarm2Activity main) {
    	main.gameCanvas.gameThread.sound(context,type);
    }
   /* public static void playSound(Context context, int type,
            MyLittleFarm2Activity main) {
        mRes = context.getResources();
        if (Constants.SOUND_ON) {
            if (audio == null) {
                mp = new MediaPlayer();
                audio = (AudioManager) main
                        .getSystemService(Context.AUDIO_SERVICE);
            }
            AssetFileDescriptor assetFileDescr = null;

            try {
                switch (type) {
                case 0:

                    break;

                case SOUND_MISSION_COMPLETE:
                    assetFileDescr = mRes
                            .openRawResourceFd(R.raw.mission_complete);
                    break;

                case SOUND_LEVEL_UP:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.level_up);
                    break;

                case SOUND_ACHIEVEMENT_COMPLETE:
                    assetFileDescr = mRes
                            .openRawResourceFd(R.raw.achievement_complete);
                    break;

                case SOUND_CONSTRUCTION_PLACED:
                    assetFileDescr = mRes
                            .openRawResourceFd(R.raw.construction_placed);
                    break;
                case SOUND_FEED_ANIMAL:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.feed_animal);
                    break;
                case SOUND_CONSTRUCTION_BOOST:
                    assetFileDescr = mRes
                            .openRawResourceFd(R.raw.construction_boost);
                    break;
                case SOUND_CONSTRUCTION_FINISHED:
                    assetFileDescr = mRes
                            .openRawResourceFd(R.raw.construction_finished);
                    break;

                case SOUND_RANDOM_BACKGROUND_SOUND:
                    assetFileDescr = mRes
                            .openRawResourceFd(R.raw.random_background_sound);
                    break;
                case SOUND_RANDOM_BACKGROUND_SOUND2:
                    assetFileDescr = mRes
                            .openRawResourceFd(R.raw.random_background_sound2);
                    break;
                case SOUND_RANDOM_BACKGROUND_SOUND3:
                    assetFileDescr = mRes
                            .openRawResourceFd(R.raw.random_background_sound3);
                    break;

                case SOUND_BAKERY:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.bakery);
                    break;
                case SOUND_CAKESHOP:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.cakeshop);
                    break;
                case SOUND_ANIMAL_FOODMACHINE:
                    assetFileDescr = mRes
                            .openRawResourceFd(R.raw.animal_foodmachine);
                    break;
                case SOUND_DAIRY:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.dairy);
                    break;

                case SOUND_SUGARFACTORY:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.sugarfactory);
                    break;
                case SOUND_TAILOR:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.tailor);
                    break;
                case SOUND_WEAVING:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.weaving);
                    break;
                case SOUND_MILL:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.mill);
                    break;
                case SOUND_GRILL:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.grill);
                    break;
                case SOUND_GOURMET:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.gourmet);
                    break;
                case SOUND_JUICERY:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.juicery);
                    break;

                case SOUND_CHICKEN:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.chicken);
                    break;
                case SOUND_COW:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.cow);
                    break;
                case SOUND_SHEEP:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.sheep);
                    break;
                case SOUND_PIG:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.pig);
                    break;
                case SOUND_GOAT:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.goat);
                    break;

                case SOUND_EARNED_GOLD:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.earn_money);
                    break;
                case SOUND_EARNED_DIAMONDS:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.diamond_earn);
                    break;
                case SOUND_EARNED_XP:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.exp_earn);
                    break;
                case SOUND_SPENT_DIAMONDS:
                    assetFileDescr = mRes
                            .openRawResourceFd(R.raw.diamond_spent);
                    break;
                case SOUND_SPENT_GOLD:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.gold_spent);
                    break;
                case SOUND_PLOW:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.plow_field);
                    break;
                case SOUND_HARVEST:
                    assetFileDescr = mRes
                            .openRawResourceFd(R.raw.harvest_crops);
                    break;
                case SOUND_PLANT:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.plant_crops);
                    break;
                case SOUND_CLICK:
                    assetFileDescr = mRes
                            .openRawResourceFd(R.raw.click_navigation);
                    break;
                case SOUND_BUILDING_UPGRADE:
                    assetFileDescr = mRes
                            .openRawResourceFd(R.raw.upgrade_building);
                    break;
                case SOUND_REMOVE_GRASS:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.remove_grass);
                    break;
                case SOUND_REMOVE_STONE:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.remove_stone);
                    break;
                case SOUND_REMOVE_TREE:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.remove_tree);
                    break;

                case SOUND_AREA_UNLOCKED:
                    assetFileDescr = mRes.openRawResourceFd(R.raw.unlock_area);
                    break;
                }

                if (assetFileDescr != null && mp != null && type != 0) {

                    try {

                        mp.reset();
                        mp.setDataSource(assetFileDescr.getFileDescriptor(),
                                assetFileDescr.getStartOffset(),
                                assetFileDescr.getLength());
                        mp.prepare();
                        mp.start();
                        
                        mp.setOnCompletionListener(new OnCompletionListener() {

                            public void onCompletion(MediaPlayer arg0) {
                            	mp.stop();

                            }
                        });
                    } catch (IllegalStateException e) {
                        mp.reset();
                    }

                }
            } catch (Exception e) {

            }
        }
    }*/
    
    

    public static void volumeUp( MyLittleFarm2Activity main) {
    	if (audio == null) {
    		   audio = (AudioManager) main.getSystemService(Context.AUDIO_SERVICE);
    	}
        if (audio != null) {
            audio.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                    AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
        }
    }

    public static void volumeDown(MyLittleFarm2Activity main) {
    	if (audio == null) {
 		   audio = (AudioManager) main.getSystemService(Context.AUDIO_SERVICE);
    	}
    	
        if (audio != null) {
            audio.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                    AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
        }
    }

    public static void stopMediaPlayer() {
        if (mp != null) {
            mp.pause();
            mp.stop();
        }
    }

    public static void soundManinGame(Context mContext,
            MyLittleFarm2Activity main) {

        switch (UtilSoftgames.random(1, 3)) {
        case 1:
            playSound(mContext, 8, main);
            break;
        case 2:
            playSound(mContext, 9, main);
            break;
        case 3:
            playSound(mContext, 10, main);
            break;
        default:
            Log.e(TAG, "this should not happen...");
            break;
        }

    }

    public static void soundAnimal(Context mContext, int type,
            MyLittleFarm2Activity main) {
        switch (type) {
        case Constants.ANIMAL_CHICKEN:
            playSound(mContext, 22, main);
            break;
        case Constants.ANIMAL_COW:
            playSound(mContext, 23, main);
            break;
        case Constants.ANIMAL_SHEEP:
            playSound(mContext, 24, main);
            break;
        case Constants.ANIMAL_PIG:
            playSound(mContext, 25, main);
            break;
        case Constants.ANIMAL_GOAT:
            playSound(mContext, 26, main);
            break;
        case Constants.ANIMAL_GOOSE:
        	playSound(mContext, 41, main);
        	break;
        case Constants.ANIMAL_DUCK:
        	 playSound(mContext, 42, main);
        	break;
        case Constants.ANIMAL_HORSE:
        	 playSound(mContext, 43, main);
        	break;
        case Constants.ANIMAL_ANGORA:
        	 playSound(mContext, 44, main);
        	break;
        default:
            Log.e(TAG, "this should not happen...");
            break;
        }
    }

    public static void soundBuilding(Context mContext, int type,
            MyLittleFarm2Activity main) {

        switch (type) {
        case Constants.BAKERY:
            playSound(mContext, 11, main);

            break;
        case Constants.CAKE:
            playSound(mContext, 12, main);

            break;
        case Constants.FEED_MILL:
            playSound(mContext, 13, main);
            break;
        case Constants.DAIRY:
            playSound(mContext, 14, main);
            break;

        case Constants.SUGAR_FACTORY:
            playSound(mContext, 15, main);
            break;
        case Constants.TAILOR:
            playSound(mContext, 16, main);
            break;
        case Constants.WEAVING_BUILDING:
            playSound(mContext, 17, main);
            break;
        case Constants.WIND_MILL:
            playSound(mContext, 18, main);
            break;
        case Constants.GRILL:
            playSound(mContext, 19, main);
            break;
        case Constants.RESTAURANT:
            playSound(mContext, 20, main);
            break;
        case Constants.FRUIT_SMASHER:
            playSound(mContext, 21, main);
            break;
        }
    }
}
