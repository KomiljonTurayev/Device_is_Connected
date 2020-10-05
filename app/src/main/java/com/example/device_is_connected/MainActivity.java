package com.example.device_is_connected;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnClick(View view) {
        
        if (isNetworkAvariable()){
            Toast.makeText(this, "Network Avariable", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Network Not Avariable", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isNetworkAvariable() {

        try {

            ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = null;

            if (manager != null) {
                networkInfo = manager.getActiveNetworkInfo();
            }
            return networkInfo != null && networkInfo.isConnected();

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return false;
    }

}