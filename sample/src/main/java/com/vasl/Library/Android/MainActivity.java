package com.vasl.Library.Android;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vasl.recyclerlibrary.MyCustomView;
import com.vasl.recyclerlibrary.globalEnums.ListStatus;
import com.vasl.recyclerlibrary.globalEnums.ScrollDirection;
import com.vasl.recyclerlibrary.globalInterfaces.MyCustomAdapterCallBack;
import com.vasl.recyclerlibrary.globalInterfaces.MyCustomViewCallBack;
import com.vasl.recyclerlibrary.globalInterfaces.MyCustomViewScrollCallBack;
import com.vasl.recyclerlibrary.globalObjects.RowModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyCustomViewCallBack, MyCustomViewScrollCallBack, MyCustomAdapterCallBack {

    private static final String TAG = "MainActivity";

    private int index = 1;

    private int start_page = 1;

    private int curr_page = 1;

    private MyCustomView myCustomView;

    private RecyclerVerticalAdapter adapter;

    private ArrayList<RowModel> rowModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        myCustomView = findViewById(R.id.myCustomView);

        RecyclerView recyclerView = myCustomView.getRecyclerView();

        myCustomView.setMyCustomViewCallBack(this);

        myCustomView.setStatus(ListStatus.LOADING);

        adapter = new RecyclerVerticalAdapter(MainActivity.this, rowModels);

        adapter.setMyCustomAdapterCallBack(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        myCustomView.setMyCustomViewScrollCallBack(this);

        recyclerView.setAdapter(adapter);

        getList(start_page);

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        LocaleHelper.onAttach(newBase);
    }

    private void getList(int page) {

        if (page == 1)
            myCustomView.setStatus(ListStatus.LOADING);
        else
            myCustomView.setStatus(ListStatus.LOADING_BOTTOM);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                rowModels.add(new RowModel("https://dkstatics-public.digikala.com/digikala-products/4308693.jpg?x-oss-process=image/resize,m_lfit,h_600,w_600/quality,q_80", "" + index++));
                rowModels.add(new RowModel("https://dkstatics-public.digikala.com/digikala-products/4308693.jpg?x-oss-process=image/resize,m_lfit,h_600,w_600/quality,q_80", "" + index++));
                rowModels.add(new RowModel("https://dkstatics-public.digikala.com/digikala-products/4308693.jpg?x-oss-process=image/resize,m_lfit,h_600,w_600/quality,q_80", "" + index++));
                rowModels.add(new RowModel("https://dkstatics-public.digikala.com/digikala-products/4308693.jpg?x-oss-process=image/resize,m_lfit,h_600,w_600/quality,q_80", "" + index++));
                rowModels.add(new RowModel("https://dkstatics-public.digikala.com/digikala-products/4308693.jpg?x-oss-process=image/resize,m_lfit,h_600,w_600/quality,q_80", "" + index++));
                rowModels.add(new RowModel("https://dkstatics-public.digikala.com/digikala-products/4308693.jpg?x-oss-process=image/resize,m_lfit,h_600,w_600/quality,q_80", "" + index++));
                rowModels.add(new RowModel("https://dkstatics-public.digikala.com/digikala-products/4308693.jpg?x-oss-process=image/resize,m_lfit,h_600,w_600/quality,q_80", "" + index++));
                rowModels.add(new RowModel("https://dkstatics-public.digikala.com/digikala-products/4308693.jpg?x-oss-process=image/resize,m_lfit,h_600,w_600/quality,q_80", "" + index++));
                rowModels.add(new RowModel("https://dkstatics-public.digikala.com/digikala-products/4308693.jpg?x-oss-process=image/resize,m_lfit,h_600,w_600/quality,q_80", "" + index++));
                rowModels.add(new RowModel("https://dkstatics-public.digikala.com/digikala-products/4308693.jpg?x-oss-process=image/resize,m_lfit,h_600,w_600/quality,q_80", "" + index++));

                adapter.notifyDataSetChanged();
                myCustomView.setStatus(ListStatus.SUCCESS);
                myCustomView.setSwipeRefreshStatus(true);
            }
        }, 1000);
    }

    @Override
    public void onRetryClicked() {
        getList(start_page);
    }

    @Override
    public void onRefresh(int page) {
        getList(start_page);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_load:
                myCustomView.setStatus(ListStatus.LOADING);
                return true;
            case R.id.action_success:
                myCustomView.setStatus(ListStatus.SUCCESS);
                return true;
            case R.id.action_failure:
                myCustomView.setStatus(ListStatus.FAILURE);
                return true;
            case R.id.action_empty:
                myCustomView.setStatus(ListStatus.EMPTY);
                return true;
        }
        return false;
    }

    @Override
    public void onScrollChange(ScrollDirection scrollDirection) {

    }

    @Override
    public void richToEnd() {
        Toast.makeText(this, "richToEnd()", Toast.LENGTH_SHORT).show();
    }
}
