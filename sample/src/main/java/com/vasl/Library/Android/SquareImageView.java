package com.vasl.Library.Android;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;

import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.File;

import androidx.appcompat.widget.AppCompatImageView;

/**
 * Created by HamidReza on 20,November,2018
 * Happy Coding ;)
 */
public class SquareImageView extends AppCompatImageView {

    public SquareImageView(Context context) {
        super(context);
    }

    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    public void setImageUrl(File file) {
        try {
            GlideApp
                    .with(getContext())
                    .load(file)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .skipMemoryCache(true)
                    .centerCrop()
                    .into(this);
        } catch (Exception e) {
        }
    }

    public void setImageUrl(Uri url) {
        setImageUrl(url.toString());
    }

    public void setImageUrl(String url) {
        try {
            GlideApp
                    .with(getContext())
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .skipMemoryCache(true)
                    .fitCenter()
                    .into(this);
        } catch (Exception e) {
        }
    }

    public void setImageUrl(String url, int placeHolder) {
        try {
            GlideApp
                    .with(getContext())
                    .load(url)
                    .placeholder(placeHolder)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .skipMemoryCache(true)
                    .centerCrop()
                    .into(this);
        } catch (Exception e) {
        }
    }

    public void setImageUrl(String url, boolean circle) {
        try {
            if (circle) {
                GlideApp
                        .with(getContext())
                        .load(url)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .skipMemoryCache(false)
                        .centerCrop()
                        .optionalCircleCrop()
                        .into(this);
            } else {
                GlideApp
                        .with(getContext())
                        .load(url)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .skipMemoryCache(false)
                        .centerCrop()
                        .into(this);
            }
        } catch (Exception e) {
        }
    }

    public void setImageUrl(int resource) {
        try {
            GlideApp
                    .with(getContext())
                    .load(resource)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .skipMemoryCache(false)
                    .into(this);
        } catch (Exception e) {
        }
    }
}
