package com.example.pos_system;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ListBuyerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_buyer);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Buyer[] buyers = loadBuyers();
        BuyerAdabter adabter = new BuyerAdabter(buyers);
        recyclerView.setAdapter(adabter);
    }

    private Buyer[] loadBuyers() {
        Buyer buyer1 = new Buyer();
        buyer1.setAddress("Phnom Penh");
        buyer1.setName("Horng");
        buyer1.setPhone_number("012523213");

        Buyer buyer2 = new Buyer();
        buyer1.setAddress("Phnom Penh");
        buyer1.setName("Horng");
        buyer1.setPhone_number("012523213");

        Buyer buyer3 = new Buyer();
        buyer1.setAddress("Phnom Penh");
        buyer1.setName("Horng");
        buyer1.setPhone_number("012523213");

        return new Buyer[]{buyer1, buyer2, buyer3};
    }
}


