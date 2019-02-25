package com.vasl.Library.Android;


import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vasl.recyclerlibrary.MyCustomView;
import com.vasl.recyclerlibrary.globalEnums.ListStatus;
import com.vasl.recyclerlibrary.globalEnums.ScrollDirection;
import com.vasl.recyclerlibrary.globalInterfaces.MyCustomAdapterCallBack;
import com.vasl.recyclerlibrary.globalInterfaces.MyCustomViewCallBack;
import com.vasl.recyclerlibrary.globalInterfaces.MyCustomViewScrollCallBack;
import com.vasl.recyclerlibrary.globalObjects.RowModel;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements MyCustomViewCallBack, MyCustomAdapterCallBack, MyCustomViewScrollCallBack {

    private int index = 1;

    private MyCustomView myCustomView;

    private RecyclerVerticalAdapter adapter;

    private ArrayList<RowModel> rowModels = new ArrayList<>();

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_blank, container, false);

        myCustomView = inflate.findViewById(R.id.myCustomView);

        RecyclerView recyclerView = myCustomView.getRecyclerView();

        myCustomView.setMyCustomViewCallBack(this);

        myCustomView.setStatus(ListStatus.LOADING);

        adapter = new RecyclerVerticalAdapter(getContext(), rowModels);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        adapter.setMyCustomAdapterCallBack(this);

        myCustomView.setMyCustomViewScrollCallBack(this);

        recyclerView.setAdapter(adapter);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                myList();
            }
        }, 2000);

        return inflate;
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
        myCustomView.setSwipeRefreshStatus(false);
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
    public void onScrollChange(ScrollDirection scrollDirection) {

    }
}
