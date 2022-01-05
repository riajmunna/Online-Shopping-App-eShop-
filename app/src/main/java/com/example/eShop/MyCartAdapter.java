package com.example.eShop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.MyViewHolder>{

    Context context;
    ArrayList<MyCartModel> myCartModels;

    public MyCartAdapter(Context context, ArrayList<MyCartModel> myCartModels) {
        this.context = context;
        this.myCartModels = myCartModels;
    }

    @NonNull
    @Override
    public MyCartAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCartAdapter.MyViewHolder holder, int position) {
        MyCartModel myCartModel = myCartModels.get(position);
        holder.description.setText(myCartModel.description);
        holder.price.setText(myCartModel.price);
        holder.code.setText(myCartModel.code);
        holder.date.setText(myCartModel.date);
    }

    @Override
    public int getItemCount() {
        return myCartModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView description,price,code,date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.price);
            code = itemView.findViewById(R.id.code);
            date = itemView.findViewById(R.id.date);

        }
    }
}
