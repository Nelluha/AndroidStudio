package com.example.utilisateur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.utilisateur.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {

    ActivitySignupBinding binding;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.signupEmail.getText().toString();
                String password = binding.signupPassword.getText().toString();
                String confirm = binding.signupConfirm.getText().toString();

                if (email.equals("") || password.equals("") || confirm.equals("")){
                    Toast.makeText(SignupActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                }else{
                    if (password.equals(confirm)){
                        Boolean checkUserEmail = databaseHelper.checkEmail(email);

                        if (checkUserEmail==false){ // si l'emil n'existe pas on réer le compte
                            Boolean insert = databaseHelper.insertData(email, password);

                            if (insert == true){ // si l'insertion est reussi on retourne un toast et on renvoie dans la page de connexion.
                                Toast.makeText(SignupActivity.this, "Création du compte réussi", Toast.LENGTH_SHORT).show();
                                Intent intent= new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(SignupActivity.this, "Création raté", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(SignupActivity.this, "L'utilisateur existe deja, connectez-vous s'il vous plait", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SignupActivity.this, "Mauvais mot de passe", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.loginRedirectionText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}