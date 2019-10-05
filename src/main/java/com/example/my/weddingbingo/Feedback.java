package com.example.my.weddingbingo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Feedback extends AppCompatActivity {
    private EditText ourmail,message,subject;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        ourmail=(EditText) findViewById(R.id.email);
        message=(EditText) findViewById(R.id.message);
        subject=(EditText) findViewById(R.id.subject);
        send=(Button)findViewById(R.id.btn_snd);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ourSubjectFeedback = subject.getText().toString();
                String ourMessageFeedback = message.getText().toString();
                String ourEmail= ourmail.getText().toString();
                String[] email_divide = ourEmail.split(",");
                Intent send = new Intent(Intent.ACTION_SEND);
                send.putExtra(Intent.EXTRA_EMAIL,email_divide);
                send.putExtra(Intent.EXTRA_SUBJECT,ourSubjectFeedback);
                send.putExtra(Intent.EXTRA_TEXT,ourMessageFeedback);
                send.setType("message/rfc822");
                send.setPackage("com.google.android.gm");
                startActivity(send);
            }
        });
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_home:
                         startActivity(new Intent(Feedback.this, Welcome.class));
                        //  mTextMessage.setText(R.string.title_home);
                        break;

                    case R.id.ic_dashboard:
                   //     Intent intent=new Intent(.this, Feedback.class);
                     //   startActivity(intent);
                        //  mTextMessage.setText(R.string.title_feedback);
                        break;
                    case R.id.ic_notifications:
                        Intent intent1=new Intent(Feedback.this,About.class);
                        startActivity(intent1);
                        //  mTextMessage.setText(R.string.title_about_us);
                        break;
                }
                return false;
            }
        });
    }
}
