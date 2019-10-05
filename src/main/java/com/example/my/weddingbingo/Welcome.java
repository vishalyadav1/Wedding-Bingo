package com.example.my.weddingbingo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Welcome extends AppCompatActivity {
    private static final String TAG = "Welcome";

    ListView myListView;
    Toolbar toolbar;
    BottomNavigationView BottomNavigationView;
    private FirebaseAuth firebaseAuth;
    private Button logout;

    private TextView mTextMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        firebaseAuth = FirebaseAuth.getInstance();

        logout = (Button) findViewById(R.id.btnLogout);
        mTextMessage = (TextView) findViewById(R.id.message);

        BottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        BottomNavigationViewHelper.disableShiftMode(BottomNavigationView);
        Menu menu = BottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logout();
            }
        });
        setContentView(R.layout.activity_welcome);

        myListView = (ListView) findViewById(R.id.listViewContextMenu);
        final ArrayList<String> alist = new ArrayList<>();
        alist.add("Engagement");

        alist.add("Haldi");
        alist.add("Mehndi");
        alist.add("Pre_Wedding");
        alist.add("Wedding");


        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, alist);
        myListView.setAdapter(aa);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                Toast.makeText(Welcome.this, "clicked " + i + " " + alist.get(i).toString(), Toast.LENGTH_SHORT).show();
                if (i == 0) {
                    Intent intent = new Intent(Welcome.this, Engagement.class);
                    startActivityForResult(intent, 0);
                }
                if (i == 1) {
                    Intent intent = new Intent(Welcome.this, Haldi.class);
                    startActivityForResult(intent, 1);
                }
                if (i == 3) {
                    Intent intent = new Intent(Welcome.this, Pre_Wedding.class);
                    startActivityForResult(intent, 3);
                }
                if (i == 2) {
                    Intent intent = new Intent(Welcome.this, Mehndi.class);
                    startActivityForResult(intent, 2);
                }
                if (i == 4) {
                    Intent intent = new Intent(Welcome.this, Wedding.class);
                    startActivityForResult(intent, 4);
                }

            }

        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_home:
                        // startActivity(new Intent(Home.this, Home.class));
                        //  mTextMessage.setText(R.string.title_home);
                        break;

                    case R.id.ic_dashboard:
                        Intent intent=new Intent(Welcome.this, Feedback.class);
                        startActivity(intent);
                      //  mTextMessage.setText(R.string.title_feedback);
                        break;
                    case R.id.ic_notifications:
                        Intent intent1=new Intent(Welcome.this,About.class);
                        startActivity(intent1);
                      //  mTextMessage.setText(R.string.title_about_us);
                        break;
                }
                return false;
            }
        });
    }

    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(Welcome.this, MainActivity.class));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.logoutMenu: {
                Logout();
                break;
            }
            case R.id.profileMenu:
                startActivity(new Intent(Welcome.this, Profile.class));
                break;


            case R.id.refreshMenu:
                startActivity(new Intent(Welcome.this, Share.class));
                break;


        }

        return super.onOptionsItemSelected(item);









    }
}
