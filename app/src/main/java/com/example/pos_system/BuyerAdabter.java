package com.example.pos_system;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BuyerAdabter extends RecyclerView.Adapter<BuyerViewHolder> {
    private Buyer[] buyers;

    public BuyerAdabter(Buyer[] buyers){
        this.buyers = buyers;
    }
    @NonNull
    @Override
    public BuyerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.view_holder_buyer,parent,false);
        return  new BuyerViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull BuyerViewHolder holder, int position) {
        Buyer buyer = buyers[position];
        holder.bind(buyer);
    }

    @Override
    public int getItemCount() {
        return buyers.length;
    }
}
