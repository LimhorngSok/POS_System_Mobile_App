package com.example.pos_system;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class ListBuyerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_buyer);

        recyclerView = findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        loadBuyers();
//        Buyer[] buyers = loadBuyers();
//        BuyerAdabter adabter = new BuyerAdabter(buyers);
//        recyclerView.setAdapter(adabter);
    }

    private void loadBuyers() {
        String url = "http://10.0.2.2/android/Buyer.json";

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Buyer[] buyers = gson.fromJson(response,Buyer[].class);
                BuyerAdabter adabter = new BuyerAdabter(buyers);
                recyclerView.setAdapter(adabter);
                Log.d("buyererror","success"+buyers);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ListBuyerActivity.this,"Error",Toast.LENGTH_LONG);
                Log.d("buyererror","Load error"+error.getMessage());

            }
        });

        Volley.newRequestQueue(this).add(request);
    }
//    private Buyer[] loadBuyers() {
//        Buyer buyer1 = new Buyer();
//        buyer1.setAddress("Phnom Penh");
//        buyer1.setName("Horng");
//        buyer1.setPhone_number("0125232132");
//
//        Buyer buyer2 = new Buyer();
//        buyer1.setAddress("Takeo");
//        buyer1.setName("Sa Horng");
//        buyer1.setPhone_number("0125232131");
//
//        Buyer buyer3 = new Buyer();
//        buyer1.setAddress("Phnom Wat");
//        buyer1.setName("Ba Horng");
//        buyer1.setPhone_number("012523213");
//
//        return new Buyer[]{buyer1, buyer2, buyer3};
//    }
}


