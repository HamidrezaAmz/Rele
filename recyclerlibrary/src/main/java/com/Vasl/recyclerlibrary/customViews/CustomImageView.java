package com.Vasl.recyclerlibrary.customViews;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.appcompat.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.Vasl.recyclerlibrary.R;

public class CustomImageView extends AppCompatImageView {

    boolean isCircle;
    String gravity;
    private Context context;

    public CustomImageView(Context context) {
        super(context);
        this.context = context;
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
