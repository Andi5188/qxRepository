package com.test.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.test.pingu.Fragment.AdsFragment;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {

    private FragmentManager  fragmentManager;
    private FragmentTransaction transaction;
    private AdsFragment adsFragment;

    private Button bt;
    private Button bt_dilog_2;
    private boolean bshow = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = this.getSupportFragmentManager();

        bt = ((Button)this.findViewById(R.id.bt_dilog));

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ActvityTest.class);
                startActivity(intent);
            }
        });

        bt_dilog_2  = ((Button)this.findViewById(R.id.bt_dilog_2));
        bt_dilog_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment();
            }
        });
        showFragment();
    }


    private void showFragment(){
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if(bshow){
            hideFragment(transaction);
        }else{
            //if (adsFragment == null)
            {
                adsFragment = new AdsFragment();
                //adsFragment.setMainActivity(this);
                transaction.add(R.id.content, adsFragment);
            }
//            else {
//                transaction.show(adsFragment);
//            }
            bshow = true;
        }

        transaction.commitAllowingStateLoss();
    }

    private void hideFragment(FragmentTransaction transaction){
        if(adsFragment != null) {
            transaction.hide(adsFragment);
            bshow = false;
        }
    }
}
