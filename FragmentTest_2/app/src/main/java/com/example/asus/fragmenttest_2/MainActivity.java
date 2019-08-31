package com.example.asus.fragmenttest_2;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView txt_1;
    private TextView txt_2;
    private TextView txt_3;
    private TextView txt_4;
    private FrameLayout ly_content;
    private MyFragment fg1,fg2,fg3,fg4;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager=getSupportFragmentManager();
        bindViews();
        txt_1.performClick();
    }
    private void bindViews(){
        txt_1=(TextView)findViewById(R.id.txt_1);
        txt_2=(TextView)findViewById(R.id.txt_2);
        txt_3=(TextView)findViewById(R.id.txt_3);
        txt_4=(TextView)findViewById(R.id.txt_4);
        ly_content=(FrameLayout)findViewById(R.id.ly_content);
        txt_1.setOnClickListener(this);
        txt_2.setOnClickListener(this);
        txt_3.setOnClickListener(this);
        txt_4.setOnClickListener(this);
    }
    private void setSelected(){
        txt_1.setSelected(false);
        txt_2.setSelected(false);
        txt_3.setSelected(false);
        txt_4.setSelected(false);
    }
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg1!=null) fragmentTransaction.hide(fg1);
        if(fg2!=null) fragmentTransaction.hide(fg2);
        if(fg3!=null) fragmentTransaction.hide(fg3);
        if(fg4!=null) fragmentTransaction.hide(fg4);
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        hideAllFragment(fragmentTransaction);
        switch (view.getId()){
            case R.id.txt_1:
                setSelected();
                txt_1.setSelected(true);
                if(fg1==null){
                    fg1=new MyFragment();
                    Bundle bundle=new Bundle();
                    bundle.putString("content","第一个Fragment");
                    fg1.setArguments(bundle);
                    fragmentTransaction.add(R.id.ly_content,fg1);
                }else {
                    fragmentTransaction.show(fg1);
                }
                break;
            case R.id.txt_2:
                setSelected();
                txt_2.setSelected(true);
                if(fg2==null){
                    fg2=new MyFragment();
                    Bundle bundle=new Bundle();
                    bundle.putString("content","第二个Fragment");
                    fg2.setArguments(bundle);
                    fragmentTransaction.add(R.id.ly_content,fg2);
                }else {
                    fragmentTransaction.show(fg2);
                }
                break;
            case R.id.txt_3:
                setSelected();
                txt_3.setSelected(true);
                if(fg3==null){
                    fg3=new MyFragment();
                    Bundle bundle=new Bundle();
                    bundle.putString("content","第三个Fragment");
                    fg3.setArguments(bundle);
                    fragmentTransaction.add(R.id.ly_content,fg3);
                }else {
                    fragmentTransaction.show(fg3);
                }
                break;
            case R.id.txt_4:
                setSelected();
                txt_4.setSelected(true);
                if(fg4==null){
                    fg4=new MyFragment();
                    Bundle bundle=new Bundle();
                    bundle.putString("content","第四个Fragment");
                    fg4.setArguments(bundle);
                    fragmentTransaction.add(R.id.ly_content,fg4);
                }else {
                    fragmentTransaction.show(fg4);
                }
                break;
        }
        fragmentTransaction.commit();
    }
}
