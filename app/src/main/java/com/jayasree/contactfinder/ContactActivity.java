package com.jayasree.contactfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import static com.jayasree.contactfinder.DbInfo.COLUMN_ADDRESS;
import static com.jayasree.contactfinder.DbInfo.COLUMN_EMAIL;
import static com.jayasree.contactfinder.DbInfo.COLUMN_ID;
import static com.jayasree.contactfinder.DbInfo.COLUMN_LAND_NO;
import static com.jayasree.contactfinder.DbInfo.COLUMN_MOBLIE_NO;
import static com.jayasree.contactfinder.DbInfo.COLUMN_TALUK;
import static com.jayasree.contactfinder.DbInfo.COLUMN_VILLAGE;
import static com.jayasree.contactfinder.DbInfo.TABLE_NAME;

import java.util.List;

public class ContactActivity extends AppCompatActivity {
    ContactAdapter contactAdapter;
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
              List<Contact> contactsFromTaluke = dbHelper.getContactFrom(contacts.get(i));

               contactAdapter = new ContactAdapter(ContactActivity.this, contactsFromTaluke);

              lvContact.setAdapter(contactAdapter);

          }

          @Override
          public void onNothingSelected(AdapterView<?> adapterView) {

          }
      });


        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contact contact = contactAdapter.getItem(i);

                BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
                Bundle bundle = new Bundle();

                bundle.putInt(COLUMN_ID,contact.getId());
                bundle.putString(COLUMN_TALUK,contact.getTaluk());
                bundle.putString(COLUMN_VILLAGE,contact.getVillage());
                bundle.putString(COLUMN_ADDRESS,contact.getAddress());
                bundle.putString(COLUMN_LAND_NO,contact.getLand_no());
                bundle.putString(COLUMN_MOBLIE_NO,contact.getMoblie_no());
                bundle.putString(COLUMN_EMAIL,contact.getEmail());

                bottomSheetFragment.setArguments(bundle);
                bottomSheetFragment.show(getSupportFragmentManager(),bottomSheetFragment.getTag());
            }
        });
    }
}
