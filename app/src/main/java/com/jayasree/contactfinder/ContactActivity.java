package com.jayasree.contactfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        final ListView lvContact = findViewById(R.id.lv_contacts);

        final DbHelper dbHelper = new DbHelper(this);
        final List<String> contacts = dbHelper.getAllTaluk();

        Spinner talukeSpinner = findViewById(R.id.spinner_taluk);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, contacts);
        talukeSpinner.setAdapter(adapter);

      talukeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
              Toast.makeText(ContactActivity.this, contacts.get(i), Toast.LENGTH_SHORT).show();
              List<Contact> contactsFromTaluke = dbHelper.getContactFrom(contacts.get(i));

              Toast.makeText(ContactActivity.this, contactsFromTaluke.size()+"", Toast.LENGTH_SHORT).show();
              ContactAdapter contactAdapter = new ContactAdapter(ContactActivity.this, contactsFromTaluke);
              lvContact.setAdapter(contactAdapter);

          }

          @Override
          public void onNothingSelected(AdapterView<?> adapterView) {

          }
      });
    }
}
