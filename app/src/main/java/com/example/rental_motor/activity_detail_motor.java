package com.example.rental_motor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class activity_detail_motor extends AppCompatActivity {

    // Deklarasi variabel untuk komponen UI
    private ImageButton backButton, aboutButton;
    private ImageView motorImage;
    private TextView motorName, motorYear, motorCC, hargaRental, totalHarga;
    private EditText jumlahHariInput;
    private Button orderButton;

    // Variabel untuk harga sewa per hari
    private int rentalPrice = 80000; // Harga sewa default, bisa diubah lewat intent

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_motor); // Gantilah dengan nama layout Anda

        // Mengambil referensi komponen UI
        backButton = findViewById(R.id.backButton);
        aboutButton = findViewById(R.id.aboutButton);
        motorImage = findViewById(R.id.imgmotor1);
        motorName = findViewById(R.id.beat);
        motorYear = findViewById(R.id.tahunmotor);
        motorCC = findViewById(R.id.CCmotor);
        hargaRental = findViewById(R.id.hargaRental);

        jumlahHariInput = findViewById(R.id.jumlahHariInput);
        orderButton = findViewById(R.id.orderButton);

        // Mengambil data dari Intent
        String name = getIntent().getStringExtra("motor_name");
        int image = getIntent().getIntExtra("motor_image", R.drawable.beatdelux); // Default image jika tidak ada
        String price = getIntent().getStringExtra("motor_price");

        // Mengatur data ke komponen UI
        motorName.setText(name);
        motorImage.setImageResource(image);
        motorYear.setText("Tahun Rilis: 2024");
        motorCC.setText("CC: 110cc");

        // Menampilkan harga dari Intent
        if (price != null && !price.isEmpty()) {
            hargaRental.setText("Harga Sewa: " + price); // Menampilkan harga dari Intent

            // Menyesuaikan harga sewa dengan yang diterima
            rentalPrice = Integer.parseInt(price.replace("Rp. ", "").replace("/hari", "").replace(".", ""));
        } else {
            hargaRental.setText("Harga Sewa: Tidak Diketahui");
        }

        // Menambahkan listener untuk tombol back
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Kembali ke halaman sebelumnya
            }
        });

        // Set listener untuk tombol About Us
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent menuju halaman About Us
                Intent intent = new Intent(activity_detail_motor.this, activity_about_us.class);
                startActivity(intent);
            }
        });

        // Menambahkan listener untuk menghitung harga saat jumlah hari diinput
        jumlahHariInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) { // Ketika input kehilangan fokus, hitung harga
                    calculateTotalPrice();
                }
            }
        });

        // Menambahkan listener untuk tombol order sekarang
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Menambahkan aksi untuk tombol Order Sekarang (buka halaman pembayaran)
                String jumlahHariStr = jumlahHariInput.getText().toString();

                if (!jumlahHariStr.isEmpty()) {
                    int jumlahHari = Integer.parseInt(jumlahHariStr);
                    int totalHargaValue = rentalPrice * jumlahHari;

                    // Membuat Intent untuk membuka halaman pembayaran
                    Intent intent = new Intent(activity_detail_motor.this, activity_pembayaran.class);
                    intent.putExtra("motor_name", name); // Mengirimkan nama motor
                    intent.putExtra("total_harga", totalHargaValue); // Mengirimkan total harga
                    intent.putExtra("jumlah_hari", jumlahHari); // Mengirimkan jumlah hari
                    intent.putExtra("motor_image", image); // Mengirimkan gambar motor
                    startActivity(intent); // Menjalankan halaman pembayaran
                } else {
                    Toast.makeText(activity_detail_motor.this, "Masukkan jumlah hari rental", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void calculateTotalPrice() {
        // Mengambil input jumlah hari rental
        String jumlahHariStr = jumlahHariInput.getText().toString();

        // Jika jumlah hari tidak kosong dan berupa angka
        if (!jumlahHariStr.isEmpty()) {
            int jumlahHari = Integer.parseInt(jumlahHariStr);

            // Menghitung total harga
            int totalHargaValue = rentalPrice * jumlahHari;

            // Menampilkan total harga
            totalHarga.setText("Total Harga: Rp. " + totalHargaValue);
        } else {
            // Menampilkan pesan error jika input kosong
            Toast.makeText(this, "Masukkan jumlah hari rental", Toast.LENGTH_SHORT).show();
        }
    }
}
