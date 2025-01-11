package com.example.rental_motor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class activity_profile extends AppCompatActivity {

    private ImageView profileImage, userImage, gmailImage;
    private TextView usernameText, emailText;
    private Button logoutButton;
    private ImageButton backButton; // Tombol kembali

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



        // Tombol Kembali
        backButton = findViewById(R.id.backButton);


        // Mengambil referensi komponen UI
        profileImage = findViewById(R.id.imageView7);
        userImage = findViewById(R.id.user);
        gmailImage = findViewById(R.id.gmail);
        usernameText = findViewById(R.id.uername);
        emailText = findViewById(R.id.txtemail);
        logoutButton = findViewById(R.id.logout);

        // Menampilkan data profil
        setProfileData();

        // Set listener untuk tombol logout
        logoutButton.setOnClickListener(v -> {
            // Menangani logout dan kembali ke halaman login atau utama
            Intent intent = new Intent(activity_profile.this, MainActivity.class);
            startActivity(intent);
            finish();  // Tutup activity profil
        });
    }

    private void setProfileData() {
        // Set gambar profil, username, dan email
        profileImage.setImageResource(R.drawable.logoaccount); // Ganti dengan sumber gambar yang sesuai
        userImage.setImageResource(R.drawable.logoaccount);    // Ganti dengan sumber gambar yang sesuai
        gmailImage.setImageResource(R.drawable.logoemail);     // Ganti dengan sumber gambar yang sesuai

        usernameText.setText("admin");  // Ganti dengan username yang sesuai
        emailText.setText("Admin@gmail.com");  // Ganti dengan email yang sesuai
    }

    // Fungsi logout
    public void logout(View view) {
        // Proses logout dan navigasi ke halaman login atau utama
        Intent intent = new Intent(activity_profile.this, MainActivity.class);  // Halaman utama atau login
        startActivity(intent);
        finish();  // Tutup halaman profil
    }
}
