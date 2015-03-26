package de.softgames.en.mylittlefarm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.util.Log;

public class LevelsLoaderTask extends AsyncTask<Void, Void, String[]> {
    private static final String TAG = LevelsLoaderTask.class.getSimpleName();

    private Resources mRes;
    private String[] levels = new String[Constants.ARRAY_LEVELS_MAX_LINES];

    public LevelsLoaderTask(Resources mRes) {
	this.mRes = mRes;
    }

    @Override
    protected String[] doInBackground(Void... voids) {
	try {
	    return loadLevels();
	} catch (IOException e) {
	    Log.e(TAG, "Error loading levels");
	}
	return null;
    }

    @Override
    protected void onPreExecute() {
	super.onPreExecute();
    }

    private String[] loadLevels() throws IOException {

	InputStream inputStream = mRes.openRawResource(R.raw.mapanivel);
	BufferedReader reader = new BufferedReader(new InputStreamReader(
		inputStream));
	int indexTxtMap = 0;
	try {
	    String line;
	    while ((line = reader.readLine()) != null) {
		levels[indexTxtMap] = line;
		indexTxtMap++;
	    }
	} finally {
	    reader.close();
	}
	return levels;
    }
}