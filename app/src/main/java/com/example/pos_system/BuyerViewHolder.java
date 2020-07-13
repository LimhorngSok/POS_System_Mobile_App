package com.example.pos_system;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BuyerViewHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView phone_number;
    private TextView address;

    public BuyerViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        phone_number = itemView.findViewById(R.id.phone_number);
        address = itemView.findViewById(R.id.address);
    }
    public void bind(Buyer buyer){
        name.setText(buyer.getName());
        phone_number.setText(buyer.getPhone_number());
        address.setText(buyer.getAddress());
    }
}
