package com.example.pos_system;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ListTransactionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_transaction);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Transaction[] transactions = loadTransactions();
        TransactionAdapter adapter = new TransactionAdapter(transactions);
        recyclerView.setAdapter(adapter);
    }
    private Transaction[] loadTransactions(){
        Transaction transaction1 = new Transaction();
        transaction1.setAmount(20000);
        transaction1.setBuyer("Horng");
        transaction1.setTime(02/04/2020);


        Transaction transaction2 = new Transaction();
        transaction2.setAmount(3000);
        transaction2.setBuyer("Ly Horng");
        transaction2.setTime(02/05/2020);

        return new Transaction[]{transaction1,transaction2};
    }
}
