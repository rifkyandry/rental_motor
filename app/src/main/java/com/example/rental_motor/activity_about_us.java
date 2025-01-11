package com.example.rental_motor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class activity_about_us extends AppCompatActivity {

    private ImageView appLogo, dev1Image;
    private TextView appName, appDescription, rentalAddress, developerInfo, dev1Name, dev1Role;
    private ImageButton backButton, profileButton; // Tombol kembali dan profil

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us); // Pastikan XML Anda memiliki nama ini

        // Mengambil referensi komponen UI
        appLogo = findViewById(R.id.app_logo);
        appName = findViewById(R.id.app_name);
        appDescription = findViewById(R.id.app_description);
        rentalAddress = findViewById(R.id.rental_address);
        developerInfo = findViewById(R.id.developer_info);

        // Developer 1
        dev1Image = findViewById(R.id.dev1Image);
        dev1Name = findViewById(R.id.dev1Name);
        dev1Role = findViewById(R.id.dev1Role);

        // Tombol Kembali dan Profile
        backButton = findViewById(R.id.backButton);
        profileButton = findViewById(R.id.profileButton);

        // Menampilkan data tentang aplikasi
        appName.setText("Rental Motor App");
        appDescription.setText("Aplikasi Rental Motor memudahkan Anda dalam menyewa motor secara cepat dan mudah. Nikmati layanan terbaik dengan berbagai pilihan motor.");
        rentalAddress.setText("Alamat: Ciawigebang, Kec. Ciawigebang, Kabupaten Kuningan, Jawa Barat 45591");
        developerInfo.setText("Dikembangkan oleh:");

        // Data Developer 1
        dev1Name.setText("Rifky Andryanto");
        dev1Role.setText("UI Designer");

        // Set logo atau gambar pengembang jika diperlukan
        appLogo.setImageResource(R.drawable.logorent3);
        dev1Image.setImageResource(R.drawable.rifky);

        // Fungsi tombol kembali
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Kembali ke halaman sebelumnya
            }
        });

        // Fungsi tombol profil
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigasi ke halaman profil
                Intent intent = new Intent(activity_about_us.this, activity_profile.class); // Ganti ProfileActivity dengan nama activity yang sesuai
                startActivity(intent);
            }
        });
    }
}
