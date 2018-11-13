package com.Vasl.recyclerlibrary.customViews;

import android.content.Context;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

import com.wang.avi.AVLoadingIndicatorView;

public class CustomLoading extends SwipeRefreshLayout {


    private Context context;
    private AVLoadingIndicatorView av;

    public CustomLoading(Context context) {
        super(context);
        this.context = context;
    }

    public CustomLoading(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public void init() {
        av = new AVLoadingIndicatorView(getContext());
        av.setIndicator("LineSpinFadeLoaderIndicator");


    }
}
