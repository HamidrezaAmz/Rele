package com.vasl.recyclerlibrary.baseClasses;

import com.vasl.recyclerlibrary.globalInterfaces.MyCustomAdapterCallBack;
import com.vasl.recyclerlibrary.utils.LogHelper;
import com.vasl.recyclerlibrary.utils.PublicValue;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseRecyclerAdapterItemBaseScroll extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    int lastPosition = -1;

    private LogHelper logHelper = new LogHelper(BaseRecyclerAdapterItemBaseScroll.class);

    private MyCustomAdapterCallBack myCustomAdapterCallBack;

    public void setMyCustomAdapterCallBack(MyCustomAdapterCallBack myCustomAdapterCallBack) {
        this.myCustomAdapterCallBack = myCustomAdapterCallBack;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        checkScrollChanged(getItemCount(), position);
    }

    protected int checkScrollChanged(int adapterSize, int position) {
        try {
            if (lastPosition >= position) {
                return lastPosition;
            }
            lastPosition = position;
            if (adapterSize - position <= 5) {
                if (myCustomAdapterCallBack != null) {
                    myCustomAdapterCallBack.richToEnd();
                }
            }
            return lastPosition;
        } catch (Exception ex) {
            logHelper.e("checkScrollChanged() called with: Exception = " + ex.getMessage() + " - Position = [" + position + "]");
            return lastPosition;
        }
    }

}
