package de.softgames.en.mylittlefarm2;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;


/**
 * AsyncTask to check the server for possible refunds. The order of refunds is
 * the following: ID; IMEI/ANDROID_ID; FOOD; XP; COINS; DIAMONDS
 * 
 * @author rolandcastillo
 * 
 */
public class CheckRefundsTask extends AsyncTask<Integer, Void, Integer[]> {

    private static final String TAG = CheckRefundsTask.class.getSimpleName();
    private static final String URL = "http://www.softgames.de/download/mobile/mlf2/master_refunds.txt";
   
    private MyLittleFarm2Activity activity;
    private String deviceId = "";
    private int typeOfRefundable;

    private List<String> ids = new ArrayList<String>();
    private List<String> imeisToRefund = new ArrayList<String>();
    private List<String> foodToRefill = new ArrayList<String>();
    private List<String> xpToRefill = new ArrayList<String>();
    private List<String> coinsToRefill = new ArrayList<String>();
    private List<String> diamondsToRefill = new ArrayList<String>();

    public CheckRefundsTask(MyLittleFarm2Activity activity, String iMEI, String androidId) {
        super();
        this.activity = activity;

        if (iMEI != null && !iMEI.equals("")) {
            this.deviceId = iMEI;
        } else if (androidId != null && !androidId.equals("")) {
            this.deviceId = androidId;
        }
    }

    @Override
    protected Integer[] doInBackground(Integer... params) {
        typeOfRefundable = params[0];
        try {
            switch (typeOfRefundable) {
            
            case Constants.REFUND_ALL:
                return loadRefundsFromServer(URL);

            default:
                break;
            }
        } catch (Exception e) {
            Log.e(TAG, "Error refunding...", e);
        }

        return null;
    }

    private Integer[] loadRefundsFromServer(String sUrl) {
        Log.e(TAG, "loadRefundsFromServer");
        Integer[] amounts = new Integer[] { 0, 0, 0, 0 };
        int found = -1;

        try {
            // Create a URL for the desired page
            URL url = new URL(sUrl);
            // Read all the text returned by the server
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    url.openStream()));
            String str;

            while ((str = in.readLine()) != null) {
                try {
                    String[] data = str.split(";");
                    ids.add(data[0]);
                    imeisToRefund.add(data[1]);
                    foodToRefill.add(data[2]);
                    xpToRefill.add(data[3]);
                    coinsToRefill.add(data[4]);
                    diamondsToRefill.add(data[5]);

                } catch (Exception e) {
                    break;
                }
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }

        for (String imeiToRefund : imeisToRefund) {
            if (imeiToRefund.equals(deviceId)) {
                found = imeisToRefund.indexOf(imeiToRefund);
                if (found != -1) {
                    String register = "-1";

                    FileInputStream fis = null;
                    try {
                        fis = activity.openFileInput(ids.get(found));
                        DataInputStream dis = new DataInputStream(fis);
                        register = dis.readUTF();
                    } catch (Exception e) {
                        Log.e(TAG, "File does not exist");
                    } finally {
                        try {
                            if (fis != null) {
                                fis.close();
                            }
                        } catch (Exception e) {
                        }
                    }

                    if (register.equals("-1")) {
                        amounts[0] = Integer.parseInt(foodToRefill.get(found)
                                .trim());
                        amounts[1] = Integer.parseInt(xpToRefill.get(found)
                                .trim());
                        amounts[2] = Integer.parseInt(coinsToRefill.get(found)
                                .trim());
                        amounts[3] = Integer.parseInt(diamondsToRefill.get(
                                found).trim());

                        FileOutputStream fos = null;
                        try {
                            fos = activity.openFileOutput(ids.get(found),
                                    Context.MODE_PRIVATE);
                            DataOutputStream dos = new DataOutputStream(fos);
                            dos.writeUTF("Package delivered");
                            dos.flush();
                            dos.close();
                        } catch (Exception e) {
                        } finally {
                            try {
                                if (fos != null) {
                                    fos.close();
                                }
                            } catch (Exception exc) {
                            }
                        }
                        break;
                    }
                }
            }
        }
        return amounts;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG, "the id checked is: " + deviceId);
    }

    @Override
    protected void onPostExecute(Integer[] result) {
        super.onPostExecute(result);
        activity.refillValuesFound();
        Log.e(TAG, "The refilled amount for the id: " + deviceId + " is "
                + arrayToString(result));
    }

    private String arrayToString(Integer[] result) {
        String sResult = "{";
        for (Integer integer : result) {
            sResult += integer.toString() + ", ";
        }
        return sResult + "}";
    }
    

}
