package com.test.pingu.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.test.pingu.R;

public class CommonDialog {

    public static final int TYPE_ONE_BUTTON = 1;

    private TextView titleTv;
    private TextView contentTv;
    private TextView cancelTv;
    private TextView okTv;
    private Dialog dialog;
    private Context context;

    private PopupWindow mPopWindow;

    public CommonDialog(Context context,View rootview){
        this.context = context;
        View view = View.inflate(context,R.layout.common_dialog,null);

        mPopWindow = new PopupWindow(view,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);

        mPopWindow.setFocusable(true);
        mPopWindow.setTouchable(true);
        mPopWindow.setOutsideTouchable(true);
        mPopWindow.setBackgroundDrawable(new BitmapDrawable(context.getResources(), (Bitmap) null));

        mPopWindow.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);

        okTv = view.findViewById(R.id.ok_btn);
        okTv.setEnabled(false);
        okTv.setBackgroundResource(R.drawable.dialog_btn_pressed);
        view.findViewById(R.id.img_close).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mPopWindow.dismiss();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.layout_dialog_id){
                    //mPopWindow.dismiss();
                }
            }
        });

        view.findViewById(R.id.txt_3_id).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                setTextEnable(v,R.id.txt_3_id);
            }
        });

        view.findViewById(R.id.txt_2_id).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                setTextEnable(v,R.id.txt_2_id);
            }
        });

        view.findViewById(R.id.txt_1_id).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                setTextEnable(v,R.id.txt_1_id);
            }
        });

        view.findViewById(R.id.txt_4_id).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                setTextEnable(v,R.id.txt_4_id);
            }
        });

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
        okTv.setEnabled(true);
        //okTv.setBackgroundColor(context.getResources().getColor(R.color.color_msg_text));
        okTv.setBackgroundResource(R.drawable.dialog_btn_normal);
    }

    public CommonDialog(Context context, int type){
        dialog = new Dialog(context,R.style.common_dialog_style);
        dialog.setCancelable(false);
        View view = View.inflate(context,R.layout.common_dialog,null);
        dialog.setContentView(view);
        //titleTv = view.findViewById(R.id.tv_title);
        contentTv = view.findViewById(R.id.content_txt);
        okTv = view.findViewById(R.id.ok_btn);
    }

    public CommonDialog setTitle(String str){
        titleTv.setText(str);
        return this;
    }

    public CommonDialog setContent(String str){
        contentTv.setText(str);
        return this;
    }
    public CommonDialog setOkName(String str){
        okTv.setText(str);
        return this;
    }
    public CommonDialog setCancelName(String str){
        if(str == null) {
            cancelTv.setVisibility(View.GONE);
        }else{
            cancelTv.setText(str);
            cancelTv.setVisibility(View.VISIBLE);
        }

        return this;
    }

    public CommonDialog setOkListener(View.OnClickListener okListener){
        okTv.setOnClickListener(okListener);
        return this;
    }

    public CommonDialog setCancelListener(View.OnClickListener cancelListener){
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

    public CommonDialog setOkString(String okString) {
        okTv.setText(okString);
        return this;
    }

    public Window getWindow() {
        return dialog.getWindow();
    }
}
