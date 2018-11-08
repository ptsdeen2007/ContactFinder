package com.jayasree.contactfinder;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ContactActivity extends AppCompatActivity {
    ContactAdapter contactAdapter;
    private String all;
    private ListView lvContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        lvContact = findViewById(R.id.lv_contacts);

        final DbHelper dbHelper = new DbHelper(this);
        final List<String> contacts = dbHelper.getAllTaluk();
        all = "All";
        contacts.add(all);
        Collections.sort(contacts);
        Spinner talukeSpinner = findViewById(R.id.spinner_taluk);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, contacts);
        talukeSpinner.setAdapter(adapter);

      talukeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
              String taluk = contacts.get(i);
              List<Contact> contactsFromTaluke =taluk.equals(all) ? dbHelper.getAllContact(): dbHelper.getContactFrom(taluk);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        SearchManager searchManager = (SearchManager)
                getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchMenuItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) searchMenuItem.getActionView();

        searchView.setSearchableInfo(searchManager.
                getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        searchView.setQueryHint("Search Village or Taluk");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
//                Toast.makeText(ContactActivity.this, "submitted", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ContactAdapter adapter = (ContactAdapter) lvContact.getAdapter();
                adapter.filter(s);

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.app_bar_search:{
                Toast.makeText(this, "menu cliked", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
