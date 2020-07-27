package com.rustfisher.tutorial2020.ndk;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.rustfisher.fishpole.worker.BaseParam;
import com.rustfisher.fishpole.worker.FisherTom;
import com.rustfisher.fishpole.worker.Jerry;
import com.rustfisher.tutorial2020.AbsGuideAct;
import com.rustfisher.tutorial2020.cal.CalUtil;
import com.rustfisher.tutorial2020.widget.GuideAdapter;

import java.util.Arrays;

public class NDKGuide extends AbsGuideAct {
    private CalUtil mCalUtil = new CalUtil();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FisherTom tom = new FisherTom();
        Jerry jerry = new Jerry();

        mGuideAdapter.setDataList(Arrays.asList(
                new GuideAdapter.OptionItem(-1, mCalUtil.getMsg() + mCalUtil.getNumber()),
                new GuideAdapter.OptionItem(-1, tom.name() + ": int: " + tom.addFish(1, 2) + ", float: " + tom.calFish(2, 3.4f)),
                new GuideAdapter.OptionItem(-1, jerry.name() + ": int: " + jerry.addFish(1, 2) + ", float: " + jerry.calFish(2, 3.4f)),
                new GuideAdapter.OptionItem(-1, "123456 -> " + jerry.reverseString("123456"))
        ));

        demoBaseParam();
    }

    private void demoBaseParam() {
        BaseParam baseParam = new BaseParam();
        Log.d(TAG, "返回int     " + baseParam.nInt());
        Log.d(TAG, "返回char    " + baseParam.nChar());
        Log.d(TAG, "返回byte    " + baseParam.nByte());
        Log.d(TAG, "返回short   " + baseParam.nShort());
        Log.d(TAG, "返回long    " + baseParam.nLong());
        Log.d(TAG, "返回float   " + baseParam.nFloat());
        Log.d(TAG, "返回double  " + baseParam.nDouble());
        Log.d(TAG, "返回boolean " + baseParam.nBool());

        int[] genArr1 = baseParam.nGenIntArray();
        StringBuilder sb1 = new StringBuilder();
        for (int a : genArr1) {
            sb1.append(a).append(" ");
        }
        Log.d(TAG, "生成int数组  " + sb1.toString());

        baseParam.nModifyIntArray(genArr1);
        sb1 = new StringBuilder();
        for (int a : genArr1) {
            sb1.append(a).append(" ");
        }
        Log.d(TAG, "修改后的int数组: " + sb1.toString());

        Log.d(TAG, "NDK新建对象 " + baseParam.nGetCarp("Carp1", 1, 1.1f, true));
    }

}
