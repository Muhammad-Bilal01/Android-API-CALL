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
import com.example.apicall.adapters.PurchaseOrderLineItemAdapter;
import com.example.apicall.models.PurchaseInvoiceModel;
import com.example.apicall.models.PurchaseOrderLineItemsModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PurchaseOrderLineItems extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PurchaseOrderLineItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_order_line_items);

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
        String url = "http://192.168.0.105/api/Invoice/GetPurchaseOrder_LineItems";
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

//                                                    // Deserialize JSON array to list of PurchaseInvoiceModel
//                                                    List<PurchaseOrderLineItemsModel> purchaseInvoices = mapper.readValue(responseBody, mapper.getTypeFactory().constructCollectionType(List.class, PurchaseOrderLineItems.class));

                                                    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                                                    List<PurchaseOrderLineItemsModel> lineItems = mapper.readValue(responseBody, new TypeReference<List<PurchaseOrderLineItemsModel>>() {});

                                                    System.out.println(lineItems);
                                                    // Update RecyclerView on the main thread
                                                    new Handler(Looper.getMainLooper()).post(() -> {
                                                        adapter = new PurchaseOrderLineItemAdapter(lineItems);
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