package com.Vasl.recyclerlibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.Vasl.recyclerlibrary.globalEnums.ListStatuse;
import com.Vasl.recyclerlibrary.globalInterfaces.MyCustomViewCallBack;
import com.Vasl.recyclerlibrary.utils.PublicFunction;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class MyCustomView extends RelativeLayout
        implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    Context context;

    // layout_loading
    LinearLayout loading;

    // recycler view
    RecyclerView recyclerView;

    // empty view
    LinearLayout emptyHolder;
    AppCompatTextView emptyTextViewTitle, emptyTextViewSubTitle;

    // error view
    LinearLayout errorHolder;
    AppCompatTextView errorTextViewTitle, errorTextViewSubTitle;
    Button buttonRetry;

    // swipe
    SwipeRefreshLayout swipeRefreshLayout;

    // interface
    MyCustomViewCallBack myCustomViewCallBack;

    public void setMyCustomViewCallBack(MyCustomViewCallBack myCustomViewCallBack) {
        this.myCustomViewCallBack = myCustomViewCallBack;
    }

    public MyCustomView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    public void init() {

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.layout_my_custom_view, this);

        buttonRetry = view.findViewById(R.id.button_retry);
        buttonRetry.setOnClickListener(this);

        // loading-view
        loading = view.findViewById(R.id.loadingHolder);

        // recycler-view
        recyclerView = view.findViewById(R.id.recyclerView);

        //  swipe-view
        swipeRefreshLayout = view.findViewById(R.id.swipeHolder);
        swipeRefreshLayout.setOnRefreshListener(this);

        // empty-view
        emptyHolder = view.findViewById(R.id.emptyHolder);
        emptyTextViewTitle = view.findViewById(R.id.emptyTextViewTitle);
        emptyTextViewSubTitle = view.findViewById(R.id.emptyTextViewSubTitle);

        //error-view
        errorHolder = view.findViewById(R.id.errorHolder);
        errorTextViewTitle = view.findViewById(R.id.errorTextViewTitle);
        errorTextViewSubTitle = view.findViewById(R.id.errorTextViewSubTitle);

    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    private void showLoading() {
        loading.setVisibility(VISIBLE);
    }

    private void setErrorTitle(@Nullable String title) {
        if (!PublicFunction.StringIsEmptyOrNull(title)) {
            errorTextViewTitle.setText(title);
        }
    }

    private void setErrorSubTitle(@Nullable String subTitle) {
        if (!PublicFunction.StringIsEmptyOrNull(subTitle)) {
            errorTextViewSubTitle.setText(subTitle);
        }
    }

    private void setEmptyTitle(@Nullable String title) {
        if (!PublicFunction.StringIsEmptyOrNull(title)) {
            emptyTextViewTitle.setText(title);
        }
    }

    private void setEmptySubTitle(@Nullable String subtitle) {
        if (!PublicFunction.StringIsEmptyOrNull(subtitle)) {
            emptyTextViewSubTitle.setText(subtitle);
        }
    }

    private void hideLoading() {
        loading.setVisibility(GONE);
    }

    private void showEmptyView() {
        emptyHolder.setVisibility(VISIBLE);
    }

    private void hideEmptyView() {
        emptyHolder.setVisibility(GONE);
    }

    private void showRecyclerView() {
        recyclerView.setVisibility(VISIBLE);
    }

    private void hideRecyclerView() {
        recyclerView.setVisibility(GONE);
    }

    private void hideSwipe() {
        swipeRefreshLayout.setRefreshing(false);
    }

    private void showSwipe() {
        swipeRefreshLayout.setRefreshing(true);
    }

    private void showError() {
        errorHolder.setVisibility(VISIBLE);
    }

    private void hideError() {
        errorHolder.setVisibility(GONE);
    }

    public void setStatus(ListStatuse status) {
        switch (status) {
            case LOADING:
                showLoading();
                hideEmptyView();
                hideRecyclerView();
                hideSwipe();
                hideError();
                break;
            case SUCCESS:
                hideLoading();
                hideEmptyView();
                showRecyclerView();
                hideSwipe();
                hideError();
                break;
            case FAILURE:
                hideLoading();
                hideEmptyView();
                hideRecyclerView();
                hideSwipe();
                setErrorTitle(null);
                showError();
                break;
            case EMPTY:
                hideLoading();
                hideRecyclerView();
                hideSwipe();
                hideError();
                setEmptyTitle(null);
                showEmptyView();
                break;
            case UNDEFINE:
                hideLoading();
                hideEmptyView();
                hideRecyclerView();
                hideSwipe();
                showError();
                break;
            default:
                hideLoading();
                hideEmptyView();
                hideRecyclerView();
                hideSwipe();
                showError();
                break;
        }
    }

    public void setStatus(ListStatuse status, @Nullable String title) {
        switch (status) {
            case LOADING:
                showLoading();
                hideEmptyView();
                hideRecyclerView();
                hideSwipe();
                hideError();
                break;
            case SUCCESS:
                hideLoading();
                hideEmptyView();
                showRecyclerView();
                hideSwipe();
                hideError();
                break;
            case FAILURE:
                hideLoading();
                hideEmptyView();
                hideRecyclerView();
                hideSwipe();
                setErrorTitle(title);
                showError();
                break;
            case EMPTY:
                hideLoading();
                hideRecyclerView();
                hideSwipe();
                hideError();
                setEmptyTitle(title);
                showEmptyView();
                break;
            case UNDEFINE:
                hideLoading();
                hideEmptyView();
                hideRecyclerView();
                hideSwipe();
                showError();
                break;
            default:
                hideLoading();
                hideEmptyView();
                hideRecyclerView();
                hideSwipe();
                showError();
                break;
        }
    }

    @Override
    public void onRefresh() {
        if (myCustomViewCallBack != null) {
            myCustomViewCallBack.onRefresh(1);
        }

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_retry) {
            if (myCustomViewCallBack != null)
                myCustomViewCallBack.onRetryClicked();
        }
    }
}
