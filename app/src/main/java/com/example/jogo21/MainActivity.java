package com.example.jogo21;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.EditText;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView TituloLogin;
    EditText editTextLogin;
    EditText editTextSenha;
    CheckBox checkBoxVisualizar;
    Button buttonLogin;
    Button buttonCadastro;

    public static final int Cadastro = 1;
    public static final int Login = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Aula02","Main Activity onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCadastro = (Button)findViewById(R.id.buttonCadastro);
    }

    public void onClickbuttonLogin(View v){

        Intent intent = new Intent(this, GameActicity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        startActivityForResult(intent, Login);
    }

    public void onClickbuttonCadastro(View v){
        Intent intent = new Intent(this, CadastroActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        startActivityForResult(intent, Cadastro);

    }
}
