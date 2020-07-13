package com.example.pos_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailTransactionActivity extends AppCompatActivity {
    TextView name;
    TextView amount;
    TextView date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_transaction);

        name  = (TextView) findViewById(R.id.name);
        amount = (TextView) findViewById(R.id.amount);
        date =  (TextView) findViewById(R.id.date);

        String tmpName = getIntent().getStringExtra("name");
        String tmpAmount = getIntent().getStringExtra("amount");
        String tmpDate = getIntent().getStringExtra("date");

        name.setText(tmpName);
        amount.setText(tmpAmount);
        date.setText(tmpDate);
    }
}
