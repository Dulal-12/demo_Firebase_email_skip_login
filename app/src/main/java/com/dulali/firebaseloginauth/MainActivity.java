package com.dulali.firebaseloginauth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button login,register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = getSharedPreferences(LoginActivity.PREF_NAME , 0);
                boolean hasLoggedIn = sharedPreferences.getBoolean("hasLoggedIn" , false);
                if(hasLoggedIn){
                    startActivity(new Intent(MainActivity.this , AllTopicsActivity.class));
                    finish();
                }
                else{
                    startActivity(new Intent(MainActivity.this , LoginActivity.class));
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this , RegisterActivity.class));
            }
        });
    }
}