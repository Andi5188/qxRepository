package com.test.pingu.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.test.pingu.R;

public class CommonXingDialog implements View.OnClickListener{

    public static final int TYPE_ONE_BUTTON = 1;

    private TextView titleTv;
    private TextView contentTv;
    private TextView cancelTv;
    private TextView okTv;
    private Dialog dialog;

    private CheckBox ck1,ck2,ck3,ck4,ck5;
    private TextView t1,t2,t3,t4,t5;

    private PopupWindow mPopWindow;
    private Context context;

    public CommonXingDialog(Context context, View rootview){
        this.context = context;
        View view = View.inflate(context,R.layout.common_xing_dialog,null);

        mPopWindow = new PopupWindow(view,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);

        mPopWindow.setFocusable(true);
        mPopWindow.setTouchable(true);
        mPopWindow.setOutsideTouchable(true);
        mPopWindow.setBackgroundDrawable(new BitmapDrawable(context.getResources(), (Bitmap) null));

        mPopWindow.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);

        okTv = view.findViewById(R.id.ok_btn);
        okTv.setEnabled(false);
        //okTv.setBackgroundColor(context.getResources().getColor(R.color.color_grey));
        okTv.setBackgroundResource(R.drawable.dialog_btn_pressed);
        view.findViewById(R.id.img_close).setOnClickListener(new View.OnClickListener() {
                                                                 @Override
                                                                 public void onClick(View v) {
                                                                     mPopWindow.dismiss();
                                                                 }
                                                             }
        );

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.layout_dialog_id){
                    //mPopWindow.dismiss();
                }
            }
        });

        (ck5 = (CheckBox) view.findViewById(R.id.ck_5_id)).setOnClickListener(this);
        (ck4 = (CheckBox) view.findViewById(R.id.ck_4_id)).setOnClickListener(this);
        (ck3 = (CheckBox) view.findViewById(R.id.ck_3_id)).setOnClickListener(this);
        (ck2 = (CheckBox) view.findViewById(R.id.ck_2_id)).setOnClickListener(this);
        (ck1 = (CheckBox) view.findViewById(R.id.ck_1_id)).setOnClickListener(this);

        t1 = (TextView)view.findViewById(R.id.txt_1);
        t2 = (TextView)view.findViewById(R.id.txt_2);
        t3 = (TextView)view.findViewById(R.id.txt_3);
        t4 = (TextView)view.findViewById(R.id.txt_4);
        t5 = (TextView)view.findViewById(R.id.txt_5);

        view.findViewById(R.id.ok_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopWindow.dismiss();
            }
        });
    }

    public void setTextEnable(View v,int Rid){
        View textView = v.findViewById(Rid);
        textView.setEnabled(!textView.isEnabled());
    }

    public CommonXingDialog(Context context, int type){
        dialog = new Dialog(context,R.style.common_dialog_style);
        dialog.setCancelable(false);
        View view = View.inflate(context,R.layout.common_dialog,null);
        dialog.setContentView(view);
        //titleTv = view.findViewById(R.id.tv_title);
        contentTv = view.findViewById(R.id.content_txt);
        okTv = view.findViewById(R.id.ok_btn);
    }

    public CommonXingDialog setTitle(String str){
        titleTv.setText(str);
        return this;
    }

    public CommonXingDialog setContent(String str){
        contentTv.setText(str);
        return this;
    }
    public CommonXingDialog setOkName(String str){
        okTv.setText(str);
        return this;
    }
    public CommonXingDialog setCancelName(String str){
        if(str == null) {
            cancelTv.setVisibility(View.GONE);
        }else{
            cancelTv.setText(str);
            cancelTv.setVisibility(View.VISIBLE);
        }

        return this;
    }

    public CommonXingDialog setOkListener(View.OnClickListener okListener){
        okTv.setOnClickListener(okListener);
        return this;
    }

    public CommonXingDialog setCancelListener(View.OnClickListener cancelListener){
        cancelTv.setOnClickListener(cancelListener);
        return this;
    }

    public void showDialog(){
        if(!dialog.isShowing()){
            dialog.show();
        }
    }

    public void dimiss(){
        dialog.dismiss();
    }

    public CommonXingDialog setOkString(String okString) {
        okTv.setText(okString);
        return this;
    }

    public Window getWindow() {
        return dialog.getWindow();
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.ck_5_id){
            if(ck5.isChecked()){
                setCheckOnOff(5,true);
            }else{
                setCheckOnOff(5,false);
            }
        }

        if(v.getId() == R.id.ck_4_id){
            if(ck4.isChecked()){
                setCheckOnOff(4,true);
            }else{
                setCheckOnOff(4,false);
            }
        }

        if(v.getId() == R.id.ck_3_id){
            if(ck3.isChecked()){
                setCheckOnOff(3,true);
            }else{
                setCheckOnOff(3,false);
            }
        }

        if(v.getId() == R.id.ck_2_id){
            if(ck2.isChecked()){
                setCheckOnOff(2,true);
            }else{
                setCheckOnOff(2,false);
            }
        }

        if(v.getId() == R.id.ck_1_id){
            if(ck1.isChecked()){
                setCheckOnOff(1,true);
            }else{
                setCheckOnOff(1,false);
            }
        }

        if(checkAllCheckState()){
            okTv.setEnabled(true);
            //okTv.setBackgroundColor(context.getResources().getColor(R.color.color_msg_text));
            okTv.setBackgroundResource(R.drawable.dialog_btn_normal);
        }else{
            okTv.setEnabled(false);
            //okTv.setBackgroundColor(context.getResources().getColor(R.color.color_grey));
            okTv.setBackgroundResource(R.drawable.dialog_btn_pressed);
        }
    }

    public void setCheckOnOff(int index,boolean b){
        switch (index){
            case 5:{
                ck5.setChecked(b);
                ck4.setChecked(b);
                ck3.setChecked(b);
                ck2.setChecked(b);
                ck1.setChecked(b);

                setAllText(5);

            }break;
            case 4:{
                ck5.setChecked(false);
                ck4.setChecked(b);
                ck3.setChecked(b);
                ck2.setChecked(b);
                ck1.setChecked(b);

                setAllText(4);
            }break;
            case 3:{
                ck5.setChecked(false);
                ck4.setChecked(false);
                ck3.setChecked(b);
                ck2.setChecked(b);
                ck1.setChecked(b);
                setAllText(3);
            }break;
            case 2:{
                ck5.setChecked(false);
                ck4.setChecked(false);
                ck3.setChecked(false);
                ck2.setChecked(b);
                ck1.setChecked(b);
                setAllText(2);
            }break;
            case 1:{
                ck5.setChecked(false);
                ck4.setChecked(false);
                ck3.setChecked(false);
                ck2.setChecked(false);
                ck1.setChecked(b);
                setAllText(1);
            }break;
        }
    }

    private boolean checkAllCheckState(){
        return ck5.isChecked() || ck1.isChecked() || ck2.isChecked() || ck3.isChecked() || ck4.isChecked();
    }

    private void setAllText(int index){
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");

        if(index == 1 && ck1.isChecked()){
            t1.setText("非常不满意");
        }
        if(index == 2 && ck2.isChecked()){
            t2.setText("不满意");
        }
        if(index == 3 && ck3.isChecked()){
            t3.setText("基本满意");
        }
        if(index == 4 && ck4.isChecked()){
            t4.setText("满意");
        }
        if(index == 5 && ck5.isChecked()){
            t5.setText("非常满意");
        }
    }

}
