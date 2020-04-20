package com.test.test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class HeaderBar extends FrameLayout implements View.OnClickListener {
    private Context context;
    private LinearLayout back_iv;
    private TextView title_txt;
    private TextView done_btn;
    private OnHeaderBarClickListener clickListener;
    private OnDoneClickListener doneClickListener;

    public void setClickListener(OnHeaderBarClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setDoneClickListener(OnDoneClickListener doneClickListener) {
        this.doneClickListener = doneClickListener;
    }

    public HeaderBar(@NonNull Context context) {
        super(context);
    }
    public HeaderBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }
    public HeaderBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        View mRootView = LayoutInflater.from(context).inflate(R.layout.common_header_bar, null);
        this.addView(mRootView);
        back_iv = (LinearLayout)mRootView.findViewById(R.id.back_iv);
        title_txt = (TextView)mRootView.findViewById(R.id.title_txt);
        done_btn = (TextView)mRootView.findViewById(R.id.header_bar_done_btn);
        back_iv.setOnClickListener(this);
        done_btn.setOnClickListener(this);
    }

    public void setTitleText(String title) {
        title_txt.setText(title);
    }

    public void hideBack() {
        back_iv.setVisibility(View.GONE);
    }
    public void showDoneBtn(){
        done_btn.setVisibility(View.VISIBLE);
    }

    public void showDoneBtn(String tittle){
        done_btn.setText(tittle);
        done_btn.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.back_iv) {
            if(clickListener != null) {
                clickListener.back();
            }
        }
        else if(v.getId() == R.id.header_bar_done_btn){
            if(doneClickListener != null){
                doneClickListener.done();
            }
        }
    }

    public interface OnHeaderBarClickListener {
        void back();
    }
    public interface OnDoneClickListener{
        void done();
    }
}
