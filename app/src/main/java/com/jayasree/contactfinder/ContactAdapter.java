package com.jayasree.contactfinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends BaseAdapter {
    Context ctx;
    List<Contact> contactList;
    List<Contact> contactAllList;
    private final LayoutInflater inflater;

    public ContactAdapter(Context ctx, List<Contact> contactList) {
        this.ctx = ctx;
        this.contactList = contactList;
        contactAllList = new ArrayList<>();
        contactAllList.addAll(contactList);
        inflater = LayoutInflater.from(ctx);

    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Contact getItem(int i) {
        return contactList.get(i);
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

     public void filter(String villageTaluke) {
        String villageTalukeSmall = villageTaluke.toLowerCase();
        contactList.clear();
        if (villageTalukeSmall.length() == 0) {
            contactList.addAll(contactAllList);
        }else {
            for (Contact contact:contactAllList) {
                if (contact.village.toLowerCase().contains(villageTaluke) ||
                        contact.taluk.toLowerCase().contains(villageTaluke) && contact.village.isEmpty()
                        ){
                    contactList.add(contact);
                }
            }
        }
        notifyDataSetChanged();
    }
}
