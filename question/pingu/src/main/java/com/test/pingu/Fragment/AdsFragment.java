package com.test.pingu.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.pingu.R;
import com.test.pingu.views.MatchSupportProgressBar;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class AdsFragment extends Fragment {

    private MatchSupportProgressBar mspb;
    private MatchSupportProgressBar mspb2;
    private MatchSupportProgressBar mspb3;
    private MatchSupportProgressBar mspb4;

    private boolean bSelect = false;

    private Context context;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View deviceView = inflater.inflate(R.layout.ads_fragment,container, false);
        initView(deviceView);

        return deviceView ;//super.onCreateView(inflater, container, savedInstanceState);
    }

    private void initView(View deviceView){
        mspb = (MatchSupportProgressBar) deviceView.findViewById(R.id.progressbar_match_support);
        mspb.setOnRightTextClickListener(new MatchSupportProgressBar.OnRightTextClickListener() {

            @Override
            public void onClick(int position) {
                selectSupport(mspb,position);
            }
        });

        mspb2 = (MatchSupportProgressBar) deviceView.findViewById(R.id.progressbar_match_support_2);

        mspb2.setOnRightTextClickListener(new MatchSupportProgressBar.OnRightTextClickListener() {

            @Override
            public void onClick(int position) {
                selectSupport(mspb2,position);
            }
        });

        mspb3 = (MatchSupportProgressBar) deviceView.findViewById(R.id.progressbar_match_support_3);

        mspb3.setOnRightTextClickListener(new MatchSupportProgressBar.OnRightTextClickListener() {

            @Override
            public void onClick(int position) {
                selectSupport(mspb3,position);
            }
        });

        mspb4 = (MatchSupportProgressBar) deviceView.findViewById(R.id.progressbar_match_support_4);
        mspb4.setOnRightTextClickListener(new MatchSupportProgressBar.OnRightTextClickListener() {

            @Override
            public void onClick(int position) {
                selectSupport(mspb4,position);
            }
        });
    }

    public void selectSupport(MatchSupportProgressBar ms,int position){
        if(ms == mspb){
            mspb.setPercentState(getPercentList("20","90","100"), getCheckList(position), true, true);

            mspb2.setReachColor(this.getResources().getColor(R.color.stroke_bg));
            mspb2.setPercentState(getPercentList("30","90","100"), getCheckList(position), true, true);

            mspb3.setReachColor(this.getResources().getColor(R.color.stroke_bg));
            mspb3.setPercentState(getPercentList("50","90","100"), getCheckList(position), true, true);

            mspb4.setReachColor(this.getResources().getColor(R.color.stroke_bg));
            mspb4.setPercentState(getPercentList("10","90","100"), getCheckList(position), true, true);

        }else if(ms == mspb2){
            mspb.setReachColor(this.getResources().getColor(R.color.stroke_bg));
            mspb.setPercentState(getPercentList("20","90","100"), getCheckList(position), true, true);

            mspb2.setPercentState(getPercentList("30","90","100"), getCheckList(position), true, true);

            mspb3.setReachColor(this.getResources().getColor(R.color.stroke_bg));
            mspb3.setPercentState(getPercentList("50","90","100"), getCheckList(position), true, true);

            mspb4.setReachColor(this.getResources().getColor(R.color.stroke_bg));
            mspb4.setPercentState(getPercentList("10","90","100"), getCheckList(position), true, true);

        }else if(ms == mspb3){
            mspb.setReachColor(this.getResources().getColor(R.color.stroke_bg));
            mspb.setPercentState(getPercentList("20","90","100"), getCheckList(position), true, true);

            mspb2.setReachColor(this.getResources().getColor(R.color.stroke_bg));
            mspb2.setPercentState(getPercentList("30","90","100"), getCheckList(position), true, true);

            mspb3.setPercentState(getPercentList("50","90","100"), getCheckList(position), true, true);

            mspb4.setReachColor(this.getResources().getColor(R.color.stroke_bg));
            mspb4.setPercentState(getPercentList("10","90","100"), getCheckList(position), true, true);
        }else if(ms == mspb4){
            mspb.setReachColor(this.getResources().getColor(R.color.stroke_bg));
            mspb.setPercentState(getPercentList("20","90","100"), getCheckList(position), true, true);

            mspb2.setReachColor(this.getResources().getColor(R.color.stroke_bg));
            mspb2.setPercentState(getPercentList("30","90","100"), getCheckList(position), true, true);

            mspb3.setReachColor(this.getResources().getColor(R.color.stroke_bg));
            mspb3.setPercentState(getPercentList("50","90","100"), getCheckList(position), true, true);

            mspb4.setPercentState(getPercentList("10","90","100"), getCheckList(position), true, true);
        }
    }

    /**
     * 获取选中的progress的位置
     * @param spf
     * @return
     */
    private ArrayList<Boolean> getCheckList(int spf) {
        ArrayList<Boolean> isCheckList = new ArrayList<Boolean>();
        switch (spf) {
            case 0:
                isCheckList.add(true);
                isCheckList.add(false);
                isCheckList.add(false);
                break;
            case 1:
                isCheckList.add(false);
                isCheckList.add(true);
                isCheckList.add(false);
                break;
            case 2:
                isCheckList.add(false);
                isCheckList.add(false);
                isCheckList.add(true);
                break;
        }
        return isCheckList;
    }

    /**
     * 获取百分比字符串集合
     */
    private ArrayList<String> getPercentList(String str1, String str2, String str3) {
        ArrayList<String> percentList = new ArrayList<String>();
        percentList.add(str1);
        percentList.add(str2);
        percentList.add(str3);
        return percentList;

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

}
