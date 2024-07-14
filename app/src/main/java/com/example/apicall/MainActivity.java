package com.example.apicall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login_button = findViewById(R.id.login_button);


        login_button.setOnClickListener(view -> {

            String email = username.getText().toString();
            String pass = password.getText().toString();
            onSignIn(email, pass);
        });


    }

    private void onSignIn(String email, String password) {
        System.out.println("+++++++++++++++++++++++++");
        System.out.println(email + password);
        OkHttpClient client = new OkHttpClient();

        // JSON payload
//        String json = "{\n" +
//                "  \"email\":" + email +
//                "  \"password\":" + password + "\n" +
//                "}";


//        System.out.println(json);

        String json = "{\n" +
                "  \"email\": \""+email+"\",\n" +
                "  \"password\": \""+password+"\"\n" +
                "}";

        System.out.println(json);

        RequestBody body = RequestBody.create(json, MediaType.get("application/json; charset=utf-8"));


        // Build the request
        Request request = new Request.Builder()
                .url("http://192.168.0.105/api/Invoice/GenerateToken")
                .post(body)
                .addHeader("accept", "text/plain")
                .addHeader("Content-Type", "application/json")
                .build();


        // Execute the request
        client.newCall(request).enqueue(new Callback() {
                                            @Override
                                            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                                                if (response.isSuccessful()) {
                                                    // Properly read the response body as a string
                                                    try (ResponseBody responseBody = response.body()) {
                                                        if (responseBody != null) {
                                                            String responseData = ((ResponseBody) responseBody).string();
                                                            runOnUiThread(() -> {
                                                                Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                                                                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                                                intent.putExtra("token", responseData);
                                                                startActivity(intent);
                                                            });
                                                        } else {
                                                            runOnUiThread(() -> Toast.makeText(MainActivity.this, "Empty response body", Toast.LENGTH_SHORT).show());
                                                        }
                                                    }
                                                } else {

                                                    System.out.println("Request failed: " + response.code());
                                                }
                                            }

                                            @Override
                                            public void onFailure(@NonNull Call call, @NonNull IOException e) {

                                                System.out.println("API CALL FAILED" + e.toString());
                                            }
                                        }
        );


    }

}