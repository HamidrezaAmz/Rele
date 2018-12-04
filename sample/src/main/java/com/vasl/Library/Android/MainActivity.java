package com.vasl.Library.Android;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.vasl.recyclerlibrary.MyCustomView;
import com.vasl.recyclerlibrary.globalEnums.ListStatus;
import com.vasl.recyclerlibrary.globalInterfaces.MyCustomAdapterCallBack;
import com.vasl.recyclerlibrary.globalInterfaces.MyCustomViewCallBack;
import com.vasl.recyclerlibrary.globalObjects.RowModel;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements MyCustomViewCallBack, MyCustomAdapterCallBack {

    private int index = 1;

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

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        adapter.setMyCustomAdapterCallBack(this);

        recyclerView.setAdapter(adapter);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                myList();
            }
        }, 2000);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        LocaleHelper.onAttach(newBase);
    }

    private void myList() {

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
    }

    @Override
    public void onRetryClicked() {
        myList();
    }

    @Override
    public void onRefresh(int page) {
        myList();
    }

    @Override
    public void richToEnd() {
        myCustomView.setStatus(ListStatus.LOADING_BOTTOM);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                myList();
                myCustomView.setStatus(ListStatus.SUCCESS);
            }
        }, 2000);
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

}
