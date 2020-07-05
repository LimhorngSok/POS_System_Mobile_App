package com.example.pos_system;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TransactionViewHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView amount;
    private TextView date;

    public TransactionViewHolder(@NonNull View itemView) {
        super(itemView);
    }
    public void bind(Transaction transaction){
        name.setText(transaction.getBuyer());
        amount.setText(transaction.getAmount());
        date.setText(String.valueOf(transaction.getTime()));
    }
}
