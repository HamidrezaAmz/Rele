package com.vasl.Library.Android;


import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vasl.recyclerlibrary.MyCustomView;
import com.vasl.recyclerlibrary.globalEnums.ListStatus;
import com.vasl.recyclerlibrary.globalInterfaces.MyCustomAdapterCallBack;
import com.vasl.recyclerlibrary.globalInterfaces.MyCustomViewCallBack;
import com.vasl.recyclerlibrary.globalObjects.RowModel;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements MyCustomViewCallBack, MyCustomAdapterCallBack {

    private int index = 1;

    private int start_page = 1;

    private int curr_page = 1;

    private TextView textView;

    private MyCustomView myCustomView;

    private RecyclerVerticalAdapter adapter;

    private ArrayList<RowModel> rowModels = new ArrayList<>();

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_blank, container, false);

        myCustomView = inflate.findViewById(R.id.myCustomView);

        textView = inflate.findViewById(R.id.index);

        RecyclerView recyclerView = myCustomView.getRecyclerView();

        myCustomView.setMyCustomViewCallBack(this);

        // myCustomView.setMyCustomViewScrollCallBack(this);

        myCustomView.setStatus(ListStatus.LOADING);

        adapter = new RecyclerVerticalAdapter(getActivity(), rowModels);

        adapter.setMyCustomAdapterCallBack(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));


        recyclerView.setAdapter(adapter);

        getList(start_page);

        return inflate;
    }

    private void getList(int page) {

        textView.setText("PAGE : " + page);

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
                myCustomView.setSwipeRefreshStatus(false);
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
    public void richToEnd() {
        curr_page = curr_page + 1;
        getList(curr_page);
    }
}
