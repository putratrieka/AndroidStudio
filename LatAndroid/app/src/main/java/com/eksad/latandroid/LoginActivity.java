package com.eksad.latandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.eksad.latandroid.utility.Constanta;

public class LoginActivity extends AppCompatActivity {
    private Context context = this;
    private int counterBack = 1;

    // Deklarasi variabel
    private EditText inputUsername, inputPassword;
    private CheckBox checkBoxRemember;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inisialisasi
        inputUsername = (EditText) findViewById(R.id.inputUsername);
        inputPassword = (EditText) findViewById(R.id.inputPassword);
        checkBoxRemember = (CheckBox) findViewById(R.id.checkBoxRemember);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);

        // tambahkan action listener
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // deklarasikan aksinya
                validasiInput();
            }
        });
    }

    private void validasiInput(){
        String valueUsername = inputUsername.getText().toString().trim();
        String valuePassword = inputPassword.getText().toString().trim();

        if(valueUsername.length() == 0){
            Toast.makeText(context, "Username Masih Kosong", Toast.LENGTH_SHORT).show();
        }else if ((valuePassword.equals(""))){
            Toast.makeText(context, "Password Masih Kosong", Toast.LENGTH_SHORT).show();
        }else{
            // Validasi Sukses
            Intent intent = new Intent(context, HomeActivity.class);
            intent.putExtra(Constanta.ID_EXTRA_USERNAME, valueUsername);
            intent.putExtra(Constanta.ID_EXTRA_PASSWORD, valuePassword);

            startActivity(intent);

        }
    }

    // confirm message
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        if (counterBack < 2){
            // message box
            Toast.makeText(context,
                    "Tekan Back Sekali Lagi Untuk Keluar",
                    Toast.LENGTH_SHORT).show();
            counterBack ++;
        }else if (counterBack == 2){
            finish();
        }
    }
}
