package com.example.my.weddingbingo;

import android.*;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Share extends AppCompatActivity {
    EditText edtphncall;
    String telNum;
    Button btncall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        edtphncall = (EditText) findViewById(R.id.edtphncall);
        btncall = (Button) findViewById(R.id.btncall);
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Insert Subject here");
                String app_url = "https://play.google.com/store/app/details?id=com.example.administrator";
                shareIntent.putExtra(Intent.EXTRA_TEXT, app_url);
                startActivity(Intent.createChooser(shareIntent, "Share via"));
            }
        });
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_home:
                        startActivity(new Intent(Share.this, Welcome.class));
                        //  mTextMessage.setText(R.string.title_home);
                        break;

                    case R.id.ic_dashboard:
                        Intent intent = new Intent(Share.this, Feedback.class);
                        startActivity(intent);
                        //  mTextMessage.setText(R.string.title_feedback);
                        break;
                    case R.id.ic_notifications:
                        Intent intent1 = new Intent(Share.this, About.class);
                        startActivity(intent1);
                        //  mTextMessage.setText(R.string.title_about_us);
                        break;
                }
                return false;
            }
        });
    }


    private void requesPermission() {
        ActivityCompat.requestPermissions(Share.this, new String[]{android.Manifest.permission.CALL_PHONE}, 1);

    }

}
