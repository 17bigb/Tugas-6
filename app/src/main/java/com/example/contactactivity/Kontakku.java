package com.example.contactactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Kontakku extends AppCompatActivity {

    private RecyclerView recyclerView;

    private TextView option;
    private LinearLayout layAddContact;
    private EditText etName, etNumber, etInstagram, etGroup;
    private Button btnClear, btnSubmit;

    private ArrayList<ContactModel> contactList = new ArrayList<>();
    private ContactPendukung contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontakku);

        recyclerView = findViewById(R.id.recycle_contact);
        recyclerView.setHasFixedSize(true);

        layAddContact = findViewById(R.id.layoutAdd);
        option = findViewById(R.id.tvoption);
        etName = findViewById(R.id.Username);
        etNumber = findViewById(R.id.Usernumber);
        etInstagram = findViewById(R.id.Userinstagram);
        etGroup = findViewById(R.id.Usergroup);
        btnClear = findViewById(R.id.bttnclear);
        btnSubmit = findViewById(R.id.bttnsubmit);

        option.setOnClickListener(v -> {
            if (recyclerView.getVisibility() == View.VISIBLE){
                recyclerView.setVisibility(View.GONE);
                layAddContact.setVisibility(View.VISIBLE);
                clearData();

            }else {
                recyclerView.setVisibility(View.VISIBLE);
                layAddContact.setVisibility(View.GONE);
            }
        });

        btnClear.setOnClickListener(v -> {
            clearData();
        });

        btnSubmit.setOnClickListener(v -> {
            if (etName.getText().toString().equals("") ||
                    etNumber.getText().toString().equals("") ||
                    etInstagram.getText().toString().equals("") ||
                    etGroup.getText().toString().equals("") ){
                Toast.makeText(this, "Please fill in the entire form", Toast.LENGTH_SHORT).show();
            } else {
                contactList.add(new ContactModel(etName.getText().toString(), etNumber.getText().toString(), etGroup.getText().toString(), etInstagram.getText().toString()));
                contactAdapter = new ContactPendukung(this, contactList);
                recyclerView.setAdapter(contactAdapter);
                recyclerView.setVisibility(View.VISIBLE);
                layAddContact.setVisibility(View.GONE);
            }
        });

        contactList.add(new ContactModel("Puan Maharani", "+6222696969", "Dewan Pencuri", "puanmaharani"));
        contactList.add(new ContactModel("Megawati", "+622119020", "Mantan Presiden Katanya", "presidenmegawati"));
        contactList.add(new ContactModel("Maruf Amin", "+6299029384", "Katanya Wapres", "marufAFK"));
        contactList.add(new ContactModel("Ganjar Prabowo", "+6230219235", "Skip", "ganjarPrabowo"));
        contactList.add(new ContactModel("Real Madrid WinUCL2023", "+6215151515", "KING Europe", "realmadrid"));

        contactAdapter = new ContactPendukung(this, contactList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Kontakku.this);
        recyclerView.setLayoutManager(layoutManager);
        contactAdapter.setOnItemClickListener((position, v) -> {
            contactList.remove(position);
            contactAdapter = new ContactPendukung(this, contactList);
            recyclerView.setAdapter(contactAdapter);
        });
        recyclerView.setAdapter(contactAdapter);
    }

    public void clearData(){
        etName.setText("");
        etNumber.setText("");
        etInstagram.setText("");
        etGroup.setText("");
    }
}