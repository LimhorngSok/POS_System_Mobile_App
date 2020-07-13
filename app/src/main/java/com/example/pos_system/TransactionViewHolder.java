package com.example.pos_system;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TransactionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView name;
    private TextView amount;
    private TextView date;
    TransactionAdapter.onTransactionListener onTransactionListener;

    public TransactionViewHolder(@NonNull View itemView, TransactionAdapter.onTransactionListener onTransactionListener) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        amount = itemView.findViewById(R.id.amount);
        date = itemView.findViewById(R.id.date);
        this.onTransactionListener = onTransactionListener;
        itemView.setOnClickListener(this);
    }
    public void bind(Transaction transaction){
        name.setText(transaction.getName());
        amount.setText(transaction.getAmount());
        date.setText(transaction.getDate());
    }

    @Override
    public void onClick(View v) {
        onTransactionListener.onTransactionClick(getAdapterPosition());
    }
}
