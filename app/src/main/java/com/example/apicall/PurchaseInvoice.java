package com.example.apicall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;


import com.example.apicall.adapters.PurchaseInvoiceAdapter;
import com.example.apicall.models.PurchaseInvoiceModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PurchaseInvoice extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PurchaseInvoiceAdapter adapter;
    private List<PurchaseInvoiceModel> purchaseInvoiceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_invoice);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        String api_token = intent.getStringExtra("token");

        fetchData(api_token);
    }

    void fetchData(String api_token){
        //        Call API
        // Replace with your actual URL and token
        OkHttpClient client = new OkHttpClient();
        String url = "http://192.168.0.105/api/Invoice/GetPurchaseInvoice";
        String token = api_token;

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", token)
                .build();

        client.newCall(request).enqueue(new Callback() {
                                            @Override
                                            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                                                if (!response.isSuccessful()) {
                                                    throw new IOException("Unexpected code " + response);
                                                }

                                                String responseBody = response.body().string();
                                                System.out.println("SUCCESS!");
                                                // Example data

                                                // Create ObjectMapper instance
                                                ObjectMapper mapper = new ObjectMapper();

                                                try {

                                                    // Deserialize JSON array to list of PurchaseInvoiceModel
                                                    List<PurchaseInvoiceModel> purchaseInvoices = mapper.readValue(responseBody, mapper.getTypeFactory().constructCollectionType(List.class, PurchaseInvoiceModel.class));

                                                    // Update RecyclerView on the main thread
                                                    new Handler(Looper.getMainLooper()).post(() -> {
                                                        adapter = new PurchaseInvoiceAdapter(purchaseInvoices);
                                                        recyclerView.setAdapter(adapter);
                                                    });

                                                } catch (JsonProcessingException e) {
                                                    System.out.println(e.toString());
                                                    e.printStackTrace();
                                                }

                                            }

                                            @Override
                                            public void onFailure(Call call, IOException e) {
                                                System.out.println("***************");
                                                System.out.println(e.toString());
                                                e.printStackTrace();
                                            }
                                        }
        );
    }

}