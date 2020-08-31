package com.vasl.recyclerlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.vasl.recyclerlibrary.databinding.LayoutMyCustomViewBinding;
import com.vasl.recyclerlibrary.globalEnums.ListStatus;
import com.vasl.recyclerlibrary.globalEnums.ScrollDirection;
import com.vasl.recyclerlibrary.globalInterfaces.MyCustomViewCallBack;
import com.vasl.recyclerlibrary.globalInterfaces.MyCustomViewScrollCallBack;
import com.vasl.recyclerlibrary.utils.PublicFunction;

public class MyCustomView extends RelativeLayout implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    private Context context;
    private LayoutMyCustomViewBinding myCustomViewBinding;
    private MyCustomViewCallBack myCustomViewCallBack;
    private MyCustomViewScrollCallBack myCustomViewScrollCallBack;

    int titleColor, subtitleColor, retryButtonColor, retryButtonTextColor, iconTintColor;

    public void setMyCustomViewCallBack(MyCustomViewCallBack myCustomViewCallBack) {
        this.myCustomViewCallBack = myCustomViewCallBack;
    }

    public void setMyCustomViewScrollCallBack(MyCustomViewScrollCallBack myCustomViewScrollCallBack) {
        this.myCustomViewScrollCallBack = myCustomViewScrollCallBack;
    }

    public MyCustomView(Context context) {
        super(context);
        this.context = context;
        init(null);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(attrs);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        myCustomViewBinding = DataBindingUtil.inflate(inflater, R.layout.layout_my_custom_view, this, true);
        setColor(attrs);

        myCustomViewBinding.layoutError.buttonRetry.setOnClickListener(this);
        myCustomViewBinding.swipeHolder.setOnRefreshListener(this);

        myCustomViewBinding.layoutRecyclerView.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    if (myCustomViewScrollCallBack != null)
                        myCustomViewScrollCallBack.onScrollChange(ScrollDirection.UP);
                } else {
                    if (myCustomViewScrollCallBack != null)
                        myCustomViewScrollCallBack.onScrollChange(ScrollDirection.DOWN);
                }
            }
        });
    }

    private void setColor(AttributeSet attrs) {
        if (attrs == null) {
            return;
        }

        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.MyCustomView);
        titleColor = ta.getColor(R.styleable.MyCustomView_titleColor, Color.WHITE);
        subtitleColor = ta.getColor(R.styleable.MyCustomView_subtitleColor, Color.GRAY);
        retryButtonColor = ta.getColor(R.styleable.MyCustomView_retryButtonColor, Color.GRAY);
        retryButtonTextColor = ta.getColor(R.styleable.MyCustomView_retryButtonTextColor, Color.GRAY);
        iconTintColor = ta.getColor(R.styleable.MyCustomView_iconBackGroundColor, Color.GRAY);

        CharSequence title = ta.getString(R.styleable.MyCustomView_emptyTitle);
        if (title != null)
            setEmptyTitle(title.toString());

        myCustomViewBinding.layoutEmpty.emptyTextViewTitle.setTextColor(titleColor);
        myCustomViewBinding.layoutError.errorTextViewTitle.setTextColor(titleColor);
        myCustomViewBinding.layoutLoading.loadingTextViewTitle.setTextColor(titleColor);
        myCustomViewBinding.layoutEmpty.emptyTextViewTitle.setTextColor(subtitleColor);
        myCustomViewBinding.layoutError.errorTextViewSubTitle.setTextColor(subtitleColor);
        myCustomViewBinding.layoutLoading.loadingTextViewSubTitle.setTextColor(subtitleColor);
        myCustomViewBinding.layoutError.buttonRetry.setTextColor(retryButtonTextColor);

        myCustomViewBinding.layoutEmpty.emptyImageView.setColorFilter(iconTintColor, android.graphics.PorterDuff.Mode.MULTIPLY);
        myCustomViewBinding.layoutError.errorImageView.setColorFilter(iconTintColor, android.graphics.PorterDuff.Mode.MULTIPLY);


        Drawable background = myCustomViewBinding.layoutError.buttonRetry.getBackground();
        if (background instanceof ShapeDrawable) {
            ((ShapeDrawable) background).getPaint().setColor(retryButtonColor);
        } else if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(retryButtonColor);
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable) background).setColor(retryButtonColor);
        }
    }

    public RecyclerView getRecyclerView() {
        return myCustomViewBinding.layoutRecyclerView.recyclerView;
    }

    public void setSwipeRefreshStatus(boolean enable) {
        myCustomViewBinding.swipeHolder.setEnabled(enable);
    }

    private void setErrorTitle(@Nullable String title) {
        if (!PublicFunction.StringIsEmptyOrNull(title)) {
            myCustomViewBinding.layoutError.errorTextViewTitle.setText(title);
        }
    }

    private void setErrorSubTitle(@Nullable String subTitle) {
        if (!PublicFunction.StringIsEmptyOrNull(subTitle)) {
            myCustomViewBinding.layoutError.errorTextViewSubTitle.setText(subTitle);
        }
    }

    private void setEmptyTitle(@Nullable String title) {
        if (!PublicFunction.StringIsEmptyOrNull(title)) {
            myCustomViewBinding.layoutEmpty.emptyTextViewTitle.setText(title);
        }
    }

    private void setEmptySubTitle(@Nullable String subtitle) {
        if (!PublicFunction.StringIsEmptyOrNull(subtitle)) {
            myCustomViewBinding.layoutEmpty.emptyTextViewTitle.setText(subtitle);
        }
    }

    private void showLoading() {
        myCustomViewBinding.layoutLoading.loadingHolder.setVisibility(VISIBLE);
    }

    private void hideLoading() {
        myCustomViewBinding.layoutLoading.loadingHolder.setVisibility(INVISIBLE);
    }

    private void showLoadingBottom() {
        myCustomViewBinding.layoutLoadingBottom.loadingBottomHolder.setVisibility(VISIBLE);
    }

    private void hideLoadingBottom() {
        myCustomViewBinding.layoutLoadingBottom.loadingBottomHolder.setVisibility(INVISIBLE);
    }

    private void showEmptyView() {
        myCustomViewBinding.layoutEmpty.emptyHolder.setVisibility(VISIBLE);
    }

    private void hideEmptyView() {
        myCustomViewBinding.layoutEmpty.emptyHolder.setVisibility(INVISIBLE);
    }

    private void showRecyclerView() {
        myCustomViewBinding.layoutRecyclerView.recyclerView.setVisibility(VISIBLE);
    }

    private void hideRecyclerView() {
        myCustomViewBinding.layoutRecyclerView.recyclerView.setVisibility(INVISIBLE);
    }

    private void showSwipe() {
        myCustomViewBinding.swipeHolder.setRefreshing(true);
    }

    private void hideSwipe() {
        myCustomViewBinding.swipeHolder.setRefreshing(false);
    }

    private void showError() {
        myCustomViewBinding.layoutError.errorHolder.setVisibility(VISIBLE);
    }

    private void hideError() {
        myCustomViewBinding.layoutError.errorHolder.setVisibility(INVISIBLE);
    }

    public void hideErrorImageView() {
        myCustomViewBinding.layoutError.errorImageView.setVisibility(GONE);
    }

    public void hideEmptyImageView() {
        myCustomViewBinding.layoutError.errorImageView.setVisibility(GONE);
    }

    public void setStatus(ListStatus status) {
        switch (status) {
            case LOADING:
                hideLoading();
                hideLoadingBottom();
                hideEmptyView();
                hideRecyclerView();
                hideSwipe();
                hideError();
                invalidate(); // for redraw
                showLoading();
                break;

            case SUCCESS:
                hideLoading();
                hideLoadingBottom();
                hideEmptyView();
                hideRecyclerView();
                hideSwipe();
                hideError();
                invalidate(); // for redraw
                showRecyclerView();
                break;

            case FAILURE:
                hideLoading();
                hideLoadingBottom();
                hideEmptyView();
                hideRecyclerView();
                hideSwipe();
                hideError();
                invalidate(); // for redraw
                showError();
                break;

            case EMPTY:
                hideLoading();
                hideLoadingBottom();
                hideEmptyView();
                hideRecyclerView();
                hideSwipe();
                hideError();
                invalidate(); // for redraw
                showEmptyView();
                break;

            case UNDEFINE:
                hideLoading();
                hideLoadingBottom();
                hideEmptyView();
                hideRecyclerView();
                hideSwipe();
                hideError();
                invalidate(); // for redraw
                showError();
                break;

            case LOADING_BOTTOM:
                hideLoading();
                hideLoadingBottom();
                hideEmptyView();
                // hideRecyclerView();
                hideSwipe();
                hideError();
                invalidate(); // for redraw
                showLoadingBottom();
                break;

            default:
                hideLoading();
                hideLoadingBottom();
                hideEmptyView();
                hideRecyclerView();
                hideSwipe();
                hideError();
                invalidate(); // for redraw
                showError();
                break;
        }
    }

    public void setStatus(ListStatus status, @Nullable String subTitle) {
        switch (status) {
            case LOADING:
                hideLoading();
                hideLoadingBottom();
                hideEmptyView();
                hideRecyclerView();
                hideSwipe();
                hideError();
                invalidate(); // for redraw
                showLoading();
                break;

            case SUCCESS:
                hideLoading();
                hideLoadingBottom();
                hideEmptyView();
                hideRecyclerView();
                hideSwipe();
                hideError();
                invalidate(); // for redraw
                showRecyclerView();
                break;

            case FAILURE:
                hideLoading();
                hideLoadingBottom();
                hideEmptyView();
                hideRecyclerView();
                hideSwipe();
                hideError();
                setErrorSubTitle(subTitle);
                invalidate(); // for redraw
                showError();
                break;

            case EMPTY:
                hideLoading();
                hideLoadingBottom();
                hideEmptyView();
                hideRecyclerView();
                hideSwipe();
                hideError();
                setEmptySubTitle(subTitle);
                invalidate(); // for redraw
                showEmptyView();
                break;

            case UNDEFINE:
                hideLoading();
                hideLoadingBottom();
                hideEmptyView();
                hideRecyclerView();
                hideSwipe();
                hideError();
                invalidate(); // for redraw
                showError();
                break;

            case LOADING_BOTTOM:
                hideLoading();
                hideLoadingBottom();
                hideEmptyView();
                // hideRecyclerView();
                hideSwipe();
                hideError();
                invalidate(); // for redraw
                showLoadingBottom();
                break;

            default:
                hideLoading();
                hideLoadingBottom();
                hideEmptyView();
                hideRecyclerView();
                hideSwipe();
                hideError();
                invalidate(); // for redraw
                showError();
                break;
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_retry) {
            if (myCustomViewCallBack != null)
                myCustomViewCallBack.onRetryClicked();
        }
    }

    @Override
    public void onRefresh() {
        if (myCustomViewCallBack != null) {
            myCustomViewCallBack.onRefresh(1);
        }
    }
}
