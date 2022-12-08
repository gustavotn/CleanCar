package com.example.cleancar;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Agendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendar);
    }

    public void OnClickHomePage(View view) {
        Intent intent_home = new Intent(this, HomePage.class);
        startActivity(intent_home);
    }

    public void OnClickAgendamentos(View view) {
        Intent intent_Agendamentos = new Intent(this, Agendamentos.class);
        startActivity(intent_Agendamentos);
    }


}