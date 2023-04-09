package com.example.utilisateur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.utilisateur.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.loginEmail.getText().toString();
                String password = binding.loginPassword.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("email", email);
                if ( email.equals("") || password.equals("")){ // si les champs sont vide, on retourne un Toast
                    Toast.makeText(LoginActivity.this, "Les champs sont vides.", Toast.LENGTH_SHORT).show();
                }else{ // sinon on verifie l'email et le password entrés, si celacorrespond la connexion est réussi
                    Boolean checkCredentials = databaseHelper.checkEmailPassword(email, password);

                    if (checkCredentials==true){ // cela correspond donc la connexioon est faite. On recupere le champ email qu'on nvoie ensuite dans l'autre activity main
                        Toast.makeText(LoginActivity.this, "Connexion reussi", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }else{ // sinon on retourne un Toast qui stipule que l'email et le mot de passe est incorrect
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
// lien entre signup et login
        binding.SignUpRedirectionText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}