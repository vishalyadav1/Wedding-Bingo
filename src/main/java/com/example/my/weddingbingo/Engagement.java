package com.example.my.weddingbingo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Engagement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engagement);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_home:
                        startActivity(new Intent(Engagement.this, Welcome.class));
                        //  mTextMessage.setText(R.string.title_home);
                        break;

                    case R.id.ic_dashboard:
                        Intent intent = new Intent(Engagement.this, Feedback.class);
                        startActivity(intent);
                        //  mTextMessage.setText(R.string.title_feedback);
                        break;
                    case R.id.ic_notifications:
                           Intent intent1 = new Intent(Engagement.this, About.class);
                         startActivity(intent1);
                        //  mTextMessage.setText(R.string.title_about_us);
                        break;
                }
                return false;
            }
        });
    }
}
