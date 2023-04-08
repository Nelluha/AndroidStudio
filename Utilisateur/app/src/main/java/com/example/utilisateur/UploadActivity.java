package com.example.utilisateur;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.utilisateur.databinding.ActivitySignupBinding;
import com.example.utilisateur.databinding.ActivityUploadBinding;

import java.io.IOException;

public class UploadActivity extends AppCompatActivity {

    EditText uploadMdp, uploadEmail;
    ImageView uploadImage;
    Button saveButton;
    private Uri uri;
    private Bitmap bitmapImage;
    DatabaseHelper databaseHelper;
    ActivityUploadBinding binding;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        binding = ActivityUploadBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        uploadEmail = findViewById(R.id.uploadEmail);
        uploadImage = findViewById(R.id.uploadImage);
        uploadMdp = findViewById(R.id.uploadMdp);
        saveButton = findViewById(R.id.saveButton);
        databaseHelper = new DatabaseHelper(this);

        binding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.uploadEmail.getText().toString();
                String password = binding.uploadMdp.getText().toString();
                String confirm = binding.uploadMdp2.getText().toString();
                if (email.equals("") || password.equals("") || confirm.equals("")) {
                    Toast.makeText(UploadActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.equals(confirm)) {
                        Boolean checkUserEmail = databaseHelper.checkEmail(email);

                        if (checkUserEmail == true) {
                            Toast.makeText(UploadActivity.this, "bon mail", Toast.LENGTH_SHORT).show();
                            databaseHelper.delete(email);
                            Boolean insert = databaseHelper.insertData(email, password);
                            if (insert == true) {
                                Toast.makeText(UploadActivity.this, "Modification reussi", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(UploadActivity.this, "madification ratÃ©", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(UploadActivity.this, "mauvais email ou meme mot de passe", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(UploadActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}









        /*uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    activityResultLauncher.launch(intent);
                } catch (Exception e){
                    Toast.makeText(UploadActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });*/
        /*saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storeImage();
            }
        });*/

    /*private void storeImage(){
        if (!uploadName.getText().toString().isEmpty() && !uploadEmail.getText().toString().isEmpty()
                && uploadImage.getDrawable() != null && bitmapImage != null){
            dbHelper.storeData(new ModelClass(uploadName.getText().toString(), uploadEmail.getText().toString(), bitmapImage));
            Intent intent = new Intent(UploadActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Fields are mandatory", Toast.LENGTH_SHORT).show();
        }
    }*/