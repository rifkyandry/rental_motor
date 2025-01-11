package com.example.rental_motor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class activity_pembayaran extends AppCompatActivity {

    private TextView motorNamaText, jumlahHariText, totalHargaText;
    private ImageView motorImage, gopayIcon, ovoIcon, danaIcon;
    private Button confirmPaymentButton;
    private EditText paymentDetailsInput;
    private TextView paymentMethodText;

    private int totalHarga; // Menyimpan total harga untuk validasi pembayaran

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran); // Pastikan ini sesuai dengan layout yang Anda buat

        // Mengambil referensi komponen UI
        motorNamaText = findViewById(R.id.motorNama);
        jumlahHariText = findViewById(R.id.jumlahHariText);
        totalHargaText = findViewById(R.id.totalHargaText);
        motorImage = findViewById(R.id.motorImage);
        gopayIcon = findViewById(R.id.gopayIcon);
        ovoIcon = findViewById(R.id.ovoIcon);
        danaIcon = findViewById(R.id.danaIcon);
        confirmPaymentButton = findViewById(R.id.confirmPaymentButton);
        paymentDetailsInput = findViewById(R.id.paymentDetailsInput);  // EditText untuk input detail pembayaran
        paymentMethodText = findViewById(R.id.metodePembayaran); // TextView untuk menampilkan metode pembayaran yang dipilih

        // Mengambil data yang dikirim dari activity_item_motor
        String motorName = getIntent().getStringExtra("motor_name");
        totalHarga = getIntent().getIntExtra("total_harga", 0); // Total harga
        int jumlahHari = getIntent().getIntExtra("jumlah_hari", 0);
        int motorImageResource = getIntent().getIntExtra("motor_image", R.drawable.beatdelux);

        // Referensi untuk tombol back
        ImageView backButton = findViewById(R.id.backButton);

        // Set listener untuk ikon back
        backButton.setOnClickListener(v -> {
            onBackPressed(); // Fungsi untuk kembali ke activity sebelumnya
        });
        // Menampilkan data ke UI
        motorNamaText.setText(motorName); // Nama motor
        jumlahHariText.setText("Jumlah Hari: " + jumlahHari + " Hari"); // Jumlah hari rental
        totalHargaText.setText("Total Harga: Rp. " + totalHarga); // Total harga
        motorImage.setImageResource(motorImageResource); // Gambar motor

        // Listener untuk ikon Gopay
        gopayIcon.setOnClickListener(v -> showPaymentPopup("Gopay"));

        // Listener untuk ikon OVO
        ovoIcon.setOnClickListener(v -> showPaymentPopup("OVO"));

        // Listener untuk ikon Dana
        danaIcon.setOnClickListener(v -> showPaymentPopup("Dana"));

        // Listener untuk tombol konfirmasi pembayaran
        confirmPaymentButton.setOnClickListener(v -> {
            // Ambil nominal yang dimasukkan sebagai pembayaran
            String paymentDetails = paymentDetailsInput.getText().toString();

            if (!paymentDetails.isEmpty()) {
                try {
                    // Mengubah input pembayaran menjadi integer
                    int pembayaran = Integer.parseInt(paymentDetails);

                    if (pembayaran == totalHarga) {
                        // Jika nominal bayar sesuai dengan total harga
                        Toast.makeText(this, "Pembayaran Berhasil! Terima kasih.", Toast.LENGTH_SHORT).show();
                        // Kembali ke activity_item_motor setelah pembayaran berhasil
                        Intent intent = new Intent(activity_pembayaran.this, ItemMotorActivity.class);
                        startActivity(intent);
                        finish(); // Menutup activity pembayaran
                    } else {
                        // Jika nominal bayar tidak sesuai dengan total harga
                        Toast.makeText(this, "Pembayaran Gagal! Nominal tidak sesuai.", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    // Jika input bukan angka
                    Toast.makeText(this, "Harap masukkan nominal yang valid.", Toast.LENGTH_SHORT).show();
                }
            } else {
                // Jika detail pembayaran kosong
                Toast.makeText(this, "Harap masukkan detail pembayaran", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Fungsi untuk menampilkan pop-up pembayaran berdasarkan metode yang dipilih
    private void showPaymentPopup(String paymentMethod) {
        // Tampilkan kolom input untuk detail pembayaran
        paymentDetailsInput.setVisibility(View.VISIBLE);
        confirmPaymentButton.setVisibility(View.VISIBLE); // Menampilkan tombol konfirmasi pembayaran
        paymentMethodText.setText("Metode Pembayaran: " + paymentMethod); // Menampilkan metode pembayaran yang dipilih
    }
}
