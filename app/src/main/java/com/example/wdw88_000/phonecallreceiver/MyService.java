package com.example.wdw88_000.phonecallreceiver;

import android.app.Service;
import android.content.Intent;
import android.content.Context;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MyService extends Service {


    public MyService() {
    }

    public void onCreate(){
        super.onCreate();
        Log.v("Debug", "Inside onCreate()");
    }


    public int onStartCommand(Intent intent, int flags, int startId)
    {
        try {
            new DoBackgroundTask().execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        stopSelf();
        return  super.onStartCommand(intent, flags, startId);

    }


    private class DoBackgroundTask extends AsyncTask<Void, Void, Void> {
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                String string = "service was started!";
                File myFile = new File("/sdcard/mysdfile.txt");
                myFile.createNewFile();
                FileOutputStream fOut = new FileOutputStream(myFile);
                OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
                myOutWriter.append(string);
                myOutWriter.close();
                fOut.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("Debug", "Inside the onStartCommand");
    }

    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
