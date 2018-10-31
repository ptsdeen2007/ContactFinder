package com.jayasree.contactfinder;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.jayasree.contactfinder.DbInfo.COLUMN_ADDRESS;
import static com.jayasree.contactfinder.DbInfo.COLUMN_EMAIL;
import static com.jayasree.contactfinder.DbInfo.COLUMN_ID;
import static com.jayasree.contactfinder.DbInfo.COLUMN_LAND_NO;
import static com.jayasree.contactfinder.DbInfo.COLUMN_MOBLIE_NO;
import static com.jayasree.contactfinder.DbInfo.COLUMN_TALUK;
import static com.jayasree.contactfinder.DbInfo.COLUMN_VILLAGE;

public class BottomSheetFragment extends BottomSheetDialogFragment {
    String TAG = "vw";

    public BottomSheetFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet, container, false);
        Log.d(TAG, "onCreateView: ");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        int id=getArguments().getInt(COLUMN_ID);
        String taluk = getArguments().getString(COLUMN_TALUK);
        String village = getArguments().getString(COLUMN_VILLAGE);
        String address = getArguments().getString(COLUMN_ADDRESS);
        String land_no = getArguments().getString(COLUMN_LAND_NO);
        String moblie_no = getArguments().getString(COLUMN_MOBLIE_NO);
        String email = getArguments().getString(COLUMN_EMAIL);

        Toast.makeText(getContext(), "village " + village, Toast.LENGTH_SHORT).show();
        TextView tv_taluk = getView().findViewById(R.id.tv_taluk);
        TextView tv_village = getView().findViewById(R.id.tv_village);
        TextView tv_address = getView().findViewById(R.id.tv_address);
        TextView tv_land_no = getView().findViewById(R.id.tv_land_no);
        TextView tv_moblie_no = getView().findViewById(R.id.tv_moblie_no);
        TextView tv_email = getView().findViewById(R.id.tv_email);

        tv_taluk.setText(taluk);
        tv_village.setText(village);
        tv_address.setText(address);
        tv_land_no.setText(land_no);
        tv_moblie_no.setText(moblie_no);
        tv_email.setText(email);

    }
}
