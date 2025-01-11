package com.example.rental_motor;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText namaEditText, emailEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Mengambil referensi komponen UI
        namaEditText = findViewById(R.id.nama);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.pass);
        Button registerButton = findViewById(R.id.register);

        // Mengambil referensi ikon media sosial
        ImageView googleIcon = findViewById(R.id.google);
        ImageView facebookIcon = findViewById(R.id.facebook);
        ImageView twitterIcon = findViewById(R.id.twitter);

        // Menambahkan click listener untuk tombol Register
        registerButton.setOnClickListener(v -> {
            String nama = namaEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            // Validasi input
            if (nama.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(RegisterActivity.this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show();
            } else {
                // Pindah ke LoginActivity
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Menutup RegisterActivity agar tidak kembali ke layar ini
            }
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
