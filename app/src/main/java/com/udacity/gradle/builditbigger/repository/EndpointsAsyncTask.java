package com.udacity.gradle.builditbigger.repository;

import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.ProgressBarVisibility;
import com.udacity.gradle.builditbigger.ShowJokeListener;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {

    private static final String TAG = "EndpointsAsyncTask";
    private static MyApi myApiService = null;

    private ProgressBarVisibility progressBarVisibility;
    private ShowJokeListener showJokeListener;

    public EndpointsAsyncTask(ShowJokeListener showJokeListener, ProgressBarVisibility progressBarVisibility) {
        this.progressBarVisibility = progressBarVisibility;
        this.showJokeListener = showJokeListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBarVisibility.showProgressBar();
    }

    @Override
    protected String doInBackground(Void... context) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getDescription();

        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
            return null;
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        progressBarVisibility.hideProgressBar();
        showJokeListener.openJokeActivity(joke);
    }
}
