package com.example.contactactivity;

import android.os.Bundle;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContactPendukung extends RecyclerView.Adapter<ContactPendukung.ContactViewHolder> {

    private Context context;
    private List<ContactModel> contactList;

    private static ClickListener clickListener;

    public ContactPendukung(Context context, ArrayList<ContactModel> contactList){
        this.context = context;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        final ContactModel contact = contactList.get(position);
        holder.TampilanName.setText(contact.getName());
        holder.TampilanNumber.setText(contact.getNumber());

        holder.TampilanCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+contact.getNumber()));
            if (ActivityCompat.checkSelfPermission(context,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return;
            }
            context.startActivity(intent);
        });

        holder.TampilanMessage.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("sms:"+contact.getNumber()));
            context.startActivity(intent);
        });

        holder.ContactLayout.setOnClickListener(v -> {
            String dataName = holder.TampilanName.getText().toString();
            String dataNumber = holder.TampilanNumber.getText().toString();
            String dataInstagram = contact.getInstagram();
            String dataGroup = contact.getGroup();

            Intent intent = new Intent(context, KontakDetail.class);
            Bundle bundle = new Bundle();
            bundle.putString("name", dataName);
            bundle.putString("number", dataNumber);
            bundle.putString("instagram", dataInstagram);
            bundle.putString("group", dataGroup);
            intent.putExtras(bundle);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        LinearLayout ContactLayout;
        TextView TampilanName, TampilanNumber, TampilanCall, TampilanMessage, TampilanDelete;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            ContactLayout = itemView.findViewById(R.id.contactLayout);
            TampilanDelete = itemView.findViewById(R.id.Tampilandelete);
            TampilanName = itemView.findViewById(R.id.Tampilanname);
            TampilanNumber = itemView.findViewById(R.id.Tampilannumber);
            TampilanCall = itemView.findViewById(R.id.Tampilancall);
            TampilanMessage = itemView.findViewById(R.id.Tampilanmessage);

            TampilanDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), itemView);
        }
    }

    public void setOnItemClickListener(ContactPendukung.ClickListener clickListener) {
        ContactPendukung.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }
}
