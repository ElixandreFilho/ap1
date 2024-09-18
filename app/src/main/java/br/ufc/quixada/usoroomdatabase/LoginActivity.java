package br.ufc.quixada.usoroomdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import br.ufc.quixada.usoroomdatabase.MainActivity;
import br.ufc.quixada.usoroomdatabase.R;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        // Listener para o botão de login
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()) {
                    // Aqui você pode implementar a lógica de autenticação
                    // Exemplo: se email for "admin" e senha for "1234", o login é bem-sucedido
                    if (email.equals("admin") && password.equals("1234")) {
                        // Se o login for bem-sucedido, redirecionar para AgendamentoActivity
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish(); // Fecha a LoginActivity
                    } else {
                        // Exibe mensagem de erro se o login falhar
                        Toast.makeText(LoginActivity.this, "Email ou senha inválidos", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Exibe mensagem de erro se os campos estiverem vazios
                    if (email.isEmpty()) {
                        editTextEmail.setError("Campo obrigatório");
                    }
                    if (password.isEmpty()) {
                        editTextPassword.setError("Campo obrigatório");
                    }
                }
            }
        });
    }
}