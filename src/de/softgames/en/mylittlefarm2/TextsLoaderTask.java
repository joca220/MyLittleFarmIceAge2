package de.softgames.en.mylittlefarm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.util.Log;

public class TextsLoaderTask extends AsyncTask<Void, Void, String[]> {
    private static final String TAG = TextsLoaderTask.class.getSimpleName();
    private int mLanguage;
    private Resources mRes;
    private String[] texts = new String[Constants.ARRAY_TEXTS_MAX_LINES];

    public TextsLoaderTask(Resources mRes, int language) {
	this.mLanguage = language;
	this.mRes = mRes;
    }

    // Decode image in background.
    @Override
    protected String[] doInBackground(Void... voids) {
	try {
	    return loadTexts();
	} catch (IOException e) {
	    Log.e(TAG, "Error loading texts");
	}
	return null;
    }


    @Override
    protected void onPreExecute() {
	super.onPreExecute();
    }

    private String[] loadTexts()
	    throws IOException {

	InputStream inputStream = null;

	switch (mLanguage) {
	case Constants.LANG_ENGLISH:
	    inputStream = mRes.openRawResource(R.raw.texts_en);
	    break;

	}

	BufferedReader reader = new BufferedReader(new InputStreamReader(
		inputStream));
	int indexText = 0;
	try {
	    String line;
	    while ((line = reader.readLine()) != null) {
		texts[indexText] = line;
		indexText++;

	    }
	} finally {
	    reader.close();
	}
	return texts;
    }
    
}