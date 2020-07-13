package com.example.pos_system;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionViewHolder> {
    private Transaction[] transactions;
    private onTransactionListener onTransactionListener;

    public TransactionAdapter(Transaction[] transactions, onTransactionListener onTransactionListener){
        this.transactions = transactions;
        this.onTransactionListener = onTransactionListener;
    }
    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.view_holder_transaction,parent,false);
        return  new TransactionViewHolder(itemView,onTransactionListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
        Transaction transaction = transactions[position];
        holder.bind(transaction);
    }

    @Override
    public int getItemCount() {
        return transactions.length;
    }
    public interface onTransactionListener{
        void onTransactionClick(int position);
    }
}
