package com.example.rental_motor;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mengambil referensi komponen UI
        Button loginButton = findViewById(R.id.login7);
        Button registerButton = findViewById(R.id.registeractivity); // Perbaiki ID ini
        ImageView googleIcon = findViewById(R.id.google);
        ImageView facebookIcon = findViewById(R.id.facebook);
        ImageView twitterIcon = findViewById(R.id.twitter);

        // Menambahkan click listener untuk tombol Login
        loginButton.setOnClickListener(v -> {
            Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(loginIntent);
        });

        // Menambahkan click listener untuk tombol Register
        registerButton.setOnClickListener(v -> {
            Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(registerIntent);
        });

        // Menambahkan click listener untuk ikon Google
        googleIcon.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://accounts.google.com/signin"));
            startActivity(intent);
        });

        // Menambahkan click listener untuk ikon Facebook
        facebookIcon.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com/login"));
            startActivity(intent);
        });

        // Menambahkan click listener untuk ikon Twitter
        twitterIcon.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/login"));
            startActivity(intent);
        });
    }
}
