package de.softgames.en.mylittlefarm2.sound;

/*
 * A pretty simple audio class 
 * Only used for playing background music.. best to use SoundPool for sound effects
 */


import android.content.Context;
import android.media.MediaPlayer;



public class Tune {

	// the actual media player object
	private MediaPlayer 			mp;
	
	// volume setting 
	float							MyVolume = 1.0f;
	

	/**
	 * Main Constructor
	 * 
	 * @param context		Context this instance runs in (used for loading)
	 * @param soundEffect	the resource ID for the music
	 */
	public Tune(Context context, int soundEffect) {
        playSong(soundEffect,context);
    }
	
	
	
	/**
	 * Play the specified file
	 *
	 * @param fName 	the resource id to load
	 * @param context 	
	 */
	public void playSong(int fName,Context context) {
		if (mp!=null) destroy();																						// Free previous player if required
		mp = MediaPlayer.create(context, fName);
	}
	
	
	public void setVolume(float newVolume) {
		MyVolume=newVolume;
		if (mp.isPlaying()) 
			mp.setVolume(MyVolume, MyVolume);
	}
	
	/**
	 * Play the audio file
	 *
	 * @param aLoop Loop the audio? true/false
	 */
	public void play(boolean aLoop) {
		if (mp==null) return;

		if (!mp.isPlaying()) {
			mp.setVolume(MyVolume, MyVolume);
			mp.seekTo(0);
			mp.setLooping(aLoop);
			mp.start();
		}
	}

	
	/**
	 * Stop the audio from playing
	 */
	public void stop() {
		if (mp==null) return;
		if (mp.isPlaying()) {
			mp.stop();
		}
	}


	/**
	* Destroy the player of this Tune object
	*/
	public void destroy() {
		try {
			if (mp!=null) {
				mp.stop();
				mp.release();
				mp=null;
			}
		}catch (Exception ex) {
			// oopsie
		}
	}	

}
