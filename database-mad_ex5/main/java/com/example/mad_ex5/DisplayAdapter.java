package com.example.mad_ex5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DisplayAdapter extends RecyclerView.Adapter<DisplayAdapter.ViewHolder>{
    private ArrayList<PersonalInfoModal> PersonalInfoList;
    private Context context;

    // constructor 
    public DisplayAdapter(ArrayList<PersonalInfoModal> PersonalInfoList, Context context) {
        this.PersonalInfoList = PersonalInfoList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.personal_info_record, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        PersonalInfoModal modal = PersonalInfoList.get(position);
        holder.name.setText(modal.getName());
        holder.addr.setText(modal.getAddress());
        holder.phone.setText(modal.getPhone());
        holder.email.setText(modal.getEmail());
    }

    @Override
    public int getItemCount() {
        return PersonalInfoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name, addr, phone, email;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name2);
            addr = itemView.findViewById(R.id.addr2);
            phone = itemView.findViewById(R.id.phone2);
            email = itemView.findViewById(R.id.email2);
        }
    }
}
