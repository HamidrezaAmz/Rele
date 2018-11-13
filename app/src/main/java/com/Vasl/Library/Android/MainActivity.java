package com.Vasl.Library.Android;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.Vasl.recyclerlibrary.MyCustomView;
import com.Vasl.recyclerlibrary.globalEnums.ListStatuse;
import com.Vasl.recyclerlibrary.globalInterfaces.MyCustomAdapterCallBack;
import com.Vasl.recyclerlibrary.globalInterfaces.MyCustomViewCallBack;
import com.Vasl.recyclerlibrary.globalObjects.RowModel;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements MyCustomViewCallBack {

    MyCustomView myCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        myCustomView = findViewById(R.id.myCustomView);

        myCustomView.setMyCustomViewCallBack(this);

        myCustomView.setStatus(ListStatuse.LOADING, null);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                myList();
            }
        }, 2000);

    }

    private void myList() {

        myCustomView.setStatus(ListStatuse.LOADING, null);

        RecyclerView recyclerView = myCustomView.getRecyclerView();


        ArrayList<RowModel> rowModels = new ArrayList<>();
        rowModels.add(new RowModel("https://dkstatics-public.digikala.com/digikala-adservice-banners/2880.jpg", "1"));
        rowModels.add(new RowModel("https://dkstatics-public.digikala.com/digikala-adservice-banners/2880.jpg", "2"));
        rowModels.add(new RowModel("https://dkstatics-public.digikala.com/digikala-adservice-banners/2880.jpg", "3"));
        rowModels.add(new RowModel("https://dkstatics-public.digikala.com/digikala-adservice-banners/2880.jpg", "4"));
        rowModels.add(new RowModel("https://dkstatics-public.digikala.com/digikala-adservice-banners/2880.jpg", "5"));
        rowModels.add(new RowModel("https://dkstatics-public.digikala.com/digikala-adservice-banners/2880.jpg", "6"));
        rowModels.add(new RowModel("https://dkstatics-public.digikala.com/digikala-adservice-banners/2880.jpg", "7"));

        RecyclerVerticalAdapter adapter = new RecyclerVerticalAdapter(MainActivity.this, rowModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        adapter.setMyCustomAdapterCallBack(new MyCustomAdapterCallBack() {
            @Override
            public void verticalScrollRichToEnd() {
                Toast.makeText(MainActivity.this, "verticalScrollRichToEnd", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void horizontalScrollRichToEnd() {
                Toast.makeText(MainActivity.this, "horizontalScrollRichToEnd", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);

        myCustomView.setStatus(ListStatuse.FAILURE, null);
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
    public void onEndOfList() {
        Toast.makeText(this, "onEndList", Toast.LENGTH_SHORT).show();
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
                myCustomView.setStatus(ListStatuse.LOADING, null);
                return true;
            case R.id.action_success:
                myCustomView.setStatus(ListStatuse.SUCCESS, null);
                return true;
            case R.id.action_failure:
                myCustomView.setStatus(ListStatuse.FAILURE, "hellooo");
                return true;
            case R.id.action_empty:
                myCustomView.setStatus(ListStatuse.EMPTY, "no item");
                return true;
        }
        return false;
    }
}
