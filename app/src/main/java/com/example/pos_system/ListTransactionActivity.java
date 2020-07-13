package com.example.pos_system;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class ListTransactionActivity extends AppCompatActivity implements TransactionAdapter.onTransactionListener {
    RecyclerView recyclerView;
    Transaction[] transactions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_transaction);

        recyclerView = findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        loadTransactions(this);
//        TransactionAdapter adapter = new TransactionAdapter(transactions);
//        recyclerView.setAdapter(adapter);
    }
    private void loadTransactions(final TransactionAdapter.onTransactionListener onTransactionListener) {
        String url = "http://10.0.2.2/android/Transaction.json";

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                transactions = gson.fromJson(response,Transaction[].class);
                TransactionAdapter adapter = new TransactionAdapter(transactions,onTransactionListener);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ListTransactionActivity.this,"Error",Toast.LENGTH_LONG);
                Log.d("buyererror","Load error"+error.getMessage());

            }
        });

        Volley.newRequestQueue(this).add(request);
    }

    @Override
    public void onTransactionClick(int position) {
        Log.d("click","position: "+position);
        Intent intent = new Intent(this, DetailTransactionActivity.class);
        intent.putExtra("name",transactions[position].getName());
        intent.putExtra("amount",transactions[position].getAmount());
        intent.putExtra("date",transactions[position].getDate());
        startActivity(intent);
    }
//    private Transaction[] loadTransactions(){
//        Transaction transaction1 = new Transaction();
//        transaction1.setAmount(20000);
//        transaction1.setBuyer("Horng");
//        transaction1.setTime(02/04/2020);
//
//
//        Transaction transaction2 = new Transaction();
//        transaction2.setAmount(3000);
//        transaction2.setBuyer("Ly Horng");
//        transaction2.setTime(02/05/2020);
//
//        return new Transaction[]{transaction1,transaction2};
//    }
}
