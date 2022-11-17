package com.lunatic.broadcastreceiver;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.widget.Toast;


public class MyReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        String TAG = "Goutam";

        //when screen is off
        if (Intent.ACTION_SCREEN_OFF.equals(intent.getAction())) {
            Toast.makeText(context, "Screen Off", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Screen Off");

        }

        //when screen is on
        if (Intent.ACTION_SCREEN_ON.equals(intent.getAction())) {
            Toast.makeText(context, "Screen Onn", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Screen Onn");

        }

        //when device is unlocked
        if (Intent.ACTION_USER_PRESENT.equals(intent.getAction())) {
            Toast.makeText(context, "Device is unlocked", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Device is unlocked");
        }

        //when device is locked
        if (!Intent.ACTION_USER_PRESENT.equals(intent.getAction())) {
            Toast.makeText(context, "Device is locked", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Device is locked");
        }

        //when internet is connected
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            NetworkInfo networkInfo = intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
            if (networkInfo != null && networkInfo.getDetailedState() == NetworkInfo.DetailedState.CONNECTED) {
                Toast.makeText(context, "Internet is connected", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Internet is connected");
            } else if (networkInfo != null && networkInfo.getDetailedState() == NetworkInfo.DetailedState.DISCONNECTED) {
                Toast.makeText(context, "No internet :(", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "No internet :(");
            }
        }

    }

}



