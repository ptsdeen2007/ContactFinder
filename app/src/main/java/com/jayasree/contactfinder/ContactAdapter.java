package com.jayasree.contactfinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends BaseAdapter {
    Context ctx;
    List<Contact> contactList;

    public ContactAdapter(Context ctx, List<Contact> contactList) {
        this.ctx = ctx;
        this.contactList = contactList;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        Contact contact = contactList.get(i);
        if (view==null){
            LayoutInflater inflater = LayoutInflater.from(ctx);
            view=inflater.inflate(R.layout.single_row_of_contact, null);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder)view.getTag();
        }
        viewHolder.tvVillage.setText(contact.getVillage());
        viewHolder.tvMobile.setText(contact.getMoblie_no());

        return view;
    }

    class ViewHolder{
        TextView tvVillage;
        TextView tvMobile;

        public ViewHolder(View view) {
            this.tvVillage = view.findViewById(R.id.tv_village);
            this.tvMobile = view.findViewById(R.id.tv_mobile);
        }
    }
}
