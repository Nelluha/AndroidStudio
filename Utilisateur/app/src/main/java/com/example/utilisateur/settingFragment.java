package com.example.utilisateur;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;


public class settingFragment extends Fragment {
    private DrawerLayout drawerLayout;
    public ImageView navImage;
    public EditText navEmail, navMdp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Intent intent = new Intent(this.getContext(),UploadActivity.class);
        startActivity(intent);
        return inflater.inflate(R.layout.fragment_setting, container, false);


    }
}