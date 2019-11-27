package com.example.dataview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class userAdapter extends RecyclerView.Adapter<userAdapter.userViewHolder>{
    static List<user> data = new ArrayList<>();

    public userAdapter(Runnable runnable, List<user> users) {
        this.data = users;
    }

    @NonNull
    @Override
    public userViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user, parent, false);
        return new userViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull userViewHolder holder, int position){
        holder.txvId.setText(data.get(position).userId +"");
        holder.edName.setText(data.get(position).name);
    }

    @Override
    public int getItemCount(){
        if (data == null) {
            return 0;
        }
        return data.size();
    }

    class userViewHolder extends RecyclerView.ViewHolder{
        TextView txvId;
        EditText edName;

        public userViewHolder(@NonNull View itemView) {
            super(itemView);
            txvId = itemView.findViewById(R.id.edtId);
            edName = itemView.findViewById(R.id.edtName);
        }
    }
}
