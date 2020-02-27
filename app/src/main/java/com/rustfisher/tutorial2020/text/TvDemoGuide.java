package com.rustfisher.tutorial2020.text;

import android.content.Intent;
import android.os.Bundle;

import com.rustfisher.tutorial2020.AbsGuideAct;
import com.rustfisher.tutorial2020.widget.GuideAdapter;

import java.util.Arrays;

public class TvDemoGuide extends AbsGuideAct {
    private static final int K_ACT_TEXT_HTML = 2;
    private static final int K_T_STYLE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGuideAdapter.setDataList(Arrays.asList(
                new GuideAdapter.OptionItem(K_T_STYLE, "字体"),
                new GuideAdapter.OptionItem(K_ACT_TEXT_HTML, "Text html")
        ));
        mGuideAdapter.setOnItemClickListener(new GuideAdapter.OnOptClickListener() {
            @Override
            public void onClick(GuideAdapter.OptionItem item) {
                switch (item.num) {
                    case K_ACT_TEXT_HTML:
                        startActivity(new Intent(getApplicationContext(), TextHtmlDemo.class));
                        break;
                    case K_T_STYLE:
                        startActivity(new Intent(getApplicationContext(), TextStyleDemo.class));
                        break;
                }
            }
        });
    }

}
