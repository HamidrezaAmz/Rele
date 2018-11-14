package com.vasl.recyclerlibrary.customViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import com.vasl.recyclerlibrary.R;

import androidx.appcompat.widget.AppCompatImageView;

public class CustomImageView extends AppCompatImageView {

    private boolean isCircle;

    private String gravity;

    private Context context;

    public CustomImageView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public CustomImageView(Context context, boolean isCircle) {
        super(context);
        this.context = context;
        this.isCircle = isCircle;
        init();
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomImageView);
        isCircle = attributes.getBoolean(R.styleable.CustomImageView_isCircle, true);
        init();
    }

    public void init() {
        // setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent));
    }
}
