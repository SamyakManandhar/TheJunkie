package com.example.myapplication22;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
    DatabaseHelper databaseHelper;
    TextView username, address;
    String id;
    //ImageView imageview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_layout,null);
        databaseHelper = new DatabaseHelper(getActivity());
        username = view.findViewById(R.id.username);
        //imageview = view.findViewById(R.id.image);
        address = view.findViewById(R.id.address);
        UserInfo info = databaseHelper.getUserinfo(id);
        username.setText(info.username);
        address.setText(info.address);
        return view;
    }
}
