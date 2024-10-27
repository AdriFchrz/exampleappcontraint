package com.example.testingapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TransactionActivity extends AppCompatActivity {

    private EditText pemasukan, pengeluaran, kategori;
    private Button button_submit;
    private String kategori_final;
    private int jml_pemasukan, jml_pengeluaran, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_transaction);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        variable();
        tombol();

    }

    private void tombol() {
        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                jml_pemasukan = Integer.parseInt(pemasukan.getText().toString());
//                jml_pengeluaran = Integer.parseInt(pengeluaran.getText().toString());
//                kategori_final = kategori.getText().toString();

//                total = jml_pemasukan - jml_pengeluaran;

                Intent intent = new Intent(TransactionActivity.this, Dashboard2Activity.class);

                intent.putExtra("pemasukan", total);
                intent.putExtra("pengeluaran", jml_pengeluaran);
                intent.putExtra("kategori", kategori_final);

                startActivity(intent);
            }
        });
    }

    private void variable() {
        pemasukan = findViewById(R.id.pemasukanEdit);
        pengeluaran = findViewById(R.id.pengeluaranEdit);
        kategori = findViewById(R.id.kategoriEdit);
        button_submit = findViewById(R.id.button_submit);
    }

}