package com.droibit.automanaged.gac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.droibit.automanaged.gac.utils.GmsStrings;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.Wearable;

public class MainActivity extends AppCompatActivity
        implements ConnectionCallbacks, OnConnectionFailedListener, MessageApi.MessageListener {

    private GoogleApiClient mGoogleApiClient;
    private TextView mTextView;

    /** {@inheritDoc} */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                           .addApi(Wearable.API)
                           .addConnectionCallbacks(this)
                           //.addOnConnectionFailedListener(this)
                           .enableAutoManage(this, this)
                           .build();

        mTextView = ((TextView) findViewById(android.R.id.text1));
    }

    /** {@inheritDoc} */
    @Override
    protected void onPause() {
        super.onPause();

        if (mGoogleApiClient.isConnected()) {
            Wearable.MessageApi.removeListener(mGoogleApiClient, this);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void onConnected(Bundle connectionHint) {
        Log.d(BuildConfig.BUILD_TYPE, "#onConnected");

        mTextView.setText("Google Play services connected !!");

        Wearable.MessageApi.addListener(mGoogleApiClient, this);
    }

    /** {@inheritDoc} */
    @Override
    public void onConnectionSuspended(int cause) {
        Log.d(BuildConfig.BUILD_TYPE, "#onConnectionSuspended :" + cause);

        mTextView.setText("Google Play services suspended by " + GmsStrings.toSuspendedString(cause));
    }

    /** {@inheritDoc} */
    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        // Play Servicesがインストールされていないエラーは、
        // #enableAutoManage()にセットすると呼ばれた、
        Log.d(BuildConfig.BUILD_TYPE, "ErrorCode: " + connectionResult.getErrorCode());

        mTextView.setText("Error: " + GmsStrings.toConnectionErrorString(connectionResult));
    }

    /** {@inheritDoc} */
    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
    }

    public void launchOtherActivity(View v) {
        final Intent intent = new Intent(this, OtherActivity.class);
        startActivity(intent);
    }
}
