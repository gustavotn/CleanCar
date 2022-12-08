package com.example.cleancar;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Agendamentos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamentos);
    }

    public void OnClickHomePage(View view) {
        Intent intent_home = new Intent(this, HomePage.class);
        startActivity(intent_home);
    }

    public void OnClickAgendar(View view) {
        Intent intent_agendar = new Intent(this, Agendar.class);
        startActivity(intent_agendar);
    }

}