package com.example.cleancar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Cadastrar extends AppCompatActivity {

    Button btnCadastrar;
    EditText editTextEmail;
    EditText editTextSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        btnCadastrar = findViewById(R.id.btnCadastrarCadastro);
        editTextEmail = findViewById(R.id.editEmailCadastro);
        editTextSenha = findViewById(R.id.editSenhaCadastro);

        CriaEventos();
    }

    private void CriaEventos(){
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString().trim();
                String senha = editTextSenha.getText().toString().trim();

                ((InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                        editTextSenha.getWindowToken(), 0);

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Snackbar msg = Snackbar.make(view, "Cadastro criado com sucesso!", Snackbar.LENGTH_SHORT);
                            msg.show();

                            Intent intent_login = new Intent(getApplicationContext(), Login.class);
                            startActivity(intent_login);

                        }else {
                            Snackbar msg = Snackbar.make(view, task.getException().getMessage(), Snackbar.LENGTH_SHORT);
                            msg.show();
                        }
                    }
                });
            }
        });
    }
}