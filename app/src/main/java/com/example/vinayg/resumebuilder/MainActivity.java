package com.example.vinayg.resumebuilder;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    AlertDialogManager alert = new AlertDialogManager();

    // Session Manager Class
    SessionManager session;

    // Button Logout
    Button btnLogout;
    TextView username,Emailid;
    ImageView profilepic;
    private String[] mPlanetTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (TextView)findViewById(R.id.user_name);
        Emailid = (TextView)findViewById(R.id.emailid);
        profilepic = (ImageView)findViewById(R.id.profilepic);
        btnLogout = (Button)findViewById(R.id.logout);
        // Session class instance
        session = new SessionManager(getApplicationContext());

        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();
        updateUi();
        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Clear the session data
                // This will clear all session data and
                // redirect user to LoginActivity
                session.logoutUser();
            }
        });
    }
    public void updateUi(){
        session.checkLogin();

        // get user data from session
        HashMap<String, String> user = session.getUserDetails();

        // name
        String name = user.get(SessionManager.KEY_NAME);
        username.setText(name);

        // email
        String email = user.get(SessionManager.KEY_EMAIL);

        Emailid.setText(email);
        String photouri = user.get(SessionManager.KEY_PHOTO);
        Glide
                .with(this)
                .load(photouri)
                .into(profilepic);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUi();
    }
}
