package de.softgames.en.mylittlefarm2;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

public class BitmapWorkerTask extends AsyncTask<String, Void, Bitmap> {
    private static final String TAG = BitmapWorkerTask.class.getSimpleName();
    private int mCanvasWidth;
    private int mCanvasHeight;
    private Resources res;
    private boolean isResizable = false;
    private String path = "";

    public BitmapWorkerTask(int width, int height, Resources mRes,
	    boolean resizable, Context context) {
	this.mCanvasWidth = width;
	this.mCanvasHeight = height;
	this.res = mRes;
	this.isResizable = resizable;
    }

    // Decode image in background.
    @Override
    protected Bitmap doInBackground(String... params) {
	path = params[0];
	return loadImageAssets(path, isResizable);

    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
	super.onPostExecute(bitmap);

    }

    @Override
    protected void onPreExecute() {
	super.onPreExecute();
    }

    protected Bitmap loadImageAssets(String name, boolean isResizable) {
	
	InputStream is = null;
	Bitmap asset = null;
	
	try {
	    is = res.getAssets().open(name);
	} catch (IOException e) {
	    Log.e(TAG, "Error loading " + name);
	}
	
	BitmapFactory.Options options = new BitmapFactory.Options();
	options.inPurgeable = true;
	options.inInputShareable = true;
	asset = BitmapFactory.decodeStream(is, null, options);

	if (isResizable) {	    
	    Log.d(TAG,
		    "loadImageAssets(" + name + ")");
	    asset = UtilSoftgames.resizeToCalculatedResolution(asset, mCanvasWidth, mCanvasHeight);
	}
	return asset;
    }

}