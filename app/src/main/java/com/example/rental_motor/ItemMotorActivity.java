package com.example.rental_motor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ItemMotorActivity extends AppCompatActivity {

    private ImageView imgMotor1, imgMotor2, imgMotor3, imgMotor4, imgMotor5, imgMotor6, imgMotor7;
    private TextView beatText, varioText, pcxText, aeroxText, scoopyText, fazioText, filanoText;
    private TextView hargaMotor1, hargaMotor2, hargaMotor3, hargaMotor4, hargaMotor5, hargaMotor6, hargaMotor7;
    private ImageView aboutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_motor);

        // Mengambil referensi komponen UI
        imgMotor1 = findViewById(R.id.imgmotor1);
        imgMotor2 = findViewById(R.id.imgmotor2);
        imgMotor3 = findViewById(R.id.imgmotor3);
        imgMotor4 = findViewById(R.id.imgmotor4);
        imgMotor5 = findViewById(R.id.imgmotor5);
        imgMotor6 = findViewById(R.id.imgmotor6);
        imgMotor7 = findViewById(R.id.imgmotor7);

        beatText = findViewById(R.id.beat);
        varioText = findViewById(R.id.vario);
        pcxText = findViewById(R.id.pcx);
        aeroxText = findViewById(R.id.aerox);
        scoopyText = findViewById(R.id.scoopy);
        fazioText = findViewById(R.id.fazio);
        filanoText = findViewById(R.id.filano);

        hargaMotor1 = findViewById(R.id.textHargaMotor1);
        hargaMotor2 = findViewById(R.id.textHargaMotor2);
        hargaMotor3 = findViewById(R.id.textHargaMotor3);
        hargaMotor4 = findViewById(R.id.textHargaMotor4);
        hargaMotor5 = findViewById(R.id.textHargaMotor5);
        hargaMotor6 = findViewById(R.id.textHargaMotor6);
        hargaMotor7 = findViewById(R.id.textHargaMotor7);

        aboutButton = findViewById(R.id.aboutButton);

        // Set listener untuk tombol About Us
        aboutButton.setOnClickListener(v -> {
            Intent intent = new Intent(ItemMotorActivity.this, activity_about_us.class);
            startActivity(intent);
        });
        // Menambahkan referensi ke ImageButton untuk profile
        ImageView profileButton = findViewById(R.id.logo);

// Set listener untuk klik pada icon profile
        profileButton.setOnClickListener(v -> {
            // Menavigasi ke halaman profil (Activity Profil)
            Intent intent = new Intent(ItemMotorActivity.this, activity_profile.class);
            startActivity(intent);
        });


        // Set data untuk motor
        setMotorData();

        // Set listener untuk setiap motor yang diklik
        setMotorClickListener();
    }

    private void setMotorData() {
        // Set nama motor
        beatText.setText("Beat Delux");
        varioText.setText("Vario150");
        pcxText.setText("PCX160");
        aeroxText.setText("Aerox155");
        scoopyText.setText("Scoopy");
        fazioText.setText("Fazio");
        filanoText.setText("Filano");

        // Set harga motor
        hargaMotor1.setText("Rp. 80.000/hari");
        hargaMotor2.setText("Rp. 110.000/hari");
        hargaMotor3.setText("Rp. 130.000/hari");
        hargaMotor4.setText("Rp. 110.000/hari");
        hargaMotor5.setText("Rp. 80.000/hari");
        hargaMotor6.setText("Rp. 90.000/hari");
        hargaMotor7.setText("Rp. 90.000/hari");

        // Set gambar motor
        imgMotor1.setImageResource(R.drawable.beatdelux);
        imgMotor2.setImageResource(R.drawable.vario);
        imgMotor3.setImageResource(R.drawable.pcx);
        imgMotor4.setImageResource(R.drawable.aerox);
        imgMotor5.setImageResource(R.drawable.scoopy);
        imgMotor6.setImageResource(R.drawable.fazio2024);
        imgMotor7.setImageResource(R.drawable.filano2024);
    }

    private void setMotorClickListener() {
        // Ketika gambar motor Beat diklik
        imgMotor1.setOnClickListener(v -> {
            Intent intent = new Intent(ItemMotorActivity.this, activity_detail_motor.class);
            intent.putExtra("motor_name", "Beat Delux");
            intent.putExtra("motor_image", R.drawable.beatdelux);
            intent.putExtra("motor_price", "Rp. 80.000/hari");
            startActivity(intent);
        });

        // Ketika gambar motor Vario diklik
        imgMotor2.setOnClickListener(v -> {
            Intent intent = new Intent(ItemMotorActivity.this, activity_detail_motor.class);
            intent.putExtra("motor_name", "Vario150");
            intent.putExtra("motor_image", R.drawable.vario);
            intent.putExtra("motor_price", "Rp. 110.000/hari");
            startActivity(intent);
        });

        // Ketika gambar motor PCX diklik
        imgMotor3.setOnClickListener(v -> {
            Intent intent = new Intent(ItemMotorActivity.this, activity_detail_motor.class);
            intent.putExtra("motor_name", "PCX160");
            intent.putExtra("motor_image", R.drawable.pcx);
            intent.putExtra("motor_price", "Rp. 130.000/hari");
            startActivity(intent);
        });

        // Ketika gambar motor Aerox diklik
        imgMotor4.setOnClickListener(v -> {
            Intent intent = new Intent(ItemMotorActivity.this, activity_detail_motor.class);
            intent.putExtra("motor_name", "Aerox155");
            intent.putExtra("motor_image", R.drawable.aerox);
            intent.putExtra("motor_price", "Rp. 110.000/hari");
            startActivity(intent);
        });

        // Ketika gambar motor Scoopy diklik
        imgMotor5.setOnClickListener(v -> {
            Intent intent = new Intent(ItemMotorActivity.this, activity_detail_motor.class);
            intent.putExtra("motor_name", "Scoopy");
            intent.putExtra("motor_image", R.drawable.scoopy);
            intent.putExtra("motor_price", "Rp. 80.000/hari");
            startActivity(intent);
        });

        // Ketika gambar motor Fazio diklik
        imgMotor6.setOnClickListener(v -> {
            Intent intent = new Intent(ItemMotorActivity.this, activity_detail_motor.class);
            intent.putExtra("motor_name", "Fazio");
            intent.putExtra("motor_image", R.drawable.fazio2024);
            intent.putExtra("motor_price", "Rp. 90.000/hari");
            startActivity(intent);
        });

        // Ketika gambar motor Filano diklik
        imgMotor7.setOnClickListener(v -> {
            Intent intent = new Intent(ItemMotorActivity.this, activity_detail_motor.class);
            intent.putExtra("motor_name", "Filano");
            intent.putExtra("motor_image", R.drawable.filano2024);
            intent.putExtra("motor_price", "Rp. 90.000/hari");
            startActivity(intent);
        });
    }
}
