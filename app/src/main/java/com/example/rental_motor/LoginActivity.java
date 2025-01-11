package com.example.rental_motor;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import android.widget.ImageView;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText email, pass;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Mengambil referensi komponen UI
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        login = findViewById(R.id.login);

        ImageView google = findViewById(R.id.google);
        ImageView twitter = findViewById(R.id.twitter);
        ImageView facebook = findViewById(R.id.facebook);

        // Menambahkan click listener untuk login button
        login.setOnClickListener(v -> login());

        // Menambahkan click listener untuk ikon Google
        google.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://accounts.google.com/signin"));
            startActivity(intent);
        });

        // Menambahkan click listener untuk ikon Twitter
        twitter.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://twitter.com/login"));
            startActivity(intent);
        });

        // Menambahkan click listener untuk ikon Facebook
        facebook.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://facebook.com/login"));
            startActivity(intent);
        });
    }

    private void login() {
        String inputEmail = email.getText().toString().trim();
        String inputPassword = pass.getText().toString().trim();

        // Cek jika kolom kosong
        if (inputEmail.isEmpty() || inputPassword.isEmpty()) {
            Toast.makeText(this, "Lengkapi kolom!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validasi email dan password (contoh sederhana)
        if (isValidCredentials(inputEmail, inputPassword)) {
            Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, ItemMotorActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Email atau password salah!", Toast.LENGTH_SHORT).show();
        }
    }


    // Contoh metode untuk validasi kredensial
    private boolean isValidCredentials(String email, String password) {
        // Ganti dengan logika validasi yang sesuai
        return email.equals("admin@gmail.com") && password.equals("#12345");
    }
}
