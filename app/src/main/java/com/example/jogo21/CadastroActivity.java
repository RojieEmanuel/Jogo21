package com.example.jogo21;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CadastroActivity extends AppCompatActivity {

    EditText NomeCadastro;
    EditText LoginCadastro;
    EditText emailCadastro;
    EditText SenhaCadastro;
    EditText SenhaCadastro2;
    CheckBox checkBoxVisualizar;
    Button Cadastrar;
    private String nulo = "";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        sharedPreferences =getSharedPreferences("preferences", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        NomeCadastro = (EditText)findViewById(R.id.NomeCadastro);
        LoginCadastro = (EditText)findViewById(R.id.LoginCadastro);
        emailCadastro = (EditText)findViewById(R.id.emailCadastro);
        SenhaCadastro = (EditText)findViewById(R.id.SenhaCadastro);
        SenhaCadastro2 = (EditText)findViewById(R.id.SenhaCadastro2);
        checkBoxVisualizar = (CheckBox)findViewById(R.id.checkBoxVisualizar);




        checkBoxVisualizar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    SenhaCadastro.setTransformationMethod(new PasswordTransformationMethod());
                    SenhaCadastro2.setTransformationMethod(new PasswordTransformationMethod());
                } else {
                    SenhaCadastro.setTransformationMethod(null);
                    SenhaCadastro2.setTransformationMethod(null);
                }
            }
        });
    }

    public void onClickCadastrar(View view) {
        int erroNome = 0, erroEmail = 0, erroLogin = 0, erroSenha = 0;
        String Snome = NomeCadastro.getText().toString();
        String Semail = emailCadastro.getText().toString();
        String Slogin = LoginCadastro.getText().toString();
        String Ssenha = SenhaCadastro.getText().toString();
        String Ssenha2 = SenhaCadastro2.getText().toString();



        //Verificação Nome
        if(NomeCadastro.getText().toString().equals(nulo)){
            Toast.makeText(this, getString(R.string.retorno_erro), Toast.LENGTH_LONG).show();
            erroNome = 1;
        }else{
            NomeCadastro.setError(null);
            erroNome = 0;
        }

        //Verificação email
        if(emailCadastro.getText().toString().equals(nulo)){
            Toast.makeText(this, getString(R.string.retorno_erro), Toast.LENGTH_LONG).show();
            erroEmail = 1;
        }else{
            emailCadastro.setError(null);
            erroEmail = 0;
        }

        //Verificação Login
        if(LoginCadastro.getText().toString().equals(nulo)){
            Toast.makeText(this, getString(R.string.retorno_erro), Toast.LENGTH_LONG).show();
            erroLogin = 1;
        }else{
            LoginCadastro.setError(null);
            erroLogin = 0;
        }

        //Verificação Senha
        if(SenhaCadastro.getText().toString().equals(nulo)){
            Toast.makeText(this, getString(R.string.retorno_erro), Toast.LENGTH_LONG).show();
            erroSenha = 1;
        }else {
            SenhaCadastro.setError(null);
            erroSenha = 0;
        }

        
        if(erroNome == 1 || erroEmail == 1 || erroLogin == 1|| erroSenha == 1 ){

        }else{
            if (Ssenha.equals(Ssenha2)) {
                editor.putString("nome", Snome);
                editor.putString("email", Semail);
                editor.putString("login", Slogin);
                editor.putString("senha", Ssenha);
                editor.putString("senha2", Ssenha2);
                finish();
            } else {
                Toast.makeText(this, getString(R.string.retorno_invalido), Toast.LENGTH_LONG).show();
            }
        }

    }
}
