package com.example.cleancar;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void OnClick2(View view) {
        Intent intent_home = new Intent(this, HomePage.class);
        startActivity(intent_home);
    }
}