package com.example.contactactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.TextView;

public class KontakDetail extends AppCompatActivity {
    TextView nama, number, grup, bnBack;
    TextView btCall, btMess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontak_detail);

        bnBack = findViewById(R.id.back);
        nama = findViewById(R.id.name);
        number = findViewById(R.id.number);
        grup = findViewById(R.id.group);
        btCall = findViewById(R.id.bttncall);
        btMess = findViewById(R.id.bttnmessage);

        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            String getName = bundle.getString("name");
            String getNumber = bundle.getString("number");
            String getGroup = bundle.getString("group");

            nama.setText(getName);
            number.setText(getNumber);
            grup.setText(getGroup);

            btCall.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + getNumber));
                if (ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                    return;
                }
                startActivity(intent);
            });

            btMess.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("sms:" + getNumber));
                startActivity(intent);
            });

            bnBack.setOnClickListener(v -> {
                setResult(RESULT_OK, null);
                finish();
            });
        }
    }
}