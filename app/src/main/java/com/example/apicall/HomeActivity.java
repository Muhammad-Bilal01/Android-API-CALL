package com.example.apicall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button btn1,btn2,btn3,btn4;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);

        Intent i = getIntent();
       String t =  i.getStringExtra("token");
       t = "Bearer "+ t;
       token = t;

        System.out.println("=========================");
        System.out.println(token);


        btn1.setOnClickListener(view -> {
            Intent intent = new Intent(this, PurchaseInvoice.class);
            intent.putExtra("token",token);
            startActivity(intent);
        });


        btn3.setOnClickListener(
                view -> {
                    Intent intent = new Intent(this, PurchaseOrderLineItems.class);
                    intent.putExtra("token",token);
                    startActivity(intent);
                }
        );



    }
}
