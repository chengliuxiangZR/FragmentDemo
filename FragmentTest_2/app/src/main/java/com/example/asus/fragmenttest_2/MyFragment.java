package com.example.asus.fragmenttest_2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment extends Fragment {
    private String content;

    public MyFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle=getArguments();
        content=bundle.getString("content");
        View view=inflater.inflate(R.layout.fg_content,container,false);
        TextView textView=(TextView) view.findViewById(R.id.txt_content);
        textView.setText(content);
        return view;
    }
}
