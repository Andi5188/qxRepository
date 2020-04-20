package com.test.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.test.pingu.dialog.CommonDialog;
import com.test.pingu.dialog.CommonXingDialog;

public class ActvityTest extends Activity implements View.OnClickListener {

    private HeaderBar header_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test);

        header_bar = (HeaderBar)findViewById(R.id.header_bar);
        header_bar.setTitleText("评价");
        header_bar.setClickListener(new HeaderBar.OnHeaderBarClickListener() {
            @Override
            public void back() {
                ActvityTest.this.finish();
            }
        });

        findViewById(R.id.done_btn).setOnClickListener(this);
        findViewById(R.id.done_btn_2).setOnClickListener(this);
    }

    private void showDialog(String title){
        try{

            View rootview = LayoutInflater.from(this).inflate(R.layout.activity_test, null);

            CommonDialog commonDialog = new CommonDialog(this,rootview);
            commonDialog.showDialog();
            commonDialog.setContent(title).
                    setCancelListener(v -> commonDialog.dimiss())
                    .setOkListener(v -> {
                        commonDialog.dimiss();
                    });

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void showCommonXingDialog(String title){
        try{

            View rootview = LayoutInflater.from(this).inflate(R.layout.activity_test, null);

            CommonXingDialog commonDialog = new CommonXingDialog(this,rootview);
            commonDialog.showDialog();
            commonDialog.setContent(title).
                    setCancelListener(v -> commonDialog.dimiss())
                    .setOkListener(v -> {
                        commonDialog.dimiss();
                    });

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.done_btn_2){
            showCommonXingDialog("评价");
        }else{
            showDialog("我的期望的口味");
        }

    }
}
