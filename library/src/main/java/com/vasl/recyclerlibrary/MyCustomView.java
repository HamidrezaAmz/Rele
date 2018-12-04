package com.vasl.recyclerlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.tuyenmonkey.mkloader.MKLoader;
import com.vasl.recyclerlibrary.globalEnums.ListStatus;
import com.vasl.recyclerlibrary.globalInterfaces.MyCustomViewCallBack;
import com.vasl.recyclerlibrary.utils.PublicFunction;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class MyCustomView extends RelativeLayout
        implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    private Context context;

    int titleColor;
    int subtitleColor;

    // layout_loading
    private LinearLayout loadingHolder;
    private AppCompatTextView loadingTextViewTitle;
    private AppCompatTextView loadingTextViewSubTitle;
    private MKLoader mkLoader;

    // layout_loading_bottom
    private LinearLayout loadingBottomHolder;
    private AppCompatTextView loadingBottomTextViewTitle;

    // recycler view
    private RecyclerView recyclerView;

    // empty view
    private LinearLayout emptyHolder;
    private AppCompatTextView emptyTextViewTitle, emptyTextViewSubTitle;

    // error view
    private LinearLayout errorHolder;
    private AppCompatTextView errorTextViewTitle, errorTextViewSubTitle;
    private Button buttonRetry;

    // swipe
    private SwipeRefreshLayout swipeRefreshLayout;

    // interface
    private MyCustomViewCallBack myCustomViewCallBack;

    public void setMyCustomViewCallBack(MyCustomViewCallBack myCustomViewCallBack) {
        this.myCustomViewCallBack = myCustomViewCallBack;
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

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.layout_my_custom_view, this);

        buttonRetry = view.findViewById(R.id.button_retry);
        buttonRetry.setOnClickListener(this);

        // loadingHolder-view
        loadingHolder = view.findViewById(R.id.loadingHolder);
        loadingTextViewTitle = view.findViewById(R.id.loadingTextViewTitle);
        loadingTextViewSubTitle = view.findViewById(R.id.loadingTextViewSubTitle);
        mkLoader = view.findViewById(R.id.mkLoader);

        // loadingBottomHolder-view
        loadingBottomHolder = view.findViewById(R.id.loadingBottomHolder);

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

        //color attr set
        setColor(attrs);

    }

    private void setColor(AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.MyCustomView);
        titleColor = ta.getColor(R.styleable.MyCustomView_titleColor, Color.WHITE);
        subtitleColor = ta.getColor(R.styleable.MyCustomView_subtitleColor, Color.GRAY);
        emptyTextViewTitle.setTextColor(titleColor);
        errorTextViewTitle.setTextColor(titleColor);
        loadingTextViewTitle.setTextColor(titleColor);
        emptyTextViewSubTitle.setTextColor(subtitleColor);
        errorTextViewSubTitle.setTextColor(subtitleColor);
        loadingTextViewSubTitle.setTextColor(subtitleColor);
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
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

    private void showLoading() {
        loadingHolder.setVisibility(VISIBLE);
    }

    private void hideLoading() {
        loadingHolder.setVisibility(INVISIBLE);
    }

    private void showLoadingBottom() {
        loadingBottomHolder.setVisibility(VISIBLE);
    }

    private void hideLoadingBottom() {
        loadingBottomHolder.setVisibility(INVISIBLE);
    }

    private void showEmptyView() {
        emptyHolder.setVisibility(VISIBLE);
    }

    private void hideEmptyView() {
        emptyHolder.setVisibility(INVISIBLE);
    }

    private void showRecyclerView() {
        recyclerView.setVisibility(VISIBLE);
    }

    private void hideRecyclerView() {
        recyclerView.setVisibility(INVISIBLE);
    }

    private void showSwipe() {
        swipeRefreshLayout.setRefreshing(true);
    }

    private void hideSwipe() {
        swipeRefreshLayout.setRefreshing(false);
    }

    private void showError() {
        errorHolder.setVisibility(VISIBLE);
    }

    private void hideError() {
        errorHolder.setVisibility(INVISIBLE);
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

    public void setStatus(ListStatus status, @Nullable String title) {
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
