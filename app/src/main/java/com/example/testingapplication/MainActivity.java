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

public class MainActivity extends AppCompatActivity {

    private EditText id, pass;
    private Button button_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initView();
        setVariable();

    }

    private void setVariable() {
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id.getText().toString().isEmpty() && pass.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please input your Email", Toast.LENGTH_SHORT).show();
                } else if (id.getText().toString().equals("admin") && pass.getText().toString().equals("admin")){
                    startActivity(new Intent(MainActivity.this, TransactionActivity.class));
                }
            }
        });

    }
    private void initView() {
        id = findViewById(R.id.userEdit);
        pass = findViewById(R.id.passEdit);
        button_login = findViewById(R.id.button_login);
    }

}