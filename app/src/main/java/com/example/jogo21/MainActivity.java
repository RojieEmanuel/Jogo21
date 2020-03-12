package com.example.jogo21;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.text.method.PasswordTransformationMethod;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.CompoundButton;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText editTextLogin;
    EditText editTextSenha;
    CheckBox checkBoxVisualizar;
    Button buttonLogin;
    Button buttonCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Aula02","Main Activity onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextLogin = (EditText)findViewById(R.id.editTextLogin);
        editTextSenha = (EditText)findViewById(R.id.editTextSenha);
        checkBoxVisualizar = (CheckBox)findViewById(R.id.checkBoxVisualizar);
        buttonLogin = (Button)findViewById(R.id.buttonLogin);
        buttonCadastro = (Button)findViewById(R.id.buttonCadastro);

        checkBoxVisualizar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    editTextSenha.setTransformationMethod(new PasswordTransformationMethod());
                } else {
                    editTextSenha.setTransformationMethod(null);
                }
            }
        });
    }

    public void onClickbuttonLogin(View v){
        SharedPreferences sharedPreferences = getSharedPreferences("preferences", MODE_PRIVATE);
        String user = sharedPreferences.getString("login", "");
        String senha = sharedPreferences.getString("senha", "");
        if(user.equals(editTextLogin.getText().toString()))
            if(senha.equals(editTextSenha.getText().toString())){
                Intent intent = new Intent(this, GameActicity.class);
                startActivity(intent);
            }
        else
            Toast.makeText(this, getString(R.string.informacao_errada), Toast.LENGTH_LONG).show();

    }

    public void onClickbuttonCadastro(View v){
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);

    }
}
