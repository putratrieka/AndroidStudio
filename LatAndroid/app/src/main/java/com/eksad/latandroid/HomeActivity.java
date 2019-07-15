package com.eksad.latandroid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.eksad.latandroid.utility.Constanta;


public class HomeActivity extends AppCompatActivity {

    private Context context = this;
    private TextView labelUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //inisialisasi
        labelUsername = (TextView) findViewById(R.id.labelUsername);


        // tangkap intendExtra
        // tangkap username
        if (getIntent().getStringExtra(Constanta.ID_EXTRA_USERNAME) != null){
            String username = getIntent().getStringExtra(Constanta.ID_EXTRA_USERNAME);
            labelUsername.setText(username);

        }
    }
}
